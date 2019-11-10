package local.smtp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * STMPサーバのスターターです。
 */
public class StmpServerStarter {

  /**
   * mainメソッドです。
   * コマンドライン引数には{@code config.properties}のパスを設定してください。
   *
   * @param args コマンドライン引数
   */
  public static void main(String[] args) {

    Path configPath = Path.of(args[0]);
    Properties config = new Properties();
    try (BufferedReader r = Files.newBufferedReader(configPath, Charset.forName("utf-8"))) {
      config.load(r);
      new StmpServer().start(config);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
