import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created by Daniel Bojic
 * Date: 2020-11-25
 * Time: 15:40
 * Project: Quizkampen
 * Copyright: MIT
 */
public class ClientToSend implements Serializable {

    static Player player1 = new Player();
    static Player player2 = new Player();
    static boolean waitForInput = true;
    static Socket socket;
    static HomePage_waiting homePageWaitForConnection = new HomePage_waiting();
    static HomePage_play homePageConnectedPlay = new HomePage_play();
    static GamePage_waiting gamePage_Waiting = new GamePage_waiting();
    static int maxAmountOfRounds = checkPropertiesForMaxRound();
    static boolean gameIsPlaying = true;
    static boolean neverEndingStory = true;


    public static int checkPropertiesForMaxRound() {
        Properties propertiesValue = new Properties();
        try {
            propertiesValue.load(new FileInputStream("src/RoundQuestions.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String stringMaxRounds = propertiesValue.getProperty("numberOfRounds", "2");

        return Integer.parseInt(stringMaxRounds);

    }

    public static void sleepThisProgram() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void logIn() throws InterruptedException {

        while (waitForInput) {

            LoginGUI logInScreen = new LoginGUI();
            logInScreen.showWindow();

            while (player1.getName() == null) {

                String name = logInScreen.findPlayerAndReturn();
                player1.setName(name);
                sleepThisProgram();

            }

            if (player1.getName() != null) {

                waitForInput = false;

            }

        }
    }

    public static void sendObject() throws IOException {
        new ObjectOutputStream(socket.getOutputStream()).writeObject(player1);
    }

    public static void receiveObject() throws IOException, ClassNotFoundException {
        player2 = (Player) new ObjectInputStream(socket.getInputStream()).readObject();
    }

    public static void transferObject() throws IOException, ClassNotFoundException {
        sendObject();
        receiveObject();
    }

    public static void assignPlayer() {

        if (player1.getPLAYER() == 0) {

            if (player2.getPLAYER() == 2) {

                player1.setPLAYER(1);

            } else {

                player1.setPLAYER(2);

            }
        }
    }

    public static void closeWaitingWindowWhenConnected() {
        if (player2.isConnected()) {

            homePageWaitForConnection.closeWindow();
        }
    }

    public static void openPlayWindowWhenConnected() throws InterruptedException {

        homePageConnectedPlay.showWindow(player1);


        waitForInput = false;
        while (!waitForInput) {

            waitForInput = homePageConnectedPlay.findClickPlay();
            sleepThisProgram();

        }

    }

    public static void resetBothPlayersWhenNewGame() {

        player1 = player1.clearAllFromPlayer(player1);
        player2 = player2.clearAllFromPlayer(player2);

    }

    public static void playRoundNotChoosenCategory() throws IOException, InterruptedException, ClassNotFoundException {
        List<Boolean> listWithPlayersPlayedTurn = player2.getAnswers();

        List<Boolean> listWithoutLastPlayersPlayedTurn = player2.getAnswers();

        player2.changeList(player2.removeAnswersFromList(listWithoutLastPlayersPlayedTurn, (player2.getMaxQuestion()), player2.getRound()));

        startRound();

        player2.changeList(listWithPlayersPlayedTurn);

        player1.addToList(player2.getRoundCategories().get(player1.getRound() - 1));

        player1.setClicked(false);

        playUntilMaxQuestionIsReachedForRoundNotChosenCategory();

        transferObject();
    }

    public static void playUntilMaxQuestionIsReachedForRoundChosenCategory() throws InterruptedException {
        for (int i = 0; i < player1.getMaxQuestion(); i++) {

            QuestionPage questionPageWithChosenCategory = new QuestionPage(player1);

            while (!player1.isClicked()) {
                player1 = questionPageWithChosenCategory.findClickPlay();
                sleepThisProgram();

            }

            player1.setClicked(false);
            player1 = questionPageWithChosenCategory.addPoints(player1);
            player1 = questionPageWithChosenCategory.lastAnswerCheck(player1);

        }

    }

    public static void playUntilMaxQuestionIsReachedForRoundNotChosenCategory() throws InterruptedException {
        for (int i = 0; i < player1.getMaxQuestion(); i++) {

            QuestionPage_NotChoseCat questionPageWithoutChoosingCategory = new QuestionPage_NotChoseCat(player1, player2);

            while (!player1.isClicked()) {

                player1 = questionPageWithoutChoosingCategory.findClickPlay();
                sleepThisProgram();

            }

            player1.setClicked(false);
            player1 = questionPageWithoutChoosingCategory.addPoints(player1);
            player1 = questionPageWithoutChoosingCategory.lastAnswerCheck(player1);

        }

    }

    public static void chooseCategory() throws InterruptedException {
        CategoryPage chooseCurrentRoundCategory = new CategoryPage(player1);

        waitForInput = false;

        while (!waitForInput) {

            waitForInput = chooseCurrentRoundCategory.findClickPlay();
            sleepThisProgram();

        }

        player1 = chooseCurrentRoundCategory.addCategoryInputToPlayer();

        player1.setClicked(false);

    }

    public static void startRound() throws InterruptedException{
        GamePage_play gamePage_play = new GamePage_play(player1, player2);

        player1.setClicked(false);

        while (!player1.isClicked()) {

            player1 = gamePage_play.findClickPlay();
            sleepThisProgram();

        }

        player1.setRound(player1.getRound() + 1);
    }

    public static void player1PlayChooseCategoryRound() throws InterruptedException, IOException, ClassNotFoundException {

        if (player1.getPLAYER() == 1) {

            startRound();

            chooseCategory();

            playUntilMaxQuestionIsReachedForRoundChosenCategory();

            transferObject();


        } else if (player1.getPLAYER() == 2) {

            gamePageWaitingForOtherPlayer();

            findQuestionsFromLastPlayedPlayer();

        }
    }

    /**
     * Metoden används för att hitta tidigare spelarens frågor som har valt kategori samt överföra frågorna mellan spelarna.
     * För att båda spelarna ska ha samma frågor.
     */
    public static void findQuestionsFromLastPlayedPlayer() {

        int addQuestionFromLastRound = (player2.getRound() * player1.getMaxQuestion()) - player1.getMaxQuestion();

        for (int i = 0; i < player1.getMaxQuestion(); i++) {

            player1.addQuestionBetweenPlayers(player2.getQuestionToPassBetweenPlayers().get(addQuestionFromLastRound));
            addQuestionFromLastRound++;

        }
    }

    public static void player2PlayNotChooseCategoryRound() throws IOException, ClassNotFoundException, InterruptedException {
        if (player1.getPLAYER() == 1) {

            gamePageWaitingForOtherPlayer();

        } else if (player1.getPLAYER() == 2) {

            playRoundNotChoosenCategory();
        }
    }

    public static void gamePageWaitingForOtherPlayer() throws IOException, ClassNotFoundException {
        gamePage_Waiting.showWindow(player1, player2);

        transferObject();

        gamePage_Waiting.closeWindow();

    }

    public static void player2PlayChooseCategoryRound() throws IOException, ClassNotFoundException, InterruptedException {
        if (player1.getPLAYER() == 1) {

            gamePageWaitingForOtherPlayer();

            findQuestionsFromLastPlayedPlayer();

        } else if (player1.getPLAYER() == 2) {

            startRound();

            chooseCategory();

            playUntilMaxQuestionIsReachedForRoundChosenCategory();

            transferObject();

        }
    }

    public static void player1PlayNotChooseCategory() throws IOException, InterruptedException, ClassNotFoundException {
        if (player1.getPLAYER() == 1) {

            playRoundNotChoosenCategory();

        } else if (player1.getPLAYER() == 2) {

            gamePageWaitingForOtherPlayer();

        }
    }

    public static void winLoseWindow() {
        if (player1.getRound() == maxAmountOfRounds && player2.getRound() == maxAmountOfRounds) {
            if (player1.getPLAYER() == 1) {

                showResult();

            } else if (player1.getPLAYER() == 2) {

                showResult();
            }
        }
    }

    public static void resultWindowWithPlayAgainOption() throws IOException, ClassNotFoundException {
        if (player1.getPLAYER() == 1) {

            scoreboard();


        } else if (player1.getPLAYER() == 2) {

            scoreboard();

        }

    }

    public static void playAgainOrClose() throws IOException, ClassNotFoundException {

        if (player1.getCloseGameOption() == 1 && player2.getCloseGameOption() == 1) {

            gameIsPlaying = true;

        } else if (player1.getCloseGameOption() == 2 || player2.getCloseGameOption() == 2) {

            EndingGamePage endingGamePage = new EndingGamePage(player1);

            waitForInput = false;
            while (!waitForInput) {
                waitForInput = endingGamePage.findClickAndPlay();

            }

            player1.setFinished(true);
            player1.setConnected(false);
            gameIsPlaying = false;
            neverEndingStory = false;
            transferObject();

        }

    }

    public static void showResult() {
        ResultPage resultPage = new ResultPage(player1, player2);

        waitForInput = false;
        while (!waitForInput) {
            waitForInput = resultPage.findClickAndPlay();

        }
        resultPage.dispose();
    }

    public static void scoreboard() throws IOException, ClassNotFoundException {
        GamePage_result scoreboardWindow = new GamePage_result(player1, player2);

        player1.setClicked(false);
        waitForInput = false;
        player1.setCloseGameOption(0);

        while (!waitForInput) {

            player1 = scoreboardWindow.findClickPlay();
            if (player1.getCloseGameOption() == 1 || player1.getCloseGameOption() == 2) {
                waitForInput = true;
            }
        }

        transferObject();

        scoreboardWindow.dispose();
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {


        InetAddress iadr = InetAddress.getLocalHost();

        logIn();

        homePageWaitForConnection.showWindow(player1);

        socket = new Socket(iadr, 7777);

        try {

            while (!player1.getFinished() && !player2.getFinished()) {

                transferObject();

                assignPlayer();

                closeWaitingWindowWhenConnected();

                openPlayWindowWhenConnected();


                while (neverEndingStory) {

                    resetBothPlayersWhenNewGame();

                    while (gameIsPlaying) {

                        player1PlayChooseCategoryRound();

                        player2PlayNotChooseCategoryRound();


                        //Check if max round is reached
                        if (player1.getRound() == maxAmountOfRounds && player2.getRound() == maxAmountOfRounds) {
                            gameIsPlaying = false;
                            break;
                        }

                        player2PlayChooseCategoryRound();

                        player1PlayNotChooseCategory();

                        //Check if max round is reached
                        if (player1.getRound() == maxAmountOfRounds && player2.getRound() == maxAmountOfRounds) {
                            gameIsPlaying = false;
                            break;
                        }

                        //Loop game until max round is reached
                    }
                    winLoseWindow();

                    resultWindowWithPlayAgainOption();

                    playAgainOrClose();


                }

            }

            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();


        }
    }


}



