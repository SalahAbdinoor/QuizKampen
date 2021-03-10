import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultPage extends JFrame implements ActionListener {

    GUI_Util util = new GUI_Util();

    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    JButton ok = new JButton("OK");

    String winnerPic = "src/Pictures/Winner.jpg";
    String loserPic = "src/Pictures/Loser.jpg";
    String drawPic = "src/Pictures/Equal.jpg";
    JLabel winner = new JLabel(new ImageIcon(winnerPic));
    JLabel loser = new JLabel(new ImageIcon(loserPic));
    JLabel draw = new JLabel(new ImageIcon(drawPic));

    boolean clicked = false;

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    Player player1Local;

    public ResultPage(Player player1, Player player2) {

        player1Local = player1;

        add(panel);

        panel.setLayout(new BorderLayout());
        util.setMainBackground(panel);
        panel.setBorder(new EmptyBorder(50, 30, 20, 30));

        panel.add(label, BorderLayout.NORTH);
        label.setText(player1Local.getName() + " fick " + player1Local.getPoints() + " poäng!");
        util.labelSetFontForegBackg_white(label,0,18,0,51,204);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(new EmptyBorder(10, 10, 10, 10));


        if(player1Local.getPoints() > player2.getPoints()){
            panel.add(winner, BorderLayout.CENTER);
        }else if (player1Local.getPoints() < player2.getPoints()){
            panel.add(loser, BorderLayout.CENTER);
        }else if (player1Local.getPoints() == player2.getPoints()){
            panel.add(draw, BorderLayout.CENTER);
        }

        panel.add(ok, BorderLayout.SOUTH);
        util.buttonSetFontForegBackg_white(ok,0,16,77,255,77);
        ok.setHorizontalAlignment(SwingConstants.CENTER);

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

