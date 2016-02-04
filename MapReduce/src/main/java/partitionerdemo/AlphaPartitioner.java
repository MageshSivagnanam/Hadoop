package partitionerdemo;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AlphaPartitioner extends Partitioner<Text, IntWritable> {

	@Override
	public int getPartition(Text key, IntWritable count, int noOfPartitions) {
		
		int partitionNum = 0 ;
		
		switch (key.toString()) {
		
		case "a":
			partitionNum = 0;
			break;
		case "b":
			partitionNum = 1;
			break ;
		case "c":
			partitionNum = 2;
			break ;
		case "d":
			partitionNum = 3;
			break ;
		case "e":
			partitionNum = 4;
			break ;
		
		case "f":
			partitionNum = 5;
			break ;
			
		default:
			partitionNum = 5;
			break;
		}
		
		return partitionNum;
		
	}

	

}
