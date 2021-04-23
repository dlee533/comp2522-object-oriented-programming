package ca.bcit.comp2522.labs.lab06;

import java.util.ArrayList;

public class OrderedPair<K, V> {
    private final K first;
    private final V second;

    public OrderedPair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static <K, V> boolean same(OrderedPair<K, V> p1,
                                      OrderedPair<K, V> p2) {
        if (p1 == p2) {
            return true;
        }
        if (p1.getClass() != p2.getClass()) {
            return false;
        }
        if (!p1.first.equals(p2.first)) {
            return false;
        }
        return p1.second.equals(p2.second);
    }


    public static void main(String[] args) {
        OrderedPair<String, String> orderedPair = new OrderedPair<>("A", "B");
        OrderedPair<Integer, ArrayList<Integer>> orderedPair1 = new OrderedPair<>(32, new ArrayList<>());
        OrderedPair<Double, Double> orderedPair2 = new OrderedPair<>(3.14, 2.12);
        OrderedPair<Double, Double> orderedPair3 = new OrderedPair<>(3.14, 2.12);
        OrderedPair<Double, Double> orderedPair4 = new OrderedPair<>(3.24, 2.12);

        System.out.println(same(orderedPair2, orderedPair3));
        System.out.println(same(orderedPair3, orderedPair4));
        double a = 3.14;
    }
}

