Java Telegram TL Compiler
===========

[Type Language](http://core.telegram.org/mtproto/TL) compiler for working with api of [Telegram](http://telegram.org) project.

Converts json-representation of [TL-scheme](http://core.telegram.org/schema) to jar with generated classes for serializing and deserializing api messages and methods.

Usage
----------
Download latest version at [releases page](https://github.com/ex3ndr/telegram-tl/releases)

Write in console:
```java -jar tl-builder.jar -in <path_to_definition> [-out <dest_folder>] [-package <package>]```
* ```<path_to_definition>``` - path to json file
* ```<dest_folder>``` - destination folder for java-files and destination jar file
* ```<package>``` - overriding java package name. Default: org.telegram.api

Generating api library
-----------
1. Download latest release version of tl-core library at [tl-core releases page](https://github.com/ex3ndr/telegram-tl-core/releases), rename jar file to "tl-core.jar" and put to working folder.
2. Get json-cheme of required api-level at http://core.telegram.org/schema and put it to same working folder.
3. Run tl-builder on this files
4. Add compiled tl-api.jar to your project

Prebuilded api libraries
-----------
You always could get actual versions of tl-api jars at [releases page](https://github.com/ex3ndr/telegram-tl/releases)

More information
----------------
#### Type Language documentation

English: http://core.telegram.org/mtproto/TL

Russian: http://dev.stel.com/mtproto/TL

####Telegraph project

http://telegram.org/

#### Android Client that uses this library

[![Telegram S](https://developer.android.com/images/brand/en_generic_rgb_wo_45.png)](https://play.google.com/store/apps/details?id=org.telegram.android "Telegram S")

Licence
----------------
Compiler uses [MIT Licence](LICENCE)
