docker build -f ./back/docker/Dockerfile -t resort-back ./back
docker build -f ./front/docker/Dockerfile -t resort-front ./front
docker build -f ./nginx/Dockerfile -t resort-nginx ./nginx