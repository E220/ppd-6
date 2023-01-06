package strategy;

import algorithm.State;
import model.Graph;

public class WithSingleThread implements Strategy {
    @Override
    public boolean find(Graph graph, State state) {
        for (int next : graph.getNeighbors(state.path().getLast())) {
            if (next == state.path().getFirst() && state.path().size() == graph.getNrNodes()) {
                return true;
            }
            if (!state.isSelected()[next] && find(graph, state.with(next))) {
                return true;
            }
        }
        return false;
    }
}
