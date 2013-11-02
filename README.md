telegram-tl
===========

TL-Library and TL-Builder for working with TL in java wint telegram.org project.

More information about TL: http://core.telegram.org/mtproto/TL

tl-core is basic library to support parsing and serializing of TL classes

tl-builder is utility for converting json-representation of TL to Java library

Usage of toolkit
===========
1) Get latest version of tl-builder and tl-core library at download section.
2) Get json-cheme of required api-level at http://core.telegram.org/schema
3) Run tl-builder:
java -jar tl-builder.jar -in <path_to_definition> [-out <dest_folder>] [-package <package>]
<path_to_definition> - path to json file
<dest_folder> - destination folder for java-files and destination jar file
<package> - overriding java package name. Default: org.telegram.api
4) Add to your project generated tl-api.jar and tl-core.jar
