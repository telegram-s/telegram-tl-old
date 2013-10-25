
package org.telegram.api.requests;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLRequestInitConnection extends TLMethod {

    public static final int CLASS_ID = 0x3fc12e08;

    public int getClassId() {
        return CLASS_ID;
    }




    protected int apiId;

    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected TLMethod query;


    public int getApiId() {
        return apiId;
    }

    public void setApiId(int value) {
        this.apiId = value;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String value) {
        this.deviceModel = value;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String value) {
        this.systemVersion = value;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String value) {
        this.appVersion = value;
    }

    public TLMethod getQuery() {
        return query;
    }

    public void setQuery(TLMethod value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.apiId, stream);
        writeTLString(this.deviceModel, stream);
        writeTLString(this.systemVersion, stream);
        writeTLString(this.appVersion, stream);
        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.apiId = readInt(stream);
        this.deviceModel = readTLString(stream);
        this.systemVersion = readTLString(stream);
        this.appVersion = readTLString(stream);
        this.query = readTLMethod(stream, context);
    }

}
