package Systeem;

import Systeem.Vraag.IVraag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Vragenlijst {
    private SpelerVragenlijst spelerVragenlijst;
    private ArrayList<IVraag> vraagList;

    private Thema thema;

    public Vragenlijst(ArrayList<IVraag> vraagList, Thema thema) {
        this.vraagList = vraagList;
        this.thema = thema;
    }

    public Thema getThema() {
        return thema;
    }

    public void setSpelerVragenlijst(SpelerVragenlijst spelerVragenlijst) {
        this.spelerVragenlijst = spelerVragenlijst;
    }

    public SpelerVragenlijst getSpelerVragenlijst() {
        return spelerVragenlijst;
    }

    public List<IVraag> getVraagList() {
        return vraagList;
    }

    public List<IVraag> getRandomVragen() {
        return new Random()
            .ints(0, vraagList.size())
            .distinct() // ensure all the ids are different
            .limit(3)
            .mapToObj(vraagList::get)
            .collect(Collectors.toList());
    }
}
