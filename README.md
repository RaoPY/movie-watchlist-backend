# Movie Watchlist (Backend)

Backend for a movie watchlist application with JWT authentication and pagination.
- Spring Boot
- PostgreSQL
- [OMDb API](https://www.omdbapi.com/)

<img src="https://github.com/user-attachments/assets/e7904854-0aa5-4c85-bfc7-37d3794e7eb7" width="500px">
<img src="https://github.com/user-attachments/assets/2627f9a4-7a20-47f1-a880-67205acb15ef" width="500px">
<img src="https://github.com/user-attachments/assets/99fadc0b-1eaa-4f01-b426-b39a7fc020e1" width="500px">

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
