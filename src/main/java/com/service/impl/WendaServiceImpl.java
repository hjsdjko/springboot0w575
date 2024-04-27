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


import com.dao.WendaDao;
import com.entity.WendaEntity;
import com.service.WendaService;
import com.entity.vo.WendaVO;
import com.entity.view.WendaView;

@Service("wendaService")
public class WendaServiceImpl extends ServiceImpl<WendaDao, WendaEntity> implements WendaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WendaEntity> page = this.selectPage(
                new Query<WendaEntity>(params).getPage(),
                new EntityWrapper<WendaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WendaEntity> wrapper) {
		  Page<WendaView> page =new Query<WendaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WendaVO> selectListVO(Wrapper<WendaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WendaVO selectVO(Wrapper<WendaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WendaView> selectListView(Wrapper<WendaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WendaView selectView(Wrapper<WendaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
