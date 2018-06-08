package com.bru.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bru.model.KasikornPriceBean;
import com.bru.model.KrungsriPriceBean;
import com.bru.model.MsgadminBean;
import com.bru.model.RegisterallBean;
import com.bru.model.RegnameBean;
import com.bru.model.SimBean;
import com.bru.model.SimpleTestBean;
import com.bru.model.UpdatecarBean;
import com.bru.model.UserAllBean;
import com.bru.util.ConnectDB;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

@Repository
public class MenberDao {

	public List<RegisterallBean> listuser(String name) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		List<RegisterallBean> list = new ArrayList<>();
		RegisterallBean bean = new RegisterallBean();

		try {

			sql.append(" SELECT * FROM  registerall WHERE reg_bankname = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1, name);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new RegisterallBean();
				bean.setRegId(rs.getInt("reg_id"));
				bean.setRegFirstname(rs.getString("reg_firstname"));
				bean.setRegLastname(rs.getString("reg_lastname"));
				bean.setRegTelephone(rs.getString("reg_telephone"));
				bean.setRegProvince(rs.getString("reg_province"));
				bean.setRegCarmake(rs.getString("reg_carmake"));
				bean.setRegLesslimit(rs.getString("reg_lesslimit"));
				list.add(bean);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<RegnameBean> listuser2(String name) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		List<RegnameBean> list = new ArrayList<>();
		RegnameBean bean = new RegnameBean();

		try {

			sql.append(" SELECT * FROM  regname WHERE na_bankname = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1, name);
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new RegnameBean();
				bean.setRegId(rs.getInt("na_id"));
				bean.setRegFirstname(rs.getString("na_firstname"));
				bean.setRegLastname(rs.getString("na_lastname"));
				bean.setRegTelephone(rs.getInt("na_telephone"));
				bean.setRegProvince(rs.getString("na_province"));
				bean.setRegCarmake(rs.getString("na_carmake"));
				bean.setRegLesslimit(rs.getString("na_lesslimit"));
				list.add(bean);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	// adminsel1
	public List<RegisterallBean> listuser1() {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		List<RegisterallBean> list = new ArrayList<>();
		RegisterallBean bean = new RegisterallBean();

		try {

			sql.append(" SELECT * FROM  registerall  ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new RegisterallBean();
				bean.setRegId(rs.getInt("reg_id"));
				bean.setRegBankname(rs.getString("reg_bankname"));
				bean.setRegFirstname(rs.getString("reg_firstname"));
				bean.setRegLastname(rs.getString("reg_lastname"));
				bean.setRegTelephone(rs.getString("reg_telephone"));
				bean.setRegProvince(rs.getString("reg_province"));
				bean.setRegCarmake(rs.getString("reg_carmake"));
				bean.setRegLesslimit(rs.getString("reg_lesslimit"));
				bean.setRegDate(rs.getDate("reg_date"));
				list.add(bean);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public List<RegnameBean> listuser3() {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		List<RegnameBean> list = new ArrayList<>();
		RegnameBean bean = new RegnameBean();

		try {

			sql.append(" SELECT * FROM  regname ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new RegnameBean();
				bean.setRegId(rs.getInt("na_id"));
				bean.setRegBankname(rs.getString("na_bankname"));
				bean.setRegFirstname(rs.getString("na_firstname"));
				bean.setRegLastname(rs.getString("na_lastname"));
				bean.setRegTelephone(rs.getInt("na_telephone"));
				bean.setRegProvince(rs.getString("na_province"));
				bean.setRegCarmake(rs.getString("na_carmake"));
				bean.setRegLesslimit(rs.getString("na_lesslimit"));
				bean.setRegDate(rs.getDate("na_date"));
				list.add(bean);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public void sssss(MsgadminBean bean) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("INSERT INTO msgadmin(ms_name,ms_msghard,ms_msgbody,ms_date) VALUES(?,?,?,?)");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1, bean.getMsName());
			prepared.setString(2, bean.getMsMsghard());
			prepared.setString(3, bean.getMsMsgbody());
			prepared.setDate(4, new Date(bean.getMsDate().getTime()));
			prepared.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public List<MsgadminBean> listmsg() {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		List<MsgadminBean> list = new ArrayList<>();
		MsgadminBean bean = new MsgadminBean();

		try {

			sql.append(" SELECT * FROM  msgadmin ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			ResultSet rs = prepared.executeQuery();

			while (rs.next()) {
				bean = new MsgadminBean();
				bean.setMsMsgbody(rs.getString("ms_msgbody"));
				bean.setMsMsghard(rs.getString("ms_msghard"));
				bean.setMsName(rs.getString("ms_name"));
				bean.setMsDate(rs.getDate("ms_date"));
				list.add(bean);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	// update
	public void ka2(UpdatecarBean bean) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append("UPDATE kasikorn_price SET ka_price = ? WHERE  br_name = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1, bean.getKa());

			prepared.setString(2, bean.getCar());

			prepared.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void kr2(UpdatecarBean bean) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append("UPDATE krungsri_price SET kr_price = ? WHERE br_name = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1, bean.getKr());

			prepared.setString(2, bean.getCar());

			prepared.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void sc2(UpdatecarBean bean) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append("UPDATE scbeasy_price SET sc_price = ? WHERE  br_name = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1, bean.getSc());
			prepared.setString(2, bean.getCar());

			prepared.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void th2(UpdatecarBean bean) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();

		try {
			sql.append("UPDATE thanachart_price SET th_price = ? WHERE  br_name = ? ");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setInt(1, bean.getTh());
			prepared.setString(2, bean.getCar());
			prepared.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void rester(UserAllBean bean) {
		ConnectDB con = new ConnectDB();
		PreparedStatement prepared = null;
		StringBuilder sql = new StringBuilder();
		try {
			sql.append("INSERT INTO userall(us_fname,us_lname,us_address,us_role,us_createdate,us_username,us_password,us_img) VALUES(?,?,?,?,?,?,?,?)");
			prepared = con.openConnect().prepareStatement(sql.toString());
			prepared.setString(1, bean.getUsFname());
			prepared.setString(2, bean.getUsLname());
			prepared.setString(3, bean.getUsAddress());
			prepared.setString(4, bean.getUsRole());
			prepared.setDate(5, new Date(bean.getUsCreatedate().getTime()));
			prepared.setString(6, bean.getUsUsername());
			prepared.setString(7, bean.getUsPassword());
			prepared.setString(8, bean.getUsImg());
			prepared.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}


		
	}
	// end class
}
