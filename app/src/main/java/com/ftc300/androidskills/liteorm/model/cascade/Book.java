package com.ftc300.androidskills.liteorm.model.cascade;


import com.ftc300.androidskills.liteorm.model.Model;
import com.inso.orm_lib.db.annotation.Column;
import com.inso.orm_lib.db.annotation.Mapping;
import com.inso.orm_lib.db.annotation.Table;
import com.inso.orm_lib.db.annotation.UniqueCombine;
import com.inso.orm_lib.db.enums.Relation;

/**
 * @author MaTianyu
 * @date 2015-03-24
 */
@Table("book")
public class Book extends Model {
    public static final String COL_AUTHOR = "author";
    public static final String COL_INDEX = "_index";
    /**
     * UniqueCombine 值为1，和 UniqueCombine同值 的属性联合唯一
     */
    @UniqueCombine(1)
    @Column(COL_INDEX)//避开SQL关键词
    private int index;

    /**
     * UniqueCombine值为1，和 index 联合唯一
     */
    @UniqueCombine(1)
    @Column(COL_AUTHOR)
    private String author;

    /**
     * 书和学生：多对一关系
     */
    @Mapping(Relation.ManyToOne)
    public Student student;

    public Book(String title) {
        super(title);
    }

    public int getIndex() {
        return index;
    }

    public Book setIndex(int index) {
        this.index = index;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Book setStudent(Student student) {
        this.student = student;
        return this;
    }

    @Override public String toString() {
        return "Book{"
               + super.toString() +
               "index = " + index +
               ", author = " + author +
               ", student = "
               + (student == null ? "" : student.getName())
               + "} ";
    }
}
