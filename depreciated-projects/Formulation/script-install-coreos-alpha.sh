#!/bin/bash

clear 
echo "Baixando o arquivo de configuração 'cloud-config.yaml'"
wget https://raw.githubusercontent.com/alisonbuss/Formulation/master/cloud-config.yaml

#sudo mv cloud-config.yaml /usr/share/oem/
#sudo cat /usr/share/oem/cloud-config.yaml
cat cloud-config.yaml

echo -ne "Deseja executar comando de instalação do CoreOS? Digite(S/N): "
read executa

if [ $executa = "s" -o $executa = "S" ]; then
    echo "Executando comando de instalação do CoreOS"
    
    #echo "Comando: 'sudo coreos-install -d /dev/sda -C alpha -c /usr/share/oem/cloud-config.yaml'"
    #sudo coreos-install -d /dev/sda -C alpha -c /usr/share/oem/cloud-config.yaml
    echo "Comando: 'sudo coreos-install -d /dev/sda -C alpha -c cloud-config.yaml'"
    sudo coreos-install -d /dev/sda -C alpha -c cloud-config.yaml
    
    echo "Instalação executada com sucesso!"
    
    echo -ne "Deseja (R)eniciar ou (D)esligar o sistema? Digite(R/D/C): "
    read desligar
    
    if [ $desligar = "r" -o $desligar = "R" ]; then
        clear 
        echo "Reniciando..."
        sudo reboot
    elif [ $desligar = "d" -o $desligar = "D" ]; then
        clear 
        echo "Desligando..."
        sudo shutdown -h now
    else
        clear 
        echo "..."
        echo "......"
        echo "........."
    fi
else
    echo "Instalação do CoreOS cancelado!"
fi
