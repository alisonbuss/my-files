#!/bin/bash

# @descr: URL padrão do "shell_script_tools" do repositorio "https://github.com/alisonbuss/shell-script-tools"
export URL_SHELL_SCRIPT_TOOLS="https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/src";

# @descr: Importa os shell scripts do repositorio.
# @example:
#
#    import.ShellScriptTools "/linux/utility.sh";
#    import.ShellScriptTools "/ubuntu/extension-jq.sh";
#
function import.ShellScriptTools {
    local shellScript=$1;
    source <(wget --no-cache -qO- "${URL_SHELL_SCRIPT_TOOLS}${shellScript}"); 
} 
export -f import.ShellScriptTools;