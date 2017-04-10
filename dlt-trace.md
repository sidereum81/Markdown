DLT-tracing
===========

Sending messages to the DLT daemon
----------------------------------

=== dlt-adaptor-stdin
The dlt-adaptor-stdin is a small external program for forwarding input from stdin to DLT daemon, and can be used for e.g. sending DBUS messages to the dlt daemon using the program dbus-monitor:

$ dbus-monitor | dlt-adaptor-stdin


Links
-----
[https://at.projects.genivi.org/wiki/display/PROJ/DLT+usage+guide+and+examples](https://at.projects.genivi.org/wiki/display/PROJ/DLT+usage+guide+and+examples)
[https://at.projects.genivi.org/wiki/display/PROJ/DLT+cheatsheet](https://at.projects.genivi.org/wiki/display/PROJ/DLT+cheatsheet)
[Minimal python ctypes based example of logging to GENIVI Diagnostic Log and Trace Daemon](https://gist.github.com/lonetwin/2bfdd41da41dae326afb)
[https://github.com/GENIVI/dlt-daemon](https://github.com/GENIVI/dlt-daemon)