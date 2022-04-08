package com.hcy.service;


import com.hcy.entity.TbMusic;

import java.util.List;

public interface TbMusicService {

    List<TbMusic> findAll();

    TbMusic findById(Integer musicId);


    TbMusic nextSong(Integer musicId);

    TbMusic prevSong(Integer musicId);

    List<TbMusic> search(String keyword);
}
