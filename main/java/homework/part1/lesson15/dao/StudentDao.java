package homework.part1.lesson15.dao;

import homework.part1.lesson15.pojo.Student;

public interface StudentDao {
        boolean deleteAll();
        Long addStudent(Student student);
        boolean addStudents(Student[] students);
        Student getStudentId(Long id);

}
