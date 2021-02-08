package dnt.com.androidbestpractices;

import com.dnt.libsample.Utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testLibModule() {
        byte[] input = "xxxxabcxxxx".getBytes();
        byte[] delimiter = "abc".getBytes();
        List<byte[]> result = Utils.splitBytes(input, delimiter);
        assertEquals(2, result.size());
    }
}