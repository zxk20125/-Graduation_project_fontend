package cn.zxk.mapper;

import cn.zxk.pojo.TSend;
import cn.zxk.pojo.TSendExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TSendMapper {
    long countByExample(TSendExample example);

    int deleteByExample(TSendExample example);

    int deleteByPrimaryKey(Integer sendId);

    int insert(TSend record);

    int insertSelective(TSend record);

    List<TSend> selectByExample(TSendExample example);

    TSend selectByPrimaryKey(Integer sendId);

    int updateByExampleSelective(@Param("record") TSend record, @Param("example") TSendExample example);

    int updateByExample(@Param("record") TSend record, @Param("example") TSendExample example);

    int updateByPrimaryKeySelective(TSend record);

    int updateByPrimaryKey(TSend record);
}