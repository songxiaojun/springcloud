package com.hfuu.springcloud.entity;


import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
    private String dbSource;//来自哪个数据库
}
