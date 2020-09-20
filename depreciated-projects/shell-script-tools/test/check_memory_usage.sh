#################################################################
# Developed by Ashok Kumar
# 1:50 PM Monday, February 04, 2008
# Font: https://gist.github.com/skyfish81/980173
#################################################################

TOT=`cat /proc/meminfo | grep MemTotal: | awk '{print $2}'`
USED=`cat /proc/meminfo | grep Active: | awk '{print $2}'`
FREE=$[$TOT - $USED ]
LOG=/tmp/mem_monitor.log
echo > $LOG
SEND=0
if [ "$USED" -gt "0" ]; then
   USEDPERC=$[$USED * 100 / $TOT]
   echo "Used Percentage      : $USEDPERC %"
   TOTMB=$[$TOT / 1024 ]
   USEDMB=$[$USED / 1024 ]
   FREEMB=$[$TOTMB - $USEDMB ]
   #echo "Used Percentage : $USEDPERC"
   if [ "$USEDPERC" -gt "80" ]; then
     SEND=1
     STATUS="Warning"
     echo "------------------------------------------------------------------" >> $LOG
     echo `hostname`   >> $LOG
     echo "------------------------------------------------------------------" >> $LOG
     echo "Total Memory (MB)    : $TOTMB" >> $LOG
     echo "Used Memory (MB)     : $USEDMB" >> $LOG
     echo "Free Memory (MB)     : $FREEMB" >> $LOG
     echo "Used Percentage      : $USEDPERC %"  >> $LOG
     echo "------------------------------------------------------------------" >> $LOG
     if [ "$USEDPERC" -gt "95" ]; then
        STATUS="Critical"
     fi
   fi
fi
if [ "$FREEMB" -eq "0" ]; then
   SEND=1
   STATUS="Fatal"
   echo "------------------------------------------------------------------" >> $LOG
   echo "    No free memory available in " `hostname`    >>$LOG
   echo "------------------------------------------------------------------" >> $LOG
fi
