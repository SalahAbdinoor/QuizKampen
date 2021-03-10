import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * Created by Ivona Zoricic
 * Date: 2020-11-26
 * Time: 11:56
 * Project: Quiz
 * Copywrite: MIT
 */
public class HomePage_waiting extends JFrame {

    GUI_Util util = new GUI_Util();

    JPanel bottomPanel = new JPanel();
    JPanel upperPanel = new JPanel();

    JLabel quizkampen = new JLabel("Quizkampen");
    JLabel player = new JLabel();
    JLabel home = new JLabel("Hem");
    JLabel info = new JLabel("Väntar på spelare nr 2...");

    Player player1Local = new Player();

    public void showWindow(Player player1){

        player1Local.setName(player1.getName());
        player.setText(player1Local.getName());

        add(upperPanel);
        upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.Y_AXIS));
        util.setMainBackground(upperPanel);
        upperPanel.add(Box.createRigidArea(new Dimension(100, 10)));

        upperPanel.add(quizkampen);
        util.labelSetFontForeg(quizkampen, "Comfortaa",1,24,
                255,255,255);
        upperPanel.add(Box.createRigidArea(new Dimension(100, 30)));

        upperPanel.add(player);
        util.labelSetFontForegBackg_white(player,0,18,0,51,204);
        player.setBorder(new EmptyBorder(10, 70, 10, 70));
        upperPanel.add(Box.createRigidArea(new Dimension(100, 240)));

        add(bottomPanel);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(home);
        util.labelSetFontForegBackg(home,"Arial",0,14,0,0,
                0,255,255,255);
        Border compoundLabel = util.setCompoundBorder(128,191,255,10,10,10,10);
        home.setBorder(compoundLabel);
        bottomPanel.add(Box.createRigidArea(new Dimension(40, 20)));

        bottomPanel.add(info);
        util.labelSetFontForeg(info,"Arial",2,14,0,0,0);

        util.alignComponentsCenter(quizkampen, player);

        Container contentPane = getContentPane();
        contentPane.add(upperPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        setSize(350, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void closeWindow(){
        this.dispose();
    }


}


