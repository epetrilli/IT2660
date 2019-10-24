package chapter3;

public class Queue {
    private int size;
    private int numOfNodes;
    private int front;
    private int rear;
    private StudentListing[] student;

    public Queue() {
        size = 100;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        student = new StudentListing[100];
    }

    public Queue(int n) {
        size = n;
        numOfNodes = 0;
        front = 0;
        rear = 0;
        student = new StudentListing[n];
    }

    public boolean enque(StudentListing newStudentListing) {
        if (numOfNodes == size)
            return false; // Overflow
        else {
            numOfNodes = numOfNodes + 1;
            student[rear] = newStudentListing.deepCopy();
            rear = (rear + 1) % size;
            return true;
        }
    }

    public StudentListing deque() {
        int frontLocation;
        if (numOfNodes == 0)
            return null; // Underflow
        else {
            frontLocation = front;
            front = (front + 1) % size;
            numOfNodes = numOfNodes - 1;
            return student[frontLocation];
        }
    }

    public void showAll() {
        int i = front;
        for (int c = 1; c <= numOfNodes; c++) {
            System.out.println(student[i].toString());
            i = (i + 1) % size;
        }
    }
}


