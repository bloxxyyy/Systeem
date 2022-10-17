package Systeem;

import Systeem.PuntenStrategie.IBonusPuntenStrategie;
import Systeem.Vraag.QuizVraagAntwoord;
import Systeem.Vraag.IVraag;
import Systeem.Vragenlijst.SpelerVragenlijst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Quiz {
    private IBonusPuntenStrategie strategie;
    private List<IVraag> vraagList;
    private ArrayList<QuizVraagAntwoord> quizVraagAntwoordList;
    private final Account account;
    private GespeeldeQuiz gespeeldeQuiz;
    private int vraagIndex = 0;
    private int verstrekenTijd = 0;

    public Quiz(Account account, List<IVraag> vraagList, IBonusPuntenStrategie strategie) {
        this.account = account;
        this.vraagList = vraagList;
        this.strategie = strategie;
    }

//    public void getVragen(SpelerVragenlijst lijst) {
//        vraagList = account.getSpelerVragenlijst(lijst).getVragenlijst().getRandomVragen();
//    }

    public List<IVraag> getVraagList() {
        return vraagList;
    }

    public String getVolgendeVraagTekst() {
        return vraagList.get(vraagIndex).getVraagtekst();
    }

    public void beantwoordVolgendeVraag(String givenAnswer) {
        if (quizVraagAntwoordList == null) quizVraagAntwoordList = new ArrayList<>();
        var quizVraag = new QuizVraagAntwoord(this, vraagList.get(vraagIndex), givenAnswer);
        vraagList.get(vraagIndex).setQuizVraagAntwoord(quizVraag);
        quizVraagAntwoordList.add(quizVraag);
        vraagIndex++;
    }

    public void controleerGemaakteQuiz() {
        gespeeldeQuiz = new GespeeldeQuiz(this, account, verstrekenTijd);
        gespeeldeQuiz.addPunten(strategie.calculateBonusPunten(verstrekenTijd));
        if (checkVragen()){ account.updateSaldo(2);gespeeldeQuiz.addPunten(strategie.getPuntenAlleVragenGoed());}

    }

    private boolean checkVragen() {
        boolean allesGoed = true;

        for (int i = 0; i < quizVraagAntwoordList.size(); i++) {
            var gegevenAntwoord = quizVraagAntwoordList.get(i).Antwoord;

            boolean inLijst = false;
            var antwoordList = vraagList.get(i).getCorrectAntwoordList();

            for (String correctAntwoord : antwoordList) {
                if (Objects.equals(correctAntwoord, gegevenAntwoord)) {
                    inLijst = true;
                    gespeeldeQuiz.addPunten(vraagList.get(i).getPunten());
                }
            }

            if (!inLijst) allesGoed = false;
        }

        return allesGoed;
    }

    public void setVerstrekenTijd(int tijd) {
        verstrekenTijd = tijd;
    }

    public int getVerstrekenTijd() {
        return verstrekenTijd;
    }

    public int eindigQuiz() {
        controleerGemaakteQuiz();
        return gespeeldeQuiz.getPunten();
    }
}
