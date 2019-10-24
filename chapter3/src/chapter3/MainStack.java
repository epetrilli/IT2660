package chapter3;
import javax.swing.*;
public class MainStack {
    public static void main(String[] args) {
        Stack s = new Stack(3);
        StudentListing one;
        StudentListing Adam = new StudentListing("Adam", "4343", "3.0");
        StudentListing Carla = new StudentListing("Carla", "5656", "3.5");
        StudentListing Frank = new StudentListing("Frank", "9898", "2.5");
        StudentListing Karen = new StudentListing("Karen", "1234", "2.0");
        System.out.println(s.pop()); // Returns null
        // Fill the stack
        System.out.println(s.push(Adam));
        System.out.println(s.push(Carla));
        System.out.println(s.push(Frank));
        s.showAll(); // Output the stack
        one = s.pop();
        // Empty the stack
        System.out.println(one.toString());
        one = s.pop();
        System.out.println(one.toString());
        one = s.pop();
        System.out.println(one.toString());
        one = s.pop(); // Returns null
        System.out.println(one);
        System.exit(0);
    }
}
