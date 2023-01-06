package algorithm;

import java.util.LinkedList;

public record State(LinkedList<Integer> path, boolean[] isSelected) {
    public State(int nrNodes) {
        this(new LinkedList<>(), new boolean[nrNodes]);
    }

    public State with(int next) {
        final State newState = new State(new LinkedList<>(path), isSelected.clone());
        newState.path().add(next);
//            System.out.println(newState.path());
        newState.isSelected()[next] = true;
        return newState;
    }
}
