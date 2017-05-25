import com.doge.blog.domain.Content;
import com.doge.blog.mapper.ContentMapper;
import com.doge.blog.mapper.anno.ComtentMapper2;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Administrator
 * @date : 2017/5/25 0025
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.doge.blog.Application.class)
//@Import(Application.class)
public class BootTest {

    @Autowired
    private SqlSession session;

    @Autowired
    private ComtentMapper2 contentMapper2;

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
//        Content content = contentMapper.selectContentMappingById(1L);
        Content content = contentMapper.selectOnkey(1L);
        System.out.println(content.getText());
    }
}
