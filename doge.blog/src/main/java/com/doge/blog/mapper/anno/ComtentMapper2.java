package com.doge.blog.mapper.anno;

import com.doge.blog.domain.Content;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: Administrator
 * @date : 2017/5/25 0025
 * @Description:
 */
@Mapper
public interface ComtentMapper2 {

    @Select("SELECT * FROM blog_content WHERE id= #{id}")
    Content selectByPrimaryKey(@Param("id") Long id);
}
