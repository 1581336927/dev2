package com.hcy.service.impl;

import com.hcy.dao.TbNoteTypeMapper;
import com.hcy.entity.TbNote;
import com.hcy.entity.TbNoteType;
import com.hcy.entity.TbNoteTypeExample;
import com.hcy.entity.TbUser;
import com.hcy.service.TbNoteTypeService;
import com.hcy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class TbNoteTypeServiceImpl implements TbNoteTypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;


    @Override
    public ResultVO add(TbNoteType type) {
        ResultVO vo = new ResultVO();

        int affectedRows = tbNoteTypeMapper.insertSelective(type);

        if (affectedRows > 0) {
            vo.setMessage("添加成功");
            vo.setCode(1);
            vo.setSuccess(true);
            vo.setData(type.getId());
        } else {
            vo.setMessage("添加失败");
            vo.setCode(0);
            vo.setSuccess(false);
        }

        return vo;
    }

    @Override
    public ResultVO update(TbNoteType type) {
        ResultVO vo = new ResultVO();

        int affectedRows = tbNoteTypeMapper.updateByPrimaryKeySelective(type);

        if (affectedRows > 0) {
            vo.setMessage("修改成功");
            vo.setCode(1);
            vo.setSuccess(true);
            vo.setData(type.getId());
        } else {
            vo.setMessage("修改失败");
            vo.setCode(0);
            vo.setSuccess(false);
        }

        return vo;
    }



    @Override
    public ResultVO delete(TbNoteType tbNoteType, HttpServletRequest request) {

        List<TbNote> notes = tbNoteTypeMapper.selectNoteById(tbNoteType.getId());

        ResultVO vo = new ResultVO();

        if (notes.isEmpty() || notes.size() < 0) {
            int i = tbNoteTypeMapper.deleteByPrimaryKey(tbNoteType.getId());
            if (i > 0) {
                vo.setCode(1);
                vo.setMessage("删除成功");
            } else {
                vo.setMessage("删除失败");
                vo.setCode(0);
            }

        }
        return vo;
    }

    @Override
    public List<TbNoteType> getTypes(Integer id) {

        TbNoteTypeExample example = new TbNoteTypeExample();

        TbNoteTypeExample.Criteria criteria = example.createCriteria();

        criteria.andUserIdEqualTo(id);

        return tbNoteTypeMapper.selectByExample(example);

    }
}
