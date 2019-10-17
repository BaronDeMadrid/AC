import java.sql.*;

public class Sqlite {

	public static void main(String[] args) {
		

	}

}
class DB
{
	Connection cn;
	DB(String db){
		try {
			cn = DriverManager.getConnection("jdbc:sqlite:"+db);
			
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
		
		return st.execute("CREATE TABLE "+tableName+" ("
					+column1 +" "+dataTypeOfColumn1+","+
					column2 +" "+dataTypeOfColumn2+","+
					column3+" "+dataTypeOfColumn3
			  +")");
		
	}
	boolean insert(Object object,String tableName) throws SQLException {
		Statement st = (Statement) cn.createStatement();
		return st.execute("insert into "+tableName+"("+object.value+")");
	}
	boolean modify(Object object,String tableName,String condition) throws SQLException {
		
		Statement st = (Statement) cn.createStatement();
		return st.execute("update "+tableName+"set "+object.value+"where"+condition);
	}
boolean modify(String tableName,String condition) throws SQLException {
		
		Statement st = (Statement) cn.createStatement();
		return st.execute("delete from "+tableName+"where"+condition);
	}
void selectAll(String tableName) throws SQLException {
	Statement st = (Statement) cn.createStatement();
	
	 st.execute("select * from"+tableName);
	ResultSet rs =st.getResultSet();
	while(rs.next()) {System.out.println(rs.getStatement());}
}
//selectColumn is unfinished
String selectColumn(String tableName,String column) throws SQLException {
	Statement st = (Statement) cn.createStatement();
	
	 st.execute("select * from"+tableName);
	ResultSet rs =st.getResultSet();
	return rs.getString(column);
}
}