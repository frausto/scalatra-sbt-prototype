1. Launch [SBT](http://code.google.com/p/simple-build-tool).

        ./sbt
		
2. Run Jetty

        container:start

3. Go to http://localhost:8080/.

4. Learn more at http://www.scalatra.org/stable/book.

5. Happy hacking!

6.Run the following command in sbt to generate eclipse project files so that eclipse wont complain when you open the project. The sbt eclipse plugin is included in the plugins.sbt.

		eclipse 


7. Run the following command to enable automatic code reloading. Woohoo!

		~ ;copy-resources;aux-compile
