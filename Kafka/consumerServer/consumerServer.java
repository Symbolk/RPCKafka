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


/**
 * RPC server for kafka consumer
 * 
 * @author symbolk
 * @version 3.2
 * @since 20160301
 */
public class consumerServer extends consumerServerStub {

	/** The global producer object */
    private static KafkaConsumer<String, Integer> consumer;
    /** The properties/configuration object */
    private static Properties props = new Properties();

    /**
     * Config a producer
     * 
     * @throws OncRpcException
     * @throws IOException
     */
	public consumerServer() throws OncRpcException, IOException {
		Properties props = new Properties();
	    props.put("bootstrap.servers", "192.168.60.120:9092");
	    props.put("group.id", "test");
	    props.put("enable.auto.commit", "true");
	    props.put("auto.commit.interval.ms", "1000");
	    props.put("session.timeout.ms", "30000");
	    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	    props.put("value.deserializer", "org.apache.kafka.common.serialization.IntegerDeserializer");
		super();
	}

    /**
     * Connect to cluster
     * 
     * @return call_result, 0 is no error(all ok)
     */
    @Override
    public call_result connect_1(){
        // create a producer
        System.out.println("Kafka Connecting...");
        call_result res=new call_result();
        consumer = new KafkaConsumer<String, Integer>(props);;
        res.error=0;
        System.out.println("Kafka Connected.");
        return res;
    }

    /**
     * Subscribe to a list of topics
     *
     * @param a string of topic names concated by +
     */
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
	
    /**
     * Unsubscribe the current topics
     *
     */
    public void unsubscribe_1(){
    	consumer.unsubscribe();
    }

    /**
     * Get the current topics names
     *
     * @return a string of topic names
     */
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

    /**
     * Get the partition infos of a topic
     *
     * @param topic name
     * @return a list of partition infos
     */
    public partitionInfoList partitionsFor_1(String topic){
    	//Q3: how to return partitionInfo crossing langs
    	partitionInfoList pil=new partitionInfoList();
    	partitionInfo pi=new partitionInfo();
    	return pil;
    }

     /**
     * Consume records from the topic
     *
     * @param time period to poll records
     * @return a list of records consumed
     */
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
    				cr.
    			}
    	}catch(Exception e){
    		e.printStackTrace(System.out);
    	}
    	return crl;
    }

    /**
     * Get the current offset in one partition of a topic
     *
     * @param topic topicname
     * @param pid partition id
     * @return offset 
     */
    public long position_1(String topic, int pid){
 		long position=consumer.position(new TopicPartition(topic,pid));
    	return position;
    }

    /**
     * Set the current offset to one specific position in one partition of a topic
     *
     * @param topic topicname
     * @param pid partition id
     * @param offset position
     * @return offset 
     */
    public void seek_1(String topic, int pid, long offset){
    	consumer.seek(new TopicPartition(topic,pid),long offset);
    }

    /**
     * Set the current offset to the beginning of one partition of a topic
     *
     * @param topic topicname
     * @param pid partition id
     */
    public void seekToBeginning_1(String topic, int pid){
    	consumer.seekToBeginning(new TopicPartition(topic,pid));
    }

    /**
     * Set the current offset to the end of one partition of a topic
     *
     * @param topic topicname
     * @param pid partition id
     */
    public void seekToEnd_1(String topic, int pid){
    	consumer.seekToEnd(new TopicPartition(topic,pid));
    }

    /**
     * Close the consumer by hand now
     */
	public void close_1() {
		consumer.close();
	}

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			consumerServer server = new consumerServer();
			System.out.println("Consumer Server Started");
			server.run();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Consumer Server Stopped.");
	}
}
