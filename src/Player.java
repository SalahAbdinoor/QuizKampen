import QuestionsHandler.Questions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel Bojic
 * Date: 2020-11-12
 * Time: 19:54
 * Project: Quizkampen
 * Copyright: MIT
 */
public class Player implements Serializable {


    //Konstruktor
    Player(){
    }

    //UNIKT ID FÖR ATT SKICKA ÖVER OBJEKT
    public static final long serialVersionUID = 1L;

    //Spelarens namn
    private String name = null;

    //Totala poäng
    private int points = 0;

    //Vilken rond man befinner sig på
    private int round = 0;

    //Max antal ronder
    private int maxRound;

    //Max antal frågor
    private int maxQuestion;

    //Fråga man befinner sig på för rundan. Återställer sig efter varje runda.
    private int question = 0;

    //Ändras till true när man har spelat alla ronder.
    private boolean finished = false;

    //Kollar om man vill spela vidare eller inte 1 = spela igen, 2 = stäng av
    private int closeGameOption = 0;

    //Socket connection
    boolean connected = false;

    //Om man har klickat på en knapp i GUI.
    boolean clicked = false;

    //Fångar upp om man har fått rätt eller fel i questionPage
    boolean clickedRightAnswer = false;

    //Om man är spelare 1 eller spelare 2
    private int PLAYER;

    //Sparar varje fråga man har fått så man inte får samma fråga igen
    List<String> currentQuestion = new ArrayList<>();

    //Sparar vilken kategori man får för varje runda
    List<String> roundCategories = new ArrayList<>();

    //Sparar om man får rätt eller fel
    List<Boolean> answers = new ArrayList<>();

    //Sparar en rundas svar, uppe i questionpage på GUI med grön eller röd
    List<Boolean> roundAnswers = new ArrayList<>();

    //Sparar alla frågor så båda spelarna får samma fråga
    List<Questions> questionToPassBetweenPlayers = new ArrayList<>();



    //Getters och setters
    public int getCloseGameOption() {
        return closeGameOption;
    }

    public void setCloseGameOption(int closeGameOption) {
        this.closeGameOption = closeGameOption;
    }

    public boolean isClickedRightAnswer() {
        return clickedRightAnswer;
    }

    public void setClickedRightAnswer(boolean clickedRightAnswer) {
        this.clickedRightAnswer = clickedRightAnswer;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public int getPLAYER() {
        return PLAYER;
    }

    public boolean getFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMaxQuestion() {
        return maxQuestion;
    }

    public void setMaxQuestion(int maxQuestion) {
        this.maxQuestion = maxQuestion;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public int getMaxRound() {
        return maxRound;
    }

    public void setMaxRound(int maxRound) {
        this.maxRound = maxRound;
    }

    public void addQuestionBetweenPlayers(Questions quest){
        questionToPassBetweenPlayers.add(quest);
    }

    public List<Questions> getQuestionToPassBetweenPlayers() {
        return questionToPassBetweenPlayers;
    }


    public void addQuestionToCurrentList(String s){
        currentQuestion.add(s);
    }

    public List<String> getCurrentQuestion() {
        return currentQuestion;
    }

    public void addToRoundAnswersList(Boolean b){
        roundAnswers.add(b);
    }

    public List<Boolean> getRoundAnswers() {
        return roundAnswers;
    }

    public void answersAddToList(Boolean b){
        this.answers.add(b);
    }

    public List<Boolean> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Boolean> answers) {
        this.answers = answers;
    }

    public void addToList(String input){
        this.roundCategories.add(input);
    }

    public List<String> getRoundCategories() {
        return roundCategories;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Återställer en spelare
     * @param player
     * @return
     */
    public Player clearAllFromPlayer(Player player){

        player.getCurrentQuestion().clear();
        player.getRoundCategories().clear();
        player.getAnswers().clear();
        player.getRoundAnswers().clear();
        player.getQuestionToPassBetweenPlayers().clear();
        player.setPoints(0);
        player.setRound(0);
        player.setQuestion(0);
        player.setCloseGameOption(0);
        player.setClicked(false);
        player.setClickedRightAnswer(false);

        return player;
    }

    /**
     * Den här metoden används i servern för att ge den första anslutna spelaren till spelare 1.
     * @param PLAYER
     */
    public void setPLAYER(int PLAYER) {
        if (PLAYER == 1){
            this.PLAYER = 1;
        }else if (PLAYER == 2){
            this.PLAYER = 2;
        }
    }

    /**
     * Skickar endast över svar från tidigare rond.
     * Om man är i rond 2 får man endast se motståndarens svar från rond 1.
     * Det är för att spelare som inte spelat rondens frågor ska se vad andra spelaren har fått.
     * @param listToRemoveFrom
     * @param maxAmountOfQuestionPerRound
     * @param playerCurrentRound
     * @return
     */
    public List<Boolean> removeAnswersFromList(List<Boolean> listToRemoveFrom, int maxAmountOfQuestionPerRound, int playerCurrentRound){

        int maxAmountOfQuestionsPossible = maxAmountOfQuestionPerRound * playerCurrentRound;

        int allQuestionAnswersUntilPreviousRound = maxAmountOfQuestionsPossible-1;

        for (int i = 0; i < maxAmountOfQuestionPerRound; i++) {

            listToRemoveFrom.remove(allQuestionAnswersUntilPreviousRound);
            allQuestionAnswersUntilPreviousRound--;
        }
        if (maxAmountOfQuestionsPossible == 0){
            listToRemoveFrom.clear();
        }
        return listToRemoveFrom;
    }

    /**
     * Metod som byter två listor.
     * @param temp
     * @return
     */
    public void changeList(List<Boolean> temp) {
        answers = temp;
    }




}
