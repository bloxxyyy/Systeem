package Systeem;

import Systeem.PuntenStrategie.BonusPuntenStrategie;
import Systeem.Vragenlijst.SpelerVragenlijst;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private Quiz quiz;
    private ArrayList<SpelerVragenlijst> spelerVragenlijstList = new ArrayList<>();
    private String gebruikersnaam, password;
    private int saldo;

    public Account(String gebruikersnaam, String password) {
        this.gebruikersnaam = gebruikersnaam;
        this.password = password;
        this.saldo = 100;
    }

    public void addSpelerVragenlijst(SpelerVragenlijst spelerVragenlijst) {
        spelerVragenlijstList.add(spelerVragenlijst);
    }
    public String getGebruiker() {
        return gebruikersnaam;
    }
    public String getPassword() {
        return password;
    }

    public String[] toonVragenlijsten() {
        spelerVragenlijstList.removeIf(spelerVragenlijst -> Period.between(spelerVragenlijst.getKoopdatum(), java.time.LocalDate.now()).getYears() == 1);

        List<String> ids = new ArrayList<>();
        for (var svl: spelerVragenlijstList) {
            ids.add(svl.getVragenlijst().getId());
        }

        return ids.toArray(new String[0]);
    }

    public void maakQuizMetVragen(String spelerVragenlijstId) {
        var lijst = pakVragenlijst(spelerVragenlijstId);
        var vragen = lijst.getRandomVragen();
        var strategy = new BonusPuntenStrategie();

        this.quiz = new Quiz(this, vragen, strategy);
    }

    public void updateSaldo(int saldo) {
        this.saldo += saldo;
    }

    public SpelerVragenlijst pakVragenlijst(String vragenlijstId) {
        for (var svl: spelerVragenlijstList) {
            if (Objects.equals(svl.getVragenlijst().getId(), vragenlijstId)){
                return svl;
            }
        }

        return null;
    }

    public String[] getVragen() {
        return quiz.getVragen();
    }

    public void BeantwoordVolgendeVraagVoorActieveQuizVan(String vraagText, String antwoord) {
        quiz.beantwoordVolgendeVraag(antwoord, vraagText);
    }

    public int eindigQuiz(String vragenlijstId) {
        var score = quiz.eindigQuiz();
        pakVragenlijst(vragenlijstId).updateLifetimeBest(score);
        return score;

    }
}
