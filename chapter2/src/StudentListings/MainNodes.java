package StudentListings;

public class MainNodes {
    public static void main(String[] args) {
        Nodes test = new Nodes();
        StudentListing temp;
        StudentListing adam = new StudentListing("Adam", "4343", "3.0");
        StudentListing carla = new StudentListing("Carla", "5656", "3.5");
        StudentListing frank = new StudentListing("Frank", "9898", "2.5");
        System.out.println("Test of insert and fetch methods");
        System.out.println(test.insert(adam));
        System.out.println(test.insert(carla));
        System.out.println(test.fetch("Frank"));
        temp = test.fetch("Adam");
        System.out.println(temp.toString());
        temp = test.fetch("Carla");
        System.out.println(temp.toString());
        System.out.println("Test of the delete method");
        System.out.println(test.delete("Frank"));
        System.out.println(test.delete("Adam"));
        System.out.println(test.fetch("Adam"));
        System.out.println("Test of the update method");
        System.out.println(test.update("frank", carla));
        test.insert(adam);
        System.out.println(test.update("Adam", frank));
        System.out.println(test.fetch("Adam"));
        temp = test.fetch("Frank");
        System.out.println(temp.toString());
        System.exit(0);
    }
}
