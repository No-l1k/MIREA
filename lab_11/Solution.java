package lab_11;
import java.util.*;

public class Solution {
    public static <T> ArrayList<T> newArrayList(Collection<? extends T> value) {
        ArrayList<T> arrayList = new ArrayList<>();
        arrayList.addAll(value);
        return arrayList;
    }

    public static <T> HashSet<T> newHashSet(Collection<? extends T> value) {
        HashSet<T> hashSet = new HashSet<>();
        hashSet.addAll(value);
        return hashSet;
    }

    public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size())
            throw new IllegalArgumentException("Values count != keys count");
        HashMap<K, V> hashMap = new HashMap();
        for (int i = 0; i < keys.size(); i++) {
            hashMap.put(keys.get(i), values.get(i));
        }
        return hashMap;
    }
}