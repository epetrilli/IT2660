package Graph;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int randomFill() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
    public static int randomFill2() {
        Random rand = new Random();
        return rand.nextInt(5);
    }
    public static int generateRandomIntIntRange(int min, int max)
    {
        Random r = new Random();
        return r.nextInt((max-min)+1)+min;
    }
    public static void main(String [] args) {
        int MAX = 300;
        int firstVertex2 = MAX-1;

        int searchNumber;
        Scanner scan = new Scanner(System.in);
        Graph graph = new Graph(301);
        System.out.println("Enter a number between 1 and 300");
        searchNumber = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < 100; i++) {
            Nodes newNodes = new Nodes((int) generateRandomIntIntRange(1, 300));
            graph.insertVertex(i, newNodes);

        }
        for (int j = 0; j < 100; j++) {
            int toVertex = randomFill2();
            for (int k = 0; k <= toVertex; k++) {
                int randomVertex = generateRandomIntIntRange(1, 300);
                graph.insertEdge(j, randomVertex);
            }

        }

        System.out.println("Depth first traversal for " + searchNumber);
        graph.DFT(searchNumber);
        System.out.println("Breadth first traversal for " + searchNumber);
        graph.BFT(searchNumber);
        graph.Dijkstra(searchNumber);


    }
}
