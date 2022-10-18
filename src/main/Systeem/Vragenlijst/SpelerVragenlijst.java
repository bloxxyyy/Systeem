package Systeem.Vragenlijst;

import java.time.LocalDate;

public class SpelerVragenlijst {
    private int lifetimeBest;
    private LocalDate koopdatum;
    private final Vragenlijst vragenlijst;
    
    public SpelerVragenlijst(Vragenlijst vragenlijst) {
        this.lifetimeBest = 0;
        this.vragenlijst = vragenlijst;
        this.koopdatum = java.time.LocalDate.now();
    }

    public Vragenlijst getVragenlijst() {
        return vragenlijst;
    }
    public void updateLifetimeBest(int score) {
        if (lifetimeBest < score) lifetimeBest = score;
    }
    public int getLifetimeBest() {
        return lifetimeBest;
    }
    public LocalDate getKoopdatum() {
        return koopdatum;
    }
}
