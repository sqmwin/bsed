import cn.bsed.mapper.ProjectMapper;
import cn.bsed.pojo.Project;
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
}
