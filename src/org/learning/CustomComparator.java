package org.learning;

import java.util.Comparator;

public class CustomComparator implements Comparator<Event> {

    @Override
    public int compare(Event o1, Event o2) {
        return o1.getData().compareTo(o2.getData());
    }
}
