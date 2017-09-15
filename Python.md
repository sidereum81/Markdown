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
import re

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
        regular_cpu_load = re.compile('.*load average:\s*([^\n\r]*)')        
        command = "uptime"
        shell_response = self.runCommand(command)
        cpu_load = re.findall(regular_cpu_load, shell_response)[0].split( )
        load_average_first_minute = cpu_load[0]
        load_average_five_minutes = cpu_load[1]
        load_average_fifteen_minutes = cpu_load[2] 

        print("Load average minute " + load_average_first_minute)
        print("Load average five minutes " + load_average_five_minutes)
        print("Load average fifteen minutes " + load_average_fifteen_minutes)


    def getCpuInfo(self):
        print("getCpuInfo")
        regular_model_name = re.compile('.*model name	:\s*([^\n\r]*)')
        regular_cpu_cores = re.compile('.*cpu cores	:\s*([^\n\r]*)')
        command = "cat /proc/cpuinfo"
        shell_response = self.runCommand(command)
        number_of_cores = re.findall(regular_cpu_cores, shell_response)[0]
        model_name = re.findall(regular_model_name, shell_response)[0]
        print("Cpu cores: " + number_of_cores)
        print("model_name: " + model_name)


    def getMemStatus(self):
        print ("getMemStatus")
        command = "free -h"
        shell_response = self.runCommand(command)
        regular = re.compile('.*Mem:\s*([^\n\r]*)')
        memory = re.findall(regular, shell_response)
        memory_list = memory[0].split( )
        total_memory = memory_list[0]
        used_memory = memory_list[1]
        print("The total memory is: " + total_memory)
        print("The used memory is: " + used_memory)


    def runCommand(self, command : str):
        shell_response = subprocess.check_output(shlex.split(command)).decode('utf-8')
        return shell_response
        

if __name__ == "__main__":
    Experiment().getUptime()
    Experiment().getCpuLoad()
    Experiment().getMemStatus()
    Experiment().getCpuInfo()