package com.jayqqaa12.util;

import com.google.common.base.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * 演示各种IO操作.
 */
public class IOTest {

    @Test
    public void workWithFileContent() throws IOException {
        File file = new File("woop.txt");
        File destFile = new File("bar.txt");
        // text -> file, 类似的还有Collection<String>, byte[] ->file
        FileUtils.writeStringToFile(file, "Hey sailor!\nHaha\n", "UTF-8");

        // inputstream -> file，
        InputStream source = IOUtils.toInputStream("Hej", "UTF-8");
        FileUtils.copyInputStreamToFile(source, file);

        // ///////////////////////////
        // file -> outputstream
        System.out.println("copy File to outputstream:");
        FileUtils.copyFile(file, System.out);

        // file -> file
        FileUtils.copyFile(file, destFile);

        // file -> string
        System.out.println("File to String:");
        System.out.println(FileUtils.readFileToString(file, "UTF-8"));

        // file -> list<string>
        System.out.println("File to List<String>:");
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        for (String string : lines) {
            System.out.println(string);
        }

    }

    /*
     * String/Input/OutputStream/Reader/Writer
     */
    @Test
    public void workWithStream() throws IOException {
        String content = "Stream testing";
        // String - > InputStream.
        try (InputStream in = IOUtils.toInputStream(content, "UTF-8")) {

            // String - > OutputStream
            System.out.println("String to OutputStram:");
            IOUtils.write(content, System.out, "UTF-8");

            // InputStream/Reader -> String
            System.out.println("\n InputStram to String:");
            System.out.println(IOUtils.toString(in, "UTF-8"));
            // InputStream/Reader -> OutputStream/Writer， 四者间可任意组合.
            InputStream in2 = IOUtils.toInputStream(content); // 重新准备inputSteam

            System.out.println("InputStream to OutputStream:");
            IOUtils.copy(in2, System.out);

            // InputStream ->Reader
            InputStreamReader reader = new InputStreamReader(in, Charsets.UTF_8);
            // Reader->InputStream
            ReaderInputStream in3 = new ReaderInputStream(reader, Charsets.UTF_8);

            // OutputStream ->Writer
            OutputStreamWriter writer = new OutputStreamWriter(System.out, Charsets.UTF_8);
            // Writer->OutputStream
            WriterOutputStream out2 = new WriterOutputStream(writer, Charsets.UTF_8);

            // 收集Writer的输出内容到String.
            StringWriter sw = new StringWriter();
            sw.write("I am String writer");
            System.out.println("\nCollect writer content:");
            System.out.println(sw.toString());

        }
    }


}
