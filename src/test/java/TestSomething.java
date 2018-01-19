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
import java.util.*;
import java.util.function.Consumer;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestSomething {
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

    @Test
    public void testIterator() {
        Long start = 0L;
        Long end = 0L;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 100000; i < 1000000; i++) {
            numbers.add(i);
        }
        List<Integer> whiles = new ArrayList<>();
        List<Integer> foreachs = new ArrayList<>();
        List<Integer> forEachs = new ArrayList<>();
        List<Integer> lambdas = new ArrayList<>();
        System.out.println("---------");
        System.out.println("迭代器while遍历");
        start = System.currentTimeMillis();
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            whiles.add(i);
        }
        System.out.println();
        end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
        System.out.println("---------");
        System.out.println("foreach遍历");

        start = System.currentTimeMillis();
        for (Integer number : numbers) {
            foreachs.add(number);
        }
        System.out.println();
        end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
        System.out.println("---------");
        System.out.println("forEach，jdk8遍历");
        start = System.currentTimeMillis();
        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                forEachs.add(integer);
            }
        });
        System.out.println();
        end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
        System.out.println("---------");
        System.out.println("lanbda表达式遍历");
        start = System.currentTimeMillis();
        numbers.forEach(i -> lambdas.add(i));
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println("用时：" + (end - start));
        System.out.println("---------");
    }

    @Test
    public void testListIterator() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(53);
        numbers.add(12);
        numbers.add(9);
        numbers.add(923);
        ListIterator<Integer> listIterator = numbers.listIterator();
        while (listIterator.hasNext()) {
            int i = listIterator.next();
            System.out.println(i);
            if (i > 50) {
                // break;
                // return;
            }
        }

    }
}
