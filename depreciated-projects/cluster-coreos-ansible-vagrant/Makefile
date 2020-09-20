
#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Makefile for running a kubernetes cluster.
# @fonts: https://www.gnu.org/software/make/
#         https://coderwall.com/p/cezf6g/define-your-own-function-in-a-makefile
# @example:
#       $ make help
#   OR
#       $ make machines-up \
#              provide-ping \
#              provide-setup \
#              provide-k8s-admin-client \
#              provide-k8s-basic-environment \
#              provide-k8s-cluster-etcd \
#              provide-k8s-cluster-master \
#              provide-k8s-cluster-worker
#   OR 
#       $ make machines-up provide-kubernetes LEVEL_INF="-vv"
#-------------------------------------------------------------#

# DEFAULT VARIABLES - STRUCTURAL ******************************

SYSTEM            ?= coreos
ENVIRONMENT       ?= development
WORKING_DIRECTORY ?= `pwd`
PLAYBOOK_DIR      ?= $(WORKING_DIRECTORY)/provision/kubernetes-ansible
# Parameter that defines the amount of information that will be shown 
# on the screen while the playbook runs, and can go up to -vvvv (1-4v).
#LEVEL_INF        ?= -v 
LEVEL_INF         ?= 
PARAM             ?= 

# EXTERNAL MAKEFILE CALL FUNCTION - STRUCTURAL ****************

define external_makefile
    @make --directory $(PLAYBOOK_DIR) $(1) SYSTEM="$(SYSTEM)" ENVIRONMENT="$(ENVIRONMENT)" LEVEL_INF="$(LEVEL_INF)";
endef

# VIEW DETAILS ************************************************

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

# INFRASTRUCTURE **********************************************

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

# PROVISIONING ENV ********************************************

provide-ping:
	$(call external_makefile, provide-ping)

provide-setup:
	$(call external_makefile, provide-setup)

provide-reboot:
	$(call external_makefile, provide-reboot)

provide-info:
	$(call external_makefile, provide-info)

# PROVISIONING KUBERNETES *************************************

provide-k8s-admin-client:
	$(call external_makefile, provide-k8s-admin-client)

provide-k8s-cluster-all:
	$(call external_makefile, provide-k8s-cluster-all)

provide-k8s-cluster-etcd:
	$(call external_makefile, provide-k8s-cluster-etcd)

provide-k8s-cluster-master:
	$(call external_makefile, provide-k8s-cluster-master)

provide-k8s-cluster-worker:
	$(call external_makefile, provide-k8s-cluster-worker)

provide-kubernetes:
	$(call external_makefile, provide-kubernetes)

provide-kubernetes-services:
	$(call external_makefile, provide-kubernetes-services)

provide-kubernetes-business:
	$(call external_makefile, provide-kubernetes-business)

# PROVISIONING NEW MEMBERS KUBERNETES *************************

provide-k8s-new-member-etcd:
	$(call external_makefile, provide-k8s-new-member-etcd)

provide-k8s-new-member-master:
	$(call external_makefile, provide-k8s-new-member-master)

provide-k8s-new-member-worker:
	$(call external_makefile, provide-k8s-new-member-worker)

# VIEW DOCUMENTATION ******************************************

help:
	@echo ' '
	@echo 'Usage: make <TARGETS> ... [OPTIONS]'
	@echo ' '
	@echo 'TARGETS:'
	@echo ' '
	@echo '  Infrastructure:'
	@echo '     machines-status   Starts view of virtual machines status.'
	@echo '     machines-up       Starts the rise of virtual machines.'
	@echo '     machines-reload   Starts the reload of virtual machines.'
	@echo '     machines-off      Starts the shutdown of virtual machines.'
	@echo '     machines-destroy  Starts the destroy of virtual machines.'
	@echo ' '
	@echo '  Help:'
	@echo '     help    Print this help message.'
	@echo ' '
	@echo 'OPTIONS:'
	@echo ' '
	@echo '   ENVIRONMENT        Specifies the type of environment variable for the Kubernetes deployment, the default is [development].'
	@echo '   WORKING_DIRECTORY  Specify the current working directory, the default is [`pwd`].'
	@echo '   INVENTORY_FILE     Specifies the inventory path according to the deployment environment variable.'
	@echo '   PLAYBOOK_DIR      Specifies the base path of the playbooks.'
	@echo '   LEVEL_INF          Parameter that defines the amount of information that will be shown on the screen'  
	@echo '                      while the playbook runs, and can go up to -vvvv (1-4v), the default is [EMPTY].'
	@echo '   PARAM              Specify the host domain in the <TARGETS> call of infrastructure, the default is [EMPTY], examples:'
	@echo '                         Ex 1: make machines-up PARAM="etcd03.virtual.com" '
	@echo '                         Ex 1: make machines-off PARAM="worker02.virtual.com" '
	@echo ' '
	@make --directory $(PLAYBOOK_DIR) help;
