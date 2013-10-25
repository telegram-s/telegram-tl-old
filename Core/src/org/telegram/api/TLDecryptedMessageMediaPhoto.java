
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLDecryptedMessageMediaPhoto extends TLAbsDecryptedMessageMedia {
    public static final int CLASS_ID = 0x32798a8c;

    public int getClassId() {
        return CLASS_ID;
    }


    protected byte[] thumb;

    protected int thumbW;

    protected int thumbH;

    protected int w;

    protected int h;

    protected int size;

    protected byte[] key;

    protected byte[] iv;


    public byte[] getThumb() {
        return thumb;
    }

    public void setThumb(byte[] value) {
        this.thumb = value;
    }

    public int getThumbW() {
        return thumbW;
    }

    public void setThumbW(int value) {
        this.thumbW = value;
    }

    public int getThumbH() {
        return thumbH;
    }

    public void setThumbH(int value) {
        this.thumbH = value;
    }

    public int getW() {
        return w;
    }

    public void setW(int value) {
        this.w = value;
    }

    public int getH() {
        return h;
    }

    public void setH(int value) {
        this.h = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int value) {
        this.size = value;
    }

    public byte[] getKey() {
        return key;
    }

    public void setKey(byte[] value) {
        this.key = value;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] value) {
        this.iv = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.thumb, stream);
        writeInt(this.thumbW, stream);
        writeInt(this.thumbH, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
        writeInt(this.size, stream);
        writeTLBytes(this.key, stream);
        writeTLBytes(this.iv, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.thumb = readTLBytes(stream);
        this.thumbW = readInt(stream);
        this.thumbH = readInt(stream);
        this.w = readInt(stream);
        this.h = readInt(stream);
        this.size = readInt(stream);
        this.key = readTLBytes(stream);
        this.iv = readTLBytes(stream);
    }

}
