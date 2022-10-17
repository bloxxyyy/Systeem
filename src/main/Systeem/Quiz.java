package Systeem;

import Systeem.Vraag.QuizVraagAntwoord;
import Systeem.Vraag.IVraag;
import Systeem.Vragenlijst.SpelerVragenlijst;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Quiz {
    private List<IVraag> vraagList;
    private ArrayList<QuizVraagAntwoord> quizVraagAntwoordList;
    private final Account account;
    private GespeeldeQuiz gespeeldeQuiz;
    private final int puntenTelling = 1;
    private int vraagIndex = 0;
    private int verstrekenTijd = 0; //TODO implement

    public Quiz(Account account, List<IVraag> vraagList) {
        this.account = account;
        this.vraagList = vraagList;
    }

    public void getVragen(SpelerVragenlijst lijst) {
        vraagList = account.getSpelerVragenlijst(lijst).getVragenlijst().getRandomVragen();
    }

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
        if (checkVragen()) account.updateSaldo(2);
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
                    gespeeldeQuiz.addPunten(puntenTelling);
                }
            }

            if (!inLijst)  allesGoed = false;
        }

        return allesGoed;
    }

    public int eindigQuiz() {
        controleerGemaakteQuiz();
        return gespeeldeQuiz.getPunten();
    }
}
