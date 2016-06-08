/*
 * Automatically generated by jrpcgen 1.0.7 on 6/8/16 1:01 PM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
import org.acplt.oncrpc.*;
import java.io.IOException;

public class consumerRecord implements XdrAble {
    public String topic;
    public int partitionId;
    public long offset;
    public String key;
    public int value;
    public consumerRecord nextConsumerRecord;

    public consumerRecord() {
    }

    public consumerRecord(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        consumerRecord $this = this;
        do {
            xdr.xdrEncodeString($this.topic);
            xdr.xdrEncodeInt($this.partitionId);
            xdr.xdrEncodeLong($this.offset);
            xdr.xdrEncodeString($this.key);
            xdr.xdrEncodeInt($this.value);
            $this = $this.nextConsumerRecord;
            xdr.xdrEncodeBoolean($this != null);
        } while ( $this != null );
    }

    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        consumerRecord $this = this;
        consumerRecord $next;
        do {
            $this.topic = xdr.xdrDecodeString();
            $this.partitionId = xdr.xdrDecodeInt();
            $this.offset = xdr.xdrDecodeLong();
            $this.key = xdr.xdrDecodeString();
            $this.value = xdr.xdrDecodeInt();
            $next = xdr.xdrDecodeBoolean() ? new consumerRecord() : null;
            $this.nextConsumerRecord = $next;
            $this = $next;
        } while ( $this != null );
    }

}
// End of consumerRecord.java
