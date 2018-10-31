package ba.unsa.etf.rpr.tutorijal03;

public class MobilniBroj extends TelefonskiBroj implements Cloneable<MobilniBroj>
{
    private Integer mob_mreza;
    private String br;

    public TelefonskiBroj(int mobilnaMreza, String broj)
    {
        mob_mreza = mobilnaMreza;
        br = broj.clone();
    }

    @Override
    public Object clone()
    {
        MobilniBroj novi = (MobilniBroj) super.clone();   //ne kontam zasto se stavlja super, super daje tip Object?????
        novi.br = this.br.clone();
        return novi;
    }

    @Override
    public String ispisi()
    {
        return "0"+mob_mreza.toString()+br;   //da smo koristili "int" kao tip za "mob_mreza" ne bi mogli korisiti metodu "toString()"
                                              //jer je ona metoda klase Object iz koje su naslijedjenje sve druge klase, a P.O.D
                                              //tipovi nisu kalse
    }
}
