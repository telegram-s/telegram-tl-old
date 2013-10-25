package org.telegram.tl.builder

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import com.fasterxml.jackson.databind.JsonNode

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 23.10.13
 * Time: 8:55
 */

fun printUsage()
{
    println("USAGE:")
    println("tlcompiler -in <path_to_definition>")
}

fun main(args: Array<String>) {
    println("TL Compiler by Stepan Korshakov, Telegraph LLC (c) 2013 v0.1")

    var inputDefinition: String?

    if (args.get(0) != "-in"){
        printUsage()
        return
    }
    else {
        inputDefinition = args.get(1)
    }

    var destFolder = File(inputDefinition!!).directory.canonicalPath + "/out"

    println("Reading definitions...")
    var mapper = ObjectMapper()
    var sourceJsonTree = mapper.readValue (File(inputDefinition!!), javaClass<JsonNode>()) as JsonNode
    var definition = buildFromJson(sourceJsonTree)
    println("Building objects tl-model...")
    checkDefinition(definition)
    var model = buildModel(definition)
    println("Converting to java model...")
    var javaModel = convertToJavaModel(model)
    println("Generating classes for library...")
    writeJavaClasses(javaModel, destFolder)
}