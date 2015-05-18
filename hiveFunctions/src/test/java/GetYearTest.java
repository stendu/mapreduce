
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by stendu on 5/18/2015.
 */
public class GetYearTest {
    @Test
    public void TestUDF()
    {
        GetYear GY = new GetYear();
        Assert.assertEquals("2005", GY.evaluate("3/12/2005"));
    }
}
