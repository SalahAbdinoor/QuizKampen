import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndingGamePage extends JFrame implements ActionListener {

    GUI_Util util = new GUI_Util();

    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton ok = new JButton("OK");

    boolean clicked = false;

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    String importPath = "src/Pictures/Bye.jpg";
    JLabel endingImage = new JLabel(new ImageIcon(importPath));

    Player player1Local;

    public EndingGamePage(Player player) {

        player1Local = player;

        add(panel);
        panel.setLayout(new BorderLayout());
        util.setMainBackground(panel);
        panel.setBorder(new EmptyBorder(50, 30, 20, 30));

        panel.add(label, BorderLayout.NORTH);
        label.setText("Hej då!");
        util.labelSetFontForegBackg_white(label,0,18,0,51,204);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(endingImage, BorderLayout.CENTER);

        panel.add(ok, BorderLayout.SOUTH);
        ok.setHorizontalAlignment(SwingConstants.CENTER);
        util.buttonSetFontForegBackg_white(ok,0,16,77,255,77);
        ok.addActionListener(this);

        setSize(350, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ok){
            setClicked(true);
        }
    }

    public boolean findClickAndPlay(){
        ok.addActionListener(this);
        return isClicked();
    }
}

