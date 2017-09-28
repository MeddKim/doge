package com.doge.blog.mapper;

import com.doge.blog.domain.Attachment;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Attachment record);

    int insertSelective(Attachment record);

    Attachment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Attachment record);

    int updateByPrimaryKeyWithBLOBs(Attachment record);

    int updateByPrimaryKey(Attachment record);
}