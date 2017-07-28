import java.util.Arrays;
import java.util.List;

/**
 * Created by YTretynychenko on 04.07.2017.
 */
public class MinRectangleFinder {

	public static void main(String[] args) {
		final List<String> testListOfRect = Arrays.asList("x=1 y=1 w=1 h=1", "x=2 y=2 w=2 h=2", "x=3 y=3 w=5 h=3");
		System.out.println(Calculations.getMinimumRequiredRectangle(testListOfRect));

		final List<String> testListOfRect1 = Arrays.asList("x=2 y=3 w=2 h=2", "x=3 y=2 w=2 h=2");
		System.out.println(Calculations.getMinimumRequiredRectangle(testListOfRect1));
	}

}
