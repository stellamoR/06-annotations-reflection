package ohm.softa.a06;
import ohm.softa.a06.model.Joke;
import retrofit2.Call;
import retrofit2.http.*;
import retrofit2.http.GET;

public interface CNJDBApi {
	@GET("jokes/random/")
	Call<Joke> randomJoke();
	@GET("jokes/search")
	Call<Joke[]> searchJoke(@Query("query") String searchString);
}
