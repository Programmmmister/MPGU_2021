package NLogNSort;
import java.util.Arrays;

public class NLogNSort {
    public void sort(int[] data)
    {
        quicksort(data, 0, data.length - 1);
    }

    private void quicksort(int data[], int start, int end) {
        if (start < end) {
            // если есть, что пшесортировать

            int pivot = partition(data, start, end); // делим массив на две части
            quicksort(data, start, pivot - 1); // сортируем первую часть
            quicksort(data, pivot + 1, end); // сортируем вторую
        }
    }

    private int partition(int data[], int start, int end) {
        int pivot = data[end]; // получаем число, с которым мы сравниваем остальные
        int border = start - 1; // перед границей - числа меньше пивота, после - больше
        for (int i = start; i < end; i++) {
            if (data[i] <= pivot) {
                // если число находится не в своей части, перекидываем его в нужную

                border++;
                swap(data, border, i);
            }
        }
        swap(data, border + 1, end); // переносим границу на своё место
        return border + 1; // возвращаем индекс границы
    }


    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
