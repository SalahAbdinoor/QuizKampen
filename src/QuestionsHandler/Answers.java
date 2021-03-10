package QuestionsHandler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salah Abdinoor
 * 11/13/2020
 * 10:09 AM
 * Quiz
 * Copyright: MIT
 */
public class Answers implements Serializable {

    private final String rightAnswer;
    private final String wrongAnswer1;
    private final String wrongAnswer2;
    private final String wrongAnswer3;

    public Answers(String rightAnswer, String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {

        this.rightAnswer = rightAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;

    }

    /**
     * This method gives you a list of the type List<String> in correct order.
     *
     * @return AnswerList
     */

    public List<String> getAnswersList(){
        List<String> answerList = new ArrayList<>();

        answerList.add(this.rightAnswer);
        answerList.add(this.wrongAnswer1);
        answerList.add(this.wrongAnswer2);
        answerList.add(this.wrongAnswer3);

        return answerList;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

}
