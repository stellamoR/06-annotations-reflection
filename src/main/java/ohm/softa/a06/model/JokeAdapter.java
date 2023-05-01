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
		final Joke j = new Joke();
		in.beginObject();
		while (in.hasNext()) {
			switch (in.nextName()) {
				case "id":
					j.setIdentifier(in.nextString());
					break;
				case "value":
					j.setContent(in.nextString());
				case "categories":
					j.setRubrics();
			}
		}
		return null;
	}
}
