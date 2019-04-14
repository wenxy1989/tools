package com.snake.tools.sql.file;

import java.io.*;

public class TableSql {

    private static final byte[] byte_wrap = new byte[]{10,13,9};//wrap,enter,tabs
    private static final String[] string_line_split = new String[]{"/n","/r","/r/n"};
    private static final String[] sql_intert_value_split = new String[]{";",","};

    private InputStream input;
    private static int read_length = 1024*4;
    private static int max_read_length = 1024*4;
    private byte[] readBytes;

    public TableSql(String file) throws FileNotFoundException {
        this.input = new FileInputStream(file);
        this.readBytes = new byte[read_length];
    }

    public boolean available() throws IOException {
        return this.input.available() > 0;
    }

    public String readLine() throws IOException {
        int readIndex = 0;
        byte[] bytes = new byte[read_length];
        while (this.input.available() > 0){
            bytes[readIndex] = (byte)this.input.read();
            for(byte w : byte_wrap){
                if(w == bytes[readIndex]){
                    break;
                }
            }
            readIndex++;
            if(readIndex > read_length){
                break;
            }
        }
        return new String(bytes);
    }

    public String readString() throws IOException {

        return this.readLine();
    }

    public void close() throws IOException {
        this.input.close();
    }

}
