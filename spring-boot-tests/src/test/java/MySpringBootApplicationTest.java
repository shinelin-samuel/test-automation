import com.shin.MySpringBootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
@ContextConfiguration(classes = MySpringBootApplication.class)
public class MySpringBootApplicationTest {

    @Test
    void exampleTest() {

    }

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }
}
