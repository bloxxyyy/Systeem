package Systeem;

import Systeem.Authentication.Authenticator;
import Systeem.Authentication.IAuthenticator;
import Systeem.DatabaseStrategie.IDatabaseStrategie;
import Systeem.Vragenlijst.SpelerVragenlijst;
import Systeem.Vragenlijst.Vragenlijst;

import java.util.List;

public class Finch {

    private final IAuthenticator Auth;
    private Account account;
    private Quiz quiz;
    private final FinchShop finchShop;

    public Finch(IDatabaseStrategie strategie) {
        finchShop = new FinchShop();
        Auth = new Authenticator();
        strategie.getVragenlijsten();
    }

    public List<SpelerVragenlijst> getLijsten() {
        return account.toonVragenlijsten();
    }

    public String getOnderwerp(SpelerVragenlijst vragenlijst) {
        return vragenlijst.getVragenlijst().getOnderwerp();
    }

    public SpelerVragenlijst getVragenlijst(int choice2) {
        return account.getSpelerVragenlijst(getLijsten().get(choice2));
    }

    public void createQuiz(SpelerVragenlijst vragenlijst) {
        account.maakQuizMetVragen(vragenlijst);
        quiz = account.getQuiz();
    }

    public boolean registreer(String[] accountInput) {

        if (!Auth.Registreer(accountInput)) return false;

        var cadeaus = finchShop.krijgCadeau();
        for (Vragenlijst cadeau : cadeaus) {
            Auth.getAccounts().get(Auth.getAccounts().size() - 1).setSpelerVragenlijst(new SpelerVragenlijst(cadeau));
        }

        return true;
    }

    public boolean login(String[] accountInput) {
        if (!Auth.Login(accountInput)) return false;

        account = Auth.getLoggedInAccount();
        return true;
    }

    public int getLifetimeBest(SpelerVragenlijst vragenlijst) {
        return vragenlijst.getLifetimeBest();
    }

    public int getVraaglistLength() {
        return quiz.getVraagList().size();
    }

    public String getvolgendeVraag() {
        return quiz.getVolgendeVraagTekst();
    }

    public void beantwoordVolgendeVraag(String next) {
        quiz.beantwoordVolgendeVraag(next);
    }

    public void updateVerstrekenTijd(int tijd) {
        quiz.setVerstrekenTijd(tijd);
    }

    public int checkScore() {
        return account.checkScore();
    }

    public void updateLifetimeBest(SpelerVragenlijst vragenlijst, int score) {
        vragenlijst.updateLifetimeBest(score);
    }

    public int getVerstrekenTijd() {
        return quiz.getVerstrekenTijd();
    }
}
