# rcp.demo
A RCP Demo Project as example as well as for communication of issues like Java Version, OpenJFX, OSGI and topics like this

[![Build Status](https://travis-ci.com/StegmannSystems/rcp.demo.svg?branch=master)](https://travis-ci.com/StegmannSystems/rcp.demo)
[![codebeat badge](https://codebeat.co/badges/cb7ab153-c08f-4b08-8ace-417055673ba1)](https://codebeat.co/projects/github-com-stegmannsystems-rcp-demo-master)
[![CodeFactor](https://www.codefactor.io/repository/github/stegmannsystems/rcp.demo/badge/master)](https://www.codefactor.io/repository/github/stegmannsystems/rcp.demo/overview/master)

## Quickstart

Running on Windows and Linux environment (at least):

```
# build without tests and generating the products
./mvnw -B -f rcp.demo.build -PDefault
# tests without product generation
./mvnw -B -f rcp.demo.build/pom.tests.core.xml -PTest
```

The rcp.demo.product/target folder will contain then all three distributions:

 - Windows 64bit
 - Linux (Gtk) 64Bit
 - Mac OSX 64Bit

**Please note**: Requires at least Java 11.

You also can use Docker on Windows for testing the Build under Linux

```
docker run --rm -v %CD%:/workspace -it adoptopenjdk/openjdk11-openj9 /workspace/build.sh
```

## Links

 - https://www.vogella.com/tutorials/EclipseRCP/article.html
 - https://www.vogella.com/tutorials/EclipseTycho/article.html
 - https://hub.docker.com/r/adoptopenjdk/openjdk11-openj9
