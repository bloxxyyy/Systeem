package Systeem;

public class GespeeldeQuiz {

    private Quiz quiz;
    private Account account;

    private int punten;

    private long verstrekenTijd;

    public GespeeldeQuiz(Quiz quiz, Account account, long verstrekenTijd) {
        this.quiz = quiz;
        this.account = account;
        this.verstrekenTijd = verstrekenTijd;
    }

    public int getPunten() {
        return punten;
    }

    public void setPunten(int punten) {
        this.punten = punten;
    }

    public void addPunten(int punten) {
        this.punten += punten;
    }
}
