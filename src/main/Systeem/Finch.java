package Systeem;

import Systeem.DatabaseStrategie.IDatabaseStrategie;
import Systeem.Vragenlijst.SpelerVragenlijst;
import Systeem.Vragenlijst.Vragenlijst;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static Systeem.DatabaseStrategie.DucthDatabaseStragie.VragenlijstList;

public class Finch {
    private ArrayList<Account> accounts = new ArrayList<>();
    private FinchShop finchShop;
    private Account loggedInAccount;
    private IDatabaseStrategie strategie;

    public Finch(IDatabaseStrategie strategie) {
        finchShop = new FinchShop();
        this.strategie = strategie;
        strategie.getVragenlijsten();
        //test purpose
        accounts.add(new Account("test", "test"));

    }

    public void showMainScreen() {
        System.out.println("Welkom bij Finch");
        System.out.println("Registreer of Login");
    }

    public boolean Registreer(String[] account) {
        if (accounts.size() != 0) {
            for (Account a : accounts) {
                if (Objects.equals(a.getUsername(), account[0])) {
                    return false;
                }
            }
        }

        var user = new Account(account[0], account[1]);
        var cadeaus = krijgCadeau();
        for (int i = 0; i < cadeaus.length; i++) {
            user.setSpelerVragenlijst(new SpelerVragenlijst(cadeaus[i]));
        }
        accounts.add(user);
        return true;
    }

    public boolean Login(String[] account) {
        for (Account a : accounts) {
            if (Objects.equals(a.getUsername(), account[0]) && Objects.equals(a.getPassword(), account[1])) {
                loggedInAccount = a;
                return true;
            }
        }
        return false;
    }

    public ArrayList<SpelerVragenlijst> showVragenlijst() {
        return loggedInAccount.getSpelerVragenlijst();
    }

    // TODO implement
    public Vragenlijst[] krijgCadeau() {
        return new Random()
                .ints(0, VragenlijstList.size())
                .distinct()
                .limit(2)
                .mapToObj(VragenlijstList::get).toArray(Vragenlijst[]::new);
    }

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public void speelQuiz(Scanner sc, SpelerVragenlijst keuze, Quiz quiz, Account account) {
        Instant start = Instant.now();
        for (int i = 0; i < quiz.getVraagList().size(); i++) {
            var vraag = quiz.getVolgendeVraagTekst();
            System.out.println(vraag);
            var givenAnswer = sc.next();
            quiz.beantwoordVolgendeVraag(givenAnswer);
        }
        Instant end = Instant.now();
        quiz.setVerstrekenTijd((int) Duration.between(start, end).toSeconds());

        var score = account.checkScore();

        var spelerVragenlijst = account.getSpelerVragenlijst(keuze);

        spelerVragenlijst.updateLifetimeBest(score);
        System.out.println("Gehaalde Score: " + score);
        System.out.println("Quiz Tijd: " + quiz.getVerstrekenTijd() + " seconden");
        System.out.println("Lifetime best: " + spelerVragenlijst.getLifetimeBest());
    }
}
