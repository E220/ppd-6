import algorithm.HamiltonianCycle;
import model.Graph;
import strategy.WithSingleThread;

public class Main {
    public static void main(String[] args) {
        final Graph withoutCycle = new Graph(7);
        withoutCycle.addEdge(0, 1);
        withoutCycle.addEdge(0, 3);
        withoutCycle.addEdge(0, 4);
        withoutCycle.addEdge(1, 2);
        withoutCycle.addEdge(1, 6);
        withoutCycle.addEdge(2, 1);
        withoutCycle.addEdge(2, 5);
        withoutCycle.addEdge(2, 6);
//        withoutCycle.addEdge(3, 0);
        withoutCycle.addEdge(3, 6);
        withoutCycle.addEdge(4, 3);
        withoutCycle.addEdge(4, 5);
        withoutCycle.addEdge(5, 0);
        withoutCycle.addEdge(5, 1);
        withoutCycle.addEdge(5, 4);
        withoutCycle.addEdge(5, 3);
        withoutCycle.addEdge(6, 4);

        System.out.println(HamiltonianCycle.find(withoutCycle, new WithSingleThread()));
//        for (int i = 0; i < 7; i++)
//            System.out.println(algorithm.HamiltonianCycle.find(withoutCycle, i, new WithSingleThread()));
    }
}