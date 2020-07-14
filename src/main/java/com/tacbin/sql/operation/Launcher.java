package com.tacbin.sql.operation;

import com.tacbin.sql.operation.impl.ExportDataUsingInsert;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/11 16:08
 **/
public class Launcher {
    public static void main(String[] args) {
        int pid = 465;
        SqlOperation operation = new ExportDataUsingInsert("mait_resource_definition", "E://insert.sql", "where id = " + pid, Arrays.asList());
        operation.doOperate();

        SqlOperation operation1 = new ExportDataUsingInsert("mait_definition_config", "E://insert.sql", "where definitionId = " + pid, Arrays.asList("id"));
        operation1.doOperate();

        SqlOperation operation2 = new ExportDataUsingInsert("strategy_datasource_config", "E://insert.sql", "where definitionId = " + pid, Arrays.asList("id"));
        operation2.doOperate();
    }
}
