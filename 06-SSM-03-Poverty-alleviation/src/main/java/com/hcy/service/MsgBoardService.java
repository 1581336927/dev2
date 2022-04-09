package com.hcy.service;

import com.hcy.entity.MessageBoardWithBLOBs;
import com.hcy.vo.ResultVo;

public interface MsgBoardService {
    ResultVo geiList(Integer pageNum, Integer pageSize, Long id);

    ResultVo insert(MessageBoardWithBLOBs messageBoardWithBLOBs);

    ResultVo delete(Long id);
}
