package com.hcy.service.impl;

import com.hcy.dao.TbNoteMapper;
import com.hcy.entity.TbNote;
import com.hcy.service.NoteService;
import com.hcy.vo.NoteVO;
import com.hcy.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private TbNoteMapper noteMapper;

    @Override
    public NoteVO findById(Integer id) {
        return noteMapper.findById(id);
    }

    @Override
    public ResultVO update(TbNote note) {
        if (note.getPubTime() == null) {
            note.setPubTime(new Date());
        }
        ResultVO resultVO = new ResultVO();
        int affectedRows = noteMapper.updateByPrimaryKeyWithBLOBs(note);
        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setSuccess(true);
            resultVO.setMessage("修改成功");
        } else {
            resultVO.setCode(0);
            resultVO.setSuccess(false);
            resultVO.setMessage("修改失败");
            resultVO.setData(note);
        }
        return resultVO;
    }

    @Override
    public ResultVO add(TbNote note) {
        ResultVO resultVO = new ResultVO();

        // 设置日记的发布日期
        note.setPubTime(new Date());

        int affectedRows = noteMapper.insertSelective(note);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setSuccess(true);
            resultVO.setMessage("添加成功");
        } else {
            resultVO.setCode(0);
            resultVO.setSuccess(false);
            resultVO.setMessage("添加失败");
            resultVO.setData(note);
        }

        return resultVO;
    }

    @Override
    public ResultVO delete(Integer id) {

        ResultVO vo = new ResultVO();

        int affectedRows = noteMapper.deleteByPrimaryKey(id);
        if (affectedRows > 0) {
            vo.setCode(1);
        } else {
            vo.setCode(0);
        }
        return vo;

    }
}
