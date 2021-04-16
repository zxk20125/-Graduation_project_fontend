package cn.zxk.mapper;

import cn.zxk.pojo.TDot;
import cn.zxk.pojo.TDotExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDotMapper {
    long countByExample(TDotExample example);

    int deleteByExample(TDotExample example);

    int deleteByPrimaryKey(Integer dotId);

    int insert(TDot record);

    int insertSelective(TDot record);

    List<TDot> selectByExample(TDotExample example);

    TDot selectByPrimaryKey(Integer dotId);

    int updateByExampleSelective(@Param("record") TDot record, @Param("example") TDotExample example);

    int updateByExample(@Param("record") TDot record, @Param("example") TDotExample example);

    int updateByPrimaryKeySelective(TDot record);

    int updateByPrimaryKey(TDot record);
}