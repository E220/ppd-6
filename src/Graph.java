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
}