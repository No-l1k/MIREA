package lab_10;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Long> arrayList = new MyArrayList<>(3);
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayToArrayList(new String[]{"one", "two", "potato-o-o"}, arrayList2);
        System.out.println(arrayList2);
        arrayList.addElement((long) 2123231);
        arrayList.addElement((long) 43625631);
        arrayList.addElement((long) 346231);
        System.out.println(arrayList.getElement(1));
        System.out.println("Exception planned:");
        arrayList.addElement((long) 346231);
    }

    public static <E> void ArrayToArrayList(E[] a, ArrayList<E> lst) {
        lst.addAll(Arrays.asList(a));
    }
}

