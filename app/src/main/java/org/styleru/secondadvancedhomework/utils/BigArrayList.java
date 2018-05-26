package org.styleru.secondadvancedhomework.utils;

import java.util.ArrayList;
import java.util.Collection;

public class BigArrayList<T> extends ArrayList<T> {
    int countRemoved = 0;

    @Override
    public void clear() {
        countRemoved += this.size();
        super.clear();
        if (countRemoved >= 100) this.trimToSize();
    }

    @Override
    public T remove(int index) {
        countRemoved++;
        T obj = super.remove(index);
        if (countRemoved >= 100) this.trimToSize();
        return obj;

    }

    @Override
    public boolean remove(Object o) {
        countRemoved++;
        boolean flag = super.remove(o);
        if (countRemoved >= 100) this.trimToSize();
        return flag;

    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        countRemoved+= toIndex - fromIndex;
        super.removeRange(fromIndex, toIndex);
        if (countRemoved >= 100) this.trimToSize();
    }

    @Override
    public boolean removeAll(Collection c) {
        countRemoved += c.size();
        boolean flag = super.removeAll(c);
        if (countRemoved >= 100) this.trimToSize();
        return flag;
    }

}
