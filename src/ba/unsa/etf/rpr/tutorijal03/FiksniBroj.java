/*
FiksniBroj sadrži konstruktor FiksniBroj(Grad grad, String broj). Parametar broj je dio telefonskog broja bez pozivnog
broja npr. \"123-456\", a grad je promjenljiva pobrojanog tipa koji označava pozivni broj koji treba koristiti npr.:\n
enum Grad { SARAJEVO, TUZLA, ZENICA…}\*/

/*Bihac-037, Orasje-031, Tuzla-035, Zenica-032, Gorazde-038, Travnik-030, Mostar-036, Široki Brijeg-039, Sarajevo-033, Livno-034, Brcko- 049 */

package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj
{
    public enum Grad
    {
        BIHAC, ORASJE, TUZLA, ZENICA, GORAZDE, TRAVNIK, MOSTAR, SIROKI_BRIJEG, SARAJEVO, LIVNO, BRCKO;
    }

    private Grad g;
    private String broj;

    public FiksniBroj(Grad grad, String broj)
    {
        g = grad;
        this.broj = broj;
    }

    @Override
    public String ispisi()
    {
        String novi= this.g.toString();

        if(novi.equals("BIHAC"))
            novi= "037/";
        else if(novi.equals("ORASJE"))
            novi="031/";
        else if(novi.equals("TUZLA"))
            novi="035/";
        else if(novi.equals("ZENICA"))
            novi="032/";
        else if(novi.equals("GORAZDE"))
            novi="038/";
        else if(novi.equals("TRAVNIK"))
            novi="030/";
        else if(novi.equals("MOSTAR"))
            novi="036/";
        else if(novi.equals("SIROKI_BRIJEG"))
            novi="039/";
        else if(novi.equals("SARAJEVO"))
            novi="033/";
        else if(novi.equals("LIVNO"))
            novi="034/";
        else if(novi.equals("BRCKO"))
            novi="049/";

        novi+=this.broj;

        return novi;
    }
}
