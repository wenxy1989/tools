package com.snake.tools.sql;

import com.snake.tools.sql.file.AbstractTableParser;
import com.snake.tools.sql.model.EventParser;
import com.snake.tools.sql.model.GlucoseParser;
import com.snake.tools.sql.model.LabelParser;
import com.snake.tools.sql.model.WearParser;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ParserTests {

    @Test
    public void readTest() throws IOException {
        String classpath = System.class.getResource("/").getPath();
        System.out.println(classpath);
        String file = classpath + "base_label.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/cgm_wear.sql";
        long start = System.currentTimeMillis();
        InputStream input = new FileInputStream(file);
        int length = 1024*4,index = 0;
        byte[] bytes = new byte[length];
        while (input.available() > 0){
            bytes[index] = (byte) input.read();

            index ++;
            if(index >= length){
                System.out.println(new String(bytes));
                index = 0;
            }
        }
        input.close();
        long end = System.currentTimeMillis();
        System.out.println(String.format("use current millis %d",(end - start)));
    }


    @Test
    public void parseTest() throws IOException {
        String classpath = System.class.getResource("/").getPath();
        System.out.println(classpath);
        String file = classpath + "base_label.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/cgm_wear.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/sam_glycemic.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/sam_event.sql";
        long start = System.currentTimeMillis();
        AbstractTableParser parser = new EventParser();
        parser.parse(file);
        long end = System.currentTimeMillis();

        System.out.println(String.format("use current millis %d",(end - start)));
    }

}
