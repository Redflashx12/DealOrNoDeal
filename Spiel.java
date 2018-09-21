
import java.util.Random;
public class Spiel
{

    private Koffer[] koffer;
    private int[] betraege = {1,2,5,10,20,50,100,250,500,750,1000,2500,5000,10000,20000,25000,50000,100000,150000,250000};
    private int[] nochImSpiel;

    private int gewinn =0;
    private double angebot =0;

    //Konstruktor
    public Spiel()
    {          
        koffer = new Koffer[20];

        nochImSpiel = betraege.clone();  //Kopiert die Eintraege von betraege nach nochImSpiel

        //Die Betraege werden zufaellig auf die 20 Koffer verteilt
        int[] a;
        a = new int[20];
        a = betraege.clone(); 

        Random random;
        random = new Random();

        for(int i=0; i<koffer.length; i++)
        {
            int j;
            j = random.nextInt(20);
            while(a[j] == 0) {
                j = random.nextInt(20);
            }
            koffer[i] = new Koffer(a[j]);
            a[j] = 0;
        }
    }

    //Oeffnet den angegebenen Koffer und loescht den gefundenen Betrag aus dem Feld betraege (der Wert wird durch 0 ersetzt).
    public boolean kofferOeffnen(int x)
    {
        boolean erfolgreich;
        erfolgreich = false;
        if(0 <= x && x < koffer.length){
            if(koffer[x].istOffen()){
                System.out.println("Dieser Koffer ist schon offen.");
            }
            else{
                int betrag = koffer[x].oeffnen();
                System.out.println("Der Koffer enthaelt "+betrag+" Euro");
                erfolgreich = true;

                for(int i=0; i<nochImSpiel.length; i++){
                    if(betrag == nochImSpiel[i]) nochImSpiel[i] = 0;
                }

            }
        }  
        return erfolgreich;
    }

    //Gibt das Feld nochImSpiel aus.
    public void BetraegeImSpiel()
    {
        System.out.println("Betraege im Spiel: ");
        for(int i=0; i<nochImSpiel.length; i++){
            if(nochImSpiel[i] != 0) System.out.print(nochImSpiel[i]+", ");
        }
        System.out.println("");
    }

    //Gibt zu allen Koffern an, ob sie bereits geoeffnet wurden.
    public void zeigeKoffer()
    {
        System.out.println("Koffer im Spiel: ");
        for(int i=0; i<koffer.length; i++){
            System.out.print(i+" ");
        }
        System.out.println("");
        for(int i=0; i<koffer.length; i++){
            if(i > 9) System.out.print(" ");
            if(koffer[i].istOffen()) System.out.print("O ");
            else System.out.print("X ");
        }
        System.out.println("");
    }

    //Hier wird der erste Koffer, also der Gewinnkoffer gewaehlt
    public void kofferWaehlen(int x)
    {
        gewinn = koffer[x].oeffnen();
        System.out.println("Du hast Koffer "+x+" gewaehlt");
    }

    //Gibt die Groeße des Feldes koffer zurueck.
    public int kofferAnzahl()
    {
        return koffer.length;
    }

    //Der Spieler akzeptiert entwerder ein Angebot der Bank oder erhaelt den Inhalt seines Koffers.
    public double auszahlen()
    {
        int verbleibendeKoffer = 0;
        for(int i=0; i<koffer.length; i++){
            if(!koffer[i].istOffen()) verbleibendeKoffer++;
        }
        if(verbleibendeKoffer == 0) return gewinn;
        return angebot;
    }

    
    //Die Bank bietet dem Spieler einen Betrag, zu dem er aussteigen kann.
    public void angebotMachen()
    {
        //Ersetzte angbotBerechnen1() durch angebotBerechnen2() oder angebotBerechnen3()
        angebot = angebotBerechnen3();

        System.out.println("Die Bank bietet dir "+angebot+" Euro.");
    }

    //Berechnung des angebotenen Betrags
    public int angebotBerechnen1()
    {
        int offen=0;
        for(int i = 0; i<koffer.length;i++){
            if(koffer[i].istOffen()==false){
                offen++;
            }

        }
        offen=offen*10000;
        return offen;
    }

    public double angebotBerechnen2()
    {
        double mittelWert=0;
        for(int i = 0;i<nochImSpiel.length;i++) {
            mittelWert=mittelWert+nochImSpiel[i];

        }
        mittelWert=mittelWert/nochImSpiel.length;
        return mittelWert;
    }

    public double angebotBerechnen3()
    {
        double mittelWert=0;
        int anzahl=0;
        for(int i = 0;i<nochImSpiel.length;i++) {
            if(nochImSpiel[i]!=0){
                mittelWert=mittelWert+nochImSpiel[i];
                anzahl++;

            }
        }
        mittelWert=mittelWert/anzahl;
        return mittelWert;
    }

}
