package cn.zxk.mapper;

import cn.zxk.pojo.TCustomer;
import cn.zxk.pojo.TCustomerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCustomerMapper {
    long countByExample(TCustomerExample example);

    int deleteByExample(TCustomerExample example);

    int deleteByPrimaryKey(Integer customerId);

    int insert(TCustomer record);

    int insertSelective(TCustomer record);

    List<TCustomer> selectByExample(TCustomerExample example);

    TCustomer selectByPrimaryKey(Integer customerId);

    int updateByExampleSelective(@Param("record") TCustomer record, @Param("example") TCustomerExample example);

    int updateByExample(@Param("record") TCustomer record, @Param("example") TCustomerExample example);

    int updateByPrimaryKeySelective(TCustomer record);

    int updateByPrimaryKey(TCustomer record);
}