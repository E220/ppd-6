package strategy;

import algorithm.State;
import model.Graph;

public interface Strategy {

    boolean find(Graph graph, State state);
}
