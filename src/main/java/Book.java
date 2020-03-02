import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class Book {
    public static void main(String[] args){
        System.out.println("TEST");
    }

    private String name;
    private String street;
    private int bld;
    private int apt;
    private static LinkedList<Book> lst = new LinkedList<>();;

    public Book(String name, String street, int bld, int apt) {
        this.name = name;
        this.street = street;
        this.bld = bld;
        this.apt = apt;
        addPerson(this);
    }

    public String getName(){
        return name;
    }

    public String getStreet(){
        return street;
    }

    public int getBld(){
        return bld;
    }

    public int getApt(){
        return apt;
    }

    public void addPerson(Book person) {
        lst.add(person);
    }

    public void removePerson(Book person) {
        lst.remove(person);
    }

    public String getAdress(String fname){
        for(Book it: lst){
            if (it.name.equals(fname)) {
                return it.street+", "+it.bld+", apt "+it.apt;
            }
        }
        return "No results found";
    }

    public void changeAdress(String cName, String nStreet, int nBld, int nApt){
        for (Book it: lst){
            if (it.name.equals(cName)) {
                it.street = nStreet;
                it.bld = nBld;
                it.apt = nApt;
            }
        }
    }

    public static List<String> findStreet(String fStreet){
        LinkedList <String> res = new LinkedList<>();
        for (Book it: lst){
            if (it.street.equals(fStreet)){
                res.add(it.name);
            }
        }
        return res;
    }

    public static List<String> findBld(String fStreet, int fBld){
        LinkedList <String> res = new LinkedList<>();
        for (Book it: lst){
            if (it.street.equals(fStreet) && it.bld == fBld){
                res.add(it.name);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", bld=" + bld +
                ", apt=" + apt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bld == book.bld &&
                apt == book.apt &&
                Objects.equals(name, book.name) &&
                Objects.equals(street, book.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, bld, apt);
    }
}
