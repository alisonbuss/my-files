#!/bin/bash

#-----------------------|DOCUMENTATION|-----------------------#
# @descr: Script de inicialização para a construção do plugin 
#         Terraform no GoLang e redirecionamento do plugin para 
#         o Terraform.     
# @fonts: https://www.terraform.io/docs/configuration/providers.html#third-party-plugins
#         http://blog.jfabre.net/2017/01/22/writing-terraform-provider/
#         https://github.com/pyToshka/terraform-provider-virtualbox  
# @example: 
#    $ bash build.sh
#-------------------------------------------------------------#

function startBuilding {
    local pathTerraformD="${HOME}/.terraform.d/plugins";

    #echo "Instalar dependências do plugin...";
    #go get github.com/hashicorp/terraform/plugin;
    #go get github.com/hashicorp/terraform/terraform;
    #go get github.com/alisonbuss/terraform-provider-vagrant;

    echo "Construindo o plugin...";
    go build -o terraform-provider-vagrant;

    echo "Instalando o plugin no diretorio: '${pathTerraformD}'";
    mkdir -p "${pathTerraformD}";
    cp "terraform-provider-vagrant" "${pathTerraformD}/"; 
} 

startBuilding;

exit 0;