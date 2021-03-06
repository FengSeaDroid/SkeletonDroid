
name := "skeleton droid" 
 
version := "0.0.1" 

//use this version of Scala for compilation
scalaVersion := "2.9.2"
//otherwise may throw exception (such as from String.split)
//http://stackoverflow.com/questions/17267847/getting-scalatron-to-work-trouble-with-opcode

//change default src path
scalaSource in Compile:= baseDirectory.value / "src"

//find the botname by looking at directory name //untested on linux
val os = sys.props.get("os.name") getOrElse "?"
val slash = if(os.toLowerCase.contains("windows")) '\\' else '/'
val botName = System.getProperty("user.dir").drop(System.getProperty("user.dir").lastIndexOf(slash)+1)

//set packaging path to bots/username/ScalatronBot.jar
artifactPath in Compile in packageBin <<=  baseDirectory { base => new File("../../bots/"+botName+"/ScalatronBot.jar") }

//add build goal for start server in debugging mode
val debugServer = taskKey[Unit]("start server in debug mode")

debugServer := {
	def log : String = Process("java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -jar ../../bin/Scalatron.jar").!!
	println(log)
	} 