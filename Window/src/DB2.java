import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class DB2 {

	Connection cn;
	Statement st ;
	DB2(String db){
		try {
			System.out.println(db);
			cn = DriverManager.getConnection("jdbc:sqlite:music.db");
			st = (Statement) cn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	boolean createTable(
			String tableName,
			String column1,
			String dataTypeOfColumn1,
			String column2,
			String dataTypeOfColumn2,
			String column3,
			String dataTypeOfColumn3,
			String primarykey) throws SQLException{
		Statement st = (Statement) cn.createStatement();
		
		return st.execute("CREATE TABLE IF NOT EXISTS "+tableName+" ("
					+column1 +" "+dataTypeOfColumn1+","+
					column2 +" "+dataTypeOfColumn2+","+
					column3+" "+dataTypeOfColumn3
			  +")");
		
	}
void insert(String values,String tableName) throws SQLException {
		Statement st = (Statement) cn.createStatement();
		st.execute("insert into "+tableName+" values"+values);
		
	}
void showTables() throws SQLException {
	DatabaseMetaData md = cn.getMetaData();
	ResultSet rs = md.getTables(null, null, "%", null);
	while (rs.next()) {
		System.out.println(1);
	  System.out.println(rs.getString(1));
	}
}




boolean modify(String values,String tableName,String condition) throws SQLException {
		
		Statement st = (Statement) cn.createStatement();
		return st.execute("update "+tableName+"set "+values+" where "+condition);
	}
boolean modify(String tableName,String condition) throws SQLException {
		
		Statement st = (Statement) cn.createStatement();
		return st.execute("delete from "+tableName+"where "+condition);
	}
//No se si devuelve un String
DefaultListModel selectAll(String tableName) throws SQLException {
	Statement st = (Statement) cn.createStatement();
	DefaultListModel dlm = new DefaultListModel<>();
	ArrayList <String> selected = new ArrayList <String>(); 
	 st.execute("select * from "+tableName);
	ResultSet rs =st.getResultSet();
	while(rs.next()) {dlm.addElement(rs.getString("chord")+">"+
	rs.getString("chord1")+">"+rs.getString("chord2"));}
	return dlm;
}
//selectColumn is unfinished
String command(String sql) throws SQLException {
	Statement st = (Statement) cn.createStatement();
	
	 st.execute("select * from "+tableName);
	ResultSet rs =st.getResultSet();
	return rs.getString(column);
}
	public static void main(String[] args) {
		DB2 db = new DB2("music.db");
		try {
			File file = new File("music.db ");
			System.out.println(file.exists());
			db.showTables();
			db.insert("(\"maj1\",\"maj2\",\"maj4\")", "chords");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
