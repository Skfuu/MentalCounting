package com.example.mentalcounting;

//import fr.katycorp.utils.fragments.SimpleDialog;

public class ScoreBDD {
    private static int nboperations = 0;
    private static int nbtentatives = 0;
    private static String derniereOperation = "";

    public static int getNboperations(){return nboperations;}

    public static String getDerniereOperation(){return derniereOperation;}

    public static void setDerniereOperation(String _dernierOperation){derniereOperation = _dernierOperation;}

    public static void nouvelleOperation(){nboperations++;}

    public static void nouvelleTentative(){nbtentatives++;}

    public static double Pourcentage(){
        if(nbtentatives==0){
            return 0;
        }
        return((double)nboperations*100/nbtentatives);
    }

    public static void ResetScore()
    {
        nboperations = 0;
        nbtentatives = 0;
        derniereOperation = "";
    }



}
