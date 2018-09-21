 

import java.util.Scanner;

public class SpielLeiter
{
    
    public SpielLeiter()
    {
        
    }

    public boolean spielen()
    {
        int[] ablauf = {6,5,4,2};
        int input = 0;
        String inStr = "";

        Spiel spiel = new Spiel();
        
        System.out.print('\u000C');
        
        spiel.BetraegeImSpiel();
        spiel.zeigeKoffer();
        System.out.println("Waehle einen Koffer!");
        input = intEingabe(spiel);
        
        System.out.print('\u000C');
        spiel.kofferWaehlen(input);
        
       
        for(int i = 0; i<ablauf.length; i++){
            int anzahl = ablauf[i];
            
            System.out.println("Oeffne jetzt "+anzahl+" der verbleibenden Koffer!");
            spiel.zeigeKoffer();
            int j=0;
            while(j<anzahl){
                input = intEingabe(spiel);
                if(spiel.kofferOeffnen(input)==true)j++;
            }
            
            spiel.BetraegeImSpiel();
            spiel.angebotMachen();
            System.out.println("Willst du das Angebot annehmen? Gebe ja oder nein ein!");
            inStr = strEingabe();
            if(inStr.equals("ja")){
                System.out.println("Glueckwunsch, du hast "+spiel.auszahlen()+" Euro gewonnen!");
                return true;
            }
            
            System.out.print('\u000C');
        }
        
        System.out.print('\u000C');
        System.out.println("Oeffne jetzt die letzten verbleibenden Koffer!");
        spiel.zeigeKoffer();
        int j=0;
        while(j<2){
            input = intEingabe(spiel);
            if(spiel.kofferOeffnen(input)==true)j++;
        }
            
        System.out.println("Glueckwunsch, du hast "+spiel.auszahlen()+" Euro gewonnen!");

        return true;
    }
    
    private int intEingabe(Spiel spiel)
    {
        Scanner input = new Scanner (System.in);
        
        int auswahl;
        auswahl = 0;
        boolean guteEingabe;
        guteEingabe = false;
        while(guteEingabe == false){
            try{
                auswahl = input.nextInt();
                if(auswahl >=0 && auswahl < spiel.kofferAnzahl()){
                    guteEingabe = true;
                }
                else{
                    System.out.println("Gebe ein Zahl zwischen 0 und "+spiel.kofferAnzahl()+" ein!");
                    guteEingabe = false;
                }
            }catch(Exception e){
                System.out.println("Gebe ein Zahl zwischen 0 und "+spiel.kofferAnzahl()+" ein!");
                input.nextLine();
            }
        }
        return auswahl;
    }
    
    private String strEingabe()
    {
        Scanner input = new Scanner (System.in);
        
        String auswahl;
        auswahl = "";
        boolean guteEingabe;
        guteEingabe = false;
        while(guteEingabe == false){
            try{
                auswahl = input.next();
                if(auswahl.equals("ja") || auswahl.equals("nein")){
                    guteEingabe = true;
                }
                else{
                    System.out.println("Gebe ja oder nein ein!");
                    guteEingabe = false;
                }
            }catch(Exception e){
                System.out.println("Gebe ja oder nein ein!");
                input.nextLine();
            }
        }
        return auswahl;
    }
}
