package com.example.demo.service.impl;

import com.example.demo.mapper.PlayerMapper;
import com.example.demo.service.PlayerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService {
    @Resource
    PlayerMapper playerMapper;

    @Override
    public List<Map<String, Object>> queryAllPlayer() {
        return playerMapper.queryAllPlayer();
    }
}
