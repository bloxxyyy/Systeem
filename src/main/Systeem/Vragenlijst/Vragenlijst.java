package Systeem.Vragenlijst;

import Systeem.Vraag.IVraag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Vragenlijst {
    private String onderwerp;
    private int prijs;
    private int geldigheid = 1;
    private Thema thema;
    private ArrayList<IVraag> vraagList = new ArrayList<>();

    public Vragenlijst(Thema thema, ArrayList<IVraag> vragen, String onderwerp){
        this.thema = thema;
        this.vraagList = vragen;
        this.onderwerp = onderwerp;
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
