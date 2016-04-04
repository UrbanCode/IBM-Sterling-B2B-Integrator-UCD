# UrbanCode Deploy Sterling B2B Integrator Plug-in
---

This UrbanCode Deploy plug-in is for integrating with Sterling B2B Integrator allowing users to automate their B2B processes.

### Compiling Source
`gradle`
Run gradle in the root directory to build a project or through BlueMix's Gradle build process. 

### The Sterling B2Bi plug-in includes the following steps:
	
	Add Workflow
	Apply Configurations
	Assemble Import Batch File
	Get Service Status
	Import Batch File
	Import MAPs
	Install or Uninstall Third-Party Jars
	Restart Windows Service
    Start B2Bi
	Stop B2Bi

### Compatibility
	The IBM UrbanCode Deploy automation plug-in works with Sterling B2B Integrator versions 5.2 and later.
	This plug-in requires version 6.1.1 or later of IBM UrbanCode Deploy.

### Installation
	The packaged zip is located in the dist folder. No special steps are required for installation.
	See Installing plug-ins in UrbanCode Deploy. Download this zip file if you wish to skip the 
	manual build step. Otherwise, download the entire uDeploy-Informatica-Plugin and 
	run the "ant" command in the top level folder. This should compile the code and create
	a new distributable zip within the dist folder. Use this command if you wish to make
	your own changes to the plugin.

### History
	Version 1
		Initial Release.