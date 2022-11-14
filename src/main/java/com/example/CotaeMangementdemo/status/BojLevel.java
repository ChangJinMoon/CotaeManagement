package com.example.CotaeMangementdemo.status;

import com.example.CotaeMangementdemo.domain.problem.BojProblem;

public enum BojLevel {
    SILVER3(8), SILVER2(9), SLIVER1(10), GOLD5(11), GOLD4(12), GOLD3(13), GOLD2(14), GOLD1(15), PLATINUM5(16);

    int level;
    String levelCode = "%2C";

    BojLevel(int level){
        this.level = level;
        this.levelCode += Integer.toString(level);
    }
}
