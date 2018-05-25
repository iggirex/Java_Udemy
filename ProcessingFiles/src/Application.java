import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// for(int i = 0; i <= 3; i++) {
		// Scanner input = new Scanner(System.in);
		// System.out.println("Enter some text: ");
		// String enteredText = input.nextLine();
		// System.out.println(enteredText);
		//
		// }
		try {
			File file = new File("myfile.txt");
			Scanner input;

			input = new Scanner(file);
			while (input.hasNextLine()) {
				String line = input.nextLine();
				System.out.println(line);
			}
			input.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
