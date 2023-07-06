import java.util.*;

public class Seminar_6 {
    public static void main(String[] args) {
        MySet obj = new MySet();
        System.out.println(obj.add(1));
        System.out.println(obj.contains(1));
        System.out.println(obj.add(2));
        System.out.println(obj.add(234));
        System.out.println(obj.isEmpty());


        System.out.println(obj.isEmpty());

        System.out.println(obj.getIndex(1));


        Iterator<Integer> iterator = obj.iterator();
        System.out.println(obj.toString(iterator));
    }

}

class MySet {
    private HashMap<Integer, Object> myMap = new HashMap<>();
    private static final Object MYOBJ = new Object();
    public boolean add(int elem) {
        return myMap.put(elem, MYOBJ) == null;
    }
    public boolean del(int elem) {
        return myMap.remove(elem) == MYOBJ;
    }
    public boolean isEmpty() {
        return myMap.isEmpty();
    }

    public boolean contains(int elem) {
        return myMap.containsKey(elem);
    }

    public int getIndex(int index) {
        Object[] a = myMap.keySet().toArray();
        return (int) a[index];
    }

    public Iterator<Integer> iterator() {
        return myMap.keySet().iterator();
    }


    public String toString(Iterator<Integer> iterator) {
        StringBuilder res = new StringBuilder();
        while (iterator.hasNext()) {
            int i = (int) iterator.next();
            res.append(i + ";");

        }
        return res.toString();
    }
}