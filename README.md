# asimplewebapp
In order to run this locally, you should have following plugins installed (globally or inside the project root folder if locally):
- nodejs
- bower
- http-server (https://www.npmjs.com/package/http-server)
- maven
For the sake of simplicity this app uses only hsql for both deployment and testing.
To run the app:
1, Make sure you have all listed above dependencies installed with correct PATH values set.
2, From cmd or git bash, type:
mvn clean install -Pw
(Or -Pl for Linux)
3, then: mvn spring-boot:run
4, Open another cmd/git bash, type: http-server {path.to.project.dir}/fileUpload -a localhost -p 8000 --cors
5, Above command will open up a temp server that host the fileUpload folder which acts like a http server for file uploading. The
app is now ready, go to: localhost:8080 to see the result.
6, By default the page would mostly be empty as the DB is fresh. Please click: Make me admin on top right of the page to 
enable Admin panel which allows you to upload/download a template. You can use one of the template provided inside the /templates folder
to see the immediate result.
