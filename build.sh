#!/bin/bash
cd /workspace
./mvnw -B -f rcp.demo.build/pom.xml -PDefault
result=$?

if [ ${result} -eq 0 ]; then
    ./mvnw -B -f rcp.demo.build/pom.tests.core.xml -PTest
    result=$?
    if [ ${result} -eq 0 ]; then
        ./mvnw -B -f rcp.demo.jacoco.merge
        result=$?
    fi
fi

exit ${result}
