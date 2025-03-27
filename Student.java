
public class Student {
    private int id;
    private String name;
    private String email;
    private int marks;

    public Student(int id, String name, String email, int marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getMarks() { return marks; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setMarks(int marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Email: " + email + " | Marks: " + marks;
    }
}
