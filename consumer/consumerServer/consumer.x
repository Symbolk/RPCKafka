/*
* Kakfa consumer remote API
* According to the Kafka Java consumer API 0.9.0---the lateset version
* "Counterpart" indicates the corresponding method in Java consumer API
* @see  http://kafka.apache.org/090/javadoc/index.html?org/apache/kafka/clients/consumer/KafkaConsumer.html
* @author Bo Shen
* @date 201601
* @version 3.2
*/

/* Maximum length of topic names */
const MAXTOPICNAMELEN=20;
/* Maximum length of keys */
const MAXKEYLEN=10;

/* Result code for no errors, 0 for Ok */
/*const RESULT_OK=0;*/

/* A list of topics, variable-length, from one to all */
typedef string topics<>;

/* Counterpart : public PartitionInfo(java.lang.String topic, int partition,Node leader,Node[] replicas,Node[] inSyncReplicas)*/
struct partitionInfo{
	string topic<MAXTOPICNAMELEN>;
	int partitionId;
	int leaderBrokerId;
	partitionInfo *nextPartitionInfo;
};
typedef partitionInfo *partitionInfoList;


/* Counerpart : public ConsumerRecord(java.lang.String topic, int partition,long offset,K key,V value) */
struct consumerRecord{
	string topic<MAXTOPICNAMELEN>;
	int partitionId;
	hyper int offset;
	string key<MAXKEYLEN>;
	int value;	
	consumerRecord *nextConsumerRecord;
};
typedef consumerRecord *consumerRecordList;


program CONSUMER{
	version CONSUMERVERS{
		/* 1, Procedures for subscription topics */
		/**
		* Subscribe to the given list of topics to get dynamically assigned partitions.
		* Counterpart : void	subscribe(java.util.List<java.lang.String> topics)
		* @params a string array of topic(s) to be subscribed
		*/
		void subscribe(topics)=1;
		
		/**
		* Unsubscribe from topics currently subscribed with subscribe(List).
		* Counterpart : void	unsubscribe()
		*/
		void unsubscribe(void)=2;
		
		/**
		* Get the current subscription.
		* Counterpart : java.util.Set<java.lang.String>	subscription()
		* @return a list of topic names being subscribed
		*/
		topics subscription(void)=3;

		/** 	
		* Get the partition metadata for the give topic.
		* Counterpart : java.util.List<PartitionInfo>	partitionsFor(java.lang.String topic)
		* @params string topic name
		* @return  a linked list of partitionInfo
		*/
		partitionInfoList partitionsFor(string)=4;

		/* 2, Procedures for fetching records */
		/**
		* Fetch data for the topics or partitions specified using one of the subscribe/assign APIs.
		* Counterpart : ConsumerRecords<K,V>	poll(long timeout)
		* @params long timeout
		* @return 
		*/
		consumerRecordList poll(hyper int)=5;
		
		/* 3, Procedures for controlling positions */
		/**
		* Get the offset of the next record that will be fetched (if a record with that offset exists).
		* Counterpart : long	position(TopicPartition partition)
		* @params string topic, int partitionId
		*/
		hyper int position(string, int)=6;

		/**
		* Overrides the fetch offsets that the consumer will use on the next poll(timeout). To consumer specific records.
		* Counterpart : void	seek(TopicPartition partition, long offset)
		* @params string topic, int partitionId, long offset
		*/
		void seek(string, int, hyper int)=7;

		/** 
		* Seek to the first offset for each of the given partitions. To consume from the begining.
		* Counterpart : void	seekToBeginning(TopicPartition... partitions)
		* @params  string topic, int partitionId
		*/
		void seekToBeginning(string, int)=8;

		/**
		* Seek to the last offset for each of the given partitions.
		* Counterpart : void	seekToEnd(TopicPartition... partitions)
		* @params  string topic, int partitionId
		*/
		void seekToEnd(string, int)=9;

		/* 4, Procedures for closing and cleaning */
		/**
		* Close the consumer, waiting indefinitely for any needed cleanup.
		* Counterpart : void	close()
		*/
		void close(void)=10;
	}=1;
}=0x20000002;
