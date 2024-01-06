import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsDevice.WindowTranslucency;
import java.awt.GraphicsEnvironment;
import java.awt.KeyboardFocusManager;
import java.awt.TextField;

import javax.swing.JFrame;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class Main {

	public JFrame frame;
	JButton one;
	JButton two;
	JButton three;
	JButton four;
	JButton five;
	JButton six;
	JButton seven;
	JButton eight;
	JButton nine;
	JButton zero;
	Font IBMsemi;
	Font IBMlight;
	InputStream is;
 GraphicsEnvironment ge;
	int operation = -1;
	boolean shift = false;
	String privalue = "";
	int cycle = 0;
	Double secvalue = null;
	private JButton dec;
	private JButton mult;
	private JButton div;
	private JButton add;
	private JButton sub;
	private JButton sqr;
	private JButton sqrt;
	private JButton equal;
	private JButton clear;
	JTextField dis1;
	JTextField dis2;
	private JMenuBar menuBar;
	private JSeparator separator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					
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
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ge =  GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        FlatLaf.setup(new FlatGruvboxDarkHardIJTheme());
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()>47 && e.getKeyCode()<58 && shift == false) {
					if(operation == -1) {
				 		privalue = privalue+e.getKeyChar();
				 		dis2.setText(privalue);
				 		}
				 		else{
				 			
				 			if(privalue.equals("0")) {
				 				privalue = e.getKeyText(e.getKeyCode());
				 			}
				 			else {	
				 				privalue = privalue+e.getKeyChar();
				 			
				 			}
				 		
				 			operate(operation);
				 		}
				}
				
				
				if(e.getKeyCode() == 16 && shift == false ) {
					shift = true;	
				}
				if(shift == true && e.getKeyCode() == 61) {
					add.doClick();
					shift = false;
				}
				else if(shift == false && e.getKeyCode() == 45) {
					sub.doClick();
					shift = false;
				}
				else if(shift == true && e.getKeyCode() == 56) {
					mult.doClick();
					shift = false;
				}
				
				else if(shift == false && e.getKeyCode() == 47) {
					div.doClick();
				}
				else if(shift == false && e.getKeyCode() == 46) {
					dec.doClick();
				}
				else if(e.getKeyCode() == 10) {
					equal.doClick();
					shift = false;
				}
				else if(e.getKeyCode() == 8) {
					try {
					char [] tempvalue = privalue.toCharArray();
					tempvalue[privalue.length()-1] = '\0';
					StringBuilder sb = new StringBuilder();
					 for (int i = 0; i < tempvalue.length-1; i++) {
				            sb.append(tempvalue[i]);
				        }
					privalue = sb.toString();
					if(operation == -1) {
						dis2.setText(privalue);
						
					}
					else {
						operate(operation);
					}
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				else if(e.getKeyCode() == 27) {
					clear.doClick();
					shift = false;
				}
			}
			
		});
		
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {	
				frame.requestFocusInWindow();	
			}
			public void windowLostFocus(WindowEvent e) {
				
			}
		});
		frame.setResizable(false);
		
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
		frame.setFont(new Font("IBMsemi",0,10));
		frame.setBounds(100, 100, 548, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		dis1 = new JTextField("");
		dis1.setBorder(null);
		dis1.setForeground(Color.WHITE);
		dis1.setEditable(false);
		dis1.setFont(new Font("Dialog", Font.PLAIN, 30));
		dis1.setHorizontalAlignment(SwingConstants.RIGHT);
		dis1.setBounds(0, 42, 536, 44);
		frame.getContentPane().add(dis1);
		
	    dis2 = new JTextField("0");
	    dis2.setEditable(false);
	    dis2.setBorder(null);
	    dis2.setForeground(Color.WHITE);
		dis2.setFont(new Font("Dialog", Font.PLAIN, 35));
		dis2.setHorizontalAlignment(SwingConstants.RIGHT);
		dis2.setBounds(0, 98, 526, 54);
		frame.getContentPane().add(dis2);
		

		 one = new JButton("1");
		 one.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		 one.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
		 		privalue = privalue+one.getText();
		 		dis2.setText(privalue);
		 		}
		 		else{
		 			
		 			if(privalue.equals("0")) {
		 				privalue = one.getText();
		 			}
		 			else {	
		 				privalue = privalue+one.getText();
		 			
		 			}
		 		
		 			operate(operation);
		 		}
		 	}
		 });
		 one.setFont(new Font("IBMsemi",0,26));
		one.setBounds(12, 164, 60, 60);
		frame.getContentPane().add(one);
		
		 two = new JButton("2");
		 two.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		 two.setFont(new Font("IBMsemi",0,26));
		 two.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+two.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = two.getText();
			 			}
			 			else {	
			 				privalue = privalue+two.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
		two.setBounds(101, 164, 60, 60);
		frame.getContentPane().add(two);
		
		 three = new JButton("3");
		 three.setFont(new Font("IBMsemi",0,26));
		 three.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		 three.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+three.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = three.getText();
			 			}
			 			else {	
			 				privalue = privalue+three.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
		three.setBounds(190, 164, 60, 60);
		frame.getContentPane().add(three);
		
		 four = new JButton("4");
		 four.setFont(new Font("IBMsemi",0,26));
		 four.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		 four.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+four.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = four.getText();
			 			}
			 			else {	
			 				privalue = privalue+four.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
		four.setBounds(12, 240, 60, 60);
		frame.getContentPane().add(four);
		
		 five = new JButton("5");
		 five.setFont(new Font("IBMsemi",0,26));
		 five.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		 five.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+five.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = five.getText();
			 			}
			 			else {	
			 				privalue = privalue+five.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
		five.setBounds(101, 240, 60, 60);
		frame.getContentPane().add(five);
		
		 six = new JButton("6");
		 six.setFont(new Font("IBMsemi",0,26));
		 six.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		 six.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+six.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = six.getText();
			 			}
			 			else {	
			 				privalue = privalue+six.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
		six.setBounds(190, 240, 60, 60);
		frame.getContentPane().add(six);
		
		 seven = new JButton("7");
		 seven.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+seven.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = seven.getText();
			 			}
			 			else {	
			 				privalue = privalue+seven.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
		 seven.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		seven.setBounds(12, 310, 60, 60);
		seven.setFont(new Font("IBMsemi",0,26));
		frame.getContentPane().add(seven);
		
		 eight = new JButton("8");
		 eight.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+eight.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = eight.getText();
			 			}
			 			else {	
			 				privalue = privalue+eight.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
		 eight.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
		 eight.setFont(new Font("IBMsemi",0,26));
		eight.setBounds(101, 310, 60, 60);
		frame.getContentPane().add(eight);
		
		 nine = new JButton("9");
		 nine.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if(operation == -1) {
			 		privalue = privalue+nine.getText();
			 		dis2.setText(privalue);
			 		}
			 		else{
			 			
			 			if(privalue.equals("0")) {
			 				privalue = nine.getText();
			 			}
			 			else {	
			 				privalue = privalue+nine.getText();
			 			
			 			}
			 		
			 			operate(operation);
			 		}
		 	}
		 });
			nine.setBounds(190, 310, 60, 60);
			nine.putClientProperty(FlatClientProperties.STYLE, "arc : 15");
			nine.setFont(new Font("IBMsemi",0,26));
			frame.getContentPane().add(nine);
			
			 zero = new JButton("0");
			 zero.setFont(new Font("IBMsemi",0,26));
			 zero.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		if(operation == -1) {
				 		privalue = privalue+zero.getText();
				 		dis2.setText(privalue);
				 		}
				 		else{
				 			
				 			if(privalue.equals("0")) {
				 				privalue = zero.getText();
				 			}
				 			else {	
				 				privalue = privalue+zero.getText();
				 			
				 			}
				 		
				 			operate(operation);
				 		}
			 	}
			 });
				zero.setBounds(12, 380, 60, 48);
				frame.getContentPane().add(zero);
				
				dec = new JButton(".");
				dec.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(operation == -1) {
					 		privalue = privalue+dec.getText();
					 		dis2.setText(privalue);
					 		}
					 		else{
					 			
					 			if(privalue.equals("0")) {
					 				privalue = dec.getText();
					 			}
					 			else {	
					 				privalue = privalue+dec.getText();
					 			
					 			}
					 		
					 			operate(operation);
					 		}
					}
				});
				dec.setBounds(190, 380, 60, 48);
				frame.getContentPane().add(dec);
				
				mult = new JButton("X");
				mult.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 0;
						operate(operation);
					}
				});
				mult.setBounds(350, 164, 60, 60);
				mult.setFont(new Font("IBMsemi",0,26));
				frame.getContentPane().add(mult);
				
				div = new JButton("/");
				div.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
							operation = 1;
							operate(operation);
						
						
					}
				});
				div.setBounds(448, 164, 60, 60);
				div.setFont(new Font("IBMsemi",0,26));
				frame.getContentPane().add(div);
				
				add = new JButton("+");
				add.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 2;
						operate(operation);
					}
				});
				add.setBounds(350, 240, 60, 60);
				add.setFont(new Font("IBMsemi",0,26));
				frame.getContentPane().add(add);
				
				sub = new JButton("-");
				sub.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 3;
						operate(operation);
					}
				});
				sub.setBounds(448, 240, 60, 60);
				sub.setFont(new Font("IBMsemi",0,35));
				frame.getContentPane().add(sub);
				JLabel pow2 = new JLabel(" 2");
				pow2.setBounds(386, 320, 24, 15);
				pow2.setFont(new Font("IBMsemi",0,12));
				frame.getContentPane().add(pow2);
				sqr = new JButton("X");
				
				sqr.setIcon(null);
				sqr.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 4;
						operate(operation);
					}
				});
				sqr.setFont(new Font("IBMsemi",0,26));
				sqr.setBounds(350, 310, 60, 60);
				frame.getContentPane().add(sqr);
				
				sqrt = new JButton("√");
				sqrt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 5;
						operate(operation);
					}
				});
				sqrt.setFont(new Font("IBMsemi",0,26));
				sqrt.setBounds(448, 310, 60, 60);
				frame.getContentPane().add(sqrt);
				
				equal = new JButton("=");
				equal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						secvalue = Double.parseDouble(dis2.getText());
						privalue = "0";
					
					}
				});
				equal.setFont(new Font("IBMsemi",0,26));
				equal.setBounds(350, 380, 60, 48);
				frame.getContentPane().add(equal);
				
				clear = new JButton("C");
				clear.setFont(new Font("IBMsemi",0,26));
				clear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.requestFocusInWindow();
						operation = -1;
						privalue = "";
						secvalue = null;
						dis1.setText("");
						dis2.setText("0");
						dis1.setForeground(Color.WHITE);
						dis2.setForeground(Color.WHITE);
					}
				});
				clear.setBounds(448, 380, 60, 48);
				frame.getContentPane().add(clear);
				
				menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 581, 37);
				frame.getContentPane().add(menuBar);
				
				JMenu more = new JMenu("More");
				menuBar.add(more);
				
				JMenuItem adv = new JMenuItem("Advanced");
				adv.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						Adv adv = new Adv();
						adv.frame.setVisible(true);
					}
				});
				more.add(adv);
				
				JMenu about = new JMenu("About");
				menuBar.add(about);
				
				JButton plusorminus = new JButton("±");
				plusorminus.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(privalue.contains("-")) {
							privalue = privalue.replace("-","");
							//privalue.trim();
							if(operation == -1) {
								dis2.setText(privalue);
							}
							else {
								operate(operation);
						}
						}
						else {
							
							try {
								char [] tempvalue = privalue.toCharArray();
								StringBuilder sb = new StringBuilder();
								for(int m = 0; m<privalue.length()+1;m++) {
									if(m == 0) {
								            sb.append('-');
									}
									else {
										sb.append(tempvalue[m-1]);
									}
								}
								
								privalue = sb.toString();
								if(operation == -1) {
									dis2.setText(privalue);
								}
								else {
									operate(operation);
								}
							}
								catch(Exception ex) {
									ex.printStackTrace();
								}
						
					}
					}
				});
				plusorminus.setBounds(101, 382, 60, 48);
				plusorminus.setFont(new Font("IBMsemi",0,26));
				frame.getContentPane().add(plusorminus);
				
				
				separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(300, 164, 2, 257);
				frame.getContentPane().add(separator);
				
				
				frame.requestFocusInWindow();
	}
	private void operate(int a) {
		frame.requestFocusInWindow();
		dis1.setForeground(Color.WHITE);
		dis2.setForeground(Color.WHITE);
		if(a == 0) {
			if(secvalue == null) {
				secvalue = Double.parseDouble(privalue);
				privalue = "0";
				dis1.setText(secvalue+" X "+privalue);
				dis2.setText(Double.toString(secvalue*(Double.parseDouble(privalue))));
			}
			else {
			dis1.setText(secvalue+" X "+privalue);
			dis2.setText(Double.toString(secvalue*(Double.parseDouble(privalue))));
		}}
		else if (a == 1) {
			try {
				if(secvalue == null) {
			secvalue = Double.parseDouble(privalue);
			privalue = "0";
			dis1.setText(secvalue+" / "+privalue);
			dis2.setText(Double.toString(secvalue/(Double.parseDouble(privalue))));
			if(dis2.getText().toLowerCase().equals("infinity")) {
				dis1.setForeground(new Color(220,100,0));
				dis2.setForeground(new Color(220,100,0));
				
			}
			}
				else {
					dis1.setText(secvalue+" / "+privalue);
					dis2.setText(Double.toString(secvalue/(Double.parseDouble(privalue))));
					if(dis2.getText().toLowerCase().equals("infinity")) {
						dis1.setForeground(new Color(220,100,0));
						dis2.setForeground(new Color(220,100,0));
						
					}
				}
			}
			catch(Exception ex) {
				dis2.setText("0");
			}
		}
		else if (a == 2) {
			if(secvalue == null) {
			secvalue = Double.parseDouble(privalue);
			privalue = "0";
			dis1.setText(secvalue+" + "+privalue);
			dis2.setText(Double.toString(secvalue+(Double.parseDouble(privalue))));
		}
			else {
				dis1.setText(secvalue+" + "+privalue);
				dis2.setText(Double.toString(secvalue+(Double.parseDouble(privalue))));
			}
		}
		else if (a == 3) {
			if(secvalue == null) {
			secvalue = Double.parseDouble(privalue);
			privalue = "0";
			dis1.setText(secvalue+" - "+privalue);
			dis2.setText(Double.toString(secvalue-(Double.parseDouble(privalue))));
		}
			else {
				dis1.setText(secvalue+" - "+privalue);
				dis2.setText(Double.toString(secvalue-(Double.parseDouble(privalue))));
			}
		}
		else if (a == 4) {
			//sqr
			if(secvalue == null) {
				secvalue = Double.parseDouble(privalue);
				dis1.setText(secvalue+" X "+privalue);
				dis2.setText(Double.toString(secvalue*(Double.parseDouble(privalue))));
			}
			else {
				dis1.setText(secvalue+" X "+privalue);
				dis2.setText(Double.toString(secvalue*(Double.parseDouble(privalue))));
			}
		}
		else if (a == 5) {
			//sqrt
			if(secvalue == null) {
			secvalue = Double.parseDouble(privalue);
			privalue = "0";
			dis1.setText("√"+secvalue);
			dis2.setText(Double.toString(Math.sqrt(secvalue)));
			if(dis2.getText().equals("NaN")) {
				dis1.setForeground(new Color(220,100,0));
				dis2.setForeground(new Color(220,100,0));
				dis2.setText("Keep it real");
			}
		}
		
		else {
			dis1.setText("√"+secvalue);
			dis2.setText(Double.toString(Math.sqrt(secvalue)));
		}
		}
	}
}
