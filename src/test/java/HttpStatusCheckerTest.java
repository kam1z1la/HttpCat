import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpRetryException;


class HttpStatusCheckerTest {

    @Test
    void testMethodForStatusCode200() {
        Assertions.assertDoesNotThrow(() -> HttpStatusChecker.getStatusImage(200));
    }

    @Test
    void testMethodForStatusCode302() {
        Assertions.assertDoesNotThrow(() -> HttpStatusChecker.getStatusImage(302));
    }

    @Test
    void testMethodForStatusCode600() {
        Assertions.assertThrows(HttpRetryException.class, ()-> HttpStatusChecker.getStatusImage(600));
    }

    @Test
    void testMethodForStatusCode101() {
        Assertions.assertDoesNotThrow(() -> HttpStatusChecker.getStatusImage(101));
    }
}