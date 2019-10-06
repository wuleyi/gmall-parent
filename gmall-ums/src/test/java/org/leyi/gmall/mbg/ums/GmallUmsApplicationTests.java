package org.leyi.gmall.mbg.ums;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.leyi.gmall.ums.mapper.RoleMapper;
import org.leyi.gmall.ums.entity.Role;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallUmsApplicationTests {

    @Resource
    RoleMapper roleMapper;

    @Test
    public void contextLoads() {
        // HintManager.getInstance().setMasterRouteOnly(); //强制去主库
        roleMapper.selectList(null).forEach(System.out::println);
        Role role = new Role();
        role.setName("哇哈哈");
        roleMapper.insert(role);
    }

}
