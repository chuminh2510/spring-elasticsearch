package com.example.springelasticsearch.service;

import com.example.springelasticsearch.dto.LogSearchRequestDto;
import com.example.springelasticsearch.entity.MachineLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MachineLogService {
    MachineLog insert(MachineLog log);

    MachineLog update(MachineLog log);

    List<MachineLog> findAll();

    Page<MachineLog> findByName(String name, Pageable pageable);

    Page<MachineLog> search(LogSearchRequestDto searchDto, Pageable pageable);
}
