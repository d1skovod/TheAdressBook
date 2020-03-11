package bookpack;

import java.util.*;

public final class TheAdressBook {
    public static void main(String[] args){ }

    private final LinkedList<Record> book;

    public TheAdressBook(){
        this.book = new LinkedList<>();
    }

    public boolean addPerson(Record person) {
        for (Record it: book) {
            if (person.getName().equals(it.getName())) {
                return false;
            }
        }
        book.add(person);
        return true;
    }

    public boolean removePerson(String rName) {
        for (Record it: book) {
            if (rName.equals(it.getName())) {
                book.remove(it);
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getAdress(String fName) {
        ArrayList<String>res = new ArrayList<>();
        for(Record it: book){
            if (fName.equals(it.getName())) {
                res.add(it.getStreet());
                res.add(it.getBld());
                res.add(it.getApt());
                break;
            }
        }
        return res;
    }

    public boolean changeAdress(String cName, String nStreet, String nBld, String nApt){
        for (Record it: book){
            if (cName.equals(it.getName())) {
                book.remove(it);
                book.add(new Record(cName, nStreet, nBld, nApt));
                return true;
            }
        }
        return false;
    }

    public List<String> findStreet(String fStreet){
        ArrayList <String> res = new ArrayList<>();
        for (Record it: book){
            if (fStreet.equals(it.getStreet())){
                res.add(it.getName());
            }
        }
        Collections.sort(res);
        return res;
    }

    public List<String> findBld(String fStreet, String fBld){
        ArrayList <String> res = new ArrayList<>();
        for (Record it: book){
            if (fStreet.equals(it.getStreet()) && fBld.equals(it.getBld())){
                res.add(it.getName());
            }
        }
        Collections.sort(res);
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Record it: book) {
            res.append(it.toString()).append(System.lineSeparator());
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TheAdressBook that = (TheAdressBook) o;
        return book.equals(that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book);
    }
}
