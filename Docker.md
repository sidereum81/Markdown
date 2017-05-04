

Docker description
==================
Docker shares resources with the host, virtual machines gets dedicated resources.

Images and containers
---------------------
[Understand images, containers, and storage drivers](https://docs.docker.com/engine/userguide/storagedriver/imagesandcontainers/)
What is usually refered to as Docker is actually the Docker Engine.

The link shows the difference between images, containers and storage drivers. The conatiners consists of Read Only images and a container layer that 
is writable. So different containers can share the same underlying image.

The storage driver is responsible for both the image layers and the writable container.

Docker commands
===============
docker run -t -i ubuntu  --- *run an ubuntu image with interactive CLI* 
docker run -it --rm alpine /bin/ash
docker run --net=host -ti ubuntu
sudo restart docker



Docker installation
===================

[Docker post install guide](https://docs.docker.com/engine/installation/linux/linux-postinstall/)

Docker under the hood
=====================
How docker works in Linux

Namespaces
----------
Namespace is a kernel feature.
With Namespaces Linux enables separation between processes in Linux. PID with namespace isolation does not anything
about the parent PID.

[A good explanation of namespaces](https://www.toptal.com/linux/separation-anxiety-isolating-your-system-with-linux-namespaces)

Cgroups
-------
Cgroups is a kernel feature.
With Cgroups linux can allocate resources to different processes. Cgroups has an hierchial structure, but unlike the 
process tructure the Cgroups can have independent and separate hierarchies of cgroups.

Troubleshooting
===============
When running images at work they did not have access to the internet, through Virtualbox and Ubuntu. 
The problem was that the docker images used the wrong DNS server.

The solution is to identify the DNS server used on host (Ubuntu) and add it to the docker configuration file
*/etc/docker/daemon.json*. If it does not exit, simply create it. Add the line below.

```json
{
    "dns": ["10.0.0.6", "8.8.8.8"]
}
```
Restarte the docker server:
*sudo service docker restart*

Identify the hosts DNS server:
nmcli device show <interfacename> | grep IP4.DNS

Behind a proxy server
---------------------

Alpine Linux
apt package will not work behind proxy, just run the command below to fix it.
export http_proxy=http://10.203.0.1:5187/

Ubuntu
apt-get behind a proxy could need an update by adding 

Acquire::http::Proxy "http://gotpr002vip.got.volvocars.net:83/";
at /etc/apt/apt.conf

However it could still not work because of DNS-problem. Use nslookup to get the IP address instead of hyperlink.
echo 'Acquire::http::Proxy "http://10.244.0.55:83/";' >> /etc/apt/apt.conf
