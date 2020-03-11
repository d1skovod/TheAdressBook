package bookpack;

import java.util.Objects;

public class Record {
    private String name;
    private String street;
    private String bld;
    private String apt;

    public Record(String name, String street, String bld, String apt) {
        this.name = name;
        this.street = street;
        this.bld = bld;
        this.apt = apt;
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

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", bld='" + bld + '\'' +
                ", apt='" + apt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return name.equals(record.name) &&
                street.equals(record.street) &&
                bld.equals(record.bld) &&
                apt.equals(record.apt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, street, bld, apt);
    }
}
