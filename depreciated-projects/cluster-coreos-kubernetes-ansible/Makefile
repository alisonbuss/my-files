
#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Makefile for running a kubernetes cluster.
# @fonts: https://www.gnu.org/software/make/
# @example:
#       $ make help
#   OR
#       $ make provide-ping \
#              provide-facts \
#              provide-admin-client \
#              provide-cluster-all \
#              provide-cluster-etcd \
#              provide-cluster-master \
#              provide-cluster-worker
#   OR
#       $ make plan provide-kubernetes LEVEL_INF="-vv"
#-------------------------------------------------------------#

# DEFAULT VARIABLES - STRUCTURAL

SYSTEM            ?= coreos
ENVIRONMENT       ?= development
WORKING_DIRECTORY ?= `pwd`
PLAYBOOK_DIR      ?= $(WORKING_DIRECTORY)
INVENTORY_FILE    ?= $(PLAYBOOK_DIR)/inventories/$(ENVIRONMENT)/hosts
# Parameter that defines the amount of information that will be shown 
# on the screen while the playbook runs, and can go up to -vvvv (1-4v).
#LEVEL_INF        ?= -v 
LEVEL_INF         ?= 

# VIEW DETAILS

plan: 
	@echo "The default values to be used by this Makefile:";
	@echo "";
	@echo "    --> MAKECMDGOALS: 'make $(MAKECMDGOALS)'";
	@echo "    --> SYSTEM: $(SYSTEM)";
	@echo "    --> ENVIRONMENT: $(ENVIRONMENT)";
	@echo "    --> WORKING_DIRECTORY: $(WORKING_DIRECTORY)";
	@echo "    --> PLAYBOOK_DIR: $(PLAYBOOK_DIR)";
	@echo "    --> INVENTORY_FILE: $(INVENTORY_FILE)";
	@echo "    --> LEVEL_INF: $(LEVEL_INF)";
	@echo "";

# PROVISIONING ENV

provide-ping: 
	@echo "Initiating the testing of 'ping' on all host on the infrastructure...";
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-setup.yml \
	                   --extra-vars="global_system=$(SYSTEM)" \
	                   --tags="ping" \
	                   --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-facts: 
	@echo "Initiating the execution of the "setup" ansible command...";
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-setup.yml \
	                   --extra-vars="global_system=$(SYSTEM)" \
	                   --tags="setup" \
	                   --verbose $(LEVEL_INF);
	-@echo -n "--Facts generated:" && ls -R ~/.ansible/custom-fact-caching;
	@echo "Execution Completed!"; 

provide-reboot: 
	@echo "Initiating system reboot of all hosts...";
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-setup.yml \
	                   --extra-vars="global_system=$(SYSTEM)" \
	                   --tags="reboot" \
	                   --verbose $(LEVEL_INF);
	@echo "Execution Completed!";

provide-info: 
	@echo "Initiating collecting basic information from the entire infrastructure...";
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-setup.yml \
	                   --extra-vars="global_system=$(SYSTEM)" \
	                   --tags="info" \
	                   --verbose $(LEVEL_INF);
	@echo "Execution Completed!";

# PROVISIONING KUBERNETES

provide-admin-client:
	@echo "Initiating the installation of the administrators clients...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-admin-client.yml \
	                  --extra-vars="global_system=ubuntu" \
	                  --tags="kubernetes-client" \
	                  --verbose $(LEVEL_INF) --ask-become-pass;
	@echo "Execution Completed!";

provide-cluster-all:
	@echo "Initiating the customization, configuration, and security of all Kubernetes hosts...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-cluster-all.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-all" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!";

provide-cluster-etcd:
	@echo "Initiating the provisioning of the Etcd cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-cluster-etcd.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-etcd" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-cluster-master:
	@echo "Initiating the provisioning of the Kubernetes Master cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-cluster-master.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-master" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-cluster-worker:
	@echo "Initiating the provisioning of the Kubernetes Worker cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-cluster-worker.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-worker" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

# ---------------------------------------- #
# Provide the entire structure kubernetes. #
# ---------------------------------------- #
provide-kubernetes: plan provide-facts provide-admin-client provide-cluster-all provide-cluster-etcd provide-cluster-master provide-cluster-worker

provide-kubernetes-services:
	@echo "Initiating the provisioning of the Services Kubernetes...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-services.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-services" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

# PROVISIONING NEW MEMBERS KUBERNETES 

provide-new-member-etcd:
	@echo "Initiating the provisioning of new Etcd members for the Etcd cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-new-member-etcd.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-new-etcd" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-new-member-master:
	@echo "Initiating the provisioning of new Master members for the Kubernetes cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-new-member-master.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-new-master" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-new-member-worker:
	@echo "Initiating the provisioning of new Worker members for the Kubernetes cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-new-member-worker.yml \
	                  --extra-vars="global_system=$(SYSTEM)" \
	                  --tags="kubernetes-new-worker" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

# VIEW DOCUMENTATION

#FONT: https://github.com/ceph/ceph-container/blob/master/Makefile#L128
help:
	@echo ' '
	@echo 'Usage: make <TARGETS> ... [OPTIONS]'
	@echo ' '
	@echo 'TARGETS:'
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
	@echo '   PLAYBOOK_DIR         Specifies the base path of the playbooks.'
	@echo '   INVENTORY_FILE       Specifies the inventory path according to the deployment environment variable.'
	@echo '   LEVEL_INF            Parameter that defines the amount of information that will be shown on the screen'  
	@echo '                        while the playbook runs, and can go up to -vvvv (1-4v), the default is [EMPTY].'
	@echo ' '
