package org.mitlware.support.io;

import java.io.IOException;
import java.io.OutputStream;

public final class NullOutputStream extends OutputStream {

    @Override
    public void write( byte[] b, int off, int len ) {}

    @Override
    public void write(int b) {}

    @Override
    public void write(byte[] b) throws IOException {}
}

// End ///////////////////////////////////////////////////////////////


