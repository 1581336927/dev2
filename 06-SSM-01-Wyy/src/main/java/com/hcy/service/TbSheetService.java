package com.hcy.service;

import com.hcy.entity.TbMusic;
import com.hcy.entity.TbSheet;

import java.util.List;
import java.util.Map;

public interface TbSheetService {
    List<TbSheet> findAll();

    List<TbMusic> findSongsBySheet(String sheetName);


    Map<String, Object> insertSheet(TbSheet sheetName);
}
