package lab_7;

public class Test {
    public static void main(String[] args) {
        MyArrayList<String> states = new MyArrayList<String>();

        states.add("Германия");
        states.add("Франция");
        states.add("Великобритания");
        states.add("Испания");
        states.add(1, "Италия");

        System.out.println(states.get(1));
        states.set(1, "Дания");

        System.out.printf("В списке %d элементов \n", states.size());
        for(String state : states)
            System.out.println(state);

        if(states.contains("Германия"))
            System.out.println("Список содержит государство Германия");

        states.remove("Германия");
        states.remove(0);

        Object[] countries = states.toArray();
        for(Object country : countries)
            System.out.println(country);
    }
}
