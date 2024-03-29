import com.jvhuaxia.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class TestDao {

  @Autowired
  UserDao userDao;

  @Test
  public void testUser() {
    System.out.println(userDao.selectOne("A0001"));
  }
}
