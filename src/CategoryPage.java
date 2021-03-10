import QuestionsHandler.Categories.*;
import QuestionsHandler.Categories.Math;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Daniel Bojic
 * Date: 2020-11-13
 * Time: 09:14
 * Project: Quizkampen
 * Copyright: MIT
 */
public class CategoryPage extends JFrame implements ActionListener {

    GUI_Util util = new GUI_Util();

    final int animalsNature = 0;
    final int artLiterature = 1;
    final int generalKnowledge = 2;
    final int math = 3;
    final int music = 4;
    final int popCulture = 5;
    final int sports = 6;
    final int technology = 7;
    final int tvShows = 8;

    int unique1;
    int unique2;
    int unique3;

    boolean category1Clicked;
    boolean category2Clicked;
    boolean category3Clicked;

    boolean clicked = false;

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }


    String categoryName;

    JPanel panel = new JPanel();

    JButton category1 = new JButton();
    JButton category2 = new JButton();
    JButton category3 = new JButton();

    JLabel choose = new JLabel("Välj en kategori");

    Player playerLocal;

    String category1Name;
    String category2Name;
    String category3Name;


    public CategoryPage(Player player) {
        playerLocal = player;

        category1Clicked = false;
        category2Clicked = false;
        category3Clicked = false;

        category1.setText(null);
        category2.setText(null);
        category3.setText(null);

        getCategoryText();

        category1Name = category1.getText();
        category2Name = category2.getText();
        category3Name = category3.getText();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        util.setMainBackground(panel);
        panel.add(Box.createRigidArea(new Dimension(100, 60)));

        panel.add(choose);
        util.labelSetFontForegBackg_white(choose, 0, 18, 0, 51, 204);
        choose.setBorder(new EmptyBorder(10, 30, 10, 30));
        panel.add(Box.createRigidArea(new Dimension(100, 40)));

        panel.add(category1);
        util.buttonSetFontForegBackg_white(category1, 1, 14, 204, 0, 204);
        util.setSizeButton(category1, 200, 70, 200, 70);
        panel.add(Box.createRigidArea(new Dimension(100, 15)));

        panel.add(category2);
        util.buttonSetFontForegBackg_white(category2, 1, 14, 0, 204, 102);
        util.setSizeButton(category2, 200, 70, 200, 70);
        panel.add(Box.createRigidArea(new Dimension(100, 15)));

        panel.add(category3);
        util.buttonSetFontForegBackg_white(category3, 1, 14, 255, 92, 51);
        util.setSizeButton(category3, 200, 70, 200, 70);

        util.alignComponentsCenter(choose, category1, category2, category3);

        setSize(350, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.add(panel);

        category1.addActionListener(this);
        category2.addActionListener(this);
        category3.addActionListener(this);

    }

    /**
     * This methods calls the uniqueRandomNumber(); method to assing values to the 3 unique numbers
     * and uses those as parameters for the method findCategoryText();
     */

    public void getCategoryText() {

        // Generate 3 random numbers and set unique[1, 2, 3]
        uniqueRandomNumber();

        findCategory(unique1);
        findCategory(unique2);
        findCategory(unique3);

    }

    /**
     * This method finds the right category based on a unique random number 0 - 9
     * All the cases (Categories) have been assigned to a number that will corresponds to the given unique number
     * <p>
     * <p>
     * t.ex: unique1 = 5 && popCulture = 5 -> category1.setText("Pop Culture)
     *
     * @param randomCategoryIndex = [unique1 || unique2 || unique3]
     */


    public void findCategory(int randomCategoryIndex) {

        // Operator = randomCategoryIndex = t.ex: unique1
        // animalsNature = 0 && if(unique1 == 0) -> case animalsNature is active:
        // Get category name from AnimalsNature.java
        // Use that name to setCategoryText();
        switch (randomCategoryIndex) {
            case animalsNature -> {
                categoryName = new AnimalsNature().getCategoryName();
                setCategoryText(categoryName);
            }
            case artLiterature -> {
                categoryName = new ArtLiterature().getCategoryName();
                setCategoryText(categoryName);
            }
            case generalKnowledge -> {
                categoryName = new GeneralKnowledge().getCategoryName();
                setCategoryText(categoryName);
            }
            case math -> {
                categoryName = new Math().getCategoryName();
                setCategoryText(categoryName);
            }
            case music -> {
                categoryName = new Music().getCategoryName();
                setCategoryText(categoryName);
            }
            case popCulture -> {
                categoryName = new PopCulture().getCategoryName();
                setCategoryText(categoryName);
            }
            case sports -> {
                categoryName = new Sports().getCategoryName();
                setCategoryText(categoryName);
            }
            case technology -> {
                categoryName = new Technology().getCategoryName();
                setCategoryText(categoryName);
            }
            case tvShows -> {
                categoryName = new TVShows().getCategoryName();
                setCategoryText(categoryName);
            }
        }

    }

    /**
     * This method makes sure to set the correct category in the right button.
     *
     *
     */

    public void setCategoryText(String categoryText) {

        // if all category names are empty ->
        if (category1.getText() == null && category2.getText() == null && category3.getText() == null) {

            // Set category1 as categoryText
            category1.setText(categoryText);

            // if first category name is taken and the other two are empty ->
        } else if ((category1.getText() != null) && category2.getText() == null && category3.getText() == null) {

            // Set category2 as categoryText
            category2.setText(categoryText);

            // if the two first category names are taken and last one is empty ->
        } else if ((category1.getText() != null) && (category2.getText() != null) && category3.getText() == null) {

            // Set category3 as categoryText
            category3.setText(categoryText);
        }

    }

    /**
     * This method creates 3 random numbers that is used for the selection of categories.
     *
     *
     */

    public void uniqueRandomNumber() {

        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        // Add the numbers 0 - 8 in a list
        for (int i = 0; i < 9; i++) {
            listOfNumbers.add(i);
        }
        // Shuffle said list
        Collections.shuffle(listOfNumbers);

        // Get 3 numbers from list. since list is shuffled these will always me 3 different random numbers between 0-8
        unique1 = listOfNumbers.get(0);
        unique2 = listOfNumbers.get(1);
        unique3 = listOfNumbers.get(2);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        category1Clicked = false;
        category2Clicked = false;
        category3Clicked = false;

        if (e.getSource() == category1) {

            dispose();
            category1Clicked = true;
            setClicked(true);

        } else if (e.getSource() == category2) {

            dispose();
            category2Clicked = true;
            setClicked(true);


        } else if (e.getSource() == category3) {

            dispose();
            category3Clicked = true;
            setClicked(true);

        }
    }

    public Player addCategoryInputToPlayer() {

        if (category1Clicked) {

            playerLocal.addToList(category1Name);

        } else if (category2Clicked) {

            playerLocal.addToList(category2Name);

        } else if (category3Clicked) {

            playerLocal.addToList(category3Name);

        }

        return playerLocal;

    }

    public Boolean findClickPlay() {

        category1.addActionListener(this);
        category2.addActionListener(this);
        category3.addActionListener(this);

        return isClicked();
    }
}
