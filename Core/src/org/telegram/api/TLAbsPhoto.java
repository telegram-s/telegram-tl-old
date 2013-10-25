
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public abstract class TLAbsPhoto extends TLObject {

    protected long id;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

}
