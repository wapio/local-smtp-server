package local.smtp.server;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.subethamail.smtp.TooMuchDataException;
import org.subethamail.smtp.helper.SimpleMessageListener;
import org.subethamail.smtp.helper.SimpleMessageListenerAdapter;
import org.subethamail.smtp.server.SMTPServer;

/**
 * STMPサーバです。
 */
public class StmpServer {

  /** ロガー */
  private Logger logger = LoggerFactory.getLogger(StmpServerStarter.class);

  /**
   * STMPサーバを起動します。
   *
   * @param config 設定情報
   */
  public void start(Properties config) {

    SimpleMessageListener listener = getMessageListener();
    SMTPServer server = new SMTPServer(new SimpleMessageListenerAdapter(listener));
    server.setHostName(config.getProperty("smtp.server.host", "localhost"));
    server.setPort(Integer.parseInt(config.getProperty("smtp.server.port", "2500")));
    server.start();
  }

  /**
   * メッセージリスナーを返します。
   *
   * @return {@code SimpleMessageListener}
   */
  private SimpleMessageListener getMessageListener() {
    return new SimpleMessageListener() {

      @Override
      public boolean accept(String from, String recipient) {
        return true;
      }

      @Override
      public void deliver(String from, String recipient, InputStream data) throws TooMuchDataException, IOException {
        logger.info("all data={}", new String(data.readAllBytes(), "utf-8"));
      }
    };
  }
}
