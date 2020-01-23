package br.com.wexigor.wexigor.repository;

import br.com.wexigor.wexigor.models.User;
import br.com.wexigor.wexigor.models.UserMovie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UsersRepository extends CrudRepository<User,Integer>
{
    @Query("SELECT new br.com.wexigor.wexigor.models.UserMovie(u.firstName, m.title) "
            + "FROM User u INNER JOIN u.movieId m")
    List<UserMovie> getMovieByUser();
}
