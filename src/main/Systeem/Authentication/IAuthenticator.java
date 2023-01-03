package Systeem.Authentication;
import Systeem.Account;
import java.util.ArrayList;

public interface IAuthenticator {
    public boolean Registreer(String[] account);
    public boolean Login(String[] account);
    public Account getLoggedInAccount();
    public ArrayList<Account> getAccounts();

    int getLastMadeAccount();

    Account pakGebruikerBijUsername(String gebruikersnaam);
}
