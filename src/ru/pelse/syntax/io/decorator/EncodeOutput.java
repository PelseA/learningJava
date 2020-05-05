package ru.pelse.syntax.io.decorator;

import java.io.*;

public class EncodeOutput extends OutputStream {
    protected OutputStream out;

    public EncodeOutput(OutputStream out) {
        this.out = out;
    }

    /**
     * always add out.write(-1) after writing!
     */
    @Override
    public void write(int b) throws IOException {
        out.write(b + 3);
    }

    public void flush() throws IOException {
        out.flush();
    }

    @SuppressWarnings("try")
    public void close() throws IOException {
        try (OutputStream ostream = out) {
            flush();
        }
    }
}
