package Hospital;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class frmMainForm {

	 JFrame frame;
	 private JButton btnRoom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMainForm window = new frmMainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frmMainForm() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 13, 1400, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setBackground(SystemColor.activeCaption);
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		
		
		JButton btnStaff = new JButton("");
		btnStaff.setBackground(new Color(0, 139, 139));
		//btnStaff.setOpaque(false);
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmStaff window = new frmStaff();
				window.frame.setVisible(true);
			}
		});
		btnStaff.setIcon(new ImageIcon("staff.png"));
		btnStaff.setBounds(352, 183, 174, 89);
		frame.getContentPane().add(btnStaff);
		
		JButton btnLog = new JButton("Log Out");
		btnLog.setBorder(BorderFactory.createMatteBorder(4,4,4,4, Color.darkGray));
		btnLog.setBackground(SystemColor.activeCaption);
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				frmLogin window = new frmLogin();
				window.frame.setVisible(true);
			}
		});
		btnLog.setBounds(1202, 39, 151, 39);
		frame.getContentPane().add(btnLog);
		
		JLabel lblDate = new JLabel("");
		lblDate.setFont(new Font("Khmer OS", Font.PLAIN, 20));
		lblDate.setBounds(1098, 612, 248, 39);
		frame.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("");
		lblTime.setFont(new Font("Khmer OS", Font.PLAIN, 20));
		lblTime.setBounds(1098, 651, 248, 39);
		frame.getContentPane().add(lblTime);
		
		JLabel lblChallenger = new JLabel("\u1798\u1793\u17D2\u1791\u17B8\u179A\u1796\u17C1\u1791\u17D2\u1799 ");
		lblChallenger.setForeground(new Color(0, 139, 139));
		lblChallenger.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChallenger.setFont(new Font("Khmer OS Muol", Font.PLAIN, 40));
		lblChallenger.setBounds(352, 51, 289, 113);
		frame.getContentPane().add(lblChallenger);
		
		btnRoom = new JButton("");
		btnRoom.setBackground(new Color(0, 139, 139));
		btnRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRoom window = new frmRoom();
				window.frame.setVisible(true);
			}
		});
		btnRoom.setBounds(352, 324, 174, 89);
		btnRoom.setIcon(new ImageIcon("room.png"));
		frame.getContentPane().add(btnRoom);
		
		JButton btnSale = new JButton("");
		btnSale.setBackground(new Color(0, 139, 139));
		btnSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmSale window = new frmSale();
				window.frame.setVisible(true);	
			}
		});
		btnSale.setBounds(352, 465, 174, 89);
		btnSale.setIcon(new ImageIcon("sale.png"));
		frame.getContentPane().add(btnSale);
		
		JLabel lblNewLabel_1 = new JLabel("\u1794\u17BB\u1782\u17D2\u1782\u179B\u17B7\u1780");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(352, 283, 174, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u17A2\u17D2\u1793\u1780\u1787\u17C6\u1784\u17BA");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_1.setBounds(616, 283, 174, 30);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u17A2\u17D2\u1793\u1780\u1795\u17D2\u1782\u178F\u17CB\u1795\u17D2\u1782\u1784\u17CB");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_2.setBounds(872, 283, 174, 30);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u1794\u1793\u17D2\u1791\u1794\u17CB");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_3.setBounds(352, 424, 174, 30);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u1790\u17D2\u1793\u17B6\u17C6");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_4.setBounds(616, 424, 174, 30);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u1782\u17D2\u179A\u17BC\u1796\u17C1\u1791\u17D2\u1799");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_5.setBounds(875, 424, 174, 30);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u1780\u17B6\u179A\u179B\u1780\u17CB");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_6.setBounds(352, 565, 174, 30);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u1794\u1789\u17D2\u1787\u17B8");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_7.setBounds(616, 565, 174, 30);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u1794\u1784\u17D2\u1780\u17BE\u178F\u1782\u178E\u1793\u17B8");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_8.setBounds(352, 701, 174, 30);
		frame.getContentPane().add(label_8);
		
		JButton btnPatient = new JButton("");
		btnPatient.setBackground(new Color(0, 139, 139));
		btnPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPForm window = new frmPForm();
				window.frame.setVisible(true);
			}
		});
		btnPatient.setBounds(616, 183, 174, 89);
		btnPatient.setIcon(new ImageIcon("patient.png"));
		frame.getContentPane().add(btnPatient);
		
		JButton btnMedicine = new JButton("");
		btnMedicine.setBackground(new Color(0, 139, 139));
		btnMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMedicine window = new frmMedicine();
				window.frame.setVisible(true);
			}
		});
		btnMedicine.setBounds(616, 324, 174, 89);
		btnMedicine.setIcon(new ImageIcon("medicine.png"));
		frame.getContentPane().add(btnMedicine);
		
		JButton btnReport = new JButton("");
		btnReport.setBackground(new Color(0, 139, 139));
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReport.setBounds(616, 465, 174, 89);
		btnReport.setIcon(new ImageIcon("report.png"));
		frame.getContentPane().add(btnReport);
		
		JButton btnSupplier = new JButton("");
		btnSupplier.setBackground(new Color(0, 139, 139));
		btnSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSupplier window = new frmSupplier();
				window.frame.setVisible(true);
			}
		});
		btnSupplier.setBounds(875, 183, 174, 89);
		btnSupplier.setIcon(new ImageIcon("supplier.png"));
		frame.getContentPane().add(btnSupplier);
		
		JButton btnDoctor = new JButton("");
		btnDoctor.setBackground(new Color(0, 139, 139));
		btnDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmPDetail window = new frmPDetail();
				window.frame.setVisible(true);
			}
		});
		btnDoctor.setBounds(875, 324, 174, 89);
		btnDoctor.setIcon(new ImageIcon("doctor.png"));
		frame.getContentPane().add(btnDoctor);
		
		JButton btnImport = new JButton("");
		btnImport.setBackground(new Color(0, 139, 139));
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmImport window = new frmImport();
				window.frame.setVisible(true);
			}
		});
		btnImport.setBounds(875, 465, 174, 89);
		btnImport.setIcon(new ImageIcon("import.png"));
		frame.getContentPane().add(btnImport);
		
		JButton btnCreateUser = new JButton("");
		btnCreateUser.setBackground(new Color(0, 139, 139));
		btnCreateUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCreateUser window = new frmCreateUser();
				window.frame.setVisible(true);
			}
		});
		btnCreateUser.setBounds(352, 601, 174, 89);
		btnCreateUser.setIcon(new ImageIcon("create_user.png"));
		frame.getContentPane().add(btnCreateUser);
		
		JLabel label_9 = new JLabel("\u1780\u17B6\u179A\u1793\u17B6\u17C6\u1785\u17BC\u179B");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_9.setBounds(875, 565, 174, 30);
		frame.getContentPane().add(label_9);
		
		JButton btnAbout = new JButton("");
		btnAbout.setBackground(new Color(0, 139, 139));
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAbout window = new frmAbout();
				window.frame.setVisible(true);
			}
		});
		btnAbout.setBounds(616, 603, 174, 89);
		btnAbout.setIcon(new ImageIcon("about.png"));
		frame.getContentPane().add(btnAbout);
		
		JButton btnExit = new JButton("");
		btnExit.setBackground(new Color(0, 139, 139));
		btnExit.setIcon(new ImageIcon("closeprogram.png"));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(875, 603, 174, 89);
		frame.getContentPane().add(btnExit);
		
		JLabel label_10 = new JLabel("\u17A2\u17C6\u1796\u17B8\u1799\u17BE\u1784");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_10.setBounds(616, 701, 174, 30);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("\u1794\u17B7\u1791\u1780\u1798\u17D2\u1798\u179C\u17B7\u1792\u17B8");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Khmer OS", Font.PLAIN, 15));
		label_11.setBounds(875, 701, 174, 30);
		frame.getContentPane().add(label_11);
		
		JLabel lblChallenger_1 = new JLabel("CHALLENGER ");
		lblChallenger_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblChallenger_1.setForeground(new Color(0, 139, 139));
		lblChallenger_1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));
		lblChallenger_1.setBounds(651, 51, 395, 113);
		frame.getContentPane().add(lblChallenger_1);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("challenger.png"));
		lblLogo.setBounds(237, 11, 289, 200);
		frame.getContentPane().add(lblLogo);
		Thread clock=new Thread()
			{
				public void run()
				{
					try
					{
						while(true)
						{
						Calendar ca=new GregorianCalendar();
						int day=ca.get(Calendar.DAY_OF_MONTH);
						int month=ca.get(Calendar.MONTH);
						int year=ca.get(Calendar.YEAR);
						
						int second=ca.get(Calendar.SECOND);
						int minute=ca.get(Calendar.MINUTE);
						int hour=ca.get(Calendar.HOUR);
						
						lblDate.setText("   \u1790\u17D2\u1784\u17C3\u1781\u17C2\u1786\u17D2\u1793\u17B6\u17C6:  "+day+"-"+month+"-"+year);
						lblTime.setText("   \u1798\u17C9\u17C4\u1784:      "+hour+":"+minute+":"+second);
						sleep(1000);
						}
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
		};
		clock.start();
	}
}
