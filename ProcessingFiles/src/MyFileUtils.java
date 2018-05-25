import com.iggi.exceptions.ExampleException;

public class MyFileUtils {

	public int subtract10FromLargerNumber(int number) throws ExampleException {
		if(number < 10) {
			throw new ExampleException("that shet brokn");
		}
		return number - 9;
	}
}

