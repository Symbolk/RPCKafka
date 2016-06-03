import java.io.IOException;
import org.acplt.oncrpc.OncRpcException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
/**
 * RPC server for kafka producer
 * 
 * @author symbolk
 * @version 3.2
 * @since 20160301
 */
public class producerServer extends producerServerStub {

	/** The global producer object */
	private static Producer<String, String> producer;
	/** The properties/configuration object */
	private static Properties props = new Properties();
	
	/**
	 * Config a producer
	 * 
	 * @throws OncRpcException
	 * @throws IOException
	 */
	public producerServer() throws OncRpcException, IOException {
		super();
		props.put("bootstrap.servers", "138.100.155.79:9092,138.100.155.80:9092,138.100.155.81:9092");
   	 	props.put("acks", "all");
   	 	props.put("retries", 0);
   	 	props.put("batch.size", 16384);
   	 	props.put("linger.ms", 1);
   	 	props.put("buffer.memory", 33554432);
   	 	props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
   	 	props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
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
		producer = new KafkaProducer<String,String>(props);
    	res.error=0;
    	System.out.println("Kafka Connected.");
    	return res;
	}
	
	/**
	 * Send the record to cluster
	 * 
	 * @param topic sensor
	 * @param key timestamp
	 * @param value sensorvalue
	 */
	public void send_1(String topic, String key, String value){
	
		producer.send(new ProducerRecord<String, String>(topic, key, value));
		System.out.println("Record : (key="+key+", value="+value+") sent to topic="+topic+".");
		//producer.send(new ProducerRecord<String, Integer>(arg1, arg2, new Integer(arg3)));
	}
	
	/**
	 * Asynchronously send the record to cluster
	 * 
	 * @param topic sensor
	 * @param key timestamp
	 * @param value sensorvalue
	 */
	public call_result sendWithAck_1(String topic, String key, String value){
		call_result res=new call_result();
		long startTime=System.currentTimeMillis();
		SendingInfo si=new SendingInfo(startTime,key,value);
		producer.send(new ProducerRecord<String, String>(topic, key, value),si);
		res.error=si.isAcked();
		return res;
	}
	
	/**
	 * Flush the buffer by hand to send all buffered records
	 */
	public void flush_1(){
		producer.flush();
	}

	/**
	 * Close the producer by hand now
	 */
	public void close_1() {
		producer.close();
	}

	/**
	 * Close the producer after a specific time
	 * 
	 * @param time timeperiod
	 */
	public void closeAfter_1(long time){
		producer.close(time,TimeUnit.MILLISECONDS);
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			producerServer server = new producerServer();
			System.out.println("Producer Server Started.");
			server.run();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Producer Server Stopped.");
	}
}
