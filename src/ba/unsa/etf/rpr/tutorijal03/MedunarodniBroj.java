package ba.unsa.etf.rpr.tutorijal03;

public class MedunarodniBroj extends TelefonskiBroj
{
    private String medj_br;
    private String drzava;

    public MedunarodniBroj(String drzava, String broj)
    {
        this.drzava = drzava;
        this.medj_br = broj;
    }

    /*@Override
    public Object clone()
    {
        MedunarodniBroj novi = (MedunarodniBroj) super.clone();

        novi.medj_br = this.medj_br.clone();
        novi.drzava = this.drzava.clone();

        return novi;
    }*/

    @Override
    public String ispisi()
    {
        return drzava+ medj_br;
    }
}
