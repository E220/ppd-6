package program;

import algorithm.HamiltonianCycle;
import model.Graph;
import strategy.Strategy;

import java.util.concurrent.ExecutionException;

public class Program {
    private final Strategy strategy;

    private final Timer timer;
    private final int runs;

    public Program(Strategy strategy, Timer timer, int runs) {
        this.strategy = strategy;
        this.timer = timer;
        this.runs = runs;
    }

    public void run(Graph graph) {
        double avg = 0;
        for (int run = 0; run < runs; run++) {
            for (int startingNode = 0; startingNode < graph.getNrNodes(); startingNode++) {
                timer.start();
                HamiltonianCycle.find(graph, startingNode, strategy);
                avg += timer.measure();
            }
        }
        timer.print(avg / runs / graph.getNrNodes());
    }
}
