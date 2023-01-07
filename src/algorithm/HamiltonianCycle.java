package algorithm;

import model.Graph;
import strategy.Strategy;

import java.util.LinkedList;

public class HamiltonianCycle {

    public static LinkedList<Integer> find(Graph graph, Strategy strategy) {
        return find(graph, 0, strategy);
    }

    public static LinkedList<Integer> find(Graph graph, int startingNode, Strategy strategy) {
        final State state = new State(graph.getNrNodes()).with(startingNode);
        return strategy.find(graph, state);
    }
}
