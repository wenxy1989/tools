package com.snake.tools.sql;

import com.snake.tools.sql.file.TableParser;
import org.junit.Test;

import java.io.IOException;

public class ParserTests {

    @Test
    public void parseTest() throws IOException {
        String classpath = System.class.getResource("/").getPath();
        System.out.println(classpath);
        String file = classpath + "base_label.sql";
        file = "/mnt/workspace/workspace/sam-cloud/database/cgm_wear.sql";
        TableParser parser = new TableParser();
        parser.parse(file);
    }

}
