package com.tacbin.sql;

import com.tacbin.sql.cases.AbstractCase;
import com.tacbin.sql.cases.YunYingResourceDefinition;

/**
 * Description
 * Author liuweibin
 * Date 2020/07/14
 **/
public class Launcher {
    public static void main(String[] args) {
        int pid = 464;
        AbstractCase abstractCase = new YunYingResourceDefinition(pid);
        abstractCase.doOperation();
    }
}
