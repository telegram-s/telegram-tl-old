package org.telegram.tl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 15:53
 */
public class StreamingUtils {
    public static void writeByte(int v, OutputStream stream) throws IOException {
        stream.write(v);
    }

    public static void writeByte(byte v, OutputStream stream) throws IOException {
        stream.write(v);
    }

    public static void writeInt(int v, OutputStream stream) throws IOException {
        writeByte((byte) (v & 0xFF), stream);
        writeByte((byte) ((v >> 8) & 0xFF), stream);
        writeByte((byte) ((v >> 16) & 0xFF), stream);
        writeByte((byte) ((v >> 24) & 0xFF), stream);
    }

    public static void writeLong(long v, OutputStream stream) throws IOException {
        writeByte((byte) (v & 0xFF), stream);
        writeByte((byte) ((v >> 8) & 0xFF), stream);
        writeByte((byte) ((v >> 16) & 0xFF), stream);
        writeByte((byte) ((v >> 24) & 0xFF), stream);

        writeByte((byte) ((v >> 32) & 0xFF), stream);
        writeByte((byte) ((v >> 40) & 0xFF), stream);
        writeByte((byte) ((v >> 48) & 0xFF), stream);
        writeByte((byte) ((v >> 56) & 0xFF), stream);
    }

    public static void writeDouble(double v, OutputStream stream) throws IOException {
        writeLong(Double.doubleToLongBits(v), stream);
    }

    public static void writeByteArray(byte[] data, OutputStream stream) throws IOException {
        stream.write(data);
    }

    public static void writeTLBool(boolean v, OutputStream stream) throws IOException {
        if (v) {
            writeInt(TLBoolTrue.CLASS_ID, stream);
        } else {
            writeInt(TLBoolFalse.CLASS_ID, stream);
        }
    }

    public static void writeTLString(String v, OutputStream stream) throws IOException {
        writeTLBytes(v.getBytes(), stream);
    }

    public static void writeTLBytes(byte[] v, OutputStream stream) throws IOException {
        int startOffset = 1;
        if (v.length >= 254) {
            startOffset = 4;
            writeByte(254, stream);
            writeByte(v.length & 0xFF, stream);
            writeByte((v.length >> 8) & 0xFF, stream);
            writeByte((v.length >> 16) & 0xFF, stream);
        } else {
            writeByte(v.length, stream);
        }

        writeByteArray(v, stream);

        int offset = (v.length + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            writeByteArray(new byte[offsetCount], stream);
        }
    }

    public static void writeTLObject(TLObject v, OutputStream stream) throws IOException {
        v.serialize(stream);
    }

    public static void writeTLMethod(TLMethod v, OutputStream stream) throws IOException {
        writeTLObject(v, stream);
    }

    public static void writeTLVector(TLVector v, OutputStream stream) throws IOException {
        writeTLObject(v, stream);
    }


    public static int readInt(InputStream stream) throws IOException {
        int a = stream.read();
        if (a < 0) {
            throw new IOException();
        }
        int b = stream.read();
        if (b < 0) {
            throw new IOException();
        }
        int c = stream.read();
        if (c < 0) {
            throw new IOException();
        }
        int d = stream.read();
        if (d < 0) {
            throw new IOException();
        }

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    public static long readUInt(InputStream stream) throws IOException {
        long a = stream.read();
        if (a < 0) {
            throw new IOException();
        }
        long b = stream.read();
        if (b < 0) {
            throw new IOException();
        }
        long c = stream.read();
        if (c < 0) {
            throw new IOException();
        }
        long d = stream.read();
        if (d < 0) {
            throw new IOException();
        }

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    public static long readLong(InputStream stream) throws IOException {
        long a = readUInt(stream);
        long b = readUInt(stream);

        return a + (b << 32);
    }

    public static double readDouble(InputStream stream) throws IOException {
        return Double.longBitsToDouble(readLong(stream));
    }

    public static String readTLString(InputStream stream) throws IOException {
        return new String(readTLBytes(stream));
    }

    public static TLObject readTLObject(InputStream stream, TLContext context) throws IOException {
        return context.deserializeMessage(stream);
    }

    public static TLMethod readTLMethod(InputStream stream, TLContext context) throws IOException {
        return (TLMethod) context.deserializeMessage(stream);
    }

    public static byte[] readBytes(int count, InputStream stream) throws IOException {
        byte[] res = new byte[count];
        int offset = 0;
        while (offset < res.length) {
            int readed = stream.read(res, offset, res.length - offset);
            if (readed > 0) {
                offset += readed;
            } else if (readed < 0) {
                throw new IOException();
            } else {
                Thread.yield();
            }
        }
        return res;
    }

    public static byte[] readTLBytes(InputStream stream) throws IOException {
        int count = stream.read();
        int startOffset = 1;
        if (count >= 254) {
            count = stream.read() + (stream.read() << 8) + (stream.read() << 16);
            startOffset = 4;
        }

        byte[] raw = readBytes(count, stream);
        int offset = (count + startOffset) % 4;
        if (offset != 0) {
            int offsetCount = 4 - offset;
            readBytes(offsetCount, stream);
        }

        return raw;
    }

    public static TLVector readTLVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeVector(stream);
    }

    public static TLIntVector readTLIntVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeIntVector(stream);
    }

    public static TLLongVector readTLLongVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeLongVector(stream);
    }

    public static TLStringVector readTLStringVector(InputStream stream, TLContext context) throws IOException {
        return context.deserializeStringVector(stream);
    }

    public static boolean readTLBool(InputStream stream) throws IOException {
        int v = readInt(stream);
        if (v == TLBoolTrue.CLASS_ID) {
            return true;
        } else if (v == TLBoolFalse.CLASS_ID) {
            return false;
        } else
            throw new DeserializeException("Not bool value: " + Integer.toHexString(v));
    }

    public static byte[] intToBytes(int value) {
        return new byte[]{
                (byte) (value & 0xFF),
                (byte) ((value >> 8) & 0xFF),
                (byte) ((value >> 16) & 0xFF),
                (byte) ((value >> 24) & 0xFF)};
    }

    public static int readInt(byte[] src) {
        return readInt(src, 0);
    }

    public static int readInt(byte[] src, int offset) {
        int a = src[offset + 0] & 0xFF;
        int b = src[offset + 1] & 0xFF;
        int c = src[offset + 2] & 0xFF;
        int d = src[offset + 3] & 0xFF;

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    public static long readUInt(byte[] src) {
        return readUInt(src, 0);
    }

    public static long readUInt(byte[] src, int offset) {
        int a = src[offset + 0] & 0xFF;
        int b = src[offset + 1] & 0xFF;
        int c = src[offset + 2] & 0xFF;
        int d = src[offset + 3] & 0xFF;

        return a + (b << 8) + (c << 16) + (d << 24);
    }

    public static long readLong(byte[] src, int offset) {
        long a = readUInt(src, offset);
        long b = readUInt(src, offset + 4);

        return a + (b << 32);
    }
}
