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
 * 4:40 PM
 * Quiz2
 * Copyright: MIT
 */
public class PopCulture implements Serializable {

    //--------------------------------------------------------------------------------------//
    // Pop Culture Answers
    private final List<Questions> popCultureList;

    private final Answers A1 = new Answers("Stephenie Meyer", "E. L. James", "J. K. Rowling", "J.R.R Tolkien");

    private final Answers A2 = new Answers("4 maj", "4 juli", "20 maj", "20 juli");

    private final Answers A3 = new Answers("Becoming", "Enhancing","Yes We Can", "Yes I Can");

    private final Answers A4 = new Answers("Doja Cat", "Megan Thee Stallion", "Nicki Minaj", "Lana Del Rey");

    private final Answers A5 = new Answers("7 böcker och 8 filmer.", "6 böcker och 8 filmer.", "10 böcker och 10 filmer.", "8 böcker och 9 filmer.");

    private final Answers A6 = new Answers("Winifred, Mary och Sarah", "Wendy, Meagan och Sandra", "Anny, Mary och Sandra", "Wendy, Megan och Sarah");

    private final Answers A7 = new Answers("Lady Gaga", "Ariana Grande", "Katy Perry", "Madonna");

    private final Answers A8 = new Answers("John James Preston", "Aidan Shaw", "Jack Berger", "Aleksandr Petrovsky");

    private final Answers A9 = new Answers("Kourtney", "Kim", "Khloé", "Kris");

    private final Answers A10 = new Answers("The Upside Down", "The Strain", "The distortion", "The Inside Out");

    //--------------------------------------------------------------------------------------//
    // Pop Culture Questions
    private final Questions Q1 = new Questions("Vem skrev Twilight-böckerna?", A1);

    private final Questions Q2 = new Questions("Vilken dag är Star Wars Day?", A2);

    private final Questions Q3 = new Questions("Vad heter Michelle Obamas 2018-memoar?", A3);

    private final Questions Q4 = new Questions("<html>Vem sjunger låten 'Say So' som ligger bakom den populära TikTok-dansen?</html>", A4);

    private final Questions Q5 = new Questions("<html>Hur många Harry Potter böcker och filmer finns det?</html>", A5);

    private final Questions Q6 = new Questions("<html>Vad heter Sanderson-systrarna från Hocus Pocus?</html>", A6);

    private final Questions Q7 = new Questions("<html>Vilken popstjärna är gudmor till båda Elton Johns söner?</html>", A7);

    private final Questions Q8 = new Questions("<html>Vad är Mr. Big: s riktiga namn i Sex and the City?</html>", A8);

    private final Questions Q9 = new Questions("Vem är den äldsta Kardashian-systern?", A9);

    private final Questions Q10 = new Questions("<html>Vad heter den alternativa dimensionen i Netflix Stranger Things?</html>", A10);


    public PopCulture(){

        popCultureList = new ArrayList<>();

        popCultureList.add(Q1);
        popCultureList.add(Q2);
        popCultureList.add(Q3);
        popCultureList.add(Q4);
        popCultureList.add(Q5);
        popCultureList.add(Q6);
        popCultureList.add(Q7);
        popCultureList.add(Q8);
        popCultureList.add(Q9);
        popCultureList.add(Q10);

        Collections.shuffle(popCultureList);

    }

    public String getCategoryName() {
        return "Pop Kultur";
    }

    public List<Questions> getPopCultureList() {
        return popCultureList;
    }

}
