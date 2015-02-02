import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.TreeMap;

/**
 * Created by stendu on 2/2/2015.
 */
public class SortDescReducer extends Reducer<LongWritable,Text,LongWritable,Text>
{
    private static Logger LOGGER=Logger.getLogger(SortDescReducer.class);


    public void reduce(LongWritable key, Iterable<Text> values, Reducer.Context context)
            throws IOException, InterruptedException
    {
        Globals counter = new Globals();
        TreeMap<LongWritable,Text> output = new TreeMap<LongWritable, Text>();

        for (Text txt: values ) {
            output.put(key,txt);
          if (output.size() >10) {
                output.remove(output.firstKey());

          }
        }
        for (Text t: output.values())
        {
            context.write(key, t);
        }


    }

}

