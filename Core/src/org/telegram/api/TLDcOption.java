
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLDcOption extends TLObject {

    public static final int CLASS_ID = 0x2ec2a43c;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected String hostname;

    protected String ipAddress;

    protected int port;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String value) {
        this.hostname = value;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int value) {
        this.port = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.hostname, stream);
        writeTLString(this.ipAddress, stream);
        writeInt(this.port, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.hostname = readTLString(stream);
        this.ipAddress = readTLString(stream);
        this.port = readInt(stream);
    }

}
