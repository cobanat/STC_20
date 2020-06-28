package homework.part1.lesson15;

import homework.part1.lesson15.ConnectionManager.ConnectionManager;
import homework.part1.lesson15.ConnectionManager.ConnectionManagerJdbcImpl;
import homework.part1.lesson15.dao.StudentDao;
import homework.part1.lesson15.dao.StudentDaoJdbcImpl;
import homework.part1.lesson15.pojo.Student;

public class Main {

    public static void main(String[] args) {
        ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
        StudentDao studentDao = new StudentDaoJdbcImpl(connectionManager);
        studentDao.deleteAll();
        Student student = new Student(null, "Zinnurov Nail Faritovich");
        Long id = studentDao.addStudent(student);

        Student secondStudent = studentDao.getStudentId(id);
        System.out.println(secondStudent.toString());

        Student[] students = new Student[]{
                new Student(null, "a"),
                new Student(null, "b"),
                new Student(null, "c"),
                new Student(null, "d")
        };
        studentDao.addStudents(students);
    }
}
