package strategy;

import algorithm.State;
import model.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WithThreadPool implements Strategy {

    private final ReentrantReadWriteLock resultLock = new ReentrantReadWriteLock();
    private LinkedList<Integer> result;

    @Override
    public LinkedList<Integer> find(Graph graph, State state) {
        final List<Integer> neighbors = graph.getNeighbors(state.path().getLast());
        try (final ExecutorService pool = Executors.newFixedThreadPool(neighbors.size())) {
            for (int next : neighbors) {
                if (next == state.path().getFirst() && state.path().size() == graph.getNrNodes()) {
                    return state.path();
                }
                if (!state.isSelected()[next]) {
                    if (this.noSolutionSoFar()) {
                        pool.execute(() -> {
                            final LinkedList<Integer> result = find(graph, state.with(next));
                            if (Objects.nonNull(result) && this.noSolutionSoFar()) {
                                this.solutionFound(result);
                            }
                        });
                    } else {
                        return this.result;
                    }
                }
            }
        }
        return this.result;
    }

    private void solutionFound(LinkedList<Integer> result) {
        this.resultLock.writeLock().lock();
        this.result = result;
        this.resultLock.writeLock().unlock();
    }

    private boolean noSolutionSoFar() {
        this.resultLock.readLock().lock();
        final boolean noSolution = Objects.isNull(this.result);
        this.resultLock.readLock().unlock();
        return noSolution;
    }
}
