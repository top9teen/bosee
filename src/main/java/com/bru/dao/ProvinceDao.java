package com.bru.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bru.model.AmphurBean;
import com.bru.model.DistrictBean;
import com.bru.model.ProvinceBean;

import com.bru.util.ConnectDB;

@Repository
public class ProvinceDao {

	public List<ProvinceBean> findallProvince() {
		ProvinceBean bean = new ProvinceBean();
		List<ProvinceBean> list = new ArrayList<>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append(" SELECT PROVINCE_NAME,PROVINCE_ID FROM province ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new ProvinceBean();
				bean.setProvinceName(rs.getString("PROVINCE_NAME"));
				bean.setProvinceId(rs.getInt("PROVINCE_ID"));
				list.add(bean);
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return list ;
	}
	
public List<AmphurBean> findAllaumhur(int xxx) {
		
	AmphurBean bean = new AmphurBean();
		List<AmphurBean> list = new ArrayList<AmphurBean>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append(" SELECT * FROM amphur  WHERE PROVINCE_ID = ?  ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1,xxx);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new AmphurBean();
				bean.setAmphurName(rs.getString("AMPHUR_NAME"));
				bean.setAmphurId(rs.getInt("AMPHUR_ID"));
				list.add(bean);
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
public List<DistrictBean> findAlldistrict(int xxx) {
	
	DistrictBean bean = new DistrictBean();
		List<DistrictBean> list = new ArrayList<DistrictBean>();
//		query master data
		
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append(" SELECT * FROM district  WHERE AMPHUR_ID = ?  ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1,xxx);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new DistrictBean();
				bean.setDistrictName(rs.getString("DISTRICT_NAME"));
				bean.setDistrictId(rs.getInt("DISTRICT_ID"));
				list.add(bean);
		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

//end class
}
