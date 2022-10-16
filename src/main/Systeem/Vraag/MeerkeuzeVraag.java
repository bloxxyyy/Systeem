package Systeem.Vraag;

import java.util.ArrayList;

public class MeerkeuzeVraag implements IVraag {
    private int punten;
    private String vraagtekst;

    private ArrayList<AntwoordKeuze> antwoordKeuzeLijst;

    private QuizVraagAntwoord quizVraagAntwoord;
    private final ArrayList<CorrectAntwoord> correctAntwoordList;

    public MeerkeuzeVraag(int punten, String vraagtekst, ArrayList<CorrectAntwoord> correctAntwoordList, ArrayList<AntwoordKeuze> antwoordKeuzeLijst) {
        this.punten = punten;
        this.vraagtekst = vraagtekst;
        this.correctAntwoordList = correctAntwoordList;
        this.antwoordKeuzeLijst = antwoordKeuzeLijst;
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
        StringBuilder tekst = new StringBuilder(vraagtekst + " | ");

        for (AntwoordKeuze antwoordKeuze : antwoordKeuzeLijst) {
            tekst.append(antwoordKeuze.getAntwoordKeuze()).append(", ");
        }

        return tekst.toString();
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
