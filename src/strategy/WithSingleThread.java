package strategy;

import algorithm.State;
import model.Graph;

import java.util.LinkedList;
import java.util.Objects;

public class WithSingleThread implements Strategy {
    @Override
    public LinkedList<Integer> find(Graph graph, State state) {
        for (int next : graph.getNeighbors(state.path().getLast())) {
            if (next == state.path().getFirst() && state.path().size() == graph.getNrNodes()) {
                return state.path();
            }
            if (!state.isSelected()[next]) {
                final LinkedList<Integer> result = find(graph, state.with(next));
                if (Objects.nonNull(result)) {
                    return result;
                }
            }
        }
        return null;
    }
}
