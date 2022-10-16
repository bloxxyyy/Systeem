package Systeem;

import Systeem.Vraag.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FinchShop {
    private List<Vragenlijst> VragenlijstList;

    public FinchShop() {
        VragenlijstList = new ArrayList<>();
        var VragenList = new ArrayList<IVraag>();
        for(int i = 0; i < 20; i++) {
            var correctList = new ArrayList<CorrectAntwoord>();
            correctList.add(new CorrectAntwoord("iets"));
            VragenList.add(new OpenVraag(1, "Wie is piet?", correctList));

            var antwoordenList = new ArrayList<AntwoordKeuze>();
            antwoordenList.add(new AntwoordKeuze("A: test"));

            var correctList2 = new ArrayList<CorrectAntwoord>();
            correctList2.add(new CorrectAntwoord("A"));

            VragenList.add(new MeerkeuzeVraag(1, "Wat is piet?", correctList2, antwoordenList));
        }

        VragenlijstList.add(new Vragenlijst(VragenList, new Thema("Muziek")));
        VragenlijstList.add(new Vragenlijst(VragenList, new Thema("Sport")));
    }

    public Vragenlijst krijgCadeau() {
        return new Random()
            .ints(0, VragenlijstList.size())
            .distinct()
            .limit(1)
            .mapToObj(VragenlijstList::get).toList().get(0);
    }
}
