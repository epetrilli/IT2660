package chapter3;

public class MainQueue {
    public static void main(String[] args) {
        Queue q = new Queue(3);
        StudentListing one;
        StudentListing Adam = new StudentListing("Adam", "4343", "3.0");
        StudentListing Carla = new StudentListing("Carla", "5656", "3.5");
        StudentListing Frank = new StudentListing("Frank", "9898", "2.5");
        StudentListing Karen = new StudentListing("Karen", "1234", "2.0");
        System.out.println(q.deque()); // Test of underflow condition
        // Fill the queue
        System.out.println(q.enque(Adam));
        System.out.println(q.enque(Carla));
        System.out.println(q.enque(Frank));
        System.out.println(q.enque(Karen));
        q.showAll(); // Output the queue
        // Empty the queue
        one = q.deque();
        System.out.println(one.toString());
        one = q.deque();
        System.out.println(one.toString());
        one = q.deque();
        System.out.println(one.toString()); // Returns null
        one = q.deque();
        System.out.println(one);
        System.exit(0);
    }
}
