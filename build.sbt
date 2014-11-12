
name := "skeleton droid" 
 
version := "0.0.1" 

//change default src path
scalaSource in Compile:= baseDirectory.value / "src"

//find the botname by looking at directory name
val os = sys.props.get("os.name") getOrElse "?"
val slash = if(os.toLowerCase.contains("windows")) '\\' else '/'
val botName = System.getProperty("user.dir").drop(System.getProperty("user.dir").lastIndexOf(slash)+1)

//set packaging path to bots/username/ScalatronBot.jar
artifactPath in Compile in packageBin <<=  baseDirectory { base => new File("../../bots/"+botName+"/ScalatronBot.jar") }

//add build goal for start server in debugging mode
val debugServer = taskKey[Unit]("start server in debug mode")

debugServer := {
	val log:String = Process("java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 -jar ../../bin/Scalatron.jar").!!
	println(log)
	} 