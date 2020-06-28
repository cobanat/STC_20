package homework.part1.lesson15.dao;

import homework.part1.lesson15.ConnectionManager.ConnectionManager;
import homework.part1.lesson15.ConnectionManager.ConnectionManagerJdbcImpl;
import homework.part1.lesson15.TestResultLoggerExtension;
import homework.part1.lesson15.mocks.ResultSetMock;
import homework.part1.lesson15.pojo.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;


@ExtendWith(TestResultLoggerExtension.class)
public class StudentDaoJdbcImplTest {

    private StudentDao studentDao;
    private ConnectionManager connectionManager;
    private Connection        connection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private ResultSet         resultSetMock;


    @BeforeEach
    void setUp() throws SQLException {
        initMocks(this);
        connectionManager = spy(ConnectionManagerJdbcImpl.getInstance());
        connection        = mock(Connection.class);
        studentDao         = spy(new StudentDaoJdbcImpl(connectionManager));
    }

    @Test
    void addStudent() throws SQLException {

        when(connectionManager.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(StudentDaoJdbcImpl.INSERT_INTO_STUDENT, Statement.RETURN_GENERATED_KEYS)).thenReturn(preparedStatement);
        when(preparedStatement.getGeneratedKeys()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);
        when(resultSetMock.getLong(1)).thenReturn(1L);
        String fullName = "Ivanov Ivan Ivanovich";
        Student student = new Student(1, fullName);

        Long result = studentDao.addStudent(student);


        verify(connectionManager, times(1)).getConnection();
        verify(connection, atMost(1)).prepareStatement(StudentDaoJdbcImpl.INSERT_INTO_STUDENT);
        verify(preparedStatement, times(1)).setString(1, fullName);
        verify(preparedStatement, times(1)).executeUpdate();
        assertEquals(1L, result);
    }
    @Test
    void addStudents() throws SQLException {

        when(connectionManager.getConnection()).thenReturn((connection));
        when(connection.prepareStatement(StudentDaoJdbcImpl.INSERT_INTO_STUDENT)).thenReturn(preparedStatement);
        Student[] students = new Student[]{
                new Student(1, "a"),
                new Student(2, "b"),
                new Student(3, "c"),
                new Student(4, "d")
        };

        boolean result = studentDao.addStudents(students);

        verify(connectionManager, times(1)).getConnection();
        verify(connection, atMost(1)).prepareStatement(StudentDaoJdbcImpl.INSERT_INTO_STUDENT);
        verify(preparedStatement, atMost(1)).executeBatch();
        assertEquals(true, result);
    }
    @Test
    void getStudentId() throws SQLException {
        when(connectionManager.getConnection()).thenReturn((connection));
        when(connection.prepareStatement(StudentDaoJdbcImpl.SELECT_FROM_STUDENT)).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery()).thenReturn(resultSetMock);
        when(resultSetMock.next()).thenReturn(true);
        Student student1 = new Student(0, null);
        Student student = studentDao.getStudentId(10L);

        verify(connectionManager, times(1)).getConnection();
        verify(preparedStatement, times(1)).setLong(1, 10L);
        verify(preparedStatement, times(1)).executeQuery();
        verify(resultSetMock, times(1)).getInt(1);
        verify(resultSetMock, times(1)).getString(2);

        assertEquals(student1.getId(), student.getId());

    }
    @Test
    void deleteAll() throws SQLException {
        when(connectionManager.getConnection()).thenReturn((connection));
        when(connection.prepareStatement(StudentDaoJdbcImpl.DELETE_ALL_FROM_STUDENT)).thenReturn(preparedStatement);

        boolean result = studentDao.deleteAll();

        verify(connectionManager, times(1)).getConnection();
        verify(preparedStatement, times(1)).execute();
        assertEquals(true, result);
    }
}
