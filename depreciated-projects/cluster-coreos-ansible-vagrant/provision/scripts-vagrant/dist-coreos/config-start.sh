#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr:
#-------------------------------------------------------------#

# @fonts: https://www.digitalocean.com/community/tutorials/using-grep-regular-expressions-to-search-for-text-patterns-in-linux
# @example:
#    $ util.getParameterValue "(--param3=|-p3=)" "$@"
function util.getParameterValue(){
    local exp=$1;
    local params=("$@");
    local valueEnd="";
    for value in "${params[@]:1:$#}"; do
        if grep -E -q "${exp}" <<< "${value}"; then
            valueEnd="${value#*=}";
            break;
        fi        
    done
    echo $valueEnd;
}

# @descr: Main function of the script, it runs automatically on the script call.
# @param: 
#    $@ | array: (*)
function StartConfiguration {
    # Get Parameter Value
    local HOSTNAME=$(util.getParameterValue "(--hostname=|-h=)" "$@");

    printf '%b\n' "Initializing basic CoreOS settings...";

    printf '%b\n' "Defining hostname(${HOSTNAME}) in the operating system...";
    hostnamectl set-hostname "${HOSTNAME}";

    sleep 2s;

    hostnamectl status;
} 

# @descr: Call of execution of the script's main function.
StartConfiguration "$@";

# @descr: Finishing the script!!! :P
exit 0;