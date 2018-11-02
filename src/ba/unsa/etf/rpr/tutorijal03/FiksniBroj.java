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
        BIHAC("037"), ORASJE("031"), TUZLA("035"), ZENICA("032"), GORAZDE("038"), TRAVNIK("030"), MOSTAR("036"), SIROKI_BRIJEG("039"), SARAJEVO("033"), LIVNO("034"), BRCKO("049");

        private String pozivni_broj;

        private Grad(String s)  //kostruktor enuma ne moze primati enum
        {
            pozivni_broj = s;
        }

        public String getPozivniBroj()
        {
            return pozivni_broj;
        }
    }



    private Grad g;
    private String broj;

    public Grad getGrad()
    {
        return g;
    }

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
