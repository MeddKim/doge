import com.security.domain.SysUsers;
import com.security.mapper.SysUsersMapper;
import com.security.service.IRedisService;
import com.security.service.ISysUsersService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Meddkim on 2017/8/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.RedisApplication.class)
public class RedisTest {

    @Autowired
    private IRedisService redisService;
    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private ISysUsersService sysUsersService;

    @Test
    public void getValue(){
        String bar = redisService.get("name");
        System.out.println(bar);
    }

    @Test
    public void test(){
        SysUsersMapper sysUsersMapper = sqlSession.getMapper(SysUsersMapper.class);
        SysUsers user = sysUsersMapper.selectByPrimaryKey(1L);
        System.out.println(user.getPassword());
    }

    @Test
    public void test1(){
        SysUsers user = sysUsersService.findUserByPrimaryKey(1L);
        System.out.println(user.getPassword());
    }

    @Test
    public void test2(){
        SysUsers user = sysUsersService.findUserByName("zhang");
        System.out.println(user.getPassword());
    }
}
