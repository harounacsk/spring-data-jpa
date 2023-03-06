Install Postgresql with Docker
Source:https://hevodata.com/learn/docker-postgresql/
docker pull postgres
docker run --name postgresql -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -v /data:/var/lib/postgresql/data -d postgres

docker run -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=yourStrong(!)Password" -p 1433:1433 -d mcr.microsoft.com/mssql/server:2022-latest

docker run --name my-mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=mypassword -d mysql


Public Key Retrieval is not allowed fix: propriete pilote allowPublicKewRetrievql true

Swagger: http://localhost:8383/swagger-ui.html

