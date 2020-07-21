package com.tacbin.sql.cases;

import com.tacbin.sql.operation.SqlOperation;
import com.tacbin.sql.operation.impl.ExportDataUsingInsert;

import java.util.Arrays;

/**
 * Description 导出运营资源位sql
 * Author liuweibin
 */
public class YunYingResourceDefinition extends AbstractCase {
    private int pid;

    public YunYingResourceDefinition(int pid) {
        this.pid = pid;
    }

    @Override
    public void doOperation() {
        SqlOperation operation = new ExportDataUsingInsert("mait_resource_definition", "E://insert.sql", "where id = " + pid, Arrays.asList("create_time", "update_time"));
        operation.doOperate();

        SqlOperation operation1 = new ExportDataUsingInsert("mait_definition_config", "E://insert.sql", "where definitionId = " + pid, Arrays.asList("id", "create_time", "update_time"));
        operation1.doOperate();

        SqlOperation operation2 = new ExportDataUsingInsert("strategy_datasource_config", "E://insert.sql", "where definitionId = " + pid, Arrays.asList("id", "create_time", "update_time"));
        operation2.doOperate();
    }
}
