package Systeem;

import Systeem.PuntenStrategie.IBonusPuntenStrategie;
import Systeem.Vraag.QuizVraagAntwoord;
import Systeem.Vraag.IVraag;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Quiz {
    private final IBonusPuntenStrategie strategie;
    private final List<IVraag> vraagList;
    private ArrayList<QuizVraagAntwoord> quizVraagAntwoordList  = new ArrayList<>();
    private final Account account;
    private GespeeldeQuiz gespeeldeQuiz;

    Instant start, end;
    private void startTimer() {
        start = Instant.now();
    }

    private int stopTimer() {
        end = Instant.now();
        return  (int) Duration.between(start, end).toSeconds();
    }

    public Quiz(Account account, List<IVraag> vraagList, IBonusPuntenStrategie strategie) {
        this.account = account;
        this.vraagList = vraagList;
        this.strategie = strategie;
    }

    public void controleerGemaakteQuiz(int verstrekenTijd) {
        gespeeldeQuiz = new GespeeldeQuiz();
        gespeeldeQuiz.addPunten(strategie.calculate(verstrekenTijd));

        if (checkVragen()){
            account.updateSaldo(2);
            gespeeldeQuiz.addPunten(strategie.getPuntenAlleVragenGoed());
        }

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

    public int eindigQuiz() {
        var verstrekenTijd = stopTimer();
        controleerGemaakteQuiz(verstrekenTijd);
        return gespeeldeQuiz.getPunten();
    }

    public String[] getVragen() {
        List<String> vraagTexten = new ArrayList<>();
        for (var vraag: vraagList) {
            vraagTexten.add(vraag.getVraagtekst());
        }

        startTimer();

        return vraagTexten.toArray(new String[0]);
    }

    public void beantwoordVolgendeVraag(String antwoord, String vraagText) {
        var vraag = getVraag(vraagText);
        var quizVraag = new QuizVraagAntwoord(this, vraag, antwoord);
        addToQuizVraagLijst(quizVraag);
    }

    private void addToQuizVraagLijst(QuizVraagAntwoord quizVraag) {
        quizVraagAntwoordList.add(quizVraag);
    }

    private IVraag getVraag(String vraagText) {
        for (var vraag: vraagList) {
            if (Objects.equals(vraag.getVraagtekst(), vraagText)) return vraag;
        }
        return null;
    }
}
