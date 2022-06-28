package com.example.springelasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Data
@Document(indexName = "machine_logs")
public class MachineLog {
    @Id
    private Integer id;
    private Integer machineId;
    private String code;
    private String name;
    private String log;
    private Date createdAt;
}
