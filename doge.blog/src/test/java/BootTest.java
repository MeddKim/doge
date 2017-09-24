import com.doge.blog.domain.Content;
import com.doge.blog.domain.Mapping;
import com.doge.blog.domain.dto.MappingDetailDto;
import com.doge.blog.mapper.ContentMapper;
import com.doge.blog.mapper.MappingMapper;
import com.doge.blog.mapper.anno.ComtentMapper2;
import com.doge.blog.service.ArticleService;
import com.doge.blog.service.impl.ArticleServiceImpl;
import com.google.common.collect.Maps;
import org.apache.ibatis.session.SqlSession;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author: Administrator
 * @date : 2017/5/25 0025
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.doge.blog.BlogApplication.class)
//@Import(Application.class)
public class BootTest {


    @Autowired
    private MappingMapper mappingMapper;

    @Test
    public void mappingMapperTest(){

        Map<String,Object> params = Maps.newHashMap();
        List<Long> list = Lists.newArrayList();
        list.add(1L);
        params.put("contentIds",list);

        List<MappingDetailDto> mappingDetailDtos = mappingMapper.findWithTaxoInfo(params);

        System.out.println(mappingDetailDtos.size());

        mappingDetailDtos.forEach( mappingDetailDto -> {
            System.out.println(mappingDetailDto.getContentId());
        });
    }
}
