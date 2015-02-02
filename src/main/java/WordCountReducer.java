import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by stendu on 1/31/2015.
 */
public class WordCountReducer extends Reducer<Text,LongWritable,Text,LongWritable> {
    public void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException
    {
        Long sum = Long.valueOf(0);
        for (LongWritable val: values){
            sum = sum + val.get();
        }

    context.write(key, new LongWritable(sum));
    }

}
