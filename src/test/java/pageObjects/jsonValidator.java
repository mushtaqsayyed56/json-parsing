package pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.json.simple.parser.ParseException;

import utility.configFileReader;
import utility.jsonFileReader;

public class jsonValidator {

	private static List<HashMap<String, String>> list;

	public static void ForeignPlayersValidation() throws FileNotFoundException, IOException, ParseException {

		list = jsonFileReader.jsonFileReading();

		// foreign players should be 4
		int playersCount = 0;
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).get("country").equalsIgnoreCase(configFileReader.ReadProperty("config", "country"))) {
				playersCount++;
			}
		}

		if (playersCount == Integer.valueOf(configFileReader.ReadProperty("config", "foreignPlayers"))) {
			assertTrue(true);
			System.out.println("There are 4 foreign players in the team");
		} else {
			System.out.println("There are less than 4 foreign players in the team");
			assertTrue(false);
		}

	}

	public static void atLeastOneWicketKeeperValidation() throws FileNotFoundException, IOException, ParseException {

		list = jsonFileReader.jsonFileReading();

		// Wicket-keeper should be 1

		int wicketKeeper = 0;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).get("role"));
			if (list.get(i).get("role").equalsIgnoreCase(configFileReader.ReadProperty("config", "role"))) {
				wicketKeeper++;
			}
		}

		if (wicketKeeper == Integer.valueOf(configFileReader.ReadProperty("config", "wicketKeeper"))) {
			assertTrue(true);
			System.out.println("There is 1 Wicket-keeper in the team");
		} else {
			System.out.println("There is no Wicket-keeper or more than 1 Wicket-keeper in the team");
			assertTrue(false);
		}

	}

}
