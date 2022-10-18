package Systeem.Vragenlijst;

import Systeem.Vraag.IVraag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Vragenlijst {
    private String onderwerp;
    private ArrayList<IVraag> vraagList;

    public Vragenlijst(ArrayList<IVraag> vragen, String onderwerp){
        this.vraagList = vragen;
        this.onderwerp = onderwerp;
    }

    public List<IVraag> getRandomVragen() {
        return new Random()
                .ints(0, vraagList.size())
                .distinct() // ensure all the ids are different
                .limit(10)
                .mapToObj(vraagList::get)
                .collect(Collectors.toList());
    }
    public String getOnderwerp() {
        return onderwerp;
    }
}
