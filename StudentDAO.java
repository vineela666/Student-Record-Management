import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "nareshit");
    }

    public void insertStudent(Student student) throws Exception {
        String sql = "INSERT INTO students VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, student.getId());
        ps.setString(2, student.getName());
        ps.setString(3, student.getEmail());
        ps.setInt(4, student.getMarks());
        ps.executeUpdate();
        ps.close();
    }

    public List<Student> getAllStudents() throws Exception {
        List<Student> list = new ArrayList<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            list.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        }

        rs.close();
        stmt.close();
        return list;
    }

    public Student getStudentById(int id) throws Exception {
        String sql = "SELECT * FROM students WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Student student = null;
        if (rs.next()) {
            student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
        }
        rs.close();
        ps.close();
        return student;
    }

    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE students SET name=?, email=?, marks=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setInt(3, student.getMarks());
        ps.setInt(4, student.getId());
        ps.executeUpdate();
        ps.close();
    }

    public void deleteStudent(int id) throws Exception {
        String sql = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }

    public void close() throws Exception {
        conn.close();
    }
}
