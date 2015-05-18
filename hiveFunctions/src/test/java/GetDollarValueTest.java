import org.junit.Assert;
import org.junit.Test;

/**
 * Created by stendu on 5/18/2015.
 */
public class GetDollarValueTest {
    @Test
    public void testUDF()
    {
        GetDollarValue dv = new GetDollarValue();
        //Long value = dv.evaluate("$45");
        //System.out.println(value);
        Assert.assertEquals(new Long(45),dv.evaluate("$45"));
    }
}
