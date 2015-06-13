package model;
import java.sql.*;
public class SQLiteUtilities {

	private static SQLiteUtilities instance = null;
	private Statement stmt = null;
	private Connection c = null;
	
	private SQLiteUtilities(){
		
	    
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:test.db");
	    }catch(Exception e){
	    	
	    }
	      
	}
	
	public static SQLiteUtilities getSQLDatabaseInstance(){
		if(instance == null){
			instance = new SQLiteUtilities();
		}
		return instance;
	}
	public void createTable(){
		
			try{
		      stmt = c.createStatement();
		      String sql = "CREATE TABLE IF NOT EXISTS TIP " +
		                   "(ID INTEGER PRIMARY KEY     AUTOINCREMENT," +
		                   " INIT_PRICE		REAL 	NOT NULL,"	+
		                   " GOV           	REAL    NOT NULL, " + 
		                   " TIP           	REAL    NOT NULL, " +
		                   " TIP_CALC       REAL     NOT NULL, " + 
		                   " TOTAL 			REAL 	NOT NULL);";
		      stmt.executeUpdate(sql);
		      stmt.close();
		      //c.close();
		    } catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
		    }
		    System.out.println("SQLiteUtilities:: Database tip table has been initialized.");
		//}
	}
	public void insertTip(Tip tip){
		if(!checkTotalRowsMax()){
			try{
				stmt = c.createStatement();
				String sql = "INSERT INTO TIP(INIT_PRICE,GOV,TIP,TIP_CALC,TOTAL) "+
							 "VALUES("+tip.getPrice()+","+tip.getGovTax()+","+tip.getTipTax() +","+TipSystem.getInstance().calculateTip(tip)+","+TipSystem.getInstance().calculateTotal(tip)+");";
				stmt.executeUpdate(sql);
				stmt.close();
				//c.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			System.out.println("SQLiteUtilities:: VALUES    "+tip.getPrice()+","+tip.getGovTax()+","+tip.getTipTax() +","+TipSystem.getInstance().calculateTip(tip)+","+TipSystem.getInstance().calculateTotal(tip)+" ");
			
		}
	}
	public boolean checkTotalRowsMax(){
		int counter = 0;
		try {
			stmt = c.createStatement();
			
			String sql = "SELECT COUNT(*) as Count FROM TIP;";
			
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				counter = rs.getInt("Count");
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("SQLiteUtilities:: Database is broken.");
			e.printStackTrace();
		}
		if(counter < 10){
			return false;
		}
		else{
			return true;
		}
	}

	public void selectRows(){
		try {
			stmt = c.createStatement();
			
			String sql = "SELECT * FROM TIP;";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt("Id") +" , " +rs.getDouble("INIT_PRICE"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			System.out.println("SQLiteUtilities:: Database is broken.");
			e.printStackTrace();
		}
	}
}
