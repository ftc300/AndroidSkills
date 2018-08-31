package com.ftc300.androidskills.liteorm.model.single;


import com.inso.orm_lib.db.annotation.Mapping;
import com.inso.orm_lib.db.annotation.Table;
import com.inso.orm_lib.db.enums.Relation;

/**
 * Wifi 和Man 是一对一关系
 *
 * @author MaTianyu
 *         2014-3-7上午10:39:45
 */
@Table("wife")
public class Wife extends Person {
    public String des = "about wife";
    public int age;
    @Mapping(Relation.OneToOne)
    public Man man;

    public enum Type{
        enumOne,
        enumTwo
    }
    public Type type;

    public Wife(String name, Man man) {
        this.name = name;
        this.man = man;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "des='" + des + '\'' +
                ", age=" + age +
                ", man=" + (man == null ? "" : man.name) +
                ", type=" + type +
                "} " + super.toString();
    }
}
