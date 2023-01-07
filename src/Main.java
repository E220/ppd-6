import algorithm.HamiltonianCycle;
import model.Graph;
import program.Program;
import program.Timer;
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
//        graph.addEdge(3, 0);
        graph.addEdge(3, 6);
        graph.addEdge(4, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 0);
        graph.addEdge(5, 1);
        graph.addEdge(5, 4);
        graph.addEdge(5, 3);
        graph.addEdge(6, 4);

        System.out.println("Single thread:");
        new Program(new WithSingleThread(), new Timer(), 100).run(graph);

        System.out.println("Thread pool:");
        new Program(new WithThreadPool(), new Timer(), 100).run(graph);
    }
}