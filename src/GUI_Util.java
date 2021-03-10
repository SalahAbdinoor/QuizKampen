import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Ivona Zoricic
 * Date: 2020-11-26
 * Time: 15:06
 * Project: Quiz
 * Copywrite: MIT
 */
public class GUI_Util extends JFrame {

    public void setMainBackground(JPanel panel) {
        panel.setBackground(new Color(51, 133, 255));
    }

    public void labelSetFontForegBackg_white(JLabel label, int fontType, int fontSize,
                                             int rBackg, int gBackg, int bBackg) {
        label.setFont(new Font("Arial", fontType, fontSize));
        label.setForeground(Color.WHITE);
        label.setBackground(new Color(rBackg, gBackg, bBackg));
        label.setOpaque(true);
    }

    public void labelSetFontForegBackg(JLabel label, String font, int fontType, int fontSize, int rForeg, int gForeg, int bForeg,
                                       int rBackg, int gBackg, int bBackg) {
        label.setFont(new Font(font, fontType, fontSize));
        label.setForeground(new Color(rForeg, gForeg, bForeg));
        label.setBackground(new Color(rBackg, gBackg, bBackg));
        label.setOpaque(true);
    }

    public void labelSetFontForeg_white(JLabel label, int fontType, int fontSize) {
        label.setFont(new Font("Arial", fontType, fontSize));
        label.setForeground(Color.WHITE);
    }

    public void labelSetFontForeg(JLabel label, String font, int fontType, int fontSize, int rForeg, int gForeg, int bForeg) {
        label.setFont(new Font(font, fontType, fontSize));
        label.setForeground(new Color(rForeg, gForeg, bForeg));
    }

    public void buttonSetFontForegBackg_white(JButton button, int fontType, int fontSize,
                                              int rBackg, int gBackg, int bBackg) {
        button.setFont(new Font("Arial", fontType, fontSize));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(rBackg, gBackg, bBackg));
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public void buttonSetFontForeg(JButton button, int fontType, int fontSize,
                                   int rForeg, int gForeg, int bForeg) {
        button.setFont(new Font("Arial", fontType, fontSize));
        button.setForeground(new Color(rForeg, gForeg, bForeg));
        button.setOpaque(true);
        button.setBorderPainted(false);
    }

    public Border setCompoundBorder(int r, int g, int b, int top, int left, int bottom, int right) {
        Border line = new LineBorder(new Color(r, g, b));
        Border margin = new EmptyBorder(top, left, bottom, right);
        return new CompoundBorder(line, margin);
    }

    public void setSizeButton(JButton button, int wPre, int hPre, int wMax, int hMax) {
        button.setPreferredSize(new Dimension(wPre, hPre));
        button.setMaximumSize(new Dimension(wMax, hMax));
    }

    public void setSizeLabel(JLabel label, int wPre, int hPre, int wMax, int hMax) {
        label.setPreferredSize(new Dimension(wPre, hPre));
        label.setMaximumSize(new Dimension(wMax, hMax));
    }

    public void alignComponentsCenter(JLabel l, JButton b1, JButton b2, JButton b3) {
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        b1.setAlignmentX(Component.CENTER_ALIGNMENT);
        b2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b3.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void alignComponentsCenter(JLabel l, JLabel l2, JButton b) {
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void alignComponentsCenter(JLabel l, JLabel l2) {
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void alignComponentsCenter(JLabel l, JTextField f, JButton b) {
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        f.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void alignComponentsCenter(JLabel l, JLabel l2, JLabel l3, JButton b) {
        l.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
        b.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
    }


}
