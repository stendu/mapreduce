import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.FileInputStream;

/**
 * Created by stendu on 2/2/2015.
 */
public class SortDesc {

    public static void main(String[] args) throws Exception
    {
        Configuration conf = new Configuration();
        Job job = new Job();

        job.setJarByClass(SortDesc.class);
        job.setJobName("Sort Descending");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(SortDescMapper.class);
        job.setReducerClass(SortDescReducer.class);

        job.setNumReduceTasks(1);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        System.exit(job.waitForCompletion(true)? 0:1);
    }
}
