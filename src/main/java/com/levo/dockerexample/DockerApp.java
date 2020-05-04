package com.levo.dockerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerApp {
	public static void main(String[] args) {
		SpringApplication.run(DockerApp.class, args);
	}
}

/*
 * Commands
docker build --tag=docker-java-hello-world-app .
docker run -p 80:8080 docker-java-hello-world-app
docker exec -it <container_id> /bin/bash

UI:
https://blog.neoprime.it/ng-in-httpd/
docker build -f Dockerfile -t sample-app:0.1 dist/sample-app/
docker run -d -p 8080:80 --name sample-app sample-app:0.1


Docker compose commands:
docker-compose up --build
docker-compose up -d
docker-compose down 

Building docker image by using some other file like DockerFile.dev
- docker build -f Dockerfile.dev
*/
 