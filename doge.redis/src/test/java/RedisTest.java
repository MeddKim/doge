import com.security.domain.SysUsers;
import com.security.mapper.SysUsersMapper;
import com.security.service.IRedisService;
import com.security.service.ISysUsersService;
import com.security.service.KeyValueService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

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

    @Autowired
    private SysUsersMapper sysUsersMapper;

    @Autowired
    private KeyValueService keyValueService;

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

    @Test
    public void test3(){
        SysUsers user = sysUsersMapper.selectUserByName("zhang");
        System.out.println(user.getPassword());
    }

    @Test
    public void redisT(){
        String name = keyValueService.get("name");
        System.out.println(name);
    }

    @Test
    public void setNxTest(){
        //为用户上锁，id可以是操作人（商户ID，用户ID，账户ID）唯一标识符 + 上锁操作（如此处的"updateProductInfo"）
        //以便对某个用户的某个操作上锁，防止重复操作（重复提交，更新数据）
        String id = UUID.randomUUID().toString()+"updateProductInfo";
        //设置过期时间防止数据操作发生异常导致锁没有删除
        //keyValueService.setNX(id,"locked",3);
        if(keyValueService.setNX(id,"locked",3) != 1){
            //throw new BusinessException("操作太频繁！");
            System.out.println("操作过于频繁");
            return;
        }
        //此处原本应该是数据操作
        boolean result  = true;

        keyValueService.del(id); //操作完成删除该锁
    }
}
