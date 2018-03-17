package br.com.jsa;


import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EnviarEmail {
	
	private String smtp = "smtp.gmail.com";
	private String emailAuthenticator = "jeffersonemails08@gmail.com";
	private String senhaAuthenticator = "101903@j";
	private int porta = 465;
	private String enviarPara;
	private String senha;
	private String mensagem;
	
	
	public EnviarEmail(String enviarPara, String senha) {
		this.enviarPara = enviarPara;
		this.senha = senha;
	}

	public boolean enviarEmailDePrimeiroAcesso(){
		mensagem = "Bem vindo!!! \n\n"
				+ "A sua senha de primeiro acesso é:\n"
				+ "E-mail: " + enviarPara
				+ "\n"
				+ "Senha: "+senha;
		
		Email email = new SimpleEmail();
		email.setHostName(smtp);
		email.setSmtpPort(porta);
		email.setAuthenticator(new DefaultAuthenticator(emailAuthenticator, senhaAuthenticator));
		email.setSSLOnConnect(true);
		try {
			email.setFrom(emailAuthenticator);
			email.setSubject("TestMail");
			email.setMsg(mensagem);
			email.addTo(enviarPara);
			email.send();
			return true;
		} catch (EmailException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
