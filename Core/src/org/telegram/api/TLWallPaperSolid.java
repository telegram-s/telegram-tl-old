
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLWallPaperSolid extends TLAbsWallPaper {
    public static final int CLASS_ID = 0x63117f24;

    public int getClassId() {
        return CLASS_ID;
    }


    protected int bgColor;


    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int value) {
        this.bgColor = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeInt(this.bgColor, stream);
        writeInt(this.color, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.bgColor = readInt(stream);
        this.color = readInt(stream);
    }

}
