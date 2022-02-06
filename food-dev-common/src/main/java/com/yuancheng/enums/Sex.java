package com.yuancheng.enums;

/**
 * 性别枚举
 */
public enum Sex {
    woman(0,"女"),
    man(1,"男"),
    secret(2,"保密");

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public final Integer type;
    public final String value;
}
