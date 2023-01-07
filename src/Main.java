import algorithm.HamiltonianCycle;
import model.Graph;
import strategy.WithSingleThread;
import strategy.WithThreadPool;

public class Main {
    public static void main(String[] args) {
        final Graph graph = new Graph(7);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 6);
        graph.addEdge(2, 1);
        graph.addEdge(2, 5);
        graph.addEdge(2, 6);
        graph.addEdge(3, 0);
        graph.addEdge(3, 6);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);
        graph.addEdge(5, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(6, 4);

//        System.out.println(HamiltonianCycle.find(graph, new WithSingleThread()));
        for (int i = 0; i < 7; i++)
            System.out.println(HamiltonianCycle.find(graph, i, new WithSingleThread()));

//        System.out.println(HamiltonianCycle.find(graph, new WithThreadPool()));
        for (int i = 0; i < 7; i++) {
            System.out.println(HamiltonianCycle.find(graph, i, new WithThreadPool()));
        }
    }
}