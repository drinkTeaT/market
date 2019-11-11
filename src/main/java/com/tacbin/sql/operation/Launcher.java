package com.tacbin.sql.operation;

import com.tacbin.sql.operation.impl.ExportDataUsingInsert;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/11 16:08
 **/
public class Launcher {
    public static void main(String[] args) {
        SqlOperation operation = new ExportDataUsingInsert("t_sms_template","E://insert.sql");
        operation.doOperate();
    }
}
