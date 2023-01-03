import Systeem.DatabaseStrategie.DutchDatabaseStragie;
import Systeem.Finch;

import java.util.Arrays;
import java.util.Scanner;

public class OOADCasus {
    static String gebruikersnaam = "";

    public static void main(String[] args) {
        System.out.println("Welkom bij Finch");

        Scanner sc = new Scanner(System.in);
        Finch finch = new Finch(new DutchDatabaseStragie());

        boolean isLoggedin = false;
        while (!isLoggedin) {
            System.out.println("[REG] Registreer of [LOG] Login");

            String mainScreenOption = sc.next();
            // index 0: gebruikersnaam, index 1: wachtwoord
            String[] account = new String[2];

            if (mainScreenOption.equalsIgnoreCase("REG")) {
                String[] gegevens = finch.aangevenRegistreren();
                for (int i = 0; i < gegevens.length; i++) {
                    System.out.println(gegevens[i]);
                    account[i] = sc.next();
                }
                finch.geefGegevens(account[0], account[1]);
            }

            if (mainScreenOption.equalsIgnoreCase("LOG")) {
                String[] gegevens = finch.aangevenRegistreren();
                for (int i = 0; i < gegevens.length; i++) {
                    System.out.println(gegevens[i]);
                    account[i] = sc.next();
                }
                isLoggedin = finch.login(account[0], account[1]);
            }

            gebruikersnaam = account[0];
        }

        while (true) {
            var lijsten = finch.aanvraagSpelenQuiz(gebruikersnaam);
            for (var i = 0; i < lijsten.length; i++) {
                System.out.println(i + " : " + lijsten[i]);
            }

            String spelerVragenlijstIds = sc.next();

            finch.geefKeuzeVragenlijst(lijsten[Integer.parseInt(spelerVragenlijstIds)], gebruikersnaam);
            var vraagTexten = finch.startQuiz(gebruikersnaam);

            for (String text : vraagTexten) {
                System.out.println(text);
                finch.beantwoordVolgendeVraag(sc.next(), text, gebruikersnaam);
            }

            var score = finch.eindigQuiz(gebruikersnaam, lijsten[Integer.parseInt(spelerVragenlijstIds)]);
            System.out.println("score: " + score);
        }
    }
}
