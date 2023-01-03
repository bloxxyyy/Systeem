package Systeem.Authentication;
import Systeem.Account;
import java.util.ArrayList;
import java.util.Objects;

public class Authenticator implements IAuthenticator {

    private Account loggedInAccount;
    private final ArrayList<Account> accounts = new ArrayList<>();

    public boolean Registreer(String[] account) {
        for (Account a : accounts) {
            if (Objects.equals(a.getGebruiker(), account[0])) {
                return false;
            }
        }

        accounts.add(new Account(account[0], account[1]));
        return true;
    }

    public boolean login(String gebruikersnaam, String wachtwoord) {
        ArrayList<Account> accounts = getAccounts();
        setLoggedInToFalse();

        for (Account a : accounts) {
            String username = a.getGebruiker();
            String password = a.getPassword();
            if(Objects.equals(gebruikersnaam, username) && Objects.equals(wachtwoord, password)){
                setLoggedInAccount(a);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    @Override
    public int getLastMadeAccount() {
        return accounts.size() - 1;
    }

    @Override
    public Account pakGebruikerBijUsername(String gebruikersnaam) {
        for (var account: accounts) {
            if (Objects.equals(account.getGebruiker(), gebruikersnaam)) return account;
        }

        return null;
    }

    public void setLoggedInToFalse(){
        loggedInAccount = null;
    }

    public void setLoggedInAccount(Account account){
        this.loggedInAccount = account;
    }

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }

    public String[] haalRegistratieGegevensOp(){
        return new String[] {"Gebruikersnaam:", "Wachtwoord:"};
    }

    public boolean probeerRegistratie(String gebruikersnaam, String wachtwoord){
        boolean inGebruik = gebruikersnaamAllInGebruik(gebruikersnaam);
        boolean registratieGelukt = false;
        if(!inGebruik){
            Account account = new Account(gebruikersnaam, wachtwoord);
            registratieGelukt = voegToeAanAccountLijst(account);
        }

        return registratieGelukt;
    }

    public boolean gebruikersnaamAllInGebruik(String gebruikersnaam){
        for (Account a : accounts) {
            if (Objects.equals(a.getGebruiker(), gebruikersnaam)) {
                return true;
            }
        }

        return false;
    }

    public boolean voegToeAanAccountLijst(Account account){
        return accounts.add(account);
    }
}
