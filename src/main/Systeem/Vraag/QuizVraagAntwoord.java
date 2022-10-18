package Systeem.Vraag;

import Systeem.Quiz;

public class QuizVraagAntwoord {
    public Quiz quiz;
    public IVraag vraag;
    public String Antwoord;

    public QuizVraagAntwoord(Quiz quiz, IVraag vraag, String antwoord) {
        this.quiz = quiz;
        this.vraag = vraag;
        Antwoord = antwoord;
    }

    public IVraag getVraag() {
        return vraag;
    }
}
