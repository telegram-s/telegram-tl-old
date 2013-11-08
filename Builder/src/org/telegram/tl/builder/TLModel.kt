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
    fun equals(other: Any?): Boolean
    {
        if (other is TLCombinedTypeDef)
        {
            return name == other.name;
        }
        return false;
    }
}

class TLAnonymousTypeDef(var constructor: TLConstructor) : TLTypeDef(constructor.name.uFirstLetter())
{
    fun toString(): String = "anonymous:" + name;

    fun equals(other: Any?): Boolean
    {
        if (other is TLAnonymousTypeDef)
        {
            return name == other.name;
        }
        return false;
    }
}

class TLAnyTypeDef() : TLTypeDef("")
{
    fun toString(): String = "any";

    fun equals(other: Any?): Boolean
    {
        if (other is TLAnyTypeDef)
        {
            return true;
        }
        return false;
    }
}

class TLFunctionalTypeDef() : TLTypeDef("")
{
    fun toString(): String = "functional";

    fun equals(other: Any?): Boolean
    {
        if (other is TLFunctionalTypeDef)
        {
            return true;
        }
        return false;
    }
}

class TLBuiltInGenericTypeDef(name: String, var basic: TLTypeDef) : TLTypeDef(name)
{
    fun toString(): String = "b-generic:" + name + "<" + basic.toString() + ">";

    fun equals(other: Any?): Boolean
    {
        if (other is TLBuiltInGenericTypeDef)
        {
            return (name == other.name) && (basic.name == other.basic.name);
        }
        return false;
    }
}

class TLBuiltInTypeDef(name: String) : TLTypeDef(name)
{
    fun toString(): String = "built-in:" + name;

    fun equals(other: Any?): Boolean
    {
        if (other is TLBuiltInTypeDef)
        {
            return (name == other.name);
        }
        return false;
    }
}

class TLMethodDef(var name: String, var id: Int, var args: List<TLParameterDef>, var returnType: TLTypeDef)