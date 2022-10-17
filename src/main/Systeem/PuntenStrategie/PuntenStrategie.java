package Systeem.PuntenStrategie;

public class PuntenStrategie implements IPuntenStrategie {
    @Override
    public int getOpenVraagPunten() {
        return 2;
    }

    @Override
    public int getMeerkeuzeVraagPunten() {
        return 4;
    }
}
