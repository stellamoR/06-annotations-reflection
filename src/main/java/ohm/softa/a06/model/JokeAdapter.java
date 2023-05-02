package ohm.softa.a06.model;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class JokeAdapter extends TypeAdapter<Joke> {


	@Override
	public void write(JsonWriter out, Joke j) throws IOException {

	}

	@Override
	public Joke read(JsonReader in) throws IOException {
		Gson gson = new Gson();
		return gson.fromJson(in, Joke.class);
	}
}
