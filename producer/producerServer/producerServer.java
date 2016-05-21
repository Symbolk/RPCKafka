import java.io.IOException;
import org.acplt.oncrpc.OncRpcException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class producerServer extends producerServerStub {

	//private static Producer<String, Integer> producer;
	public producerServer() throws OncRpcException, IOException {
		// config & create a producer
		super();
	}

	@Override
	public call_result connect_1(){
		call_result res=new call_result();
		//System.out.println("Connected\n");
    	res.error=0;
    	return res;
	}

	public void send_1(String arg1, String arg2, int arg3){
		//get a bunch of data
		//divide them into 3 groups
		System.out.println("topic="+arg1+"key="+arg2+"value="+arg3);
		//producer.send(new ProducerRecord<String, Integer>(arg1, arg2, new Integer(arg3)));
	}

	public call_result sendWithAck_1(String arg1, String arg2, int arg3){
		call_result res=new call_result();
		res.error=0;
		return res;
		//producer.send(new ProducerRecord<String, Integer>(arg1, arg2, new Integer(arg3)));
	}
	
	public void flush_1(){
		//producer.flush();
	}

	public void close_1() {
		//producer.close();
	}

	public void closeLater_1(long arg1){
		//producer.close(arg1,TimeUnit.MILLISECONDS);
	}

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			producerServer server = new producerServer();
			System.out.println("Server Started");
			server.run();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Server stopped.");
	}
}
