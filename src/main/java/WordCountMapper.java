import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by stendu on 1/31/2015.
 */
public class WordCountMapper extends Mapper<LongWritable,Text,Text,LongWritable> {

    private static final LongWritable one = new LongWritable(1);
    private Text word = new Text();

    public void map(LongWritable Key,Text value, Context context )
        throws IOException,InterruptedException {

        String line = value.toString();
        StringTokenizer tokenizer = new StringTokenizer(line);

        while (tokenizer.hasMoreTokens())
        {
            word.set(tokenizer.nextToken());
            context.write(word,one);
        }
    }

}
