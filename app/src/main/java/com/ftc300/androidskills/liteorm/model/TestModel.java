package com.ftc300.androidskills.liteorm.model;


import com.inso.orm_lib.db.annotation.Column;
import com.inso.orm_lib.db.annotation.Default;
import com.inso.orm_lib.db.annotation.Ignore;
import com.inso.orm_lib.db.annotation.NotNull;
import com.inso.orm_lib.db.annotation.PrimaryKey;
import com.inso.orm_lib.db.annotation.Table;
import com.inso.orm_lib.db.enums.AssignType;

/**
 * @author MaTianyu @http://litesuits.com
 * @date 2015-12-13
 */
@Table("test_model")
public class TestModel {

    // 指定自增，每个对象需要有一个主键
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;

    // 非空字段
    @NotNull
    private String name;

    //忽略字段，将不存储到数据库
    @Ignore
    private String password;

    // 默认为true，指定列名
    @Default("true")
    @Column("login")
    private Boolean isLogin;
}
