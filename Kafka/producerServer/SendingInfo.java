import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class SendingInfo implements Callback {
	
	private final long startTime;
	private final String key;
	private final String value;
	private int error;
	/**
	 * Constructor 
	 * @param startTime
	 * @param key
	 * @param value
	 */
	public SendingInfo(long startTime, String key, String value){
		this.startTime=startTime;
		this.key=key;
		this.value=value;
		this.error=-1;
	}
	/**
	 * Print debug info for sending if succeed
	 * Or exception info if fail
	 */
	public void onCompletion(RecordMetadata rm, Exception ecp) {
		// TODO Auto-generated method stub
		long timeCost=System.currentTimeMillis()-startTime;
		if(rm!=null){
			System.out.println("Record : (key="+key+", value="+value+") sent to partition="+rm.partition()+" at offset="+rm.offset()+" in "+timeCost+"ms.");
			this.error=0;
		}else{
			this.error=1;
			ecp.printStackTrace();
		}
	}
	
	/**
	 * Return whether the record has been acked
	 */
	public int isAcked(){
		return error;
	}
}
