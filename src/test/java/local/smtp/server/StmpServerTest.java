package local.smtp.server;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;

/**
 * StmpServerのテストです。
 */
public class StmpServerTest {

  /**
   * StmpServerにメールを送信します。
   *
   * @throws Exception メールの送信に失敗した場合
   */
  @Test
  public void test_sendMail() throws Exception {

    Properties props = new Properties();
    props.put("mail.smtp.host", "localhost");
    props.put("mail.smtp.port", "2500");
    props.put("mail.smtp.starttls.enable", false);
    Session session = Session.getDefaultInstance(props);
    MimeMessage msg = new MimeMessage(session);
    msg.addFrom(new Address[] { new InternetAddress("from@mail.com") });
    msg.addRecipient(RecipientType.TO, new InternetAddress("to@mail.com"));
    msg.setSubject("title");
    msg.setText("aaaaa");
    msg.setSentDate(new Date());
    Transport.send(msg);
  }
}
