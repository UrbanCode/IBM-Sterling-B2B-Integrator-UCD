 #
 #  © Copyright IBM Corporation 2014, 2016.
 #  This is licensed under the following license.
 #  The Eclipse Public 1.0 License (http://www.eclipse.org/legal/epl-v10.html)
 #  U.S. Government Users Restricted Rights:  Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 #

import sys
#read the first argument as the input properties file
inputFile = open(sys.argv[1], 'r')
inputProps = {}

#parse the input properties file and add properties to a dictionary
for line in inputFile:
	split=line.split('=', 1)
	if len(split) == 2:
		inputProps.update({split[0]:split[1]})

inputFile.close()
#print the message back to the user
print inputProps['message']
