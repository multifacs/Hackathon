./scripts/clean.sh

docker network create resort-net

docker run -d --name backend -p 8080:8080 --network resort-net resort-back
docker run -d --name frontend -p 3000:8080 --network resort-net resort-front
docker run -p 80:80 --name resort-nginx \
  --network resort-net -d resort-nginx
