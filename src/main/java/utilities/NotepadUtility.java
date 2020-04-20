package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NotepadUtility {
	public String data;
	public String path;
	public static String utilData = "";

	public static String readNotepadContent(String path) throws FileNotFoundException {

		File file = new File(path);
		Scanner sc = new Scanner(file);

		while (sc.hasNextLine()) {
			utilData = sc.nextLine();

		}
		sc.close();
		// System.out.println(utilData);
		return utilData;

	}

}
