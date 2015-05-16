import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by stendu on 5/16/2015.
 */
public class TrxnAvgReducer  extends Reducer<Text,LongWritable,LongWritable,NullWritable> {
    public void reduce(Text key, Iterable<LongWritable> values, Context context)
            throws IOException, InterruptedException {
        Long sum = Long.valueOf(0);
        int counter = 0;
        for (LongWritable val : values) {
            sum = sum + val.get();
            counter++;
        }
        Long average = sum / counter;
        context.write(new LongWritable(average), null);
    }
}