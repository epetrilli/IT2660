package chapter3;

public class Stack {
    private int top;
    private int size;
    private StudentListing[] student;

    public Stack() {
        top = -1;
        size = 100;
        student = new StudentListing[100];
    }
    public Stack(int n) {
        top = -1;
        size = n;
        student = new StudentListing[n];
    }
    public boolean push(StudentListing newStudentListing) {
        if (top == size - 1)
            return false; // Overflow error
        else {
            top = top + 1;
            student[top] = newStudentListing.deepCopy();
            return true;
        }
    }
    public StudentListing pop() {
      int topLocation;
      if(top == -1)
          return null; // Underflow error
      else {
          topLocation = top;
          top = top - 1;
          return student[topLocation];
      }
    }
    public void showAll()
    {
        for(int i = top; i >= 0; i--)
            System.out.println(student[i].toString());
    }
}
