package cn.zxk.mapper;

import cn.zxk.pojo.TShipAddress;
import cn.zxk.pojo.TShipAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TShipAddressMapper {
    long countByExample(TShipAddressExample example);

    int deleteByExample(TShipAddressExample example);

    int deleteByPrimaryKey(Integer shipAddressId);

    int insert(TShipAddress record);

    int insertSelective(TShipAddress record);

    List<TShipAddress> selectByExample(TShipAddressExample example);

    TShipAddress selectByPrimaryKey(Integer shipAddressId);

    int updateByExampleSelective(@Param("record") TShipAddress record, @Param("example") TShipAddressExample example);

    int updateByExample(@Param("record") TShipAddress record, @Param("example") TShipAddressExample example);

    int updateByPrimaryKeySelective(TShipAddress record);

    int updateByPrimaryKey(TShipAddress record);
}