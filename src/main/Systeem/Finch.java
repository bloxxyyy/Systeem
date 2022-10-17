package Systeem;

import Systeem.Vragenlijst.SpelerVragenlijst;
import Systeem.Vragenlijst.Vragenlijst;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import static Systeem.Database.VragenlijstList;

public class Finch {
    private ArrayList<Account> accounts = new ArrayList<>();
    private FinchShop finchShop;
    private Account loggedInAccount;

    public Finch() {
        finchShop = new FinchShop();

        //test purpose
        accounts.add(new Account("test","test"));

    }

    public void showMainScreen(){
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
        user.setSpelerVragenlijst(new SpelerVragenlijst(cadeaus[0]));
        user.setSpelerVragenlijst(new SpelerVragenlijst(cadeaus[1]));
        accounts.add(user);
        return true;
    }

    public Account Login(String[] account) {
        for(Account a : accounts){
            if(Objects.equals(a.getUsername(), account[0]) && Objects.equals(a.getPassword(), account[1])){
                loggedInAccount = a;
                return a;
            }
        }
        return null;
    }

    public ArrayList<SpelerVragenlijst> showVragenlijst(){
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

        public void speelQuiz(Scanner sc, SpelerVragenlijst keuze) {
        for (int i = 0; i < getLoggedInAccount().getQuiz().getVraagList().size(); i++) {
            var vraag = getLoggedInAccount().getQuiz().getVolgendeVraagTekst();
            System.out.println(vraag);
            var givenAnswer = sc.next();
            getLoggedInAccount().getQuiz().beantwoordVolgendeVraag(givenAnswer);
        }

        var score = getLoggedInAccount().checkScore();

        var spelerVragenlijst = getLoggedInAccount().getSpelerVragenlijst(keuze);

        spelerVragenlijst.updateLifetimeBest(score);
        System.out.println("Gehaalde Score: " + score);
        System.out.println("Lifetime best: " + spelerVragenlijst.getLifetimeBest());
    }
}
