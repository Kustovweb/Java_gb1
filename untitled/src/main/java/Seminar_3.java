import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Seminar_3 {
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();

        list.add(0,2);
        list.add(1,9);
        list.add(2, 10);
        list.add(3, 5);
        list.add(4, 8);
        list.add(5, 20);

        // Удалить четные
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list);

       int min = list.get(0);
       int max = list.get(1);

       for (int i = 0; i < list.size(); i++) {
           if (list.get(i) > max) {
               max = list.get(i);
           }
           if (list.get(i) < min) {
               min = list.get(i);
           }
       }
        System.out.printf("Минимальное значение = %d\n", min);
        System.out.printf("Максимальное значение = %d\n", max);

        //Среднее арифметическое
        int summ = 0;
        for (int a: list) {
            summ += a;
        }
        System.out.printf("Среднее арифметическое = %d", summ / list.size());
    }
}
