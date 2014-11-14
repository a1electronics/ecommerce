# A1 Electionics Ecommerce Sample Application

This repository contains code and support files for the book "Learning AWS".

## Running ecommerce application locally

	git clone https://github.com/a1electronics/ecommerce
	mvn tomcat7:run 
    
    The URL to launch the application is http://localhost:8888/a1ecommerce

## Setting up the build enviornment in Spring Tool Suite / Eclipse

###Prerequisites:
1)	Spring Tool Suite (STS) or Eclipse.Download STS (http://spring.io/tools/sts) or Eclipse (https://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/lunasr1). We recommend using STS as it has spring tooling built in. 

2)	Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html). 

3)	git command line tool (https://help.github.com/articles/set-up-git).

4)	Eclipse with the m2e plugin. m2e is installed by default when using the STS.


###Steps
1) From command line first checkout from the github

	git clone https://github.com/a1electronics/ecommerce

to run the application from command line 
	
	mvn tomcat7:run 
    
The URL to launch the application is http://localhost:8888/a1ecommerce
 
2) To build it from STS you will need to import the project. Open

File -> Import -> Maven -> Existing Maven project