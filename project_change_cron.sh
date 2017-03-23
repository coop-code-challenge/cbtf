#!/bin/bash
# This script is meant to run forever to invoke the monitor script. It could be replaced with a crontab.
# This script requires a branch name to be passed in.

BRANCH_NAME=$1

if [ -z ${BRANCH_NAME} ]; then
  echo "Branch name is required. Exiting"
  exit 1
fi

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

while :
do
  ${DIR}/project_change_monitor.sh ${BRANCH_NAME} & 
  sleep 30
done
