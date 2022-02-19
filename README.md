# Spring Boot Microservices Project

## Setup mongo on Docker

- we need to create a directory called “mongodb” to hold the docker-compose file. We will create another directory
  called “database” inside the “mongodb” directory to map to the database location of the container. This will enable
  local access to the database. We use the -pv operator to create those parent folders.
    - ```shell
      mkdir -pv mongodb/database
      ``` 

- The following docker-compose.yml file will be created within the “mongodb” directory to construct the MongoDB
  container. docker-compose.yml
    - ```yaml
        version: "3.9"  # optional since v1.27.0
          services:
            mongodb:
            image : mongo
            container_name: mongodb-product-service
          environment:
            - PUID=1000
            - PGID=1000
          ports:
            - 27017:27017
          volumes:
            - /home/yeahbutstill/mongodb/database:/data/db
          restart: unless-stopped
      ```

- Run docker compose
    - ```shell
      sudo docker-compose up -d
      ```

- Using the docker exec command, we can access the terminal of the MongoDB container. As the container runs in a
  detached mode, we will use the Docker interactive terminal to establish the connection.
    - ```shell
      sudo docker exec -it mongodb bash
      ```

details: https://www.bmc.com/blogs/mongodb-docker-container/

## Setup MySQL on Docker

```shell
sudo docker run --rm \           
--name=order-service-db \
-e MYSQL_DATABASE=order-service \
-e MYSQL_USER=orderservice \
-e MYSQL_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e MYSQL_ROOT_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e TZ=Asia/Jakarta \
-p 3306:3306 \
-v "$PWD/docker/order-service-db/conf.d":/etc/mysql/conf.d \
-v "$PWD/storage/docker/order-servicedb-data":/var/lib/mysql \
mysql

```