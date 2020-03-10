import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class Book {
    public static void main(String[] args){
        System.out.println("TEST");
    }

    private String name;
    private String street;
    private String bld;
    private String apt;
    private static LinkedList<Book> lst = new LinkedList<>();;

    public Book(String name, String street, String bld, String apt) {
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

    public String getBld(){
        return bld;
    }

    public String getApt(){
        return apt;
    }

    public void addPerson(Book person) {
        lst.add(person);
    }

    public void removePerson(Book person) {
        lst.remove(person);
    }

    public static String[] getAdress(String fName) {
        for(Book it: lst){
            if (it.name.equals(fName)) {
                return new String[]{it.street, it.bld, it.apt};
            }
        }
        throw new IllegalArgumentException("Name "+fName+" not found");
    }

    public void changeAdress(String cName, String nStreet, String nBld, String nApt){
        boolean flag = false;
        for (Book it: lst){
            if (it.name.equals(cName)) {
                it.street = nStreet;
                it.bld = nBld;
                it.apt = nApt;
                flag = true;
            }
        }
        if (!flag) throw new IllegalArgumentException("Name "+cName+" not found");
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

    public static List<String> findBld(String fStreet, String fBld){
        LinkedList <String> res = new LinkedList<>();
        for (Book it: lst){
            if (it.street.equals(fStreet) && it.bld.equals(fBld)){
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
        return bld.equals(book.bld) &&
                apt.equals(book.apt) &&
                Objects.equals(name, book.name) &&
                Objects.equals(street, book.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, bld, apt);
    }
}
