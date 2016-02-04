package partitionerdemo;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AlphaReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> totalNoOfWord,
			Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
	
		int sum =0;
		while(totalNoOfWord.iterator().hasNext()){
			
			sum = sum+ totalNoOfWord.iterator().next().get();
		}
	
		context.write(key, new IntWritable(sum));
		
	}
	
	
}
