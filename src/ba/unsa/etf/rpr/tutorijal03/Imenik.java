
/*An instance of HashMap has two parameters that affect its performance: initial capacity and load factor.
The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is
 created. The load factor is a measure of how full the hash table is allowed to get before its capacity is automatically increased.
 When the number of entries in the hash table exceeds the product of the load factor and the current capacity, the hash table is
 rehashed (that is, internal data structures are rebuilt) so that the hash table has approximately twice the number of buckets.

As a general rule, the default load factor (.75) offers a good tradeoff between time and space costs. Higher values decrease
 the space overhead but increase the lookup cost (reflected in most of the operations of the HashMap class, including get and put).
  The expected number of entries in the map and its load factor should be taken into account when setting its initial capacity, so as
  to minimize the number of rehash operations. If the initial capacity is greater than the maximum number of entries divided by the
  load factor, no rehash operations will ever occur.

If many mappings are to be stored in a HashMap instance, creating it with a sufficiently large capacity will allow the mappings
to be stored more efficiently than letting it perform automatic rehashing as needed to grow the table. Note that using many keys
with the same hashCode() is a sure way to slow down performance of any hash table. To ameliorate impact, when keys are Comparable,
this class may use comparison order among keys to help break ties.*/

/*KONSTRUKTORI
HashMap()
Constructs an empty HashMap with the default initial capacity (16) and the default load factor (0.75).

HashMap(int initialCapacity)
Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75).

HashMap(int initialCapacity, float loadFactor)
Constructs an empty HashMap with the specified initial capacity and load factor.

HashMap(Map<? extends K,? extends V> m)
Constructs a new HashMap with the same mappings as the specified Map.*/

package ba.unsa.etf.rpr.tutorijal03;

import java.util.*;

public class Imenik
{
    //      HashMap<kljuc, vrijednost>
    private HashMap<String, TelefonskiBroj> tel_imenik; //hashCode() se mora implementirati kada je kljuc licno definisanog tipa

    public Imenik()
    {
        tel_imenik= new HashMap<>(); //kapacitet mape je 16, a "load_factor" je 0.75
    }

    void dodaj(String ime, TelefonskiBroj broj)
    {
        tel_imenik.put(ime, broj);
    }

    String dajBroj(String ime) //vraca broj osobe s referencom "ime" u formi stringa, pozivacuji metod ispisi
    {
        TelefonskiBroj tel_br = tel_imenik.get(ime); //vraca referencu na clana mape sa kljucem "ime"
        String br_isp = tel_br.ispisi();

        return br_isp;
    }

    String dajIme(TelefonskiBroj broj)  //vraca ime osobe ciji telefonski broj je "broj", korisiti HashMapu za ovu operaciju
    {
        String vrati=null;

        if(tel_imenik.containsValue(broj)==true)
        {
            /* I nacin */
            Set sk=tel_imenik.entrySet();  // "IME_MAPE.entrySet()" vraca "Set", te su svi clanovi Seta-a tipa "Map.Entry"
            Iterator it=sk.iterator();   // na tip "Set" se moze primjeniti iterator, kao i za sve iz "Collection", za razliku od tipa "Map"

            int vel = tel_imenik.size();

            for(int i=0; i<vel; i++)
            {
                Map.Entry par = (Map.Entry) it.next();

                if( ( (TelefonskiBroj)par.getValue() ).compareTo(broj)==0)
                    vrati= (String) par.getKey();

                //it.next();
            }

            /* II nacin
            for(Map.Entry<String, TelefonskiBroj> pristup : tel_imenik.entrySet())
            {
                if(pristup.getValue().compareTo(broj)==0 )
                    vrati=pristup.getKey();
            }*/
        }

        return vrati;
    }

    String naSlovo(char s)  //varca sve brojeve u telefonskom imeniku za osobe cije ime pocinje na slovo "s", kao '1. - ime prezime, broj'
    {
        Set st = tel_imenik.entrySet();
        Iterator it_sk = st.iterator();

        Integer brojac=1;

        String vrati = brojac.toString();  //"brojac" mora biti "Integer", a ne "int", jer "toString()" radi samo za ugrdjenje tipove

        for(int i=0; i<tel_imenik.size(); i++)
        {
            Map.Entry m_sk = (Map.Entry) it_sk.next();  //"m_sk" je jedan od uredjenih parova iz mape na koji "it" trenutno ukazuje
                                                        //a da bi se dobio taj element, a ne objekt tipa Iterator, moramo primjeniti ".next()"
                                                        // metodu koja vraca ono na sta it trenutno ukazuje i pomjera iterator za jedan
            String kljuc = (String)m_sk.getKey();

            if( kljuc.indexOf(s)==0)
                vrati+=". "+m_sk.getKey()+" - "+( (TelefonskiBroj)m_sk.getValue() ).ispisi()+"\n";
        }

        return vrati;
    }

    Set<String> izGrada(FiksniBroj.Grad g) //vraca sva imena i prezimena osoba koje zive u gradu "g" i skup treba biti sortiran
    {
        Set s = tel_imenik.entrySet();
        Iterator it_sk = s.iterator();

        TreeSet sortiran=null;

        for(int i=0; i<tel_imenik.size(); i++)
        {
            Map.Entry mp = (Map.Entry) it_sk.next();

            TelefonskiBroj tb = (TelefonskiBroj) mp.getValue();

            String br =tb.ispisi();

            if( br.startsWith(g.toString()))
                sortiran.add( (String) mp.getKey());
        }

        Set<String> vrati=null;
        vrati.addAll(sortiran);

        return vrati;  //"sortiran" koji je tipa TreeSet se downcasta u Set
    }

    Set<TelefonskiBroj> izGradaBrojevi(FiksniBroj.Grad g) // vraca brojeve za osobe iz grada "g", treba biti sortiran po stringu koji vrati "ispisi()"
    {
        Set s = tel_imenik.entrySet();
        Iterator it_s = s.iterator();

        int vel=tel_imenik.size();

        TreeSet vrati=null;

        for(int i=0; i<vel; i++)
        {
            Map.Entry mp = (Map.Entry) it_s.next();

            TelefonskiBroj tb = (TelefonskiBroj) mp.getValue();

            String st = tb.ispisi();

            if(st.startsWith(g.toString()))
                vrati.add( st );
        }
        return vrati;
    }

}
