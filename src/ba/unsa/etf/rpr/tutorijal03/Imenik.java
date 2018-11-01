
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
    // HashMap<kljuc, vrijednost>
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
            int vel = tel_imenik.size();

            for(int i=0; i<vel; i++)
            {

            }
        }


        return vrati;
    }

    String naSlovo(char s)  //varca sve brojeve u telefonskom imeniku za osobe cije ime pocinje na slovo "s", kao '1. - ime prezime, broj'
    {
        int brojac=1;

        while(tel_imenik.isEmpty()==false)
        {
            if(tel_imenik.containsValue(s)==true)
            {
                //////////////
            }

        }
    }

    TreeSet<String> izGrada(Grad g) //vraca sva imena i prezimena osoba koje zive u gradu "g" i skup treba biti sortiran
    {

    }

    Set<TelefonskiBroj> izGradaBrojevi(Grad g) // vraca brojeve za osobe iz grada "g", treba biti sortiran po stringu koji vrati "ispisi()"
    {

    }

}
