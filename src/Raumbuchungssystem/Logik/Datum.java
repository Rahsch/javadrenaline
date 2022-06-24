package Raumbuchungssystem.Logik;

import java.io.Serializable;

public class Datum implements Serializable
{
    private int tag;
    private int monat;
    private int jahr;


    public Datum(int pTag, int pMonat, int pJahr) {
        tag =pTag;
        monat = pMonat;
        jahr = pJahr;

        boolean pruefung=pruefeDatum(this.tag, this.monat, this.jahr);
    }

    public int getTag()
    {
        return this.tag;
    }

    public int getMonat()
    {
        return this.monat;
    }

    public int getJahr()
    {
        return this.jahr;
    }

    /**
     * Gibt Datum zurück
     * @return
     */
    public String getDate ()
    {
        String gesamtzahl = tag+"."+monat+"."+jahr;
        return gesamtzahl;
    }

    /**
     * Gibt Datum zurück als eine Zahl zum vergleichen für die Buchungen usw.
     * JahrMonatTag
     * @return
     */
    public int getDateComp ()
    {
        int gesamtzahl = tag + monat*100 +jahr*10000;
        return gesamtzahl;
    }


    /**
     * Ein Jahr ist ein Schaltjahr, wenn die Jahreszahl durch 4 teilbar ist.
     * wenn die Jahreszahl durch 4, aber nicht durch 100 teilbar ist. wenn die
     * Jahreszahl durch 4, durch 100 und durch 400 teilbar ist.
     */
    public static boolean isSchaltjahr(int jahr)
    {
        if (jahr % 4 == 0) {
            if (jahr % 100 == 0 && jahr % 400 == 0) {
                return true;
            } else {
                if (jahr % 100 == 0 && jahr % 400 != 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Gibt die Anzahl der Monatstage zurück
     * @param monat
     * @param jahr
     * @return
     */
    public static int getMaxTage(int monat, int jahr){
        int anzTage=0;

        switch(monat){
            //Monate mit 31 Tagen
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                anzTage =31;
                break;

            //Monate mit 30 Tagen
            case 4:
            case 6:
            case 9:
            case 11:
                anzTage =30;
                break;

            //Prüfen ob Schaltjahr wegen dem Februar
            case 2:
                boolean schaltjahr= isSchaltjahr(jahr);
                if(schaltjahr==false){
                    anzTage=28;
                }
                else{
                    anzTage=29;
                }
                break;
            default:
                System.out.println("Bitte machen Sie korrekte Angaben");
        }
        return (anzTage);
    }

    /**
     * Prüft ob das Datum funktioniert
     * @param tag
     * @param monat
     * @param jahr
     * @return
     */
    public boolean pruefeDatum(int tag, int monat, int jahr)
    {
        boolean b;
        switch (monat){

            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(tag>=1&&tag<=31){
                    b=true;
                }
                else{
                    System.out.println("Bitte machen Sie korrekte Angaben!");
                    b=false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(tag>=1&&tag<=30){
                    b=true;
                }
                else{
                    System.out.println("Bitte machen Sie korrekte Angaben!");
                    b=false;
                }
                break;
            case 2:
                boolean schaltjahr= isSchaltjahr(jahr);
                if(schaltjahr==false){
                    if(tag>=1&&tag<=28){
                        b=true;
                    }
                    else{
                        System.out.println("Bitte machen Sie korrekte Angaben!");
                        b=false;
                    }
                }
                else{
                    if(tag>=1&&tag<=29){
                        b=true;
                    }
                    else{
                        System.out.println("Bitte machen Sie korrekte Angaben!");
                        b=false;
                    }
                }
                break;
            default:
                System.out.println("Bitte machen Sie korrekte Angaben!");
                b=false;
        }
        return(b);
    }

}
