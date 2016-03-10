import java.util.ArrayList;
import java.util.List;

public class PokerFigureOrganiser implements IFiguresOrganiser {
	private int frequency;
	private List<Integer> cardValues = new ArrayList<Integer>();

	// ---------------------------------------------------------

	public PokerFigureOrganiser(int frequency, Integer cardValue) {
		this.frequency = frequency;
		this.cardValues.add(cardValue);
	}

	// ---------------------------------------------------------
	
	@Override
	public int getCardFrequency() {
		return frequency;
	}

	@Override
	public List<Integer> getCardValues() {
		return cardValues;
	}

	@Override
	public String toString() {
		String result = new String();

		result = "[" + frequency + "," + cardValues + "]\n";
		return result;
	}

	@Override
	public int compareTo(IFiguresOrganiser another) {
		return this.getCardFrequency() > another.getCardFrequency() ? 1 : -1;
	}
}