package com.common.user.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Author：xiongzhan
 * Description：用户
 * Date: 2018-07-25 23:05
 */
@Data
@Entity
@Table(name = "tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer age;

    @Column(columnDefinition = "varchar(100) comment '个人爱好'")
    private String hobby;

}
