import java.io.IOException;
import org.acplt.oncrpc.OncRpcException;
import java.util.Properties;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class consumerServer extends consumerServerStub {

	private static KafkaConsumer<String, Integer> consumer;
	public consumerServer() throws OncRpcException, IOException {
		super();
		Properties props = new Properties();
	    props.put("bootstrap.servers", "192.168.60.120:9092");
	    props.put("group.id", "test");
	    props.put("enable.auto.commit", "true");
	    props.put("auto.commit.interval.ms", "1000");
	    props.put("session.timeout.ms", "30000");
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
    	consumer = new KafkaConsumer<String, Integer>(props);
		
	}

	@Override
	public void subscribe_1(topics ts){
    	//Q1: how to pass a list of topics == ok
    	//consumer.subscribe(Arrays.asList("April15"));
    	StringTokenizer st=new StringTokenizer(ts.value,"+");
    	List<String> topiclist=new ArrayList<String>();
    	while(st.hasMoreTokens()){
    		topiclist.add(st.nextToken());
    	}
		System.out.println(topiclist);
	}
	
    public void unsubscribe_1(){
    	//consumer.unsubscribe();
    }

    public topics subscription_1(){
    	//Q2: how to return a class which can be parsed by C
    	// ArrayList<String> subtopics=consumer.subscription();//downcasting
    	ArrayList<String> subtopics=new ArrayList<String>();
    	topics result=new topics("Topics being subscribing : \n");
    	subtopics.add("Topic1");
    	subtopics.add("Topic2");
    	for(int i=0;i<subtopics.size();++i){
    		result.value=result.value+"Topic"+i+"\n";
    	}
    	return result;
    }

    public partitionInfoList partitionsFor_1(String topic){
    	//Q3: how to return partitionInfo crossing langs
    	partitionInfoList pil=new partitionInfoList();
    	partitionInfo pi=new partitionInfo();
    	return pil;
    }

    public consumerRecordList poll_1(long timeout){
    	consumerRecordList crl=new consumerRecordList();
    	consumerRecord cr=new consumerRecord();
    	try{
    			//poll records just once 
    			ConsumerRecords<String, Integer> records = consumer.poll(timeout);
    			int record_num=records.count();//number of records for all topics
    			/*for(Iterator it = c.iterator(); it.hasNext(); ) {
　　						Object o = it.next();
　　 					//do something
				}*/
				int count = 0;//number of records parsed and passed to C consumerClient,to indicate EOF
    			for (ConsumerRecord<String, Integer> record : records){
    				cr.nextConsumerRecord=new consumerRecord();
    				cr=cr.nextConsumerRecord;
    				if(count==0){
    					crl.value=cr;
    				}
    				
    			}
    	}catch(Exception e){
    		e.printStackTrace(System.out);
    	}
    	return crl;
    }

    public long position_1(String topic, int pid){
 		long position=consumer.position(new TopicPartition(topic,pid));
    	return position;
    }

    public void seek_1(String topic, int pid, long offset){
    	// consumer.seek(new TopicPartition(topic,pid),long offset);
    }

    public void seekToBeginning_1(String topic, int pid){
    	// consumer.seekToBeginning(new TopicPartition(topic,pid));
    }

    public void seekToEnd_1(String topic, int pid){
    	// consumer.seekToEnd(new TopicPartition(topic,pid));
    }

	public void close_1() {
		//consumer.close();
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			consumerServer server = new consumerServer();
			System.out.println("Server Started");
			server.run();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Server stopped.");
	}
}
