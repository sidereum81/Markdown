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

Result database in Insight
--------------------------
The result database has one row for every measurement point.

**Parameter explanation**
- JobId      : An ID for a measurement serie of test cases.
- Evaluate   : Used for seperating between measurement values and interpolated results.
- FinalVerdict : If all measurement points are passed, then FinalVerdict = PASS.
- MeasId     : Seperates different types of measurements, for instance BLER_A, BER_B, BLER_DPCCH, interpolated values etc
- MeasTime   : The measurement time for each measurement point
- SetValueX  : The value set in the instrument. Should not differ alot from MeasValueX
- MeasValueX : Measured value on X-axis, usually measured in instrument (EcN0)
- MeasValueY : Measvalue on Y-axis, usually calculated through the test environment
- ReqX       : The requriement on X-axis, specified in CRS
- ReqY       : The requriement on Y-axis, specified in CRS
- ScaleTypeY : Y-axis can be represented in Logarithmic scale and Linear scale, this tells the Dashboard what scale to SetValueX
- TestCaseStatus : If measurement is within requirement, then PASS. If measuremnt has passed requirement then N/A, used for characterization.
- Tester     : Signum of the tester

| NameTag  | CalibaritionFile   | CommitHash | DUType      | Evaluate         | FinalVerdigt           | InstrumentInformation | JobId   | MeasId | MeasTime       | MeasTypeX | MeasTypeY | MeasValueX | MeasValueY | 
|----------|--------------------|------------|-------------|------------------|------------------------|-----------------------|---------|--------|----------------|-----------|-----------|------------|------------|
| name1    | Path for cal. file | Git hash   | DU version  | INTERPOLATE/MEAS | PASS/FAIL/INCONCLUSIVE | All HW info           | JobId # | 1-5    | Time/measPoint | EcN0/EbN0 | BLER/BER  | Value      | Value      |


| RU_Type | ReqVersion  | ReqX           | ReqY           | ScaleTypeY | SetValueX  | TestCaseParametersInfo | TestCaseStatus | Tester | UP        |
|---------|-------------|----------------|----------------|------------|------------|------------------------|----------------|--------|-----------|
| -       | CRS Version | RequirementOnX | RequirementOnY | LOG/LIN    | MeasValueX | TestSuite              | PASS/FAIL/NA   | Signum | UPVersion |

Meta data store in Insight
--------------------------

To be able to compare the different results from the different test environments (BPV Light and BPV node) there is another data store called
meta data store. It contains the overal information from the different test environments. 

| Commit     | HW_DUT       | failed                | passed             | job_id  | job_name                 | job_status          | test_env          | total              | UP/SW_DUT |
|------------|--------------|-----------------------|--------------------|---------|--------------------------|---------------------|-------------------|--------------------|-----------|
| #git hash  | HW_DUT_name  | #of failed test cases | #passed test cases | job_id  | Daily BPV/Daily BPV node | error/failed/passed | TestEnv1/TestEnv2 | totalNumberOfTests | CXP-nr    |
