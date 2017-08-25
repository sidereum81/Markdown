Python
======
Lessons learned when programming Python. There will probably be comparisons to Java through out this document.

Running commands in prompt
--------------------------
shlex.split (shlex.split(command)) is used to split the command in a shell like syntax
[https://docs.python.org/2/library/shlex.html](https://docs.python.org/2/library/shlex.html)

subprocess.Popen is used to run a command in console
[https://docs.python.org/2/library/subprocess.html](https://docs.python.org/2/library/subprocess.html)

Error handling
--------------
[https://docs.python.org/2/tutorial/errors.html](https://docs.python.org/2/tutorial/errors.html)


Code snippets
-------------

import os
import subprocess
import shlex

class ReadCpuInfo(object):
    
    def __init__(self, logpath):
        self._logpath = logpath
        self._cpuinfo = None
        self._log_file_path = "/home/kenneth/debug.txt"
        self._log_file = None

    def read_cpu_info(self):
        command = "ls"
        # command = "os.path.expanduser('~')."
        print(command)
        self._log_file = open(self._log_file_path, "w")
        # self._cpu_info = subprocess.call(["ls", "-l"], stdout=self._log_file)
        self._cpu_info = subprocess.Popen(shlex.split(command), stderr=subprocess.STDOUT, stdout=self._log_file)

# def main():
test = ReadCpuInfo("/home/kenneth/")
test.read_cpu_info()


==================================================

#!/usr/bin/env python

import logging
import time
import sys
import os
from datetime import timedelta
import subprocess
import shlex

class Experiment():

    def __init__(self):
        self._logpath = "/home/kenneth/debug.txt"
        self._cpu_load = None

    def getUptime(self):
        print("getUptime")
        with open('/proc/uptime', 'r') as f:
            uptime_seconds = float(f.readline().split()[0])
            uptime_string = str(timedelta(seconds=uptime_seconds))
        print(uptime_string)

    def getCpuLoad(self):
        print ("getCpuLoad")
        command = "uptime"
        proc = subprocess.Popen(shlex.split(command), stderr=subprocess.STDOUT, stdout=subprocess.PIPE)
        shell_response = proc.stdout.read()
        load_average = shell_response.split( )
        load_average2 = load_average[-5:]
        load_average3 = b" ".join(load_average2)
        print(load_average3)

    def getMemStatus(self):
        print ("getMemStatus")
        command = "cat /proc/meminfo"
        proc = subprocess.Popen(shlex.split(command), stderr=subprocess.STDOUT, stdout=subprocess.PIPE)
        shell_response = proc.stdout.read()
        split_shell_response = shell_response.splitlines()
        mem_status = split_shell_response[:2]
        mem_status2 = b" ".join(mem_status)
        print(mem_status2)
        
if __name__ == "__main__":
    Experiment().getUptime()
    Experiment().getCpuLoad()
    Experiment().getMemStatus()