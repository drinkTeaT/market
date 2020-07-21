package com.tacbin.sql;

import com.tacbin.sql.cases.AbstractCase;
import com.tacbin.sql.cases.YunYingResourceDefinition;

/**
 * Description
 * Author liuweibin
 **/
public class Launcher {
    public static void main(String[] args) {
        int pid = 211;
        AbstractCase abstractCase = new YunYingResourceDefinition(pid);
        abstractCase.doOperation();
    }
}
