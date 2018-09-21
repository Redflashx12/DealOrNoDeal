
public class Koffer
{
    
    private int inhalt;
    private boolean offen;


    public Koffer(int betrag)
    {
        inhalt = betrag;
        offen = false;
    }

    public int oeffnen()
    {
        offen = true;
        return inhalt;
    }
    
    public boolean istOffen()
    {
        return offen;
    }
}
