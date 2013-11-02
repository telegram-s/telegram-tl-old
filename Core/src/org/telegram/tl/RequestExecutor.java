package org.telegram.tl;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 02.11.13
 * Time: 6:55
 */
public abstract class RequestExecutor {
    public abstract byte[] doRpcCall(byte[] request) throws IOException;
}
