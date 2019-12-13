package Graph;
import java.util.*;
import java.util.Queue;
import java.util.Stack;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Graph {
    public int vertexQuantity;
    Nodes vertex [];
    int edge[][];
    int edgeWeight[][];
    int max, numberOfVertices;
    int numVerticesIncluded;
    int a[][];
    int spt[][];

    private int randomFill3() {
        Random rand = new Random();
        int RandomNum = rand.nextInt(3);
        return RandomNum;
    }
    public Graph(int vertexValue)
    {
        vertex = new Nodes[vertexValue];
        edge = new int[vertexValue][vertexValue];
        edgeWeight = new int[vertexValue][vertexValue];
        max = vertexValue;
        numberOfVertices = 0;
    }
    public boolean insertVertex(int vertexNumber, Nodes newNodes)
    {
        if (vertexNumber >= max)
            return false;
        vertex[vertexNumber] = newNodes.deepCopy(); numberOfVertices++;
        return true;
    }
    public boolean insertEdge(int fromVertex, int toVertex) {
        if (vertex[fromVertex] == null || vertex[toVertex] == null) {
            return false;
        }
        if(edgeWeight[fromVertex][toVertex] >= 1)
        {
            return false;
        }
        edge[fromVertex][toVertex] = 1;
        edgeWeight[fromVertex][toVertex] = randomFill3();
        System.out.println("New edge at vertex " + fromVertex + " to " + toVertex + " with weight:" + + edgeWeight[fromVertex][toVertex]) ;
        return true;
    }

    public void BFT(int searchNumber) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> v = new ArrayList<>();
        for(int i = 0; i < numberOfVertices; i++)
        {
            if(vertex[i] != null)
            {
                vertex[i].setPushed(false);
            }

        }
        queue.add(searchNumber);
        while (queue.size() != 0) {
            int nextNode;
            nextNode = queue.remove();
            if (!v.contains(nextNode)); {
                System.out.println("Went to: vertex "+ nextNode + " with value of: " + vertex[nextNode].getNodes());
                if (vertex[nextNode].getNodes() == searchNumber) {
                    System.out.println(searchNumber + "found at vertex" + v);
                }
                for (int i = 0; i < numberOfVertices; i++)
                    if (edge[nextNode][i] > 0 && !v.contains(i)) {
                        queue.add(i);
                    }
            }
        }
        if(queue.isEmpty())
        {
            System.out.println(searchNumber + " not found");
        }
    }
    public void DFT(int searchNumber) {
        int v;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numberOfVertices; i++) {
            {
                if (vertex[i] != null)
                    vertex[i].setPushed(false);
            }
        }
        stack.push(searchNumber);
        vertex[searchNumber].setPushed(true);
        while (!stack.empty()) {
            v = stack.pop();
            vertex[v].visit(v);
            if(vertex[v].getNodes() == searchNumber)
            {
                System.out.println(searchNumber + "found at vertex" + v);
            }
            System.out.println();
            for (int column = 0; column < numberOfVertices; column++) {
                if (edge[v][column] == 1 && !vertex[column].getPushed()) {
                    stack.push(column);
                    vertex[column].setPushed(true);
                }
            }
        }
        if(stack.isEmpty())
        {
            System.out.println(searchNumber + " not found");
        }
    }

    public int[][] Dijkstra(int searchNumber) {
        int numVerticesIncluded;

        int[] minPathLengths = new int[numberOfVertices];
        int[] verticesIncluded = new int[numberOfVertices];
        int[][] aCopy = a;
        int noEdge = Integer.MAX_VALUE;
        int noPath = Integer.MAX_VALUE;
        int minPath;
        int rowMin = 0;
        int colMin = 0;
        int weightMin = 0;
        int minWeight = 0;
        verticesIncluded[0] = searchNumber;
        numVerticesIncluded = 1;
        for (int i = 0; i < numberOfVertices; i++) {
            minPathLengths[i] = noPath;
        }
        while (numVerticesIncluded < numberOfVertices) {
            minPath = findMinWeightEdge(numberOfVertices, aCopy, verticesIncluded, numVerticesIncluded, rowMin, colMin, minWeight);
            for (int i = 0; i < numberOfVertices; i++) {
                aCopy[i][colMin] = noEdge;
            }
            spt[rowMin][colMin] = minWeight;
            minPathLengths[colMin] = minPath;
            verticesIncluded[numVerticesIncluded] = colMin;
            numVerticesIncluded++;
        }
        return spt;
    }
    public int findMinWeightEdge(int numberOfVertices, int [][] aCopy, int[] verticesIncluded, int numVerticesIncluded, int rowMin, int colMin, int minWeight)
    {
        int index = -1;
        return index;
    }
}
