package Systeem;

import Systeem.Vragenlijst.Vragenlijst;

import java.util.Random;

import static Systeem.DatabaseStrategie.DutchDatabaseStragie.VragenlijstList;

public class FinchShop {
    public Vragenlijst[] krijgCadeau() {
        return new Random()
                .ints(0, VragenlijstList.size())
                .distinct()
                .limit(2)
                .mapToObj(VragenlijstList::get).toArray(Vragenlijst[]::new);
    }
}
