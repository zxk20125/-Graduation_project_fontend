package cn.zxk.service;

import cn.zxk.pojo.TFeedback;

import java.util.List;

public interface TFeedbackService {

	//添加反馈建议
	int feedbackInsert(TFeedback feedback);
	
	//查询反馈建议
	List<TFeedback> feedbackSelect();
	
	//删除
	int feedbackdelete(int id);
}
