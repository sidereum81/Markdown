

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


