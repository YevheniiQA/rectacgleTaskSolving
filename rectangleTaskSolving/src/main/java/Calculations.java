import java.util.List;

/**
 * Created by YTretynychenko on 04.07.2017.
 */
public class Calculations {

	private static final String delimiter = " ";

	public static String getMinimumRequiredRectangle(final List<String> rectanglesParams) {
		return new StringBuilder().append(StringUtils.RectangleParameter.DX.getParameterValue())
				.append(getMinValue(rectanglesParams, StringUtils.RectangleParameter.DX)).append(delimiter)
				.append(StringUtils.RectangleParameter.DY.getParameterValue())
				.append(getMinValue(rectanglesParams, StringUtils.RectangleParameter.DY)).append(delimiter)
				.append(StringUtils.RectangleParameter.DW.getParameterValue())
				.append(getMaxValue(rectanglesParams, StringUtils.RectangleParameter.DW)).append(delimiter)
				.append(StringUtils.RectangleParameter.DH.getParameterValue())
				.append(getMaxValue(rectanglesParams, StringUtils.RectangleParameter.DH)).append(delimiter).toString();
	}

	private static int getMinValue(final List<String> rectangleParams, final StringUtils.RectangleParameter parameter) {
		return rectangleParams.stream().map(item -> StringUtils.getValueFromString(item, parameter))
				.mapToInt(element -> element).min().getAsInt();
	}

	private static int getMaxValue(final List<String> rectangleParams, final StringUtils.RectangleParameter parameter) {
		return rectangleParams.stream().map(item -> {
			Integer resultValue = null;
			if (parameter.getParameterValue().equals(StringUtils.RectangleParameter.DW.getParameterValue())) {
				resultValue = StringUtils.getValueFromString(item, StringUtils.RectangleParameter.DX) + StringUtils
						.getValueFromString(item, StringUtils.RectangleParameter.DW) - getMinValue(rectangleParams,
						StringUtils.RectangleParameter.DX);
			} else if (parameter.getParameterValue().equals(StringUtils.RectangleParameter.DH.getParameterValue())) {
				resultValue = StringUtils.getValueFromString(item, StringUtils.RectangleParameter.DY) + StringUtils
						.getValueFromString(item, StringUtils.RectangleParameter.DH) - getMinValue(rectangleParams,
						StringUtils.RectangleParameter.DY);
			}
			return resultValue;
		}).mapToInt(element -> element).max().getAsInt();
	}

}
