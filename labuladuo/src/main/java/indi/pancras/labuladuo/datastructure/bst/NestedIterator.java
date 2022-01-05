package indi.pancras.labuladuo.datastructure.bst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// leetcode 341
public class NestedIterator implements Iterator<Integer> {

    private ArrayList<Integer> list = new ArrayList<>();
    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        initList(nestedList);
        iterator = list.iterator();
    }

    private void initList(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                initList(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }
}