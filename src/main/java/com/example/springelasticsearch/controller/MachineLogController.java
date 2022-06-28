package com.example.springelasticsearch.controller;

import com.example.springelasticsearch.dto.LogSearchRequestDto;
import com.example.springelasticsearch.entity.MachineLog;
import com.example.springelasticsearch.service.MachineLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/machines/logs")
public class MachineLogController {
    private MachineLogService logService;

    @GetMapping(value = "")
    public List<MachineLog> findAll() {
        return logService.findAll();
    }

    @GetMapping(value = "/findByName")
    public Page<MachineLog> findByName(@RequestParam("name") String name) {
        log.info("findByName {}", name);
        Pageable pageable = PageRequest.of(0, 100);
        return logService.findByName(name, pageable);
    }

    @GetMapping(value = "/search")
    public Page<MachineLog> search(@RequestBody LogSearchRequestDto searchDto) {
        log.info("search {}", searchDto);
        Pageable pageable = PageRequest.of(0, 100);
        return logService.search(searchDto, pageable);
    }

    @PostMapping(value = "")
    public MachineLog insert(@RequestBody MachineLog machineLog) {
        log.info("insert {}", machineLog.toString());
        return logService.insert(machineLog);
    }

    @PutMapping(value = "")
    public MachineLog update(@RequestBody MachineLog machineLog) {
        log.info("update {}", machineLog.toString());
        return logService.update(machineLog);
    }


    @Autowired
    public void setLogService(MachineLogService logService) {
        this.logService = logService;
    }
}
