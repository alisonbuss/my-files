
#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Sua Descrição da Instalação na Maquina.
# @fonts: https://pt.wikibooks.org/wiki/Programar_em_C/Makefiles
# 		  https://blog.pantuza.com/tutoriais/como-funciona-o-makefile
#		  http://mindbending.org/pt/makefile-para-java
#		  https://www.embarcados.com.br/introducao-ao-makefile/		
# @example:
#
#-------------------------------------------------------------#

https://github.com/stylelab-io/kubernetes-coreos-terraform

# DEFAULT VARIABLES - Structural
#WORKING_DIRECTORY ?= ./
WORKING_DIRECTORY  ?= `pwd`

help:
	@echo "   --> help"; 

run: 
	@echo "   --> WORKING_DIRECTORY: $(WORKING_DIRECTORY)"; 

	@make --directory ./packer run-packer;
	@make --directory ./terraform;
	@make --directory ./provisioners run-ansible;


