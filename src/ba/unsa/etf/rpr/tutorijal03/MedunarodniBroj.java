package ba.unsa.etf.rpr.tutorijal03;

public class MedunarodniBroj implements TelefonskiBroj, Cloneable<MedunarodniBroj>
{
    private String medj_br;
    private String drzava;

    public MedunarodniBroj(String drzava, String broj)
    {
        this.drzava=drzava.clone();
        this.medj_br=broj.clone();
    }

    @Override
    public Object clone()
    {
        MedunarodniBroj novi = (MedunarodniBroj) super.clone();

        novi.medj_br = this.medj_br.clone();
        novi.drzava = this.drzava.clone();

        return novi;
    }

    @Override
    public String ispisi()
    {
        return drzava+ medj_br;
    }
}
