package Systeem.Vraag;

import Systeem.PuntenStrategie.IPuntenStrategie;

import java.util.Arrays;
import java.util.List;

public class MeerkeuzeVraag extends Vraag {
    private List<String> antwoordKeuzeLijst;

    private final String correctAntwoord;

    public MeerkeuzeVraag(IPuntenStrategie strategie, String vraagtekst, String correctAntwoord, List<String> antwoordKeuzeLijst) {
        this.strategie = strategie;
        this.vraagtekst = vraagtekst;
        this.correctAntwoord = correctAntwoord;
        this.antwoordKeuzeLijst = antwoordKeuzeLijst;
    }

    @Override
    public int getPunten() {
        return strategie.getMeerkeuzeVraagPunten();
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

    public List<String> getCorrectAntwoordList() {
        return Arrays.stream(new String[]{correctAntwoord}).toList();
    }
}
