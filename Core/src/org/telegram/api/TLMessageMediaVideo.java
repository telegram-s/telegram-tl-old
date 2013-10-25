
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLMessageMediaVideo extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xa2d24290;

    public int getClassId() {
        return CLASS_ID;
    }


    protected org.telegram.api.TLAbsVideo video;


    public org.telegram.api.TLAbsVideo getVideo() {
        return video;
    }

    public void setVideo(org.telegram.api.TLAbsVideo value) {
        this.video = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.video, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.video = (org.telegram.api.TLAbsVideo)readTLObject(stream, context);
    }

}
