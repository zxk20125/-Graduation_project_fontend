package cn.zxk.service.impl;

import cn.zxk.mapper.TDotMapper;
import cn.zxk.pojo.TDot;
import cn.zxk.pojo.TDotExample;
import cn.zxk.service.TdotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TdotServiceImpl implements TdotService {

	@Autowired
	private TDotMapper mapper;
	
	/* (non-Javadoc)
	 * @see cn.zxk.service.TdotService#dotByCity(java.lang.String)
	 * 通过所在城市查询网点信息
	 */
	@Override
	public List<TDot> dotByCity(String city) {
		TDotExample example = new TDotExample();
		example.createCriteria().andDotCityEqualTo(city);
		List<TDot> Tdotquery = mapper.selectByExample(example);
		return Tdotquery;
	}

	/* (non-Javadoc)
	 * @see cn.zxk.service.TdotService#dotInsert(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * 添加网点
	 */
	@Override
	public int dotInsert(TDot dot) {
		return mapper.insertSelective(dot);
	}

	/* (non-Javadoc)
	 * @see cn.zxk.service.TdotService#dotDelete()
	 * 删除网点
	 */
	@Override
	public int dotDelete(int dotId) {
		return mapper.deleteByPrimaryKey(dotId);
	}

	/* (non-Javadoc)
	 * @see cn.zxk.service.TdotService#dotIdSelectByName(java.lang.String)
	 * 根据网点名查询网点id
	 */
	@Override
	public Integer dotIdSelectByName(String dot_name) {
		if(dot_name==null) {
			return null;
		}
		Integer dot_id = 0;
		TDotExample example = new TDotExample();
		example.createCriteria().andDotNameEqualTo(dot_name);
		List<TDot> dotQuery = mapper.selectByExample(example);
		if(dotQuery!=null&&!dotQuery.isEmpty()) {
			TDot dot = dotQuery.get(0);
			dot_id = dot.getDotId();
		}
		return dot_id;
	}

	//查询全部
	@Override
	public List<TDot> dotselectAll() {
		TDotExample example = new TDotExample();
		return mapper.selectByExample(example);
	}

	//id查询
	@Override
	public TDot dotselectById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int dotUpdate(TDot dot) {
		return mapper.updateByPrimaryKeySelective(dot);
	}


	//根据网点名查询网点信息
	@Override
	public TDot selectByName(String dot_name) {
		TDotExample example = new TDotExample();
		example.createCriteria().andDotNameEqualTo(dot_name);
		List<TDot> selectByExample = mapper.selectByExample(example);
		return selectByExample.get(0);
	}



}
