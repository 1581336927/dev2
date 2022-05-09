package com.hcy.vo;

import com.hcy.entity.TbNote;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NoteVO extends TbNote {
    private Integer typeId;
    private String typeName;
    private String groupName;
    private Integer noteCount;
}
