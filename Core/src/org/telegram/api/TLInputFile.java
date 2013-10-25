
package org.telegram.api;

import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;
public class TLInputFile extends TLObject {

    public static final int CLASS_ID = 0xf52ff27f;

    public int getClassId() {
        return CLASS_ID;
    }


    protected long id;

    protected int parts;

    protected String name;

    protected String md5Checksum;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int value) {
        this.parts = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String value) {
        this.md5Checksum = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeInt(this.parts, stream);
        writeTLString(this.name, stream);
        writeTLString(this.md5Checksum, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.parts = readInt(stream);
        this.name = readTLString(stream);
        this.md5Checksum = readTLString(stream);
    }

}
