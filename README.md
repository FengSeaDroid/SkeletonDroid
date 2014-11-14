It is difficult for me to setup coding environment for Scalatron, so I made this repo to make it easier. It helps:

  1. Use sbt to package the jar to the right directory to join the tournament locally.
  2. Use sbt to start up scalatron server in debug mode.
  3. Use Eclipse to debug a Scalatron session.
  
Required: sbt

How to use:
  1. Download Scalatron to local
  2. Clone or copy this repo to /Scalatron/users/{Your desired bot name}/
      After this step you should see "build.sbt" in this path
  3. Run sbt within this folder.
      Basically the sbt script has to convient goals:
      a. package  This goal package whatever scala files inside src folder to a jar named ScalatronBot.jar to the directory where the server will look up for bots.
      b. debugServer  This goal fires up Scalatron server in debug mode so that you can use eclipse for remote debuging.
  4. You may want to set up ScalaIde/Eclipse for coding the bot. Use "import" -> "existing project into workspace" -> "select root directory" -> "/Scalatron/users/{Your desired bot name}/". And you should be good.
  5. Set up ScalaIde/Eclipse for remote debugging:
      a. First you should have the jar file packaged for the scalatron server (sbt package)
      b. Start server in debug mode (sbt debugServer)
      c. In Eclipse, "run"->"debug configurations" -> on "remote java applications" select new -> fill in as follows:
       this project,connection type: Scala debugger(Socket Attach),host: localhost, port: 5005. Then you should be good.
       
Configurations - in build.sbt
  1. You may change the port for debugging
