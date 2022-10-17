package singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonScopeTest {

    private static final Logger log = LoggerFactory.getLogger(SingletonScopeTest.class);

    @Resource(name = "bean1")
    CustomerAccount account1;

    @Resource(name = "bean1")
    CustomerAccount duplicateAccount;

    @Resource(name = "bean2")
    CustomerAccount account2;

    @Test
    public void testSingletonScope() {
        log.info(account1.getName());
        log.info(account2.getName());

        log.info("account are equal:: {}", account1 == account2);
        log.info("Duplicate Account :: {}", account1 == duplicateAccount);
    }
}