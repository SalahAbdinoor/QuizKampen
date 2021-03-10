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
public class ArtLiterature implements Serializable {

    //--------------------------------------------------------------------------------------//
    // Art & Literature Answers
    private final List<Questions> artLiteratureList = new ArrayList<>();

    private final Answers A1 = new Answers("August Strindberg", "Hjalmar Söderberg", "Björn Ranelid", "Daniel Bojic");

    private final Answers A2 = new Answers("Harry Martinson", "Jan Guillou", "Daniel Axelqvist", "Peter Manneberg");

    private final Answers A3 = new Answers("Två", "Tre", "Fyra", "Fem");

    private final Answers A4 = new Answers("Mugglare", "Troll", "Gobliner", "Gråmulare");

    private final Answers A5 = new Answers("Charles Dickens", "Frank Kafka", "William Shakespeare", "George Orwell");

    private final Answers A6 = new Answers("Louvren, Paris", "British Museum, London", "Pradomuseet, Madrid", "<html>The Metropolitan Museum of Art, New York</html>");

    private final Answers A7 = new Answers("Antonio Vivaldi", "Giacomo Puccini", "Gioacchino Rossini", "Benito Mussolini");

    private final Answers A8 = new Answers("Odling", "Intryck", "Insikt", "Sjöl");

    private final Answers A9 = new Answers("Sofokles", "Euripides", "Aischylos", "Aristoteles");

    private final Answers A10 = new Answers("London", "Sydney", "New York", "Johannesburg");

    //--------------------------------------------------------------------------------------//
    // Art & Literature Questions
    private final Questions Q1 = new Questions("<html>Efter äktenskapskrisen med Siri von Essen skrev han 'En dåres försvarstal'.Vilken författare?</html>", A1);

    private final Questions Q2 = new Questions("<html>Vem har skrivit den delvis självbiografiska 'Nässlorna blomma'?</html>", A2);

    private final Questions Q3 = new Questions("<html>Hur många är tornen i titeln på J.R.R. Tolkiens andra volym i serien om Härskarringen?</html>", A3);

    private final Questions Q4 = new Questions("<html>Vilket begrepp används om människor utan magiska förmågor i J.K. Rowlings böcker?</html>", A4);

    private final Questions Q5 = new Questions("<html>Vem är ”pappa” till såväl David Copperfield som Oliver Twist?</html>", A5);

    private final Questions Q6 = new Questions("Var hänger Mona Lisa idag?", A6);

    private final Questions Q7 = new Questions("<html>Vem komponerade 'De fyra årstiderna', på italienska 'Le quattro stagioni'?</html>", A7);

    private final Questions Q8 = new Questions("<html>Ordet kultur kommer från latinets cultura. Vad betyder det, ungefär?</html>", A8);

    private final Questions Q9 = new Questions("<html>Vem skrev tragedierna 'Antigone' och 'Kung Oidipus'?</html>", A9);

    private final Questions Q10 = new Questions("Var ligger konserthuset Royal Albert Hall?", A10);


    public ArtLiterature(){


    }



    public String getCategoryName() {
        return "Konst & literatur";
    }

    public List<Questions> getArtLiteratureList() {

        artLiteratureList.add(Q1);
        artLiteratureList.add(Q2);
        artLiteratureList.add(Q3);
        artLiteratureList.add(Q4);
        artLiteratureList.add(Q5);
        artLiteratureList.add(Q6);
        artLiteratureList.add(Q7);
        artLiteratureList.add(Q8);
        artLiteratureList.add(Q9);
        artLiteratureList.add(Q10);

        Collections.shuffle(artLiteratureList);

        return artLiteratureList;
    }

}
