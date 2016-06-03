/*
 * Automatically generated by jrpcgen 1.0.7 on 6/3/16 5:56 AM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
import org.acplt.oncrpc.*;
import java.io.IOException;

import java.net.InetAddress;

/**
 * The class <code>producerClient</code> implements the client stub proxy
 * for the PRODUCER remote program. It provides method stubs
 * which, when called, in turn call the appropriate remote method (procedure).
 */
public class producerClient extends OncRpcClientStub {

    /**
     * Constructs a <code>producerClient</code> client stub proxy object
     * from which the PRODUCER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public producerClient(InetAddress host, int protocol)
           throws OncRpcException, IOException {
        super(host, producer.PRODUCER, 1, 0, protocol);
    }

    /**
     * Constructs a <code>producerClient</code> client stub proxy object
     * from which the PRODUCER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public producerClient(InetAddress host, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, producer.PRODUCER, 1, port, protocol);
    }

    /**
     * Constructs a <code>producerClient</code> client stub proxy object
     * from which the PRODUCER remote program can be accessed.
     * @param client ONC/RPC client connection object implementing a particular
     *   protocol.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public producerClient(OncRpcClient client)
           throws OncRpcException, IOException {
        super(client);
    }

    /**
     * Constructs a <code>producerClient</code> client stub proxy object
     * from which the PRODUCER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public producerClient(InetAddress host, int program, int version, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, 0, protocol);
    }

    /**
     * Constructs a <code>producerClient</code> client stub proxy object
     * from which the PRODUCER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public producerClient(InetAddress host, int program, int version, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, port, protocol);
    }

    /**
     * Call remote procedure connect_1.
     * @return Result from remote procedure call (of type call_result).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public call_result connect_1()
           throws OncRpcException, IOException {
        XdrVoid args$ = XdrVoid.XDR_VOID;
        call_result result$ = new call_result();
        client.call(producer.connect_1, producer.PRODUCERVERS, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure send_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @param arg2 parameter (of type String) to the remote procedure call.
     * @param arg3 parameter (of type String) to the remote procedure call.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void send_1(String arg1, String arg2, String arg3)
           throws OncRpcException, IOException {
        class XdrAble$ implements XdrAble {
            public String arg1;
            public String arg2;
            public String arg3;
            public void xdrEncode(XdrEncodingStream xdr)
                throws OncRpcException, IOException {
                xdr.xdrEncodeString(arg1);
                xdr.xdrEncodeString(arg2);
                xdr.xdrEncodeString(arg3);
            }
            public void xdrDecode(XdrDecodingStream xdr)
                throws OncRpcException, IOException {
            }
        };
        XdrAble$ args$ = new XdrAble$();
        args$.arg1 = arg1;
        args$.arg2 = arg2;
        args$.arg3 = arg3;
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(producer.send_1, producer.PRODUCERVERS, args$, result$);
    }

    /**
     * Call remote procedure sendWithAck_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @param arg2 parameter (of type String) to the remote procedure call.
     * @param arg3 parameter (of type String) to the remote procedure call.
     * @return Result from remote procedure call (of type call_result).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public call_result sendWithAck_1(String arg1, String arg2, String arg3)
           throws OncRpcException, IOException {
        class XdrAble$ implements XdrAble {
            public String arg1;
            public String arg2;
            public String arg3;
            public void xdrEncode(XdrEncodingStream xdr)
                throws OncRpcException, IOException {
                xdr.xdrEncodeString(arg1);
                xdr.xdrEncodeString(arg2);
                xdr.xdrEncodeString(arg3);
            }
            public void xdrDecode(XdrDecodingStream xdr)
                throws OncRpcException, IOException {
            }
        };
        XdrAble$ args$ = new XdrAble$();
        args$.arg1 = arg1;
        args$.arg2 = arg2;
        args$.arg3 = arg3;
        call_result result$ = new call_result();
        client.call(producer.sendWithAck_1, producer.PRODUCERVERS, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure flush_1.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void flush_1()
           throws OncRpcException, IOException {
        XdrVoid args$ = XdrVoid.XDR_VOID;
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(producer.flush_1, producer.PRODUCERVERS, args$, result$);
    }

    /**
     * Call remote procedure close_1.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void close_1()
           throws OncRpcException, IOException {
        XdrVoid args$ = XdrVoid.XDR_VOID;
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(producer.close_1, producer.PRODUCERVERS, args$, result$);
    }

    /**
     * Call remote procedure closeAfter_1.
     * @param arg1 parameter (of type long) to the remote procedure call.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void closeAfter_1(long arg1)
           throws OncRpcException, IOException {
        XdrLong args$ = new XdrLong(arg1);
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(producer.closeAfter_1, producer.PRODUCERVERS, args$, result$);
    }

}
// End of producerClient.java
