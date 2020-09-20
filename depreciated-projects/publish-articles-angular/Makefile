
#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Makefile for running a kubernetes cluster.
# @fonts: https://www.gnu.org/software/make/
#         https://coderwall.com/p/cezf6g/define-your-own-function-in-a-makefile
# @example:
#       $ make help
#   OR
#       $ make machines-up \
#              provide-ping \
#              provide-facts \
#              provide-admin-client \
#              provide-cluster-all \
#              provide-cluster-etcd \
#              provide-cluster-master \
#              provide-cluster-worker
#   OR 
#       $ make machines-up provide-kubernetes LEVEL_INF="-vv"
#-------------------------------------------------------------#

# DEFAULT VARIABLES - STRUCTURAL

SYSTEM            ?= coreos
ENVIRONMENT       ?= development
WORKING_DIRECTORY ?= `pwd`
PLAYBOOK_DIR      ?= $(WORKING_DIRECTORY)/provision/kubernetes-ansible
# Parameter that defines the amount of information that will be shown 
# on the screen while the playbook runs, and can go up to -vvvv (1-4v).
#LEVEL_INF        ?= -v 
LEVEL_INF         ?= 
PARAM             ?= 

# EXTERNAL MAKEFILE CALL FUNCTION - STRUCTURAL

define external_makefile
    @make --directory $(PLAYBOOK_DIR) $(1) SYSTEM="$(SYSTEM)" ENVIRONMENT="$(ENVIRONMENT)" LEVEL_INF="$(LEVEL_INF)";
endef

# VIEW DETAILS

plan: 
	@echo "The default values to be used by this Makefile:";
	@echo "";
	@echo "    --> MAKECMDGOALS: 'make $(MAKECMDGOALS)'";
	@echo "    --> SYSTEM: $(SYSTEM)";
	@echo "    --> ENVIRONMENT: $(ENVIRONMENT)";
	@echo "    --> WORKING_DIRECTORY: $(WORKING_DIRECTORY)";
	@echo "    --> PLAYBOOK_DIR: $(PLAYBOOK_DIR)";
	@echo "    --> LEVEL_INF: $(LEVEL_INF)";
	@echo "    --> PARAM: $(PARAM)";
	@echo "";

# INFRASTRUCTURE

machines-status:
	@echo "Initiating view of virtual machines status...";
	@vagrant status $(PARAM);
	@echo "Execution Completed!"; 

machines-up:
	@echo "Initiating the rise of virtual machines...";
	@vagrant up $(PARAM);
	@echo "Execution Completed!"; 

machines-reload:
	@echo "Initiating the reload of virtual machines...";
	@vagrant reload $(PARAM) --provision;
	@echo "Execution Completed!"; 

machines-off:
	@echo "Initiating the shutdown of virtual machines...";
	@vagrant halt $(PARAM);
	@echo "Execution Completed!"; 

machines-destroy:
	@echo "Initiating the destroy of virtual machines...";
	@vagrant destroy $(PARAM) --force;
	@echo "Execution Completed!"; 

# PROVISIONING ENV

provide-ping:
	$(call external_makefile, provide-ping)

provide-facts:
	$(call external_makefile, provide-facts)

provide-reboot:
	$(call external_makefile, provide-reboot)

provide-info:
	$(call external_makefile, provide-info)

# PROVISIONING KUBERNETES

provide-admin-client:
	$(call external_makefile, provide-admin-client)

provide-cluster-all:
	$(call external_makefile, provide-cluster-all)

provide-cluster-etcd:
	$(call external_makefile, provide-cluster-etcd)

provide-cluster-master:
	$(call external_makefile, provide-cluster-master)

provide-cluster-worker:
	$(call external_makefile, provide-cluster-worker)

provide-kubernetes:
	$(call external_makefile, provide-kubernetes)

provide-services:
	$(call external_makefile, provide-services)

# PROVISIONING NEW MEMBERS KUBERNETES

provide-new-member-etcd:
	$(call external_makefile, provide-new-member-etcd)

provide-new-member-master:
	$(call external_makefile, provide-new-member-master)

provide-new-member-worker:
	$(call external_makefile, provide-new-member-worker)

# VIEW DOCUMENTATION

help:
	@echo ' '
	@echo 'Usage: make <TARGETS> ... [OPTIONS]'
	@echo ' '
	@echo 'TARGETS:'
	@echo ' '
	@echo '  Infrastructure:'
	@echo '     machines-status     Starts view of virtual machines status.'
	@echo '     machines-up         Starts the rise of virtual machines.'
	@echo '     machines-reload     Starts the reload of virtual machines.'
	@echo '     machines-off        Starts the shutdown of virtual machines.'
	@echo '     machines-destroy    Starts the destroy of virtual machines.'
	@echo ' '

	@echo '  Provisioning from setup initial:'
	@echo '     provide-ping      Starts the testing of "ping" on all host on the infrastructure.'
	@echo '     provide-facts     Starts the execution of the "setup" ansible command.'
	@echo '     provide-reboot    Starts the execution system reboot of all hosts.'
	@echo '     provide-info      Starts the collecting basic information from the entire infrastructure.'
	@echo ' '
	@echo '  Provisioning Kubernetes:'
	@echo '     provide-admin-client      Starts the installation of the administrators clients.'
	@echo '     provide-cluster-all       Starts the customization, configuration, and security of all Kubernetes hosts.'
	@echo '     provide-cluster-etcd      Starts the provisioning of the Etcd cluster.'
	@echo '     provide-cluster-master    Starts the provisioning of the Kubernetes Master cluster.'
	@echo '     provide-cluster-worker    Starts the provisioning of the Kubernetes Worker cluster.'
	@echo '     provide-services          Starts the provisioning of the Services Kubernetes.'
	@echo ' '
	@echo '  Provisioning new members of the infrastructure:'
	@echo '     provide-new-member-etcd      Starts the provisioning of new Etcd members for the Etcd cluster.'
	@echo '     provide-new-member-master    Starts the provisioning of new Kubernetes Master members for the Kubernetes cluster.'
	@echo '     provide-new-member-worker    Starts the provisioning of new Kubernetes Worker members for the Kubernetes cluster.'

	@echo ' '
	@echo '  View details:'
	@echo '     plan    The default values to be used by this Makefile.'
	@echo ' '
	@echo '  Help:'
	@echo '     help    Print this help message.'
	@echo ' '
	@echo 'OPTIONS:'
	@echo ' '
	@echo '   SYSTEM               Specifies the type operational system for the Kubernetes deployment, the default is [coreos].'
	@echo '   ENVIRONMENT          Specifies the type of environment variable for the Kubernetes deployment, the default is [development].'
	@echo '   WORKING_DIRECTORY    Specify the current working directory, the default is [`pwd`].'
	@echo '   INVENTORY_FILE       Specifies the inventory path according to the deployment environment variable.'
	@echo '   PLAYBOOK_DIR         Specifies the base path of the playbooks.'
	@echo '   LEVEL_INF            Parameter that defines the amount of information that will be shown on the screen'  
	@echo '                        while the playbook runs, and can go up to -vvvv (1-4v), the default is [EMPTY].'
	@echo '   PARAM                Specify the host domain in the <TARGETS> call of infrastructure, the default is [EMPTY], examples:'
	@echo '                           Ex 1: make machines-up PARAM="etcd03.virtual.com"'
	@echo '                           Ex 2: make machines-off PARAM="worker02.virtual.com"'
	@echo ' '
