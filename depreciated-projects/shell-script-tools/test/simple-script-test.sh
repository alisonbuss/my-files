#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Um simples template de shell script. 
# @example:
#    $ bash simple-script-test.sh;
#  OR
#    $ bash simple-script-test.sh var1 var2 "var 3";
#-------------------------------------------------------------#

source <(wget --no-cache -qO- "https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/import.sh"); 

import.ShellScriptTools "/linux/utility.sh";

function Script() {
    # instance encapsulation flag
    local _instantiated="true";

    # set parameters
    local _param="$@";

    local _timeDate=$(date +'%d/%m/%Y %H:%M:%S');
    local _message="Starting the script, $_timeDate";

    __printHelloWorld() {
        # Check that the instance flag is TRUE.
        if [ -n "$_instantiated" ]; then

            # print instance execution message
            util.print.info "$_message";

            # Check that the parameters are NOT EMPTY
            if [ -n "$_param" ]; then           
                util.print.info "Set parameters: $_param";
            fi

            # Calcular Tempo
            # https://stackoverflow.com/questions/8903239/how-to-calculate-time-difference-in-bash-script
            string1="10:33:56"
            string2="10:36:10"
            StartDate=$(date -u -d "$string1" +"%s")
            FinalDate=$(date -u -d "$string2" +"%s")
            date -u -d "0 $FinalDate sec - $StartDate sec" +"%H:%M:%S"

            string1="10:33:56.5400022"
            string2="10:36:10.8800056"
            StartDate=$(date -u -d "$string1" +"%s.%N")
            FinalDate=$(date -u -d "$string2" +"%s.%N")
            date -u -d "0 $FinalDate sec - $StartDate sec" +"%H:%M:%S.%N"

            string1="+10 days 10:33:56.5400022"
            string2="+35 days 10:36:10.8800056"
            StartDate=$(date -u -d "2000/1/1 $string1" +"%s.%N")
            FinalDate=$(date -u -d "2000/1/1 $string2" +"%s.%N")
            date -u -d "2000/1/1 $FinalDate sec - $StartDate sec" +"%j days %H:%M:%S.%N"

        fi
    }

    __initialize() {
        # Check that the instance flag is TRUE.
        if [ -n "$_instantiated" ]; then

            __printHelloWorld;

            # Run: invalid command
            INVALID_COMMAND;            

        fi
    }
    
    __initialize;
}

util.try; ( Script "$@" ); util.catch || {
    util.print.error "Exception Code: $exception";
    util.throw $exception;
}

exit 0;