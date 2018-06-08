package com.bru.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bru.dao.ProvinceDao;
import com.bru.model.AmphurBean;

import com.bru.model.CriteriaBean;
import com.bru.model.DistrictBean;
import com.bru.model.ProvinceBean;


@RestController
public class ProvinceController {

	@Autowired
	ProvinceDao provinceDao;
	
	@RequestMapping(value="/province")
	public List<ProvinceBean> province() {
		List<ProvinceBean> list = new ArrayList<ProvinceBean>();
	
		list = provinceDao.findallProvince();
		return list;
	}
	
	@RequestMapping(value="/amphur", method = RequestMethod.POST)
	public List<AmphurBean> amphur(@RequestBody CriteriaBean criteriaBean) {
		
		List<AmphurBean> list2 = new ArrayList<>();
		list2  = provinceDao.findAllaumhur(criteriaBean.getXxx());
		return list2;
	}
	
	@RequestMapping(value="/district", method = RequestMethod.POST)
	public List<DistrictBean> district(@RequestBody CriteriaBean criteriaBean) {
		
		List<DistrictBean> list2 = new ArrayList<>();
		list2  = provinceDao.findAlldistrict(criteriaBean.getXxx());
		return list2;
	}
	
}
