package com.aventurasalvaje.pedidos;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class envioPedido {
	
	public String envio(String correo, String contrasenia) throws Exception{
    
    // Propiedades de la conexión
    Properties props = new Properties();
    props.setProperty("mail.smtp.host", "smtp.gmail.com");
    props.setProperty("mail.smtp.starttls.enable", "true");
    props.setProperty("mail.smtp.port", "587");
    props.setProperty("mail.smtp.user", "aventurasalvajepedidos@gmail.com");
    props.setProperty("mail.smtp.auth", "true");

    // Preparamos la sesion
    
    Session session = Session.getDefaultInstance(props);

    // Construimos el mensaje
    
    MimeMessage message = new MimeMessage(session);
    message.setFrom(new InternetAddress("aventurasalvajepedidos@gmail.com"));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
    message.setSubject("Recuperación de Contraseña");
    message.setText(
        "Hola,\n\nComo has solicitado,\n\nTu contraseña es: "+contrasenia+"\n\nSaludos,\n International Business Software");

    // Lo enviamos
    Transport t = session.getTransport("smtps");
    t.connect("smtp.gmail.com","aventurasalvajepedidos@gmail.com", "correoprueba");
    t.sendMessage(message, message.getAllRecipients());

    // Cierre. 
    t.close();

return "";
	}
}//fin envio
