# FE Intro

This is a front end create React app that return min coin combination for a target sum, which is deployed in OCI with the following URL:

```
http://40.233.84.218/
```

# How to build local docker image

Within the FE root folder, run below to build docker image:

```
docker build -t coincalculator-frontend .
```

After successful build, run container based on the image created.

```
docker run -d -p 80:80 coincalculator-frontend
```

Once the container is running, you can access the Coin Calculator frontend by navigating to http://localhost in your web browser.

# How to deploy the docker image

After installing docker engine on the server instance, pull the docker image from docker hub (you may need to add sudo for permission).

```
docker pull jerrychen123/coincalculator-frontend:V1.0.1
```

Then run the image in the instance.

```
docker run -d -p 80:80 jerrychen123/coincalculator-frontend:V1.0.1
```

# Deployment notes

The app deployment details:

- Deployed on OCI cloud
- canonical ubuntu 22
- Docker enginee installation [ref](https://docs.docker.com/engine/install/ubuntu/)
