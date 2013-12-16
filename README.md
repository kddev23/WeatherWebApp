Welcome To Weather Information Service
Please follow below instructions to run this web application

Prerequisite
1) Download & Install Apache Maven 3.1.1
	http://maven.apache.org/download.cgi
	Please run "mvn -version" from command prompt to check if maven installation done successfully.
2) Download & Install JDK 1.7 or JRE7
   Set JAVA_HOME
3) Your system should have internet access to download maven dependencies & to connect web API to get current weather information.
4) Download & Install Tomcat 7 if want to deploy in standalone tomcat. Also Set TOMCAT_HOME

******************************************************************************************
Installation & Deployment (using tomcat maven plugin to start & deploy in embedded tomcat)

1) Download WeatherWebApp folder from Github

2) Go to /WeatherWebApp using command prompt

3) run "mvn install tomcat7:run" (Compile, Build, Start Tomcat, Deploy war file)

5) Open Browser and type "http://localhost:9090/WeatherWebApp/"


******************************************************************************************
Installation & Deployment (using tomcat maven plugin to start & deploy in standalone tomcat)

1) Download WeatherWebApp folder from Github

2) Go to /WeatherWebApp using command prompt

3) Open pom.xml, Edit/Add following
	\<plugin>  
		\<groupId>org.apache.tomcat.maven\</groupId>  
		\<artifactId>tomcat7-maven-plugin\</artifactId>  
		\<version>2.1\</version>  
		\<configuration>  
			\<url>http://localhost:8080/manager/text\</url>  
			\<server>my-tomcat\</server>  
			\<path>/WeatherWebApp\</path> 
		\</configuration>  
	\</plugin>
	
4) Open Maven Setting.xml, Add
	\<server>
		\<id>my-tomcat\</id>
		\<username>manager\</username>
		\<password>manager\</password>
	\</server>
	
5) Add to TOMCAT_HOME\conf\tomcat-users.xml
	\<role rolename="manager-gui"/>
	\<role rolename="manager-script"/>
	\<user username="managerGui" password="manager" roles="manager-gui"/>
	\<user username="manager" password="manager" roles="manager-script"/>
	
6) run "mvn install tomcat7:deploy" (Compile, Build, Start Tomcat, Deploy war file)

7) Redeploy Application run "tomcat7:redeploy"


