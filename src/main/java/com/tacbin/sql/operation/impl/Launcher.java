package com.tacbin.sql.operation.impl;

import com.tacbin.sql.operation.SqlOperation;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/11 16:08
 **/
public class Launcher {
    public static void main(String[] args) {
        SqlOperation operation = new ExportDataUsingInsert("blog","E://insert.txt");
        operation.doOperate();
    }
}
