docker run -it -p 6379:6379 --name auth-redis redis redis-server --requirepass password
docker rm auth-redis