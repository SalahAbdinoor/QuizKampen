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
 * 4:34 PM
 * Quiz2
 * Copyright: MIT
 */
public class Math implements Serializable {

    //--------------------------------------------------------------------------------------//
    // Math Answers
    private final List<Questions> mathList;

    private final Answers A1 = new Answers("55", "65", "43", "53");

    private final Answers A2 = new Answers("476 > 467", "456 > 465", "403 > 430", "457 > 475");

    private final Answers A3 = new Answers("4531", "4432", "4532", "5431");// Changed(I found two right answers)

    private final Answers A4 = new Answers("1331", "1313", "1133", "3131");//Changed

    private final Answers A5 = new Answers("24", "36", "26", "56");//Changed

    private final Answers A6 = new Answers("360", "21600", "30", "600");//Changed

    private final Answers A7 = new Answers("23", "33", "25", "12");//Changed

    private final Answers A8 = new Answers("x=4", "x=6", "x=3", "x=1");

    private final Answers A9 = new Answers("2", "0,2", "234", "0,74");//Changed

    private final Answers A10 = new Answers("9900", "9990", "990", "1001");

    //--------------------------------------------------------------------------------------//
    // Math Questions
    private final Questions Q1 = new Questions("Summera 1 till 10", A1);

    private final Questions Q2 = new Questions("Vilka av dessa påstående är korrekta?", A2);

    private final Questions Q3 = new Questions("<html>Vilket nummer kommer nästa i serien? 4231, 4331, 4431...?</html>", A3);

    private final Questions Q4 = new Questions("Vad är 121 gånger 11?", A4);//Changed

    private final Questions Q5 = new Questions("5 + 7 + 10 + 6 - 4 =?", A5);//Changed

    private final Questions Q6 = new Questions("Hur många minuter är det på sex timmar?", A6);//Changed

    private final Questions Q7 = new Questions("<html>Vilket nummer kommer nästa i serien? 3,8,13,18...?</html>", A7); //Changed

    private final Questions Q8 = new Questions("14+3x=26", A8);

    private final Questions Q9 = new Questions("1,4 / 0,7", A9);//Changed

    private final Questions Q10 = new Questions("10001 – 101", A10);


    public Math(){

        mathList = new ArrayList<>();

        mathList.add(Q1);
        mathList.add(Q2);
        mathList.add(Q3);
        mathList.add(Q4);
        mathList.add(Q5);
        mathList.add(Q6);
        mathList.add(Q7);
        mathList.add(Q8);
        mathList.add(Q9);
        mathList.add(Q10);

        Collections.shuffle(mathList);

    }

    public String getCategoryName() {
        return "Matte";
    }

    public List<Questions> getMathList() {
        return mathList;
    }

}
