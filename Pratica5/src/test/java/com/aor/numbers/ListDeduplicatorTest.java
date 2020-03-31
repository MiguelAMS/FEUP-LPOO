package com.aor.numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListDeduplicatorTest {
    private List<Integer> list;

    public void helper() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(5);
    }

    @Test
    public void deduplicate() {
        helper();

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new ListSorter(list));

        assertEquals(expected, distinct);
    }

    @Test
    public void deduplicateBugReport() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);

        class StubSort implements IListSorter {
            @Override
            public List<Integer> sort() {
                List<Integer> sorted = new ArrayList<>();
                sorted.add(1);
                sorted.add(2);
                sorted.add(2);
                sorted.add(4);
                return sorted;
            }
        }

        ListDeduplicator deduplicator = new ListDeduplicator(list);
        List<Integer> distinct = deduplicator.deduplicate(new StubSort());

        assertEquals(expected, distinct);
    }
}