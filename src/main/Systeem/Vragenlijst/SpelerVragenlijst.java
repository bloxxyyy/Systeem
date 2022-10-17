package Systeem.Vragenlijst;

import java.time.LocalDate;

public class SpelerVragenlijst {
    private int lifetimeBest;
    private LocalDate koopdatum;
    private Vragenlijst vragenlijst;

    public SpelerVragenlijst(Vragenlijst vragenlijst) {
        this.lifetimeBest = 0;
        this.koopdatum = java.time.LocalDate.now();
        this.vragenlijst = vragenlijst;
    }


//    private Account account;
//    private Vragenlijst vragenlijst;
//
//    private int lifetimeBest = 0;
//
//    public SpelerVragenlijst(Account account, Vragenlijst vragenlijst) {
//        this.account = account;
//        this.vragenlijst = vragenlijst;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public Vragenlijst getVragenlijst() {
//        return vragenlijst;
//    }
//
//    public void updateLifetimeBest(int score) {
//        if (lifetimeBest < score) lifetimeBest = score;
//    }
//
//    public int getLifetimeBest() {
//        return lifetimeBest;
//    }
}
