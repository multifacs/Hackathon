docker rm -f backend 2> /dev/null
docker rm -f frontend 2> /dev/null
docker rm -f resort-nginx 2> /dev/null

docker network rm resort-net 2> /dev/null