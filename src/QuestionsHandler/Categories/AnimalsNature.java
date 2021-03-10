package QuestionsHandler.Categories;

import QuestionsHandler.Answers;
import QuestionsHandler.Questions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Salah Abdinoor
 * 11/13/2020
 * 5:12 PM
 * Quiz2
 * Copyright: MIT
 */

public class AnimalsNature implements Serializable {

    //--------------------------------------------------------------------------------------//
    // Animals & Nature Answers
    private final List<Questions> animalsNatureList;

    private final Answers A1 = new Answers("Afrika & Asien", "Afrika & Sydamerika", "Asien och Australien", "Afrika och Australien");

    private final Answers A2 = new Answers("Orangutang", "Gorilla", "Klätterapan", "Schimpans");

    private final Answers A3 = new Answers("Valhaj", "Vithaj", "Blåhaj", "Tigerhaj");

    private final Answers A4 = new Answers("Vallmo", "Tulpan", "Nejlika", "Tusensköna");

    private final Answers A5 = new Answers("Kviga", "Amma", "Springare", "Ko");

    private final Answers A6 = new Answers("Krokus", "Smörblomma", "Rödklöver", "Hundloka");

    private final Answers A7 = new Answers("Karljohan", "Champinjon", "Kantarell", "Björksopp");

    private final Answers A8 = new Answers("Persika", "Äpple", "Apelsin", "Jordgubb");

    private final Answers A9 = new Answers("Gepard", "Leopard", "Lejon", "Tiger");

    private final Answers A10 = new Answers("Al", "Alm", "Asp", "Ask");

    //--------------------------------------------------------------------------------------//
    // Animals & Nature Questions
    private final Questions Q1 = new Questions("Vilda elefanter finns i två världsdelar. Vilka?", A1);

    private final Questions Q2 = new Questions("<html>Vilken människoapa är rödaktig och lever på Sumatra och Borneo?</html>", A2);

    private final Questions Q3 = new Questions("Vilken haj är världens största fiskart?", A3);

    private final Questions Q4 = new Questions("Vrån vilken typ av blomma erhålls opium?", A4);

    private final Questions Q5 = new Questions("Vad kallas en ko som ännu inte kalvat?", A5);

    private final Questions Q6 = new Questions("Från vilken sorts blomma får man saffran?", A6);

    private final Questions Q7 = new Questions("Vilken ätlig svamp kallas även stensopp?", A7);

    private final Questions Q8 = new Questions("Vilken frukt är en stenfruk?t", A8);

    private final Questions Q9 = new Questions("<html>Vilket kattdjur är världens snabbaste djur på land?</html>", A9);

    private final Questions Q10 = new Questions("Vilket lövträd har kottar?", A10);


    public AnimalsNature(){

        animalsNatureList = new ArrayList<>();

        animalsNatureList.add(Q1);
        animalsNatureList.add(Q2);
        animalsNatureList.add(Q3);
        animalsNatureList.add(Q4);
        animalsNatureList.add(Q5);
        animalsNatureList.add(Q6);
        animalsNatureList.add(Q7);
        animalsNatureList.add(Q8);
        animalsNatureList.add(Q9);
        animalsNatureList.add(Q10);

        Collections.shuffle(animalsNatureList);

    }

    public String getCategoryName() {
        return "Djur & natur";
    }

    public List<Questions> getAnimalsNatureList() {
        return animalsNatureList;
    }



}
