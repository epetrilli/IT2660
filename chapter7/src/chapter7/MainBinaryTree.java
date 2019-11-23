package chapter7;

public class MainBinaryTree {
    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        StudentListing one = new StudentListing("Aaron", "12345", "2.5");
        StudentListing two = new StudentListing("Bill", "23456", "3.0");
        StudentListing three = new StudentListing("Carla", "34567", "3.5");
        StudentListing four = new StudentListing("Denise", "45678", "4.0");
        StudentListing five = new StudentListing("Erin", "56789", "3.0");
        t.insert(one);
        t.insert(two);
        t.insert(three);
        System.out.println(t.fetch("Aaron"));
        System.out.println(t.fetch("Bill"));
        System.out.println(t.fetch("Carla"));
        t.delete("Aaron");
        System.out.println(t.fetch("Aaron"));
        t.delete("Bill");
        System.out.println(t.fetch("Bill"));
        t.update("Denise", one);
        System.out.println(t.fetch("Aaron"));
        System.out.println(t.fetch("Denise"));
        System.exit(0);
    }
}

