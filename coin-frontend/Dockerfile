FROM node:20
WORKDIR /app

COPY package.json .
RUN npm install
RUN npm install -g serve -y

COPY . .
# You need to enable JavaScript to run this app.
# script tag is not linked to js correctly in run build step
RUN npm run build

EXPOSE 80

# /build file in create react app
CMD ["npx", "serve","-s","/app/build","-l","80"]