import Systeem.DatabaseStrategie.DutchDatabaseStragie;
import Systeem.Finch;
import java.util.Scanner;

public class OOADCasus {

    public static void main(String[] args) {
        System.out.println("Welkom bij Finch");

        Scanner sc = new Scanner(System.in);
        Finch finch = new Finch(new DutchDatabaseStragie());

        boolean isLoggedin = false;
        while (!isLoggedin) {
            System.out.println("[REG] Registreer of [LOG] Login");

            String mainScreenOption = sc.next();
            var input = authenticatie(sc);

            checkRegister(finch, mainScreenOption, input);
            isLoggedin = checkLogin(finch, mainScreenOption, input);
        }

        while (true) {
            var lijsten = finch.aanvraagSpelenQuiz(gebruikersnaam);
            for (var i = 0; i < lijsten.length; i++) {
                System.out.println(i + " : " + lijsten[i]);
            }

            String spelerVragenlijstIds = sc.next();

            finch.geefKeuzeVragenlijst(spelerVragenlijstIds, gebruikersnaam);
            var vraagTexten = finch.startQuiz(gebruikersnaam);

            for (String text : vraagTexten) {
                System.out.println(text);
                finch.beantwoordVolgendeVraag(sc.next(), text, gebruikersnaam);
            }

            var score = finch.eindigQuiz(gebruikersnaam, spelerVragenlijstIds);
            System.out.println("score: " +  score);
        }
    }

    private static void checkRegister(Finch finch, String mainScreenOption, String[] input) {
        if (!mainScreenOption.equalsIgnoreCase("REG")) return;

        if (!finch.registreer(input)) {
            System.out.println("Deze gebruikersnaam bestaat al");
        }
    }

    private static boolean checkLogin(Finch finch, String mainScreenOption, String[] input) {
        if (!mainScreenOption.equalsIgnoreCase("LOG")) return false;

        if (!finch.login(input)) {
            System.out.println("U heeft uw gegevens verkeerd ingevoerd of geen account");
            return false;
        }

        return true;
    }

    static String gebruikersnaam = "";
    private static String[] authenticatie(Scanner sc) {
        String[] account = new String[2];
        System.out.println("Uw gebruikersnaam:");
        String gebruikersnaam = sc.next();
        account[0] = gebruikersnaam;
        gebruikersnaam = gebruikersnaam;
        System.out.println("Uw wachtwoord:");
        String wachtwoord = sc.next();
        account[1] = wachtwoord;

        return account;
    }
}
