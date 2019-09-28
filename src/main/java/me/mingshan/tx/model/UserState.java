package me.mingshan.tx.model;

public enum UserState {

    INITIAL("初始"),

    USEING("使用中");

    private String desc;

    UserState(String desc) {
        this.desc = desc;
    }
}
