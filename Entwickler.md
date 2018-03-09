
docker network create commonnet

docker build ./ -t javaee

docker run --net commonnet -it -p 7777:8080 -p 9990:9990 -p 8787:8787 javaee:latest

mvn wildfly:deploy

http://localhost:7777/simplejavaee-web-1.0-SNAPSHOT/sayhello

mvn install -DskipITs=false