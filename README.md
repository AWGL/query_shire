# Query Shire Sample Sheet Data
***
## Introduction
Tool to extract data from the Shire database required to generate Sample Sheets for Next Generation Sequencing with Illumina sequencers. The minimum input is a worksheet identifier (first command line argument) and the parsed data is returned to standard output.

The software has been set up as part of the package nhs.cardiff.genetics in common with other locally written Java software.

This tool is designed to be used as a packaged jar file. For information about using this jar file, see the repository: 

```
https://github.com/AWGL/sample_sheets
```

***
## Installation
This software uses Java 6 (1.6.0_45).

It has dependencies which must be installed:

* jackson-core v.2.6.0
* jackson-databind v.2.6.0
* jackson-annotations v.2.6.0


Clone the repository:

```
git clone https://github.com/AWGL/query_shire
```

The code must then be compiled:

```
 javac Main.java
```
and can be run after compilation:

```
 java Main
```
***
## Packaging for deployment
The software needs to be packaged as a jar file to run on imaged PCs with a different version of Java installed. The jar file can be built on any computer with Java 1.6.0_45 (requires the Java SDK).

I recommend using an IDE of your choice to accomplish this. Instructions for various methods are available online.

***
## Deployment
The jar file should be copied to the location from which it is to be launched. It is likely that this will be a shared drive that is accessible to all. 

Current versions of the sample sheet generator are in:
 
```
M:\Pyrosequencing\Pyrosequencing Service\PCR & PYRO spreadsheets\Log\IT\PyroService Worklist Program\jre\
``` 


This can be accomplished using the batch file available in the repository and changing the paths to the Java installation and location of the jar file if required:
```
https://github.com/AWGL/sample_sheets
```
***
## Instructions for usage
### Running the software
The software must be launched on Trust PCs from the portable Java located at:
 
```
M:\Pyrosequencing\Pyrosequencing Service\PCR & PYRO spreadsheets\Log\IT\PyroService Worklist Program\jre\bin
``` 
It is recommended to use this same portable Java for testing. It can be copied to the local machine and the path in the batch file changed to point to the correct location. 

### Using the software
The software requires launching with at least one command line argument. This should be the worksheet id for the data:

```
java -jar query_shire.jar 20-0000
```
Default behaviour in the absence of the optional command line arguments is using the live (not test) database and writing the parsed data to standard output.

#### Optional command line arguments
##### Optional command line argument - testing
A second command line argument can be supplied. If the test database is to be used (e.g.. testing the software), this should be "true". If the live database is to be used (e.g. deployed) this should be set to "false". e.g.
```
java -jar query_shire.jar 20-0000 true
```

##### Optional command line argument - write to file
A third command line argument allows the user to write the parsed data to a file in JSON format. The third command line argument should be the desired file name. e.g.
```
java -jar query_shire.jar 20-0000 true shire_data.json
```

Note that use of this option requires the second command line argument to be correctly set.
***

## Troubleshooting
Launch the software (via batch file) directly from the Windows command line to see error messages.

***
## Notes
### Current known issues
* None






