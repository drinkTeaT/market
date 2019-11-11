package com.tacbin.sql.operation;

import com.tacbin.sql.DataBaseConnection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description sql操作
 * Author liuweibin
 * Date 2019/11/11 11:04
 **/
public abstract class SqlOperation {
    protected Connection conn;
    protected String tableName;
    protected String outputPath;

    public SqlOperation(String tableName, String outputPath) {
        conn = DataBaseConnection.getConnection();
        this.tableName = tableName;
        this.outputPath = outputPath;
    }


    public abstract Object doOperate();

    protected List<String> queryTableFields() {
        // 获取表中字段
        List<String> fields = new ArrayList<>();
        try {
            String fieldSql = "select COLUMN_NAME from information_schema.COLUMNS  where TABLE_NAME= '" + tableName + "'";
            PreparedStatement fieldsStatement = conn.prepareStatement(fieldSql);
            ResultSet result = fieldsStatement.executeQuery();
            int i = 1;
            while (result.next()) {
                String fieldName = result.getString(i);
                fields.add(fieldName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fields;
    }

    protected void writeIntoFile(List<String> sqls) {
        FileWriter writer = null;
        BufferedWriter bw = null;
        try {
            writer = new FileWriter(outputPath, true);
            bw = new BufferedWriter(writer);
            for (int i = 0; i < sqls.size(); i++) {
                System.out.println("写入-- " + sqls.get(i).toString());
                bw.append(sqls.get(i).toString() + "\n");
            }
            writer.flush();
            bw.flush();
            writer.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
