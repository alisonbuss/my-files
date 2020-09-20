
#### Translation for: **[English](https://github.com/alisonbuss/cluster-kubernetes-ansible-vagrant/blob/master/README_LANG_EN.md)**.

#### Status do Projeto: *(Em Desenvolvimento)*.

# Project: cluster-kubernetes-ansible-vagrant

## Esse projeto se utiliza de um Vagrant Box gerado pelo projeto: **[coreos-packer](https://github.com/alisonbuss/coreos-packer/)**.

## ...

https://leucos.github.io/ansible-files-layout

Projeto de "Infrastructure as Code (IaC)" usando Vagrant e Ansible para provisionar um cluster CoreOS(Etcd) e fornecer os serviços (rkt, flannel, etcd3, docker, peervpn) para ambiente VirtualBox.

## ...


          K5:
            Packer >> Terraform >> Machines(IPs) >> Ansible >> Kubernetes >> NEGÓCIOS!!!!

            - Makefile - ENVIRONMENT VARIABLES

                - SYSTEM=coreos            # (CoreOS, CentOS, Ubuntu)
                - PLATFORM=vagrant         # (vagrant, aws, google, digitalocean)
                - ENVIRONMENT=development  # (development, staging, production)

            - Makefile - Packer

                - publish-image-coreos
                - publish-image-centos
                - publish-image-ubuntu

            - Makefile - Terraform

                - machines-plan
                - machines-status
                - machines-up
                - machines-reload
                - machines-off
                - machines-destroy
                - machines-test

            - Makefile - Ansible

                - provide-ping
                - provide-setup
                - provide-reboot
                - provide-info
                - provide-test

            - Makefile - Ansible - kubernetes

                - provide-k8s-admin-client
                - provide-k8s-basic-environment
                - provide-k8s-cluster-etcd
                - provide-k8s-cluster-master
                - provide-k8s-cluster-worker
                - provide-k8s-new-member-etcd
                - provide-k8s-new-member-master
                - provide-k8s-new-member-worker
                - provide-kubernetes

            - Makefile - Ansible - kubernetes - Service

                - provide-kubernetes-services

            - Makefile - Ansible - kubernetes - Business

                - provide-kubernetes-business

] 
















## ...


# ansible -i ./inventories/development/hosts all -m ping

https://www.ostechnix.com/configure-static-dynamic-ip-address-arch-linux/
sudo systemctl list-unit-files

sudo journalctl -u etcd2

networkctl status --all

sudo journalctl -k -f

sudo journalctl -k -f | grep IPTABLE_INPUT

sudo journalctl -k | grep IPTABLE_INPUT

sudo cat /usr/lib/sysctl.d/baselayout.conf
sudo cat /usr/share/baselayout/sudoers

sudo cut -d : -f 1,5 /etc/passwd | tr : \\\t
sudo getent passwd | cut -d \: -f1
sudo getent passwd


kubectl get componentstatuses

kubectl get nodes
kubectl get nodes -o wide

kubectl get nodes --output=jsonpath='{range .items[*]}{.status.addresses[?(@.type=="InternalIP")].address} {.spec.podCIDR} {"\n"}{end}'


kubectl get pods --namespace=kube-system


kubectl get pods -o wide --namespace=kube-system

kubectl get pods 
kubectl get pods -o wide 

kubectl get all -o wide

kubectl run my-nginx --image=nginx --replicas=2 --port=80
kubectl expose rc my-nginx --port=80
kubectl describe pod my-nginx

kubectl get pods --all-namespaces

kubectl get services

kubectl get daemonsets -n=kube-system

kubectl get deployments -n=kube-system

kubectl config list-clusters
kubectl config list-contexts
"kubectl config unset" takes a dot-delimited path. You can delete cluster/context/user entries by name. E.g.
kubectl config unset users.gke_project_zone_name
kubectl config unset contexts.aws_cluster1-kubernetes
kubectl config unset clusters.foobar-baz

kubectl config view
kubectl config get-clusters 
kubectl config get-contexts

kubectl port-forward traefik-ingress-controller-wqsxt 8080:8080 --namespace=kube-system

$ kubectl expose deployment example-app --port 80

kubectl logs traefik-ingress-controller-wqsxt --namespace=kube-system

kubectl get secret --namespace=kube-system traefik-etcd



### Referências:

https://x-team.com/blog/introduction-kubernetes-architecture/
https://medium.com/@tsuyoshiushio/kubernetes-in-three-diagrams-6aba8432541c

https://github.com/coreos/coreos-kubernetes/issues/372
https://stackoverflow.com/questions/24490862/shared-storage-with-coreos
https://coreos.com/os/docs/latest/mounting-storage.html
https://www.evergreenitco.com/evergreenit-blog/2016/9/9/my-journey-into-the-world-of-containers-docker-coreos-and-kubernetes-part-2
https://debian-handbook.info/browse/pt-BR/stable/sect.nfs-file-server.html
https://knowledgelayer.softlayer.com/es/procedure/mounting-storage-coreos
https://blog.scottlowe.org/2015/02/20/config-mount-nfs-coreos/
https://severalnines.com/blog/installing-kubernetes-cluster-minions-centos7-manage-pods-services
https://severalnines.com/blog/wordpress-application-clustering-using-kubernetes-haproxy-and-keepalived

https://churrops.io/2018/02/04/primeiros-passos-com-ansible-configurando-e-gerenciando-nginx/



* Packer - Official Site, Packer Documentation. ***Welcome to the Packer documentation!*** <br/>
  Acessado: *Sei lá da pesti, foi em 2017 por ai...* <br/>
  Disponível: *[https://www.packer.io/docs/index.html](https://www.packer.io/docs/index.html)*

* Professor José de Assis - YouTube, Playlist ***Curso - Primeiros passos com Servidor Linux*** <br/>
  Acessado: *Sei lá da pesti, foi em 2017 por ai...* <br/>
  Disponível: *[https://www.youtube.com/playlist?list=PLbEOwbQR9lqy926a_ArLcUL2gHJYuu8XK](https://www.youtube.com/playlist?list=PLbEOwbQR9lqy926a_ArLcUL2gHJYuu8XK)*

* Aula EAD Blog, Curso com José de Assis, ***Primeiros passos com Servidor Linux*** <br/>
  Acessado: *Sei lá da pesti, foi em 2017 por ai...* <br/>
  Disponível: *[http://www.aulaead.com/courses/curso-gratis-servidor-linux](http://www.aulaead.com/courses/curso-gratis-servidor-linux)*

* Vagrant - Official Site, Vagrant Documentation. ***Command-Line Interface*** <br/>
  Acessado: *Sei lá da pesti, foi em 2017 por ai...* <br/>
  Disponível: *[https://www.vagrantup.com/docs/cli/](https://www.vagrantup.com/docs/cli/)*

* Yet Emerging Technologies - Blog, by Sébastien Braun. ***CoreOS Container Linux*** <br/>
  Acessado: *Sei lá da pesti, foi em 2018 por ai...* <br/>
  Disponível: *[http://www.yet.org/2017/03/01-container-linux/](http://www.yet.org/2017/03/01-container-linux/)*

* ChurrOps on DevOps, Blog. ***[Packer] Customizando e automatizando suas imagens - Parte 1*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://churrops.io/2017/10/13/packer-customizando-e-automatizando-suas-imagens-parte-1/](https://churrops.io/2017/10/13/packer-customizando-e-automatizando-suas-imagens-parte-1/)*.

* Giovanni dos Reis Nunes, Blog. ***Introdução ao Packer*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://giovannireisnunes.wordpress.com/2016/05/27/introducao-ao-packer/](https://giovannireisnunes.wordpress.com/2016/05/27/introducao-ao-packer/)*.

* Ricardo Martins, Blog. ***Conhecendo o Terraform, Packer e Ansible*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[http://www.ricardomartins.com.br/conhecendo-o-terraform-packer-e-ansible/](http://www.ricardomartins.com.br/conhecendo-o-terraform-packer-e-ansible/)*.

* Andre Tadeu, Blog. ***Packer – um breve tutorial*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://andretdecarvalho.wordpress.com/2014/03/25/packer-um-breve-tutorial/](https://andretdecarvalho.wordpress.com/2014/03/25/packer-um-breve-tutorial/)*.

* CoreOS, Container Linux. ***Using Cloud-Config*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://coreos.com/os/docs/latest/cloud-config.html](https://coreos.com/os/docs/latest/cloud-config.html)*.

* CoreOS, Container Linux. ***Migrating from Cloud-Config to Container Linux Config*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://coreos.com/os/docs/latest/migrating-to-clcs.html](https://coreos.com/os/docs/latest/migrating-to-clcs.html)*.

* DigitalOcean, Tutorials. ***How To Secure Your CoreOS Cluster with TLS/SSL and Firewall Rules*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://www.digitalocean.com/community/tutorials/how-to-secure-your-coreos-cluster-with-tls-ssl-and-firewall-rules](https://www.digitalocean.com/community/tutorials/how-to-secure-your-coreos-cluster-with-tls-ssl-and-firewall-rules)*.

* CoreOS, Container Linux. ***Generate self-signed certificates*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://coreos.com/os/docs/latest/generate-self-signed-certificates.html](https://coreos.com/os/docs/latest/generate-self-signed-certificates.html)*.

* CoreOS, etcd. ***Enabling HTTPS in an existing etcd cluster*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://coreos.com/etcd/docs/latest/etcd-live-http-to-https-migration.html](https://coreos.com/etcd/docs/latest/etcd-live-http-to-https-migration.html)*.

* CoreOS, etcd. ***Configure CoreOS Container Linux components to connect to etcd with TLS*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://coreos.com/etcd/docs/latest/tls-etcd-clients.html](https://coreos.com/etcd/docs/latest/tls-etcd-clients.html)*.

* Swaathi Kakarla, Blog. ***Securing your CoreOS Container*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://www.twistlock.com/2017/10/16/securing-coreos-container/](https://www.twistlock.com/2017/10/16/securing-coreos-container/)*.

* Matt Carrier, Blog. ***Setup CoreOS with iptables on DigitalOcean*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://mattcarrier.com/post/core-os-iptables/](https://mattcarrier.com/post/core-os-iptables/)*.

* Jimmy Cuadra, Blog. ***Securing CoreOS with iptables*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://www.jimmycuadra.com/posts/securing-coreos-with-iptables/](https://www.jimmycuadra.com/posts/securing-coreos-with-iptables/)*.

* Netroby, Blog. ***CoreOS sshd security configure guide*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://www.netroby.com/view/3814](https://www.netroby.com/view/3814)*.

* KYLE, Blog. ***USING CLOUD CONFIG WITH COREOS*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://www.programminggoalie.com/cloud-config-coreos-digitalocean/](https://www.programminggoalie.com/cloud-config-coreos-digitalocean/)*.

* Robert, Blog. ***CoreOS Iptables*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[http://palex.nl/securing-coreos/](http://palex.nl/securing-coreos/)*

* Skrobul, Blog. ***Deploying CoreOS cluster with etcd secured by TLS/SSL*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[http://blog.skrobul.com/securing_etcd_with_tls/](http://blog.skrobul.com/securing_etcd_with_tls/)*.

* gar, Blog. ***CoreOS Etcd and Fleet with Encryption and Authentication*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://medium.com/@gargar454/coreos-etcd-and-fleet-with-encryption-and-authentication-27ffefd0785c](https://medium.com/@gargar454/coreos-etcd-and-fleet-with-encryption-and-authentication-27ffefd0785c)*.

* Tomasre, Blog. ***Securing CoreOS with Iptables*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[http://tomasre.com/2016/03/07/securing-coreos-with-iptables/](http://tomasre.com/2016/03/07/securing-coreos-with-iptables/)*.

* BLAZED’S TECH, Blog. ***CoreOS, Iptables and Vulcand*** <br/>
  Acessado: *17 de Dezembro de 2017*. <br/>
  Disponível: *[https://darkstar.se/2015/02/06/coreos-iptables-and-vulcand/](https://darkstar.se/2015/02/06/coreos-iptables-and-vulcand/)*.










https://vsupalov.com/packer-ami/

- basic technology.


- service technology.

http://www.zdnet.com/article/snappy-ubuntu-challenges-coreos-and-project-atomic-on-lightweight-cloud-servers/
https://blog.codeship.com/container-os-comparison/
https://dcos.io/


Entendimento:
https://coreos.com/blog/cluster-osi-model.html


http://virtualelephant.com/2017/11/13/infrastructure-as-code-project-overview/
http://virtualelephant.com/2017/11/14/infrastructure-as-code-bootstrap-coreos-with-ignition/
http://virtualelephant.com/2017/11/16/infrastructure-as-code-understanding-coreos-ignition/
https://vadosware.io/post/installing-python-on-coreos-with-ansible/
http://www.hanymichaels.com/2017/11/02/kubernetes-in-the-enterprise-the-design-guide/




http://bitcubby.com/configuring-vagrant-json-ruby/
https://github.com/tkambler/perfect-vagrant 
https://blog.scottlowe.org/2016/01/18/multi-machine-vagrant-json/ 
https://thornelabs.net/2014/11/13/multi-machine-vagrantfile-with-shorter-cleaner-syntax-using-json-and-loops.html

https://www.tecmint.com/commands-to-collect-system-and-hardware-information-in-linux/

https://grafana.com/

https://5pi.de/2016/11/20/15-producation-grade-kubernetes-cluster/

https://www.youtube.com/watch?v=A760lwRDg9U
https://www.youtube.com/watch?v=C20Ia-OqZt0

https://cloud.google.com/solutions/automated-build-images-with-jenkins-kubernetes

https://cloud.google.com/solutions/jenkins-on-kubernetes-engine#deploying_kubernetes_engine_clusters

https://5pi.de/2016/11/20/15-producation-grade-kubernetes-cluster/





https://github.com/kelseyhightower/kubestack/blob/master/packer/kubestack.json

https://github.com/ainoya/aws-coreos-clustering-kit/

https://github.com/cloudurable/cassandra-image/wiki/Using-Packer-to-create-an-AMI-for-Amazon---EC2
https://github.com/cloudurable/cassandra-image

https://github.com/dyson/packer-qemu-coreos-container-linux

https://github.com/stylelab-io/kubernetes-coreos-packer

https://github.com/brikis98/terraform-up-and-running-code

https://github.com/kaorimatz/packer-templates/

https://github.com/wasbazi/coreos-packer

https://github.com/kevit/coreos-packer

https://github.com/flomotlik/packer-example

http://www.codedependant.net/2016/06/29/coreos-a-year-in-review/

https://www.infoq.com/br/search.action?queryString=API+Gateway&page=1&searchOrder=&sst=KYiYsc1qHfkIyyf8

http://gutocarvalho.net/blog/2016/09/06/por-onde-iniciar-os-estudos-sobre-devops/
https://www.alura.com.br/carreira-engenheiro-devops
https://dev9.com/blog-posts/2016/6/introduction-to-kong-api-gateway
https://www.nginx.com/blog/microservices-api-gateways-part-1-why-an-api-gateway/
https://www.nginx.com/blog/microservices-api-gateways-part-2-how-kong-can-help/

USAR ESSE AKI
https://konghq.com/kong-community-edition/
https://pantsel.github.io/konga/
https://pantsel.github.io/konga/
https://gravitee.io/
http://wicked.haufe.io/
https://www.fusio-project.org/
http://www.apiman.io/latest/index.html

https://sensedia.com/blog/apis/owasp-2017-top-10-riscos-seguranca-apis/

https://dev9.com/blog-posts/2016/6/introduction-to-kong-api-gateway

É AKI AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA........
https://dev9.com/blog-posts/2016/6/introduction-to-kong-api-gateway
https://konghq.com/blog/protecting-rate-limiting-api-kong/

https://github.com/upmc-enterprises/kubernetes-secret-manager
https://github.com/coreos/awesome-kubernetes-extensions

https://www.youtube.com/watch?v=h4A8HytL5ts

https://tyk.io/#section-0

https://www.gluu.org/

http://www.codedependant.net/2016/06/29/coreos-a-year-in-review/

https://getkong.org/
https://pantsel.github.io/konga/
https://ajaysreedhar.github.io/kongdash/
https://medium.com/@aodjaturongvachirasaksakul/kong-free-api-gateway-28edc64f7b6e

https://github.com/coreos/awesome-kubernetes-extensions

https://apiumbrella.io/

http://www.codedependant.net/2016/06/29/coreos-a-year-in-review/


https://github.com/julienstroheker/DCOS-Azure/blob/master/packer/packer/packer.json
https://docs.microsoft.com/en-us/azure/virtual-machines/linux/build-image-with-packer
https://github.com/squasta/PackerAzureRM/blob/master/Packer-VMWin2016StanAzureBasicManagedDisk.json
https://github.com/squasta/PackerAzureRM/blob/master/Packer-VMWin2016-IIS-Azure-squasta.json
https://github.com/squasta/PackerAzureRM

https://github.com/hashicorp/packer/tree/master/examples/azure





### Licença

[<img width="190" src="https://raw.githubusercontent.com/alisonbuss/my-licenses/master/files/logo-open-source-550x200px.png">](https://opensource.org/licenses)
[<img width="166" src="https://raw.githubusercontent.com/alisonbuss/my-licenses/master/files/icon-license-mit-500px.png">](https://github.com/alisonbuss/cluster-kubernetes-ansible-vagrant/blob/master/LICENSE)
