Test Environment Principles
===========================

This document contains general solutions for test environment.

Requirement database in excel
-----------------------------
The structure in the Excel database is quite general. It has a naming convention for the columns that
is applicable for all the test cases. However, if the test environment needs to add a new requirement the database
will need to be expanded with the corresponding number of columns. The number of columns will then vary depending on the 
number of requirements of the test case.
One row contains all the requirements for the test case.


| NameTag  | ReqX_1            | ReqY_1           | ReqX_2           | ReqY_2           | ReqTypeY|
|----------|-------------------|------------------|------------------|------------------|---------|
| name1    | Req1. for X-axis  | Req1. for Y-axis | Req2. for X-axis | Req2. for Y-axis | BLER    |
| name2    | Req1. for X-axis  | Req1. for Y-axis | Req2. for X-axis | Req2. for Y-axis | BLER    |
| name3    | Req1. for X-axis  | Req1. for Y-axis | Req2. for X-axis | Req2. for Y-axis | BLER    |

Requirement database in Insight
-------------------------------

The structure for the Insight databsase is more general in a that sence that it does not require that the 
the database creates a new column when a new requirement is added. It only require a new line, which can be added
without affecting the database in whole. If a NameTag has multiple rows it will be handled as multiple requirements.


| NameTag  | ReqX              | ReqY             | ReqTypeX             | ReqTypeY             | ReqVersion|
|----------|-------------------|------------------|----------------------|----------------------|-----------|
| name1    | Req1. for X-axis  | Req1. for Y-axis | Req. type for X-axis | Req. type for Y-axis | A         |
| name1    | Req2. for X-axis  | Req2. for Y-axis | Req. type for X-axis | Req. type for Y-axis | A         |
| name2    | Req1. for X-axis  | Req1. for Y-axis | Req. type for X-axis | Req. type for Y-axis | A         |

Below is an example of how it could look in the Insight database.

| NameTag    | ReqX | ReqY | ReqTypeX | ReqTypeY | ReqVersion |
|------------|------| -----|----------|----------|------------|
| Test1_TU3  | -15  | 0.01 | EcN0     | BLER     | A          |
| Test1_TU3  | -16  | 0.1  | EcN0     | BLER     | A          |
| Test2_TU3  | -12  | 0.1  | EcN0     | BLER     | A          |

