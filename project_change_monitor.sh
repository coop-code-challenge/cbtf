#!/bin/bash

BRANCH_NAME=$1

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd $DIR
git fetch

localsha=$(git log --pretty=format:'%h' -1 2>&1)
originsha=$(git log origin/${BRANCH_NAME} --pretty=format:'%h' -1 2>&1)

if [ "${localsha}" != "${originsha}" ]; then
    echo `date`" Revisions were different, pulling down changes. Previous: \"${localsha}\" New: \"${originsha}\""
    git checkout ${BRANCH_NAME}
    git pull origin ${BRANCH_NAME}
    export JAVA_HOME=/usr/java/latest
    echo `date`" Rebuilding application"
    ./gradlew
    echo `date`" Attempting shutdown of previous running application"
    pkill -9 -f family2family
    echo `date`" Removing old log files"
    rm -f ../application.out
    rm -f ../application.err
    echo `date`" Attempting startup of new application"
    java -jar family2family/build/libs/*.jar --spring.profiles.active=production > ../application.out 2> ../application.err &
fi
