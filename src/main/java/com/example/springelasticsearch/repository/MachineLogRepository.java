package com.example.springelasticsearch.repository;

import com.example.springelasticsearch.entity.MachineLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachineLogRepository extends ElasticsearchRepository<MachineLog, Integer> {
    Page<MachineLog> findByName(String name, Pageable pageable);

    @Query("{\"bool\": {" +
            "\"must\": [{\"match\": {\"name\": \"?0\"}}," +
            "{\"match\": {\"code\": \"?1\"}}]" +
            "}}")
    Page<MachineLog> findBy(String name, String code, Pageable pageable);
}
