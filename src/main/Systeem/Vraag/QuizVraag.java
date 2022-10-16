package Systeem.Vraag;

import Systeem.GegevenAntwoord;
import Systeem.Quiz;

public class QuizVraag {
    private Quiz quiz;
    private IVraag vraag;
    private GegevenAntwoord antwoord;

    public QuizVraag(Quiz quiz, IVraag vraag) {
        this.quiz = quiz;
        this.vraag = vraag;
    }

    public GegevenAntwoord getAntwoord() {
        return antwoord;
    }

    public void setAntwoord(GegevenAntwoord antwoord) {
        this.antwoord = antwoord;
    }
}
