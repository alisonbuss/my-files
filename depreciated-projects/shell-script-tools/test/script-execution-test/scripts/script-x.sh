#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Teste para print1 e print2
# @param: 
#    action | text: (print1, print2)
#    paramJson | json: {"message":"..."}
# @example:
#       bash script-x.sh --action='print1' --param='{"message":"Hello World!!"}'
#   OR
#       bash script-x.sh --action='print2' --param='{"message":"Hello World!!"}'    
#-------------------------------------------------------------#

source <(wget --no-cache -qO- "https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/import.sh"); 

import.ShellScriptTools "/linux/utility.sh";

function ScriptX {

    local ACTION=$(util.getParameterValue "(--action=|-a=)" "$@");
    local PARAM_JSON=$(util.getParameterValue "(--param=|-p=)" "$@");

    local message=$(echo "${PARAM_JSON}" | jq -r '.message');

    __print1() {
        util.print.info "Print 1: $message"; 
    }

    __print2() {
        util.print.info "Print 2: $message"; 
        __commandInvalid;
    }

    __actionError() {
        util.print.error "Erro: 'action' passado:($ACTION) não coincide com [print1, print2]!";
    } 

    __commandInvalid() {
        formHell...
    }

    __initialize() {
        case ${ACTION} in
            print1) __print1; ;;
            print2) __print2; ;;
            *) __actionError;
        esac
    }

    __initialize;
}

# SCRIPT INITIALIZE...
util.try; ( ScriptX "$@" ); util.catch || {
    util.print.error "Erro: Ao executar o script '${0##*/}', Exception Code: ${exception}";
    util.throw $exception;
}

exit 0;