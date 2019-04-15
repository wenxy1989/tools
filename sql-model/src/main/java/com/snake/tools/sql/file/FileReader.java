package com.snake.tools.sql.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileReader {


    private static final byte[] byte_wrap = new byte[]{10, 13, 9};//wrap,enter,tabs
//    private static final String[] string_line_split = new String[]{"/n", "/r", "/r/n"};
//    private static final String[] sql_insert_value_split = new String[]{";", ","};

    //    private static int max_read_length = 1024 * 4;
//    private byte[] readBytes;
    private static int read_length = 1024 * 4;
    private InputStream input;
    private boolean lineStart = true;
    private boolean lineOver = true;

    public FileReader(String file) throws FileNotFoundException {
        this.input = new FileInputStream(file);
    }

    public boolean isWrap(byte b) {
        for (byte w : byte_wrap) {
            if (w == b) {
                return true;
            }
        }
        return false;
    }

    public String readString() throws IOException {
        this.lineStart = this.lineOver == true;
        this.lineOver = false;
        byte[] bytes = new byte[read_length];
        for (int i = 0; i < read_length && this.input.available() > 0; i++) {
            bytes[i] = (byte) this.input.read();
            if (this.lineOver = isWrap(bytes[i])) {
                break;
            }
        }
        return new String(bytes);
    }

    public boolean isLineStart() {
        return this.lineStart;
    }

    public boolean isLineOver() {
        return this.lineOver;
    }

    public int available() throws IOException {
        return this.input.available();
    }

    public void close() throws IOException {
        this.input.close();
    }

}
