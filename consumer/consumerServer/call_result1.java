/*
 * Automatically generated by jrpcgen 1.0.7 on 6/9/16 3:09 AM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
import org.acplt.oncrpc.*;
import java.io.IOException;

public class call_result1 implements XdrAble {
    public int error;
    public int errid;

    public call_result1() {
    }

    public call_result1(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        xdr.xdrEncodeInt(error);
        switch ( error ) {
        case -1:
            xdr.xdrEncodeInt(errid);
            break;
        default:
            break;
        }
    }

    public void xdrDecode(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        error = xdr.xdrDecodeInt();
        switch ( error ) {
        case -1:
            errid = xdr.xdrDecodeInt();
            break;
        default:
            break;
        }
    }

}
// End of call_result1.java
