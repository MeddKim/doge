import com.doge.blog.domain.Content;
import com.doge.blog.domain.Mapping;
import com.doge.blog.mapper.ContentMapper;
import com.doge.blog.mapper.anno.ComtentMapper2;
import com.doge.blog.service.ArticleService;
import com.doge.blog.service.impl.ArticleServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    private SqlSession session;

    @Autowired
    private ComtentMapper2 contentMapper2;

//    @Autowired
//    private ArticleServiceImpl articleService;


    @Test
    public void test(){
        Content content = contentMapper2.selectByPrimaryKey(1L);
        System.out.println(content.getTitle());
    }

    @Test
    public void test2(){
//        try{
//            ContentMapper contentMaper = session.getMapper(ContentMapper.class);
//            Content content = contentMapper.selectByPrimaryKey(1L);
//            System.out.println(content.getTitle());
//        }finally {
//            session.close();
//        }
        //上面的代码错误，在spring中，我们无需手动关闭SqlSession，关闭操作由Spring替我们完成
            ContentMapper contentMapper = session.getMapper(ContentMapper.class);
            Content content = contentMapper.selectByPrimaryKey(1L);
            System.out.println(content.getText());
    }

    @Test
    public void test3(){
//        try{
//            ContentMapper contentMaper = session.getMapper(ContentMapper.class);
//            Content content = contentMapper.selectByPrimaryKey(1L);
//            System.out.println(content.getTitle());
//        }finally {
//            session.close();
//        }
        //上面的代码错误，在spring中，我们无需手动关闭SqlSession，关闭操作由Spring替我们完成
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        Content content = contentMapper.selectContentMappingById(1L);
        System.out.println(content.getMappings().size());

        for(Mapping mp : content.getMappings()){
            System.out.println(mp.getTaxonomyId());
        }
    }

    @Test
    public void test4(){
        ContentMapper contentMapper = session.getMapper(ContentMapper.class);
        List<Content> contents = contentMapper.selectContentList();
        System.out.println(contents.size());
        System.out.println(contents.get(0).getMappings().size());
    }

    @Test
    public void test5(){
        ArticleService articleService = new ArticleServiceImpl();
        List<Content> contents = articleService.findContentPage();
        System.out.println(contents.size());
        System.out.println(contents.get(0).getMappings().size());
    }
}
