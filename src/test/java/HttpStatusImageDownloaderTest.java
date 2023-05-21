import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpRetryException;


class HttpStatusImageDownloaderTest {

    @Test
    void testMethodToDownloadStatusImageWhereStatusCode103() {
        Assertions.assertDoesNotThrow(()-> HttpStatusImageDownloader.downloadStatusImage(103));
    }

    @Test
    void testMethodToDownloadStatusImageWhereStatusCode700() {
        Assertions.assertThrows(HttpRetryException.class, ()-> HttpStatusImageDownloader.downloadStatusImage(700));
    }
}