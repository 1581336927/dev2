package com.hcy.service.impl;

import com.hcy.dao.TbSheetMapper;
import com.hcy.entity.TbMusic;
import com.hcy.entity.TbSheet;
import com.hcy.service.TbSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbSheetServiceImpl implements TbSheetService {
    @Autowired
    private TbSheetMapper tbSheetMapper;

    @Override
    public List<TbSheet> findAll() {
        return tbSheetMapper.selectByExample(null);
    }

    @Override
    public List<TbMusic> findSongsBySheet(String sheetName) {
        return tbSheetMapper.findSongsBySheet(sheetName);
    }

    @Override
    public Map<String, Object> insertSheet(TbSheet sheetName) {

        int i = tbSheetMapper.insertSelective(sheetName);
        Map<String, Object> map = new HashMap<>();

        map.put("code", -1);
        map.put("message", "失败了");
        map.put("success", false);

        if (i > 0) {
            map.put("code", 200);
            map.put("message", "成功了");
            map.put("success", true);
        }


        return map;
    }


}
