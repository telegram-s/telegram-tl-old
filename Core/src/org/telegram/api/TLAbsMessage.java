
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public abstract class TLAbsMessage extends TLObject {

    protected int id;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

}
