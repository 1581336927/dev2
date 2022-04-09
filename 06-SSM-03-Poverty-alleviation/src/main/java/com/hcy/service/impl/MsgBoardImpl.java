package com.hcy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hcy.dao.MessageBoardMapper;
import com.hcy.entity.MessageBoard;
import com.hcy.entity.MessageBoardWithBLOBs;
import com.hcy.service.MsgBoardService;
import com.hcy.vo.DataVo;
import com.hcy.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MsgBoardImpl implements MsgBoardService {

    @Autowired
    private MessageBoardMapper messageBoardMapper;

    @Override
    public ResultVo geiList(Integer pageNum, Integer pageSize, Long id) {
        ResultVo resultVo;

        DataVo<MessageBoardWithBLOBs> dataVo;

        List<MessageBoardWithBLOBs> list;

        if (id != null) {

            list = new ArrayList<>();

            MessageBoardWithBLOBs withBLOBs = messageBoardMapper.selectByPrimaryKey(id);

            if (withBLOBs == null) {
                dataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "留言板查询失败", false, dataVo);
            } else {
                list.add(withBLOBs);
                dataVo = new DataVo<>(1L, list, pageNum, pageSize);

                resultVo = new ResultVo(200, "留言板查询成功", true, dataVo);
            }

        } else {
            PageHelper.startPage(pageNum, pageSize);

            list = messageBoardMapper.selectByExampleWithBLOBs(null);
            if (list.size() == 0) {
                dataVo = new DataVo<>(0L, list, pageNum, pageSize);

                resultVo = new ResultVo(4000, "留言板查询失败", false, dataVo);
            } else {
                PageInfo<MessageBoardWithBLOBs> pageInfo = new PageInfo<>(list);

                dataVo = new DataVo<>(pageInfo.getTotal(), list, pageNum, pageSize);

                resultVo = new ResultVo(200, "留言板查询成功", true, dataVo);

            }


        }
        return resultVo;

    }

    @Override
    public ResultVo insert(MessageBoardWithBLOBs messageBoardWithBLOBs) {
        ResultVo resultVo;
        int affetedRows = messageBoardMapper.insert(messageBoardWithBLOBs);

        if (affetedRows > 0) {


            resultVo = new ResultVo(4000, "插入留言板成功", true, null);
        } else {
            resultVo = new ResultVo(4000, "插入留言板失败", false, null);
        }

        return resultVo;
    }

    @Override
    public ResultVo delete(Long id) {
        ResultVo resultVo;

        int affectedRows = messageBoardMapper.deleteByPrimaryKey(id);

        if (affectedRows > 0) {
            resultVo = new ResultVo(1000, "留言板删除成功！！", true, null);
        } else {
            resultVo = new ResultVo(5000, "留言板删除失败！！", false, null);
        }

        return resultVo;
}
}
