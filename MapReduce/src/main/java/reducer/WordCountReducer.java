package reducer;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordCountReducer extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable>{

	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> noOfCounts,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

		int wordCount = 0;
		while(noOfCounts.iterator().hasNext()){
			wordCount = wordCount + noOfCounts.iterator().next().get();
		}
		context.write(key, new IntWritable(wordCount));
	}
	
	
	
	


}
