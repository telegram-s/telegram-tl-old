package org.telegram.tl.builder

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.JavaType
import java.util.ArrayList

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 22.10.13
 * Time: 19:07
 */

fun createTypeFromName(name: String): TLType {
    return if (name == "X"){
        TLTypeAny()
    }else if (name == "!X"){
        TLTypeFunctional("X")
    }else if (name.contains("<") && name.contains(">")){
        var tlName = name.substring(0, name.indexOf("<"))
        var genericName = name.substring(name.indexOf("<") + 1);
        genericName = genericName.substring(0, genericName.indexOf(">"))

        TLTypeGeneric(tlName, array(createTypeFromName(genericName)))
    }
    else {
        TLTypeRaw(name)
    }
}

fun buildFromJson(root: JsonNode): TLDefinition
{
    var sourceConstructors = ArrayList<TLConstructor>()
    var sourceMethods = ArrayList<TLMethod>()

    var constructors = root.get("constructors") as JsonNode
    for(i in constructors)
    {
        var name = i.get("predicate")!!.textValue()!!.toString()

        var id = i.get("id")!!.textValue()!!.toInt()

        var rawType = i.get("type")!!.textValue().toString()

        if (IgnoredTypes.any {(x) -> rawType == x }){
            continue
        }

        var tlType = createTypeFromName(rawType);

        var constructorParameters = ArrayList<TLParameter>()

        var paramsNode = i.get("params");
        for(p in paramsNode!!.iterator()){
            var paramName = p.get("name")!!.textValue().toString()
            var paramType = p.get("type")!!.textValue().toString()
            constructorParameters.add(TLParameter(paramName, createTypeFromName(paramType)));
        }

        sourceConstructors.add(TLConstructor(name, id, constructorParameters, tlType));
    }

    var methods = root.get("methods") as JsonNode
    for(i in methods)
    {
        var name = i.get("method")!!.textValue()!!.toString()

        var id = i.get("id")!!.textValue()!!.toInt()

        var rawType = i.get("type")!!.textValue().toString()

        var tlType = createTypeFromName(rawType);

        var constructorParameters = ArrayList<TLParameter>()

        var paramsNode = i.get("params");
        for(p in paramsNode!!.iterator()){
            var paramName = p.get("name")!!.textValue().toString()
            var paramType = p.get("type")!!.textValue().toString()
            constructorParameters.add(TLParameter(paramName, createTypeFromName(paramType)));
        }

        sourceMethods.add(TLMethod(name, id, constructorParameters, tlType));
    }

    return TLDefinition(sourceConstructors, sourceMethods);
}