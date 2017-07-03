 CI
====
Different CI tools are described and explored.

Gerrit
------

A lot of configuraion and management are done in the CLI. For instance the project.config file is not possible to edit in 
Gerrit gui until it has the verified label. 
And to edit the project.config file you need to follow the steps below:


mkdir tmp
cd tmp
git init
git remote add origin ssh://admin@remote.site.com:29418/All-Projects
git fetch origin refs/meta/config:refs/remotes/origin/meta/config
git checkout meta/config

remember to add 


Jenkins
-------

======================================
ls -la
export WORKSPACE_ROOT=$(pwd)

## Initialize Repo and vendor/volvocars
#
# Important to initialize the repository with "repo init" "repo sync" instead of standard "git init", 
# otherwise repo get confused (repo assumes .git-data is in .repo/project-objects/).
# Reset the manifest-repo in case it was modified in a strange way from last commit
cd .repo/manifests && git reset --hard origin/master || true
cd ${WORKSPACE_ROOT}
repo init -u ssh://gotsvl1415.got.volvocars.net:29421/manifest -b master
repo sync vendor/volvocars

## Download the commit to check
#
# zuul-cloner implicity uses other environment variables as well, such as ZUUL_REF. 
GIT_SSH=/cm/zuul_stuff/ssh_wrapper.sh /cm/virtualenv_zuul/bin/zuul-cloner $ZUUL_URL vendor/volvocars

## Update the manifests based on the templates and download all other repositories
# First time this will take a very long time but subsequent downloads are incremental and faster
#
cd ${WORKSPACE_ROOT}
python3 ./vendor/volvocars/tools/ci/shipit/bump.py . local

## Build image
#
export DOCKER_HOST="tcp://127.0.0.1:2375" # Not required after reboot of gotsvl1416
./vendor/volvocars/tools/ci/jenkins/commit_test.sh


# Commented out because we are not building "flashfiles" for now
#mkdir -p jenkins_stash
#export dest_file_name="flashfiles-$(uuidgen).zip"
#echo ${dest_file_name} > jenkins_stash/dest_file_name
#scp out/target/product/ihu_abl_car/ihu_abl_car-flashfiles-eng.ihu.zip blade@10.246.65.176:/home/blade/jenkins_slave/${dest_file_name} '''
======================================

env
pwd
ls -la
export WORKSPACE_ROOT=$(pwd)


## Initialize Repo and vendor/volvocars
#
# Important to initialize the repository with "repo init" "repo sync" instead of standard "git init", 
# otherwise repo get confused (repo assumes .git-data is in .repo/project-objects/).
# Reset the manifest-repo in case it was modified in a strange way from last commit
cd .repo/manifests && git reset --hard origin/master || true
cd ${WORKSPACE_ROOT}
repo init -u ssh://gotsvl1415.got.volvocars.net:29421/manifest -b master
repo sync vendor/volvocars

## Download the commit the check
#
# TODO: Replace git clone with zuul-cloner once zuul is setup
#GIT_SSH=/cm/zuul_stuff/ssh_wrapper.sh /cm/virtualenv_zuul/bin/zuul-cloner http://icup_android.gerrit.cm.volvocars.biz $ZUUL_PROJECT
GIT_SSH=/cm/zuul_stuff/ssh_wrapper.sh /cm/virtualenv_zuul/bin/zuul-cloner $ZUUL_URL vendor/volvocars
#zuul-cloner $ZUUL_URL vendor/volvocars
#cd vendor/volvocars
#git remote add gerrit ssh://gotsvl1415.got.volvocars.net:29421/vendor/volvocars  || true
#git fetch --tags --progress gerrit ${GERRIT_REFSPEC}
#git checkout ${GERRIT_PATCHSET_REVISION}

## Update the manifests based on the templates and download all other repositories
# First time this will take a very long time but subsequent downloads are incremental and faster
#
cd ${WORKSPACE_ROOT}
python3 ./vendor/volvocars/tools/ci/shipit/bump.py . local

## Build image
#
export DOCKER_HOST="tcp://127.0.0.1:2375" # Not required after reboot of gotsvl1416
./vendor/volvocars/tools/ci/jenkins/commit_test.sh


# Commented out because we are not building "flashfiles" for now
#mkdir -p jenkins_stash
#export dest_file_name="flashfiles-$(uuidgen).zip"
#echo ${dest_file_name} > jenkins_stash/dest_file_name
#scp out/target/product/ihu_abl_car/ihu_abl_car-flashfiles-eng.ihu.zip blade@10.246.65.176:/home/blade/jenkins_slave/${dest_file_name} '''
============================================================


Jenkins job builder and Zuul
----------------------------

**How to configure a job to be triggered by Zuul**

https://docs.openstack.org/infra/jenkins-job-builder/zuul.html

**Parameters expected by Zuul**

https://docs.openstack.org/infra/zuul/launchers.html#zuul-parameters

**Jenkins job builder - Triggers**

https://docs.openstack.org/infra/jenkins-job-builder/triggers.html

**Jenkins job builder -- definitions**

https://docs.openstack.org/infra/jenkins-job-builder/definition.html

*Raw config*
It is possible, but not recommended, to use raw within a module to inject raw xml into the job configs.
This is relevant in case there is no appropriate module for a Jenkins plugin or the module does not behave as you expect it to do.

**Jenkins job builder -- Builders**

https://docs.openstack.org/infra/jenkins-job-builder/builders.htmls


Builders - actions that the job should do.
Publishers - actions to do after build is complete

**Jenkins job builder examples**

https://github.com/arilivigni/jjb_demo

Project are used to collect different of related jobs together.
It is possible, but not recommended, to use raw within a module to inject raw xml into the job configs.
This is relevant in case there is no appropriate module for a Jenkins plugin or the module does not behave as you expect it to do.

Jfrog - Artifaktory
https://www.ansible.com/it-automation

Coverity - Lint
Valgrind
Jenkins job builder
Behave

Jenkins
-------
https://jenkins.io/doc/book/pipeline/

Zuul
----
https://launchpad.net/zuul
https://github.com/openstack-infra/zuul
Docs https://docs.openstack.org/infra/zuul/
https://github.com/openstack/openstack-ci-puppet not working
https://github.com/openstack/puppet-openstack-integration
freenode #openstack-infra

GoCD
----
https://docs.gocd.io/current/
https://highops.com/insights/continuous-delivery-pipelines-gocd-vs-jenkins/

Continuous Integration/Deliviery articles
-----------------------------------------
https://martinfowler.com/bliki/DeploymentPipeline.html
https://martinfowler.com/bliki/ContinuousDelivery.html


Complete CI chain
-----------------
https://blogs.rdoproject.org/7542/dive-into-zuul-gated-commit-system-2
https://github.com/Combitech/codefarm


Gearman plugin
https://wiki.jenkins-ci.org/display/JENKINS/Gearman+Plugin