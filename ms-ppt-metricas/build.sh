#!/bin/bash
echo "Compilando Fuentes"

export JAVA_HOME=/opt/jdk-17.0.7
export MAVEN_HOME=/opt/apache-maven-3.9.2
export GRADLE_HOME=/opt/gradle-8.1.1
export PATH=$JAVA_HOME/bin:$MAVEN_HOME/bin:${GRADLE_HOME}/bin:$PATH

gradle build

echo '==FIN del Build=='
