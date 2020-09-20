#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr:
# @fonts: https://www.vagrantup.com/docs/networking/private_network.html#static-ip
#         https://coreos.com/os/docs/latest/network-config-with-networkd.html
#         https://www.upcloud.com/support/configure-floating-ip-coreos/
#         http://www.devtech101.com/2017/11/01/configuring-kubernetes-3-node-cluster-coreos-without-tectonic-part-1/
#         http://www.ricardomartins.com.br/coreos-como-realizar-a-instalacao-basica/
#         http://linux-ip.net/html/basic-changing.html#basic-changing-default
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
    local DOMAIN=$(util.getParameterValue "(--domain=|-do=)" "$@");
    local IP_ADDRESS=$(util.getParameterValue "(--ip-address=|-ip=)" "$@");
    local INTERFACE=$(util.getParameterValue "(--interface=|-i=)" "$@");
    local GATEWAY=$(util.getParameterValue "(--gateway=|-g=)" "$@");
    local DNS=$(util.getParameterValue "(--dns=|-d=)" "$@"); 
    
    printf '%b\n' "WARNING: Configuration not implemented!";
} 

# @descr: Call of execution of the script's main function.
StartConfiguration "$@";

# @descr: Finishing the script!!! :P
exit 0;