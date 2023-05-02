package ohm.softa.a06.model;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class JokeArrayAdapter extends TypeAdapter<Joke[]> {
	@Override
	public void write(JsonWriter out, Joke[] value) throws IOException {

	}

	@Override
	public Joke[] read(JsonReader in) throws IOException {
		Gson gson = new Gson();
		Joke[] result = null;

		in.beginObject();
		while(in.hasNext()){
			switch(in.nextName()){
				case "total":
					in.skipValue();
					break;
				case "result":
					result = gson.fromJson(in, Joke[].class);
					break;
			}
		}
		in.endObject();

		return result;
	}
}
