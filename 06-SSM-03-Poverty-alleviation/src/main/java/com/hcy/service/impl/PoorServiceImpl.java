package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.dao.PoorMapper;
import com.hcy.entity.Poor;
import com.hcy.entity.PoorWithBLOBs;
import com.hcy.service.PoorService;
import com.hcy.vo.DataVo;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoorServiceImpl implements PoorService {
    @Autowired
    private PoorMapper poorMapper;

    @Override
    public ResultVo getList(Integer pageNum, Integer pageSize, Long id) {
        ResultVo resultVo;

        DataVo<PoorWithBLOBs> dataVo;

        List<PoorWithBLOBs> list;

        if (id != null) {
            list = new ArrayList<>();

            PoorWithBLOBs poorWithBLOBs = poorMapper.selectByPrimaryKey(id);
            if (poorWithBLOBs == null) {
                dataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此贫困户", false, dataVo);
            } else {
                list.add(poorWithBLOBs);

                click(poorWithBLOBs.getId(), null);

                poorWithBLOBs.setClickNum(poorWithBLOBs.getClickNum() + 1);

                dataVo = new DataVo<>(1L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查到了该贫困户", true, dataVo);
            }
        } else {
            PageHelper.startPage(pageNum, pageSize);

            list = poorMapper.selectByExampleWithBLOBs(null);
            if (list.size() == 0) {
                dataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查无此贫困户", false, dataVo);
            } else {
                PageInfo<PoorWithBLOBs> pageInfo = new PageInfo<>(list);

                dataVo = new DataVo<>(pageInfo.getTotal(), list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "查到了该贫困户", true, dataVo);
            }
        }


        return resultVo;
    }

    @Override
    public ResultVo insert(PoorWithBLOBs poor) {

        ResultVo resultVo;

        int affetedRows = poorMapper.insert(poor);

        if (affetedRows > 0) {

            poor.setClickNum(0);
            poor.setCreateTime(null);

            resultVo = new ResultVo(4000, "插入贫困户成功", true, null);
        } else {
            resultVo = new ResultVo(4000, "插入贫困户失败", false, null);
        }


        return resultVo;
    }


    @Override
    public ResultVo click(Long id, Date lastClickTime) {
        if (lastClickTime == null) {
            lastClickTime = new Date();
        }
        Integer affectedRows = poorMapper.click(id, lastClickTime);
        ResultVo vo;

        if (affectedRows > 0) {
            vo = new ResultVo(1000, "贫困者浏览量加1成功！！", true, null);
        } else {
            vo = new ResultVo(5000, "贫困者浏览量加1失败！！", false, null);
        }

        return vo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo vo;
        int affectedRows = poorMapper.deleteByPrimaryKey(id);

        if (affectedRows > 0) {
            vo = new ResultVo(1000, "贫困者删除！！", true, null);
        } else {
            vo = new ResultVo(5000, "贫困者删除失败！！", false, null);
        }

        return vo;

    }

    @Override
    public ResultVo update(PoorWithBLOBs poor) {
        ResultVo vo;
        int affectedRows = poorMapper.updateByPrimaryKeyWithBLOBs(poor);
        if (affectedRows > 0) {

            poor = poorMapper.selectByPrimaryKey(poor.getId());
            vo = new ResultVo(1000, "贫困者修改成功！！", true, poor);
        } else {
            vo = new ResultVo(5000, "贫困者修改失败！！", false, null);
        }

        return vo;
    }


}
