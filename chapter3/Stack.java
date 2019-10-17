package chapter3;

public class Stack {
    private int next;
    private int size;
    private StudentListing[] student;

    public Nodes() {
        next = 0;
        size = 100;
        student = new StudentListing[size];
    }
    public Nodes(int s) {
        next = 0;
        student = new StudentListing[s];
        size = s;
    }
    public boolean insert(StudentListing newStudentListing) {
        if (next >= size)
            return false;
        student[next] = newStudentListing.deepCopy();
        if (student[next] == null)
            return false;
        next = next + 1;
        return true;
    }
    public StudentListing fetch(String targetKey) {
        StudentListing node;
        StudentListing temp;
        int i = 0;
        while (i < next && !(student[i].compareTo(targetKey) == 0)) {
            i++;
        }
        if (i == next)
            return null;
        node = student[i].deepCopy();
        if (i != 0) {
            temp = student[i - 1];
            student[i] = temp;
        }
        return node;
    }

    public boolean delete(String targetKey) {
        int i = 0;
        while (i < next && !(student[i].compareTo(targetKey) == 0)) {
            i++;
        }
        if (i == next)
            return false;
        student[i] = student[next - 1];
        student[next - 1] = null;
        next = next - 1;
        return true;
    }
    public boolean update(String targetKey, StudentListing newStudentListing) {
        {
            if (delete(targetKey) == false)
                return false;
            else if (insert(newStudentListing) == false)
                return false;
            else
                return true;
        }
    }
    public void showAll()
    {
        for(int i = 0; i < next; i++)
            System.out.println(student[i].toString());
    }
}
