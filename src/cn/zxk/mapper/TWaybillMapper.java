package cn.zxk.mapper;

import cn.zxk.pojo.TWaybill;
import cn.zxk.pojo.TWaybillExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TWaybillMapper {
    long countByExample(TWaybillExample example);

    int deleteByExample(TWaybillExample example);

    int deleteByPrimaryKey(String waybillId);

    int insert(TWaybill record);

    int insertSelective(TWaybill record);

    List<TWaybill> selectByExample(TWaybillExample example);

    TWaybill selectByPrimaryKey(String waybillId);

    int updateByExampleSelective(@Param("record") TWaybill record, @Param("example") TWaybillExample example);

    int updateByExample(@Param("record") TWaybill record, @Param("example") TWaybillExample example);

    int updateByPrimaryKeySelective(TWaybill record);

    int updateByPrimaryKey(TWaybill record);
}