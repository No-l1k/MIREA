package lab_11;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<String> content = getDirectoryList(".");
            for (int i = 0; i < 5 && i < content.size(); i++)
                System.out.println(content.get(i));
        } catch (SecurityException e) {
            System.out.println("Защищёный каталог не хочет читаться.. :(");
        } catch (Throwable t) {
            System.out.println("Что-то пошло совсем не так...");
        }
        System.out.println("Solution test:");
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        b.add(21);
        b.add(21);
        b.add(23);
        b.add(24);
        System.out.println("ArrayList: "+Solution.newArrayList(a));
        System.out.println("HashMap: "+Solution.newHashMap(a, b));
        System.out.println("HashSet: "+Solution.newHashSet(b));
    }

    public static ArrayList<String> getDirectoryList(String path) throws SecurityException {
        ArrayList<String> list = new ArrayList<>();
        File actual = new File(path);
        if (actual.listFiles() != null)
            for(File f: Objects.requireNonNull(actual.listFiles()))
                list.add(f.getName());
        return list;
    }
}