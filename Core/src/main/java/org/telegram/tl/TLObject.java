package org.telegram.tl;

import java.io.*;
import java.util.HashMap;

import static org.telegram.tl.StreamingUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 15:41
 */
public abstract class TLObject implements Serializable {

    public abstract int getClassId();

    public byte[] serialize() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        serialize(stream);
        return stream.toByteArray();
    }

    public void serialize(OutputStream stream) throws IOException {
        writeInt(getClassId(), stream);
        serializeBody(stream);
    }

    public void deserialize(InputStream stream, TLContext context) throws IOException {
        int classId = readInt(stream);
        if (classId != getClassId()) {
            throw new DeserializeException("Wrong class id. Founded:" + Integer.toHexString(classId) +
                    ", expected: " + Integer.toHexString(getClassId()));
        }
        deserializeBody(stream, context);
    }

    public void serializeBody(OutputStream stream) throws IOException {

    }

    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

    }
}
