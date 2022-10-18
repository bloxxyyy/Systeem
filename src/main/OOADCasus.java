import Systeem.DatabaseStrategie.DutchDatabaseStragie;
import Systeem.Finch;
import Systeem.Vragenlijst.SpelerVragenlijst;

import java.time.Duration;
import java.time.Instant;
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
            SpelerVragenlijst vragenlijst = kiezenOnderwerpBijThema(sc, finch);

            initializerenQuiz(finch, vragenlijst);

            Instant start = Instant.now();
            spelenQuiz(sc, finch);
            Instant end = Instant.now();

            eindigenQuiz(finch, vragenlijst, start, end);
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

    private static SpelerVragenlijst kiezenOnderwerpBijThema(Scanner sc, Finch finch) {
        System.out.println("Selecteer uw vragenlijst bij onderwerp");

        var lijsten = finch.getLijsten();
        for (int i = 0; i < lijsten.size(); i++) {
            System.out.println(i + ": " + finch.getOnderwerp(lijsten.get(i)));
        }

        return finch.getVragenlijst(sc.nextInt());
    }

    private static void initializerenQuiz(Finch finch, SpelerVragenlijst vragenlijst) {
        finch.createQuiz(vragenlijst);
        System.out.println("CurrentLifetimebest: " + finch.getLifetimeBest(vragenlijst));
    }

    private static void eindigenQuiz(Finch finch, SpelerVragenlijst vragenlijst, Instant start, Instant end) {
        finch.updateVerstrekenTijd((int) Duration.between(start, end).toSeconds());

        var score = finch.checkScore();
        finch.updateLifetimeBest(vragenlijst, score);
        System.out.println("Gehaalde Score: " + score);
        System.out.println("Quiz Tijd: " + finch.getVerstrekenTijd() + " seconden");
        System.out.println("Lifetime best: " + finch.getLifetimeBest(vragenlijst));
    }

    private static void spelenQuiz(Scanner sc, Finch finch) {
        for (int i = 0; i < finch.getVraaglistLength(); i++) {
            System.out.println(finch.getvolgendeVraag());
            finch.beantwoordVolgendeVraag(sc.next());
        }
    }

    private static String[] authenticatie(Scanner sc) {
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
