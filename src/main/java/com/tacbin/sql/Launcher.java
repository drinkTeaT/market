package com.tacbin.sql;

import com.tacbin.sql.cases.AbstractCase;
import com.tacbin.sql.cases.YunYingResourceDefinition;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/11 16:08
 **/
public class Launcher {
    public static void main(String[] args) {
        AbstractCase abstractCase = new YunYingResourceDefinition(465);
        abstractCase.doOperation();
    }
}
