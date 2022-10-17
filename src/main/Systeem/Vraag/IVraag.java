package Systeem.Vraag;

import java.util.List;

public interface IVraag {
    public void setQuizVraagAntwoord(QuizVraagAntwoord quizVraagAntwoord);
    public int getPunten();
    public void setPunten(int punten);
    public String getVraagtekst();
    public void setVraagtekst(String vraagtekst);
    public QuizVraagAntwoord getQuizVraagAntwoord();
    public List<String> getCorrectAntwoordList();
}
