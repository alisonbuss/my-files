#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr:
# @fonts: https://www.vagrantup.com/docs/networking/public_network.html#static-ip
#         https://coreos.com/os/docs/latest/network-config-with-networkd.html
#         https://www.upcloud.com/support/configure-floating-ip-coreos/
#         https://copyninja.info/blog/systemd-networkd-networking.html
#         https://omarine.org/2018/04/12/creating-manageable-virtual-machines-general-network-setup/
#         https://major.io/2015/03/26/creating-a-bridge-for-virtual-machines-using-systemd-networkd/
#         https://wiki.gentoo.org/wiki/Network_bridge
#         https://www.cyberciti.biz/faq/how-to-configuring-bridging-in-debian-linux/
#         https://www.ostechnix.com/configure-static-dynamic-ip-address-arch-linux/
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

        touch "/etc/systemd/network/00-static-bridge.netdev"
        { 
            echo '[NetDev]';
            echo 'Description=Bridge interface for containers/vms';
            echo 'Name=br0';
            echo 'Kind=bridge';

        } > "/etc/systemd/network/00-static-bridge.netdev";
        chmod 644 "/etc/systemd/network/00-static-bridge.netdev";
    
        touch "/etc/systemd/network/01-static-bridge-uplink.network"
        { 
            echo '[Match]';
            echo 'Name='$INTERFACE'';
            echo '';
            echo '[Network]';
            echo 'Bridge=br0';

        } > "/etc/systemd/network/01-static-bridge-uplink.network";
        chmod 644 "/etc/systemd/network/01-static-bridge-uplink.network";

        touch "/etc/systemd/network/02-static-bridge.network"
        { 
            echo '[Match]';
            echo 'Name=br0';
            echo '';
            echo '[Network]';
            echo 'Address='$IP_ADDRESS'/24';
            echo 'Gateway='$GATEWAY'';
            echo 'DNS='$DNS'';

        } > "/etc/systemd/network/02-static-bridge.network";
        chmod 644 "/etc/systemd/network/02-static-bridge.network";

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