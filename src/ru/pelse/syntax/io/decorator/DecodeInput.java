package ru.pelse.syntax.io.decorator;

import java.io.IOException;
import java.io.InputStream;

public class DecodeInput extends InputStream {
    /**
     * The input stream to be decoded.
     */
    protected InputStream in;

    public DecodeInput(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return in.read() - 3;
    }
}
