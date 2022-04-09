package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.dao.CollectionMapper;
import com.hcy.entity.Collection;
import com.hcy.service.CollectionService;
import com.hcy.vo.DataVo;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVo resultVo;

        DataVo<Collection> userDataVo;

        List<Collection> list;

        if (id!=null){
            list=new ArrayList<>();
            //说明查询单个数据
            Collection collection = collectionMapper.selectByPrimaryKey(id);

            if (collection==null){
                userDataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "没有此收藏", false, userDataVo);
            }else {
                list.add(collection);

                userDataVo = new DataVo<>(1L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查到了收藏", false, userDataVo);
            }
        }else {
            //开启分页
            PageHelper.startPage(pageNum,pageSize);

            list=collectionMapper.selectByExample(null);
            //获取总数量
            PageInfo<Collection> pageInfo = new PageInfo<>(list);

            if (list.size()==0){
                userDataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "没有收藏", false, userDataVo);
            }else {
                userDataVo = new DataVo<>(pageInfo.getTotal(), list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查到了收藏收藏", false, userDataVo);
            }
        }
        return resultVo;
    }

    @Override
    public ResultVo insert(Collection collection) {
        ResultVo resultVo;
        if (collection.getCreateTime()==null){
            collection.setCreateTime(new Date());
        }
        int affectedRows = collectionMapper.insertSelective(collection);
        if (affectedRows>0){
            resultVo=new ResultVo(1000,"收藏添加成功",true,collection);
        }else {
            resultVo=new ResultVo(5000,"收藏添加失败",false,null);
        }

        return resultVo;

    }

    @Override
    public ResultVo update(Collection collection) {
        ResultVo resultVo;

        int affectedRows = collectionMapper.updateByPrimaryKeySelective(collection);

        if (affectedRows>0){

            collection = collectionMapper.selectByPrimaryKey(collection.getId());

            resultVo=new ResultVo(1000,"收藏修改成功",true,collection);
        }else {
            resultVo=new ResultVo(5000,"收藏修改失败",false,null);
        }
        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo resultVo;
        int affectedRows = collectionMapper.deleteByPrimaryKey(id);
        if (affectedRows>0){
            resultVo=new ResultVo(1000,"收藏删除成功",true,null);
        }else {
            resultVo=new ResultVo(5000,"收藏删除失败",false,null);
        }
        return resultVo;

    }
}
