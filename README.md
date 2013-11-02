Telegram TL Java Library
===========

TL-Library and TL-Builder for working with TL in java wint telegram.org project.

More information about TL: http://core.telegram.org/mtproto/TL

tl-core is basic library to support parsing and serializing of TL classes

tl-builder is utility for converting json-representation of TL to Java library

Licence: MIT

Prebuild library
===========
You always can download prebuilded jars and source classes for every level of api.
Latest release: https://github.com/ex3ndr/telegram-tl/releases/tag/0.1

Actual api levels
-----------
### Api Level #1
Jar:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-1.jar

Source:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-1.src.zip

### Api Level #7
Jar:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-7.jar

Source:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-7.src.zip

### Api Level #8
Jar:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-8.jar

Source:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-8.src.zip

### Api Level #9
Jar:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-9.jar

Source:
https://github.com/ex3ndr/telegram-tl/releases/download/0.1/tl-api-9.src.zip

Usage of toolkit
===========
1) Get latest version of tl-builder and tl-core library at download section.

2) Get json-cheme of required api-level at http://core.telegram.org/schema

3) Run tl-builder:
```
java -jar tl-builder.jar -in <path_to_definition> [-out <dest_folder>] [-package <package>]
<path_to_definition> - path to json file
<dest_folder> - destination folder for java-files and destination jar file
<package> - overriding java package name. Default: org.telegram.api
````
4) Add to your project generated tl-api.jar and tl-core.jar
