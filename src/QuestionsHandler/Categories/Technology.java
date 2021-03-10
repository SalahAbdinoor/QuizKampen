package QuestionsHandler.Categories;

import QuestionsHandler.Answers;
import QuestionsHandler.Questions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Salah Abdinoor
 * 11/14/2020
 * 5:10 PM
 * Quiz2
 * Copyright: MIT
 */
public class Technology implements Serializable {

    //--------------------------------------------------------------------------------------//
    // Technology Answers
    private final List<Questions> technologyList;

    private final Answers A1 = new Answers("Amazon", "Walmart", "BEST BUY", "Apple");

    private final Answers A2 = new Answers("Snapchat", "Instagram", "Facebook", "SNOW");

    private final Answers A3 = new Answers("Harvard", "Columbia", "Yale", "Brown");

    private final Answers A4 = new Answers("2007", "2010", "2000", "2005");

    private final Answers A5 = new Answers("Ljusår", "Ljudår", "Parsec", "Attoparsec");

    private final Answers A6 = new Answers("Archie", "Yahoo!", "Google", "Ask");

    private final Answers A7 = new Answers("1970-talet", "1960-talet", "1980-talet", "1990-talet");

    private final Answers A8 = new Answers("1889", "1947", "1975", "1901");

    private final Answers A9 = new Answers("Böcker", "Leksaker","Elektoronik" , "Porslin");

    private final Answers A10 = new Answers("Lucky-Goldstar", "Lucy-Goldie", "Lucky-Goodman", "Lucy-Goldman");

    //--------------------------------------------------------------------------------------//
    // Technology Questions
    private final Questions Q1 = new Questions("<html>Den nuvarande rikaste mannen i världen Jeff Bezos är VD för vilken online-återförsäljare?</html>", A1);

    private final Questions Q2 = new Questions("<html>Vilken app för sociala medier låter dig bara visa bilder och meddelanden under en begränsad tid?</html>", A2);

    private final Questions Q3 = new Questions("<html>Vilket prestigefyllt universitet hoppade Microsoft-grundaren Bill Gates av?</html>", A3);

    private final Questions Q4 = new Questions("<html>Vilket år lanserades den första Apple iPhone?</html>", A4);

    private final Questions Q5 = new Questions("<html>Vilken längdenhet är lika med cirka 5,8 biljoner mil?</html>", A5);

    private final Questions Q6 = new Questions("<html>Skapades 1990, vad hette den första sökmotorn på internet?</html>", A6);

    private final Questions Q7 = new Questions("Under vilket årtionde lanserades Sony Walkman?", A7);

    private final Questions Q8 = new Questions("När elektronikföretaget Nintendo grundades?", A8);

    private final Questions Q9 = new Questions("<html>Ursprungligen sålde Amazon endast vilken produkt?</html>", A9);

    private final Questions Q10 = new Questions("Vad står LG för i LG Electronics?", A10);


    public Technology(){

        technologyList = new ArrayList<>();

        technologyList.add(Q1);
        technologyList.add(Q2);
        technologyList.add(Q3);
        technologyList.add(Q4);
        technologyList.add(Q5);
        technologyList.add(Q6);
        technologyList.add(Q7);
        technologyList.add(Q8);
        technologyList.add(Q9);
        technologyList.add(Q10);

        Collections.shuffle(technologyList);

    }

    public Object getQuestion(int questionIndex){

        return technologyList.get(questionIndex).getQuestion();
    }

    public String getCategoryName() {
        return "Teknologi";
    }

    public List<Questions> getTechnologyList() {
        return technologyList;
    }

}
