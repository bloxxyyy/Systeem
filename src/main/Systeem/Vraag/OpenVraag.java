package Systeem.Vraag;

import java.util.ArrayList;

public class OpenVraag implements IVraag {
    private int punten;
    private String vraagtekst;
    private QuizVraagAntwoord quizVraagAntwoord;
    private final ArrayList<CorrectAntwoord> correctAntwoordList;

    public OpenVraag(int punten, String vraagtekst, ArrayList<CorrectAntwoord> correctAntwoordList) {
        this.punten = punten;
        this.vraagtekst = vraagtekst;
        this.correctAntwoordList = correctAntwoordList;
    }

    public void setQuizVraagAntwoord(QuizVraagAntwoord quizVraagAntwoord) {
        this.quizVraagAntwoord = quizVraagAntwoord;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }

    public String getVraagtekst() {
        return vraagtekst;
    }

    public void setVraagtekst(String vraagtekst) {
        this.vraagtekst = vraagtekst;
    }

    public QuizVraagAntwoord getQuizVraagAntwoord() {
        return quizVraagAntwoord;
    }

    public ArrayList<CorrectAntwoord> getCorrectAntwoordList() {
        return correctAntwoordList;
    }

}
