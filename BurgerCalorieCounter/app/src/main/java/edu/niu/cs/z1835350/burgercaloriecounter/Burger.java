package edu.niu.cs.z1835350.burgercaloriecounter;

public class Burger {
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    final static int ASIAGO = 90;
    final static int PROVOLONE = 120;
    final static int PROSCIUTTO = 115;
    private int pattyCal, cheeseCal, prosciuttoCal, sauceCal;
    public Burger() {
        pattyCal = BEEF;
        cheeseCal = ASIAGO;
        prosciuttoCal = 0;
        sauceCal = 0;
    }//end constructor

    public void setPattyCal(int pattyCal) {
        this.pattyCal = pattyCal;
    }

    public void setCheeseCal(int cheeseCal) {
        this.cheeseCal = cheeseCal;
    }

    public void setProsciuttoCal(int prosciuttoCal) {
        this.prosciuttoCal = prosciuttoCal;
    }

    public void setSauceCal(int sauceCal) {
        this.sauceCal = sauceCal;
    }
    public void clearProsciuttoCalories(){
        prosciuttoCal = 0;

    }
    public  int getTotalCalories(){
        return pattyCal + cheeseCal + prosciuttoCal + sauceCal;
    }
}
