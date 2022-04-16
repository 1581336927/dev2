package com.hcy.controller;

import com.hcy.entity.Poor;
import com.hcy.entity.PoorWithBLOBs;
import com.hcy.service.PoorService;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    private PoorService poorService;

    @GetMapping("getlist")
    public ResultVo getList(@RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                            Long id){
        return poorService.getList(pageNum,pageSize,id);
    }

    @PostMapping("add")
    public ResultVo insert(@RequestBody PoorWithBLOBs poor){
        return poorService.insert(poor);
    }

    @PostMapping("click")
    public ResultVo click(Poor poor){
        return poorService.click(poor.getId(),poor.getLastClickTime());
    }

    @GetMapping("delete")
    public ResultVo delete(Long id){
        return poorService.delete(id);
    }
    @PostMapping("update")
    public ResultVo update(@RequestBody PoorWithBLOBs poor){
        return poorService.update(poor);
    }
}
