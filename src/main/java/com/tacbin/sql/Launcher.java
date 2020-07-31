package com.tacbin.sql;

import com.tacbin.sql.cases.AbstractCase;
import com.tacbin.sql.cases.YunYingResourceDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description
 * Author liuweibin
 **/
public class Launcher {
    public static void main(String[] args) {
        List<Integer> pids = new ArrayList<>();
        pids.add(475);
        System.out.println(pids.size());
        for (int pid : pids) {
            AbstractCase abstractCase = new YunYingResourceDefinition(pid);
            abstractCase.doOperation();
        }
    }
}
