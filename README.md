# Movie Watchlist (Backend)

Backend for a movie watchlist application with JWT authentication and pagination.
- Spring Boot
- PostgreSQL
- [OMDb API](https://www.omdbapi.com/)

## How to Run Locally

1. Clone the repo: `git clone https://github.com/RaoPY/movie-watchlist-backend.git`  
OR download _zip_ file: https://github.com/RaoPY/movie-watchlist-backend/archive/refs/heads/main.zip

2. Configure _application.properties_
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/movie_watchlist
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

jwt.secret.key=YOUR_JWT_SECRET_KEY

movie.api.url=http://www.omdbapi.com/
movie.api.key=YOUR_OMDB_API_KEY
```

3. Run the application
```bash
./mvnw spring-boot:run

# or build first then run
./mvnw clean install
java -jar target/watchlist-0.0.1-SNAPSHOT.jar
```

4. The application will start at port 8080.
