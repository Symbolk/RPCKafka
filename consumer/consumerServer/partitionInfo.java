/*
 * Automatically generated by jrpcgen 1.0.7 on 6/7/16 3:40 AM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
import org.acplt.oncrpc.*;
import java.io.IOException;

public class partitionInfo implements XdrAble {
    public String topic;
    public int partitionId;
    public int leaderBrokerId;
    public partitionInfo nextPartitionInfo;

    public partitionInfo() {
    }

    public partitionInfo(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        partitionInfo $this = this;
        do {
            xdr.xdrEncodeString($this.topic);
            xdr.xdrEncodeInt($this.partitionId);
            xdr.xdrEncodeInt($this.leaderBrokerId);
            $this = $this.nextPartitionInfo;
            xdr.xdrEncodeBoolean($this != null);
        } while ( $this != null );
    }

    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        partitionInfo $this = this;
        partitionInfo $next;
        do {
            $this.topic = xdr.xdrDecodeString();
            $this.partitionId = xdr.xdrDecodeInt();
            $this.leaderBrokerId = xdr.xdrDecodeInt();
            $next = xdr.xdrDecodeBoolean() ? new partitionInfo() : null;
            $this.nextPartitionInfo = $next;
            $this = $next;
        } while ( $this != null );
    }

}
// End of partitionInfo.java
