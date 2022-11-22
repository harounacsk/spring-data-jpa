Install Postgresql with Docker
Source:https://hevodata.com/learn/docker-postgresql/
docker pull postgres
docker run --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres