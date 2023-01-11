package dvn.intensive.arraylist_realization;

public class BubbleSorter {

    /**Flag to finish sorting
     */
    private static boolean isSorted = false;

    /**
     * Sorting array of int values
     * @param array - for sorting
     */
    public static void sort(int[] array) {
        while (!isSorted) {
            int counter = 0;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                } else {
                    counter++;
                }
            }
            if (counter == array.length - 1) {
                isSorted = true;
            }
        }
        isSorted = false;
    }

    /**
     * Sorting ArrayList of Integer
     * @param list - for sorting
     */
    public static void sort(ListMyRealization<Integer> list) {
        while (!isSorted) {
            int counter = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int current = list.get(i);
                int next = list.get(i + 1);
                if (current > next) {
                    list.replace(i + 1, current);
                    list.replace(i, next);
                } else {
                    counter++;
                }
            }
            if (counter == list.size() - 1) {
                isSorted = true;
            }
        }
        isSorted = false;
    }

}
