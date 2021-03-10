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
public class TVShows implements Serializable {

    //--------------------------------------------------------------------------------------//
    // TVShows Answers
    private final List<Questions> tvShows;

    private final Answers A1 = new Answers("Central Perk", "Starbucks", "Friends Pub", "SoHo");

    private final Answers A2 = new Answers("How you doing?", "How's it going beautiful?", "Hey baby.", "<html>You're wasting good pastrami!</html>");

    private final Answers A3 = new Answers("73", "87", "53", "67");

    private final Answers A4 = new Answers("Bröderna Duffer", "Syskonen Wachowski", "Syskonnen Willoughby", "Bröderna Coen");

    private final Answers A5 = new Answers("Edith", "Yvette", "Michelle", "Maria");

    private final Answers A6 = new Answers("Larry David", "Jerry Seinfeld", "Richard Lewis", "Jeff Garlin");

    private final Answers A7 = new Answers("Claire Foy", "Cate Blanchett", "Vanessa Kirby", "Lily James");

    private final Answers A8 = new Answers("Sex and the City", "Girlfriends", "Gossip Girl", "Desperate Housewives");

    private final Answers A9 = new Answers("Parks and Recreation", "Great News", "The Good Place", "The Office");

    private final Answers A10 = new Answers("Tina Fey", "Amy Poehler", "Lindsay Lohan", "Lacey Chabert");

    //--------------------------------------------------------------------------------------//
    // TVShows Questions
    private final Questions Q1 = new Questions("Vad heter kaféet där de umgås i 'Friends?'", A1);

    private final Questions Q2 = new Questions("<html>Vad är Joey's slagord när han träffar kvinnor i 'Friends'?</html>", A2);

    private final Questions Q3 = new Questions("<html>Hur många avsnitt av 'Game of Thrones' finns det?</html>", A3);

    private final Questions Q4 = new Questions("Namnge skaparna av 'Stranger Things'", A4);

    private final Questions Q5 = new Questions("Vad heter Renes fru i 'Allo' Allo! ?", A5);

    private final Questions Q6 = new Questions("<html>Vem skapade hit USA: s sitcom Seinfeld with Jerry Seinfeld?</html>", A6);

    private final Questions Q7 = new Questions("<html>Vem spelade drottning Elizabeth II under de första säsongerna av 'The Crown'?</html>", A7);

    private final Questions Q8 = new Questions("<html>Vilket tv-program innehåller Miranda Hobbes och Samantha Jones?</html>", A8);

    private final Questions Q9 = new Questions("<html>Amy Poehler, Rob Lowe och Chris Pratt arbetade tillsammans på vilken amerikansk komedieserie?</html>", A9);

    private final Questions Q10 = new Questions("<html>Vilken amerikansk komedi-skådespelerska skapade Netflix-showen 'The Unbreakable Kimmy Schmidt'?</html>", A10);


    public TVShows(){


        tvShows = new ArrayList<>();

        tvShows.add(Q1);
        tvShows.add(Q2);
        tvShows.add(Q3);
        tvShows.add(Q4);
        tvShows.add(Q5);
        tvShows.add(Q6);
        tvShows.add(Q7);
        tvShows.add(Q8);
        tvShows.add(Q9);
        tvShows.add(Q10);

        Collections.shuffle(tvShows);

    }

    public String getCategoryName() {
        return "TV-show";
    }

    public List<Questions> getTvShowsList() {
        return tvShows;
    }

}
