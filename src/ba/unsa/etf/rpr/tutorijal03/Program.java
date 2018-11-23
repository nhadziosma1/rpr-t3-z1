package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Program
{
    public static int KojegTipaBroj(String broj)
    {
        int tip=0;

        if(broj.startsWith("06"))
            return 1;  //1 znaci MobilniBroj
        else if(broj.startsWith("03"))
            return 2; //2 znaci FiksniBroj
        else
            return 3; //3 znaci medjunarodni
    }

    public static int KojaMreza(String broj)
    {
        String prve_tri = broj.substring(0, 3);

        int mreza = Integer.parseInt(prve_tri);

        return mreza;
    }

    public static String KojiGrad(String broj)
    {
        String prve_tri = broj.substring(0, 3);

        if(prve_tri.equals("037"))
            return "BIHAC";
        else if(prve_tri.equals("031"))
            return "ORASJE";
        else if(prve_tri.equals("035"))
            return "TUZLA";
        else if(prve_tri.equals("032"))
            return "ZENICA";
        else if(prve_tri.equals("038"))
            return "GORAZDE";
        else if(prve_tri.equals("030"))
            return "TRAVNIK";
        else if(prve_tri.equals("036"))
            return "MOSTAR";
        else if(prve_tri.equals("039"))
            return "SIROKI_BRIJEG";
        else if(prve_tri.equals("033"))
            return "SARAJEVO";
        else if(prve_tri.equals("034"))
            return "LIVNO";
        else if(prve_tri.equals("049"))
            return "BRCKO";

        return "ovdje ista ne treba, glupa osobina IntelliJ-a";
    }


    public static void main(String[] args)
	{
	    Integer broj=0;
	    Imenik im= new Imenik();

        while(true)
        {
            System.out.println("Unesite: 0-za zavrsetak programa, 1-za dodavanje broja u imenik, 2-za pretrazivanje imenika po nekom  uslovu");

            Scanner unesi = new Scanner(System.in);
            broj = unesi.nextInt();

            while(broj!=0 && broj!=1 && broj!=2)
            {
                System.out.println("Unijeli ste pogresan broj, unesite ponovo!");
                broj=unesi.nextInt();
            }

            if (broj==0)
                break;

            String ime=new String();
            String tel_br=new String();

            unesi.nextLine(); //kupi enter

            if(broj==1)
            {
                System.out.println("Unesite ime i prezime osobe: ");
                ime = unesi.nextLine();

                System.out.println("Unesite broj osobe: ");
                tel_br=unesi.nextLine();

                if(KojegTipaBroj(tel_br)==1) //1 zanci MobilniBroj
                {
                    int mreza= KojaMreza(tel_br);

                    MobilniBroj mb = new MobilniBroj(mreza, tel_br.substring(3,9));

                    im.dodaj(ime, mb);
                }
                else if(KojegTipaBroj(tel_br)==2)  //2 znaci FiksniBroj
                {
                    String ime_grada = KojiGrad(tel_br);

                    FiksniBroj fb = new FiksniBroj(  FiksniBroj.Grad.valueOf(ime_grada), tel_br.substring(3,9));

                    im.dodaj(ime, fb);
                }
                else
                {
                    MedunarodniBroj medj_b = new MedunarodniBroj(tel_br.substring(0,3), tel_br.substring(3,9));

                    im.dodaj(ime, medj_b);
                }

            }
            else if(broj==2)
            {
                System.out.println("Unesite: 1-za pretragu imenika po imenu, 2-pretragu imenika po broju, 3-za spisak ljudi cije ime pocinje na neko slovo, 4-pretragu na osnovu grada, pri cemu se dobija spisak imena i prezimena, 5-pretragu na osnovu garda, pri cemu se vraca spisak brojeva");
                int br2 = unesi.nextInt();

                while(br2<1 || br2>5)
                {
                    System.out.println("Unijeli ste pogresan broj, unesite ponovo!");

                    br2=unesi.nextInt();
                }

                unesi.nextLine(); //kupi enter

                if(br2==1)
                {
                    System.out.println("Unesite ime i prezime osobe: ");
                    ime = unesi.nextLine();

                    String ime_trazene= im.dajBroj(ime);

                    System.out.println("Broj osobe: "+ime+" je: "+ ime_trazene);
                }
                else if(br2==2)
                {
                    System.out.println("Unesite broj po kojem zelite pretraziti imenik: ");
                    String broj_bre=unesi.nextLine();

                    TelefonskiBroj tb;

                    if(KojegTipaBroj(broj_bre)==1) //1 zanci MobilniBroj
                    {
                        int mreza= KojaMreza(broj_bre);

                        MobilniBroj mb = new MobilniBroj(mreza, broj_bre.substring(3,9));

                        tb=mb;
                    }
                    else if(KojegTipaBroj(broj_bre)==2)  //2 znaci FiksniBroj
                    {
                        String ime_grada = KojiGrad(broj_bre);

                        FiksniBroj fb = new FiksniBroj(  FiksniBroj.Grad.valueOf(ime_grada), broj_bre.substring(3,9));

                        tb=fb;
                    }
                    else
                    {
                        MedunarodniBroj medj_b = new MedunarodniBroj(broj_bre.substring(0,3), broj_bre.substring(3,9));

                        tb=medj_b;
                    }

                    String ime_osobe_s_prosledjenim = im.dajIme(tb);

                    System.out.println("Ime osobe sa brojem: "+tb.ispisi()+" je: "+ ime_osobe_s_prosledjenim);
                }
                else if(br2==3)
                {
                    System.out.println("Unesite slovo za koje zeliste da vam se ispisu svi clanovi imenika cije ime pocinje na to slovo");

                    char slovo = unesi.next().trim().charAt(0);

                    String za_ispisat = im.naSlovo(slovo);
                    System.out.println(za_ispisat);
                }
                else if(br2==4)
                {
                    System.out.println("Unesite ime jednog od sljdececih gradova da bi dobili spisak ljudi iz imenika iz ovog grada:");
                    System.out.println("BIHAC, ORASJE, TUZLA, ZENICA, GORAZDE, TRAVNIK, MOSTAR, SIROKI_BRIJEG, SARAJEVO, LIVNO, BRCKO");

                    String ime_grada=unesi.nextLine();

                    while(ime_grada.equals("BIHAC")==false && ime_grada.equals("ORASJE")==false && ime_grada.equals("TUZLA")==false && ime_grada.equals("ZENICA")==false && ime_grada.equals("GORAZDE")==false &&ime_grada.equals("TRAVNIK")==false && ime_grada.equals("MOSTAR")==false &&ime_grada.equals("SIROKI_BRIJEG")==false &&ime_grada.equals("SARAJEVO")==false &&ime_grada.equals("LIVNO")==false &&ime_grada.equals("BRCKO")==false)
                    {
                        System.out.println("Niste ispravno unijeli ime grada, pazite na cinjenicu da unos mora biti velikim slovom!");

                        ime_grada=unesi.nextLine();
                    }

                    Set<String> skup = im.izGrada(FiksniBroj.Grad.valueOf(ime_grada));
                    Iterator it =skup.iterator();

                    while(it.hasNext()==true)
                    {
                        System.out.println( (String) it.next());
                    }
                }
                else if(br2==5)
                {
                    System.out.println("Unesite ime jednog od sljdececih gradova da bi dobili spisak ljudi iz imenika iz ovog grada:");
                    System.out.println("BIHAC, ORASJE, TUZLA, ZENICA, GORAZDE, TRAVNIK, MOSTAR, SIROKI_BRIJEG, SARAJEVO, LIVNO, BRCKO");

                    String ime_grada=unesi.nextLine();

                    while(ime_grada.equals("BIHAC")==false && ime_grada.equals("ORASJE")==false && ime_grada.equals("TUZLA")==false && ime_grada.equals("ZENICA")==false && ime_grada.equals("GORAZDE")==false &&ime_grada.equals("TRAVNIK")==false && ime_grada.equals("MOSTAR")==false &&ime_grada.equals("SIROKI_BRIJEG")==false &&ime_grada.equals("SARAJEVO")==false &&ime_grada.equals("LIVNO")==false &&ime_grada.equals("BRCKO")==false)
                    {
                        System.out.println("Niste ispravno unijeli ime grada, pazite na cinjenicu da unos mora biti velikim slovom!");

                        ime_grada=unesi.nextLine();
                    }

                    Set<TelefonskiBroj> skup= im.izGradaBrojevi(FiksniBroj.Grad.valueOf(ime_grada));
                    Iterator it = skup.iterator();

                    while(it.hasNext()==true)
                    {
                       ( (TelefonskiBroj) it.next() ).ispisi();
                    }
                }

            }
        }


    }
}
