package Systeem.Authentication;
import Systeem.Account;
import java.util.ArrayList;

public interface IAuthenticator {
    public boolean Registreer(String[] account);
    public boolean login(String gebruikersnaam, String wachtwoord);
    public Account getLoggedInAccount();
    public ArrayList<Account> getAccounts();
    int getLastMadeAccount();
    Account pakGebruikerBijUsername(String gebruikersnaam);
    String[] haalRegistratieGegevensOp();
    boolean probeerRegistratie(String gebruikersnaam, String wachtwoord);
    boolean gebruikersnaamAllInGebruik(String gebruikersnaam);
    boolean voegToeAanAccountLijst(Account account);
}
