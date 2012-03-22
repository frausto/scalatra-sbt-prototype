1. Launch [SBT](http://code.google.com/p/simple-build-tool).

        ./sbt

2. Seed
	seed

3. Run tests

	test
		
4. Run Jetty

        container:start

5. Go to http://localhost:8080/.

6. Learn more at http://www.scalatra.org/stable/book.

7. Happy hacking!

8.Run the following command in sbt to generate eclipse project files so that eclipse wont complain when you open the project. The sbt eclipse plugin is included in the plugins.sbt.

		eclipse

9. Run the following command to enable automatic code reloading. Woohoo!

		~ ;copy-resources;aux-compile
