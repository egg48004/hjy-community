package com.msb.hjycommunity.springsecurity_example;

import com.msb.hjycommunity.springsecurity_example.mapper.SysUserMapper;
import com.msb.hjycommunity.springsecurity_example.entity.SysUser;
import com.msb.hjycommunity.system.mapper.SysAreaMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void testSelect(){

        List<SysUser> sysUsers = userMapper.selectList(null);
        System.out.println(sysUsers);
    }
    @Test
    public void testBcryp(){
        //使用随机盐值对密码进行加密，所以每次的加密结果都会不一样，即使原始值相同。
        String e1 = passwordEncoder.encode("123456");
        System.out.println(e1);
    }
}

















