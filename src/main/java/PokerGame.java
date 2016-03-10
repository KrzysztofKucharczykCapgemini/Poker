public class PokerGame implements Poker{
	
	private FileReaderForPoker fileReader;
	private WinCounter winCounter = new WinCounter();
	private Hand player, enemy;
	private int playerStrength, enemyStrength;
	
	public PokerGame(String filename) {
		fileReader = new FileReaderForPoker(filename);

	}
	
	@Override
	public boolean isInput() {
		return fileReader.nextLine();
	}

	@Override
	public void getNewHandsForPlayers() {
		player = (PokerHand) fileReader.getNewHand();
		enemy = (PokerHand) fileReader.getNewHand();
	}

	@Override
	public void calculatePlayersStrength() {
		playerStrength = player.getFigureAnalyzer().getFigureStrength(player);
		enemyStrength = enemy.getFigureAnalyzer().getFigureStrength(enemy);
	}

	@Override
	public void findWinner() {
		if (playerStrength > enemyStrength)
			winCounter.addPoint();
		else if (playerStrength == enemyStrength)
			if (DrawResolver.resolve(player, enemy) == 1)
				winCounter.addPoint();
	}

	@Override
	public void cleanAfterMatch() {
		player.clear();
		enemy.clear();
	}

	@Override
	public int getPoints() {
		return winCounter.getPoints();
	}
	
	
	
	public static void main(String[] args) {
		PokerGame poker = new PokerGame("C:\\Users\\KRKUCHAR\\workspace\\Poker\\src\\data\\poker.txt");
		
		while (poker.isInput()) {
			poker.getNewHandsForPlayers();
			poker.calculatePlayersStrength();
			poker.findWinner();
			poker.cleanAfterMatch();

		}
		System.out.println("Points: " + poker.getPoints());
	}
}