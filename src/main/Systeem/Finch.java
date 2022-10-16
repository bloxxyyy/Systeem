package Systeem;

import java.util.Scanner;

public class Finch {
    private Account account;
    private FinchShop finchShop;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Finch finch = new Finch(new FinchShop());

        // Spelen Quiz
        finch.Login("root", "pass");

        var cadeau = new SpelerVragenlijst(finch.account, finch.finchShop.krijgCadeau());
        finch.account.OntvangCadeau(cadeau); // register func
        var cadeau2 = new SpelerVragenlijst(finch.account, finch.finchShop.krijgCadeau());
        finch.account.OntvangCadeau(cadeau2); // register func

        boolean isRunning = true;

        while(isRunning) {
            // toon thema's
            var hashset = finch.account.getThemasBijVragenlijsten();
            Thema[] themas = finch.account.getThemasBijVragenlijsten().toArray(new Thema[hashset.size()]);
            for (int i = 0; i < themas.length; i++) {
                System.out.println(i + ": " + themas[i].getName());
            }

            var choice = sc.nextInt();
            var thema = themas[choice];

            var lijsten = finch.account.toonVragenlijstenBijthema(thema);
            for (int i = 0; i < lijsten.size(); i++) {
                System.out.println(i + ": " + lijsten.get(i));
            }

            var choice2 = sc.nextInt();
            var vragenlijst = finch.account.getSpelerVragenlijst(lijsten.get(choice2));

            finch.account.maakQuizMetVragen(vragenlijst);

            System.out.println("CurrentLifetimebest: " + finch.account.getSpelerVragenlijst(vragenlijst).getLifetimeBest());

            finch.speelQuiz(sc, vragenlijst);

            // End Spelen Quiz
        }
    }

    public Finch(FinchShop finchShop) {
        this.finchShop = finchShop;
    }

    public void Login(String username, String password) {
        account = new Account(username, password);
    }

    public void speelQuiz(Scanner sc, SpelerVragenlijst keuze) {
        for (int i = 0; i < account.getQuiz().getVraagList().size(); i++) {
            var vraag = account.getQuiz().getVolgendeVraagTekst();
            System.out.println(vraag);
            var givenAnswer = sc.next();
            account.getQuiz().beantwoordVolgendeVraag(givenAnswer);
        }

        var score = account.checkScore();

        var spelerVragenlijst = account.getSpelerVragenlijst(keuze);

        spelerVragenlijst.updateLifetimeBest(score);
        System.out.println("Gehaalde Score: " + score);
        System.out.println("Lifetime best: " + spelerVragenlijst.getLifetimeBest());
    }
}
