package com.aventurasalvaje.pedidos;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

	

	public class prueba
	{
	    String  d_email = "aventurasalvajepedidos@gmail.com",
	     d_password = "aventuraanimal",
	     d_host = "smtp.gmail.com",
	     //d_port = "587",
	     d_port  = "465",
	     //m_to = "sample@yahoo.com",
	     m_subject = "Pedido de Animales",
	     m_text = "";

	    public prueba(String strEmailAddress,String mensaje)
	    {
	    	m_text=mensaje;


	        Properties props = new Properties();
	        props.put("mail.smtp.user", d_email);
	        props.put("mail.smtp.host", d_host);
	        props.put("mail.smtp.port", d_port);
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.auth", "true");
	        //props.put("mail.smtp.debug", "true");
	        props.put("mail.smtp.socketFactory.port", d_port);
	        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.socketFactory.fallback", "false");

	        SecurityManager security = System.getSecurityManager();

	        try
	        {
	            Authenticator auth = new SMTPAuthenticator();
	            Session session = Session.getInstance(props, auth);
	            //session.setDebug(true);

	            MimeMessage msg = new MimeMessage(session);
	            msg.setText(m_text);
	            msg.setSubject(m_subject);
	            msg.setFrom(new InternetAddress(d_email));
	            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(strEmailAddress));
	            Transport.send(msg);
	        }
	        catch (Exception mex)
	        {
	            mex.printStackTrace();
	        } 
	    }

		public class SMTPAuthenticator extends javax.mail.Authenticator
	    {
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	            return new PasswordAuthentication(d_email, d_password);
	        }
	    }
	}

