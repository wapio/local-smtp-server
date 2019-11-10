# local-smtp-server
テスト用のSMTPサーバを提供します。

### サーバ起動方法
* 任意のフォルダで以下のコマンドを使用してzipファイルを展開してください。
  
  ```
    unzip local-smtp-server.zip
  ```

* 展開後のフォルダ構成は以下のようになります。

  ```
    root
     ├ conf
     │ └ conf.properties
     │ └ logback.xml
     ├ lib
     │  └ local-smtp-server.jar
     │  └ ......
     └ run.sh

  ```

* `conf/conf.properties`でサーバ定義を設定します。
  設定しない場合デフォルト値が使用されます。
  
  ```
    smtp.server.host=localhost
    smtp.server.port=2500
  ```

  | # | キー | 説明 | デフォルト |
  | - | -- | -- | -- |
  | 1 | `smtp.server.host` | SMTPサーバのホスト名 | `localhost` |
  | 2 | `smtp.server.port` | SMTPサーバのポート番号 | `2500` |

* `conf/logback.xml`でログの出力定義を設定できます。

* 以下のコマンドでshellスクリプトを実行してSMTPサーバを起動します。

  ```
    sh ./run.sh
  ```

* 起動に成功した場合以下のようなログが出力されます。

  ```
    o.s.smtp.server.ServerThread - SMTP server *:2500 started
  ```

* SMTPサーバにメールを送信すると、メールの内容がログに出力されます。

  出力例

  ```
    all data=Received: from 192.168.1.9 (localhost [127.0.0.1])
        by localhost
        with SMTP (SubEthaSMTP 3.1.7) id K2T2PCJC
        for to@mail.com;
        Sun, 10 Nov 2019 23:08:27 +0900 (JST)
    Date: Sun, 10 Nov 2019 23:08:27 +0900 (JST)
    From: from@mail.com
    To: to@mail.com
    Message-ID: <341878976.0.1573394907493@[192.168.1.9]>
    Subject: title
    MIME-Version: 1.0
    Content-Type: text/plain; charset=us-ascii
    Content-Transfer-Encoding: 7bit
    
    aaaaa <-メール本文
 
  ```