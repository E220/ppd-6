package strategy;

import algorithm.State;
import model.Graph;

import java.util.LinkedList;

public interface Strategy {

    LinkedList<Integer> find(Graph graph, State state);
}
