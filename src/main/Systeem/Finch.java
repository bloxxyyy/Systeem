package Systeem;

import Systeem.Authentication.Authenticator;
import Systeem.Authentication.IAuthenticator;
import Systeem.DatabaseStrategie.IDatabaseStrategie;
import Systeem.Vragenlijst.SpelerVragenlijst;
import Systeem.Vragenlijst.Vragenlijst;

public class Finch {

    private final IAuthenticator Auth;

    private Account account;
    private final FinchShop finchShop;

    public Finch(IDatabaseStrategie strategie) {
        finchShop = new FinchShop();
        Auth = new Authenticator();
        strategie.getVragenlijsten();
    }

    public String[] getLijsten() {
        return account.toonVragenlijsten();
    }

    public String getOnderwerp(String vragenlijstId) {
        var vragenlijst = account.pakVragenlijst(vragenlijstId);
        return vragenlijst.getVragenlijst().getOnderwerp();
    }

    public boolean registreer(String[] accountInput) {

        if (!Auth.Registreer(accountInput)) return false;

        var cadeaus = finchShop.krijgCadeau();
        var accountIndex = Auth.getLastMadeAccount();
        for (Vragenlijst cadeau : cadeaus) {
            Auth.getAccounts().get(accountIndex).setSpelerVragenlijst(new SpelerVragenlijst(cadeau));
        }

        return true;
    }

    public boolean login(String[] accountInput) {
        if (!Auth.Login(accountInput)) return false;

        account = Auth.getLoggedInAccount();
        return true;
    }

    public void beantwoordVolgendeVraag(String antwoord, String vraagText, String username) {
        account = Auth.pakGebruikerBijUsername(username);
        account.BeantwoordVolgendeVraagVoorActieveQuizVan(vraagText, antwoord);
    }

    public String[] aanvraagSpelenQuiz(String username) {
        account = Auth.pakGebruikerBijUsername(username);
        return account.toonVragenlijsten();
    }

    public void geefKeuzeVragenlijst(String vragenLijstId, String username) {
        account = Auth.pakGebruikerBijUsername(username);
        account.maakQuizMetVragen(vragenLijstId);
    }

    public String[] getVragen(String username) {
        account = Auth.pakGebruikerBijUsername(username);
        return account.getVragen();
    }

    public int eindigQuiz(String username, String vragenlijstId) {
        account = Auth.pakGebruikerBijUsername(username);
        return account.eindigQuiz(vragenlijstId);
    }
}
