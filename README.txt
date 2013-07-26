Welcome to the Apache Camel on WildFly / JBoss EAP 6.1 / Tomcat 7 / JBoss EWS Examples!
======================================================================================

To run examples go through this steps:

Download and start WildFly / JBoss EAP 6.1 / Tomcat 7 / JBoss EWS  distribution.

To automatically run all examples on WildFly or JBoss EAP 6.1 run:

    "mvn -Pdeploy-jboss,it-tests clean install"

To automatically run all examples on Tomcat 7 or JBoss EWS run:

    "mvn -Pdeploy-tomcat,it-tests clean install"

This will sequentially deploy each example to server, run test and undeploy
application.


Tomcat 7 configuration:
-----------------------

Create user "tomcat" with password "tomcat" which will have role "manager-script".

    <role rolename="manager-script"/>
    <user username="tomcat" password="tomcat" roles="tomcat,manager-script"/


------------------------

This directory contains the various examples for working with Apache
Camel. The examples can be run using Maven. When using the Maven
command, Maven will attempt to download the required dependencies from a
central repository to your local repository.

Before you start we recommend you install a recent distribution of
Maven, which we use to run our examples
  http://maven.apache.org/

Please help us make Apache Camel better - we appreciate any feedback you
may have.

Enjoy!

------------------------
The Camel riders!
