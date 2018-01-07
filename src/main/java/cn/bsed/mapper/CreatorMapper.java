package cn.bsed.mapper;

import cn.bsed.pojo.Creator;
import cn.bsed.pojo.CreatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CreatorMapper {
    long countByExample(CreatorExample example);

    int deleteByExample(CreatorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Creator record);

    int insertSelective(Creator record);

    List<Creator> selectByExample(CreatorExample example);

    Creator selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Creator record, @Param("example") CreatorExample example);

    int updateByExample(@Param("record") Creator record, @Param("example") CreatorExample example);

    int updateByPrimaryKeySelective(Creator record);

    int updateByPrimaryKey(Creator record);
}