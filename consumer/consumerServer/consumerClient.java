/*
 * Automatically generated by jrpcgen 1.0.7 on 6/9/16 3:09 AM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
import org.acplt.oncrpc.*;
import java.io.IOException;

import java.net.InetAddress;

/**
 * The class <code>consumerClient</code> implements the client stub proxy
 * for the CONSUMER remote program. It provides method stubs
 * which, when called, in turn call the appropriate remote method (procedure).
 */
public class consumerClient extends OncRpcClientStub {

    /**
     * Constructs a <code>consumerClient</code> client stub proxy object
     * from which the CONSUMER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public consumerClient(InetAddress host, int protocol)
           throws OncRpcException, IOException {
        super(host, consumer.CONSUMER, 1, 0, protocol);
    }

    /**
     * Constructs a <code>consumerClient</code> client stub proxy object
     * from which the CONSUMER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public consumerClient(InetAddress host, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, consumer.CONSUMER, 1, port, protocol);
    }

    /**
     * Constructs a <code>consumerClient</code> client stub proxy object
     * from which the CONSUMER remote program can be accessed.
     * @param client ONC/RPC client connection object implementing a particular
     *   protocol.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public consumerClient(OncRpcClient client)
           throws OncRpcException, IOException {
        super(client);
    }

    /**
     * Constructs a <code>consumerClient</code> client stub proxy object
     * from which the CONSUMER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public consumerClient(InetAddress host, int program, int version, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, 0, protocol);
    }

    /**
     * Constructs a <code>consumerClient</code> client stub proxy object
     * from which the CONSUMER remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public consumerClient(InetAddress host, int program, int version, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, port, protocol);
    }

    /**
     * Call remote procedure connect_1.
     * @return Result from remote procedure call (of type call_result1).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public call_result1 connect_1()
           throws OncRpcException, IOException {
        XdrVoid args$ = XdrVoid.XDR_VOID;
        call_result1 result$ = new call_result1();
        client.call(consumer.connect_1, consumer.CONSUMERVERS, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure subscribe_1.
     * @param arg1 parameter (of type topics) to the remote procedure call.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void subscribe_1(topics arg1)
           throws OncRpcException, IOException {
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(consumer.subscribe_1, consumer.CONSUMERVERS, arg1, result$);
    }

    /**
     * Call remote procedure unsubscribe_1.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void unsubscribe_1()
           throws OncRpcException, IOException {
        XdrVoid args$ = XdrVoid.XDR_VOID;
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(consumer.unsubscribe_1, consumer.CONSUMERVERS, args$, result$);
    }

    /**
     * Call remote procedure subscription_1.
     * @return Result from remote procedure call (of type topics).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public topics subscription_1()
           throws OncRpcException, IOException {
        XdrVoid args$ = XdrVoid.XDR_VOID;
        topics result$ = new topics();
        client.call(consumer.subscription_1, consumer.CONSUMERVERS, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure partitionsFor_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @return Result from remote procedure call (of type partitionInfoList).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public partitionInfoList partitionsFor_1(String arg1)
           throws OncRpcException, IOException {
        XdrString args$ = new XdrString(arg1);
        partitionInfoList result$ = new partitionInfoList();
        client.call(consumer.partitionsFor_1, consumer.CONSUMERVERS, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure poll_1.
     * @param arg1 parameter (of type long) to the remote procedure call.
     * @return Result from remote procedure call (of type consumerRecordList).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public consumerRecordList poll_1(long arg1)
           throws OncRpcException, IOException {
        XdrLong args$ = new XdrLong(arg1);
        consumerRecordList result$ = new consumerRecordList();
        client.call(consumer.poll_1, consumer.CONSUMERVERS, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure position_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @param arg2 parameter (of type int) to the remote procedure call.
     * @return Result from remote procedure call (of type long).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public long position_1(String arg1, int arg2)
           throws OncRpcException, IOException {
        class XdrAble$ implements XdrAble {
            public String arg1;
            public int arg2;
            public void xdrEncode(XdrEncodingStream xdr)
                throws OncRpcException, IOException {
                xdr.xdrEncodeString(arg1);
                xdr.xdrEncodeInt(arg2);
            }
            public void xdrDecode(XdrDecodingStream xdr)
                throws OncRpcException, IOException {
            }
        };
        XdrAble$ args$ = new XdrAble$();
        args$.arg1 = arg1;
        args$.arg2 = arg2;
        XdrLong result$ = new XdrLong();
        client.call(consumer.position_1, consumer.CONSUMERVERS, args$, result$);
        return result$.longValue();
    }

    /**
     * Call remote procedure seek_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @param arg2 parameter (of type int) to the remote procedure call.
     * @param arg3 parameter (of type long) to the remote procedure call.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void seek_1(String arg1, int arg2, long arg3)
           throws OncRpcException, IOException {
        class XdrAble$ implements XdrAble {
            public String arg1;
            public int arg2;
            public long arg3;
            public void xdrEncode(XdrEncodingStream xdr)
                throws OncRpcException, IOException {
                xdr.xdrEncodeString(arg1);
                xdr.xdrEncodeInt(arg2);
                xdr.xdrEncodeLong(arg3);
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
        client.call(consumer.seek_1, consumer.CONSUMERVERS, args$, result$);
    }

    /**
     * Call remote procedure seekToBeginning_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @param arg2 parameter (of type int) to the remote procedure call.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void seekToBeginning_1(String arg1, int arg2)
           throws OncRpcException, IOException {
        class XdrAble$ implements XdrAble {
            public String arg1;
            public int arg2;
            public void xdrEncode(XdrEncodingStream xdr)
                throws OncRpcException, IOException {
                xdr.xdrEncodeString(arg1);
                xdr.xdrEncodeInt(arg2);
            }
            public void xdrDecode(XdrDecodingStream xdr)
                throws OncRpcException, IOException {
            }
        };
        XdrAble$ args$ = new XdrAble$();
        args$.arg1 = arg1;
        args$.arg2 = arg2;
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(consumer.seekToBeginning_1, consumer.CONSUMERVERS, args$, result$);
    }

    /**
     * Call remote procedure seekToEnd_1.
     * @param arg1 parameter (of type String) to the remote procedure call.
     * @param arg2 parameter (of type int) to the remote procedure call.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public void seekToEnd_1(String arg1, int arg2)
           throws OncRpcException, IOException {
        class XdrAble$ implements XdrAble {
            public String arg1;
            public int arg2;
            public void xdrEncode(XdrEncodingStream xdr)
                throws OncRpcException, IOException {
                xdr.xdrEncodeString(arg1);
                xdr.xdrEncodeInt(arg2);
            }
            public void xdrDecode(XdrDecodingStream xdr)
                throws OncRpcException, IOException {
            }
        };
        XdrAble$ args$ = new XdrAble$();
        args$.arg1 = arg1;
        args$.arg2 = arg2;
        XdrVoid result$ = XdrVoid.XDR_VOID;
        client.call(consumer.seekToEnd_1, consumer.CONSUMERVERS, args$, result$);
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
        client.call(consumer.close_1, consumer.CONSUMERVERS, args$, result$);
    }

}
// End of consumerClient.java
