#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Script de instalação da extensão 'jq' na maquina. 
# @fonts: https://stedolan.github.io/jq/
#         https://serverfault.com/questions/768026/how-to-install-jq-on-rhel6-5
# @example:
#       $ ...
#-------------------------------------------------------------#

# @descr: Instalação do JQ
# @example:
#    $ installExtensionJQ;
function installExtensionJQ {
    __install() {
        apt-get install jq;
    }

    __initialize() {
        __install;
    }

    __initialize;
}
export -f installExtensionJQ;

# @descr: Desinstalação do JQ
# @example:
#    $ uninstallExtensionJQ;
function uninstallExtensionJQ {
    # @fonts: http://installion.co.uk/ubuntu/trusty/universe/j/jq/uninstall/index.html
    __uninstall() {
        apt-get remove --auto-remove jq;
        apt-get purge --auto-remove jq;
    }

    __initialize() {
        __uninstall;
    }

    __initialize;
}
export -f uninstallExtensionJQ;