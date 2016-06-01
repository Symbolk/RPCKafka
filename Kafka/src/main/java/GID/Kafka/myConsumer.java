package GID.Kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class myConsumer {
   public static void main (String[] args){
	   
	   Properties props = new Properties();
	     props.put("bootstrap.servers", "138.100.155.79:9092,138.100.155.80:9092,138.100.155.81:19092");
	     props.put("group.id", "Mayor");
	     //props.put("client.id", "dashboard");
	     props.put("enable.auto.commit", "true");
	     props.put("auto.commit.interval.ms", "1000");
	     props.put("session.timeout.ms", "30000");
	     props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
	     consumer.subscribe(Arrays.asList("light"));
	     consumer.seekToBeginning();
	     while (true) {
	         ConsumerRecords<String, String> records = consumer.poll(100);
	         for (ConsumerRecord<String, String> record : records)
	             System.out.println("offset = "+record.offset()+",key = "+record.key()+",value = "+record.value());
	     }
   }
}
