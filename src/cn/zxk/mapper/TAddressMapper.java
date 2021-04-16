package cn.zxk.mapper;

import cn.zxk.pojo.TAddress;
import cn.zxk.pojo.TAddressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAddressMapper {
    long countByExample(TAddressExample example);

    int deleteByExample(TAddressExample example);

    int deleteByPrimaryKey(Integer addressId);

    int insert(TAddress record);

    int insertSelective(TAddress record);

    List<TAddress> selectByExample(TAddressExample example);

    TAddress selectByPrimaryKey(Integer addressId);

    int updateByExampleSelective(@Param("record") TAddress record, @Param("example") TAddressExample example);

    int updateByExample(@Param("record") TAddress record, @Param("example") TAddressExample example);

    int updateByPrimaryKeySelective(TAddress record);

    int updateByPrimaryKey(TAddress record);
}