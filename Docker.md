

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

Docker installation
===================

[Docker post install guide](https://docs.docker.com/engine/installation/linux/linux-postinstall/)