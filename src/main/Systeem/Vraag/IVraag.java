package Systeem.Vraag;

import java.util.List;

public interface IVraag {
    public void setQuizVraagAntwoord(QuizVraagAntwoord quizVraagAntwoord);
    public int getPunten();
    public String getVraagtekst();
    public List<String> getCorrectAntwoordList();
}
