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
    # Get Operating System
    local OPERATING_SYSTEM=$(awk '/^ID=/' /etc/*-release | awk -F'=' '{ print tolower($2) }');

    # Get Parameter Value
    local INTERFACE=$(util.getParameterValue "(--interface=|-a=)" "$@");
    local IP_ADDRESS=$(util.getParameterValue "(--ip-address=|-a=)" "$@");
    local GATEWAY=$(util.getParameterValue "(--gateway=|-a=)" "$@");
    local DNS=$(util.getParameterValue "(--dns=|-a=)" "$@");
    
    # @descr: ...
    __configure_for_coreos() {
        printf '%b\n' "Initializing the (Network) configuration on the system...";

        # add static network configuration in file: '/etc/systemd/network/00-enp0s8.network'
        mkdir -p "/etc/systemd/network";

        touch "/etc/systemd/network/00-static-hostonly.network"
        { 
            echo '[Match]';
            echo 'Name='$INTERFACE'';
            echo '';
            echo '[Network]';
            echo 'Address='$IP_ADDRESS'/24';
            echo 'Gateway='$GATEWAY'';
            echo 'DNS='$DNS'';

        } > "/etc/systemd/network/00-static-hostonly.network";
        chmod 644 "/etc/systemd/network/00-static-hostonly.network";

        systemctl daemon-reload; 
        systemctl restart systemd-networkd; 
        sleep 1s;
        networkctl status;
    }

    # @descr: Main function of the script "constructor"
    __initialize() {
        case ${OPERATING_SYSTEM} in
            "coreos") { 
                __configure_for_coreos "$@"; 
            };;
            "ubuntu") { 
                echo "WARNING: Configuration not implemented!";
            };;
            "centos") { 
                echo "WARNING: Configuration not implemented!";
            };;
            *) {
                echo "ERROR: The Operating System type was not implemented!";
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