
package org.telegram.api;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public abstract class TLAbsPhotoSize extends TLObject {

    protected String type;


    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

}
