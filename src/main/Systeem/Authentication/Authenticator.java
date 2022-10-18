package Systeem.Authentication;
import Systeem.Account;
import java.util.ArrayList;
import java.util.Objects;

public class Authenticator implements IAuthenticator {

    private Account loggedInAccount;
    private final ArrayList<Account> accounts = new ArrayList<>();

    public boolean Registreer(String[] account) {
        for (Account a : accounts) {
            if (Objects.equals(a.getUsername(), account[0])) {
                return false;
            }
        }

        accounts.add(new Account(account[0], account[1]));
        return true;
    }

    public boolean Login(String[] account) {
        for (Account a : accounts) {
            if (Objects.equals(a.getUsername(), account[0]) && Objects.equals(a.getPassword(), account[1])) {
                loggedInAccount = a;
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

    public Account getLoggedInAccount() {
        return loggedInAccount;
    }
}
