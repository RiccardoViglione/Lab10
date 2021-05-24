package it.polito.tdp.rivers.db;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.rivers.model.Flow;
import it.polito.tdp.rivers.model.Measurements;
import it.polito.tdp.rivers.model.River;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RiversDAO {

	public List<River> getAllRivers() {
		
		final String sql = "SELECT id, name FROM river";

		List<River> rivers = new LinkedList<River>();

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				rivers.add(new River(res.getInt("id"), res.getString("name")));
			}

			conn.close();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}

		return rivers;
	}
	
	public List<Flow> getFlows(River r){
	final String sql="SELECT day,flow "
			+" from flow "
			+" where river=? "
			+" order by day "	;
	List<Flow> flows=new LinkedList<Flow>();
	
		
	try {
		Connection conn = DBConnect.getConnection();
		PreparedStatement st = conn.prepareStatement(sql);
		st.setInt(1, r.getId());
		ResultSet res = st.executeQuery();

		while (res.next()) {
			flows.add(new Flow(res.getDate("day").toLocalDate(),(res.getFloat("flow")*3600*24),r));
		}

		conn.close();
		
	} catch (SQLException e) {
		//e.printStackTrace();
		throw new RuntimeException("SQL Error");
	}

		return flows;
	}
	public Measurements getMeasurementsInfo(River r) {
		final String sql = "SELECT day, flow "
							+ "FROM flow "
							+ "WHERE river = ? "
							+ "ORDER BY day";
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, r.getId());
			
			ResultSet res = st.executeQuery();
			
			Measurements m = new Measurements(r, null, null, 0, 0);
			
			if(res.first())
				m.setStartDate(res.getDate("day").toLocalDate());
			if(res.last())
				m.setEndDate(res.getDate("day").toLocalDate());		
			
			int n = 0;
			float s = 0;
			
			res.beforeFirst();
			while (res.next()) {
				n++;
				s += res.getFloat("flow");
			}
			m.setNumMeasurements(n);
			m.setfMed(s/n);
			
			conn.close();
			
			return m;
			
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new RuntimeException("SQL Error");
		}
	}

	
}
