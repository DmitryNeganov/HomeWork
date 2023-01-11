package dvn.intensive.arraylist_realization;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArrayListMyRealizationTest {

    static ListMyRealization<String> list = new ArrayListMyRealization<>();

    @BeforeAll
    static void addElementsForTest() {
        list.add("Zero");
        list.add("One");
        list.add("Two");
        System.out.println("Elements for tests were added");
    }

    @Test
    @Order(10)
    void size() {
        Assertions.assertEquals(3, list.size());
    }

    @Test
    @Order(20)
    void get() {
        Assertions.assertEquals("Zero", list.get(0));
        Assertions.assertEquals("One", list.get(1));
        Assertions.assertEquals("Two", list.get(2));
    }

    @Test
    @Order(30)
    void add() {
        list.add("Three");
        Assertions.assertEquals("Three", list.get(3));
    }

    @Test
    @Order(40)
    void addAllByArrayListMyRealization() {
        ListMyRealization<String> listToAdd = new ArrayListMyRealization<>(3);
        listToAdd.add("Four");
        listToAdd.add("Five");
        list.addAll(listToAdd);
        Assertions.assertEquals("Five", list.get(5));
    }

    @Test
    @Order(41)
    void addAllByArray() {
        String[] arrayToAdd = {"Six", "Seven"};
        list.addAll(arrayToAdd);
        Assertions.assertEquals("Seven", list.get(7));
    }

    @Test
    @Order(42)
    void addAllByCollection() {
        List<String> arrayList = new ArrayList<>(2);
        arrayList.add("Eight");
        arrayList.add("Nine");
        list.addAll(arrayList);
        Assertions.assertEquals("Nine", list.get(9));
    }

    @Test
    @Order(50)
    void remove() {
        list.remove(1);
        Assertions.assertEquals("Two", list.get(1));
    }

    @Test
    void replace() {
        list.replace(0, "ZeroZero");
        Assertions.assertEquals("ZeroZero", list.get(0));
    }
}