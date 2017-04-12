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