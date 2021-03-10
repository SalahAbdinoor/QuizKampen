import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage_play extends JFrame implements ActionListener {

    GUI_Util util = new GUI_Util();

    JPanel bottomPanel = new JPanel();
    JPanel upperPanel = new JPanel();

    JLabel quizkampen = new JLabel("Quizkampen");
    JLabel player = new JLabel();
    JButton play = new JButton("Spela");
    JLabel home = new JLabel("Hem");


    Player player1Local = new Player();

    boolean clicked = false;

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }


    public void showWindow(Player player1) {

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
        util.labelSetFontForegBackg_white(player,0,18, 0,51,204);
        player.setBorder(new EmptyBorder(10, 70, 10, 70));
        upperPanel.add(Box.createRigidArea(new Dimension(100, 30)));

        upperPanel.add(play);
        Border compoundButton = util.setCompoundBorder(128,255,128,
                5,80,5,80);
        play.setBorder(compoundButton);
        util.buttonSetFontForegBackg_white(play,0,16,77,255,77);
        upperPanel.add(Box.createRigidArea(new Dimension(100, 240)));

        add(bottomPanel);
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.add(home);
        util.labelSetFontForegBackg(home,"Arial",0,14,0,0,
                0,255,255,255);
        Border compoundLabel = util.setCompoundBorder(128,191,255,
                10,10,10,10);
        home.setBorder(compoundLabel);

        util.alignComponentsCenter(quizkampen, player, play);

        Container contentPane = getContentPane();
        contentPane.add(upperPanel, BorderLayout.CENTER);
        contentPane.add(bottomPanel, BorderLayout.PAGE_END);

        setSize(350, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        play.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == play) {

            dispose();
            setClicked(true);

        }

    }

    public boolean findClickPlay() {
        play.addActionListener(this);
        return isClicked();
    }
}
