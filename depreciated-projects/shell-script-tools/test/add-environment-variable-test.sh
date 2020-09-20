#!/bin/bash

###################  DOC  ###################
# @descr: Script do Bash para automatizar as ferramentas de 
#         instalação da linguagem programação Go em um usuário (Linux) ou remoção.
# @font: https://github.com/canha/golang-tools-install-script
# @param: 
#    action | text: (install, uninstall)
#    paramJson | json: {"version":"..."}
#############################################

function AddEnvironmentVariable {

    local name_variable=$1;
    local value_variable=$2;

    __initialize() {
        local export='export '$name_variable'="'$value_variable'"';

        touch "$HOME/.profile"
        {
            echo ${export};
        } >> "$HOME/.profile";
        source ~/.profile;

        touch "$HOME/.bashrc"
        {
            echo ${export};
        } >> "$HOME/.bashrc";
        source ~/.bashrc;

        echo "Foi adicionada uma nova variavel de ambiente no (.profile e .bashrc).";
        echo "--> export $name_variable=$value_variable";
        echo "EXECUTE COMMAD: '$ source ~/.bashrc ~/.profile'";
    }

    __initialize;
}

AddEnvironmentVariable "$@";

exit 0;