package com.example.demo.controller;

import com.example.demo.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
public class TestController {
    @Resource
    PlayerService playerService;

    @RequestMapping("/getPlayer")
    @ResponseBody
    public List<Map<String,Object>> getPlayer(){
        return playerService.queryAllPlayer();
    }

}
