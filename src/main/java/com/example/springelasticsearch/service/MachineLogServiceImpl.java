package com.example.springelasticsearch.service;

import com.example.springelasticsearch.dto.LogSearchRequestDto;
import com.example.springelasticsearch.entity.MachineLog;
import com.example.springelasticsearch.repository.MachineLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MachineLogServiceImpl implements MachineLogService {
    private MachineLogRepository logRepo;

    @Override
    public MachineLog insert(MachineLog machineLog) {
        return logRepo.save(machineLog);
    }

    @Override
    public MachineLog update(MachineLog machineLog) {
        return logRepo.save(machineLog);
    }

    @Override
    public List<MachineLog> findAll() {
        return StreamSupport.stream(logRepo.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Page<MachineLog> findByName(String name, Pageable pageable) {
        return logRepo.findByName(name, pageable);
    }

    @Override
    public Page<MachineLog> search(LogSearchRequestDto searchDto, Pageable pageable) {
        return logRepo.findBy(searchDto.getMachineName(), searchDto.getMachineCode(), pageable);
    }

    @Autowired
    public void setLogRepo(MachineLogRepository logRepo) {
        this.logRepo = logRepo;
    }
}
