package com.doge.blog.domain.dto;

import com.doge.blog.domain.Mapping;
import com.doge.blog.domain.Taxonomy;
import lombok.Data;

/**
 * Created by Meddkim on 2017/9/24.
 */
@Data
public class MappingDetailDto extends Mapping{

    private Taxonomy taxonomy;

}
