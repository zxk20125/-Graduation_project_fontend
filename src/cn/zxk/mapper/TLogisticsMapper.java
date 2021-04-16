package cn.zxk.mapper;

import cn.zxk.pojo.TLogistics;
import cn.zxk.pojo.TLogisticsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TLogisticsMapper {
    long countByExample(TLogisticsExample example);

    int deleteByExample(TLogisticsExample example);

    int deleteByPrimaryKey(Integer logisticsId);

    int insert(TLogistics record);

    int insertSelective(TLogistics record);

    List<TLogistics> selectByExample(TLogisticsExample example);

    TLogistics selectByPrimaryKey(Integer logisticsId);

    int updateByExampleSelective(@Param("record") TLogistics record, @Param("example") TLogisticsExample example);

    int updateByExample(@Param("record") TLogistics record, @Param("example") TLogisticsExample example);

    int updateByPrimaryKeySelective(TLogistics record);

    int updateByPrimaryKey(TLogistics record);
}