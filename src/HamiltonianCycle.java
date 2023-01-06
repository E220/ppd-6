import java.util.LinkedList;

public class HamiltonianCycle {

    public static boolean find(Graph graph) {
        return find(graph, 0);
    }

    public static boolean find(Graph graph, int startingNode) {
        final State state = new State(graph.getNrNodes()).with(startingNode);
        return find(graph, state);
    }

    private static boolean find(Graph graph, State state) {
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

    private record State(LinkedList<Integer> path, boolean[] isSelected) {
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
}
