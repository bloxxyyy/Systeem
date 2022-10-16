package Systeem;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Finch {
    private ArrayList<Account> accounts = new ArrayList<>();
    private FinchShop finchShop;

    public Finch() {
        finchShop = new FinchShop();
    }

    public void Registreer(String[] account) {
        accounts.add(new Account(account[0],account[1]));
    }

    public boolean Login(String[] account) {
        for(Account a : accounts){
            if(Objects.equals(a.getUsername(), account[0]) && Objects.equals(a.getPassword(), account[1])){
                return true;
            }
        }
        return false;
    }




//    public void speelQuiz(Scanner sc, SpelerVragenlijst keuze) {
//        for (int i = 0; i < account.getQuiz().getVraagList().size(); i++) {
//            var vraag = account.getQuiz().getVolgendeVraagTekst();
//            System.out.println(vraag);
//            var givenAnswer = sc.next();
//            account.getQuiz().beantwoordVolgendeVraag(givenAnswer);
//        }
//
//        var score = account.checkScore();
//
//        var spelerVragenlijst = account.getSpelerVragenlijst(keuze);
//
//        spelerVragenlijst.updateLifetimeBest(score);
//        System.out.println("Gehaalde Score: " + score);
//        System.out.println("Lifetime best: " + spelerVragenlijst.getLifetimeBest());
//    }
}
