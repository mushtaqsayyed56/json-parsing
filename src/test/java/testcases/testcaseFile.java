package testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import pageObjects.jsonValidator;

public class testcaseFile {

	@Test
	public void countNumberOfForeignPlayers() throws FileNotFoundException, IOException, ParseException {

		jsonValidator.ForeignPlayersValidation();

	}

	@Test
	public void atLeastOneWicketKeeper() throws FileNotFoundException, IOException, ParseException {

		jsonValidator.atLeastOneWicketKeeperValidation();

	}

}
