import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class AppReducer extends Reducer<Text, Iterable<Text>, Text, IntWritable> {

    @Override
    protected void reduce(Text key, Iterable<Iterable<Text>> values, Context context) throws IOException, InterruptedException {
        Iterator liste = values.iterator();
        HashSet<String> users = new HashSet<String>();
        while(liste.hasNext()){
            Text userid = (Text) liste.next();
            users.add(userid.toString());
        }
        context.write(key, new IntWritable(users.size()));
    }
}
