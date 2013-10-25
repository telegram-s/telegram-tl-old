package org.telegram.tl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import static org.telegram.tl.StreamingUtils.*;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 15:41
 */
public abstract class TLObject {

    public abstract int getClassId();

    public void serialize(OutputStream stream) throws IOException {
        writeInt(getClassId(), stream);
        serializeBody(stream);
    }

    public void deserialize(InputStream stream, TLContext context) throws IOException {
        int classId = readInt(stream);
        deserializeBody(stream, context);
    }

    public void serializeBody(OutputStream stream) throws IOException {

    }

    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

    }
}
