# Set base image as node 20, including both Node.js and npm
FROM node:20
# Set working directory inside the container to be `/app`
# All subsequent commands will be for this folder
WORKDIR /app
# copy dependencies and install them
COPY package.json .
RUN npm install
# install serve package globally, serve is a server built with node.js for static file serving and directory listing
RUN npm install -g serve -y

# Copy the rest of the application from host machine into current working directory `/app`
COPY . .

# run build file from create react app
# built file stored in /app/build, where /app is previous created directory and /build is default create react build folder
RUN npm run build

# Container will listen on port 80 at runtime (ingress)
EXPOSE 80

# use serve package to serve the build file on port 80 (egress)
CMD ["npx", "serve","-s","/app/build","-l","80"]