package me.mingshan.tx.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -6850348341209008278L;

    private String name;
    private int age;
    private long version;
    private UserState state;
    private Date gmtCreate;
    private Date gmtModified;
}
