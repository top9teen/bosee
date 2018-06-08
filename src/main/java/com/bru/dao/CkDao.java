package com.bru.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.bru.model.AmphurBean;
import com.bru.model.DistrictBean;
import com.bru.model.ProvinceBean;
import com.bru.util.ConnectDB;

@Repository
public class CkDao {

	public ProvinceBean province(int a) {
		ProvinceBean bean = new ProvinceBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" SELECT * FROM province WHERE PROVINCE_ID = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1, a);
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setProvinceName(rs.getString("PROVINCE_NAME"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return bean;
	}
	public AmphurBean amphur(int b) {
		AmphurBean bean = new AmphurBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" SELECT * FROM amphur WHERE AMPHUR_ID = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1, b);
			ResultSet rs = prepared.executeQuery();
	
		while (rs.next()) {
			bean.setAmphurName(rs.getString("AMPHUR_NAME"));
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	return bean;
}

	public DistrictBean dis(int c) {
		DistrictBean bean = new DistrictBean();
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append(" SELECT * FROM district WHERE DISTRICT_ID = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1, c);
			ResultSet rs = prepared.executeQuery();
			while (rs.next()) {
				bean.setDistrictName(rs.getString("DISTRICT_NAME"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	return bean;
	}
	
	//end class
}
