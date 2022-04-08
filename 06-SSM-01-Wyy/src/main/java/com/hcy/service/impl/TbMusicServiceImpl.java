package com.hcy.service.impl;

import com.hcy.dao.TbMusicMapper;
import com.hcy.entity.TbMusic;
import com.hcy.entity.TbMusicExample;
import com.hcy.service.TbMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbMusicServiceImpl implements TbMusicService {

    @Autowired
    private TbMusicMapper tbMusicMapper;
    @Override
    public List<TbMusic> findAll() {

        //无条件查询全部
        return tbMusicMapper.selectByExample(null);
    }

    @Override
    public TbMusic findById(Integer musicId) {

        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic nextSong(Integer musicId) {
        Integer maxId=tbMusicMapper.findMaxId();
        if (musicId.equals(maxId)){
            musicId=1;
        }else {
            musicId++;
        }

        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public TbMusic prevSong(Integer musicId) {
        if (!musicId.equals(tbMusicMapper.finMinId())){
            musicId--;
        }else {
            musicId=tbMusicMapper.findMaxId();
        }
        return tbMusicMapper.selectByPrimaryKey(musicId);
    }

    @Override
    public List<TbMusic> search(String keyword) {
        TbMusicExample example = new TbMusicExample();

        TbMusicExample.Criteria criteria = example.createCriteria();

        criteria.andMusicNameLike("%"+keyword+"%");
        return tbMusicMapper.selectByExample(example);
    }


}
