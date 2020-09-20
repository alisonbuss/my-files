#!/bin/bash

###################  DOC  ###################
# @descr: Script do Bash para automatizar as ferramentas de 
#         instalação da linguagem programação Go em um usuário (Linux) ou remoção.
# @font: https://github.com/canha/golang-tools-install-script
# @param: 
#    action | text: (install, uninstall)
#    paramJson | json: {"version":"..."}
#############################################

function addShortcutVariableGit {

    __initialize() {
        local export='export GREP="/mnt/sda2/git-repositories"';
        local export_pi='export GREP_PI="/mnt/sda2/git-repositories/private"';
        local export_pu='export GREP_PU="/mnt/sda2/git-repositories/public"';
        local export_wo='export GREP_WO="/mnt/sda2/git-repositories/work"';

        touch "$HOME/.profile"
        {
            echo ${export};
            echo ${export_pi};
            echo ${export_pu};
            echo ${export_wo};
        } >> "$HOME/.profile";
        source ~/.profile;

        touch "$HOME/.bashrc"
        {
            echo ${export};
            echo ${export_pi};
            echo ${export_pu};
            echo ${export_wo};
        } >> "$HOME/.bashrc";
        source ~/.bashrc;

        echo "Foi adicionada uma nova variavel de ambiente no (.profile e .bashrc).";
        echo "--> $export";
        echo "--> $export_pi";
        echo "--> $export_pu";
        echo "--> $export_wo";
        echo "EXECUTE COMMAD: '$ source ~/.bashrc ~/.profile'";
    }

    __initialize;
}

addShortcutVariableGit "$@";

exit 0;