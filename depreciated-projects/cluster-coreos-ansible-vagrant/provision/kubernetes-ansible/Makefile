
#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Makefile for running a kubernetes cluster.
# @fonts: https://www.gnu.org/software/make/
# @example:
#       $ make help
#   OR
#       $ make provide-ping \
#              provide-setup \
#              provide-k8s-admin-client \
#              provide-k8s-cluster-all \
#              provide-k8s-cluster-etcd \
#              provide-k8s-cluster-master \
#              provide-k8s-cluster-worker
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
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-environment.yml \
	                   --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                   --tags="ping" \
	                   --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-setup: 
	@echo "Initiating the execution of the "setup" ansible command...";
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-environment.yml \
	                   --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                   --tags="setup" \
	                   --verbose $(LEVEL_INF);
	-@echo -n "--Facts generated:" && ls -R ~/.ansible/custom-fact-caching;
	@echo "Execution Completed!"; 

provide-reboot: 
	@echo "Initiating system reboot of all hosts...";
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-environment.yml \
	                   --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                   --tags="reboot" \
	                   --verbose $(LEVEL_INF);
	@echo "Execution Completed!";

provide-info: 
	@echo "Initiating collecting basic information from the entire infrastructure...";
	-@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-environment.yml \
	                   --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                   --tags="info" \
	                   --verbose $(LEVEL_INF);
	@echo "Execution Completed!";

# PROVISIONING KUBERNETES

provide-k8s-admin-client:
	@echo "Initiating the installation of the administrators clients...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-k8s-admin-client.yml \
	                  --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                  --tags="kubernetes-client" \
	                  --verbose $(LEVEL_INF) --ask-become-pass;
	@echo "Execution Completed!";

provide-k8s-cluster-all:
	@echo "Initiating the customization, configuration, and security of all Kubernetes hosts...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-k8s-cluster-all.yml \
	                  --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                  --tags="kubernetes-all" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!";

provide-k8s-cluster-etcd:
	@echo "Initiating the provisioning of the Etcd cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-k8s-cluster-etcd.yml \
	                  --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                  --tags="kubernetes-etcd" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-k8s-cluster-master:
	@echo "Initiating the provisioning of the Kubernetes Master cluster...";
	@ansible-playbook --inventory="$(INVENTORY_FILE)" $(PLAYBOOK_DIR)/provide-k8s-cluster-etcd.yml \
	                  --extra-vars="global_env_system=$(SYSTEM) global_env_depl=$(ENVIRONMENT)" \
	                  --tags="kubernetes-master" \
	                  --verbose $(LEVEL_INF);
	@echo "Execution Completed!"; 

provide-k8s-cluster-worker:
	#$(call external_makefile, provide-k8s-cluster-worker)

# ---------------------------------------- #
# Provide the entire structure kubernetes. #
# ---------------------------------------- #
provide-kubernetes: plan provide-setup provide-k8s-admin-client provide-k8s-cluster-solid provide-k8s-cluster-etcd provide-k8s-cluster-master provide-k8s-cluster-worker

provide-kubernetes-services:
	#$(call external_makefile, provide-kubernetes-services)

provide-kubernetes-business:
	#$(call external_makefile, provide-kubernetes-business)

# PROVISIONING NEW MEMBERS KUBERNETES 

provide-k8s-new-member-etcd:
	#$(call external_makefile, provide-k8s-new-member-etcd)

provide-k8s-new-member-master:
	#$(call external_makefile, provide-k8s-new-member-master)

provide-k8s-new-member-worker:
	#$(call external_makefile, provide-k8s-new-member-worker)


# provide-ping: plan
# 	@echo "Initiating the testing of "ping" on all host on the infrastructure...";
# 	-@ansible -i $(INVENTORY_FILE) all -m ping $(LEVEL_INF);
# 	-@ansible -i $(INVENTORY_FILE) all -m shell -a 'free -m' $(LEVEL_INF);
# 	@echo "Execution Completed!"; 

# provide-setup: plan
# 	@echo "Initiating the execution of the "setup" ansible command...";
# 	-@ansible -i $(INVENTORY_FILE) all -m setup $(LEVEL_INF);
# 	-@echo -n "--Facts generated:" && ls -R ~/.ansible/custom-fact-caching;
# 	@echo "Execution Completed!"; 

# provide-admin-client: plan
# 	@echo "Initiating the installation of the administrators clients...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-admin-client.yml --ask-become-pass $(LEVEL_INF);
# 	@echo "Execution Completed!"; 

# provide-basic-environment: plan
# 	@echo "Initiating the installation and basic configurations of the cluster and the initial preparation of the environment...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-basic-environment.yml $(LEVEL_INF);
# 	@echo "Execution Completed!"; 

# provide-cluster-etcd: plan
# 	@echo "Initiating the provisioning of the Etcd cluster...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-cluster-etcd.yml $(LEVEL_INF);
# 	@echo "Execution Completed!"; 

# provide-cluster-k8s-master: plan
# 	@echo "Initiating the provisioning of the Kubernetes Master cluster...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-cluster-k8s-master.yml $(LEVEL_INF);
# 	@echo "Execution Completed!"; 

# provide-cluster-k8s-worker: plan
# 	@echo "Initiating the provisioning of the Kubernetes Worker cluster...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-cluster-k8s-worker.yml $(LEVEL_INF);
# 	@echo "Execution Completed!"; 

# # Provision the entire kubernetes cluster structure in a single command.
# provide-cluster-k8s-all: plan provide-ping provide-setup provide-admin-client provide-basic-environment provide-cluster-etcd provide-cluster-k8s-master provide-cluster-k8s-worker

# provide-services-k8s: plan
# 	@echo "Initiating the provisioning of the Services Kubernetes...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-services-k8s.yml $(LEVEL_INF);
# 	@echo "Execution Completed!"; 


# # PROVISIONING NEW MEMBERS KUBERNETES *************************

# provide-new-member-etcd: plan
# 	@echo "Initiating the provisioning of new Etcd members for the Etcd cluster...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-new-member-etcd.yml $(LEVEL_INF);
# 	@echo "Execution Completed!"; 

# provide-new-member-master: plan
# 	@echo "Initiating the provisioning of new Master members for the Kubernetes cluster...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-new-member-k8s-master.yml $(LEVEL_INF);
# 	@echo "Execution Completed!";

# provide-new-member-worker: plan
# 	@echo "Initiating the provisioning of new Worker members for the Kubernetes cluster...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-new-member-k8s-worker.yml $(LEVEL_INF);
# 	@echo "Execution Completed!"; 


# # PROVISIONING OF BASIC TESTING *******************************

# # Provisioning a simple test.
# provide-testing: plan
# 	@echo "Initiating a playbook for running testing...";
# 	@ansible-playbook -i $(INVENTORY_FILE) $(PLAYBOOKS_DIR)/provide-testing.yml $(LEVEL_INF);
# 	@echo "Execution Completed!";


# # VIEW DOCUMENTATION ******************************************

# #FONT: https://github.com/ceph/ceph-container/blob/master/Makefile#L128
# help:
# 	@echo ' '
# 	@echo 'Usage: make <TARGETS> ... [OPTIONS]'
# 	@echo ' '
# 	@echo 'TARGETS:'
# 	@echo ' '
# 	@echo '  Infrastructure:'
# 	@echo '     machines-status   Starts view of virtual machines status.'
# 	@echo '     machines-up       Starts the rise of virtual machines.'
# 	@echo '     machines-reload   Starts the reload of virtual machines.'
# 	@echo '     machines-off      Starts the shutdown of virtual machines.'
# 	@echo '     machines-destroy  Starts the destroy of virtual machines.'
# 	@echo ' '
# 	@echo '  Provisioning K8s with Ansible:'
# 	@echo '     provide-ping                Starts the testing of "ping" on all host on the infrastructure.'
# 	@echo '     provide-setup               Starts the execution of the "setup" ansible command.'
# 	@echo '     provide-admin-client        Starts the installation of the administrators clients.'
# 	@echo '     provide-basic-environment   Starts the installation and basic configurations of the cluster and the initial preparation of the environment.'
# 	@echo '     provide-cluster-etcd        Starts the provisioning of the Etcd cluster.'
# 	@echo '     provide-cluster-k8s-master  Starts the provisioning of the Kubernetes Master cluster.'
# 	@echo '     provide-cluster-k8s-worker  Starts the provisioning of the Kubernetes Worker cluster.'
# 	@echo '     provide-cluster-k8s-all     Starts the provisioning the entire kubernetes cluster structure in a single command.'
# 	@echo '     provide-services-k8s        Starts the provisioning of the Services Kubernetes.'
# 	@echo ' '
# 	@echo '  Provisioning new members K8s with Ansible:'
# 	@echo '     provide-new-member-etcd    Starts the provisioning of new Etcd members for the Etcd cluster.'
# 	@echo '     provide-new-member-master  Starts the provisioning of new Kubernetes Master members for the Kubernetes cluster.'
# 	@echo '     provide-new-member-worker  Starts the provisioning of new Kubernetes Worker members for the Kubernetes cluster.'
# 	@echo ' '
# 	@echo '  Run chain of tests:'
# 	@echo '     provide-testing    Starts the running a chain of tests.'
# 	@echo ' '
# 	@echo '  View details:'
# 	@echo '     plan    The default values to be used by this Makefile.'
# 	@echo ' '
# 	@echo '  Help:'
# 	@echo '     help    Print this help message.'
# 	@echo ' '
# 	@echo 'OPTIONS:'
# 	@echo ' '
# 	@echo '   ENVIRONMENT        Specifies the type of environment variable for the Kubernetes deployment, the default is [development].'
# 	@echo '   WORKING_DIRECTORY  Specify the current working directory, the default is [`pwd`].'
# 	@echo '   INVENTORY_FILE     Specifies the inventory path according to the deployment environment variable.'
# 	@echo '   PLAYBOOKS_DIR      Specifies the base path of the playbooks.'
# 	@echo '   LEVEL_INF          Parameter that defines the amount of information that will be shown on the screen'  
# 	@echo '                      while the playbook runs, and can go up to -vvvv (1-4v), the default is [EMPTY].'
# 	@echo '   PARAM              Specify the host domain in the <TARGETS> call of infrastructure, the default is [EMPTY], examples:'
# 	@echo '                         Ex 1: make machines-up PARAM="etcd03.virtual.com" '
# 	@echo '                         Ex 1: make machines-off PARAM="worker02.virtual.com" '
# 	@echo ' '


# # VIEW DOCUMENTATION ******************************************

# #FONT: https://github.com/ceph/ceph-container/blob/master/Makefile#L128
# help:
# 	@echo ' '
# 	@echo 'Usage: make <TARGETS> ... [OPTIONS]'
# 	@echo ' '
# 	@echo 'TARGETS:'
# 	@echo ' '
# 	@echo '  Infrastructure:'
# 	@echo '     machines-status   Starts view of virtual machines status.'
# 	@echo '     machines-up       Starts the rise of virtual machines.'
# 	@echo '     machines-reload   Starts the reload of virtual machines.'
# 	@echo '     machines-off      Starts the shutdown of virtual machines.'
# 	@echo '     machines-destroy  Starts the destroy of virtual machines.'
# 	@echo ' '
# 	@echo '  Provisioning K8s with Ansible:'
# 	@echo '     provide-ping                Starts the testing of "ping" on all host on the infrastructure.'
# 	@echo '     provide-setup               Starts the execution of the "setup" ansible command.'
# 	@echo '     provide-admin-client        Starts the installation of the administrators clients.'
# 	@echo '     provide-basic-environment   Starts the installation and basic configurations of the cluster and the initial preparation of the environment.'
# 	@echo '     provide-cluster-etcd        Starts the provisioning of the Etcd cluster.'
# 	@echo '     provide-cluster-k8s-master  Starts the provisioning of the Kubernetes Master cluster.'
# 	@echo '     provide-cluster-k8s-worker  Starts the provisioning of the Kubernetes Worker cluster.'
# 	@echo '     provide-cluster-k8s-all     Starts the provisioning the entire kubernetes cluster structure in a single command.'
# 	@echo '     provide-services-k8s        Starts the provisioning of the Services Kubernetes.'
# 	@echo ' '
# 	@echo '  Provisioning new members K8s with Ansible:'
# 	@echo '     provide-new-member-etcd    Starts the provisioning of new Etcd members for the Etcd cluster.'
# 	@echo '     provide-new-member-master  Starts the provisioning of new Kubernetes Master members for the Kubernetes cluster.'
# 	@echo '     provide-new-member-worker  Starts the provisioning of new Kubernetes Worker members for the Kubernetes cluster.'
# 	@echo ' '
# 	@echo '  Run chain of tests:'
# 	@echo '     provide-testing    Starts the running a chain of tests.'
# 	@echo ' '
# 	@echo '  View details:'
# 	@echo '     plan    The default values to be used by this Makefile.'
# 	@echo ' '
# 	@echo '  Help:'
# 	@echo '     help    Print this help message.'
# 	@echo ' '
# 	@echo 'OPTIONS:'
# 	@echo ' '
# 	@echo '   ENVIRONMENT        Specifies the type of environment variable for the Kubernetes deployment, the default is [development].'
# 	@echo '   WORKING_DIRECTORY  Specify the current working directory, the default is [`pwd`].'
# 	@echo '   INVENTORY_FILE     Specifies the inventory path according to the deployment environment variable.'
# 	@echo '   PLAYBOOKS_DIR      Specifies the base path of the playbooks.'
# 	@echo '   LEVEL_INF          Parameter that defines the amount of information that will be shown on the screen'  
# 	@echo '                      while the playbook runs, and can go up to -vvvv (1-4v), the default is [EMPTY].'
# 	@echo '   PARAM              Specify the host domain in the <TARGETS> call of infrastructure, the default is [EMPTY], examples:'
# 	@echo '                         Ex 1: make machines-up PARAM="etcd03.virtual.com" '
# 	@echo '                         Ex 1: make machines-off PARAM="worker02.virtual.com" '
# 	@echo ' '
