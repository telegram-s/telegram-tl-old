package org.telegram.tl.builder

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 25.10.13
 * Time: 0:29
 */

var JavaImports = """
import org.telegram.tl.*;
import java.io.*;

import static org.telegram.tl.StreamingUtils.*;"""

var JavaClassTemplate =
        """
package {package};
""" + JavaImports + """
public class {name} extends TLObject {

    public static final int CLASS_ID = {class_id};

    public int getClassId() {
        return CLASS_ID;
    }

{fields}
{getter-setters}
{serialize}
{deserialize}
}
"""

var JavaContextTemplate =
        """
package {package};
""" + JavaImports + """
public class TLApiContext extends TLContext {

    protected void init() {
{init}
    }
}
"""
var JavaContextIntRecord = """
        registerClass({id}, {type}.class);"""

var JavaMethodTemplate =
        """
package {package};
""" + JavaImports + """
public class {name} extends TLMethod {

    public static final int CLASS_ID = {class_id};

    public int getClassId() {
        return CLASS_ID;
    }

{responseParser}

{fields}
{getter-setters}
{serialize}
{deserialize}
}
"""

var JavaAbsClassTemplate =
        """
package {package};

""" + JavaImports + """

public abstract class {name} extends TLObject {
{fields}
{getter-setters}
}
"""

var JavaChildClassTemplate =
        """
package {package};

""" + JavaImports + """

public class {name} extends {base-name} {
    public static final int CLASS_ID = {class_id};

    public int getClassId() {
        return CLASS_ID;
    }

{fields}
{getter-setters}
{serialize}
{deserialize}
}
"""

var JavaFieldTemplate = """
    protected {type} {int};
"""
var JavaGetterSetterTemplate = """
    public {type} {getter}() {
        return {int};
    }

    public void {setter}({type} value) {
        this.{int} = value;
    }
"""

var JavaDeserializeTemplate = """
    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
{body}
    }
"""

var JavaSerializeTemplate = """
    @Override
    public void serializeBody(OutputStream stream) throws IOException {
{body}
    }
"""

var JavaSerializeInt = """
        writeInt(this.{int}, stream);"""

var JavaDeserializeInt = """
        this.{int} = readInt(stream);"""

var JavaSerializeLong = """
        writeLong(this.{int}, stream);"""

var JavaDeserializeLong = """
        this.{int} = readLong(stream);"""

var JavaSerializeDouble = """
        writeDouble(this.{int}, stream);"""

var JavaDeserializeDouble = """
        this.{int} = readDouble(stream);"""

var JavaSerializeString = """
        writeTLString(this.{int}, stream);"""

var JavaDeserializeString = """
        this.{int} = readTLString(stream);"""

var JavaSerializeBoolean = """
        writeTLBool(this.{int}, stream);"""

var JavaDeserializeBoolean = """
        this.{int} = readTLBool(stream);"""

var JavaSerializeBytes = """
        writeTLBytes(this.{int}, stream);"""

var JavaDeserializeBytes = """
        this.{int} = readTLBytes(stream);"""

var JavaSerializeObject = """
        writeTLObject(this.{int}, stream);"""

var JavaSerializeFunctional = """
        writeTLMethod(this.{int}, stream);"""

var JavaDeserializeObject = """
        this.{int} = ({type})readTLObject(stream, context);"""

var JavaDeserializeFunctional = """
        this.{int} = readTLMethod(stream, context);"""

var JavaSerializeVector = """
        writeTLVector(this.{int}, stream);"""

var JavaDeserializeVector = """
        this.{int} = readTLVector(stream, context);"""

var JavaDeserializeIntVector = """
        this.{int} = readTLIntVector(stream);"""

var JavaDeserializeLongVector = """
        this.{int} = readTLLongVector(stream);"""