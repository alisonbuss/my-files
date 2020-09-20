#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Script of the installation of Python in CoreOS to enable provisioning with Ansible.
# @fonts: https://gist.github.com/jason-riddle/b88db998c3cceede4f7879c439bf8186
#         https://makefile.blog/2017/06/02/install-python-on-coreos/
#         https://github.com/ziozzang/python-on-coreos/blob/master/install-python-on-coreos.sh
#         https://github.com/holms/ansible-coreos/blob/master/roles/coreos/tasks/coreos.yml
#         https://vadosware.io/post/installing-python-on-coreos-with-ansible/
#-------------------------------------------------------------#

# @fonts: https://www.digitalocean.com/community/tutorials/using-grep-regular-expressions-to-search-for-text-patterns-in-linux
# @example:
#    $ util.getParameterValue "(--param3=|-p3=)" "$@"
function util.getParameterValue(){
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

# @descr: Main function of the script, it runs automatically on the script call.
# @param: 
#    $@ | array: (*)
function StartConfiguration {
    # Get Operating System
    local OPERATING_SYSTEM=$(awk '/^ID=/' /etc/*-release | awk -F'=' '{ print tolower($2) }');
    
    # @descr: ...
    __install_for_coreos() {
        if [ -x /opt/bin/python ]; then
            printf '%b\n' "CoreOS already has (ActivePython) installed on your system...";
            /opt/bin/python --version;
        else
            printf '%b\n' "Starting the installation of (ActivePython)...";

            # Define default values.
            local VERSION="2.7.13.2714"
            local PACKAGE="ActivePython-${VERSION}-linux-x86_64-glibc-2.12-402178"

            # Creating installation directories.
            mkdir -p "/opt/bin";
            mkdir -p "/opt/python";
            cd /opt;

            # Starting download: 'ActivePython-2.7...tar.gz'.
            wget "http://downloads.activestate.com/ActivePython/releases/${VERSION}/${PACKAGE}.tar.gz";
            
            # Extracting files: 'ActivePython-2.7...tar.gz'.
            tar -zxf ${PACKAGE}.tar.gz;

            # Starting installation for '/opt/python/'...
            mv ${PACKAGE} apy && cd apy && ./install.sh -I /opt/python/;

            ln -sf /opt/python/bin/easy_install /opt/bin/easy_install;
            ln -sf /opt/python/bin/pip /opt/bin/pip;
            ln -sf /opt/python/bin/python /opt/bin/python;
            ln -sf /opt/python/bin/virtualenv /opt/bin/virtualenv;

            /opt/bin/python --version;
            export PATH=$PATH:/opt/python/bin;

            # Remove files.
            rm -rf /opt/${PACKAGE}.tar.gz;
            rm -rf /opt/apy;
            
            # BUG: 
            # Run shell -> $ docker-compose version
            # WARNING: Dependency conflict: an older version of the 'docker-py' package may be polluting
            # the namespace. If you're experiencing crashes, run the following command to remedy the issue:
            # pip uninstall docker-py; pip uninstall docker; pip install docker
            # docker-compose version 1.19.0, build 9e633ef
            # SOLUTION:
            printf '%b\n' "--run pip upgrade...";
            pip install --upgrade pip;
            printf '%b\n' "--run pip uninstall docker-py...";
            pip uninstall -y docker-py;
            printf '%b\n' "--run pip install docker...";
            pip install docker;
        fi
    }

    # @descr: Main function of the script "constructor"
    __initialize() {
        case ${OPERATING_SYSTEM} in
            "coreos") { 
                __install_for_coreos "$@"; 
            };;
            "ubuntu") { 
                echo "WARNING: Configuration not implemented!";
            };;
            "centos") { 
                echo "WARNING: Configuration not implemented!";
            };;
            *) {
                echo "ERROR: The Operating System type was not implemented!";
            };;
        esac
    }

    # @descr: Call of execution of the main function
    __initialize "$@";
} 

# @descr: Call of execution of the script's main function.
StartConfiguration "$@";

# @descr: Finishing the script!!! :P
exit 0;