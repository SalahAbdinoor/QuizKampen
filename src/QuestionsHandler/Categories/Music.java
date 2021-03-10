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
 * 4:48 PM
 * Quiz2
 * Copyright: MIT
 */
public class Music implements Serializable {

    //--------------------------------------------------------------------------------------//
    // Music Answers
    private final List<Questions> musicList;

    private final Answers A1 = new Answers("Beach Boys", "Backstreet Boys", "Take That", "Oasis");

    private final Answers A2 = new Answers("1964", "1966", "1954", "1970");

    private final Answers A3 = new Answers("Hometown Glory", "Set Fire to the Rain", "Hello", "Skyfall");

    private final Answers A4 = new Answers("Dua Lipa", "Ava Max", "Camila Cabello", "Rita Ora");

    private final Answers A5 = new Answers("Queen", "Pink Floyd", "Sex Pistols", "The Beatles");

    private final Answers A6 = new Answers("Michael Jackson", "Elvis Presley", "Bruno Mars", "Frank Sinatra");

    private final Answers A7 = new Answers("Justin Bieber", "Joseph Adam Jonas", "Billie Eilish", "ZaYn Malik");

    private final Answers A8 = new Answers("R.E.M.", "U2", "The Smiths", "Radiohead");

    private final Answers A9 = new Answers("Yesterday", "Help!", "Let It Be", "Hej Jude");

    private final Answers A10 = new Answers("Avicii", "Martin Garrix", "Zedd", "Kygo");

    //--------------------------------------------------------------------------------------//
    // Music Questions
    private final Questions Q1 = new Questions("<html>Vilken 1960-tals amerikansk popgrupp skapade surfin sound?</html>", A1);

    private final Questions Q2 = new Questions("Vilket år åkte Beatles först till USA?", A2);

    private final Questions Q3 = new Questions("Vad hette Adeles första skiva?", A3);

    private final Questions Q4 = new Questions("<html>'Future Nostalgia' som innehåller singeln'Don't Start Now' är det andra studioalbumet från vilken engelsk sångare?</html>", A4);

    private final Questions Q5 = new Questions("<html>Vad heter bandet med följande medlemmar:John Deacon, Brian May, Freddie Mercury,Roger Taylor?</html>", A5);

    private final Questions Q6 = new Questions("<html>Vilken sångare var bland annat känd som 'The King of Pop' och 'The Gloved One'?</html>", A6);

    private final Questions Q7 = new Questions("<html>Vilken amerikansk popstjärna hade framgångsrikt 2015-framgång med singlarna 'Sorry' och 'Love Yourself'?</html>", A7);

    private final Questions Q8 = new Questions("<html>‘Losing my religion‘ var en hit för vilket alternativt Rockband 1991?</html>", A8);

    private final Questions Q9 = new Questions("<html>Vilken låt har följande texter: 'Suddenly I’m not half the man I used to be. There’s a shadow hanging over me.'?</html>", A9);

    private final Questions Q10 = new Questions("<html>Vilken svensk musikproducent har skapat studioalbum ‘True‘?</html>", A10);


    public Music(){

        musicList = new ArrayList<>();

        musicList.add(Q1);
        musicList.add(Q2);
        musicList.add(Q3);
        musicList.add(Q4);
        musicList.add(Q5);
        musicList.add(Q6);
        musicList.add(Q7);
        musicList.add(Q8);
        musicList.add(Q9);
        musicList.add(Q10);

        Collections.shuffle(musicList);

    }

    public String getCategoryName() {
        return "Musik";
    }

    public List<Questions> getMusicList() {
        return musicList;
    }
}
