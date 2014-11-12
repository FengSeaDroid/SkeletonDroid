
name := "skeleton droid" 
 
version := "0.0.1" 

//change default src path
scalaSource in Compile:= baseDirectory.value / "src"

//find the botname by looking at directory name
val botName = System.getProperty("user.dir").drop(System.getProperty("user.dir").lastIndexOf('\\')+1)

//set packaging path to bots/username/ScalatronBot.jar
artifactPath in Compile in packageBin <<=  baseDirectory { base => new File("../../bots/"+botName+"/ScalatronBot.jar") }