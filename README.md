1. Launch [SBT](http://code.google.com/p/simple-build-tool).

        ./sbt

2. Run tests

	test
		
3. Run Jetty

        container:start

4. Go to http://localhost:8080/.

5. Learn more at http://www.scalatra.org/stable/book.

6. Happy hacking!

7.Run the following command in sbt to generate eclipse project files so that eclipse wont complain when you open the project. The sbt eclipse plugin is included in the plugins.sbt.

		eclipse

8. Run the following command to enable automatic code reloading. Woohoo!

		~ ;copy-resources;aux-compile
