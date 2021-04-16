package cn.zxk.service.impl;

import cn.zxk.mapper.TCustomerMapper;
import cn.zxk.mapper.TFeedbackMapper;
import cn.zxk.pojo.TCustomer;
import cn.zxk.pojo.TCustomerExample;
import cn.zxk.pojo.TFeedback;
import cn.zxk.pojo.TFeedbackExample;
import cn.zxk.service.TFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TFeedbackServiceImpl implements TFeedbackService {

	@Autowired
	private TFeedbackMapper mapper;
	
	@Autowired
	private TCustomerMapper cuMapper;
	
	/* (non-Javadoc)
	 * @see cn.zxk.service.TFeedbackService#feedbackInsert(int, java.lang.String)
	 * 添加反馈建议
	 */
	@Override
	public int feedbackInsert(TFeedback feedback) {
		
		return mapper.insertSelective(feedback);
	}

	/* (non-Javadoc)
	 * @see cn.zxk.service.TFeedbackService#feedbackSelect()
	 * 查看反馈建议
	 */
	@Override
	public List<TFeedback> feedbackSelect() {
		TFeedbackExample example = new TFeedbackExample();
		List<TFeedback> fbList = mapper.selectByExample(example);
		TCustomerExample customerExample = new TCustomerExample();
		List<TCustomer> selectByExample = cuMapper.selectByExample(customerExample);
		
		TCustomer customer = new TCustomer();
		for (TFeedback tFeedback : fbList) {
			
			for (TCustomer tCustomer : selectByExample) {
			if(tCustomer.getCustomerId()==tFeedback.getCustomerId()) {
				tFeedback.setCustomer(tCustomer);
			}	
			}
		}
		
		return fbList;
	}

	//删除
	@Override
	public int feedbackdelete(int id) {
		int i = mapper.deleteByPrimaryKey(id);
		return i;
	}

}
