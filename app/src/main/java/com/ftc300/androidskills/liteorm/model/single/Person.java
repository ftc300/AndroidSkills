package com.ftc300.androidskills.liteorm.model.single;


import com.inso.orm_lib.db.annotation.Column;
import com.inso.orm_lib.db.annotation.Conflict;
import com.inso.orm_lib.db.annotation.NotNull;
import com.inso.orm_lib.db.annotation.PrimaryKey;
import com.inso.orm_lib.db.enums.AssignType;
import com.inso.orm_lib.db.enums.Strategy;

/**
 *
 * @author MaTianyu
 * 2014-3-7上午10:39:45
 */
public class Person extends  BaseModel{
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    @Column("_id")
    protected long id;

    @NotNull
    @Conflict(Strategy.FAIL)
    public String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "} " + super.toString();
    }
}
