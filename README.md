## This is the reference connector for EWP

This reference connector demonstrates how a connector can be implemented. It has a built-in database to save persistent information. 

## Requirements

* Java 8
* Java EE container, such as Tom EE or Glassfish

## Development environment
In addition to the requirements for the EWP host, the following are also required

* Any Java IDE compatible with Java 8 and Maven
* Node.js
* Maven 3.3.9
* Git

## Build and run a Docker image. 
The Docker API and Maven plugins are not in sync anymore, so you'll have to do it by hand. 

```
$ cp target/ewp-reference-connector-1.0-SNAPSHOT.war docker
$ docker build docker --no-cache -t ewp
```
Followed by
```
docker run -p 127.0.0.1:8080:8080 ewp
```
Locate your browser to
```
http://localhost:8080/ewp/
```
## Installation instructions for a EWP Host

* Download TomEE from http://www.apache.org/dyn/closer.cgi/tomee/tomee-7.0.4/apache-tomee-7.0.4-plus.zip
* Configure system.properties and modify this property
```
tomee.serialization.class.blacklist = -
```
* Copy .war file to `webapps`
* Start `bin/startup.bat`
* Go to http://localhost:8080/connector-1.0-SNAPSHOT/

## Installation instructions for a local development environment

If you want to fork the code, or just start to hack on your own connector, and want to use this as a reference, follow these steps. 

Go to the source tree. 
```
$ mvn clean install
```
Lots of output and should be followed by

```
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 03:33 min
[INFO] Finished at: 2016-09-08T09:21:13+02:00
[INFO] Final Memory: 31M/356M
[INFO] ------------------------------------------------------------------------
```
