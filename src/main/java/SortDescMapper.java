import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by stendu on 2/2/2015.
 */
public class SortDescMapper extends Mapper<LongWritable,Text,LongWritable,Text> {

    public void map(LongWritable Key,Text value,Context context)
            throws IOException,InterruptedException
    {
        String line = value.toString();
        String[] splits = line.split("\t");
        Integer i = Integer.valueOf(splits[1]);

        context.write(new LongWritable(i),new Text(splits[0]));
    }
}
