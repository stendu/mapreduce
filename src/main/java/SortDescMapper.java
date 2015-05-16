import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.TreeMap;

/**
 * Created by stendu on 2/2/2015.
 */
public class SortDescMapper extends Mapper<LongWritable,Text,NullWritable,Text> {

    //private TreeMap<LongWritable,Text> output = new TreeMap<LongWritable, Text>();

    public void map(LongWritable Key,Text value,Context context)
            throws IOException,InterruptedException
    {
        context.write(NullWritable.get(),value);
    }
}
