package mapper;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper  extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text,Text ,IntWritable>{
	
	public static IntWritable count = new IntWritable(1);
	public static Text word = new Text();
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		String recordLine = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(recordLine, " ");
	
		while (tokenizer.hasMoreTokens()){
			word.set(tokenizer.nextToken());
			context.write(word, count);
		}
	}

	
}
