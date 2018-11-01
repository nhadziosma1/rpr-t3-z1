/*
FiksniBroj sadrži konstruktor FiksniBroj(Grad grad, String broj). Parametar broj je dio telefonskog broja bez pozivnog
broja npr. \"123-456\", a grad je promjenljiva pobrojanog tipa koji označava pozivni broj koji treba koristiti npr.:\n
enum Grad { SARAJEVO, TUZLA, ZENICA…}\*/

/*Bihac-037, Orasje-031, Tuzla-035, Zenica-032, Gorazde-038, Travnik-030, Mostar-036, Široki Brijeg-039, Sarajevo-033, Livno-034, Brcko- 049 */

package ba.unsa.etf.rpr.tutorijal03;

public class FiksniBroj extends TelefonskiBroj
{
    private Grad g;
    private String broj;

     public FiksniBroj(Grad grad, String broj)
    {
        g = grad;
        this.broj = broj;
    }

    /*@Override
    public Object clone()
    {
        FiksniBroj novi = (FiksniBroj) super.clone();   //ne kontam zasto se stavlja super, super daje tip Object?????
        novi.g = this.g.clone();
        return novi;
    }*/

    @Override
    public String ispisi()
    {
        String novi=null;

        if(this.g.equals("BIHAC"))
            novi= "037/";
        else if(this.g.equals("ORASJE"))
            novi="031/";
        else if(this.g.equals("TUZLA"))
            novi="035/";
        else if(this.g.equals("ZENICA"))
            novi="032/";
        else if(this.g.equals("GORAZDE"))
            novi="038/";
        else if(this.g.equals("TRAVNIK"))
            novi="030/";
        else if(this.g.equals("MOSTAR"))
            novi="036/";
        else if(this.g.equals("SIROKI_BRIJEG"))
            novi="039/";
        else if(this.g.equals("SARAJEVO"))
            novi="033/";
        else if(this.g.equals("LIVNO"))
            novi="034/";
        else if(this.g.equals("BRCKO"))
            novi="049/";

        novi+=broj;

        return novi;
    }
}
