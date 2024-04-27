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


import com.dao.DiscusswendaDao;
import com.entity.DiscusswendaEntity;
import com.service.DiscusswendaService;
import com.entity.vo.DiscusswendaVO;
import com.entity.view.DiscusswendaView;

@Service("discusswendaService")
public class DiscusswendaServiceImpl extends ServiceImpl<DiscusswendaDao, DiscusswendaEntity> implements DiscusswendaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusswendaEntity> page = this.selectPage(
                new Query<DiscusswendaEntity>(params).getPage(),
                new EntityWrapper<DiscusswendaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusswendaEntity> wrapper) {
		  Page<DiscusswendaView> page =new Query<DiscusswendaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusswendaVO> selectListVO(Wrapper<DiscusswendaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusswendaVO selectVO(Wrapper<DiscusswendaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusswendaView> selectListView(Wrapper<DiscusswendaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusswendaView selectView(Wrapper<DiscusswendaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
