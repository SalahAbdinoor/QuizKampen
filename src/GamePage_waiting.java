import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Ivona Zoricic
 * Date: 2020-11-26
 * Time: 12:09
 * Project: Quiz
 * Copywrite: MIT
 */
public class GamePage_waiting extends JFrame {

    GUI_Util util = new GUI_Util();

    JPanel player1Panel = new JPanel();
    JPanel player2Panel = new JPanel();
    JPanel stats = new JPanel();
    JPanel categoriepanel = new JPanel();
    JPanel lowestPanel = new JPanel();
    JButton info = new JButton("Spelare 2 spelar");
    JButton playerName1 = new JButton();
    JButton playerName2 = new JButton("");

    List<JButton> player1_answers;
    List<JButton> player2_answers;

    List<JLabel> labelNames;

    Player player1Local;

    Properties properties = new Properties();

    int numberOfRounds;
    int numberOfQuestions;


    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }


    public List<JButton> createButtonList(int numberOfButtons) {
        List<JButton> buttonList = new ArrayList<>();
        for (int i = 0; i < numberOfButtons; i++) {
            buttonList.add(new JButton());
        }
        return buttonList;
    }

    public List<JLabel> createLabelList(int numberOfRounds) {
        List<JLabel> labelList = new ArrayList<>();
        for (int i = 0; i < numberOfRounds; i++) {
            labelList.add(new JLabel(""));
        }
        return labelList;
    }

    public void showWindow(Player player1, Player player2) {

        lowestPanel.removeAll();
        stats.removeAll();
        player1Panel.removeAll();
        player2Panel.removeAll();
        categoriepanel.removeAll();

        revalidate();
        repaint();

        player1Local = player1;

        info.setText(player2.getName() + " spelar...");
        playerName2.setText(player2.getName());

        importFromProperties();

        generateUI(player2);


        add(stats);
        stats.setLayout(new BoxLayout(stats, BoxLayout.LINE_AXIS));
        util.setMainBackground(stats);
        stats.setBorder(new EmptyBorder(30, 10, 30, 10));

        stats.add(playerName1);
        util.buttonSetFontForegBackg_white(playerName1, 0, 14, 0, 51, 204);
        util.setSizeButton(playerName1, 150, 40, 150, 40);
        playerName1.setAlignmentX(Component.LEFT_ALIGNMENT);

        stats.add(Box.createRigidArea(new Dimension(20, 40)));
        stats.add(playerName2);
        util.buttonSetFontForegBackg_white(playerName2, 0, 14, 191, 64, 191);
        util.setSizeButton(playerName2, 150, 40, 150, 40);
        playerName2.setAlignmentX(Component.RIGHT_ALIGNMENT);

        add(player1Panel);
        player1Panel.setLayout(new GridLayout(getNumberOfRounds(), getNumberOfQuestions() + 1));
        player1Panel.setBorder(new EmptyBorder(10, 20, 10, 2));
        util.setMainBackground(player1Panel);

        add(categoriepanel);
        categoriepanel.setLayout(new GridLayout(getNumberOfRounds() + 1, 1));
        categoriepanel.setBorder(new EmptyBorder(20, 2, 0, 2));
        util.setMainBackground(categoriepanel);

        add(player2Panel);
        player2Panel.setLayout(new GridLayout(getNumberOfRounds(), getNumberOfQuestions() + 1));
        player2Panel.setBorder(new EmptyBorder(10, 2, 10, 20));
        util.setMainBackground(player2Panel);

        add(lowestPanel);
        lowestPanel.setLayout(new BoxLayout(lowestPanel, BoxLayout.Y_AXIS));
        util.setMainBackground(lowestPanel);

        lowestPanel.add(info);
        util.buttonSetFontForeg(info, 2, 16, 0, 0, 77);
        util.setSizeButton(info, 350, 210, 350, 210);
        info.setContentAreaFilled(false);
        info.setBorderPainted(false);
        info.setOpaque(false);

        playerName1.setText(player1Local.getName());

        Container contentPane = getContentPane();
        contentPane.add(stats, BorderLayout.NORTH);
        contentPane.add(player1Panel, BorderLayout.WEST);
        contentPane.add(categoriepanel, BorderLayout.CENTER);
        contentPane.add(player2Panel, BorderLayout.EAST);
        contentPane.add(lowestPanel, BorderLayout.SOUTH);

        setSize(350, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    public void generateUI(Player player2) {

        player1Local.setMaxRound(getNumberOfRounds());
        player1Local.setMaxQuestion(getNumberOfQuestions());

        int totalbuttons = getNumberOfQuestions() * getNumberOfRounds();

        player1_answers = createButtonList(totalbuttons);
        player2_answers = createButtonList(totalbuttons);


        generatePlayerButtons(player1Local, player1_answers, totalbuttons, player1Panel);
        generatePlayerButtons(player2, player2_answers, totalbuttons, player2Panel);


        labelNames = createLabelList(getNumberOfRounds());

        //Hämtar kategorinamn
        for (int i = 0; i < player1Local.getMaxRound(); i++) {

            if (i < player1Local.getRound()) {

                labelNames.get(i).setText(player1Local.getRoundCategories().get(i));

            } else {

                labelNames.get(i).setText("          ");

            }

            categoriepanel.add(labelNames.get(i));

        }

        //Placerar kategorinamn
        if (player1Local.getRound() >= 1) {
            for (int i = 0; i < player1Local.getRoundCategories().size(); i++) {
                labelNames.get(i).setText(player1Local.getRoundCategories().get(i));
                util.labelSetFontForegBackg_white(labelNames.get(i), 0, 10, 51, 133, 255);
                labelNames.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            }

        }
    }

    public void generatePlayerButtons(Player playerToGenerate, List<JButton> playerButtonToGenerate, int totalbuttons, JPanel playerPanel) {

        for (int i = 0; i < totalbuttons; i++) {
            if (i < playerToGenerate.getAnswers().size()) {
                if (!playerToGenerate.getAnswers().get(i)) {
                    playerButtonToGenerate.get(i).setBackground(Color.RED);
                    playerButtonToGenerate.get(i).setOpaque(true);
                    playerButtonToGenerate.get(i).setBorder(new LineBorder(new Color(51, 133, 255)));
                } else {
                    playerButtonToGenerate.get(i).setBackground(Color.GREEN);
                    playerButtonToGenerate.get(i).setOpaque(true);
                    playerButtonToGenerate.get(i).setBorder(new LineBorder(new Color(51, 133, 255)));
                }
            }
            playerPanel.add(playerButtonToGenerate.get(i));
            util.setSizeButton(playerButtonToGenerate.get(i), 35, 10, 35, 10);
        }

    }

    public void importFromProperties() {
        try {
            properties.load(new FileInputStream("src/RoundQuestions.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String stringRounds = properties.getProperty("numberOfRounds", "2");
        setNumberOfRounds(Integer.parseInt(stringRounds));


        String stringQuestions = properties.getProperty("numberOfQuestions", "2");
        setNumberOfQuestions(Integer.parseInt(stringQuestions));
    }


    public void closeWindow() {
        dispose();
    }

}
