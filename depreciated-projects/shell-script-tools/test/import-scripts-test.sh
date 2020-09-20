#!/bin/bash

# @FONT: https://stackoverflow.com/questions/5735666/execute-bash-script-from-url
# @descr: 
# @example:
#
# Baixa e executa o arquivo passando parametros (arg1 arg2)
# curl -s http://server/path/script.sh | bash -s arg1 arg2
#

#SST_URL="https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master";
#source <(wget -qO- "$SST_URL/linux/utility.sh");

source <(wget -qO- "https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/import.sh"); 
echo $URL_SHELL_SCRIPT_TOOLS;
importShellScriptTools "/linux/utility.sh";

function RunTest {
   
    local PARAM=$1;

    __initialize() {
        
        print.info "$PARAM"; 
 
    }

    __initialize;
}

RunTest "$@";

# @descr: example a script the parameters
# @font: https://stackoverflow.com/questions/3811345/how-to-pass-all-arguments-passed-to-my-bash-script-to-a-function-of-mine
# @example:
#    $ testSetParameters a1 a2 a3;
#function testSetParameters {
#    args=("$@")
#    echo args: "$@";
#    echo Number of arguments: $#;
#    echo 1st argument: ${args[0]};
#    echo 2nd argument: ${args[1]};
#}
#function testSetParameters { args=("$@") echo args: "$@"; echo Number of arguments: $#; echo 1st argument: ${args[0]}; echo 2nd argument: ${args[1]}; }

exit 0;