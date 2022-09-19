import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        double[] arr = {0.2, 99.3, 4.3, 22.1, 5.5, 6.3, 7.7, -2.5, -93.9, 88.8,
                12.2, -55.3, 1003.25, -1.9, 13.4};

        System.out.println(task1(arr));
        System.out.println("");
        System.out.println(selectionSort(arr));
    }


    public static double task1(double[] arr) {
        int index_start = 0; // индекс первого отрицательного числа

        // цикл ищущий первое отрицательное число
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0) {
                index_start = i + 1;
                break;
            }
        }

        double count = 0; // сумма всех положительных чисел
        int divide = 0;  // счетчик положительных чисел

        // цикл отделяющий отрицательные числа
        for (int j = index_start; j < arr.length; j++) {
            if (arr[j] > 0) {
                count += arr[j];
                divide += 1;
            } else {
                continue;
            }
        }
        return count / divide;
    }


    public static String selectionSort(double[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            double min = arr[i];
            int indexMin = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    indexMin = j;
                }
            }
            if (indexMin != i) {
                double save = arr[i];
                arr[i] = arr[indexMin];
                arr[indexMin] = save;
            }
            System.out.println(Arrays.toString(arr));
        }

        return Arrays.toString(arr) + " Sorted array";
    }
}

















