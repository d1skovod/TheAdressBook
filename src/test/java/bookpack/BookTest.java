package bookpack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class BookTest {
    private TheAdressBook testBook;

    @BeforeEach
    void setUp() {
        testBook = new TheAdressBook();
        testBook.addPerson(new Record("Зашихин", "пр. Советских Космонавтов", "153", "58"));
        testBook.addPerson(new Record("Дружинин", "пр. Советских Космонавтов", "153", "53"));
        testBook.addPerson(new Record("Вишняков", "пр. Советских Космонавтов", "158", "17"));
        testBook.addPerson(new Record("Халаков", "ул. Гагарина", "49", "26"));
    }

    @Test
    void addPerson() {
        assertTrue(testBook.addPerson(new Record("Рылов", "ул. Ломоносова", "45/2", "71")));
        assertFalse(testBook.addPerson(new Record("Зашихин", "пр. Тройцкий", "163", "16")));
    }

    @Test
    void removePerson() {
        assertFalse(testBook.removePerson("Кобелев"));
        assertTrue(testBook.removePerson("Дружинин"));
    }

    @Test
    void getAdress() {
        ArrayList<String> excepted1 = new ArrayList<>();
        ArrayList<String> excepted2 = new ArrayList<>();
        excepted1.add("пр. Советских Космонавтов");
        excepted1.add("153");
        excepted1.add("58");
        assertEquals(excepted1, testBook.getAdress("Зашихин"));
        assertEquals(excepted2, testBook.getAdress("Рылов"));
    }

    @Test
    void changeAdress() {
        testBook.changeAdress("Вишняков", "ул. Воскресенская", "94/3", "26");
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("ул. Воскресенская");
        excepted.add("94/3");
        excepted.add("26");
        assertEquals(excepted, testBook.getAdress("Вишняков"));
        assertTrue(testBook.changeAdress("Халаков", "пр. Тройцкий", "25", "6"));
        assertFalse(testBook.changeAdress("Кобелев", "пр. Тройцкий", "25", "6"));
    }

    @Test
    void findStreet() {
        ArrayList<String> excepted1 = new ArrayList<>();
        ArrayList<String> excepted2 = new ArrayList<>();
        excepted1.add("Вишняков");
        excepted1.add("Дружинин");
        excepted1.add("Зашихин");
        assertEquals(excepted1, testBook.findStreet("пр. Советских Космонавтов"));
        assertEquals(excepted2, testBook.findStreet("ул. Воскресенская"));
    }

    @Test
    void findBld() {
        ArrayList<String> excepted1 = new ArrayList<>();
        ArrayList<String> excepted2 = new ArrayList<>();
        excepted1.add("Дружинин");
        excepted1.add("Зашихин");
        assertEquals(excepted1, testBook.findBld("пр. Советских Космонавтов", "153"));
        assertEquals(excepted2, testBook.findBld("пр. Советских Космонавтов", "180"));
        assertEquals(excepted2, testBook.findBld("ул. Воскресенская", "153"));
    }
}
