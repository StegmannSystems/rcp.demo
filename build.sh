#!/bin/bash
cd /workspace
./mvnw -B -f rcp.demo.build/pom.xml -PDefault
./mvnw -B -f rcp.demo.build/pom.tests.core.xml -PTest