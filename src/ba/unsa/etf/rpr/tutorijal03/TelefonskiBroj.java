/*"Apstraktna klasa TelefonskiBroj sadrži javnu apstraktnu metodu String ispisi() koja vraća broj u tekstualnoj
formi pogodnoj za ispis, te apstraktnu metodu int hashCode() objašnjenu na predavanjima.*/

/*The general contract of hashCode is:

During the execution of the application, if hashCode() is invoked more than once on the same Object then it
must consistently return the same Integer value, provided no information used in equals(Object) comparison
on the Object is modified. It is not necessary that this Integer value to be remained same from one execution
of the application to another execution of the same application.

If two Objects are equal, according to the the equals(Object) method, then hashCode() method must produce the
same Integer on each of the two Objects.

If two Objects are unequal, according to the the equals(Object) method, It is not necessary the Integer value
produced by hashCode() method on each of the two Objects will be distinct. It can be same but producing the
distinct Integer on each of the two Objects is better for improving the performance of hashing based Collections
like HashMap, HashTable…etc.

Note: Equal objects must produce the same hash code as long as they are equal, however unequal objects need not
produce distinct hash codes.*/

package ba.unsa.etf.rpr.tutorijal03;

public abstract class TelefonskiBroj
{
    public abstract String ispisi();
    public abstract int hashCode(); //svaka klasa koja preklopi metodu "equals" mora preklopiti i metodu " int hashCode()"
}
