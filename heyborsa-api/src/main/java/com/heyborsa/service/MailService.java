package com.heyborsa.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private MailSender mailSender;
	JavaMailSenderImpl impl;

	
	public void RegisterMail(String name,String lastname,String key,String email) throws UnsupportedEncodingException
	{
		 MimeMessage mail = javaMailSender.createMimeMessage();
	        String body = "<!DOCTYPE html>\r\n" + 
	        		"<html>\r\n" + 
	        		"<head>\r\n" + 
	        		"<title></title>\r\n" + 
	        		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n" + 
	        		"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	        		"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
	        		"<style type=\"text/css\">\r\n" + 
	        		"    @import url('https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i');\r\n" + 
	        		"    body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\r\n" + 
	        		"    table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\r\n" + 
	        		"    img { -ms-interpolation-mode: bicubic; }\r\n" + 
	        		"    img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }\r\n" + 
	        		"    table { border-collapse: collapse !important; }\r\n" + 
	        		"    body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }\r\n" + 
	        		"    a[x-apple-data-detectors] {\r\n" + 
	        		"        color: inherit !important;\r\n" + 
	        		"        text-decoration: none !important;\r\n" + 
	        		"        font-size: inherit !important;\r\n" + 
	        		"        font-family: inherit !important;\r\n" + 
	        		"        font-weight: inherit !important;\r\n" + 
	        		"        line-height: inherit !important;\r\n" + 
	        		"    }\r\n" + 
	        		"    @media screen and (max-width:600px){\r\n" + 
	        		"        h1 {\r\n" + 
	        		"            font-size: 32px !important;\r\n" + 
	        		"            line-height: 32px !important;\r\n" + 
	        		"        }\r\n" + 
	        		"    }\r\n" + 
	        		"    div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\r\n" + 
	        		"</style>\r\n" + 
	        		"</head>\r\n" + 
	        		"<body style=\"background-color: #f3f5f7; margin: 0 !important; padding: 0 !important;\">\r\n" + 
	        		"<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: 'Poppins', sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\r\n" + 
	        		"    HEYBORSAYA HOSGELDINIZ !\r\n" + 
	        		"</div>\r\n" + 
	        		"<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"background:url(../../../images/preview/bg.jpg);\">\r\n" + 
	        		"    <tr>\r\n" + 
	        		"        <td align=\"center\">\r\n" + 
	        		"            \r\n" + 
	        		"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
	        		"                <tr>\r\n" + 
	        		"                    <td align=\"center\" valign=\"top\" style=\"padding: 40px 10px 40px 10px;\">\r\n" + 
	        		"                        <a href=\"#\" target=\"_blank\" style=\"text-decoration: none;\">\r\n" + 
	        		"							<span style=\"display: block; font-family: 'Poppins', sans-serif; color: #ffffff; font-size: 36px;\" border=\"0\"><b>HEY</b>BORSA</span>\r\n" + 
	        		"                        </a>\r\n" + 
	        		"                    </td>\r\n" + 
	        		"                </tr>\r\n" + 
	        		"            </table>\r\n" + 
	        		"            \r\n" + 
	        		"        </td>\r\n" + 
	        		"    </tr>\r\n" + 
	        		"    <tr>\r\n" + 
	        		"        <td align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n" + 
	        		"            \r\n" + 
	        		"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
	        		"                <tr>\r\n" + 
	        		"                    <td bgcolor=\"#ffffff\" align=\"center\" valign=\"top\" style=\"padding: 40px 20px 20px 20px; border-radius: 4px 4px 0px 0px; color: #111111; font-family: 'Poppins', sans-serif; font-size: 48px; font-weight: 400; letter-spacing: 2px; line-height: 48px;\">\r\n" + 
	        		"                      <h1 style=\"font-size: 42px; font-weight: 400; margin: 0;\">Merhaba ! "+ name +" " + lastname+" </h1>\r\n" + 
	        		"                    </td>\r\n" + 
	        		"                </tr>\r\n" + 
	        		"            </table>\r\n" + 
	        		"        </td>\r\n" + 
	        		"    </tr>\r\n" + 
	        		"   \r\n" + 
	        		"    <tr>\r\n" + 
	        		"        <td align=\"center\" style=\"padding: 0px 10px 0px 10px;\">\r\n" + 
	        		"            <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width: 600px;\">\r\n" + 
	        		"              <tr>\r\n" + 
	        		"                <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 20px 30px 40px 30px; color: #666666; font-family: 'Poppins', sans-serif; font-size: 16px; font-weight: 400; line-height: 25px;\">\r\n" + 
	        		"                  <p style=\"margin: 0;\">Aramiza katilmak için asagida bulunan linke tiklamalisin</p>\r\n" + 
	        		"                </td>\r\n" + 
	        		"              </tr>\r\n" + 
	        		"              <tr>\r\n" + 
	        		"                <td bgcolor=\"#ffffff\" align=\"left\">\r\n" + 
	        		"                  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
	        		"                    <tr>\r\n" + 
	        		"                      <td bgcolor=\"#ffffff\" align=\"center\" style=\"padding: 20px 30px 60px 30px;\">\r\n" + 
	        		"                        <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
	        		"                          <tr>\r\n" + 
	        		"                              <td align=\"center\" style=\"border-radius: 3px;\" bgcolor=\"#398bf7\"><a href=\"http://localhost:4200/verifyemail/"+ key +" \" target=\"_blank\" style=\"font-size: 18px; font-family: Helvetica, Arial, sans-serif; color: #ffffff; text-decoration: none; color: #ffffff; text-decoration: none; padding: 12px 50px; border-radius: 2px; border: 1px solid #398bf7; display: inline-block;\">Hesabini Aktiflestir</a></td>\r\n" + 
	        		"                          </tr>\r\n" + 
	        		"                        </table>\r\n" + 
	        		"                      </td>\r\n" + 
	        		"                    </tr>\r\n" + 
	        		"                  </table>\r\n" + 
	        		"                </td>\r\n" + 
	        		"              </tr>      \r\n" + 
	        		"              <tr>\r\n" + 
	        		"                <td bgcolor=\"#ffffff\" align=\"left\" style=\"padding: 0px 30px 40px 30px; border-radius: 0px 0px 0px 0px; color: #666666; font-family: 'Poppins', sans-serif; font-size: 14px; font-weight: 400; line-height: 25px;\">\r\n" + 
	        		"                  <p style=\"margin: 0;\">Saygilar,<br>HEYBORSA</p>\r\n" + 
	        		"                </td>\r\n" + 
	        		"              </tr>\r\n" + 
	        		"            </table>\r\n" + 
	        		"            \r\n" + 
	        		"        </td>\r\n" + 
	        		"    </tr>\r\n" + 
	        		"</table>\r\n" + 
	        		"\r\n" + 
	        		"</body>\r\n" + 
	        		"</html>\r\n" + 
	        		"";
	        MimeMessageHelper helper;
			try {
				helper = new MimeMessageHelper(mail, true);
				helper.setFrom("heyborsa@gmail.com");
		        helper.setTo(email);
		        helper.setSubject("Üyelik");
		        helper.setText(body, true);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        javaMailSender.send(mail);
	}
}
