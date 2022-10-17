import Systeem.Database;
import Systeem.Finch;

import java.util.Scanner;

public class OOADCasus {
    private static String mainScreenOption;
    private static boolean isRunning = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Finch finch = new Finch();
        Database.getVragenlijsten();
        var data = Database.VragenlijstList;

        finch.showMainScreen();
        mainScreenOption = sc.next();
        if (mainScreenOption.equalsIgnoreCase("REG")) {
            if (finch.Registreer(FinchAuthorization(sc))) {
                finch.showMainScreen();
                mainScreenOption = sc.next();
            } else {
                System.out.println("Deze gebruikersnaam bestaat al");
                finch.showMainScreen();
                mainScreenOption = sc.next();
            }
        }
        if (mainScreenOption.equalsIgnoreCase("LOG")) {
            if (finch.Login(FinchAuthorization(sc)) == null) {
                System.out.println("U heeft uw gegevens verkeerd ingevoerd of geen account");
                finch.showMainScreen();
                mainScreenOption = sc.next();
            }

            System.out.println("Selecteer uw vragenlijst op onderwerp");
            System.out.println(finch.showVragenlijst());
        }

        boolean isRunning = true;

        while (isRunning) {

            var lijsten = finch.getLoggedInAccount().toonVragenlijsten();
            for (int i = 0; i < lijsten.size(); i++) {
                System.out.println(i + ": " + lijsten.get(i).getVragenlijst().getOnderwerp());
            }

            var choice2 = sc.nextInt();
            var vragenlijst = finch.getLoggedInAccount().getSpelerVragenlijst(lijsten.get(choice2));

            finch.getLoggedInAccount().maakQuizMetVragen(vragenlijst);

            System.out.println("CurrentLifetimebest: " + finch.getLoggedInAccount().getSpelerVragenlijst(vragenlijst).getLifetimeBest());

            finch.speelQuiz(sc, vragenlijst);

            // End Spelen Quiz
        }
    }

    private static String[] FinchAuthorization(Scanner sc) {
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
