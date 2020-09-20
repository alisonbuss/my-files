#!/bin/bash

source <(wget --no-cache -qO- "https://raw.githubusercontent.com/alisonbuss/shell-script-tools/master/import.sh"); 

import.ShellScriptTools "/linux/utility.sh";

function colorTextTest() {
    local text=$1;
    util.print.out '%b\n' "$BLACK $text $COLOR_OFF";
    util.print.out '%b\n' "$RED $text $COLOR_OFF";
    util.print.out '%b\n' "$GREEN $text $COLOR_OFF";
    util.print.out '%b\n' "$YELLOW $text $COLOR_OFF";
    util.print.out '%b\n' "$BLUE $text $COLOR_OFF";
    util.print.out '%b\n' "$PURPLE $text $COLOR_OFF";
    util.print.out '%b\n' "$CYAN $text $COLOR_OFF";
    util.print.out '%b\n' "$WHITE $text $COLOR_OFF";

    util.print.out '%b\n' "$B_BLACK $text $COLOR_OFF";
    util.print.out '%b\n' "$B_RED $text $COLOR_OFF";
    util.print.out '%b\n' "$B_GREEN $text $COLOR_OFF";
    util.print.out '%b\n' "$B_YELLOW $text $COLOR_OFF";
    util.print.out '%b\n' "$B_BLUE $text $COLOR_OFF";
    util.print.out '%b\n' "$B_PURPLE $text $COLOR_OFF";
    util.print.out '%b\n' "$B_CYAN $text $COLOR_OFF";
    util.print.out '%b\n' "$B_WHITE $text $COLOR_OFF";

    util.print.out '%b\n' "$U_BLACK $text $COLOR_OFF";
    util.print.out '%b\n' "$U_RED $text $COLOR_OFF";
    util.print.out '%b\n' "$U_GREEN $text $COLOR_OFF";
    util.print.out '%b\n' "$U_YELLOW $text $COLOR_OFF";
    util.print.out '%b\n' "$U_BLUE $text $COLOR_OFF";
    util.print.out '%b\n' "$U_PURPLE $text $COLOR_OFF";
    util.print.out '%b\n' "$U_CYAN $text $COLOR_OFF";
    util.print.out '%b\n' "$U_WHITE $text $COLOR_OFF";

    util.print.out '%b\n' "$ON_BLACK $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_RED $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_GREEN $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_YELLOW $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_BLUE $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_BLUE1 $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_PURPLE $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_PURPLE1 $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_CYAN $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_CYAN1 $text $COLOR_OFF";
    util.print.out '%b\n' "$ON_WHITE $text $COLOR_OFF";
}
colorTextTest "Message.........";