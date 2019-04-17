package com.snake.tools.sql;

import com.snake.tools.sql.file.FileReader;
import org.junit.Test;

import java.io.IOException;

public class FileReadTests {

    @Test
    public void readFileTest() throws IOException {
        long start = System.currentTimeMillis();
        String file = "/mnt/workspace/workspace/sam-cloud/database/sam_glycemic.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/sam_refer_glycemic.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/sam_event.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/cgm_wear.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/base_label.sql";
        FileReader reader = new FileReader(file);
        while (reader.available() > 0) {
            System.out.println(reader.readBytes());
        }
        reader.close();
        long end = System.currentTimeMillis();
        System.out.println(String.format("use millis is : %f", ((double)(end - start)/1000)));
    }

}
