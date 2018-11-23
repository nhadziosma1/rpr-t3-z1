package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj
{
    private Integer mob_mreza;
    private String mob_br;

    public MobilniBroj(int mobilnaMreza, String broj)
    {
        mob_mreza = mobilnaMreza;
        mob_br = broj;
    }

    @Override
    public String ispisi()
    {
        return "0"+mob_mreza.toString()+"/"+mob_br; //Da smo koristili "int" kao tip za "mob_mreza" ne bi mogli korisiti metodu "toString()"
                                                    // jer je ona metoda klase Object iz koje su naslijedjenje sve druge klase, a P.O.D
                                                    // tipovi nisu kalse.

                                                    //Sa druge strane, da mogao se koristiti tip "int", ali bi se morala konverzija inta u
                                                    // String odraditi na sljedeci nacin "Sting.valueOf(mob_mreza)"
    }
}
