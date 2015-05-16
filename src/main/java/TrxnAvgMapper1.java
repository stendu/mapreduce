import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/**
 * Created by stendu on 5/16/2015.
 */
public class TrxnAvgMapper1 extends Mapper<LongWritable,Text,Text,LongWritable> {

    private Text word = new Text("T");

    public void map(LongWritable Key,Text value, Context context )
            throws IOException,InterruptedException {

        String line = value.toString();
        String[] attributes = line.split(",");

        if (attributes[4].contains("Amount"))
            context.write(word,new LongWritable(0));
        else
        {
            String trxn = attributes[4].replace("$","");
            Long amt = new Long(trxn);
            context.write(word,new LongWritable(amt));
        }

    }

}