package org.telegram.tl;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 16:38
 */
public abstract class TLContext {
    private HashMap<Integer, Class> registeredClasses = new HashMap<Integer, Class>();

    public TLContext() {
        init();
    }

    protected void init() {

    }

    public <T extends TLObject> void registerClass(Class<T> tClass) {
        try {
            int classId = tClass.getField("CLASS_ID").getInt(null);
            registeredClasses.put(classId, tClass);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public <T extends TLObject> void registerClass(int clazzId, Class<T> tClass) {
        registeredClasses.put(clazzId, tClass);
    }

    public TLObject parseMessage(int clazzId, InputStream stream) throws IOException {
        try {
            TLObject message = (TLObject) registeredClasses.get(clazzId).getConstructor().newInstance();
            message.deserializeBody(stream, this);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException();
        }
    }

    public TLObject parseMessage(InputStream stream) throws IOException {
        int clazzId = StreamingUtils.readInt(stream);
        return parseMessage(clazzId, stream);
    }
}
