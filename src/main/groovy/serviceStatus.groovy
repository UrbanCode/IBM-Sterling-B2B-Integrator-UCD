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
def URL = props['testing_url'];

def started="no";

try {
    def webpage= URL.toURL().text;

    println "<title>Sterling B2B Integrator Dashboard</title>";

    def pos=webpage.indexOf('<title>Sterling B2B Integrator Dashboard</title>');

    if (pos>=0) {
        started="yes"
    }
}
catch (ex)
{
    println "got exception";
}
println "Sterling B2Bi service started: "+started;

//Set an output property
apTool.setOutputProperty("started", started);

apTool.storeOutputProperties();//write the output properties to the file

if (started=="no")
	System.exit(1)
