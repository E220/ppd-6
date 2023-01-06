import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final boolean edges[][];

    public Graph(int nrNodes) {
        this.edges = new boolean[nrNodes][nrNodes];
    }

    public boolean hasEdge(int from, int to) {
        return this.edges[from][to];
    }

    public void addEdge(int from, int to) {
        this.edges[from][to] = true;
    }

    public int getNrNodes() {
        return this.edges.length;
    }

    public List<Integer> getNeighbors(int from) {
        final List<Integer> neighbors = new ArrayList<>(this.getNrNodes());
        for (int to = 0; to < this.getNrNodes(); to++) {
            if (this.edges[from][to]) {
                neighbors.add(to);
            }
        }
        return neighbors;
    }
}