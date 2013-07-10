Welcome to the Apache Camel on WildFly / JBoss EAP 6.1 Examples!
================================================================

To run examples go through this steps:

1. Download and start WildFly / JBoss EAP 6.1 distribution.
2. Run "mvn clean install" in the examples root directory.

This will sequentially deploy each example to server, run test and undeploy
application.

To only package example run "mvn clean package" in example directory.
To deploy packaged example run "mvn jboss-as:deploy" in example directory.
To undeploy example run "mvn jboss-as:undeploy" in example directory.

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
