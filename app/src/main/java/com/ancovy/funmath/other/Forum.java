package com.ancovy.funmath.other;

/**
 * Created by DarKnight98 on 5/8/2017.
 */

public class Forum {
    String title, answer;

    public Forum() {
    }

    public Forum(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
