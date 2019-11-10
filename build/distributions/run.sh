#!/bin/bash
java -Dlogback.configurationFile=./conf/logback.xml -jar ./lib/local-smtp-server.jar ./conf/conf.properties