package Systeem.PuntenStrategie;

public class BonusPuntenStrategie implements IBonusPuntenStrategie {

    @Override
    public int calculateBonusPunten(int tijd) {
        return tijd/5;
    }
}
