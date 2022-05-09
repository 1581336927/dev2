package com.hcy.service.impl;

import com.hcy.dao.ReportDao;
import com.hcy.entity.TbNote;
import com.hcy.service.ReportService;
import com.hcy.vo.NoteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportDao reportDao;

    @Override
    public Map<String, Object> getNoteCountByMonth(Integer id) {

        Map<String, Object> data = null;

        List<NoteVO> notes = reportDao.getNoteCountByMonth(id);

        if (notes != null && notes.size() > 0) {
            ArrayList<String> mouths = new ArrayList<>();

            ArrayList<Integer> noteCounts = new ArrayList<>();

            for (NoteVO note : notes) {
                mouths.add(note.getGroupName());
                noteCounts.add(note.getNoteCount());
            }

            data=new HashMap<>();

            data.put("monthArray",mouths);

            data.put("dataArray",noteCounts);
        }

        return data;
    }

    @Override
    public List<TbNote> getLocation(Integer id) {


        return reportDao.getLocation(id);
    }
}
