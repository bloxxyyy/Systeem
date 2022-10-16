import Systeem.Finch;
import Systeem.FinchShop;
import Systeem.SpelerVragenlijst;
import Systeem.Thema;

import java.util.Scanner;

public class OOADCasus {
    private static String mainScreenOption;
    private static boolean isRunning = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Finch finch = new Finch();

        showMainScreen(sc);
        if (mainScreenOption.equalsIgnoreCase("REG")) {
            finch.Registreer(FinchAuthorization(sc));
            showMainScreen(sc);
        }
        if (mainScreenOption.equalsIgnoreCase("LOG")) {
            if (finch.Login(FinchAuthorization(sc))) {
                startFinch();
            }
            System.out.println("U heeft uw gegevens verkeerd ingevoerd of geen account");
            showMainScreen(sc);
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

    private static void startFinch() {
        isRunning = true;
        while (isRunning) {
            System.out.println("working....");
        }
    }

    private static void showMainScreen(Scanner sc) {
        System.out.println("Welkom bij Finch");
        System.out.println("Registreer of Login");
        mainScreenOption = sc.next();
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
