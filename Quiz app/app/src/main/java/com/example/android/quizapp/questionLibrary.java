package com.example.android.quizapp;

/**
 * Created by Piratheepa on 11-3-2018.
 */

public class questionLibrary {

    private String mQuestions[] = {
            "Welke sport betekend in het Japans “zachte weg”?",
            "In welk jaar werd het Feyenoord stadion geopend?",
            "Om de hoeveel jaar wordt het wereldkampioenschap cricket gehouden?",
            "Bij welke sport hoort het lied “Take me out to the Ball Game”?",
            "Sinds welk jaar is ijshockey een Olympische sport?",

    };

    private String mChoices[][] = {
            {"Honkbal", "Judo", "Goofy"},
            {"1934", "1935", "1937", "1932"},
            {"Om de 3 jaar", "Om de 4 jaar", "Om de 5 jaar"},
            {"Voetbal", "Basketbal", "Honkbal"},
            {"	1925", "1920", " 1923"}

    };

    private String mCorrectAnswers[] = {"Judo", "1937", "Om de 4 jaar", "Honkbal", "1920"};


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getchoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getchoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getchoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }


}
