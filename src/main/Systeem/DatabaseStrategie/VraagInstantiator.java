package Systeem.DatabaseStrategie;

import Systeem.Vragenlijst.Thema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VraagInstantiator {
    public static Map<Thema, ArrayList<InfoOpenVraag>> open = new HashMap<>();
    public static Map<Thema, ArrayList<InfoMeerkeuzeVraag>> meerkeuze = new HashMap<>();

    public static void instantiator() {
        var openVraagLijstMuziek = new ArrayList<InfoOpenVraag>();
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wanneer is metal uitgevonden?", new String[]{"1990", "negetien"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wanneer is pop uitgevonden?", new String[]{"1990", "negetien"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wanneer is klasiek uitgevonden?", new String[]{"1990", "negetien"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wie is de maker van Don't Let Me Down?", new String[]{"The Chainsmokers", "chainsmokers"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wie is de maker van Work from Home?", new String[]{"Fifth Harmony", "harmony"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wie is de maker van What Do You Mean?", new String[]{"Justin Bieber", "justin"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{"DJ Snake", "snake"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wie is de maker van All About That Bass?", new String[]{"Meghan Trainor", "trainor"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wie is de maker van Baby I?", new String[]{"Ariana Grande", "ariana"}));
        openVraagLijstMuziek.add(new InfoOpenVraag("O Wie is de maker van Cheap Thrills?", new String[]{"Sia", "Sia"}));
        open.put(Thema.MUZIEK, openVraagLijstMuziek);

        var meerkeuzeVraagLijstMuziek = new ArrayList<InfoMeerkeuzeVraag>();
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wanneer is metal uitgevonden?", new String[]{"A 1990", "B 2002","C 2004","D 1999"},"A"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wanneer is pop uitgevonden?", new String[]{"A 1990", "B 2002","C 2004","D 1999"}, "A"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wanneer is klasiek uitgevonden?", new String[]{"A 1990", "B 2002","C 2004","D 1999"}, "A"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wie is de maker van Don't Let Me Down?", new String[]{"A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "A"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wie is de maker van Work from Home?", new String[]{"A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "B"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wie is de maker van What Do You Mean?", new String[]{"A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "B"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{"A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "C"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wie is de maker van All About That Bass?", new String[]{"A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "A"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wie is de maker van Baby I?", new String[]{"A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "D"));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("M Wie is de maker van Cheap Thrills?", new String[]{"A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "D"));
        meerkeuze.put(Thema.MUZIEK, meerkeuzeVraagLijstMuziek);

        var openVraagLijstSport = new ArrayList<InfoOpenVraag>();
        openVraagLijstSport.add(new InfoOpenVraag("2O Wanneer is metal uitgevonden?", new String[]{"1990", "negetien"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wanneer is pop uitgevonden?", new String[]{"1990", "negetien"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wanneer is klasiek uitgevonden?", new String[]{"1990", "negetien"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wie is de maker van Don't Let Me Down?", new String[]{"The Chainsmokers", "chainsmokers"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wie is de maker van Work from Home?", new String[]{"Fifth Harmony", "harmony"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wie is de maker van What Do You Mean?", new String[]{"Justin Bieber", "justin"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{"DJ Snake", "snake"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wie is de maker van All About That Bass?", new String[]{"Meghan Trainor", "trainor"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wie is de maker van Baby I?", new String[]{"Ariana Grande", "ariana"}));
        openVraagLijstSport.add(new InfoOpenVraag("2O Wie is de maker van Cheap Thrills?", new String[]{"Sia", "Sia"}));
        open.put(Thema.SPORT, openVraagLijstSport);

        var meerkeuzeVraagLijstSport = new ArrayList<InfoMeerkeuzeVraag>();
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wanneer is metal uitgevonden?", new String[]{" A 1990", "B 2002","C 2004","D 1999"},"A"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wanneer is pop uitgevonden?", new String[]{" A 1990", "B 2002","C 2004","D 1999"}, "A"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wanneer is klasiek uitgevonden?", new String[]{" A 1990", "B 2002","C 2004","D 1999"}, "A"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wie is de maker van Don't Let Me Down?", new String[]{" A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "A"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wie is de maker van Work from Home?", new String[]{" A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "B"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wie is de maker van What Do You Mean?", new String[]{" A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "B"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{" A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "C"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wie is de maker van All About That Bass?", new String[]{" A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "A"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wie is de maker van Baby I?", new String[]{" A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "D"));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2M  Wie is de maker van Cheap Thrills?", new String[]{" A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "D"));
        meerkeuze.put(Thema.SPORT, meerkeuzeVraagLijstSport);
    }
}
