#!/bin/bash

#FONT: https://stackoverflow.com/questions/22009364/is-there-a-try-catch-command-in-bash

source <(wget -qO- "https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/linux/utility.sh");

export AnException=100
export AnotherException=101

# start with a try  
try
(   # open a subshell !!!
    print.info "do something"
    [ someErrorCondition ] && throw $AnException
 
    print.info "do something more"
    executeCommandThatMightFail || throw $AnotherException

    throwErrors # automaticatly end the try block, if command-result is non-null
    print.info "now on to something completely different"
    executeCommandThatMightFail

    print.info "it's a wonder we came so far"
    executeCommandThatFailsForSure || true # ignore a single failing command

    ignoreErrors # ignore failures of commands until further notice
    executeCommand1ThatFailsForSure
    local result = $(executeCommand2ThatFailsForSure)
    [ result != "expected error" ] && throw $AnException # ok, if it's not an expected error, we want to bail out!
    executeCommand3ThatFailsForSure

    print.info "finished"
)
# directly after closing the subshell you need to connect a group to the catch using ||
catch || {
    # now you can handle
    case $ex_code in
        $AnException)
            print.error "AnException was thrown"
        ;;
        $AnotherException)
            print.error "AnotherException was thrown"
        ;;
        *)
            print.error "An unexpected exception was thrown"
            throw $ex_code # you can rethrow the "exception" causing the script to exit if not caught
        ;;
    esac
}