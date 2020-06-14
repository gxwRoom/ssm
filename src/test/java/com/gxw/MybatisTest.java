package com.gxw;

import com.gxw.mapper.UserMapper;
import com.gxw.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * 持久层测试类
 * @author GXW工作室
 * @date 2020/6/14 0014 - 11:59
 */
public class MybatisTest {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void run1() throws IOException {
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("spring/applicationContext.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        // 查询所有数据
        List<User> list = userMapper.selectUser();
        for(User user : list){
            System.out.println(user);
        }
        // 关闭资源
        session.close();
        in.close();
    }
}
