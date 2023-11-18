package x.collection;

import java.util.Map;

public final class MapX {

    public static <K, V> V get(Map<K, V> map, K key) {
        return map.get(key);
    }

    public static <K, V> String getString(Map<K, V> map, K key) {
        return (String) get(map, key);
    }

    public static <K, V> int getInt(Map<K, V> map, K key) {
        return (int) get(map, key);
    }

    public static <K, V> long getLong(Map<K, V> map, K key) {
        return (long) get(map, key);
    }
}
