package org.example.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManagement {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("E:/deep/github/java-coding/java-coding/src/main/java/org/example/file/input.txt");
            FileWriter fileWriter = new FileWriter("E:/deep/github/java-coding/java-coding/src/main/java/org/example/file/output.txt");

            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = fileReader.read()) != -1) stringBuilder.append((char)i);
            fileWriter.write(stringBuilder.toString());

            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
