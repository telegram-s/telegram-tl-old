
package org.telegram.api.messages;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public abstract class TLAbsSentEncryptedMessage extends TLObject {

    protected int date;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

}
