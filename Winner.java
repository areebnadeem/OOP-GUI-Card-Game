/**
 * This class demonstrates the method Winner(). It decides who wins the round
 * based on game logic.
 * 
 * @author Areeb Nadeem
 *
 */
public class Winner {
	/**
	 * This method returns the winner of the round based on the logic of the game
	 * 
	 * @param player_scores contains list of number values of player's 3 cards
	 * @param dealer_scores contains list of number values of dealer's 3 cards
	 * @return a character 'P' (player) or 'D' (dealer) that determines the winner
	 *         of the round
	 */
	public String winner(int player_scores[], int dealer_scores[]) {

		int player_special_card_count = 0;
		int player_num_card_value = 0;
		int dealer_special_card_count = 0;
		int dealer_num_card_value = 0;

		for (int i = 0; i < 3; i++) {

			// the condition below checks whether a special card is present in the player's
			// cards
			if (player_scores[i] > 110 && player_scores[i] < 114 || player_scores[i] > 210 && player_scores[i] < 214
					|| player_scores[i] > 310 && player_scores[i] < 314
					|| player_scores[i] > 410 && player_scores[i] < 414) {

				player_special_card_count++;

			}
			// the following condition checks if value of number card is 10
			else if (player_scores[i] % 10 == 0) {
				player_num_card_value += 10;
			} else {
				player_num_card_value += (player_scores[i] % 10);
			}

			if (dealer_scores[i] > 110 && dealer_scores[i] < 114 || dealer_scores[i] > 210 && dealer_scores[i] < 214
					|| dealer_scores[i] > 310 && dealer_scores[i] < 314
					|| dealer_scores[i] > 410 && dealer_scores[i] < 414) {

				dealer_special_card_count++;

			} else if (dealer_scores[i] % 10 == 0) {
				dealer_num_card_value += 10;
			} else {
				dealer_num_card_value += (dealer_scores[i] % 10);
			}
		}

		player_num_card_value = player_num_card_value % 10;
		dealer_num_card_value = dealer_num_card_value % 10;

		if (player_special_card_count > dealer_special_card_count) {
			return "P";
		}

		else if (player_special_card_count < dealer_special_card_count) {
			return "D";
		}

		else {
			if (player_num_card_value > dealer_num_card_value) {
				return "P";
			}

			else if (player_num_card_value < dealer_num_card_value) {
				return "D";
			}

			// return dealer as winner if none of the conditions above are satisfied.
			return "D";
		}

	}
}
