package com.hcy.controller;

import com.hcy.entity.MessageBoardWithBLOBs;
import com.hcy.service.MsgBoardService;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msgboard")
public class Message_Board {
    @Autowired
    private MsgBoardService msgBoardService;

    @GetMapping("getlist")
    public ResultVo getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                            Long id) {
        return msgBoardService.geiList(pageNum, pageSize, id);
    }

    @PostMapping("add")
    public ResultVo insert(@RequestBody MessageBoardWithBLOBs messageBoardWithBLOBs) {
        return msgBoardService.insert(messageBoardWithBLOBs);
    }
    @GetMapping("delete")
    public ResultVo delete(Long id){
        return msgBoardService.delete(id);
    }
}
