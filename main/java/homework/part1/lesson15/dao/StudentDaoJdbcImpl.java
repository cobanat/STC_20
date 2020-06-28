package homework.part1.lesson15.dao;

import homework.part1.lesson15.ConnectionManager.ConnectionManager;
import homework.part1.lesson15.pojo.Student;

import java.sql.*;

public class StudentDaoJdbcImpl implements StudentDao{
    public static final String INSERT_INTO_STUDENT = "INSERT INTO student values (DEFAULT, ?)";
    public static final String SELECT_FROM_STUDENT = "SELECT * FROM student WHERE id = ?";
    public static final String DELETE_ALL_FROM_STUDENT = "DELETE FROM student";
    private ConnectionManager connectionManager;

    public StudentDaoJdbcImpl(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    @Override
    public Long addStudent(Student student) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     INSERT_INTO_STUDENT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.executeUpdate();
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        } catch (SQLException e) {

        }
        return 0L;
    }

    @Override
    public boolean addStudents(Student[] students) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     INSERT_INTO_STUDENT)) {
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint();
            for (Student student : students) {
                preparedStatement.setString(1, student.getFullName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            connection.commit();
            connection.rollback(savepoint);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudentId(Long id) {
        try(Connection connection = connectionManager.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        SELECT_FROM_STUDENT)) {
            preparedStatement.setLong(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Student(
                            resultSet.getInt(1),
                            resultSet.getString(2));
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteAll() {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ALL_FROM_STUDENT)) {
            statement.execute();
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
