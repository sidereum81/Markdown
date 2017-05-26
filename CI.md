 CI
====

Different CI tools are described and explored.


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