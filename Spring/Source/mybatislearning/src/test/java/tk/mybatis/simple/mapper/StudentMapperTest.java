package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.model.Student;

import java.util.List;

public class StudentMapperTest extends BaseMapperTest {
    @Test
    public void testSelectAll() {
        SqlSession sqlSession = getSqlSession();
        List<Student> students1 = sqlSession.getMapper(StudentMapper.class).selectAll();
        students1.stream().forEach(System.out::println);

        List<Student> students2 = sqlSession.getMapper(StudentMapper.class).selectAll2();
        students2.stream().forEach(System.out::println);

        sqlSession.close();
    }
}
