import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by stendu on 2/2/2015.
 */
public class SortDescReducer extends Reducer<NullWritable,Text,NullWritable,Text>
{
    //private TreeMap<Integer,Text> outputs = new TreeMap<Integer, Text>();
    private TreeMap<Text,Text> outputs = new TreeMap<Text, Text>();

    public void reduce(NullWritable key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException
    {
        for (Text txt: values ) {
            //String line = txt.toString();
            //String[] splits = line.split("\t");
            //Integer i = Integer.valueOf(splits[0]);

            outputs.put(txt,txt);

              if (outputs.size() > 20) {
                outputs.remove(outputs.firstKey());
          }
        }
        Set<Text> keyvalue = outputs.descendingMap().keySet();
        for (Text t: keyvalue)
        {
            context.write(NullWritable.get(), outputs.get(t));
        }


    }

}

