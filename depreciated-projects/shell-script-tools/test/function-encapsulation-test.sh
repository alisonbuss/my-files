#!/bin/bash

source <(wget -qO- "https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/import.sh"); 

importShellScriptTools "/linux/utility.sh";

function functionX() {
    print.info "iniciando a função X...";

    # Run: invalid command
    INVALID_COMMAND;
}

try; ( functionX "$@" ); catch || {
    print.error "Error: $ex_code";
    throw $ex_code;
}

exit 0;