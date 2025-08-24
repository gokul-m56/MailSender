import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;


class sendMailGui{

    static void sendingEmail(String fEmail, String TEmail, String topic, String msg){
        // backend implement--
        // Getting system properties
        
        Properties properties=System.getProperties();
        
        // for setup mail server
        properties.put("mail.smtp.host", "smtp.gmail.com"); // gmail
        // it send from sender to recevier mail server 
        properties.put("mail.smtp.port",587);
        // only auth. user can send or recevie mail
        properties.put("mail.smtp.auth", "true");
        // for security
        properties.put("mail.smtp.starttls.enable","true");
        // SSL -> TLSv1.2
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); 
        
        // Username/Password
        String userName="gokulmohanraj.com@gmail.com";
        String password="udui vbcs ucbd mioy";

        Session session=Session.getInstance(properties, 
            new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(userName, password);

            }
        });

       
        try {
             // message--
            MimeMessage message=new MimeMessage(session);
       
            // fromEmail -- sender email
            message.setFrom(new InternetAddress(fEmail));
            
            // toEmail -- Receiver/Recipient email
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(TEmail));

            // Subject/topic -- Title
            message.setSubject(topic);

            // Description/msg --
            message.setText(msg);

            // transport
            Transport.send(message);
            JOptionPane.showMessageDialog(null,  "Email sent Successfully.", "Done !",0);

        
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    

    public static void main(String[] args) {
     
        JFrame jFrame=new JFrame("Gmail Desktop App"); // Window
        jFrame.setSize(600, 380);
        jFrame.setResizable(false);
        
        // icon- 
        ImageIcon logoImg=new ImageIcon("icon.png");
        jFrame.setIconImage(logoImg.getImage());

        // panel 1--
        JPanel jPanel=new JPanel(); // Container/Area
        jPanel.setBounds(20, 40, 540, 265);
        jPanel.setBackground(new Color(1, 43, 49, 190));
        jPanel.setLayout(null);
        jFrame.add(jPanel);
         
        
        // label/text --
        JLabel jLabel=new JLabel("Send GK Email !");
        jLabel.setBounds(215, 10, 180, 50);
        jLabel.setFont(new Font("verdana",Font.BOLD,18));
        jLabel.setForeground(Color.white);
        jPanel.add(jLabel);

        // separator--
        JSeparator jSeparator=new JSeparator();
        jSeparator.setBounds(205, 50, 145, 35);
        jSeparator.setBackground(Color.white);
        jPanel.add(jSeparator);
         
        // background image--
        JLabel backgroundImg;
        ImageIcon bgImage=new ImageIcon("bgImg.jpg");//load image
        backgroundImg=new JLabel("",bgImage,JLabel.CENTER);
        backgroundImg.setBounds(0, 0, 600, 380);
        jFrame.add(backgroundImg);

        // TextArea--
        JTextArea fromTextArea=new JTextArea("From:");
        fromTextArea.setBounds(20, 80,220, 33);
        fromTextArea.setForeground(Color.white);
        fromTextArea.setBackground(new Color(31, 43, 49, 250));
        fromTextArea.setFont(new Font("",Font.PLAIN,14));
        fromTextArea.setSelectedTextColor(Color.blue);
        fromTextArea.setSelectionColor(Color.cyan);
        fromTextArea.setCaretColor(Color.white);
        fromTextArea.setCaretPosition(5);
        jPanel.add(fromTextArea);
        
        // separator--
        JSeparator fromjSeparator=new JSeparator();
        fromjSeparator.setBounds(50, 114, 190, 35);
        fromjSeparator.setBackground(Color.white);
        jPanel.add(fromjSeparator);
        
        // TextArea--
        JTextArea toTextArea=new JTextArea("To:");
        toTextArea.setBounds(20, 130,220, 33);
        toTextArea.setForeground(Color.white);
        toTextArea.setBackground(new Color(31, 43, 49, 250));
        toTextArea.setFont(new Font("",Font.PLAIN,14));
        toTextArea.setSelectedTextColor(Color.blue);
        toTextArea.setSelectionColor(Color.cyan);
        toTextArea.setCaretColor(Color.white);
        toTextArea.setCaretPosition(3);
        jPanel.add(toTextArea);
         
        // Jseparator--
        JSeparator tojSeparator=new JSeparator();
        tojSeparator.setBounds(50, 164, 190, 35);
        tojSeparator.setBackground(Color.white);
        jPanel.add(tojSeparator);

        // TextArea--
        JTextArea topicTextArea=new JTextArea("Subject:");
        topicTextArea.setBounds(20, 180,220, 33);
        topicTextArea.setForeground(Color.white);
        topicTextArea.setBackground(new Color(31, 43, 49, 250));
        topicTextArea.setFont(new Font("",Font.PLAIN,14));
        topicTextArea.setSelectedTextColor(Color.blue);
        topicTextArea.setSelectionColor(Color.cyan);
        topicTextArea.setCaretColor(Color.white);
        topicTextArea.setCaretPosition(6);
        jPanel.add(topicTextArea);
          
        // separator--
        JSeparator topicjSeparator=new JSeparator();
        topicjSeparator.setBounds(50, 214, 190, 35);
        topicjSeparator.setBackground(Color.white);
        jPanel.add(topicjSeparator);

        // TextArea--
        JTextArea messageTextArea=new JTextArea("Message:");
        messageTextArea.setBounds(260, 80,220, 135);
        messageTextArea.setForeground(Color.white);
        messageTextArea.setBackground(new Color(31, 43, 49, 250));
        messageTextArea.setFont(new Font("",Font.PLAIN,14));
        messageTextArea.setSelectedTextColor(Color.blue);
        messageTextArea.setSelectionColor(Color.cyan);
        messageTextArea.setCaretColor(Color.white);
        messageTextArea.setCaretPosition(8);
        jPanel.add(messageTextArea);
          
        // separator--
        JSeparator messagejSeparator=new JSeparator();
        messagejSeparator.setBounds(260, 215, 220, 35);
        messagejSeparator.setBackground(Color.white);
        jPanel.add(messagejSeparator);

        // Button--
        JButton button=new JButton("SEND");
        button.setBounds(260, 223, 220, 30);
        button.setBackground(new Color(0, 212, 255, 255));
        button.setForeground(new Color(231, 239, 246, 250));
        button.setFont(new Font("verdana",Font.BOLD,17));
        jPanel.add(button);

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                // get text from TextArea--
                String fromText=fromTextArea.getText(); // From: 5
                String toText=toTextArea.getText(); // To: 3
                String topicText=topicTextArea.getText(); // Topic: 6
                String messageText=messageTextArea.getText(); // message: 8

                if(fromText.equals("From:") || toText.equals("To:") ||
                    topicText.equals("Topic:") || messageText.equals("message:")){
                        
                        JOptionPane.showMessageDialog(jFrame,  "Fill all fields", "note",0);
                }
                else{
                    String fromEmail=fromText.substring(5, fromText.length());
                    String toEmail=toText.substring(3, toText.length());
                    String topicTxt=topicText.substring(6, topicText.length());
                    String messageTxt=messageText.substring(8, messageText.length());

                    sendingEmail(fromEmail,toEmail,topicTxt,messageTxt);
                   
                    
                
                }


            }
                
            
        });
        
        
        // JOptionPane.showMessageDialog(jFrame,  "You enter email: "+fromTextEmail, "note",0);
        // JOptionPane.showMessageDialog(jFrame,  "You enter email: "+toTextEmail, "note",0);
        // JOptionPane.showMessageDialog(jFrame,  "You enter email: "+topicText, "note",0);
        // JOptionPane.showMessageDialog(jFrame,  "You enter email: "+messageText, "note",0);
            
    
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null); // no layout 
        jFrame.setVisible(true);

    }
}