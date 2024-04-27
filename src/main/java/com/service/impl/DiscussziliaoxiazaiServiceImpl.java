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


import com.dao.DiscussziliaoxiazaiDao;
import com.entity.DiscussziliaoxiazaiEntity;
import com.service.DiscussziliaoxiazaiService;
import com.entity.vo.DiscussziliaoxiazaiVO;
import com.entity.view.DiscussziliaoxiazaiView;

@Service("discussziliaoxiazaiService")
public class DiscussziliaoxiazaiServiceImpl extends ServiceImpl<DiscussziliaoxiazaiDao, DiscussziliaoxiazaiEntity> implements DiscussziliaoxiazaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussziliaoxiazaiEntity> page = this.selectPage(
                new Query<DiscussziliaoxiazaiEntity>(params).getPage(),
                new EntityWrapper<DiscussziliaoxiazaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussziliaoxiazaiEntity> wrapper) {
		  Page<DiscussziliaoxiazaiView> page =new Query<DiscussziliaoxiazaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussziliaoxiazaiVO> selectListVO(Wrapper<DiscussziliaoxiazaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussziliaoxiazaiVO selectVO(Wrapper<DiscussziliaoxiazaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussziliaoxiazaiView> selectListView(Wrapper<DiscussziliaoxiazaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussziliaoxiazaiView selectView(Wrapper<DiscussziliaoxiazaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
