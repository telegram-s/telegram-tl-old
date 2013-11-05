package org.telegram.tl.builder

import java.io.File
import java.util.ArrayList
import java.util.HashSet
import java.io.InputStreamReader
import java.io.BufferedReader

/**
 * Created with IntelliJ IDEA.
 * User: ex3ndr
 * Date: 02.11.13
 * Time: 6:37
 */

fun File.recursiveFind(filter: (file: File) -> Boolean): List<File> {
    var res = ArrayList<File>()
    var stack = ArrayList<File>()
    stack.add(this)
    while(stack.size() > 0) {
        var item = stack.remove(0);
        var files = item.listFiles()
        if (files != null)
        {
            for(f in files!!) {
                if (f.isDirectory()) {
                    stack.add(f);
                }

                if (filter.invoke(f)) {
                    res.add(f)
                }
            }
        }
    }
    return res;
}

fun exec(command: String, workingFolder: String)
{
    println(command);
    var process = Runtime.getRuntime().exec(command, null, File(workingFolder));
    var inStream = BufferedReader(InputStreamReader(process.getErrorStream()!!));
    var line = inStream.readLine()
    while (line != null) {
        System.out.println(line);
        line = inStream.readLine()
    }
    inStream.close();
}

fun compileClasses(srcFolder: String, workingFolder: String, destFolder: String) {
    var args = "-g:vars -classpath " + File(".").getAbsoluteFile() + "/tl-core.jar -d " + destFolder + " ";

    var files = File(srcFolder).recursiveFind {(x) -> x.extension == "java" };

    for(f in files) {
        args += f.getAbsolutePath() + " ";
    }

    File(workingFolder + "/" + destFolder).mkdirs();
    exec("javac " + args, workingFolder);
}

fun buildJar(classesFolder: String, jarName: String, workingFolder: String) {
    var args = "";
    var files = File(workingFolder + "/" + classesFolder).recursiveFind {(x) -> x.extension == "class" };

    for(f in files) {
        args += f.getAbsolutePath().substring((workingFolder + "/" + classesFolder + "/").size) + " ";
    }

    exec("jar cf ../" + jarName + " " + args, workingFolder + "/" + classesFolder + "/")
}