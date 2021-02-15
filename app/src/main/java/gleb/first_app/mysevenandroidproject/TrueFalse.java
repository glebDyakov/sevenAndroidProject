package gleb.first_app.mysevenandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TrueFalse {
    private int question;
    private boolean isTrueQuestion;

    public TrueFalse(int question, boolean isTrueQuestion) {
        this.question = question;
        this.isTrueQuestion = isTrueQuestion;
    }
    public int getQuestion(){
        return question;
    }
    public int setQuestion(){
        this.question=question;
    }
    public int isTrueQuestion(){
        return isTrueQuestion;
    }
    public int setTrueQuestion(boolean trueQuestion){
        isTrueQuestion;
    }


}