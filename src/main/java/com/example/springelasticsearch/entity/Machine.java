package com.example.springelasticsearch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "machines")
public class Machine {
    @Id
    private Integer id;
    private String code;
    private String name;
    private Date createdAt;
    private Date updatedAt;
}
