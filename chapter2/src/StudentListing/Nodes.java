package StudentListing;

public class Nodes {
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
        if (next >= size) // Error check if structure is full
            return false;
        student[next] = newStudentListing.deepCopy(); // Deep copy the node
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
        if (i == next) // Error check for node not found
            return null;
        node = student[i].deepCopy(); // Deep copy the node
        if (i != 0) // Move node up if not the first node
        {
            temp = student[i - 1];
            student[i-1] = student[i];
            student[i] = temp;
        }
        return node;
    }

    public boolean delete(String targetKey) {
        int i = 0;
        while (i < next && !(student[i].compareTo(targetKey) == 0)) {
            i++;
        }
        if (i == next) // Error check for node not found
            return false;
        student[i] = student[next - 1]; // Move the last node into the the deleted node's position
        student[next - 1] = null;
        next = next - 1;
        return true; // Node deleted
    }
    public boolean update(String targetKey, StudentListing newStudentListing) {
        {
            if (delete(targetKey) == false) // Error check if node in the structure
                return false;
            else if (insert(newStudentListing) == false) // Error check for insufficient memory
                return false;
            else
                return true; // Node updated
        }
    }
}
