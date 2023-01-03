package Systeem.PuntenStrategie;

public class BonusPuntenStrategie implements IBonusPuntenStrategie {

    @Override
    public int calculate(int tijd) {
        return tijd/5;
    }

    @Override
    public int getPuntenAlleVragenGoed() {
        return 5;
    }
}
