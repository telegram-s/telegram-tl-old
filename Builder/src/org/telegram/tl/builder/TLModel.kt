package org.telegram.tl.builder

import java.util.ArrayList

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 23.10.13
 * Time: 9:40
 */

class TLModel(var types: List<TLTypeDef>, var methods: List<TLMethodDef>)

class TLParameterDef(var name: String,
                     var typeDef: TLTypeDef)

class TLConstructorDef(var name: String,
                       var id: Int,
                       var parameters: List<TLParameterDef>)

abstract class TLTypeDef(var name: String)

class TLCombinedTypeDef(name: String, var constructors: ArrayList<TLConstructorDef>) : TLTypeDef(name)
{
    fun toString(): String = name;
}

class TLAnonymousTypeDef(var constructor: TLConstructor) : TLTypeDef(uCamelCase(constructor.name))
{
    fun toString(): String = "anonymous:" + name;
}

class TLAnyTypeDef() : TLTypeDef("")
{
    fun toString(): String = "any";
}

class TLFunctionalTypeDef() : TLTypeDef("")
{
    fun toString(): String = "functional";
}

class TLBuiltInGenericTypeDef(name: String, var basic: TLTypeDef) : TLTypeDef(name)
{
    fun toString(): String = "b-generic:" + name + "<" + basic.toString() + ">";
}

class TLBuiltInTypeDef(name: String) : TLTypeDef(name)
{
    fun toString(): String = "built-in:" + name;
}

class TLMethodDef(var name: String, var id: Int, var args: List<TLParameterDef>, var returnType: TLTypeDef)