import org.apache.hadoop.hive.ql.exec.UDF;

/**
 * Created by stendu on 5/18/2015.
 */
public class GetDollarValue extends UDF {
    public Long evaluate(String input)
    {
        String dollarValue = input.replace("$","");
        return new Long(dollarValue);
    }
}
