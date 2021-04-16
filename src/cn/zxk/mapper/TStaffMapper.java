package cn.zxk.mapper;

import cn.zxk.pojo.TStaff;
import cn.zxk.pojo.TStaffExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TStaffMapper {
    long countByExample(TStaffExample example);

    int deleteByExample(TStaffExample example);

    int deleteByPrimaryKey(Integer staffId);

    int insert(TStaff record);

    int insertSelective(TStaff record);

    List<TStaff> selectByExample(TStaffExample example);

    TStaff selectByPrimaryKey(Integer staffId);

    int updateByExampleSelective(@Param("record") TStaff record, @Param("example") TStaffExample example);

    int updateByExample(@Param("record") TStaff record, @Param("example") TStaffExample example);

    int updateByPrimaryKeySelective(TStaff record);

    int updateByPrimaryKey(TStaff record);
}