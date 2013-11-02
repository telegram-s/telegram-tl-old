package org.telegram.tl.builder

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import com.fasterxml.jackson.databind.JsonNode
import java.util.ArrayList
import java.util.HashSet
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 23.10.13
 * Time: 8:55
 */

fun printUsage()
{
    println("USAGE:")
    println("tlcompiler -in <path_to_definition> [-out <dest_folder>] [-package package]")
}

fun main(args: Array<String>) {
    println("TL Compiler by Stepan Korshakov, Telegraph LLC (c) 2013 v0.1")

    var inputDefinition: String?

    if (args.size != 2 && args.size != 4 && args.size != 6) {
        printUsage()
        return
    }

    if (args.get(0) != "-in"){
        printUsage()
        return
    }
    else {
        inputDefinition = args.get(1)
    }

    var destFolder = File(inputDefinition!!).getAbsoluteFile().getParent() + "/out"

    if (args.size == 4) {
        if (args.get(2) != "-out" && args.get(2) != "-package") {
            printUsage()
            return
        } else {
            if (args.get(2) == "-out") {
                destFolder = args.get(3)
            }
            else {
                JavaPackage = args.get(3)
            }
        }
    }

    if (args.size == 6) {
        if (args.get(4) != "-package") {
            printUsage()
            return
        } else {
            JavaPackage = args.get(5)
        }
    }

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
    writeJavaClasses(javaModel, destFolder + "/src/")
    println("Compiling classes...")
    compileClasses(destFolder + "/src/", destFolder, "bin");
    println("Building jar...")
    buildJar(destFolder + "/bin/", "tl-api.jar", destFolder)
    println("Operation completed successfuly")
    println("[Sources]")
    println("\t" + destFolder + "/src/")
    println("[JAR]")
    println("\t" + destFolder + "/tl-api.jar")
}