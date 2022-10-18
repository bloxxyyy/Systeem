package Systeem.DatabaseStrategie;

import Systeem.PuntenStrategie.PuntenStrategie;
import Systeem.Vraag.*;
import Systeem.Vragenlijst.Thema;
import Systeem.Vragenlijst.Vragenlijst;

import java.util.*;

public class DutchDatabaseStragie implements IDatabaseStrategie {
    public static ArrayList<Vragenlijst> VragenlijstList = new ArrayList<>();

    @Override
    public void getVragenlijsten() {
        VraagInstantiator.instantiator();
        VragenlijstList.add(new Vragenlijst(Thema.MUZIEK,getiVraags(Thema.MUZIEK), "dance"));
        VragenlijstList.add(new Vragenlijst(Thema.SPORT ,getiVraags(Thema.SPORT), "voetbal"));
    }

    @Override
    public ArrayList<IVraag> getiVraags(Thema thema) {
        var openLijst = VraagInstantiator.open;
        var meerkeuzeLijst = VraagInstantiator.meerkeuze;

        var InfoOpen = openLijst.get(thema);
        var InfoMeerkeuze = meerkeuzeLijst.get(thema);

        var VragenList = new ArrayList<IVraag>();
        for (var themaInfo : InfoOpen) {
            VragenList.add(new OpenVraag(new PuntenStrategie(), themaInfo.title(), Arrays.stream(themaInfo.antwoorden()).toList()));
        }

        for (var themaInfo2 : InfoMeerkeuze) {
            VragenList.add(new MeerkeuzeVraag(new PuntenStrategie(), themaInfo2.title(), themaInfo2.correctAntwoord(), Arrays.stream(themaInfo2.antwoorden()).toList()));
        }
        return VragenList;
    }
}

