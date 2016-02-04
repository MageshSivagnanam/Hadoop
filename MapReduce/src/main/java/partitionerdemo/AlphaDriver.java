package partitionerdemo;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import mapper.WordCountMapper;
import reducer.WordCountReducer;

public class AlphaDriver  {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

		//
		
				Job job = Job.getInstance();
				
				
				job.setJarByClass(AlphaDriver.class);
				job.setJobName("PartitionerDemo");
			
				
				
				
				job.setMapperClass(AlphaMapper.class);
				job.setReducerClass(AlphaReducer.class);
				job.setPartitionerClass(AlphaPartitioner.class);

				
				job.setNumReduceTasks(6);
				
				job.setMapOutputKeyClass(Text.class);
				job.setMapOutputValueClass(IntWritable.class);
				
				FileInputFormat.addInputPaths(job, args[0]);
				FileOutputFormat.setOutputPath(job, new Path(args[1]));
				
				job.waitForCompletion(true);

	}

}
