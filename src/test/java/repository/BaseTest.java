package repository;

import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;

/**
 * @author Oliver Gierke
 */
public abstract class BaseTest extends AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData()  {
        try {
            if (countRowsInTable("Customer") == 0) {
                executeSqlScript("classpath:data.sql", false);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
