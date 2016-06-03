package GID.Kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class myProducer {
    public static void main(String[] args){
    	 Properties props = new Properties();
    	 props.put("bootstrap.servers", "138.100.155.79:9092,138.100.155.80:9092,138.100.155.81:9092");
    	 props.put("acks", "all");
    	 props.put("retries", 0);
    	 props.put("batch.size", 16384);
    	 props.put("linger.ms", 1);
    	 props.put("buffer.memory", 33554432);
    	 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    	 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

    	 Producer<String, String> producer = new KafkaProducer<String,String>(props);
    	 for(int i = 0; i < 10; i++)
    	     producer.send(new ProducerRecord<String, String>("light", "2015-06-02 12:23:30", "1200"));

    	 producer.close();
    }
}
