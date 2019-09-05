@echo off
setlocal
set JAVA_VERSION=%1

if "%JAVA_VERSION%" == "" (
    set JAVA_VERSION=11
)

if "%JAVA_VERSION%" == "11" (
    docker run --rm ^
        -v%CD%:/workspace ^
        -it adoptopenjdk/openjdk11-openj9 ^
        /workspace/build.sh
)
