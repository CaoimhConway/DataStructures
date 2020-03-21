import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByN {
    OffByN offBy1 = new OffByN(1);
    OffByN offBy5 = new OffByN(5);

    @Test
    public void testOffByN() {
        assertTrue(offBy1.equalChars('a', 'b'));
        assertTrue(offBy1.equalChars('a', 'f'));
    }
}
