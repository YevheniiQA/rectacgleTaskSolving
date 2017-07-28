import java.util.Arrays;

/**
 * Created by YTretynychenko on 04.07.2017.
 */
public class StringUtils {

	public static int getValueFromString(final String rectangleData, final RectangleParameter parameter) {
		final String delimiter = " ";
		return Integer.parseInt(Arrays.stream(rectangleData.split(delimiter))
				.filter(item -> item.contains(parameter.getParameterValue())).map(item -> {
					item.trim();
					return item.replaceAll("[^0-9]", "");
				}).findAny().get());
	}

	public enum RectangleParameter {
		DX("x="), DY("y="), DW("w="), DH("h=");

		RectangleParameter(final String parameter) {
			this.parameter = parameter;
		}

		private String parameter;

		public String getParameterValue() {
			return parameter;
		}
	}

}
