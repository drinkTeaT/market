package com.tacbin.sql.operation.impl;

import com.tacbin.sql.operation.SqlOperation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description 生成insert的sql脚本，导出表中数据
 * Author liuweibin
 * Date 2019/11/11 11:26
 **/
public class ExportDataUsingInsert extends SqlOperation {
    public ExportDataUsingInsert(String tableName, String outputPath) {
        super(tableName, outputPath);
    }

    @Override
    public Object doOperate() {
        // 获取表的字段
        List<String> fields = queryTableFields();
        // 分页查询
        page(fields);
        return null;
    }

    private void page(List<String> fields) {
        List<String> insertSqls = new ArrayList<>();
        try {
            // 总数
            String countSql = "select count(*) from " + tableName + ";";
            PreparedStatement fieldsStatement = null;
            fieldsStatement = conn.prepareStatement(countSql);
            ResultSet result = fieldsStatement.executeQuery();
            int count = result.next() ? result.getInt(1) : 0;
            // 分页查询
            int initial = 50;
            int times = count / initial + (count % initial == 0 ? 0 : 1);
            String pageSql = "";
            for (int i = 0; i < times; i++) {
                insertSqls.clear();
                String field = fields.stream().collect(Collectors.joining(","));
                pageSql = "SELECT " + field + " FROM " + tableName + " LIMIT " + i * initial + "," + ((i + 1) * initial - 1) + ";";
                fieldsStatement = conn.prepareStatement(pageSql);
                result = fieldsStatement.executeQuery();
                while (result.next()) {
                    String sql = "insert into " + tableName + " (" + field + ") values ";
                    String value = "";
                    for (int j = 0; j < fields.size(); j++) {
                        String column = fields.get(j);
                        if (j == 0) {
                            value += "'" + result.getString(column) + "'";
                        } else {
                            value += ",'" + result.getString(column) + "'";
                        }
                    }
                    sql = sql + "(" + value + ");";
                    insertSqls.add(sql.trim());
                }
                writeIntoFile(insertSqls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void writeIntoFile(List<String> sqls) {
        FileWriter writer = null;
        BufferedWriter bw = null;
        try {
            writer = new FileWriter(outputPath, true);
            bw = new BufferedWriter(writer);
            for (int i = 0; i < sqls.size(); i++) {
                System.out.println("写入-- " + sqls.get(i).toString());
                bw.append(sqls.get(i).toString()+"\n");
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
