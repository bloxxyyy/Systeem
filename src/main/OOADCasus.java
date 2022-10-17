import Systeem.Account;
import Systeem.Database;
import Systeem.Finch;

import java.util.Scanner;

import static Systeem.Database.getVragenlijsten;

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



        // Spelen Quiz
//        finch.Login("root", "pass");
//
//        var cadeau = new SpelerVragenlijst(finch.account, finch.finchShop.krijgCadeau());
//        finch.account.OntvangCadeau(cadeau); // register func
//        var cadeau2 = new SpelerVragenlijst(finch.account, finch.finchShop.krijgCadeau());
//        finch.account.OntvangCadeau(cadeau2); // register func
//
//        boolean isRunning = true;
//
//        while (isRunning) {
//            // toon thema's
//            var hashset = finch.account.getThemasBijVragenlijsten();
//            Thema[] themas = finch.account.getThemasBijVragenlijsten().toArray(new Thema[hashset.size()]);
//            for (int i = 0; i < themas.length; i++) {
//                System.out.println(i + ": " + themas[i].getName());
//            }
//
//            var choice = sc.nextInt();
//            var thema = themas[choice];
//
//            var lijsten = finch.account.toonVragenlijstenBijthema(thema);
//            for (int i = 0; i < lijsten.size(); i++) {
//                System.out.println(i + ": " + lijsten.get(i));
//            }
//
//            var choice2 = sc.nextInt();
//            var vragenlijst = finch.account.getSpelerVragenlijst(lijsten.get(choice2));
//
//            finch.account.maakQuizMetVragen(vragenlijst);
//
//            System.out.println("CurrentLifetimebest: " + finch.account.getSpelerVragenlijst(vragenlijst).getLifetimeBest());
//
//            finch.speelQuiz(sc, vragenlijst);
//
//            // End Spelen Quiz
//        }
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
