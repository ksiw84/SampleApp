package demo.spring.rest.handler;



public class NumberToWordHandlerImpl implements INumberToWordHandler {

	public enum hundreds {
		OneHundred, TwoHundred, ThreeHundred, FourHundred, FiveHundred, SixHundred, SevenHundred, EightHundred, NineHundred
	}

	public enum tens {
		Twenty, Thirty, Forty, Fifty, Sixty, Seventy, Eighty, Ninty
	}

	public enum ones {
		One, Two, Three, Four, Five, Six, Seven, Eight, Nine
	}

	public enum denom {
		Thousand, Lakhs, Crores
	}

	public enum splNums {
		Ten, Eleven, Tweleve, Thirteen, Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen
	}

	public static final String SPACE = " ";
	
	public static final String ZERO = "Zero";
	
	public static final String ERR_MSG = "Number  is too long.  Need to build the logic";

	@Override
	public String convertWordToNumber(long num) {
		
		try
		{
		String text = SPACE;
		int rem = 0;
		int i = 0;
		while (num > 0) {
			if (i == 0) {
				rem = (int) (num % 1000);
				text = printText(rem, text);
				num = num / 1000;
				i++;
			} else if (num > 0) {
				rem = (int) (num % 100);
				if (rem > 0)
					text = denom.values()[i - 1] + SPACE + text;
				text = printText(rem, text);
				num = num / 100;
				i++;
			}
		}

		if (i > 0)
			return text;
		else
			return ZERO;
		}catch(Exception ex)
		{
			return String.format(ERR_MSG);
		}

	}

	public String printText(int num, String text) {
		if (!(num > 9 && num < 19)) {
			if (num % 10 > 0)
				text = getOnes(num % 10, text);

			num = num / 10;
			if (num % 10 > 0)
				text = getTens(num % 10, text);

			num = num / 10;
			if (num > 0)
				text = getHundreds(num, text);
		} else {
			text = getSplNums(num % 10, text);
		}
		return text;
	}

	public String getSplNums(int num, String text) {
		text = splNums.values()[num] + SPACE + text;
		return text;
	}

	public String getHundreds(int num, String text) {
		text = hundreds.values()[num - 1] + SPACE + text;
		return text;
	}

	public String getTens(int num, String text) {
		text = tens.values()[num - 2] + SPACE + text;
		return text;
	}

	public String getOnes(int num, String text) {
		text = ones.values()[num - 1] + SPACE + text;
		return text;
	}



}
