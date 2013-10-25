
package org.telegram.api.messages;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public abstract class TLAbsDhConfig extends TLObject {

    protected byte[] random;


    public byte[] getRandom() {
        return random;
    }

    public void setRandom(byte[] value) {
        this.random = value;
    }

}
