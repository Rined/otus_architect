docker run -it --name otus-05-auth -p 8000:8000 --env-file env.list --add-host pg-db:192.168.56.1 rined/otus-05-auth:v2
docker rm otus-05-auth