/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jproject;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Admin
 */
public class Home extends javax.swing.JFrame {
    
    public static Connection getConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/travelax";
        String username = "root";
        String password = "";

        Class.forName(driver);//used to load the JDBC driver class
        //causes the JDBC driver from some jdbc vendor to be loaded into the application
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    String username,from,to,dept_day,arr_day,day,password,time,train_name;
    int from_index,to_index,distance,amount,mute=0,userId,userType;
    Date doj;
    Connection conn = null;
    Statement stmt = null,stmt2=null,stmt3=null;
    ResultSet rs=null,rs2 = null;
    AudioStream audioStream = null;
    
    public class Derived extends Thread
    {
            public void run()
            {
                int i=1;
                while(true){
                    
                    try {
                        InputStream inputStream = getClass().getResourceAsStream(""+i+".wav");
                        audioStream = new AudioStream(inputStream);
                        AudioPlayer.player.start(audioStream);
                        while(audioStream.available()>0){
                            
                        }
                        if(i==3)
                            i=1;
                        else
                            i++;
                    } catch (IOException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            audioStream.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
            }
    }
    
    public Home() throws IOException {
        initComponents();
        
          // get the sound file as a resource out of my jar file;
          // the sound file must be in the same directory as this class file.
          // the input stream portion of this recipe comes from a javaworld.com article.
        
        Derived derivedThread = new Derived();
        derivedThread.start();
        
        jFrame1.getRootPane().setDefaultButton(jButton1);
        jFrame2.getRootPane().setDefaultButton(jButton4);
        jFrame5.getRootPane().setDefaultButton(jButton7);
        bookFrame.getRootPane().setDefaultButton(jButton12);
        register.getRootPane().setDefaultButton(jButton16);
        
        
        jButton11.setBackground(Color.decode("#5D91F0"));
        jButton14.setBackground(Color.decode("#1DDE9E"));
        jButton13.setBackground(Color.decode("#E8357D"));
        jButton15.setBackground(Color.decode("#D4BB92"));
        
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        jFrame1.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        jFrame2.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        jFrame3.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        jFrame4.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        jFrame5.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        jFrame6.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        //jFrame7.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        admin.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        register.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        history.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        bookFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("TAxLogo.jpg")));
        
        date.setMinSelectableDate(new Date());
        Date d7 = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(d7); 
        c.add(Calendar.DATE, 6);
        d7 = c.getTime();
        //DateTime date = parser.parseDateTime(dt);
        
        
        date.setMaxSelectableDate(d7);
        try {
            conn = getConnection();
        } catch (Exception e) {
            System.out.println("Error in connection");
            e.printStackTrace();
        }

        System.out.println("conn=" + conn);
        
        /*
        jFrame1.setLayout(new BorderLayout());
        jFrame1.setContentPane(new JLabel(new ImageIcon("mainImage.jpg")));
        jFrame1.setSize(300,300);
 
        Image bgimage = null;
        MediaTracker mt = new MediaTracker(jFrame1);
        bgimage = Toolkit.getDefaultToolkit().getImage("mainImage.jpg");
        mt.addImage(bgimage, 0);
        */
        }
    static Frame frame;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jFrame3 = new javax.swing.JFrame();
        jButton5 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPasswordField3 = new javax.swing.JPasswordField();
        jLabel21 = new javax.swing.JLabel();
        jFrame4 = new javax.swing.JFrame();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jFrame5 = new javax.swing.JFrame();
        jLabel12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        from_box = new javax.swing.JComboBox();
        to_box = new javax.swing.JComboBox();
        jFrame6 = new javax.swing.JFrame();
        jLabel24 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        bookFrame = new javax.swing.JFrame();
        jLabel43 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel47 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        register = new javax.swing.JFrame();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jPasswordField4 = new javax.swing.JPasswordField();
        jLabel38 = new javax.swing.JLabel();
        jPasswordField5 = new javax.swing.JPasswordField();
        jLabel56 = new javax.swing.JLabel();
        history = new javax.swing.JFrame();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        admin = new javax.swing.JFrame();
        jLabel37 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jLabel68 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setTitle("TravelAX");
        jFrame1.setBounds(new java.awt.Rectangle(450, 200, 0, 0));
        jFrame1.setMinimumSize(new java.awt.Dimension(400, 320));
        jFrame1.setResizable(false);
        jFrame1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jFrame1KeyTyped(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("New User Registration");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Password");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer Login");

        jButton1.setText("Login");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordField1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Back");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(29, 29, 29)
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)
                        .addGap(130, 130, 130))))
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame2.setTitle("TravelAX");
        jFrame2.setBounds(new java.awt.Rectangle(450, 200, 0, 0));
        jFrame2.setMinimumSize(new java.awt.Dimension(400, 300));
        jFrame2.setResizable(false);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Password");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Username");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Agent Login");

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });

        jButton4.setText("Login");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPasswordField2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPasswordField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField2MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Agent Registration");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jButton3.setText("Reset");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Back");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jFrame2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame2Layout.createSequentialGroup()
                                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4)
                                .addGap(27, 27, 27)
                                .addComponent(jButton3)
                                .addGap(21, 21, 21)))
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(38, 38, 38)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(33, 33, 33)
                .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jFrame3.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame3.setTitle("TravelAX");
        jFrame3.setBounds(new java.awt.Rectangle(450, 200, 0, 0));
        jFrame3.setMinimumSize(new java.awt.Dimension(400, 300));
        jFrame3.setResizable(false);

        jButton5.setText("Reset");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Password");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Admin Login");

        jButton6.setText("Login");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPasswordField3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jPasswordField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField3MouseClicked(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Back");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame3Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame3Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(27, 27, 27)
                        .addComponent(jButton5)
                        .addGap(122, 122, 122))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(29, 29, 29)
                        .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(143, 143, 143))))
            .addGroup(jFrame3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel20)
                .addGap(56, 56, 56)
                .addGroup(jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jFrame4.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame4.setTitle("TravelAX");
        jFrame4.setBounds(new java.awt.Rectangle(450, 200, 0, 0));
        jFrame4.setMinimumSize(new java.awt.Dimension(400, 300));
        jFrame4.setResizable(false);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Welcome To TravelAX");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("•   Reservation");
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel17MouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText(" •   Logout          ");
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("•   Booking Histroy");
        jLabel40.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
        });

        jLabel51.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("username");

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame4Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addGroup(jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106))
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        jFrame5.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame5.setTitle("TravelAX");
        jFrame5.setBounds(new java.awt.Rectangle(450, 200, 0, 0));
        jFrame5.setMinimumSize(new java.awt.Dimension(376, 309));
        jFrame5.setResizable(false);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Home");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Reservation");

        jLabel25.setText("From :");

        jLabel26.setText("To :");

        jLabel27.setText("Date :");

        jButton7.setText("Search");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Reset");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        date.setDateFormatString("MMM dd, yyyy");

        from_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jammu", "Delhi", "Agra", "Chennai", "Gwalior", "Kanpur", "Mumbai", "Kolkata", "Jaipur", "Bhopal" }));

        to_box.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jammu", "Delhi", "Agra", "Chennai", "Gwalior", "Kanpur", "Mumbai", "Kolkata", "Jaipur", "Bhopal" }));
        to_box.setSelectedIndex(6);

        javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
        jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame5Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame5Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame5Layout.createSequentialGroup()
                                .addComponent(jButton7)
                                .addGap(203, 203, 203)))
                        .addGroup(jFrame5Layout.createSequentialGroup()
                            .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jFrame5Layout.createSequentialGroup()
                                    .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25)
                                        .addComponent(jLabel26))
                                    .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jFrame5Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(from_box, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame5Layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(to_box, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jFrame5Layout.createSequentialGroup()
                                    .addGap(130, 130, 130)
                                    .addComponent(jButton8)))
                            .addContainerGap()))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jFrame5Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))))
        );
        jFrame5Layout.setVerticalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame5Layout.createSequentialGroup()
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jFrame5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel23)))
                .addGap(52, 52, 52)
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(from_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(to_box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addGap(59, 59, 59))
        );

        jFrame6.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame6.setTitle("TravelAX");
        jFrame6.setBounds(new java.awt.Rectangle(350, 200, 0, 0));
        jFrame6.setMinimumSize(new java.awt.Dimension(786, 340));
        jFrame6.setPreferredSize(new java.awt.Dimension(786, 340));
        jFrame6.setResizable(false);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Home");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Reservation");

        table.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 153)));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Train Name", "From", "Departure Time", "To", "Arrival Time", "Fare", "Availability", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table.setMinimumSize(new java.awt.Dimension(525, 250));
        table.setName(""); // NOI18N
        table.setPreferredSize(new java.awt.Dimension(525, 250));
        table.setRowHeight(20);
        table.setRowMargin(3);
        table.setSelectionBackground(new java.awt.Color(51, 0, 51));
        table.setSelectionForeground(new java.awt.Color(153, 255, 255));
        table.setShowVerticalLines(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(150);
            table.getColumnModel().getColumn(0).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jFrame6Layout = new javax.swing.GroupLayout(jFrame6.getContentPane());
        jFrame6.getContentPane().setLayout(jFrame6Layout);
        jFrame6Layout.setHorizontalGroup(
            jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(279, 279, 279)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jFrame6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrame6Layout.setVerticalGroup(
            jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame6Layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(jFrame6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bookFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        bookFrame.setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        bookFrame.setMinimumSize(new java.awt.Dimension(672, 300));
        bookFrame.setPreferredSize(new java.awt.Dimension(672, 300));
        bookFrame.setResizable(false);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Fare");

        jTextField7.setEditable(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton12.setText("Confirm and Pay");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Name");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("No. of Persons");

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Id No.");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(51, 51, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("Booking Details");

        jButton18.setText("Cancel");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookFrameLayout = new javax.swing.GroupLayout(bookFrame.getContentPane());
        bookFrame.getContentPane().setLayout(bookFrameLayout);
        bookFrameLayout.setHorizontalGroup(
            bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookFrameLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookFrameLayout.createSequentialGroup()
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bookFrameLayout.createSequentialGroup()
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
            .addGroup(bookFrameLayout.createSequentialGroup()
                .addGroup(bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookFrameLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bookFrameLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jButton12)
                        .addGap(80, 80, 80)
                        .addComponent(jButton18)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        bookFrameLayout.setVerticalGroup(
            bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookFrameLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(bookFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12)
                    .addComponent(jButton18))
                .addGap(67, 67, 67))
        );

        register.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        register.setTitle("TravelAX");
        register.setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        register.setMinimumSize(new java.awt.Dimension(400, 343));
        register.setResizable(false);

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel52.setText("Password");
        jLabel52.setPreferredSize(new java.awt.Dimension(56, 14));

        jLabel53.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel53.setText("Username");
        jLabel53.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel54.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel54.setText("Name");
        jLabel54.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel55.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel55.setText("Address");
        jLabel55.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("User Registeration");

        jButton16.setText("Submit");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("Reset");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jPasswordField4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Back");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel38MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel38MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel38MouseExited(evt);
            }
        });

        jPasswordField5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel56.setText("Re-enter Password");
        jLabel56.setPreferredSize(new java.awt.Dimension(56, 14));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register.getContentPane());
        register.getContentPane().setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(registerLayout.createSequentialGroup()
                                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jPasswordField4))
                                        .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(registerLayout.createSequentialGroup()
                                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(registerLayout.createSequentialGroup()
                                                .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(registerLayout.createSequentialGroup()
                                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, registerLayout.createSequentialGroup()
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPasswordField5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                                .addGap(70, 70, 70))))
                    .addGroup(registerLayout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16)
                .addGap(18, 18, 18)
                .addComponent(jButton17)
                .addGap(119, 119, 119))
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(35, 35, 35)
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(jButton17))
                .addGap(13, 13, 13)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        history.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        history.setTitle("TravelAX");
        history.setBounds(new java.awt.Rectangle(350, 200, 0, 0));
        history.setMinimumSize(new java.awt.Dimension(745, 364));
        history.setResizable(false);

        jLabel41.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Booking History");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Home");
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel42MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel42MouseExited(evt);
            }
        });

        table1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Train Name", "From", "To", "No of Persons", "Date of Journey", "Fare", "Date of Booking", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table1.setMinimumSize(new java.awt.Dimension(525, 250));
        table1.setPreferredSize(new java.awt.Dimension(525, 250));
        table1.setSelectionBackground(new java.awt.Color(51, 0, 51));
        table1.setSelectionForeground(new java.awt.Color(153, 255, 255));
        table1.getTableHeader().setReorderingAllowed(false);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(0).setMinWidth(40);
            table1.getColumnModel().getColumn(0).setPreferredWidth(40);
            table1.getColumnModel().getColumn(1).setMinWidth(80);
            table1.getColumnModel().getColumn(1).setPreferredWidth(80);
            table1.getColumnModel().getColumn(2).setMinWidth(110);
            table1.getColumnModel().getColumn(2).setPreferredWidth(110);
            table1.getColumnModel().getColumn(6).setMinWidth(90);
            table1.getColumnModel().getColumn(6).setPreferredWidth(90);
            table1.getColumnModel().getColumn(8).setMinWidth(90);
            table1.getColumnModel().getColumn(8).setPreferredWidth(90);
        }

        javax.swing.GroupLayout historyLayout = new javax.swing.GroupLayout(history.getContentPane());
        history.getContentPane().setLayout(historyLayout);
        historyLayout.setHorizontalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(historyLayout.createSequentialGroup()
                        .addGap(0, 376, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addGap(247, 247, 247)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)))
        );
        historyLayout.setVerticalGroup(
            historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyLayout.createSequentialGroup()
                .addGroup(historyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(historyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel41))
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        admin.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        admin.setTitle("TravelAX");
        admin.setBounds(new java.awt.Rectangle(400, 200, 0, 0));
        admin.setMinimumSize(new java.awt.Dimension(400, 460));
        admin.setResizable(false);

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Admin Portal");

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel48.setText("User ID");
        jLabel48.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField19.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField19KeyPressed(evt);
            }
        });

        jTextField20.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel49.setText("Name");
        jLabel49.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField21.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel64.setText("Address");
        jLabel64.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField22.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField22KeyPressed(evt);
            }
        });

        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel65.setText("Username");
        jLabel65.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField23.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel66.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel66.setText("Password");
        jLabel66.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField24.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel67.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel67.setText("Balance");
        jLabel67.setPreferredSize(new java.awt.Dimension(56, 14));

        jButton21.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton21.setText("Search");
        jButton21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel68.setText("Commission");
        jLabel68.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField25.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel69.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel69.setText("Type");
        jLabel69.setPreferredSize(new java.awt.Dimension(56, 14));

        jTextField26.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton21)
                        .addGap(62, 62, 62)
                        .addComponent(jButton22)
                        .addGap(88, 88, 88))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Logout");
        jLabel70.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel70.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel70.setMaximumSize(new java.awt.Dimension(55, 18));
        jLabel70.setPreferredSize(new java.awt.Dimension(55, 18));
        jLabel70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel70MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel70MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel70MouseExited(evt);
            }
        });

        jMenu1.setText("User Records");

        jMenuItem1.setText("Modify");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Delete");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Transport");

        jMenuItem4.setText("Add");
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Modify");
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("Delete");
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        admin.setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout adminLayout = new javax.swing.GroupLayout(admin.getContentPane());
        admin.getContentPane().setLayout(adminLayout);
        adminLayout.setHorizontalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(adminLayout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        adminLayout.setVerticalGroup(
            adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminLayout.createSequentialGroup()
                .addGroup(adminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(adminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37))
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TravelAX");
        setBounds(new java.awt.Rectangle(450, 200, 400, 300));
        setMinimumSize(new java.awt.Dimension(400, 290));
        setResizable(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Welcome To TravelAX");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Customer Login");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Agent Login");
        jLabel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Admin Login");
        jLabel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        jButton11.setDefaultCapable(false);
        jButton11.setFocusPainted(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton13.setFocusPainted(false);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFocusPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFocusPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jLabel10)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        jFrame1.dispose();
        jLabel18.setText("Customer Registration");
        register.getRootPane().setDefaultButton(jButton16);
        register.setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        jFrame1.dispose();
        frame.setVisible(true);
        jPasswordField1.setText("");
        //jLabel29.setText("");
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        jFrame2.dispose();
        jLabel18.setText("Agent Registration");
        register.getRootPane().setDefaultButton(jButton16);
        register.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        this.dispose();
        userType=1;
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jFrame1.getRootPane().setDefaultButton(jButton1);
        jFrame1.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        this.dispose();
        userType=2;
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jFrame2.getRootPane().setDefaultButton(jButton4);
        jFrame2.setVisible(true);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        jFrame2.dispose();
        frame.setVisible(true);
        jPasswordField2.setText("");
        //jLabel30.setText("");
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        jFrame3.dispose();
        frame.setVisible(true);
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        this.dispose();
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14));
        jFrame3.getRootPane().setDefaultButton(jButton6);
        jFrame3.setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_jLabel17MouseEntered

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        jFrame4.dispose();
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jFrame5.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        jFrame4.dispose();
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        frame.setVisible(true);
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        jFrame6.dispose();
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jFrame4.setVisible(true);
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        username = jTextField1.getText();
        char[] tempP= jPasswordField1.getPassword();
        password="";
        for(int i=0;i<tempP.length;i++){
            password+=tempP[i];
        }
        
        String query = "select * from user where type=1 and username='"+username+"' and password='"+password+"'";

        
        try {
            // create a statement
            stmt = conn.createStatement();

            // execute query and return result as a ResultSet
            rs = stmt.executeQuery(query);
            
            // extract data from the ResultSet
            if(!rs.next()){
               jPasswordField1.setText("");
               JOptionPane.showMessageDialog(rootPane, "Wrong username or password!!!");
            }
            else{
                jLabel51.setText(username);
                userId=rs.getInt("id");
                jPasswordField1.setText("");
                //jLabel29.setVisible(true);
                jFrame1.dispose();
                jFrame4.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        from = from_box.getSelectedItem().toString().toLowerCase();
        to = to_box.getSelectedItem().toString().toLowerCase();
        //day = jDateChooser1.getDate();
        //System.out.println("From:"+from+"   To:"+to);
        
        if(date.getDate()==null){
            JOptionPane.showMessageDialog(this,"Date not specified or is given in wrong format!!!");
            return;
        }
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        
        Date db = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(db); 
        c.add(Calendar.DATE, -1);
        db = c.getTime();
        
        Date da = new Date();
        c = Calendar.getInstance(); 
        c.setTime(da); 
        c.add(Calendar.DATE, 6);
        da = c.getTime();
        
        doj=date.getDate();
        if(db.before(date.getDate())&&da.after(date.getDate())){
            //System.out.println(dateFormat.format(d)); //2014/08/06 15:59:48
            String query = "select * from route where "+from+"!=0 and "+to+"!=0 and "+from+"<"+to;
            String query2="select * from distance where from_station='"+from+"'";
            
            int f=0;
            try {
                // create a statement
                stmt = conn.createStatement();
                stmt2 = conn.createStatement();
                // execute query and return result as a ResultSet
                rs = stmt.executeQuery(query);
                rs2 = stmt2.executeQuery(query2);

                rs2.next();
                //System.out.println("Hello:"+query2);
                distance=rs2.getInt(to);
                rs2.close();
                stmt2.close();
                //System.out.println("d="+distance);
                
                // extract data from the ResultSet

                DefaultTableModel model=(DefaultTableModel)table.getModel();
                model.setRowCount(0);
                
                while(rs.next()){
                    from_index=rs.getInt(from)-1;
                    to_index=rs.getInt(to)-1;
                    time=rs.getString("time");
                    String[] time_array=time.split(",");

                    String dept_time,arr_time; 
                    if(from_index==0){
                        dept_time=time_array[0];
                    }
                    else{
                        dept_time=time_array[from_index].split("-")[1];
                    }

                    if(to_index==(time_array.length-1)){
                        arr_time=time_array[to_index];
                    }
                    else{
                        arr_time=time_array[to_index].split("-")[0];
                    }

                    day=dept_day=date.getDate().toString().split(" ")[0];
                    
                    int day_num1=(Integer.parseInt(dept_time.split(";")[1])-1)%7;
                    int day_num2=(Integer.parseInt(arr_time.split(";")[1])-1)%7;
                    
                    while(day_num1-->0){
                        switch(day){
                            case "Mon":day="Sun";break;
                            case "Tue":day="Mon";break;
                            case "Wed":day="Tue";break;
                            case "Thu":day="Wed";break;
                            case "Fri":day="Thu";break;
                            case "Sat":day="Fri";break;
                            case "Sun":day="Sat";
                        }
                    }
                    
                    arr_day=day;
                    while(day_num2-->0){
                        switch(arr_day){
                            case "Mon":arr_day="Tue";break;
                            case "Tue":arr_day="Wed";break;
                            case "Wed":arr_day="Thu";break;
                            case "Thu":arr_day="Fri";break;
                            case "Fri":arr_day="Sat";break;
                            case "Sat":arr_day="Sun";break;
                            case "Sun":arr_day="Mon";
                        }
                    }
                    
                    
                    //System.out.println(day_num+" "+day);
                    
                    dept_time=dept_time.split(";")[0]+" "+dept_day;
                    arr_time=arr_time.split(";")[0]+" "+arr_day;//11:30 Mon
                    
                    
                    if(rs.getString("days").contains(day)){
                        
                        String[] available=rs.getString("available").split(";")[(rs.getString("days").indexOf(dept_day))/4].split(",");
                        
                        //System.out.println(arr_day);
                        int n1=Integer.parseInt(rs.getString(from));
                        int n2=Integer.parseInt(rs.getString(to));
                        //System.out.println(available[0]);
                        //System.out.println(available[1]);
                        //System.out.println("n1="+n1+" n2="+n2);
                        int min=Integer.parseInt(rs.getString("capacity"));
                        for(int i=n1-1;i<(n2-1);i++){
                            if(Integer.parseInt(available[i])<min){
                                min=Integer.parseInt(available[i]);
                            }
                            //System.out.println(min);
                        }
                        
                        String option;
                        if(min==0){
                            option="NA";
                        }
                        else{
                            option="Book";
                        }
                        
                        int fare=0;
                        switch(rs.getString("type")){
                            case "1":fare=distance/2;break;
                            case "2":fare=distance*4/5;break;
                            case "3":fare=distance;
                        }
                        model.addRow(new Object[]{rs.getString("name"),from,dept_time,to,arr_time,fare,min,option});

                        f=1;
                        //System.out.println(rs.getString("name")+"::"+from+":"+dept_time+"    "+to+":"+arr_time);
                    }
                }
            } 
            catch (Exception e) {
                e.printStackTrace();
            }

            if(f==1){
                jFrame5.dispose();
                jFrame6.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(this,"No trains found!!");
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Date Outside Advance Reservation Period");
        }
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        jFrame5.dispose();
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12));
        jFrame4.setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        username = jTextField2.getText();
        char [] tempP = jPasswordField2.getPassword();
        password="";
        for(int i=0;i<tempP.length;i++){
            password+=tempP[i];
        }
        
        String query = "select * from user where type=2 and username='"+username+"' and password='"+password+"'";

        
        try {
            // create a statement
            stmt = conn.createStatement();

            // execute query and return result as a ResultSet
            rs = stmt.executeQuery(query);
            
            // extract data from the ResultSet
            if(!rs.next()){
               jPasswordField2.setText("");
               JOptionPane.showMessageDialog(rootPane, "Wrong username or password!!!");
            }
            else{
                jLabel51.setText(username);
                userId=rs.getInt("id");
                jPasswordField2.setText("");
                //jLabel30.setVisible(true);
                jFrame2.dispose();
                jFrame4.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        jPasswordField2.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        char[] tempP  = jPasswordField3.getPassword();
        jPasswordField3.setText("");
        password="";
        for(int i=0;i<tempP.length;i++){
            password+=tempP[i];
        }
        
        if(!password.equals("admin")){
            JOptionPane.showMessageDialog(this, "Incorrect Password");
            return;
        }
        
        
        jFrame3.dispose();
        admin.getRootPane().setDefaultButton(jButton21);
        admin.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField1.setText("");
        jPasswordField1.setText("");
        //jLabel29.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTextField2.setText("");
        jPasswordField2.setText("");
        //jLabel30.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jPasswordField3.setText("");
        //jLabel31.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseExited
        jLabel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_jLabel17MouseExited

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
        jLabel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_jLabel22MouseExited

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 12));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 12));
    }//GEN-LAST:event_jLabel24MouseExited

    private void jPasswordField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField3MouseClicked
        //jLabel31.setText("");
    }//GEN-LAST:event_jPasswordField3MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        from_box.setSelectedIndex(0);
        to_box.setSelectedIndex(6);
        date.setDate(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel model=(DefaultTableModel)table.getModel();
        if(evt.getClickCount()==2){
            try {
                //System.out.println(""+table.getSelectedRow());
                //System.out.println(model.getValueAt(table.getSelectedRow(), 0));
                train_name=model.getValueAt(table.getSelectedRow(), 0).toString();
                //JOptionPane.showConfirmDialog(this, "Do you want to book a ticket in "+train_name);
                int jop=JOptionPane.showConfirmDialog(this, "Do you want to book a ticket in "+train_name+"?","", JOptionPane.YES_NO_OPTION);
                if(jop==JOptionPane.NO_OPTION){
                    return;
                }
                
                //System.out.println("Yes!!!");
                
                amount=Integer.parseInt(model.getValueAt(table.getSelectedRow(), 5).toString());
                jTextField7.setText(""+amount);
                
                rs=stmt.executeQuery("select * from user where username='"+username+"'");
                rs.next();
                jFrame6.dispose();
                
                jComboBox2.removeAllItems();
                if(rs.getString("type").equals("1")){
                    for(int i=1;i<=5;i++){
                        jComboBox2.addItem(i);
                    }
                }
                else{

                    for(int i=1;i<=(Integer.parseInt(model.getValueAt(table.getSelectedRow(), 6).toString()));i++){
                        jComboBox2.addItem(i);
                    }
                }
                
                bookFrame.setVisible(true);
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
        
    }//GEN-LAST:event_tableMouseClicked

    private void jFrame1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFrame1KeyTyped

    }//GEN-LAST:event_jFrame1KeyTyped

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        //jLabel29.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        //jLabel29.setText("");
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        //jLabel30.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jPasswordField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField2MouseClicked
        //jLabel30.setText("");
    }//GEN-LAST:event_jPasswordField2MouseClicked

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(jTextField9.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Name can not be empty!!!");
            return;
        }
        if(jTextField8.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Id is mandatory!!!");
            return;
        }
      
        String query = "select * from user where username='"+username+"'";
        try {
            // create a statement
            stmt = conn.createStatement();

            // execute query and return result as a ResultSet
            rs = stmt.executeQuery(query);
            
            // extract data from the ResultSet
            rs.next();
            
            int payment=Integer.parseInt(jTextField7.getText());
            int balance=Integer.parseInt(rs.getString("balance"));
            
            if(payment>balance){
                JOptionPane.showMessageDialog(this,"Insufficient Fund, You have Rs."+balance+" only!!!");
                return;
            }
            
            
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String strdoj = sdf.format(doj);
            String strdob = sdf.format(new Date());
            DefaultTableModel model=(DefaultTableModel)table.getModel();
            query="insert into ticket(`userid`, `name`, `id_no`, `no_of_persons`, `train_name`, `date_of_journey`, `from_station`, `dept_time`, `to_station`, `arr_time`, `fare`,`date_of_booking`, `status`) values("+rs.getString("id")+",'"+jTextField9.getText()+"','"+jTextField8.getText()+"',"+(jComboBox2.getSelectedIndex()+1)+",'"+train_name+"','"+strdoj+"','"+from+"','"+model.getValueAt(table.getSelectedRow(), 2).toString()+"','"+to+"','"+model.getValueAt(table.getSelectedRow(), 4).toString()+"',"+jTextField7.getText()+",'"+strdob+"',3)";
            
            //System.out.println(query);
            
            String query2="select * from route where name='"+train_name+"' and "+from+"<"+to;
            rs=stmt.executeQuery(query2);
            rs.next();
            
            String[] semiavl=rs.getString("available").split(";");
            
            String avl=semiavl[rs.getString("days").indexOf(day)/4];
            
            int min=Integer.parseInt(rs.getString("capacity"));
            String[] stravl=avl.split(",");
            for(int i=Integer.parseInt(rs.getString(from))-1;i<(Integer.parseInt(rs.getString(to))-1);i++){
                if(Integer.parseInt(stravl[i])<min){
                    min=Integer.parseInt(stravl[i]);
                }
            }
            
            //System.out.println("hello1");
            
            if(min<(jComboBox2.getSelectedIndex()+1)){
                
                if(min==0){
                    JOptionPane.showMessageDialog(this, "Sorry, No seats available!!!");
                    
                    bookFrame.dispose();
                    jFrame6.setVisible(true);
                    return;
                }
                
                jComboBox2.removeAllItems();
                for(int i=1;i<=min;i++){
                    jComboBox2.addItem(i);
                }
                
                
                JOptionPane.showMessageDialog(this, "Sorry, Availability updated!!!");
                return;
            }
            
            //System.out.println("hello2");
            
            int retval=stmt.executeUpdate(query);
            if(retval==0){
                JOptionPane.showMessageDialog(this, "Ticket could not be booked. Try again later!!!");
                return;
            }
            
            rs=stmt.executeQuery("select * from route where name='"+train_name+"' and "+from+"<"+to);
            rs.next();
            //System.out.println("hello3"+rs.getString(from));
            
            for(int i=Integer.parseInt(rs.getString(from))-1;i<(Integer.parseInt(rs.getString(to))-1);i++){
                stravl[i]=""+(Integer.parseInt(stravl[i])-(jComboBox2.getSelectedIndex()+1));
            }
            
            avl="";
            
            //System.out.println("hello4");
            
            int i;
            for(i=0;i<(stravl.length-1);i++){
                avl+=stravl[i]+",";
            }
            avl+=stravl[i];
            
            //System.out.println("avl:"+avl);
            
            semiavl[rs.getString("days").indexOf(day)/4]=avl;
            String avail="";
            for(i=0;i<(semiavl.length-1);i++){
                avail+=semiavl[i]+";";
            }
            avail+=semiavl[i];
            
            //System.out.println("avail:"+avail);
            
            query="update route set available='"+avail+"' where name='"+train_name+"' and "+from+"<"+to;
            retval=stmt.executeUpdate(query);
            if(retval==0){
                JOptionPane.showMessageDialog(this, "Ticket could not be booked. Try again later!!!");
                return;
            }
            
            retval=stmt.executeUpdate("Update user set balance="+(balance-Integer.parseInt(jTextField7.getText()))+" where username='"+username+"'");
            JOptionPane.showMessageDialog(this, "Thank you for using TravelAx. Ticket booked Successfully.");
            bookFrame.dispose();
            jFrame4.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        jTextField7.setText(""+amount*(jComboBox2.getSelectedIndex()+1));
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        Color c=Color.decode("#5D91F0");
        jFrame1.getContentPane().setBackground( c );
        jFrame2.getContentPane().setBackground( c);
        jFrame3.getContentPane().setBackground( c);
        jFrame4.getContentPane().setBackground( c );
        jFrame5.getContentPane().setBackground( c );
        jFrame6.getContentPane().setBackground( c );
        //jFrame7.getContentPane().setBackground( c);
        admin.getContentPane().setBackground( c );
        register.getContentPane().setBackground( c );
        history.getContentPane().setBackground( c );
        bookFrame.getContentPane().setBackground( c );
        this.getContentPane().setBackground(c);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        Color c=Color.decode("#1DDE9E");
        jFrame1.getContentPane().setBackground( c );
        jFrame2.getContentPane().setBackground( c);
        jFrame3.getContentPane().setBackground( c);
        jFrame4.getContentPane().setBackground( c );
        jFrame5.getContentPane().setBackground( c );
        jFrame6.getContentPane().setBackground( c );
        //jFrame7.getContentPane().setBackground( c);
        admin.getContentPane().setBackground( c );
        register.getContentPane().setBackground( c );
        history.getContentPane().setBackground( c );
        bookFrame.getContentPane().setBackground( c );
        this.getContentPane().setBackground(c);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        Color c=Color.decode("#E8357D");
        jFrame1.getContentPane().setBackground( c );
        jFrame2.getContentPane().setBackground( c);
        jFrame3.getContentPane().setBackground( c);
        jFrame4.getContentPane().setBackground( c );
        jFrame5.getContentPane().setBackground( c );
        jFrame6.getContentPane().setBackground( c );
        //jFrame7.getContentPane().setBackground( c);
        admin.getContentPane().setBackground( c );
        register.getContentPane().setBackground( c );
        history.getContentPane().setBackground( c );
        bookFrame.getContentPane().setBackground( c );
        this.getContentPane().setBackground(c);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        Color c=Color.decode("#D4BB92");
        jFrame1.getContentPane().setBackground( c );
        jFrame2.getContentPane().setBackground( c);
        jFrame3.getContentPane().setBackground( c);
        jFrame4.getContentPane().setBackground( c );
        jFrame5.getContentPane().setBackground( c );
        jFrame6.getContentPane().setBackground( c );
        //jFrame7.getContentPane().setBackground( c);
        admin.getContentPane().setBackground( c );
        register.getContentPane().setBackground( c );
        history.getContentPane().setBackground( c );
        bookFrame.getContentPane().setBackground( c );
        this.getContentPane().setBackground(c);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if(jTextField16.getText().isEmpty()||jTextField17.getText().isEmpty()||jTextField18.getText().isEmpty()||jPasswordField4.getPassword().length==0||jPasswordField5.getPassword().length==0) {
            JOptionPane.showMessageDialog(this, "Empty Fields!!");
            return;
        }
        char[] tempP = jPasswordField4.getPassword();
        char[] tempQ = jPasswordField5.getPassword();
        password = "";
        String pass = "";
        for(int i=0;i<tempP.length;i++)
        password+=tempP[i];
        for(int i=0;i<tempQ.length;i++)
        pass+=tempQ[i];
        if(!password.equals(pass)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!!!");
            jPasswordField4.setText("");
            jPasswordField5.setText("");
        }
        else {
            String query = "insert into user (`name`, `address`, `username`, `password`, `balance`, `type`, `commission`) VALUES ('"+jTextField16.getText()+"','"+jTextField17.getText()+"','"+jTextField18.getText()+"','"+password+"',0,"+userType+",0)";
            try {
                stmt = conn.createStatement();
                stmt.execute(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            jLabel7.setVisible(false);
            JOptionPane.showMessageDialog(this, "Account Created Successfully!!");
            register.dispose();
            frame.setVisible(true);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jPasswordField4.setText("");
        jPasswordField5.setText("");
        jLabel7.setVisible(false);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jLabel38MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseClicked
        register.dispose();
        //jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14));
        if(userType==1){
            jFrame1.setVisible(true);
        }
        else{
            jFrame2.setVisible(true);
        }
        jPasswordField4.setText("");
        jPasswordField5.setText("");
    }//GEN-LAST:event_jLabel38MouseClicked

    private void jLabel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseEntered
        //jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel38MouseEntered

    private void jLabel38MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseExited
        //jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 14));
    }//GEN-LAST:event_jLabel38MouseExited

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        bookFrame.dispose();
        jFrame6.setVisible(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        jFrame4.dispose();
        //System.out.println("userid="+userId);
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        try {
            stmt = conn.createStatement();
            rs2 = stmt.executeQuery("select * from ticket where userid="+userId);
            DefaultTableModel model=(DefaultTableModel)table1.getModel();
            model.setRowCount(0);
            while(rs2.next()) {
                String option = "Expired";
                if(rs2.getInt(14)==3)
                option = "Cancellable";
                else
                if(rs2.getInt(14)==2)
                option = "Cancelled";
                model.addRow(new Object[]{rs2.getInt(1),rs2.getString(3),rs2.getString(6),rs2.getString(8),rs2.getString(10),rs2.getInt(5),rs2.getString(7),rs2.getInt(12),rs2.getString(13),option});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        history.setVisible(true);
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        history.dispose();
        DefaultTableModel model=(DefaultTableModel)table1.getModel();
        for(int i=0;i<model.getRowCount();i++){
            model.removeRow(i);
        }
        jFrame4.setVisible(true);
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel42MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseEntered
        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel42MouseEntered

    private void jLabel42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseExited
        jLabel42.setFont(new java.awt.Font("Times New Roman", 1, 12));
    }//GEN-LAST:event_jLabel42MouseExited

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        DefaultTableModel model=(DefaultTableModel)table1.getModel();
        if(evt.getClickCount()==2){
            try {
                stmt2=conn.createStatement();
                rs2=stmt2.executeQuery("select * from ticket where userid="+userId+" and id="+model.getValueAt(table1.getSelectedRow(), 0));
                rs2.next();
                if(rs2.getInt("status")!=3)
                return;
                int jop=JOptionPane.showConfirmDialog(this, "Do you want to cancel this ticket in "+model.getValueAt(table1.getSelectedRow(), 2).toString()+"?","", JOptionPane.YES_NO_OPTION);
                if(jop==JOptionPane.NO_OPTION)
                return;
                stmt.executeUpdate("update ticket set status=2 where id="+model.getValueAt(table1.getSelectedRow(), 0));
                String query2="select * from route where name='"+model.getValueAt(table1.getSelectedRow(), 2).toString()+"'"+" and "+model.getValueAt(table1.getSelectedRow(), 3)+"<"+model.getValueAt(table1.getSelectedRow(), 4);
                rs=stmt.executeQuery(query2);
                rs.next();
                String[] semiavl=rs.getString("available").split(";");
                
                String dept_day=rs2.getString("dept_time").split(" ")[1];
                int dept_day_index=rs.getString("days").indexOf(dept_day)/4;
                String[] str_avail=rs.getString("available").split(";");
                String day_avail=str_avail[dept_day_index];
                String[] day_avail_split=day_avail.split(",");
                int start_index=Integer.parseInt(rs.getString(rs2.getString("from_station"))),end_index=Integer.parseInt(rs.getString(rs2.getString("to_station")));
                
                for(int i=start_index-1;i<(end_index-1);i++){
                    day_avail_split[i]=""+(Integer.parseInt(day_avail_split[i])+Integer.parseInt(rs2.getString("no_of_persons")));
                }
                
                day_avail="";
                
                int i;
                for(i=0;i<(day_avail_split.length-1);i++){
                    day_avail+=day_avail_split[i]+",";
                }
                day_avail+=day_avail_split[i];
                
                str_avail[dept_day_index]=day_avail;
                
                String avail="";
                for(i=0;i<(str_avail.length-1);i++){
                    avail+=str_avail[i]+";";
                }
                avail+=str_avail[i];
                
                //System.out.println(model.getValueAt(table1.getSelectedRow(), 2));
                
                String query="update route set available='"+avail+"' where name='"+model.getValueAt(table1.getSelectedRow(), 2)+"' and "+model.getValueAt(table1.getSelectedRow(), 3)+"<"+model.getValueAt(table1.getSelectedRow(), 4);
                //System.out.println(avail);
                //System.out.println(query);
                stmt3=conn.createStatement();
                if(stmt3.executeUpdate(query)==0){
                    System.out.println("Availability update failed!!!");
                    return;
                }
                
                String query3="select * from user where id="+userId;
                //System.out.println(query3);
                Statement stmt4=conn.createStatement();
                ResultSet rs3=stmt4.executeQuery(query3); 
                rs3.next();
                //System.out.println(""+(rs3.getInt("balance")+rs2.getInt("fare")));
                int refund=(rs3.getInt("balance")+rs2.getInt("fare"));
                String query4="update user set balance="+refund+" where id="+userId;
                //System.out.println(query4);
                stmt.executeUpdate(query4);
                
                JOptionPane.showMessageDialog(this,"Ticket cancelled successfully, Rs."+refund+" also got refunded.");
                
                try {
                    stmt = conn.createStatement();
                    rs2 = stmt.executeQuery("select * from ticket where userid="+userId);
                    model=(DefaultTableModel)table1.getModel();
                    model.setRowCount(0);
                    while(rs2.next()) {
                        String option = "Expired";
                        if(rs2.getInt(14)==3)
                        option = "Cancellable";
                        else
                        if(rs2.getInt(14)==2)
                        option = "Cancelled";
                        model.addRow(new Object[]{rs2.getInt(1),rs2.getString(3),rs2.getString(6),rs2.getString(8),rs2.getString(10),rs2.getInt(5),rs2.getString(7),rs2.getInt(12),rs2.getString(13),option});
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_table1MouseClicked

    private void jTextField19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyPressed
        admin.getRootPane().setDefaultButton(jButton11);
    }//GEN-LAST:event_jTextField19KeyPressed

    private void jTextField22KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyPressed
        admin.getRootPane().setDefaultButton(jButton11);
    }//GEN-LAST:event_jTextField22KeyPressed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if(!jTextField19.getText().equals(""))
        {
            String userid = jTextField19.getText();
            String query = "select * from user where id="+userid;
            try {
                // create a statement
                stmt = conn.createStatement();
                // execute query and return result as a ResultSet
                rs = stmt.executeQuery(query);
                // extract data from the ResultSet
                if(!rs.next()){
                    JOptionPane.showMessageDialog(this, "User doesn't exist!!");
                    return;
                }
                jTextField20.setText(rs.getString(2));
                jTextField21.setText(rs.getString(3));
                jTextField22.setText(rs.getString(4));
                jTextField23.setText(rs.getString(5));
                jTextField24.setText(rs.getFloat(6)+"");
                jTextField25.setText(rs.getInt(7)+"");
                jTextField26.setText(rs.getFloat(8)+"");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if(!jTextField22.getText().equals(""))
        {
            String user_name = jTextField22.getText();
            String query = "select * from user where username='"+user_name+"'";
            try {
                // create a statement
                stmt = conn.createStatement();

                // execute query and return result as a ResultSet
                rs = stmt.executeQuery(query);

                // extract data from the ResultSet
                if(!rs.next()){
                    JOptionPane.showMessageDialog(this, "User doesn't exist!!");
                    return;
                }
                jTextField19.setText(rs.getInt(1)+"");
                jTextField20.setText(rs.getString(2));
                jTextField21.setText(rs.getString(3));
                jTextField23.setText(rs.getString(5));
                jTextField24.setText(rs.getFloat(6)+"");
                jTextField25.setText(rs.getInt(7)+"");
                jTextField26.setText(rs.getFloat(8)+"");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Empty Fields!!");
            return;
        }
        jTextField20.setEnabled(true);
        jTextField21.setEnabled(true);
        jTextField23.setEnabled(true);
        jTextField24.setEnabled(true);
        jTextField25.setEnabled(true);
        jTextField26.setEnabled(true);
        jButton22.setEnabled(true);
        admin.getRootPane().setDefaultButton(jButton22);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if(jButton22.getText().equals("Submit"))
        {
            String query = "";
            try {
                if(!rs.getString(2).equals(jTextField20.getText()))
                query = "update user set name='"+jTextField20.getText()+"' where id="+jTextField19.getText();
                if(!rs.getString(3).equals(jTextField21.getText()))
                query = "update user set address='"+jTextField21.getText()+"' where id="+jTextField19.getText();
                if(!rs.getString(4).equals(jTextField22.getText()))
                query = "update user set username='"+jTextField22.getText()+"' where id="+jTextField19.getText();
                if(!rs.getString(5).equals(jTextField23.getText()))
                query = "update user set password='"+jTextField23.getText()+"' where id="+jTextField19.getText();
                if(!rs.getString(6).equals(jTextField24.getText()))
                query = "update user set balance="+jTextField24.getText()+" where id="+jTextField19.getText();
                if(!rs.getString(7).equals(jTextField25.getText()))
                query = "update user set type="+jTextField25.getText()+" where id="+jTextField19.getText();
                if(!rs.getString(8).equals(jTextField26.getText()))
                query = "update user set commission="+jTextField26.getText()+" where id="+jTextField19.getText();
                // create a statement
                stmt = conn.createStatement();
                // execute query and return result as a ResultSet
                stmt.executeUpdate(query);
                // extract data from the ResultSet
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else
        {
            String query = "delete from user where id="+jTextField19.getText();
            try {
                // create a statement
                stmt = conn.createStatement();
                // execute query and return result as a ResultSet
                stmt.execute(query);
                // extract data from the ResultSet
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        JOptionPane.showMessageDialog(this, "Operation Successful!");
        jPanel1.setVisible(false);
        admin.getRootPane().setDefaultButton(jButton21);
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jTextField26.setText("");
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jLabel70MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseClicked
        admin.dispose();
        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 12));
        frame.setVisible(true);
    }//GEN-LAST:event_jLabel70MouseClicked

    private void jLabel70MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseEntered
        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 14));
    }//GEN-LAST:event_jLabel70MouseEntered

    private void jLabel70MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel70MouseExited
        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 12));
    }//GEN-LAST:event_jLabel70MouseExited

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jPanel1.setVisible(true);
        jTextField20.setEnabled(false);
        jTextField21.setEnabled(false);
        jTextField23.setEnabled(false);
        jTextField24.setEnabled(false);
        jTextField25.setEnabled(false);
        jTextField26.setEnabled(false);
        jButton22.setEnabled(false);
        jButton22.setText("Submit");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jPanel1.setVisible(true);
        jTextField20.setEnabled(false);
        jTextField21.setEnabled(false);
        jTextField23.setEnabled(false);
        jTextField24.setEnabled(false);
        jTextField25.setEnabled(false);
        jTextField26.setEnabled(false);
        jButton22.setEnabled(false);
        jButton22.setText("Delete");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
        } catch (Exception e) {
            System.out.println("Error in connection");
            e.printStackTrace();
        }

        System.out.println("conn=" + conn);

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    frame = new Home();
                } catch (IOException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                frame.setVisible(true);
            }
        });
        
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame admin;
    private javax.swing.JFrame bookFrame;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JComboBox from_box;
    private javax.swing.JFrame history;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JFrame jFrame6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField jPasswordField5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JFrame register;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    private javax.swing.JComboBox to_box;
    // End of variables declaration//GEN-END:variables
}
