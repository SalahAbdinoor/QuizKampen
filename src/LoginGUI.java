import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    GUI_Util util = new GUI_Util();

    JPanel panel = new JPanel();
    JLabel user = new JLabel("Spelare");
    JTextField userText = new JTextField();
    JButton login = new JButton("Logga in");

    String name;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userText || e.getSource() == login) {

            name = userText.getText();
            dispose();

        }
    }

    public String findPlayerAndReturn() {

        login.addActionListener(this);

        return name;
    }


    public void showWindow(){

        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        util.setMainBackground(panel);
        panel.add(Box.createRigidArea(new Dimension(100, 80)));
        panel.setBorder(new EmptyBorder(50, 50, 50, 50));

        panel.add(user);
        util.labelSetFontForeg(user,"Arial",0,18,255,255,255);
        panel.add(Box.createRigidArea(new Dimension(10, 10)));

        panel.add(userText);
        panel.add(Box.createRigidArea(new Dimension(100, 15)));

        panel.add(login);
        util.buttonSetFontForegBackg_white(login,0,12,71,71,209);
        util.setSizeButton(login,100,40,100,40);
        panel.add(Box.createRigidArea(new Dimension(100, 170)));

        util.alignComponentsCenter(user,userText,login);

        setSize(350, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        login.addActionListener(this);
        userText.addActionListener(this);
    }

}
