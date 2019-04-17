import com.jvhuaxia.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:/spring/*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAll {

  @Autowired
  UserService userService;

  @Test
  public void testService() {
    System.out.println(userService.getUser("Admin"));
  }

}
