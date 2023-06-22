//Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого
// запроса, используя StringBuilder и/или String. Данные для фильтрации приведены ниже в
// виде json-строки.
//Если значение null, то параметр не должен попадать в запрос.;
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
public class Seminar_2 {
    public static void main(String[] args) {
        StringBuilder builder_str = new StringBuilder("select * from students where ");
        StringBuilder builder_par = new StringBuilder("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
        builder_par.delete(0, 2);
        builder_par.delete(builder_par.length() - 2, builder_par.length());
        while (builder_par.indexOf(":") != -1 ) {
            builder_par.replace(builder_par.indexOf(":"), builder_par.indexOf(":") + 1, "=");
        }
        while (builder_par.indexOf("null") != -1) {
            if (builder_par.lastIndexOf(",", builder_par.indexOf("null")) == -1) {
                builder_par.delete(0, builder_par.indexOf("null")+5);
            }
            else {
                builder_par.delete(builder_par.lastIndexOf(",", builder_par.indexOf("null")), builder_par.indexOf("null")+4);
            }
        }
        System.out.println(builder_str.append(builder_par));
    }
}
