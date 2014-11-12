
name := "skeleton droid" 
 
version := "0.0.1" 

val botName = System.getProperty("user.dir").drop(System.getProperty("user.dir").lastIndexOf('\\')+1)

artifactPath in Compile in packageBin <<=  baseDirectory { base => new File("../../bots/"+botName+"/Scalatron.jar") }