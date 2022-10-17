package Systeem.Vraag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeerkeuzeVraag implements IVraag {
    private int punten;
    private String vraagtekst;

    private List<String> antwoordKeuzeLijst;

    private QuizVraagAntwoord quizVraagAntwoord;
    private final String correctAntwoord;

    public MeerkeuzeVraag(int punten, String vraagtekst, String correctAntwoord, List<String> antwoordKeuzeLijst) {
        this.punten = punten;
        this.vraagtekst = vraagtekst;
        this.correctAntwoord = correctAntwoord;
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

        for (String antwoordKeuze : antwoordKeuzeLijst) {
            tekst.append(antwoordKeuze).append(", ");
        }

        return tekst.toString();
    }

    public void setVraagtekst(String vraagtekst) {
        this.vraagtekst = vraagtekst;
    }

    public QuizVraagAntwoord getQuizVraagAntwoord() {
        return quizVraagAntwoord;
    }

    public List<String> getCorrectAntwoordList() {
        return Arrays.stream(new String[] {correctAntwoord }).toList();
    }
}
