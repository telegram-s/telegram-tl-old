
package org.telegram.api.storage;


import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;

public class TLStorageFileUnknown extends TLAbsFileType {
    public static final int CLASS_ID = 0xaa963b05;

    public int getClassId() {
        return CLASS_ID;
    }





}
