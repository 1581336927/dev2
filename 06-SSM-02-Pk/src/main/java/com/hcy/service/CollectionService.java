package com.hcy.service;

import com.hcy.entity.Collection;

import java.util.Map;

public interface CollectionService {
    Map<Object, Object> selectLimit(Integer pageNum, Integer pageSize);

    Map<String, Object> insertCollection(Collection collection);

    Map<String, Object> deleteCollection(Integer id);
}
