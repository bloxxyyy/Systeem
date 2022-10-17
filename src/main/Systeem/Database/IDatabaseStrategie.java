package Systeem.Database;

import Systeem.Vraag.IVraag;
import Systeem.Vragenlijst.Thema;

import java.util.ArrayList;

public interface IDatabaseStrategie {
    void getVragenlijsten();
    ArrayList<IVraag> getiVraags(Thema thema);
}
