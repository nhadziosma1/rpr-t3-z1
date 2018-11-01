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

    /*@Override
    public Object clone()
    {
        MobilniBroj novi = (MobilniBroj) super.clone();   //ne kontam zasto se stavlja super, super daje tip Object?????
        novi.mob_br = this.mob_br.clone();
        return novi;
    }*/

    @Override
    public String ispisi()
    {
        return "0"+mob_mreza.toString()+mob_br; //da smo koristili "int" kao tip za "mob_mreza" ne bi mogli korisiti metodu "toString()"
                                              //jer je ona metoda klase Object iz koje su naslijedjenje sve druge klase, a P.O.D
                                              //tipovi nisu kalse
    }
}
