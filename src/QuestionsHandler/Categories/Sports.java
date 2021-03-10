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
public class Sports implements Serializable {

    //--------------------------------------------------------------------------------------//
    // Sports Answers
    private final List<Questions> sportsList;

    private final Answers A1 = new Answers("7", "6", "9", "11");

    private final Answers A2 = new Answers("Victoria Azarenka", "Sofia Kenin", "Naomi Osaka", "Serena Williams");

    private final Answers A3 = new Answers("Garbiñe Muguruza", "Simona Halep", "Angelique Kerber", "Victoria Azarenka");

    private final Answers A4 = new Answers("David Beckham", "Cristiano Ronald", "Ben Stokes", "Geraint Thomas");

    private final Answers A5 = new Answers("Ishockey", "Tennis", "Judo", "Badminton");

    private final Answers A6 = new Answers("Gult och svart", "Grönt och Vitt", "Grönt och Gult", "Vitt och rött");

    private final Answers A7 = new Answers("Basket", "Fotboll", "Volleyboll", "Bordtennis");

    private final Answers A8 = new Answers("Ryssland", "Kina", "Kanada", "USA");

    private final Answers A9 = new Answers("Jan-Ove Waldner", "Jan Wallander", "Mats Wilander", "Erik Wilhelm");

    private final Answers A10 = new Answers("Klara något med kraft", "Klara något med magi", "Klara något med pengar", "Klara något med fot");

    //--------------------------------------------------------------------------------------//
    // General Knowledge Questions
    private final Questions Q1 = new Questions("<html>Hur många spelare finns det i ett vattenpoloteam?</html>", A1);

    private final Questions Q2 = new Questions("<html>Vilken tennisspelare vann Australian Ladies Australian Open 2012 och besegrade Maria Sharapova 6-3, 6-0?</html>", A2);

    private final Questions Q3 = new Questions("<html>Wimbledon 2017 vann av 14: e fröna som överraskande besegrade Venus WIlliams i finalen. Vem är hon?</html>", A3);

    private final Questions Q4 = new Questions("<html>Vem var BBC’s ‘Sports Personality of the Year’ 2001?</html>", A4);

    private final Questions Q5 = new Questions("<html>Kanadensiska Connor McDavid är en stigande stjärna i vilken sport?</html>", A5);

    private final Questions Q6 = new Questions("<html>Vilka färger använder Hammarby Fotboll som Bortaställ?</html>", A6);

    private final Questions Q7 = new Questions("<html>Vilket sportspel uppfann James Naismith 1891?</html>", A7);

    private final Questions Q8 = new Questions("<html>Vilket land har dominerat Olympiska sommarspel Synkroniserad simning med fem guldmedaljer sedan det återinfördes till spelen 2000?</html>", A8);

    private final Questions Q9 = new Questions("<html>Vem är svensk bordtennisspelare känd som ‘Gamle Wa’?</html>", A9);

    private final Questions Q10 = new Questions("Vad betyder Zratanera?", A10);


    public Sports(){

        sportsList = new ArrayList<>();

        sportsList.add(Q1);
        sportsList.add(Q2);
        sportsList.add(Q3);
        sportsList.add(Q4);
        sportsList.add(Q5);
        sportsList.add(Q6);
        sportsList.add(Q7);
        sportsList.add(Q8);
        sportsList.add(Q9);
        sportsList.add(Q10);

        Collections.shuffle(sportsList);

    }

    public String getCategoryName() {
        return "Idrott";
    }

    public List<Questions> getSportsList() {
        return sportsList;
    }

}
