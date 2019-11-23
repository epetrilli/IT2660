package chapter7;

import javax.swing.*;

public class StudentListing {
    private String name;
    private String id;
    private String gpa;
    public StudentListing()
    {
        name = "";
        id = "";
        gpa = "";
    }

    public StudentListing(String n, String i, String g) {
        name = n;
        id = i;
        gpa = g;
    }

    public String toString() // Used to return the contents of a node
    {
        return ("Name is " + name +
                "\nID is " + id +
                "\nGPA is " + gpa + "\n");
    }

    public StudentListing deepCopy() // Used to encapsulate the binary tree structure
    {
        StudentListing clone = new StudentListing(name, id, gpa);
        return clone;
    }
    public String getKey() // Used for the insert algorithm to access the key field of the inserted node
    {return name;}

    public int compareTo(String targetKey) // Used to compare keys to the keys in the binary tree structure
    {
        return (name.compareTo(targetKey));
    }

    public void input() {
        name = JOptionPane.showInputDialog("Enter a name");
        id = JOptionPane.showInputDialog("Enter an ID");
        gpa = JOptionPane.showInputDialog("Enter a GPA");
    }
}
