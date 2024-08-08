# BE Intro

This is a back end API that returns a min coin combination for a target sum, which is deployed in OCI with the following URL:

```
http://40.233.84.218:8080/hello
```
Running above will see a text returning from server.
To get a coin combination from API, use below format:
```
curl --location 'http://40.233.84.218:8080/hello' \
--header 'Content-Type: application/json' \
--data '{
    "targetAmount": 7.03,
    "coinDenominators": [0.01, 0.5, 1, 5, 10]
}'
```

# How to build local docker image

Within the BE root folder, run below to build docker image:

```
docker build -t coincalculator-backend .
```

After successful build, run container based on the image created.

```
docker run -d -p 8080:8080 coincalculator-backend
```

Once the container is running, you can access the Coin Calculator BE by navigating to http://localhost:8080/hello in your web browser.

# How to deploy the docker image

After installing docker engine on the server instance, pull the docker image from docker hub (you may need to add sudo for permission).

```
sudo docker pull jerrychen123/coincalculator-backend:V1.0.0
```

Then run the image in the instance.

```
docker run -d -p 8080:8080 jerrychen123/coincalculator-backend:V1.0.0
```

## Troubleshoot docker deployment

List docker images available
```
docker images
```

create tag for docker image
```
docker tag <nameOfImage> <username>/<whateverImageName:v1.0>
```

login docker hub
```
docker login
```

push image
```
docker push <username>/<imageName:version>
```

pull image
```
docker pull <username>/<imageName:version>
```

# Deployment notes

The app deployment details:

- Deployed on OCI cloud
- canonical ubuntu 22
- Docker enginee installation [ref](https://docs.docker.com/engine/install/ubuntu/)


# For local dropwizard app development

How to start the min_coin application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/min_coin_challenge-1.0.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`