package com.tacbin.sql.operation;

import com.tacbin.sql.config.DataBaseConnection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description sql操作
 * Author liuweibin
 **/
public abstract class SqlOperation {
    protected Connection conn;
    protected String tableName;
    protected String outputPath;
    protected Map<String, String> fieldCommentMap;
    protected HashMap<String, String> excludeFieldsMap;

    public SqlOperation(String tableName, String outputPath) {
        this.conn = DataBaseConnection.getConnection();
        this.tableName = tableName;
        this.outputPath = outputPath;
        this.fieldCommentMap = new HashMap<>();
        this.excludeFieldsMap = new HashMap<>();
    }


    public abstract void doOperate();

    protected List<String> queryTableFields(HashMap<String, String> excludeFieldsMap) {
        // 获取表中字段
        List<String> fields = new ArrayList<>();
        try {
            String fieldSql = "select COLUMN_NAME,COLUMN_COMMENT from information_schema.COLUMNS  where TABLE_NAME= '" + tableName + "'";
            PreparedStatement fieldsStatement = conn.prepareStatement(fieldSql);
            ResultSet result = fieldsStatement.executeQuery();
            int i = 1;
            while (result.next()) {
                String fieldName = result.getString("COLUMN_NAME");
                fieldCommentMap.put(fieldName, result.getString("COLUMN_COMMENT"));
                if (excludeFieldsMap.containsKey(fieldName)) {
                    continue;
                }
                fields.add(fieldName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fields;
    }

    protected final void writeIntoFile(List<String> sqls) {
        try (FileWriter writer = new FileWriter(outputPath, true);
             BufferedWriter bw = new BufferedWriter(writer)) {
            for (int i = 0; i < sqls.size(); i++) {
                bw.append(sqls.get(i) + "\n");
            }
            writer.flush();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
