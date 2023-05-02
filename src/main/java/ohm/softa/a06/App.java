package ohm.softa.a06;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ohm.softa.a06.model.Joke;
import ohm.softa.a06.model.JokeAdapter;
import ohm.softa.a06.model.JokeArrayAdapter;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

/**
 * @author Peter Kurfer
 * Created on 11/10/17.
 */
public class App{

	public static void main(String[] args) throws IOException {
		Gson gson = new GsonBuilder()
			.registerTypeAdapter(Joke[].class, new JokeArrayAdapter())
			.create();

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.chucknorris.io/")
			.addConverterFactory(GsonConverterFactory.create(gson))
			.build();

		CNJDBApi api = retrofit.create(CNJDBApi.class);
		Call<Joke> cjoke = api.randomJoke();
		Response<Joke> rjoke = cjoke.execute();
		Joke j = rjoke.body();
		System.out.println(j.getContent());

		Response<Joke[]> respArr = api.searchJoke("chuck").execute();
		System.out.println(respArr.toString());
		Joke[] jokeArr = respArr.body();

		for(Joke myj :jokeArr){
			System.out.println(myj.getContent());
		}

	}

}
