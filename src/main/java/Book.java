import java.util.Vector;

public final class Book {
    public static void main(String[] args){
        System.out.println("TEST");
    }

    private String name;
    private String street;
    private int bld;
    private int apt;
    private static Vector <Book> lst = new Vector <Book> ();

    Book(String name, String street, int bld, int apt) {
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

    public static void addPerson(Book person) {
        lst.add(person);
    }

    public static void removePerson(Book person) {
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


}
//Тест