#!/usr/bin/env sh

##############################################################################
##
##  slatekit start up script for UN*X
##
##############################################################################


# Initialize variables
COLOR_ERR='\033[0;31m'
COLOR_OK='\033[0;32m'
COLOR_OFF='\033[0m' 

VERSION=0.9.45
APP_ENV=dev


showError(){
	echo -e "${COLOR_ERR}$1 ${COLOR_OFF}"
}

showHelp() {
	echo -e "\n"

	echo -e "ARGS:\n"
	echo -e "  -dest: the destination directory to copy to"
	echo -e "        ! | string e.g. ~/git/slatekit-tools/generator/\n"
	echo -e "\n"

	echo -e "EXAMPLES:\n"
	echo -e "  1. ./slatekit.sh ~/git/slatekit-tools/generator/"
}


showSettings(){
	echo "VARS:"
	echo "env      : $APP_ENV"
	echo "name     : $APP_NAME" 
	echo "home     : $APP_HOME" 
	echo "source   : $APP_SRC" 
	echo "dist     : $APP_DIST"
	echo "target   : $APP_TARGET"
}


createDirs(){

	# Destination directories
	mkdir $APP_TARGET
	mkdir $APP_TARGET/conf
	mkdir $APP_TARGET/lib
	mkdir $APP_TARGET/gen
	mkdir $APP_TARGET/templates
}


# Validate args
if [ "$#" -ge 4 ]; then
    showError "${COLOR_ERR}Invalid number of parameters"
    showHelp
    exit 
fi


# Validate args
if [ "$#" -eq 0 ]; then
    showError "${COLOR_ERR}Must provide the destination directory"
    showHelp
    exit 
fi


# Check for help
if [ $1 == "help" ]; then
	showHelp
	exit 
fi


# Check for version
if [ $1 != "" ]; then APP_TARGET=$1; fi 


# Set settings
APP_NAME=slatekit
APP_HOME=~/dev/tmp/slatekit/slatekit
APP_SRC=$APP_HOME/src/lib/kotlin/slatekit
APP_DIST=$APP_SRC/build/distributions/slatekit
JAVA_JAR=/Library/Java/JavaVirtualMachines/jdk1.8.0_141.jdk/contents/home/bin


showSettings

# Clean all existing directories
rm -rf $APP_TARGET/templates/*

# Copy all the jars 
cp $APP_DIST/lib/*   $APP_TARGET/lib/

# Copy launcher
# cp  $APP_DIST/bin/slatekit  	 $APP_TARGET/slatekit
# cp  $APP_DIST/bin/slatekit.bat   $APP_TARGET/slatekit.bat

# Copy confs
cp $APP_SRC/src/main/resources/*.conf   $APP_TARGET/conf/

# Copy templates
cp -R $APP_SRC/src/main/resources/templates/   $APP_TARGET/templates/

# Zip up the entires release version directory
#cd $APP_RELS
#zip -r ${APP_NAME}_kotlin_v_${VERSION}.zip $VERSION

#cd $APP_BUILD
