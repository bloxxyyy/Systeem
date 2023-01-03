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

//    public boolean registreer(String[] accountInput) {
//
//        if (!Auth.Registreer(accountInput)) return false;
//
//        var cadeaus = finchShop.krijgCadeau();
//        var accountIndex = Auth.getLastMadeAccount();
//        for (Vragenlijst cadeau : cadeaus) {
//            Auth.getAccounts().get(accountIndex).addSpelerVragenlijst(new SpelerVragenlijst(cadeau));
//        }
//
//        return true;
//    }

    public String[] aangevenRegistreren() {
        return Auth.haalRegistratieGegevensOp();
    }

    public void geefGegevens(String gebruikersnaam, String wachtwoord) {
        boolean registratieGelukt = Auth.probeerRegistratie(gebruikersnaam, wachtwoord);
        if (!registratieGelukt) {
            System.out.println("error");
            return;
        }

        Vragenlijst[] cadeaus = finchShop.krijgCadeau();
        Account acc = Auth.pakGebruikerBijUsername(gebruikersnaam);
        for (Vragenlijst cadeau : cadeaus) {
            SpelerVragenlijst lijst = new SpelerVragenlijst(cadeau);
            acc.addSpelerVragenlijst(lijst);
        }
    }

    public boolean login(String gebruikersnaam, String wachtwoord) {
        boolean isLoggedIn;
        isLoggedIn = Auth.login(gebruikersnaam, wachtwoord);
        if (isLoggedIn) {
            Account account = Auth.getLoggedInAccount();
            setLoggedInAccount(account);
        }

        return isLoggedIn;
    }

    public void beantwoordVolgendeVraag(String antwoord, String vraagText, String gebruikersnaam) {
        account = Auth.pakGebruikerBijUsername(gebruikersnaam);
        account.BeantwoordVolgendeVraagVoorActieveQuizVan(vraagText, antwoord);
    }

    public String[] aanvraagSpelenQuiz(String gebruikersnaam) {
        account = Auth.pakGebruikerBijUsername(gebruikersnaam);
        return account.toonVragenlijsten();
    }

    public void geefKeuzeVragenlijst(String spelerVragenlijstIds, String gebruikersnaam) {
        account = Auth.pakGebruikerBijUsername(gebruikersnaam);
        account.maakQuizMetVragen(spelerVragenlijstIds);
    }

    public String[] startQuiz(String gebruikersnaam) {
        account = Auth.pakGebruikerBijUsername(gebruikersnaam);
        return account.getVragen();
    }

    public int eindigQuiz(String gebruikersnaam, String spelerVragenlijstId) {
        account = Auth.pakGebruikerBijUsername(gebruikersnaam);
        return account.eindigQuiz(spelerVragenlijstId);
    }

    public void setLoggedInAccount(Account account) {
        this.account = account;
    }
}
