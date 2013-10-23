package org.telegram.tl.builder

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 22.10.13
 * Time: 19:14

 */

// Main definition
class TLDefinition(
        var contructors: List<TLConstructor>,
        var methods: List<TLMethod>
)

// Types
abstract class TLType()

class TLTypeRaw(
        var name: String
) : TLType()
{
    fun toString(): String = name
}

class TLTypeGeneric(
        var name: String,
        var generics: Array<TLType>) : TLType()
{
    fun toString(): String = "Generic<" + name + ">"
}

class TLTypeAny() : TLType()
{
    fun toString(): String = "#Any"
}

class TLTypeFunctional(
        var name: String
) : TLType()
{
    fun toString(): String = "!" + name
}


// Constructors of combined types

class TLConstructor(
        var name: String,
        var id: Int,
        var parameters: List<TLParameter>,
        var tlType: TLType
)
{
    fun toString(): String = name + "#" + hex(id) + " -> " + tlType.toString();
}

// Methods for RPC calls

class TLMethod(
        var name: String,
        var id: Int,
        var parameters: List<TLParameter>,
        var tlType: TLType
)
{
    fun toString(): String = name + "#" + hex(id);
}

// Parameters

class TLParameter(
        var name: String,
        var tlType: TLType
)