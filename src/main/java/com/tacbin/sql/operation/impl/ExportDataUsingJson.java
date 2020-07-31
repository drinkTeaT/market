package com.tacbin.sql.operation.impl;

import com.tacbin.sql.operation.SqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author EDZ
 * @description
 * @date 2020/7/21 17:24
 */
public class ExportDataUsingJson extends SqlOperation {
    public ExportDataUsingJson(String tableName, String outputPath) {
        super(tableName, outputPath);
    }

    @Override
    public void doOperate() {
        // 获取表的字段
        List<String> fields = queryTableFields(excludeFieldsMap);
//        page(fields);
    }

//    private void page(List<String> fields) {
//        int writeAmount = 0;
//        List<String> insertSqls = new ArrayList<>();
//        try {
//            // 总数
//            String countSql = "select count(*) from " + tableName + ";";
//            PreparedStatement fieldsStatement = null;
//            fieldsStatement = conn.prepareStatement(countSql);
//            ResultSet result = fieldsStatement.executeQuery();
//            int count = result.next() ? result.getInt(1) : 0;
//            // 分页查询
//            int initial = 50;
//            int times = count / initial + (count % initial == 0 ? 0 : 1);
//            String pageSql = "";
//            for (int i = 0; i < times; i++) {
//                insertSqls.clear();
//                String field = fields.stream().collect(Collectors.joining(","));
//                pageSql = "SELECT " + field + " FROM " + tableName + conditionSql + " order by " + fields.get(0) + " LIMIT " + (i * initial) + "," + initial + ";";
//                fieldsStatement = conn.prepareStatement(pageSql);
//                result = fieldsStatement.executeQuery();
//                while (result.next()) {
//                    String sql = "insert into " + tableName + " (" + field + ") values ";
//                    String value = "";
//                    for (int j = 0; j < fields.size(); j++) {
//                        String column = fields.get(j);
//                        if (j == 0) {
//                            value += "'" + result.getString(column) + "'";
//                        } else {
//                            value += ",'" + result.getString(column) + "'";
//                        }
//                    }
//                    sql = sql + "(" + value + ");";
//                    insertSqls.add(sql.trim());
//                    writeAmount++;
//                }
//                writeIntoFile(insertSqls);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(tableName + " 写入总条数有" + writeAmount + "条");
//    }
}
