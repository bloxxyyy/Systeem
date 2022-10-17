package Systeem;

import Systeem.Vragenlijst.Thema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

record InfoOpenVraag (String title, String[] antwoorden, int punten) { }
record InfoMeerkeuzeVraag (String title, String[] antwoorden, String correctAntwoord, int punten) { }

public class VraagInstantiator {
    public static Map<Thema, ArrayList<InfoOpenVraag>> open = new HashMap<>();
    public static Map<Thema, ArrayList<InfoMeerkeuzeVraag>> meerkeuze = new HashMap<>();

    public static void instantiator() {
        var openVraagLijstMuziek = new ArrayList<InfoOpenVraag>();
        openVraagLijstMuziek.add(new InfoOpenVraag("Wanneer is metal uitgevonden?", new String[]{"1990", "negetien"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wanneer is pop uitgevonden?", new String[]{"1990", "negetien"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wanneer is klasiek uitgevonden?", new String[]{"1990", "negetien"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wie is de maker van Don't Let Me Down?", new String[]{"The Chainsmokers", "chainsmokers"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wie is de maker van Work from Home?", new String[]{"Fifth Harmony", "harmony"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wie is de maker van What Do You Mean?", new String[]{"Justin Bieber", "justin"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{"DJ Snake", "snake"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wie is de maker van All About That Bass?", new String[]{"Meghan Trainor", "trainor"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wie is de maker van Baby I?", new String[]{"Ariana Grande", "ariana"}, 1));
        openVraagLijstMuziek.add(new InfoOpenVraag("Wie is de maker van Cheap Thrills?", new String[]{"Sia", "Sia"}, 1));
        open.put(Thema.Muziek, openVraagLijstMuziek);

        var meerkeuzeVraagLijstMuziek = new ArrayList<InfoMeerkeuzeVraag>();
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wanneer is metal uitgevonden?", new String[]{"A 1990", "B 2002","C 2004","D 1999"},"A", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wanneer is pop uitgevonden?", new String[]{"A 1990", "B 2002","C 2004","D 1999"}, "A", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wanneer is klasiek uitgevonden?", new String[]{"A 1990", "B 2002","C 2004","D 1999"}, "A", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wie is de maker van Don't Let Me Down?", new String[]{"A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "A", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wie is de maker van Work from Home?", new String[]{"A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "B", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wie is de maker van What Do You Mean?", new String[]{"A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "B", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{"A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "C", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wie is de maker van All About That Bass?", new String[]{"A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "A", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wie is de maker van Baby I?", new String[]{"A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "D", 1));
        meerkeuzeVraagLijstMuziek.add(new InfoMeerkeuzeVraag("Wie is de maker van Cheap Thrills?", new String[]{"A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "D", 1));
        meerkeuze.put(Thema.Muziek, meerkeuzeVraagLijstMuziek);

        var openVraagLijstSport = new ArrayList<InfoOpenVraag>();
        openVraagLijstSport.add(new InfoOpenVraag("2 Wanneer is metal uitgevonden?", new String[]{"1990", "negetien"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wanneer is pop uitgevonden?", new String[]{"1990", "negetien"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wanneer is klasiek uitgevonden?", new String[]{"1990", "negetien"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wie is de maker van Don't Let Me Down?", new String[]{"The Chainsmokers", "chainsmokers"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wie is de maker van Work from Home?", new String[]{"Fifth Harmony", "harmony"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wie is de maker van What Do You Mean?", new String[]{"Justin Bieber", "justin"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{"DJ Snake", "snake"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wie is de maker van All About That Bass?", new String[]{"Meghan Trainor", "trainor"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wie is de maker van Baby I?", new String[]{"Ariana Grande", "ariana"}, 1));
        openVraagLijstSport.add(new InfoOpenVraag("2 Wie is de maker van Cheap Thrills?", new String[]{"Sia", "Sia"}, 1));
        open.put(Thema.SPORT, openVraagLijstSport);

        var meerkeuzeVraagLijstSport = new ArrayList<InfoMeerkeuzeVraag>();
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wanneer is metal uitgevonden?", new String[]{" A 1990", "B 2002","C 2004","D 1999"},"A", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wanneer is pop uitgevonden?", new String[]{" A 1990", "B 2002","C 2004","D 1999"}, "A", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wanneer is klasiek uitgevonden?", new String[]{" A 1990", "B 2002","C 2004","D 1999"}, "A", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wie is de maker van Don't Let Me Down?", new String[]{"The Chainsmokers", "chainsmokers"}, "A", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wie is de maker van Work from Home?", new String[]{" A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "B", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wie is de maker van What Do You Mean?", new String[]{" A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "B", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wie is de maker van Let Me Love You ft. Justin Bieber?", new String[]{" A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "C", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wie is de maker van All About That Bass?", new String[]{" A Meghan Trainor", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "A", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wie is de maker van Baby I?", new String[]{" A The Chainsmokers", "B Fifth Harmony","C DJ Snake","D Ariana Grande"}, "D", 1));
        meerkeuzeVraagLijstSport.add(new InfoMeerkeuzeVraag("2 Wie is de maker van Cheap Thrills?", new String[]{" A The Chainsmokers", "B Justin Bieber","C DJ Snake","D Sia"}, "D", 1));
        meerkeuze.put(Thema.SPORT, meerkeuzeVraagLijstSport);
    }
}
