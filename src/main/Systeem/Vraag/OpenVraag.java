package Systeem.Vraag;

import Systeem.PuntenStrategie.IPuntenStrategie;

import java.util.List;

public class OpenVraag extends Vraag {
    private final List<String> correctAntwoordList;

    public OpenVraag(IPuntenStrategie strategie, String vraagtekst, List<String> correctAntwoordList) {
        this.strategie = strategie;
        this.vraagtekst = vraagtekst;
        this.correctAntwoordList = correctAntwoordList;
    }

    @Override
    public int getPunten() {
        return strategie.getOpenVraagPunten();
    }

    public String getVraagtekst() {
        return vraagtekst;
    }

    public List<String> getCorrectAntwoordList() {
        return correctAntwoordList;
    }
}
