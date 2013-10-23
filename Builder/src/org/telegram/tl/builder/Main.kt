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

fun main(args: Array<String>) {
    var sourceFileName = "/Users/ex3ndr/Develop/Sources/TypeLanguage/definitions.json"
    var mapper = ObjectMapper()
    var sourceJsonTree = mapper.readValue (File(sourceFileName), javaClass<JsonNode>()) as  JsonNode
    var definition = buildFromJson(sourceJsonTree)
    checkDefinition(definition)
    var model = buildModel(definition)
}