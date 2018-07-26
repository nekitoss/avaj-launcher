#!/usr/bin/bash
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color
for file in ./tests/*.txt
do
	if java ua.avaj.simulator.Main $file | grep -q "Error"; then
		echo "${GREEN}ua.avaj.simulator.Main " $file
		echo "OK${NC}\n"
	else
		echo "${RED}ua.avaj.simulator.Main " $file
		echo "WRONG_RESULT!${NC} Press any key to continue"
		read _
	fi
done
