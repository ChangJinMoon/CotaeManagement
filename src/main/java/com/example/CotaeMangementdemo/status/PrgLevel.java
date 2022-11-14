package com.example.CotaeMangementdemo.status;

public enum PrgLevel {
    LEVEL1(1), LEVEL2(2), LEVEL3(3), LEVEL4(4), LEVEL5(5);

    int level;
    String levelCode = "%2C";

    PrgLevel(int level){
        this.level = level;
        this.levelCode += Integer.toString(level);
    }
}
