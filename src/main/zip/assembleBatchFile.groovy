/* This is an example step groovy to show the proper use of APTool
 * In order to use import these utilities, you have to use the "pluginutilscripts" jar
 * that comes bundled with this plugin example. 
 */
import com.urbancode.air.AirPluginTool;
import com.urbancode.air.CommandHelper;
import groovy.io.FileType;

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

def xmlFolder = props['xmlFolder'];
def importBatchFile = props['importBatchFile'];
def reportFileName = props['reportFileName'];
def tagName = props['tagName'];
def numberOfThreads = props['numberOfThreads'];
def password = props['password'];

println("begin to check folders to assemble xmls into a batch file");

def dir = new File(xmlFolder);
def importFile = new File(importBatchFile);
dir.eachFileRecurse (FileType.FILES) { file ->
    println(file);
   // println(file.toString());
    def filePath=file.getCanonicalPath();
	println("filepath is "+filePath);
    def len=filePath.length();
    def extension;
    if (len>4)
    {
        extenstion=filePath.substring(len-4,len).toLowerCase();
        if (extenstion==".xml") {
            println("\tfound xml: "+filePath);
			def filePathPrefix=filePath.substring(0,len-4);
			def backupFileName=filePathPrefix+".bak";
			def errorFileName=filePathPrefix+".error";
			def importEntry = " -input " + filePath + " -update" + " -passphrase "+ password + " -backup " + backupFileName + " -errors \"" + errorFileName + "\" -numberOfThreads "+ numberOfThreads + " -resourcetag " + tagName + "\n";
			importFile << importEntry
        }
    }
}


apTool.storeOutputProperties();//write the output properties to the file
