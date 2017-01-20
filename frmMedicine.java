
package Hospital;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class frmMedicine {

	JFrame frame;
	private JTextField txtID;
	private JTextField txtUPIS;
	private JTable tbMedicine;
	private DefaultTableModel dtmMed = new DefaultTableModel(new Object[]{"ID","Name","UPIS","Quantity","Unit Price"},0);
	
	Connection con;
	Statement stm;
	ResultSet rss;
	String FileName=null;

	
	JButton btnSave = new JButton("\u179A\u1780\u17D2\u179F\u17B6\u1791\u17BB\u1780");
	JButton btnDelete = new JButton("\u179B\u17BB\u1794");
	private JTextField txtName;
	private JTextField txtUP;
	private JTextField txtQty;

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try{
					frmMedicine window = new frmMedicine();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void CloseControl()
	{
		txtID.setEnabled(false);
		txtID.setBackground(Color.lightGray);
		txtName.setEnabled(false);
		txtName.setBackground(Color.lightGray);
		txtUPIS.setEnabled(false);
		txtUPIS.setBackground(Color.lightGray);
		txtQty.setEnabled(false);
		txtQty.setBackground(Color.lightGray);
		txtUP.setEnabled(false);
		txtUP.setBackground(Color.lightGray);
		btnSave.setBounds(420, 119, 134, 36);
		btnSave.setEnabled(false);
		btnDelete.setBounds(420, 166, 134, 36);
		btnDelete.setEnabled(false);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	   // frame.setUndecorated(true);

		
	}
	
	void OnControl()
	{
		txtID.setEnabled(true);
		txtID.setBackground(Color.white);
		txtName.setEnabled(true);
		txtName.setBackground(Color.white);
		txtUPIS.setEnabled(true);
		txtUPIS.setBackground(Color.white);
		txtQty.setEnabled(true);
		txtQty.setBackground(Color.white);
		txtUP.setEnabled(true);
		txtUP.setBackground(Color.white);
		btnSave.setEnabled(true);
	}
	
	void getMedicine()
	{
		try{
		rss=stm.executeQuery("SELECT * From tbmedicine");
		while(rss.next())
		{
			dtmMed.addRow(new Object[]{
										rss.getString(1),
										rss.getString(2),
										rss.getString(3),
										rss.getString(4),
										rss.getString(5)
			});
		}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
}
	
/*	void getRoomType()
	{
		try{
		rss=stm.executeQuery("SELECT RType FROM tbroomtype");
		while(rss.next()){
			cboType.addItem(rss.getString(1));
		}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}	
*/
	void Connection()
	{
		try {
			//con = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/hospital?characterEncoding=utf-8","root","");
			con = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/database?characterEncoding=utf-8","root","12345");
			//con = DriverManager.getConnection("jdbc:mysql:" + "//192.168.88.161/database","ISAD","12345");
			stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception ex)
		{
			System.out.print(ex);
		}
	}


	/**
	 * @wbp.parser.entryPoint
	 */
	public frmMedicine() {
		Connection();
		initialize();
		CloseControl();
		getMedicine();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 569, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		frame.addWindowListener(new WindowAdapter(){
	    	 public void windowClosing(WindowEvent e)
	    	 {
	    		 frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    	 }
	     });
		
		
		JLabel label = new JLabel("\u1788\u17D2\u1798\u17C4\u17C7\u1790\u17D2\u1793\u17B6\u17C6");
		label.setBounds(10, 119, 143, 36);
		label.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u179B\u17C1\u1781\u179F\u17C6\u1782\u17B6\u179B\u17CB\u1790\u17D2\u1793\u17B6\u17C6");
		label_1.setBounds(10, 72, 143, 36);
		label_1.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u178F\u1798\u17D2\u179B\u17C3\u1799\u1780\u1785\u17BC\u179B");
		label_2.setBounds(10, 166, 143, 36);
		label_2.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		frame.getContentPane().add(label_2);
		
		txtID = new JTextField();
		txtID.setBounds(163, 72, 228, 36);
		frame.getContentPane().add(txtID);
		txtID.setColumns(10);
		
		txtUPIS = new JTextField();
		txtUPIS.setBounds(163, 166, 228, 36);
		txtUPIS.setColumns(10);
		frame.getContentPane().add(txtUPIS);
		
		JButton btnNew = new JButton("\u1794\u1793\u17D2\u1790\u17C2\u1798\u1790\u17D2\u1798\u17B8");
		btnNew.setBounds(420, 72, 134, 36);
		//btnNew.setHorizontalTextPosition(SwingConstants.RIGHT);
		//btnNew.setIconTextGap(15);
		//btnNew.setIcon(new ImageIcon("add new.png"));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnNew.getText()=="\u1794\u1793\u17D2\u1790\u17C2\u1798\u1790\u17D2\u1798\u17B8")
				{
					OnControl();
					btnSave.setText("\u179A\u1780\u17D2\u179F\u17B6\u1791\u17BB\u1780");
					btnDelete.setEnabled(false);
					txtID.requestFocus();
					txtID.setText(null);
					txtName.setText(null);
					txtUPIS.setText(null);
					txtQty.setText(null);
					txtUP.setText(null);
					tbMedicine.setFocusable(false);
					btnNew.setText("\u1794\u17C4\u17C7\u1794\u1784\u17CB");
				}
				else
				{	
					btnNew.setText("\u1794\u1793\u17D2\u1790\u17C2\u1798\u1790\u17D2\u1798\u17B8");
					CloseControl();
					txtID.setText(null);
					txtName.setToolTipText(null);
					txtUPIS.setText(null);
					txtQty.setToolTipText(null);
					txtUP.setText(null);
					tbMedicine.setFocusable(false);
					btnSave.setText("\u179A\u1780\u17D2\u179F\u17B6\u1791\u17BB\u1780");
				}	
			}
		});
		btnNew.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		frame.getContentPane().add(btnNew);
		
		//JButton btnDelete = new JButton("\u179B\u17BB\u1794");
		//btnDelete.setHorizontalTextPosition(SwingConstants.RIGHT);
		//btnDelete.setIconTextGap(20);
		//btnDelete.setIcon(new ImageIcon("recycling-bin.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice=JOptionPane.showOptionDialog(null,"Do you want to delete?","Delete",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
				if(choice==JOptionPane.YES_OPTION)
				{
				 String sql="DELETE FROM tbmedicine WHERE MedID= "+ txtID.getText() +";";
				 try{
					 //System.out.println(sql);;
						stm.execute(sql);
						JOptionPane.showMessageDialog(null,"Deleted");
						txtID.setText(null);
						txtName.setText(null);
						txtUPIS.setText(null);
						txtQty.setText(null);
						txtUP.setText(null);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				 	dtmMed.setRowCount(0);
				 	CloseControl();
				 	getMedicine();
					}
				else
					return;
			}
		
		});
		btnDelete.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		frame.getContentPane().add(btnDelete);
		
		//JButton btnSave = new JButton("\u179A\u1780\u17D2\u179F\u17B6\u1791\u17BB\u1780");
		//btnSave.setHorizontalTextPosition(SwingConstants.RIGHT);
		//btnSave.setIconTextGap(10);
		//btnSave.setIcon(new ImageIcon("save.png"));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(btnSave.getText()=="\u179A\u1780\u17D2\u179F\u17B6\u1791\u17BB\u1780")
			{	
				if(txtID.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Insert ID...");}
				else if(txtName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Insert Name...");}
				else if(txtUPIS.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Insert Unit Price in Stock...");}
				else if(txtQty.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Insert Quantity...");}
				else if(txtUP.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Insert Unit Price...");}
				else{
				int Choice=JOptionPane.showOptionDialog(null,"Do you want to save?","Save",JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,null,null);
				if(Choice==JOptionPane.YES_OPTION)
				{
					String ID=txtID.getText();
					String Name=txtName.getText();
					String UPIS=txtUPIS.getText();
					String Qty=txtQty.getText();
					String UP=txtUP.getText();
					try{
						PreparedStatement ps=con.prepareStatement("INSERT INTO tbmedicine VALUE(?,?,?,?,?)");
						ps.setString(1,ID);
						ps.setString(2, Name);
						ps.setString(3, UPIS);
						ps.setString(4, Qty);
						ps.setString(5, UP);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"Saved","Save", JOptionPane.INFORMATION_MESSAGE);
						dtmMed.setRowCount(0);
						getMedicine();
						txtID.setText(null);
						txtName.setText(null);
						txtUPIS.setText(null);
						txtQty.setText(null);
						txtUP.setText(null);
						btnNew.doClick();
					}catch(SQLException ex)
					{
						ex.printStackTrace();
					}
					
				}}
			}
			else
			{
				int Choice=JOptionPane.showOptionDialog(null,"Do you want to update?","Update",JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null,null,null);
				if(Choice==JOptionPane.YES_OPTION)
				{
					String ID=txtID.getText();
					String Name=txtName.getText();
					String UPIS=txtUPIS.getText();
					String Qty=txtQty.getText();
					String UP=txtUP.getText();
					try {
						PreparedStatement ps=con.prepareStatement("UPDATE tbmedicine set MedName=?, MedQty=?, UPIS=?, UnitPrice=? WHERE MedID= " + ID + ";");
						if(Objects.equals(null, FileName))
						{
					    ps.setString(1, Name);
					    ps.setString(2, UPIS);
					    ps.setString(3, Qty);
						ps.setString(4, UP);
				    	ps.executeUpdate();
				    	JOptionPane.showMessageDialog(null,"Updated");
				    	dtmMed.setRowCount(0);
				    	getMedicine();
					    }
					} catch (SQLException e) {
						e.printStackTrace();
					}
					btnNew.setText("\u1794\u1793\u17D2\u1790\u17C2\u1798\u1790\u17D2\u1798\u17B8");
					CloseControl();
					txtID.requestFocus();
					txtID.setText(null);
					txtName.setText(null);
					txtUPIS.setText(null);
					txtQty.setText(null);
					txtUP.setText(null);
					tbMedicine.setFocusable(false);
				//	btnNew.doClick();
					}
			}
			}
					
			}
		);
		
		btnSave.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		frame.getContentPane().add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 318, 564, 159);
		frame.getContentPane().add(scrollPane);
		
		tbMedicine = new JTable();
		tbMedicine.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		scrollPane.setViewportView(tbMedicine);
		tbMedicine.setModel(dtmMed);
		tbMedicine.setRowHeight(30);
		//tbMedicine.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbMedicine.getTableHeader().setResizingAllowed(false);
		tbMedicine.getTableHeader().setReorderingAllowed(false);
		tbMedicine.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent e)
			{
				if(tbMedicine.getSelectedRow()>=0)
				{
				txtID.setText((String) tbMedicine.getModel().getValueAt(tbMedicine.getSelectedRow(),0));
				try
				{
					rss = stm.executeQuery("SELECT * FROM tbmedicine WHERE  MedID='" + txtID.getText() + "'");
					while(rss.next())
					{
						txtID.setText(rss.getString(1));
						txtName.setText(rss.getString(2));
						txtUPIS.setText(rss.getString(3));
						txtQty.setText(rss.getString(4));
						txtUP.setText(rss.getString(5));
					}	 
					btnDelete.setEnabled(true);
					btnSave.setEnabled(true);
					btnSave.setText("\u1792\u17D2\u179C\u17BE\u1794\u1785\u17D2\u1785\u17BB\u1794\u17D2\u1794\u1793\u17D2\u1793\u1797\u17B6\u1796");
					txtID.setEnabled(false);
					txtID.setBackground(Color.white);
					txtName.setEnabled(true);
					txtName.setBackground(Color.white);
					txtUPIS.setEnabled(true);
					txtUPIS.setBackground(Color.white);
					txtQty.setEnabled(true);
					txtQty.setBackground(Color.white);
					txtUP.setEnabled(true);
					txtUP.setBackground(Color.white);
					btnNew.setText("\u1794\u17C4\u17C7\u1794\u1784\u17CB");
				}catch(SQLException ex){
					ex.printStackTrace();
				}
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("\u1796\u178F\u17CC\u1798\u17B6\u1793\u1790\u17D2\u1793\u17B6\u17C6");
		lblNewLabel.setBounds(0, 0, 543, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Khmer OS", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u178F\u1798\u17D2\u179B\u17C3\u179B\u1780\u17CB\u1785\u17C1\u1789");
		label_3.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_3.setBounds(10, 260, 143, 36);
		frame.getContentPane().add(label_3);
		
		txtName = new JTextField();
		txtName.setEnabled(false);
		txtName.setColumns(10);
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setBounds(163, 119, 228, 36);
		frame.getContentPane().add(txtName);
		
		txtUP = new JTextField();
		txtUP.setEnabled(false);
		txtUP.setColumns(10);
		txtUP.setBackground(Color.LIGHT_GRAY);
		txtUP.setBounds(163, 260, 228, 36);
		frame.getContentPane().add(txtUP);
		
		txtQty = new JTextField();
		txtQty.setEnabled(false);
		txtQty.setColumns(10);
		txtQty.setBackground(Color.LIGHT_GRAY);
		txtQty.setBounds(163, 213, 228, 36);
		frame.getContentPane().add(txtQty);
		
		JLabel label_4 = new JLabel("\u1794\u179A\u17B7\u1798\u17B6\u178E");
		label_4.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_4.setBounds(10, 213, 143, 36);
		frame.getContentPane().add(label_4);
		
		JButton btExit = new JButton("\u1785\u17B6\u1780\u1785\u17C1\u1789");
		btExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.exit(0);
				frame.dispose();
			}
		});
		btExit.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		btExit.setBounds(420, 213, 134, 36);
		frame.getContentPane().add(btExit);
	
	}
}
