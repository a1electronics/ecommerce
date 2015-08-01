# A1 Electronics Ecommerce Sample Application

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

## CloudFormation script
You can execute the cloudformation script a1ecommerceaws.json from command line if the AWS cmdline is installed in your machine.
please read Scripting auto scaling in chapter 4 to install the AWS command line tools.

To create the  CloudFormation stack fire the follwoing on the command line

aws cloudformation create-stack --stack-name a1ecommerce --template-body
file://a1ecommerceaws.json --region=us-east-1

The script might fail due to an unavailable availability zone . 

To fix it first query AWS for the available  availability zones 

aws ec2 describe-availability-zones --region=us-east-1

and then replace the value of "AZ" on line 264,268 with any AZ except us-east-1a

