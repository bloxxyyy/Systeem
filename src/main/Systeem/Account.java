package Systeem;

import Systeem.Vragenlijst.SpelerVragenlijst;
import Systeem.Vragenlijst.Thema;
import Systeem.Vragenlijst.Vragenlijst;

import java.util.ArrayList;

public class Account {
    private Quiz quiz;

    private ArrayList<SpelerVragenlijst> spelerVragenlijstList = new ArrayList<>();

    private String username, password;
    private int saldo = 0;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
        saldo = 100;
    }

    public void setSpelerVragenlijst(SpelerVragenlijst spelerVragenlijst) {
        spelerVragenlijstList.add(spelerVragenlijst);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<SpelerVragenlijst> getSpelerVragenlijst(){
        return spelerVragenlijstList;
    }

//    public SpelerVragenlijst getSpelerVragenlijst(SpelerVragenlijst keuze) {
//        return spelerVragenlijstList.stream().filter((list) -> list == keuze).findFirst().orElse(null);
//    }
//
//    public List<SpelerVragenlijst> toonVragenlijstenBijthema(Thema thema) {
//        return spelerVragenlijstList.stream().filter(vragenlijst ->
//            Objects.equals(vragenlijst.getVragenlijst().getThema().getName(), thema.getName())).collect(Collectors.toList());
//    }
//
//    public void maakQuizMetVragen(SpelerVragenlijst vragenlijst) {
//        this.quiz = new Quiz(this, vragenlijst.getVragenlijst().getRandomVragen());
//    }
//
//    public void OntvangCadeau(SpelerVragenlijst cadeau) {
//        spelerVragenlijstList.add(cadeau);
//    }
//
//    public HashSet<Thema> getThemasBijVragenlijsten() {
//        List<Thema> themaList = new ArrayList<>();
//        for (var spelerVragenlijst : spelerVragenlijstList) {
//            themaList.add(spelerVragenlijst.getVragenlijst().getThema());
//        }
//        return new HashSet<>(themaList);
//    }
//
//    public Quiz getQuiz() {
//        return quiz;
//    }
//
//    public void updateSaldo(int i) {
//        saldo += i;
//    }
//
//    public int checkScore() {
//        return getQuiz().eindigQuiz();
//    }
//
}
