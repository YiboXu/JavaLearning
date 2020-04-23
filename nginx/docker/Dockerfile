FROM nginx
WORKDIR /usr
RUN mkdir /usr/local/java
ADD jdk-8u241-linux-x64.tar.gz /usr/local/java
ENV JAVA_HOME /usr/local/java/jdk1.8.0_241
ENV JRE_HOME $JAVA_HOME/jre
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib:$CLASSPATH
ENV PATH $JAVA_HOME/bin:$PATH
ADD tomcat-jmeter-test-1.0-SNAPSHOT.jar /