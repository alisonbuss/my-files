#!/bin/bash

value="valor global....";

function func01() {

    local value="valor local....";

    echo "func 01: $value";

    function func02() {
        echo "func 02: $value";
        return 0;
    }

    function func03() {
        echo "func 03: $value";
        return 0;
    }

    func02;
    func03;

    return 0;
}; func01; 

function func04() {
    echo "func 04: $value";
    return 0;
}

function funcParams() {
    if [ $# -gt 0 ]; then           
        echo "Com parametros"
    else
        echo "Sem parametros"
    fi

    local firstParam="$1";
    local params=("$@");

    echo "all params:" "$@";
    echo "Number of arguments: $#";
    echo "1st argument: ${params[0]}";
    echo "2nd argument: ${params[1]}";

    echo "First Param: ${firstParam}";

    echo "From the second onwards: ${params[@]:1:$#}";
}

#https://www.digitalocean.com/community/tutorials/using-grep-regular-expressions-to-search-for-text-patterns-in-linux
function getParameterValue(){
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

function funcGetParams() {
    if [ $# -gt 0 ]; then           
        echo "Com parametros"
    else
        echo "Sem parametros"
    fi

    local firstParam="$1";
    local params=("$@");

    echo "--------";
    for value in "${params[@]:0:$#}"; do
        echo "${value}";
    done
    echo "--------";

    echo "all params:" "$@";
    echo "Number of arguments: $#";
    echo "1st argument: ${params[0]}";
    echo "2nd argument: ${params[1]}";

    echo "First Param: ${firstParam}";

    echo "From the second onwards: ${params[@]:1:$#}";

    echo "Pegar valores dos parametros: [--param2, --param1, --param3]";
    
    local valueParam2=$(getParameterValue "(--param2=|-p2=)" "$@");
    echo "--param2: ${valueParam2}";

    local valueParam1=$(getParameterValue "(--param1=|-p1=)" "$@");
    echo "--param1: ${valueParam1}";

    local valueParam3=$(getParameterValue "(--param3=|-p3=)" "$@");
    echo "--param3: ${valueParam3}";
}

func02;
func03;
func04;

funcParams paA paB paC paD;

echo "---------------------------------------------------";

funcGetParams --run --param1="LL ll..." --p2="UU uu..." --p3="XX xx..." "L u X";