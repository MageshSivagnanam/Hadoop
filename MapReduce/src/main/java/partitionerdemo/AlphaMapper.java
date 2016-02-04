package partitionerdemo;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AlphaMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

	
	IntWritable count = new IntWritable(1);
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
	
		String record = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(record, " ");
		while(tokenizer.hasMoreTokens()){
			context.write(new Text(tokenizer.nextToken()),count);
		}
	}
	
	
	
	
}
