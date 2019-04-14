package com.snake.tools.sql;

import com.snake.tools.sql.file.TableParser;
import org.junit.Test;

import java.io.IOException;

public class ParserTests {

    @Test
    public void parseTest() throws IOException {
        String file = "/document/code/workspace/sql-model/src/main/resources/base_label.sql";
        TableParser parser = new TableParser();
        parser.parse(file);
    }

}
