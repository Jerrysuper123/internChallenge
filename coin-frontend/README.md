# Intro

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

# How to deploy docker image

After installing docker engine on the server instance, pull the docker image from docker hub.

```
docker pull jerrychen123/coincalculator-frontend:V1.0.1
```

Then run the image in the instance.

```
docker run -d -p 80:80 jerrychen123/coincalculator-frontend:V1.0.1
```
