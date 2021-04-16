package cn.zxk.mapper;

import cn.zxk.pojo.TFeedback;
import cn.zxk.pojo.TFeedbackExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TFeedbackMapper {
    long countByExample(TFeedbackExample example);

    int deleteByExample(TFeedbackExample example);

    int deleteByPrimaryKey(Integer feedbackId);

    int insert(TFeedback record);

    int insertSelective(TFeedback record);

    List<TFeedback> selectByExample(TFeedbackExample example);

    TFeedback selectByPrimaryKey(Integer feedbackId);

    int updateByExampleSelective(@Param("record") TFeedback record, @Param("example") TFeedbackExample example);

    int updateByExample(@Param("record") TFeedback record, @Param("example") TFeedbackExample example);

    int updateByPrimaryKeySelective(TFeedback record);

    int updateByPrimaryKey(TFeedback record);
}