#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr:
#-------------------------------------------------------------#

# @descr: Main function of the script, it runs automatically on the script call.
# @param: 
#    $@ | array: (*)
function StartConfiguration {
    # Get the script name to execute.
    local SHELL_SCRIPT="${0##*/}";

    # Get Operating System
    local OPERATING_SYSTEM=$(awk '/^ID=/' /etc/*-release | awk -F'=' '{ print tolower($2) }');

    # @descr: Main function of the script "constructor"
    __initialize() {
        case ${OPERATING_SYSTEM} in
            "coreos") { 
                bash "/tmp/scripts-vagrant/dist-coreos/${SHELL_SCRIPT}" "$@";
            };;
            "centos") { 
                bash "/tmp/scripts-vagrant/dist-centos/${SHELL_SCRIPT}" "$@";
            };;
            "ubuntu") { 
                bash "/tmp/scripts-vagrant/dist-ubuntu/${SHELL_SCRIPT}" "$@";
            };;
            *) {
                echo "ERROR..: '${SHELL_SCRIPT}' script not implemented for this Linux(${OPERATING_SYSTEM}) distribution!";
                echo "WARNING: '${SHELL_SCRIPT}' script only supports distributions Linux(CoreOS, CentOS, Ubuntu).";
            };;
        esac
    }

    # @descr: Call of execution of the main function
    __initialize "$@";
}

# @descr: Call of execution of the script's main function.
StartConfiguration "$@";

# @descr: Finishing the script!!! :P
exit 0;