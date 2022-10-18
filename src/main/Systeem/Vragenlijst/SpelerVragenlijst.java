package Systeem.Vragenlijst;

public class SpelerVragenlijst {
    private int lifetimeBest;
    private final Vragenlijst vragenlijst;
    
    public SpelerVragenlijst(Vragenlijst vragenlijst) {
        this.lifetimeBest = 0;
        this.vragenlijst = vragenlijst;
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
}
