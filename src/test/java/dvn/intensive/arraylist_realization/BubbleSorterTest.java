package dvn.intensive.arraylist_realization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSorterTest {

    @Test
    void sort() {

        int[] array = {5, 2, 4, 3, 1};
        BubbleSorter.sort(array);
        int[] sortedArray = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(sortedArray, array);

    }

    @Test
    void sortArrayListMyRealization() {

        Integer[] array = {5, 2, 4, 3, 1};
        ListMyRealization<Integer> list = new ArrayListMyRealization<>();
        list.addAll(array);
        BubbleSorter.sort(list);
        Integer[] sortedArray = {1, 2, 3, 4, 5};
        for (int i = 0; i < list.size(); i++) {
            Assertions.assertEquals(sortedArray[i], list.get(i));
        }

    }
}