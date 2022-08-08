package utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonFileReader {

	public static List<HashMap<String, String>> jsonFileReading()
			throws FileNotFoundException, IOException, ParseException {

		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		FileReader reader = new FileReader(configFileReader.ReadProperty("config", "JsonFilePath"));

		//Read JSON file
		Object obj = jsonParser.parse(reader);
		JSONObject jsonObject = (JSONObject) obj;

		JSONArray arr = (JSONArray) jsonObject.get(configFileReader.ReadProperty("config", "node"));

		List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < arr.size(); i++) {
			HashMap<String, String> map = new HashMap<String, String>();
			JSONObject ob = (JSONObject) arr.get(i);
			map.put("name", ob.get("name").toString());
			map.put("country", ob.get("country").toString());
			map.put("role", ob.get("role").toString());
			map.put("price-in-crores", ob.get("price-in-crores").toString());
			list.add(map);
		}

		return list;
	}

}
