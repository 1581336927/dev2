package com.hcy.service.impl;


import com.github.pagehelper.PageHelper;
import com.hcy.dao.CollectionMapper;
import com.hcy.entity.Collection;
import com.hcy.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    public Map<Object, Object> selectLimit(Integer pageNum, Integer pageSize) {
        List<Collection> list = collectionMapper.selectByExample(null);
        PageHelper.startPage(pageNum, pageSize);
        HashMap<Object, Object> map1 = new HashMap<>();
        map1.put("total", list.size());
        map1.put("list", list);
        HashMap<Object, Object> map = new HashMap<>();
        if (list == null) {
            map.put("message", "失败");
            map.put("code", -1);
            map.put("success", false);
            map.put("data", "查无此人");
        } else {
            map.put("message", "获取成功");
            map.put("code", 200);
            map.put("data", map1);
            map.put("pageNum", pageNum);
            map.put("pageSize", pageSize);
        }

        return map;
    }

    @Override
    public Map<String, Object> insertCollection(Collection collection) {

        int insert = collectionMapper.insert(collection);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("errMsg","错误描述");
        if (insert > 0) {
            map.put("message", "收藏成功");
            map.put("code", 200);
           map.put("success",true);
           map.put("data",null);
        }else {
            map.put("message","收藏失败！");
            map.put("code",500);
            map.put("success",false);
            map.put("data",map1);

        }
        return map;
    }

    @Override
    public Map<String, Object> deleteCollection(Integer id) {
        int i = collectionMapper.deleteByPrimaryKey(id.longValue());

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("errMsg","错误描述");
        if (i > 0) {
            map.put("message", "修改成功");
            map.put("code", 200);
            map.put("success",true);
            map.put("data",null);
        }else {
            map.put("message","修改失败！");
            map.put("code",500);
            map.put("success",false);
            map.put("data",map1);
        }
        return map;
    }
}
