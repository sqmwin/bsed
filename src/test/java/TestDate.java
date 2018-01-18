import cn.bsed.mapper.ProjectMapper;
import cn.bsed.mapper.UserMapper;
import cn.bsed.pojo.Project;
import cn.bsed.pojo.User;
import cn.bsed.service.UserService;
import cn.bsed.util.security.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestDate {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @Test
    public void testDate() {
        Instant createInstant = Instant.now();
        System.out.println(createInstant);

        Date createDate = new Date(createInstant.toEpochMilli());
        System.out.println(createDate);

        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void testEditTime() {
        Project project = projectMapper.selectByPrimaryKey(11);
        //project.setCreateDate(new Date());
        String year = "2017";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        try {
            Date time = simpleDateFormat.parse(year);
            System.out.println(time);
            project.setTime(time);
            projectMapper.updateByPrimaryKeySelective(project);
            System.out.println(project);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testList() {
        List<List<String>> fatherList = new LinkedList<>();
        List<String> childList = new ArrayList<>();
        childList.add("before add child list");
        fatherList.add(childList);
        System.out.println(fatherList);
        childList.add("after add child list");
        System.out.println(fatherList);

    }

    @Test
    public void testHashCode() {
        String password = "admin";
        String md5code = MD5Util.getMD5(password);
        System.out.println(md5code);
    }

    @Test
    public void testUser() {
        User user1 = userService.get(1);
        System.out.println(user1);
        User user2 = userService.getByUsername("admin");
        System.out.println(user2);
        List<User> users = userMapper.selectAll();
        System.out.println(users);
    }
}
