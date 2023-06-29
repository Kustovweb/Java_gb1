import java.util.*;

public class Seminar_4 {
    // Из будущего применил изученные классы
    static class People {
        int id;
        String name;
        int age;
        String gender;
        public People(int id, String name, int age, String gender) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        // Переопределяем поведение toString
        @Override
        public String toString(){
            return name + "," + age + "," + gender; // Было на лекции
        }



    }
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in, "UTF-8");
        System.out.println("Введите ФИО, возраст, пол");
        ArrayList<String> surname = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> patronymic = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> gender = new ArrayList<>();
        ArrayList<People> people_list = new ArrayList<>();
        int count = 0;
        while (true) {
            String console_str = console.nextLine();
            if (console_str.equals("q")) {
                System.out.println("Программа закончена");
                break;
            }
            String[] arr = new String[3];
            arr = console_str.split(",");
            StringBuilder fio_tmp = new StringBuilder();
            fio_tmp.append(arr[0]);
            age.add(Integer.parseInt(arr[1]));
            gender.add(arr[2]);

            String[] arr_fio = new String[3];
            arr_fio = fio_tmp.toString().split(" ");
            surname.add(arr_fio[0]);
            name.add(arr_fio[1]);
            patronymic.add(arr_fio[2]);

            count++;
        }
        // База данных из ArrayList
        int max_value_age = age.get(0); // Находим макс возраст необходимо для функции  CountingSort
        for (int i = 0; i < count; i++) {
            String fio = "";
            fio = surname.get(i) + " " + patronymic.get(i).charAt(0) + "." + patronymic.get(i).charAt(0);
            people_list.add(new People(i, fio, age.get(i), gender.get(i)));
            if (max_value_age < age.get(i)) {
                max_value_age = age.get(i);
            }
        }
        System.out.println(people_list.get(0));

        Integer[] age_tmp = new Integer[count];
        for (int i = 0; i < count; i++) {
            age_tmp[i] = Integer.parseInt(String.valueOf(age.get(i)));
        }

        for (People people: countingSortObj(people_list, max_value_age)) {
            System.out.println(people);
        }

    }
    public static People[] countingSortObj(List<People> peoples, int max_value) {

        int[] count = new int[max_value + 1];

        for (int i = 0; i < peoples.size(); i++) {
            count[peoples.get(i).age] = count[peoples.get(i).age] + 1;

        }

        People[] output = new People[peoples.size()];

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = peoples.size() - 1; i >= 0 ; i--) {
            People people = peoples.get(i);
            output[count[people.age] - 1] = people;
            count[people.age]--;

        }

        return output;
    }


    // Сортировка подсчетом для массива
    public static void CountingSort(Integer[] array, int max_value) {
        // Создаем массив счетчиков
        int[] count = new int[max_value + 1];
        // Считаем количество элементов для каждого значения
        for (int i = 0; i < array.length; i++) {
            count[array[i]] = count[array[i]] + 1;
        }
        // Копируем значения в исходный массив

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[index] = i;
                index++;
            }
        }

    }

}
