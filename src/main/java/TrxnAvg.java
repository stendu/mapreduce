import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by stendu on 5/16/2015.
 */
public class TrxnAvg {
    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job();
        //JobConf job = new JobConf();
        job.setJarByClass(TrxnAvg.class);
        job.setJobName("Calculate average Transaction");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, TrxnAvgMapper1.class);
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, TrxnAvgMapper2.class);

        FileOutputFormat.setOutputPath(job, new Path(args[2]));

        job.setReducerClass(TrxnAvgReducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(LongWritable.class);

        //job.setNumReduceTasks(1);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
