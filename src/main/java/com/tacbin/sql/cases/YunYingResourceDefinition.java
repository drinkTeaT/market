package com.tacbin.sql.cases;

import com.tacbin.sql.operation.SqlOperation;
import com.tacbin.sql.operation.impl.ExportDataUsingInsert;

import java.util.Arrays;

public class YunYingResourceDefinition extends AbstractCase{
    private int pid;

    public YunYingResourceDefinition(int pid) {
        this.pid = pid;
    }

    @Override
    public void doOperation() {
        SqlOperation operation = new ExportDataUsingInsert("mait_resource_definition", "E://insert.sql", "where id = " + pid, Arrays.asList());
        operation.doOperate();

        SqlOperation operation1 = new ExportDataUsingInsert("mait_definition_config", "E://insert.sql", "where definitionId = " + pid, Arrays.asList("id"));
        operation1.doOperate();

        SqlOperation operation2 = new ExportDataUsingInsert("strategy_datasource_config", "E://insert.sql", "where definitionId = " + pid, Arrays.asList("id"));
        operation2.doOperate();
    }
}
