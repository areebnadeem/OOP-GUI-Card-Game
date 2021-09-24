import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * This is the main class that creates instances of all other classes, that is
 * of the MainPanel and Winner classes. It initiates the frame object, and adds
 * the main Panel, consisting of all other panels, to it. All the Action
 * Listeners on the Menu Items and buttons are also enabled in this class.
 * 
 * @author Areeb Nadeem
 *
 */
public class Main {

	JFrame frame = new JFrame();
	int bet;
	int i = 0; // this will point to the next card to be picked up from the deck. It is
				// incremented every time a card is picked up
	int input_bet;
	boolean inputCheck = false;

	int card_to_replace_with = 6;
	int btn_rpcard_count; // counter to check how many times replace button has been clicked
	String deck[];
	int player_card1;
	int player_card2;
	int player_card3;
	int dealer_card1;
	int dealer_card2;
	int dealer_card3;
	int player_scores[] = new int[3]; // for storing the number values of player's cards
	int dealer_scores[] = new int[3]; // for storing number values of dealer's cards
	int money; // stores dealer's money in hand and is updated after every round

	/**
	 * This method initiates an object of this class and demonstrates go().
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		Main gui = new Main();
		gui.go();

	}

	/**
	 * This method sets up the frame and creates an instance of the MainPanel class
	 * and adds the main panel and menu bar to the frame. It also calls on the
	 * shuffleDeck() method in MainPanel class, which returns the shuffled deck.
	 * This method then distributes the cards to the players and dealers from the
	 * top of the deck. All the action listeners are also demonstrated in this
	 * method. In the end, it calls the winner() method from the Winner class, which
	 * returns who wins the game as the character 'P' (player) and 'D' (dealer).
	 */

	public void go() {
		frame = new JFrame("A simple card game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		JMenu menuControl = new JMenu("Control");
		JMenuItem controlItem = new JMenuItem("Exit");

		controlItem.addActionListener(e -> {
			frame.dispose();
		});

		menuControl.add(controlItem);
		JMenu menuHelp = new JMenu("Help");
		JMenuItem instructionsItem = new JMenuItem("Instructions");
		menuHelp.add(instructionsItem);

		instructionsItem.addActionListener(e -> {
			JOptionPane.showMessageDialog(frame, "Rules to determine who has better cards:\r\n"
					+ "J, Q, K are regarded as special cards.\r\n" + "Rule 1: The one with more special cards wins.\r\n"
					+ "Rule 2: If both have the same number of special cards, add the face values of the other\r\n"
					+ "card(s) and take the remainder after dividing the sum by 10. The one with a bigger\r\n"
					+ "remainder wins. (Note: Ace = 1).\r\n"
					+ "Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the winner.");
		});

		menuBar.add(menuControl);
		menuBar.add(menuHelp);
		frame.setJMenuBar(menuBar);

		MainPanel mp = new MainPanel();
		frame.getContentPane().add(mp.displayGame());
		frame.setTitle("A simple card game");
		frame.setSize(400, 700);
		frame.setVisible(true);
		money = Integer.valueOf(mp.money);

		/**
		 * the action listener class is implemented here for the start button. On
		 * clicking, it calls the shuffleDeck() method and receives the shuffled deck as
		 * the return value. Also, The input bet value is validated in this method, and
		 * player's cards are displayed.
		 */
		mp.btn_start.addActionListener(e -> {
			deck = mp.shuffleDeck();

			try {
				input_bet = Integer.parseInt(mp.txt_inputbet.getText());

				if (input_bet > 0 && input_bet <= Integer.valueOf(money)) {
					inputCheck = true;
				}

				else if (input_bet <= 0) {
					JOptionPane.showMessageDialog(frame, "WARNING: The bet you place must be a positive integer");
					input_bet = 0;
				}
			}

			catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(frame, "WARNING: The bet you place must be a positive integer");
			}

			if (input_bet > Integer.valueOf(money)) {
				JOptionPane.showMessageDialog(frame, "WARNING: You only have $" + money);
				input_bet = 0;
			}

			else if (inputCheck == true) {

				mp.Image4 = new ImageIcon(deck[i]);
				player_card1 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
				i++;

				mp.Image5 = new ImageIcon(deck[i]);
				player_card2 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
				i++;

				mp.Image6 = new ImageIcon(deck[i]);
				player_card3 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
				i++;

				mp.label_Image4.setIcon(mp.Image4);
				mp.label_Image5.setIcon(mp.Image5);
				mp.label_Image6.setIcon(mp.Image6);

				mp.Image1 = new ImageIcon(deck[i]);
				dealer_card1 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
				i++;

				mp.Image2 = new ImageIcon(deck[i]);
				dealer_card2 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
				i++;

				mp.Image3 = new ImageIcon(deck[i]);
				dealer_card3 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
				i++;

				mp.label_info
						.setText("Your current bet is: $" + String.valueOf(input_bet) + " Amount of money you have:");

				mp.btn_start.setEnabled(false);

				btn_rpcard_count = 0;

				mp.btn_rpcard1.setEnabled(true);
				mp.btn_rpcard2.setEnabled(true);
				mp.btn_rpcard3.setEnabled(true);
				mp.btn_result.setEnabled(true);

			}

		});

		/**
		 * The action listener class is implemented here for the 'Replace Card 1'
		 * button. On clicking, it replaces the player's card with the top card from the
		 * deck. All the action listeners for the 'Replace card' buttons have the same
		 * functionality.
		 * 
		 */
		mp.btn_rpcard1.addActionListener(e ->

		{

			mp.Image4 = new ImageIcon(deck[i]);
			player_card1 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
			i++;
			mp.label_Image4.setIcon(mp.Image4);
			btn_rpcard_count++;

			if (btn_rpcard_count == 2) {

				mp.btn_rpcard2.setEnabled(false);
				mp.btn_rpcard3.setEnabled(false);
			}
			mp.btn_rpcard1.setEnabled(false);

		});

		/**
		 * The action listener class is implemented here for the 'Replace Card 2'
		 * button.
		 */
		mp.btn_rpcard2.addActionListener(e -> {

			mp.Image5 = new ImageIcon(deck[i]);
			player_card2 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));
			i++;
			mp.label_Image5.setIcon(mp.Image5);
			btn_rpcard_count++;

			if (btn_rpcard_count == 2) {
				mp.btn_rpcard1.setEnabled(false);
				mp.btn_rpcard3.setEnabled(false);
			}
			mp.btn_rpcard2.setEnabled(false);

		});

		/**
		 * The action listener class is implemented here for the 'Replace Card 3'
		 * button.
		 */
		mp.btn_rpcard3.addActionListener(e -> {

			mp.Image6 = new ImageIcon(deck[i]);
			player_card3 = Integer.valueOf((deck[i]).replaceAll("[^\\d]", ""));

			mp.label_Image6.setIcon(mp.Image6);
			i++;
			btn_rpcard_count++;
			if (btn_rpcard_count == 2) {
				mp.btn_rpcard1.setEnabled(false);
				mp.btn_rpcard2.setEnabled(false);

			}
			mp.btn_rpcard3.setEnabled(false);

		});

		/**
		 * The action listener class for the 'Result' button is implemented here. On
		 * clicking, it displays the dealer's cards. It also stores the player's cards
		 * and dealer's cards in separate lists and passes them as parameters in the
		 * winner() method of the Winner class. The winner() method then returns the
		 * winner of the round as a character 'P' (player) or 'D' (dealer). Inside this
		 * class, the player's money is also updated according to the result of the
		 * round.
		 */
		mp.btn_result.addActionListener(e -> {

			mp.label_Image1.setIcon(mp.Image1);
			mp.label_Image2.setIcon(mp.Image2);
			mp.label_Image3.setIcon(mp.Image3);

			player_scores[0] = player_card1;
			player_scores[1] = player_card2;
			player_scores[2] = player_card3;
			dealer_scores[0] = dealer_card1;
			dealer_scores[1] = dealer_card2;
			dealer_scores[2] = dealer_card3;

			/**
			 * This is where the game_winner object of the Winner class is instantiated. The
			 * winner () method is called and the return value is checked to see who won the
			 * round. The message showing the result is displayed accordingly.
			 */
			Winner game_winner = new Winner();
			if (game_winner.winner(player_scores, dealer_scores) == "P") {
				JOptionPane.showMessageDialog(frame, "CONGRATULATIONS! You win this round.");
				money = money + input_bet;

			}

			if (game_winner.winner(player_scores, dealer_scores) == "D") {
				JOptionPane.showMessageDialog(frame, "Sorry! The dealer wins this round.");
				money = money - input_bet;

			}

			/**
			 * The conditionals below checks if the dealer has lost all his money or not.
			 */

			if (money <= 0) {

				mp.btn_rpcard1.setEnabled(false);
				mp.btn_rpcard2.setEnabled(false);
				mp.btn_rpcard3.setEnabled(false);
				mp.btn_result.setEnabled(false);
				mp.btn_start.setEnabled(false);

				mp.label_info.setText("You have no more money! Please start a new game.");
				mp.label_money.setText("");
				JOptionPane.showMessageDialog(frame,
						"Game Over!\r\n" + "You have no more money!\r\n" + "Please start a new game!\r\n");

			}

			else {
				mp.label_info.setText("Please place your bet! Amount of money you have: ");
				mp.label_money.setText("$" + String.valueOf(money));
				mp.btn_start.setEnabled(true);
				mp.btn_result.setEnabled(false);
				mp.btn_rpcard1.setEnabled(false);
				mp.btn_rpcard2.setEnabled(false);
				mp.btn_rpcard3.setEnabled(false);

				mp.Image1 = new ImageIcon("card_back.gif");
				mp.Image2 = new ImageIcon("card_back.gif");
				mp.Image3 = new ImageIcon("card_back.gif");
				mp.Image4 = new ImageIcon("card_back.gif");
				mp.Image5 = new ImageIcon("card_back.gif");
				mp.Image6 = new ImageIcon("card_back.gif");

				mp.label_Image1.setIcon(mp.Image1);
				mp.label_Image2.setIcon(mp.Image2);
				mp.label_Image3.setIcon(mp.Image3);
				mp.label_Image4.setIcon(mp.Image4);
				mp.label_Image5.setIcon(mp.Image5);
				mp.label_Image6.setIcon(mp.Image6);

				// resetting the i value so that it points to the top of the deck in the next
				// round.
				i = 0;

				// resetting inputCheck value so that input bet value can be checked in next
				// round
				inputCheck = false;

				// resetting initial input bet for next round
				input_bet = 0;

			}

		});

	}
}
