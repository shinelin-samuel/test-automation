import com.shin.MySpringBootApplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS,
        args = "--app.test=one")
@ContextConfiguration(classes = MySpringBootApplication.class)
public class MySpringBootApplicationTest {

    @BeforeAll
    public static void setUp() {

    }
    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

    @Test
    void applicationArgumentsPopulated(@Autowired ApplicationArguments args) {
        assertThat(args.getOptionNames()).containsOnly("app.test");
        assertThat(args.getOptionValues("app.test")).containsOnly("one");

        assertThat(args.getOptionValues("app.test").get(0)).hasToString("one");
    }
}
