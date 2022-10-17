import Systeem.Database.DucthDatabaseStragie;
import Systeem.Finch;

import java.util.Scanner;

public class OOADCasus {
    private static final boolean isRunning = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Finch finch = new Finch(new DucthDatabaseStragie());
        var data = DucthDatabaseStragie.VragenlijstList;

        boolean isLoggedin = false;
        while (!isLoggedin) {
            finch.showMainScreen();
            String mainScreenOption = sc.next();
            if (mainScreenOption.equalsIgnoreCase("REG")) {
                if (!finch.Registreer(AccountInput(sc))) {
                    System.out.println("Deze gebruikersnaam bestaat al");
                }

                continue;
            }
            if (mainScreenOption.equalsIgnoreCase("LOG")) {
                if (!finch.Login(AccountInput(sc))) {
                    System.out.println("U heeft uw gegevens verkeerd ingevoerd of geen account");
                } else {
                    isLoggedin = true;
                }
            }
        }

        System.out.println("Selecteer uw vragenlijst op onderwerp");

        boolean isRunning = true;

        var account = finch.getLoggedInAccount();
        while (isRunning) {

            var lijsten = account.toonVragenlijsten();
            for (int i = 0; i < lijsten.size(); i++) {
                System.out.println(i + ": " + lijsten.get(i).getVragenlijst().getOnderwerp());
            }

            var choice2 = sc.nextInt();
            var vragenlijst = account.getSpelerVragenlijst(lijsten.get(choice2));

            account.maakQuizMetVragen(vragenlijst);

            System.out.println("CurrentLifetimebest: " + vragenlijst.getLifetimeBest());

            finch.speelQuiz(sc, vragenlijst, account.getQuiz(), account);

            // End Spelen Quiz
        }
    }

    private static String[] AccountInput(Scanner sc) {
        String[] account = new String[2];
        System.out.println("Uw gebruikersnaam:");
        String gebruikersnaam = sc.next();
        account[0] = gebruikersnaam;
        System.out.println("Uw wachtwoord:");
        String wachtwoord = sc.next();
        account[1] = wachtwoord;

        return account;
    }
}
