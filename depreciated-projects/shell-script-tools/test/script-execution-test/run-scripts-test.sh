#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Executar scripts sobre parametros. 
# @example:
#       bash run-scripts-test.sh --help 
#   OR
#       bash run-scripts-test.sh --version 
#   OR
#       bash run-scripts-test.sh --run --setting-file="./settings.json" 
#   OR
#       bash run-scripts-test.sh -r -s="./settings.json"
#-------------------------------------------------------------#

source <(wget --no-cache -qO- "https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/import.sh"); 

import.ShellScriptTools "/linux/utility.sh";

function RunScriptTest() {

    # @descr: 
    __notifyScriptExecution() {
        local script="$1";
        local executionWasOk="$2";
        if [[ $executionWasOk -eq 0 ]]; then
            util.print.out "%b\n" "${B_BLUE}Script ${CYAN}'${script}' ${B_BLUE}Executado com sucesso!${COLOR_OFF}";
        else
            util.print.out '%b\n' "${B_RED}Falha ao executar o script ${CYAN}'${script}'${B_RED}!${COLOR_OFF}";
            util.print.out '%b\n' "${B_RED}Exception Code: ${RED}${executionWasOk}${COLOR_OFF}";
        fi
        util.print.out '%b' "${B_WHITE}Presione [ENTER] para continuar... ${COLOR_OFF}"; read;
    }

    # @descr: 
    __executeBash() {
        local script="$1"; 
        local action="$2"; 
        local param="$3";
        local isValidPath=$(util.validateFilePath "${script}");

        if [ "${isValidPath}" == "true" ]; then
            util.executeBash "${script}" "--action=${action}" "--param=${param}";
            return $?;
        else 
            util.print.out '%b\n' "${RED}--> Error: Arquivo ou diretório não encontrado! ${B_RED}'${script}' ${COLOR_OFF}";
            return 1;
        fi
    }

    # @descr: 
    __executeBashCloud() {
        local script="$1"; 
        local action="$2"; 
        local param="$3";
        local isValidUrl=$(util.validateURL "${script}");

        if [ "${isValidUrl}" == "true" ]; then
            util.executeBashCloud "${script}" "--action=${action}" "--param=${param}";
            return $?;
        else 
            util.print.out '%b\n' "${RED}--> Error: Invalid URL! ${B_RED}'${script}' ${COLOR_OFF}";
            return 1;
        fi
    }

    # @descr: 
    __runScript() {
        local defaultPath="$1"; 
        local script="$2"; 
        local action="$3"; 
        local param="$4";

        util.print.out '%b\n\n' "";
        util.print.out '%b\n' "${ON_BLUE}--> INICIANDO A EXECUÇÃO DO SCRIPT! ${COLOR_OFF}";
        util.print.out '%b\n' "${B_WHITE}--> Script........:${B_YELLOW} '${script}'${COLOR_OFF}";
        util.print.out '%b\n' "${B_WHITE}--> Action........:${CYAN} '${action}'${COLOR_OFF}";
        util.print.out '%b\n' "${B_WHITE}--> Param.........:${CYAN} '${param}'${COLOR_OFF}";
        util.print.out '%b\n' "${B_WHITE}--> Default Path..:${CYAN} '${defaultPath}'${COLOR_OFF}";
        util.print.out '%b\n' "";

        local startTime=$(date +'%H:%M:%S');
        local startDate=$(date -u -d "${startTime}" +"%s");

        if [[ $defaultPath == "http"* ]]; then
            __executeBashCloud "${defaultPath}${script}" "${action}" "${param}";
        else
            __executeBash "${defaultPath}${script}" "${action}" "${param}";
        fi
        local executionWasOk=$?;

        local endTime=$(date +'%H:%M:%S');
        local endDate=$(date -u -d "${endTime}" +"%s")
        local finalTime=$(date -u -d "0 ${endDate} sec - ${startDate} sec" +"%H:%M:%S");
        util.print.out '%b\n' "${ON_BLUE}--> FINALIZADA A EXECUÇÃO DO SCRIPT! ${COLOR_OFF}";
        util.print.out '%b\n' "${ON_BLUE}--> TEMPO DE EXECUÇÃO DE..: ${finalTime} ${COLOR_OFF}";

        __notifyScriptExecution $script $executionWasOk;

        return 0;
    }

    # @descr: 
    __runScripts() {
        local settingFile="$1";

        local startTime=$(date +'%H:%M:%S');
        local startDate=$(date -u -d "${startTime}" +"%s")

        local settingSize=$(cat "${settingFile}" | jq ".settings | length"); 
        for (( x=1; x<=$settingSize; x++ )); do
            local settingIndex=$(($x-1));
            local scriptSize=$(cat "${settingFile}" | jq ".settings[${settingIndex}].scripts | length"); 
            for (( y=1; y<=$scriptSize; y++ )); do
                local scriptIndex=$(($y-1));
                local execute=$(cat "${settingFile}" | jq ".settings[${settingIndex}].scripts[${scriptIndex}].execute");
                if [ "${execute}" == "true" ]; then
                    local defaultPath=$(cat "${settingFile}" | jq -r ".settings[${settingIndex}].defaultPath");
                    local script=$(cat "${settingFile}" | jq -r ".settings[${settingIndex}].scripts[${scriptIndex}].script"); 
                    local action=$(cat "${settingFile}" | jq -r ".settings[${settingIndex}].scripts[${scriptIndex}].action"); 
                    local param=$(cat "${settingFile}" | jq -c ".settings[${settingIndex}].scripts[${scriptIndex}].param");

                    __runScript "${defaultPath}" "${script}" "${action}" "${param}" | tee -a "./logs/${script}.log";
                fi
            done
        done

        local endTime=$(date +'%H:%M:%S');
        local endDate=$(date -u -d "${endTime}" +"%s")
        local finalTime=$(date -u -d "0 ${endDate} sec - ${startDate} sec" +"%H:%M:%S");
        util.print.warning "A execução dos scripts teve duração de: ${finalTime}";
    }

    # @descr: 
    __showScriptExecutionDetails() {
        local settingFile="$1";
        local settingSize=$(cat "${settingFile}" | jq ".settings | length"); 
        
        util.print.info "Reading File: '${settingFile}'";

        util.print.out '%b\n\n' "${ON_BLUE}--> SCRIPTS A SEREM EXECUTADOS: ${COLOR_OFF}";
        
        for (( x=1; x<=$settingSize; x++ )); do
            local settingIndex=$(($x-1));
            local scriptSize=$(cat "${settingFile}" | jq ".settings[${settingIndex}].scripts | length"); 
            for (( y=1; y<=$scriptSize; y++ )); do
                local scriptIndex=$(($y-1));
                local execute=$(cat "${settingFile}" | jq ".settings[${settingIndex}].scripts[${scriptIndex}].execute");
                if [ "${execute}" == "true" ]; then
                    local defaultPath=$(cat "${settingFile}" | jq -r ".settings[${settingIndex}].defaultPath");
                    local script=$(cat "${settingFile}" | jq -r ".settings[${settingIndex}].scripts[${scriptIndex}].script"); 
                    local action=$(cat "${settingFile}" | jq -r ".settings[${settingIndex}].scripts[${scriptIndex}].action"); 
                    local param=$(cat "${settingFile}" | jq -c ".settings[${settingIndex}].scripts[${scriptIndex}].param");
                    
                    util.print.out '%b\n' "${B_WHITE}--> Script........:${B_YELLOW} '${script}'${COLOR_OFF}";
                    util.print.out '%b\n' "${B_WHITE}--> Action........:${CYAN} '${action}'${COLOR_OFF} ";
                    util.print.out '%b\n' "${B_WHITE}--> Param.........:${CYAN} '${param}'${COLOR_OFF}";
                    util.print.out '%b\n' "${B_WHITE}--> Default Path..:${CYAN} '${defaultPath}'${COLOR_OFF}";
                    util.print.out '%b\n' "";
                fi
            done
        done
    }
    
    # @descr: 
    __prepareScriptsExecution() {
        local settingFile=$(util.getParameterValue "(--setting-file=|-s=)" "$@");
        
        if [ -n "${settingFile}" ]; then 
            local isValidPath=$(util.validateFilePath "${settingFile}");    
            if [ "${isValidPath}" == "true" ]; then
                __showScriptExecutionDetails "${settingFile}";
                util.print.out '%b%s' "${B_WHITE}Deseja executar os scripts detalhados acima? [yes/no] $ ${COLOR_OFF}"; read input_run_scripts; 
                if [ "${input_run_scripts}" == "yes" ] || [ "${input_run_scripts}" == "y" ]; then
                    __runScripts "${settingFile}";
                fi
            else 
                util.print.out '%b\n' "${RED}--> Error: Arquivo ou diretório não encontrado! ${B_RED}'${settingFile}' ${COLOR_OFF}";
                return 1;
            fi
        else
            util.print.error "Erro: Parametro --setting-file='...' não existe!";
        fi
    }

    # @descr: 
    __help() {
        echo "Go read the code...";
    }

    # @descr: 
    __version() {
        echo "3.3.666";
    }

    # @descr: 
    __initialize() {
        # set parameters
        local _params="$@";
        case $_params in
            *--run*|*-r*) { 
                __prepareScriptsExecution "$@"; 
            };;
            *--help*|*-help*|*-h*|*help*) {
                __help "$@"; 
            };;
            *--version*|*-version*|*-v*|*version*) {
                __version "$@"; 
            };;
        esac
    }
    
    # @descr: 
    __initialize "$@";
}

# SCRIPT INITIALIZE...
util.try; ( RunScriptTest "$@" | tee -a "./logs/${0##*/}.log"; ); util.catch || {
    util.print.error "Erro: Ao executar o script '${0##*/}', Exception Code: ${exception}";
    util.throw $exception;
}

exit 0;