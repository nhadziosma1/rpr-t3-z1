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

    @Override
    public String ispisi()
    {
        return drzava+ medj_br;
    }
}
