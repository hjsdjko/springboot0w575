package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZiliaoxiazaiDao;
import com.entity.ZiliaoxiazaiEntity;
import com.service.ZiliaoxiazaiService;
import com.entity.vo.ZiliaoxiazaiVO;
import com.entity.view.ZiliaoxiazaiView;

@Service("ziliaoxiazaiService")
public class ZiliaoxiazaiServiceImpl extends ServiceImpl<ZiliaoxiazaiDao, ZiliaoxiazaiEntity> implements ZiliaoxiazaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZiliaoxiazaiEntity> page = this.selectPage(
                new Query<ZiliaoxiazaiEntity>(params).getPage(),
                new EntityWrapper<ZiliaoxiazaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZiliaoxiazaiEntity> wrapper) {
		  Page<ZiliaoxiazaiView> page =new Query<ZiliaoxiazaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZiliaoxiazaiVO> selectListVO(Wrapper<ZiliaoxiazaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZiliaoxiazaiVO selectVO(Wrapper<ZiliaoxiazaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZiliaoxiazaiView> selectListView(Wrapper<ZiliaoxiazaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZiliaoxiazaiView selectView(Wrapper<ZiliaoxiazaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
