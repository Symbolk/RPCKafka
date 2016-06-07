/*
* Kakfa producer remote API
* According to the Kafka Java producer API 0.9.0---the lateset version
* "Counterpart" indicates the corresponding method in Java producer API
* @see  http://kafka.apache.org/090/javadoc/index.html?org/apache/kafka/clients/producer/KafkaProducer.html
* @author Bo Shen
* @date 20160606
* @version 3.4
*/

/*
* The result of the send requiring acknowledgements
* error==0 : no error; error == -1 : error with errid
*/

union call_result switch(int error){
	case -1: 
		int errid;
	default: /*0*/
		void;
};

program PRODUCER{
	version PRODUCERVERS{
		/* 1, Procedures for produce records */
		/**
		* New a producer client and connect the Kafka Cluster
		* Counterpart : Constructor()
		* @params ...
		*/
		call_result connect(void)=1;

		/**
		* Sends one single data to one single topic, partitioned by key
		* Counterpart : java.util.concurrent.Future<RecordMetadata> send(ProducerRecord<K,V> record)
		* If topic exists, append; if not, create one
		* @params string topic=sensorname
		* @params string key=timestamp(eg. 2016-06-01 12:30:23)
		* @params string value(0-1023)
		*/
		void send(string, string, string)=2;

		/**
		* Asynchronously send a record to a topic and return a bool value  
		* Counterpart : java.util.concurrent.Future<RecordMetadata> send(ProducerRecord<K,V> record, Callback callback)
		* @params string topic=sensorname
		* @params string key=timestamp(eg. 2016-06-01 12:30:23)
		* @params string value(0-1023)
		* @return the result 
		*/
		call_result sendWithAck(string, string, string)=3;

		/* 2, Procedures for flushing and closing */
		/**
		* Invoking this method makes all buffered records immediately available to send
		* Counterpart : void	flush()
		*/
		void flush(void)=4;


		/**
		* Close this producer manually.
		* Counterpart : void	close()
		*/
		void close(void)=5;

		/**
		* Close this producer after a period of time.
		* Counterpart : void	close(long timeout, java.util.concurrent.TimeUnit timeUnit)
		* @params long timeout, with the default timeUnit is ms
		*/
		void closeAfter(hyper int)=6;
	}=1;
}=0x20000001;
