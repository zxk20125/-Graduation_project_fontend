package cn.zxk.mapper;

import cn.zxk.pojo.TResSort;
import cn.zxk.pojo.TResSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TResSortMapper {
    long countByExample(TResSortExample example);

    int deleteByExample(TResSortExample example);

    int deleteByPrimaryKey(Integer resSortId);

    int insert(TResSort record);

    int insertSelective(TResSort record);

    List<TResSort> selectByExample(TResSortExample example);

    TResSort selectByPrimaryKey(Integer resSortId);

    int updateByExampleSelective(@Param("record") TResSort record, @Param("example") TResSortExample example);

    int updateByExample(@Param("record") TResSort record, @Param("example") TResSortExample example);

    int updateByPrimaryKeySelective(TResSort record);

    int updateByPrimaryKey(TResSort record);
}