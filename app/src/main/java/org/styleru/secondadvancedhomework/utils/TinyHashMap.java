package org.styleru.secondadvancedhomework.utils;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Unique exception, which is using only with TinyHashMap.
 * It is throwed while user tries to add more than 10 elements.
 */
class TinyHashMapException extends RuntimeException{
    TinyHashMapException(){
        Log.d("TinyHashMapException", "added mote than 10 items");
    }
}

/**
 * The same class as HashMap, but it doesn't allow to add more than 10 elements at once.
 * @param <T> object
 * @param <V> key
 */
public class TinyHashMap<T, V> extends HashMap<T, V> {

    @Override
    public void putAll(Map<? extends T, ? extends V> m) throws TinyHashMapException {
        if (m.size() <= 10) super.putAll(m);
        throw new TinyHashMapException();
    }
}
