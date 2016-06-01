/*
 * Automatically generated by jrpcgen 1.0.7 on 5/30/16 6:21 AM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
import org.acplt.oncrpc.*;
import java.io.IOException;

public class call_result implements XdrAble {
    public int error;
    public int errno;

    public call_result() {
    }

    public call_result(XdrDecodingStream xdr)
           throws OncRpcException, IOException {
        xdrDecode(xdr);
    }

    public void xdrEncode(XdrEncodingStream xdr)
           throws OncRpcException, IOException {
        xdr.xdrEncodeInt(error);
        switch ( error ) {
        case -1:
            xdr.xdrEncodeInt(errno);
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
            errno = xdr.xdrDecodeInt();
            break;
        default:
            break;
        }
    }

}
// End of call_result.java
