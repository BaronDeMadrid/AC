import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
class Vista extends JFrame{
	
	JTextField textField;
	JSpinner spinner ;
	JSpinner spinner_1;
	JSpinner spinner_2;
	JButton btnNewButton;
	JLabel lblNewLabel;
	JList list;
	Vista(){
			
			setBounds(100, 100, 450, 300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			spinner = new JSpinner();
			spinner.setBounds(64, 50, 28, 20);
			getContentPane().add(spinner);
			
			spinner_1 = new JSpinner();
			spinner_1.setBounds(64, 97, 28, 20);
			getContentPane().add(spinner_1);
			
		    spinner_2 = new JSpinner();
			spinner_2.setBounds(64, 146, 28, 20);
			getContentPane().add(spinner_2);
			
			textField = new JTextField();
			textField.setBounds(51, 189, 61, 19);
			getContentPane().add(textField);
			textField.setColumns(10);
			
			btnNewButton = new JButton("start");
			btnNewButton.setBounds(138, 94, 114, 25);
			
			getContentPane().add(btnNewButton);
			
			lblNewLabel = new JLabel("Aqui");
			lblNewLabel.setBounds(111, 230, 167, 15);
			getContentPane().add(lblNewLabel);
			list = new JList();
			list.setBounds(313, 116, 111, -23);
			getContentPane().add(list);
			
			
			System.out.println("ok");
			JLabel lblChord = new JLabel("chord");
			lblChord.setBounds(50, 28, 66, 15);
			getContentPane().add(lblChord);
			
			JLabel lblNewLabel_1 = new JLabel("chord1");
			lblNewLabel_1.setBounds(50, 73, 66, 15);
			getContentPane().add(lblNewLabel_1);
			
			JLabel lblChord_1 = new JLabel("chord2");
			lblChord_1.setBounds(50, 120, 66, 15);
			getContentPane().add(lblChord_1);
			
			JLabel lblKey = new JLabel("key");
			lblKey.setBounds(50, 173, 66, 15);
			getContentPane().add(lblKey);
		}
	void setListener(Controler controler) {
		System.out.println("ok123");
		btnNewButton.addActionListener(controler);
		
	}
}
public class window2 {
	private static JTable table;

	

	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Vista window = new Vista()	;
					
					window.setVisible(true);
					Controler c = new Controler(window);
					
					table = new JTable();
					table.setBounds(399, 59, -119, 88);
					window.getContentPane().add(table);
					
					
					
					
					
					window.setListener(c);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
class Controler implements ActionListener{
	
	LinkedList <String> chords = new LinkedList<String>();
	DB db;
	Vista window;
	Controler (Vista window){this.window=window;}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		 db = new DB("music.db");
		 try {
			db.createTable("chords", "chord", "varchar(10)", "chord1", "varchar(10)", "chord2", "varchar(10)"
					 , "primary key (chord,chord1,chord2)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (o == window.btnNewButton) { 
			
			  System.out.println("ok");
			  int i1 = (int) window.spinner.getValue();
			  System.out.println(i1);
				int i2 = (int) window.spinner_1.getValue();
				int i3 = (int) window.spinner_2.getValue();
				String key = window.textField.getText();
				
				chords.add("Amaj");
				chords.add("Bmaj");
				chords.add("Cmaj");
				chords.add("Dmaj");
				chords.add("Emaj");
				chords.add("Fmaj");
				chords.add("Gmaj");
				String chordsExchange="";
				System.out.println(key+1);
				if(key.equalsIgnoreCase("a") ) {
					window.lblNewLabel.setText(chords.get(i1)+">"+chords.get(i2)+">"+chords.get(i3));
				
				}
				else if(key.equalsIgnoreCase("b") ) {
					
					chords.addLast(chords.getFirst());
					chords.removeFirst();
					for(int i = 0;i<chords.size();i++) {System.out.println(chords.get(i));}
					window.lblNewLabel.setText(chords.get(i1)+">"+chords.get(i2)+">"+chords.get(i3));
					try {
						db.insert("("+chords.get(i1)+","
						+chords.get(i1)+","+
						chords.get(i1)+")", "chords");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(key.equalsIgnoreCase("c") ) {
					chordsExchange = chords.get(chords.size());
					for(int i = 0;i<2;i++) 
					{
						chords.addLast(chords.getFirst());
						chords.removeFirst();
					}
					window.lblNewLabel.setText(chords.get(i1)+">"+chords.get(i2)+">"+chords.get(i3));
					try {
						db.insert("("+chords.get(i1)+","
								+chords.get(i1)+","+
								chords.get(i1)+")", "chords");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(key.equalsIgnoreCase("d") ) {
					chordsExchange = chords.get(chords.size());
					for(int i = 0;i<3;i++) 
					{
						chords.addLast(chords.getFirst());
						chords.removeFirst();
					}
					window.lblNewLabel.setText(chords.get(i1)+">"+chords.get(i2)+">"+chords.get(i3));
					try {
						db.insert("("+chords.get(i1)+","
								+chords.get(i1)+","+
								chords.get(i1)+")", "chords");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(key.equalsIgnoreCase("e") ) {
					chordsExchange = chords.get(chords.size());
					for(int i = 0;i<4;i++) 
					{
						chords.addLast(chords.getFirst());
						chords.removeFirst();
					}
					window.lblNewLabel.setText(chords.get(i1)+">"+chords.get(i2)+">"+chords.get(i3));
					try {
						db.insert("("+chords.get(i1)+","
								+chords.get(i1)+","+
								chords.get(i1)+")", "chords");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(key.equalsIgnoreCase("f") ) {
					chordsExchange = chords.get(chords.size());
					for(int i = 0;i<5;i++) 
					{
						chords.addLast(chords.getFirst());
						chords.removeFirst();
					}
					window.lblNewLabel.setText(chords.get(i1)+">"+chords.get(i2)+">"+chords.get(i3));
					try {
						db.insert("("+chords.get(i1)+","
								+chords.get(i1)+","+
								chords.get(i1)+")", "chords");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(key.equalsIgnoreCase("g") ) {
					chordsExchange = chords.get(chords.size());
					for(int i = 0;i<6;i++) 
					{
						chords.addLast(chords.getFirst());
						chords.removeFirst();
					}
					window.lblNewLabel.setText(chords.get(i1)+">"+chords.get(i2)+">"+chords.get(i3));
					try {
						db.insert("("+chords.get(i1)+","
								+chords.get(i1)+","+
								chords.get(i1)+")", "chords");
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else {window.lblNewLabel.setText("error");}
				chords = null;
		  }
		try {
			window.list.setModel(db.selectAll("chords"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		
		return st.execute("CREATE TABLE IF NOT EXISTS "+tableName+" ("
					+column1 +" "+dataTypeOfColumn1+","+
					column2 +" "+dataTypeOfColumn2+","+
					column3+" "+dataTypeOfColumn3
			  +")");
		
	}
boolean insert(String values,String tableName) throws SQLException {
		Statement st = (Statement) cn.createStatement();
		return st.execute("insert into "+tableName+" values"+values);
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
String selectColumn(String tableName,String column) throws SQLException {
	Statement st = (Statement) cn.createStatement();
	
	 st.execute("select * from "+tableName);
	ResultSet rs =st.getResultSet();
	return rs.getString(column);
}
}
