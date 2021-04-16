package cn.zxk.mapper;

import cn.zxk.pojo.TResWeight;
import cn.zxk.pojo.TResWeightExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResWeightMapper {
    long countByExample(TResWeightExample example);

    int deleteByExample(TResWeightExample example);

    int deleteByPrimaryKey(Integer resWeightId);

    int insert(TResWeight record);

    int insertSelective(TResWeight record);

    List<TResWeight> selectByExample(TResWeightExample example);

    TResWeight selectByPrimaryKey(Integer resWeightId);

    int updateByExampleSelective(@Param("record") TResWeight record, @Param("example") TResWeightExample example);

    int updateByExample(@Param("record") TResWeight record, @Param("example") TResWeightExample example);

    int updateByPrimaryKeySelective(TResWeight record);

    int updateByPrimaryKey(TResWeight record);
}