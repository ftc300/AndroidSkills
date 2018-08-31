package com.ftc300.androidskills.liteorm.model.cascade;


import com.ftc300.androidskills.liteorm.model.Model;
import com.inso.orm_lib.db.annotation.Mapping;
import com.inso.orm_lib.db.annotation.Table;
import com.inso.orm_lib.db.enums.Relation;

/**
 * 班级
 *
 * @author MaTianyu
 * @date 2015-03-22
 */
@Table("class")
public class Classes extends Model {

    /**
     * 假设一个班级只有一个老师
     */
    @Mapping(Relation.OneToOne)
    public Teacher teacher;

    public Classes(String title) {
        super(title);
    }

    @Override public String toString() {
        return "Classes{"
               + super.toString() +
               " teacher= " + teacher +
               "} ";
    }
}
