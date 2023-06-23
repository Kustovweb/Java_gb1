import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

//Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.
public class seminar2_1 {

    public static void main(String[] args) {
        try {
            String pathProject= System.getProperty("user.dir");
            String pathFile = pathProject.concat("/src/main/java/data_sem2.txt");

            File data_txt = new File(pathFile);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(data_txt));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            StringBuilder stringBuilder = new StringBuilder(line);
            String str = stringBuilder.toString();
            String s2 = str.replaceAll("[^а-яА-Я-0-9]", "")
                    .replaceAll("фамилия", ".Студент ")
                    .replaceAll("оценка", " получил ")
                    .replaceAll("предмет", " по предмету ");
           StringBuilder s3 = new StringBuilder(s2).delete(0, 1);
           while (s3.indexOf(".") != -1) {
               s3.replace(s3.indexOf("."), s3.indexOf(".") + 1, "\n");
           }
            System.out.println(s3);

        } catch (Exception e) {
            System.out.println("Здесь ошибка" + " " + e);
        }

        }


}

