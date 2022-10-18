package Systeem.Vraag;

import Systeem.PuntenStrategie.IPuntenStrategie;

public abstract class Vraag implements IVraag{
    protected IPuntenStrategie strategie;
    protected int punten;
    protected QuizVraagAntwoord quizVraagAntwoord;
    protected String vraagtekst;
    public void setQuizVraagAntwoord(QuizVraagAntwoord quizVraagAntwoord) {
        this.quizVraagAntwoord = quizVraagAntwoord;
    }

}
