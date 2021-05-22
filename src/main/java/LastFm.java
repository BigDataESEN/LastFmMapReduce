import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class LastFm {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job lastfm = Job.getInstance(conf, "Last FM Job");
        lastfm.setJarByClass(LastFm.class);
        lastfm.setMapperClass(AppMapper.class);
        lastfm.setReducerClass(AppReducer.class);
        lastfm.setOutputKeyClass(Text.class);
        lastfm.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(lastfm, new Path(args[0]));
        FileOutputFormat.setOutputPath(lastfm, new Path(args[1]));
        System.exit(lastfm.waitForCompletion(true) ? 0 : 1);
    }

}
