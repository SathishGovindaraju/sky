This exercise uses following frameworks,

1. Spring boot for backend web-service.
2. ReactJs for front-end.

To set up this project do the following,

1. This project uses Node.js to install and manage packages for front-end.
So please make sure you have node.js installed.

2. In command line navigate into the root of the project and install node module using the command "npm install".
This should pull all the node modules required for this project.

3. This project uses gradle as its build tool for backend web-service. So open "IntelliJ Idea" and import this project as a gradle project.
This should download all the jars required for this project.

Now the project should be ready to use.

To start the web-service do the following,

1. Open "ApplicationConfig.java" in the package "com.sky.config" and run it.
This should start the server at "localhost:8080".

2. Navigate to the url "localhost:8080" in your browser to start using it.


NOTE:

When you goto the landing page, i expect a cookie name "customerId" to be present. So please make sure you have
set the cookie with one of the following values,

1. "liverpoolCustomer" (Use this to get packages for Liverpool location)
2. "londonCustomer" (Use this to get packages for London location)
3. Any other value will be considered as invalid customerId and will be taken to "/error-page"