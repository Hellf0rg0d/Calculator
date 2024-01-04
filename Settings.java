import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.PopupMenu;
import java.io.File;
import java.io.InputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.Choice;
import java.awt.Canvas;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Settings {

	public JFrame frame;
	InputStream is;
	GraphicsEnvironment ge;
	Font IBMsemi;
	Font IBMlight;
	public JTextField lgvalue;
	public boolean inv = false;
	public boolean degree = true;
	public boolean antilog = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings window = new Settings();
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
	public Settings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FlatLaf.setup(new FlatGruvboxDarkHardIJTheme());
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 300, 563, 388);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Logarithm");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 5, 541, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 37, 602, 2);
		frame.getContentPane().add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Value of the base for Logarithm Function :");
		lblNewLabel_1.setBounds(8, 51, 434, 37);
		lblNewLabel_1.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_1);
		
		lgvalue = new JTextField();
		lgvalue.setBorder(null);
		lgvalue.setHorizontalAlignment(SwingConstants.CENTER);
		lgvalue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			
				lgvalue.setEditable(true);
				SwingUtilities.updateComponentTreeUI(lgvalue);
			}
			public void mouseExited(MouseEvent e) {
				
				lgvalue.setEditable(false);
				SwingUtilities.updateComponentTreeUI(lgvalue);
			}
		});
		lgvalue.setText("e");
		lgvalue.setEditable(false);
		lgvalue.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		lgvalue.setBounds(433, 50, 108, 38);
		frame.getContentPane().add(lgvalue);
		lgvalue.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 108, 602, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Other");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(0, 117, 553, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton inve = new JRadioButton("Inverse Trignometric Ratios");
		inve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(inve.isSelected() == true) {
				   inv = true;
				}
				else {
					inv = false;
				}
			}
		});
		inve.setHorizontalAlignment(SwingConstants.CENTER);
		inve.setBounds(0, 159, 533, 37);
		inve.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		frame.getContentPane().add(inve);
		
		JRadioButton alog = new JRadioButton("AntiLog");
		alog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(antilog == false) {
					antilog = true;
				}
				else {
					antilog = false;
				}
			}
		});
		alog.setHorizontalAlignment(SwingConstants.CENTER);
		alog.setBounds(10, 200, 531, 37);
		alog.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		frame.getContentPane().add(alog);
		
		JLabel lblNewLabel_3 = new JLabel("Angle - ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 261, 212, 37);
		lblNewLabel_3.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel_3);
		
		JRadioButton ang1 = new JRadioButton("Degree");
		ang1.setSelected(true);
		ang1.setBounds(175, 263, 149, 32);
		ang1.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		frame.getContentPane().add(ang1);
		
		JRadioButton ang2 = new JRadioButton("Radian");
		
		ang2.setBounds(348, 263, 149, 32);
		ang2.setFont(new Font("IBMsemi", Font.PLAIN, 20));
		frame.getContentPane().add(ang2);
		ang1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				degree = true;
				if(ang2.isSelected() == true) {
					ang2.setSelected(false);
					
				}
				
			}
		});
		ang2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				degree = false;
				if(ang1.isSelected() == true) {
					ang1.setSelected(false);
				}
				
			}
		});
		lblNewLabel.requestFocusInWindow();

		try {
			is = getClass().getResourceAsStream(File.separator+"fonts"+File.separator+"IBMPlexMono-SemiBold.ttf");
			IBMsemi = Font.createFont(Font.TRUETYPE_FONT,is);    
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(IBMsemi);
			is = getClass().getResourceAsStream(File.separator+"fonts"+File.separator+"IBMPlexMono-Light.ttf");
			IBMlight = Font.createFont(Font.TRUETYPE_FONT,is);    
			ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(IBMlight);
			}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
