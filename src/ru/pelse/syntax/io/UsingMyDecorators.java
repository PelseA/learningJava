package ru.pelse.syntax.io;

import ru.pelse.syntax.io.decorator.DecodeInput;
import ru.pelse.syntax.io.decorator.EncodeOutput;

import java.io.*;

public class UsingMyDecorators {
    public static void main(String[] args) throws IOException {
        String fileName = "sources/io/file1.txt";
        File file = new File(fileName);

        try (InputStream inputStream = new FileInputStream(file)) {
            try (EncodeOutput encodeOutput = new EncodeOutput(new FileOutputStream("sources/io/text-encode.txt"))) {
                int read;
                while ((read = inputStream.read()) != -1) {
                    encodeOutput.write(read);
                }
                encodeOutput.write(-1);
            }
        }

        try (DecodeInput decodeInput = new DecodeInput(new FileInputStream("sources/io/text-encode.txt"))) {
            try (OutputStream outputStream = new FileOutputStream(new File("sources/io/decode-text.txt"))) {
                int read;
                while ((read = decodeInput.read()) != -1) {
                    outputStream.write(read);
                }
            }
        }
    }
}
