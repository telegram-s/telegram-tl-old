package org.telegram.tl.builder

import java.util.ArrayList
import java.io.File
import java.nio.charset.Charset
import java.util.HashMap

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 23.10.13
 * Time: 13:09
 */

fun convertToJavaModel(model: TLModel): JavaModel
{
    var javaTypes = HashMap<String, JavaTypeObject>()

    for(t in model.types)
    {
        if (t is TLCombinedTypeDef)
        {
            var combinedType = t as TLCombinedTypeDef
            javaTypes.put(combinedType.name, JavaTypeObject(combinedType))
        }
    }

    var javaMethods = ArrayList<JavaRpcMethod>()

    for(t in model.methods){
        javaMethods.add(JavaRpcMethod(t))
    }

    for(t in javaTypes.values())
    {
        for(p in t.commonParameters)
        {
            p.reference = mapReference(javaTypes, p.tlParameterDef.typeDef)
        }
        for(c in t.constructors)
        {
            for(p in c.parameters)
            {
                p.reference = mapReference(javaTypes, p.tlParameterDef.typeDef)
            }
        }
    }

    for(m in javaMethods)
    {
        m.returnReference = mapReference(javaTypes, m.tlMethod.returnType)

        for (p in m.parameters)
        {
            p.reference = mapReference(javaTypes, p.tlParameterDef.typeDef)
        }
    }

    return JavaModel(javaTypes, javaMethods)
}

fun mapReference(javaTypes: HashMap<String, JavaTypeObject>, tlType: TLTypeDef): JavaTypeReference
{
    return if (tlType is TLCombinedTypeDef) {
        JavaTypeTlReference(tlType, javaTypes.get((tlType as TLCombinedTypeDef).name)!!);
    } else if (tlType is TLBuiltInTypeDef)
    {
        JavaTypeBuiltInReference(tlType);
    } else if (tlType is TLBuiltInGenericTypeDef)
    {
        var generic = tlType as TLBuiltInGenericTypeDef
        if (generic.name != "Vector")
        {
            throw RuntimeException("Only Vector built-in generics are supported")
        }
        JavaTypeVectorReference(tlType, mapReference(javaTypes, (tlType as TLBuiltInGenericTypeDef).basic));
    }
    else if (tlType is TLBuiltInTypeDef)
    {
        JavaTypeBuiltInReference(tlType)
    }
    else if (tlType is TLAnyTypeDef){
        JavaTypeAnyReference(tlType)
    }
    else if (tlType is TLFunctionalTypeDef) {
        JavaTypeFunctionalReference(tlType)
    }
    else{
        JavaTypeUnknownReference(tlType)
    }
}

fun buildSerializer(parameters: List<JavaParameter>): String
{
    if (parameters.size() == 0)
    {
        return ""
    }
    var serializer = "";
    for(p in parameters)
    {
        if (p.reference is JavaTypeTlReference)
        {
            serializer += JavaSerializeObject.replace("{int}", p.internalName);
        }
        else if (p.reference is JavaTypeVectorReference)
        {
            serializer += JavaSerializeVector.replace("{int}", p.internalName);
        } else if (p.reference is JavaTypeBuiltInReference)
        {
            if (p.tlParameterDef.typeDef.name == "int")
            {
                serializer += JavaSerializeInt.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "Bool")
            {
                serializer += JavaSerializeBoolean.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "long")
            {
                serializer += JavaSerializeLong.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "double")
            {
                serializer += JavaSerializeDouble.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "string")
            {
                serializer += JavaSerializeString.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "bytes")
            {
                serializer += JavaSerializeBytes.replace("{int}", p.internalName);
            } else throw RuntimeException("Unknown internal type: " + p.tlParameterDef.typeDef.name)
        } else if (p.reference is JavaTypeFunctionalReference) {
            serializer += JavaSerializeFunctional.replace("{int}", p.internalName);
        } else if (p.reference is JavaTypeAnyReference) {
            serializer += JavaSerializeObject.replace("{int}", p.internalName);
        }
        else
        {
            throw RuntimeException("Unknown type: " + p.tlParameterDef.typeDef.name)
        }
    }

    return JavaSerializeTemplate.replace("{body}", serializer)
}

fun buildDeserializer(parameters: List<JavaParameter>): String
{
    if (parameters.size() == 0)
    {
        return ""
    }
    var serializer = "";
    for(p in parameters)
    {
        if (p.reference is JavaTypeTlReference)
        {
            serializer += JavaDeserializeObject.replace("{int}", p.internalName)
                    .replace("{type}", (p.reference as JavaTypeTlReference).javaName);
        }
        else if (p.reference is JavaTypeVectorReference)
        {
            if ((p.reference as JavaTypeVectorReference).internalReference is JavaTypeBuiltInReference)
            {
                var intReference = (p.reference as JavaTypeVectorReference).internalReference as JavaTypeBuiltInReference;
                if (intReference.javaName == "int")
                {
                    serializer += JavaDeserializeIntVector.replace("{int}", p.internalName);
                } else if (intReference.javaName == "long")
                {
                    serializer += JavaDeserializeLongVector.replace("{int}", p.internalName);
                }
                else {
                    serializer += JavaDeserializeVector.replace("{int}", p.internalName);
                }
            }
            else{
                serializer += JavaDeserializeVector.replace("{int}", p.internalName);
            }
        } else if (p.reference is JavaTypeBuiltInReference)
        {
            if (p.tlParameterDef.typeDef.name == "int")
            {
                serializer += JavaDeserializeInt.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "Bool")
            {
                serializer += JavaDeserializeBoolean.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "long")
            {
                serializer += JavaDeserializeLong.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "double")
            {
                serializer += JavaDeserializeDouble.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "string")
            {
                serializer += JavaDeserializeString.replace("{int}", p.internalName);
            } else if (p.tlParameterDef.typeDef.name == "bytes")
            {
                serializer += JavaDeserializeBytes.replace("{int}", p.internalName);
            }else throw RuntimeException("Unknown internal type: " + p.tlParameterDef.typeDef.name)
        }
        else if (p.reference is JavaTypeFunctionalReference) {
            serializer += JavaDeserializeFunctional.replace("{int}", p.internalName);
        } else if (p.reference is JavaTypeAnyReference) {
            serializer += JavaDeserializeObject.replace("{int}", p.internalName)
                    .replace("{type}", "TLObject");
        }
        else
        {
            throw RuntimeException("Unknown type: " + p.tlParameterDef.typeDef.name)
        }
    }

    return JavaDeserializeTemplate.replace("{body}", serializer)
}


fun writeJavaClasses(model: JavaModel, path: String)
{
    for(t in model.types.values()) {
        if (t.constructors.size == 1 && !IgnoreUniting.any {(x) -> x == t.tlType.name })
        {
            var generatedFile = JavaClassTemplate;
            generatedFile = generatedFile
                    .replace("{name}", t.javaTypeName)
                    .replace("{package}", t.javaPackage)
                    .replace("{class_id}", "0x" + Integer.toHexString(t.constructors.first!!.tlConstructor.id));;

            var fields = "";
            for(p in t.constructors.get(0).parameters)
            {
                fields += JavaFieldTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName)
            }
            generatedFile = generatedFile.replace("{fields}", fields)

            var getterSetter = "";
            for(p in t.constructors.get(0).parameters)
            {
                getterSetter += JavaGetterSetterTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName)
                        .replace("{getter}", p.getterName)
                        .replace("{setter}", p.setterName)
            }

            if (t.constructors.get(0).parameters.size > 0)
            {
                var constructorArgs = "";
                var constructorBody = "";
                for(p in t.constructors.get(0).parameters)
                {
                    if (constructorArgs != ""){
                        constructorArgs += ", ";
                    }

                    constructorArgs += JavaConstructorArgTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)

                    constructorBody += JavaConstructorBodyTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName) + "\n";
                }
                generatedFile = generatedFile.replace("{constructor}",
                        JavaConstructorTemplate
                                .replace("{name}", t.javaTypeName)
                                .replace("{args}", constructorArgs)
                                .replace("{body}", constructorBody))
            }
            else{
                generatedFile = generatedFile.replace("{constructor}", "")
            }

            generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

            generatedFile = generatedFile.replace("{serialize}", buildSerializer(t.constructors.get(0).parameters))
            generatedFile = generatedFile.replace("{deserialize}", buildDeserializer(t.constructors.get(0).parameters))

            var directory = t.javaPackage.split('.').fold(path, {(x, t) -> x + "/" + t });
            val destFile = File(directory + "/" + t.javaTypeName + ".java");
            File(directory).mkdirs()
            destFile.writeText(generatedFile, "utf-8")
        } else {
            var directory = t.javaPackage.split('.').fold(path, {(x, t) -> x + "/" + t });
            run {
                var generatedFile = JavaAbsClassTemplate;
                generatedFile = generatedFile
                        .replace("{name}", t.javaTypeName)
                        .replace("{package}", t.javaPackage);
                var fields = "";
                for(p in t.commonParameters)
                {
                    fields += JavaFieldTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                }
                generatedFile = generatedFile.replace("{fields}", fields)

                var getterSetter = "";
                for(p in t.commonParameters)
                {
                    getterSetter += JavaGetterSetterTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                            .replace("{getter}", p.getterName)
                            .replace("{setter}", p.setterName)
                }

                generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

                val destFile = File(directory + "/" + t.javaTypeName + ".java");
                File(directory).mkdirs()
                destFile.writeText(generatedFile, "utf-8")
            }

            for(constr in t.constructors)
            {
                var generatedFile = JavaChildClassTemplate;
                generatedFile = generatedFile
                        .replace("{name}", constr.javaClassName)
                        .replace("{base-name}", t.javaTypeName)
                        .replace("{package}", t.javaPackage)
                        .replace("{class_id}", "0x" + Integer.toHexString(constr.tlConstructor.id));;
                var fields = "";
                for(p in constr.parameters)
                {
                    if (t.commonParameters.any {(x) -> x.internalName == p.internalName })
                    {
                        continue
                    }
                    fields += JavaFieldTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                }
                generatedFile = generatedFile.replace("{fields}", fields)

                var getterSetter = "";
                for(p in constr.parameters)
                {
                    if (t.commonParameters.any {(x) -> x.internalName == p.internalName })
                    {
                        continue
                    }
                    getterSetter += JavaGetterSetterTemplate
                            .replace("{type}", p.reference!!.javaName)
                            .replace("{int}", p.internalName)
                            .replace("{getter}", p.getterName)
                            .replace("{setter}", p.setterName)
                }

                if (constr.parameters.size > 0)
                {
                    var constructorArgs = "";
                    var constructorBody = "";
                    for(p in constr.parameters)
                    {
                        if (constructorArgs != ""){
                            constructorArgs += ", ";
                        }

                        constructorArgs += JavaConstructorArgTemplate
                                .replace("{type}", p.reference!!.javaName)
                                .replace("{int}", p.internalName)

                        constructorBody += JavaConstructorBodyTemplate
                                .replace("{type}", p.reference!!.javaName)
                                .replace("{int}", p.internalName) + "\n";
                    }
                    var constructor = JavaConstructorTemplate
                            .replace("{name}", constr.javaClassName)
                            .replace("{args}", constructorArgs)
                            .replace("{body}", constructorBody);
                    generatedFile = generatedFile.replace("{constructor}", constructor)
                } else {
                    generatedFile = generatedFile.replace("{constructor}", "")
                }

                generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

                generatedFile = generatedFile.replace("{serialize}", buildSerializer(constr.parameters))
                generatedFile = generatedFile.replace("{deserialize}", buildDeserializer(constr.parameters))

                val destFile = File(directory + "/" + constr.javaClassName + ".java");
                File(directory).mkdirs()
                destFile.writeText(generatedFile, "utf-8")
            }
        }
    }

    for(m in model.methods)
    {
        var generatedFile = JavaMethodTemplate;
        generatedFile = generatedFile
                .replace("{name}", m.requestClassName)
                .replace("{package}", JavaPackage + "." + JavaMethodPackage)
                .replace("{class_id}", "0x" + Integer.toHexString(m.tlMethod.id))
                .replace("{return_type}", m.returnReference!!.javaName);

        var fields = "";
        for(p in m.parameters)
        {
            fields += JavaFieldTemplate
                    .replace("{type}", p.reference!!.javaName)
                    .replace("{int}", p.internalName)
        }
        generatedFile = generatedFile.replace("{fields}", fields)

        var getterSetter = "";
        for(p in m.parameters)
        {
            getterSetter += JavaGetterSetterTemplate
                    .replace("{type}", p.reference!!.javaName)
                    .replace("{int}", p.internalName)
                    .replace("{getter}", p.getterName)
                    .replace("{setter}", p.setterName)
        }

        if (m.parameters.size > 0)
        {
            var constructorArgs = "";
            var constructorBody = "";
            for(p in m.parameters)
            {
                if (constructorArgs != ""){
                    constructorArgs += ", ";
                }

                constructorArgs += JavaConstructorArgTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName)

                constructorBody += JavaConstructorBodyTemplate
                        .replace("{type}", p.reference!!.javaName)
                        .replace("{int}", p.internalName) + "\n";
            }
            var constructor = JavaConstructorTemplate
                    .replace("{name}", m.requestClassName)
                    .replace("{args}", constructorArgs)
                    .replace("{body}", constructorBody);
            generatedFile = generatedFile.replace("{constructor}", constructor)
        } else {
            var constructor = JavaConstructorTemplate
                    .replace("{name}", m.requestClassName)
                    .replace("{args}", "")
                    .replace("{body}", "");
            generatedFile = generatedFile.replace("{constructor}", constructor)
        }

        generatedFile = generatedFile.replace("{getter-setters}", getterSetter)

        generatedFile = generatedFile.replace("{serialize}", buildSerializer(m.parameters))
        generatedFile = generatedFile.replace("{deserialize}", buildDeserializer(m.parameters))


        var responseParser = JavaMethodParserTemplate.replace("{return_type}",
                m.returnReference!!.javaName);
        if (m.returnReference is JavaTypeVectorReference) {
            var vectorReference = m.returnReference as JavaTypeVectorReference;
            if (vectorReference.internalReference is JavaTypeBuiltInReference) {
                var intReference = vectorReference.internalReference as JavaTypeBuiltInReference;
                if (intReference.javaName == "int") {
                    responseParser = responseParser.replace("{body}", JavaMethodParserBodyIntVector)
                } else if (intReference.javaName == "long") {
                    responseParser = responseParser.replace("{body}", JavaMethodParserBodyLongVector)
                }
                else{
                    throw RuntimeException("Unsupported vector internal reference")
                }
            }
            else if (vectorReference.internalReference is JavaTypeTlReference) {
                var tlReference = vectorReference.internalReference as JavaTypeTlReference;
                responseParser = responseParser.replace("{body}",
                        JavaMethodParserBodyVector.replace("{vector_type}", tlReference.javaName))
            } else {
                throw RuntimeException("Unsupported built-in reference")
            }
        }
        else if (m.returnReference is JavaTypeTlReference) {
            var returnReference = m.returnReference as JavaTypeTlReference;
            responseParser = responseParser.replace("{body}",
                    JavaMethodParserBodyGeneral.replace("{return_type}", returnReference.javaName))
        } else {

            var functionalParameter: JavaParameter? = null
            for(p in m.parameters)
            {
                if (p.reference is JavaTypeFunctionalReference) {
                    functionalParameter = p;
                    break
                }
            }

            if (functionalParameter == null) {
                throw RuntimeException("Any reference without functional reference")
            }

            // throw RuntimeException("Unsupported return reference")
            responseParser = responseParser.replace("{body}",
                    JavaMethodParserBodyReference.replace("{return_type}", "TLObject")
                            .replace("{int}", functionalParameter!!.internalName))
        }

        generatedFile = generatedFile.replace("{responseParser}", responseParser)

        var directory = (JavaPackage + "." + JavaMethodPackage).split('.').fold(path, {(x, t) -> x + "/" + t });
        val destFile = File(directory + "/" + m.requestClassName + ".java");
        File(directory).mkdirs()
        destFile.writeText(generatedFile, "utf-8")
    }

    var requests = ""

    for(m in model.methods) {

        var args = "";
        var methodArgs = "";
        for(p in m.parameters) {
            if (args != "") {
                args += ", ";
            }
            if (methodArgs != "") {
                methodArgs += ", ";
            }
            methodArgs += p.internalName;
            args += p.reference!!.javaName + " " + p.internalName;
        }

        requests += JavaRequesterMethod.replace("{return_type}", m.returnReference!!.javaName)
                .replace("{method_name}", m.methodName)
                .replace("{method_class}", m.requestClassName)
                .replace("{args}", args)
                .replace("{method_args}", methodArgs)
    }

    var directory = JavaPackage.split('.').fold(path, {(x, t) -> x + "/" + t });
    val destRequesterFile = File(directory + "/TLApiRequester.java");
    File(directory).mkdirs()
    destRequesterFile.writeText(JavaRequesterTemplate
            .replace("{methods}", requests)
            .replace("{package}", JavaPackage), "utf-8")


    var contextInit = ""
    for(t in model.types.values()) {
        if (t.constructors.size == 1 && !IgnoreUniting.any {(x) -> x == t.tlType.name })
        {
            contextInit += JavaContextIntRecord
                    .replace("{type}", t.javaPackage + "." + t.javaTypeName)
                    .replace("{id}", "0x" + Integer.toHexString(t.constructors.first!!.tlConstructor.id));
        }
        else{
            for(c in t.constructors)
            {
                contextInit += JavaContextIntRecord
                        .replace("{type}", t.javaPackage + "." + c.javaClassName)
                        .replace("{id}", "0x" + Integer.toHexString(c.tlConstructor.id));
            }
        }
    }

    val destFile = File(directory + "/TLApiContext.java");
    File(directory).mkdirs()
    destFile.writeText(JavaContextTemplate
            .replace("{init}", contextInit)
            .replace("{package}", JavaPackage), "utf-8")
}