import org.apache.hadoop.hive.ql.exec.UDF;


/**
 * Created by stendu on 5/18/2015.
 */
public class GetYear extends UDF {
    public String evaluate(String input)
    {
        String inputDate[] = input.split("/");
        return inputDate[2];
    }
}
