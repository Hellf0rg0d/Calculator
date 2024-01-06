import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.File;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkHardIJTheme;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JSeparator;

public class Adv {

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
	double pi =  3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006606315588174881520920962829254091715364367892590360011330530548820466521384146951941511609433057270365759591953092186117381932611793105118548074462379962749567351885752724891227938183011949129833673362440656643086021394946395224737190702179860943702770539217176293176752384674818467669405132000568127145263560827785771342757789609173637178721468440901224953430146549585371050792279689258923542019956112129021960864034418159813629774771309960518707211349999998372978049951059731732816096318595024459455346908302642522308253344685035261931188171010003137838752886587533208381420617177669147303598253490428755468731159562863882353787593751957781857780532171226806613001927876611195909216420198938095257201065485863278865936153381827968230301952035301852968995773622599413891249721775283479131515574857242454150695950829533116861727855889075098381754637464939319255060400927701671139009848824012858361603563707660104710181942955596198946767837449448255379774726847104047534646208046684259069491293313677028989152104752162056966024058038150193511253382430035587640247496473263914199272604269922796782354781636009341721641219924586315030286182974555706749838505494588586926995690927210797509302955321165344987202755960236480665499119881834797753566369807426542527862551818417574672890977772793800081647060016145249192173217214772350141441973568548161361157352552133475741849468438523323907394143334547762416862518983569485562099219222184272550254256887671790494601653466804988627232791786085784383827967976681454100953883786360950680064225125205117392984896084128488626945604241965285022210661186306744278622039194945047123713786960956364371917287467764657573962413890865832645995813390478027590099465764078951269468398352595709825822620522489407726719478268482601476990902640136394437455305068203496252451749399651431429809190659250937221696461515709858387410597885959772975498930161753928468138268683868942774155991855925245953959431049972524680845987273644695848653836736222626099124608051243884390451244136549762780797715691435997700129616089441694868555848406353422072225828488648158456028506016842739452267467678895252138522549954666727823986456596116354886230577456498035593634568174324112515076069479451096596094025228879710893145669136867228748940560101503308;
	double constant = Math.PI/180;
	double constant2 = 180/Math.PI;
	boolean shift = false;
	boolean cntrl = false;
	String privalue = "";
	Double secvalue = null;
	private JButton dec;
	private JButton sine;
	private JButton cose;
	private JButton tane;
	private JButton expo;
	private JButton log;
	private JButton pow;
	private JButton equal;
	private JButton clear;
	JTextField dis1;
	String logbase;
	boolean deg = true;
	boolean inv = false;
	boolean antlog = false;
	JLabel antlogname;
	JTextField dis2;
	private JMenuBar menuBar;
	private JMenu set;
	private JLabel epow;
	private JLabel bpow;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adv window = new Adv();
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
	public Adv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Settings settings = new Settings();
		settings.frame.setVisible(false);
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
				
				if(e.getKeyCode() == 17 && cntrl == false) {
					cntrl = true;
				}
				
				if(e.getKeyCode() == 16 && shift == false ) {
					shift = true;	
				}
				else if (cntrl == true && e.getKeyCode() == 86) {
					try {
						Transferable transferable = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
						privalue = transferable.getTransferData(DataFlavor.stringFlavor).toString();
						dis2.setText(privalue);
					cntrl = false;
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
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
				logbase = settings.lgvalue.getText();
				deg = settings.degree;
				inv = settings.inv;
				antlog = settings.antilog;
				if(inv) {
					sine.setText("asin");
					cose.setText("acos");
					tane.setText("atan");
					
				}
				if(antlog) {
					antlogname.setText("antilog");
				}
				if(!inv) {
					sine.setText("sin");
					cose.setText("cos");
					tane.setText("tan");
				}
				if(!antlog) {
					antlogname.setText("log");
				}
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
		dis1.setFont(new Font("IBMsemi", Font.PLAIN, 30));
		dis1.setHorizontalAlignment(SwingConstants.RIGHT);
		dis1.setBounds(12, 42, 514, 44);
		frame.getContentPane().add(dis1);
		
		dis2 = new JTextField("0");
	    dis2.setEditable(false);
	    dis2.setBorder(null);
	    dis2.setForeground(Color.WHITE);
		dis2.setFont(new Font("IBMsemi", Font.PLAIN, 35));
		dis2.setHorizontalAlignment(SwingConstants.RIGHT);		dis2.setBounds(0, 98, 526, 54);
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
		antlogname = new JLabel("log");
		antlogname.setHorizontalAlignment(SwingConstants.CENTER);
		antlogname.setVerticalAlignment(SwingConstants.TOP);
		antlogname.setFont(new Font("IBMsemi",0,18));
		antlogname.setBounds(341, 330, 75, 30);
		frame.getContentPane().add(antlogname);
		
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
				
				sine = new JButton("sin");
				sine.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 0;
						operate(operation);
					}
				});
				sine.setBounds(341, 164, 75, 60);
				sine.setFont(new Font("IBMsemi",0,18));
				frame.getContentPane().add(sine);
				
				cose = new JButton("cos");
				cose.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
							operation = 1;
							operate(operation);
						
						
					}
				});
				cose.setBounds(441, 164, 75, 60);
				cose.setFont(new Font("IBMsemi",0,18));
				frame.getContentPane().add(cose);
				
				tane = new JButton("tan");
				tane.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 2;
						operate(operation);
					}
				});
				tane.setBounds(341, 243, 75, 60);
				tane.setFont(new Font("IBMsemi",0,18));
				frame.getContentPane().add(tane);
				
				epow = new JLabel("  x");
				epow.setBounds(480, 258, 34, 15);
				epow.setFont(new Font("IBMsemi",0,14));
				frame.getContentPane().add(epow);
				
				expo = new JButton("e");
				expo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					operation =6;
						operate(operation);
					}
				});
				expo.setBounds(441, 240, 75, 60);
				expo.setFont(new Font("IBMsemi",0,20));
				frame.getContentPane().add(expo);
				
				log = new JButton("");
				log.setIcon(null);
				log.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 4;
						operate(operation);
					}
				});
				log.setFont(new Font("IBMsemi",0,17));
				log.setBounds(341, 310, 75, 60);
				frame.getContentPane().add(log);
				
				bpow = new JLabel("b");
				bpow.setBounds(485, 323, 39, 15);
				bpow.setFont(new Font("IBMsemi",0,14));
				frame.getContentPane().add(bpow);
				
				pow = new JButton("a");
				pow.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						operation = 5;
						operate(operation);
					}
				});
				pow.setFont(new Font("IBMsemi",0,26));
				pow.setBounds(441, 310, 75, 60);
				frame.getContentPane().add(pow);
				
				equal = new JButton("=");
				equal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						secvalue = Double.parseDouble(dis2.getText());
						privalue = "0";
					
					}
				});
				equal.setFont(new Font("IBMsemi",0,26));
				equal.setBounds(341, 380, 75, 48);
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
				clear.setBounds(441, 380, 75, 48);
				frame.getContentPane().add(clear);
				
				menuBar = new JMenuBar();
				menuBar.setBounds(0, 0, 581, 37);
				frame.getContentPane().add(menuBar);
				
				JMenu more = new JMenu("More");
				menuBar.add(more);
				
				JMenuItem bas = new JMenuItem("Basic");
				bas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.dispose();
						Main main = new Main();
						main.frame.setVisible(true);
					}
				});
				more.add(bas);
				
				JMenu about = new JMenu("About");
				about.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						}
					@Override
					public void mousePressed(MouseEvent e) {
						
						JOptionPane.showMessageDialog(frame, "This Applications doesn't provide accurate data it provides round-off values ");
					
					}
				});
				
				menuBar.add(about);
				
				set = new JMenu("Settings");
				set.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						}
					@Override
					public void mousePressed(MouseEvent e) {
						settings.frame.setVisible(true);
					}
				});
				menuBar.add(set);
				
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
				
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBounds(300, 164, 2, 264);
				frame.getContentPane().add(separator);

				frame.requestFocusInWindow();
	}
	private void operate(int a) {
		frame.requestFocusInWindow();
		dis1.setForeground(Color.WHITE);
		dis2.setForeground(Color.WHITE);
		if(inv == true ) {
			if(a == 0) {
			if(deg == false) {
				dis1.setText("arcsin("+privalue+")");
				dis2.setText(Double.toString(Math.asin(Double.parseDouble(privalue))));
			}
			else {
				dis1.setText("arcsin("+privalue+")");
				secvalue = Math.asin(Double.parseDouble(privalue));
				secvalue = secvalue*constant2;
				dis2.setText(Double.toString(secvalue));

			}
			}
			else if(a == 1) {
				if(deg == false) {
					dis1.setText("arccos("+privalue+")");
					dis2.setText(Double.toString(Math.acos(Double.parseDouble(privalue))));
				}
				else {
					dis1.setText("arctan("+privalue+")");
					secvalue = Math.acos(Double.parseDouble(privalue));
					secvalue = secvalue*constant2;
					dis2.setText(Double.toString(secvalue));

				}
				
			}
			else if(a == 2) {
				if(deg == false) {
					dis1.setText("arctan("+privalue+")");
					dis2.setText(Double.toString(Math.atan(Double.parseDouble(privalue))));
				}
				else {
					dis1.setText("arctan("+privalue+")");
					secvalue = Math.atan(Double.parseDouble(privalue));
					secvalue = secvalue*constant2;
					dis2.setText(Double.toString(secvalue));

				}
			}
			
			
		}
		else if(antlog == true) {
			if( a== 4) {
				if(logbase.toLowerCase().contains("e")) {
				dis1.setText("AntiLog("+privalue+")");
				dis2.setText(Double.toString(Math.pow(Math.E, Double.parseDouble(privalue))));
				}
				else {
					dis1.setText("AntiLog("+privalue+")");
					dis2.setText(Double.toString(Math.pow(Double.parseDouble(logbase), Double.parseDouble(privalue))));
				}
			}
		}
		else {
		if(a == 0) {
			if(deg == false) {
			dis1.setText("sin("+privalue+"rad)");
			
			dis2.setText(Double.toString(((double)Math.round(Math.sin(Double.parseDouble(privalue))*100)/100)));
			}
			else {
				secvalue = Double.parseDouble(privalue)*constant;
				dis1.setText("sin("+privalue+"°)");
				
				dis2.setText(Double.toString(((double)Math.round(Math.sin(secvalue)*100)/100)));
			}
		}
		else if (a == 1) {
			if(deg == false) {
				
				dis1.setText("cos("+privalue+"rad)");
				dis2.setText(Double.toString(((double)Math.round(Math.cos(Double.parseDouble(privalue))*100)/100)));
				}
				else {
					secvalue = Double.parseDouble(privalue)*constant;
					dis1.setText("cos("+privalue+"°)");
					dis2.setText(Double.toString(((double)Math.round(Math.cos(secvalue)*100)/100)));
				}
		}
		else if(a == 2) {
			if(deg == false) {
				
				dis1.setText("tan("+privalue+"rad)");
				dis2.setText(Double.toString(((double)Math.round(Math.tan(Double.parseDouble(privalue))*100)/100)));
				
			}
				else {
						secvalue = Double.parseDouble(privalue)*constant;
					dis1.setText("tan("+privalue+"°)");
					dis2.setText(Double.toString(((double)Math.round(Math.tan(secvalue)*100)/100)));
				}
			
		}
		if(a == 4) {
			dis1.setText("Log("+privalue+")");
			if(logbase.toLowerCase().equals("e")) {
			dis2.setText(Double.toString(Math.log(Double.parseDouble(privalue)/Math.log(Math.E))));
			if(dis2.getText().toLowerCase().equals("infinity")) {
				dis1.setForeground(new Color(220,100,0));
				dis2.setForeground(new Color(220,100,0));
				
			}
		}
			else {
				dis2.setText(Double.toString(Math.log(Double.parseDouble(privalue))/Math.log(Double.parseDouble(logbase))));
				if(dis2.getText().toLowerCase().equals("infinity")) {
					dis1.setForeground(new Color(220,100,0));
					dis2.setForeground(new Color(220,100,0));
					
				}
			}
		}
		else if( a== 5) {
			if(secvalue == null) {
				secvalue = Double.parseDouble(privalue);
				privalue = "0";
				dis1.setText(secvalue+" ^ "+privalue);
				dis2.setText(Double.toString(Math.pow(secvalue, Double.parseDouble(privalue))));
				if(dis2.getText().toLowerCase().equals("infinity")) {
					dis1.setForeground(new Color(220,100,0));
					dis2.setForeground(new Color(220,100,0));
					
				}
			}
			else {
			dis1.setText(secvalue+" ^ "+privalue);
			dis2.setText(Double.toString(Math.pow(secvalue, Double.parseDouble(privalue))));
			if(dis2.getText().toLowerCase().equals("infinity")) {
				dis1.setForeground(new Color(220,100,0));
				dis2.setForeground(new Color(220,100,0));
				
			}
		}
		}
		else if(a == 6) {
			dis1.setText("e^"+privalue);
			dis2.setText(Double.toString(Math.pow(Math.E,Double.parseDouble(privalue))));
			if(dis2.getText().toLowerCase().equals("infinity")) {
				dis1.setForeground(new Color(220,100,0));
				dis2.setForeground(new Color(220,100,0));
				
			}
		}
		}
	}

	
}
