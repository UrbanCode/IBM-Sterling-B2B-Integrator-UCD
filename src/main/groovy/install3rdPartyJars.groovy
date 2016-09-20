/**
 *  © Copyright IBM Corporation 2014, 2016.
 *  This is licensed under the following license.
 *  The Eclipse Public 1.0 License (http://www.eclipse.org/legal/epl-v10.html)
 *  U.S. Government Users Restricted Rights:  Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 */

 /* This is an example step groovy to show the proper use of APTool
 * In order to use import these utilities, you have to use the "pluginutilscripts" jar
 * that comes bundled with this plugin example.
 */
import com.urbancode.air.AirPluginTool;
import com.urbancode.air.CommandHelper;

/* This gets us the plugin tool helper.
 * This assumes that args[0] is input props file and args[1] is output props file.
 * By default, this is true. If your plugin.xml looks like the example.
 * Any arguments you wish to pass from the plugin.xml to this script that you don't want to
 * pass through the step properties can be accessed using this argument syntax
 */
def apTool = new AirPluginTool(this.args[0], this.args[1])

/* Here we call getStepProperties() to get a Properties object that contains the step properties
 * provided by the user.
 */
def props = apTool.getStepProperties();

/* This is how you retrieve properties from the object. You provide the "name" attribute of the
 * <property> element
 *
 */
def sterlingHome = props['sterlingHome'];
def filelist = props['filelist'];
def vendorName = props['vendorName'];
def vendorVersion = props['vendorVersion'];
def targetJVMOptions = props['targetJVMOptions'];
//if (targetJVMOptions=="NO")

def uninstall = props['uninstall'];
def nodeploy = props['nodeploy'];

//println("targetJVMOptions"+ targetJVMOptions+", uninstall"+uninstall);

//example commandHelper
def workDir = new File(sterlingHome+"/install/bin");
//def workDir = new File(".");
def ch = new CommandHelper(workDir);

//def args = [sterlingHome+"/install/bin/install3rdparty.cmd", vendorName, vendorVersion,'-j', filelist];
def args = ["install3rdparty.cmd", vendorName, vendorVersion,'-j', filelist];
// targetJVMOptions, uninstall,nodeploy];

println("targetJVMOptions"+ targetJVMOptions+", uninstall"+uninstall);

if (targetJVMOptions!="NO")
	args = [*args,"-targetJVMOptions "+targetJVMOptions];

if (uninstall=="true")
	args = 	[*args,"-uninstall"];

if (nodeploy=="true")
	args = 	[*args,"-nodeploy"];

def myresult;

println (args);

if (uninstall=='false')
{
	myresult=ch.runCommand("install third party jars", args);
}
else
{
	myresult=ch.runCommand("uninstall third party jars", args);
}




println ("result is "+ myresult);
//Set an output property
//apTool.setOutputProperty("outPropName", "outPropValue");

apTool.storeOutputProperties();//write the output properties to the file
