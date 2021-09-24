import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class creates 5 panel objects, and all the components to be added to
 * them (for example JButtons, JLabels). It then adds all the components to
 * their respective panels and then the panel to the main Panel. This is done in
 * the method displayGame(). Another method shuffleDeck() is called, that
 * returns the shuffled deck at the beginning of each round.
 * 
 * @author Areeb Nadeem
 *
 */
public class MainPanel {

	JButton btn_start;
	ImageIcon Image1;
	ImageIcon Image2;
	ImageIcon Image3;
	ImageIcon Image4;
	ImageIcon Image5;
	ImageIcon Image6;

	JLabel label_Image1;
	JLabel label_Image2;
	JLabel label_Image3;
	JLabel label_Image4;
	JLabel label_Image5;
	JLabel label_Image6;

	JPanel mainPanel;
	JPanel DealerPanel;
	JPanel PlayerPanel;
	JPanel RpCardBtnPanel;
	JPanel ButtonPanel;
	JPanel InfoPanel;

	JButton btn_rpcard1;
	JButton btn_rpcard2;
	JButton btn_rpcard3;
	JButton btn_result;

	JLabel label_bet;
	JTextField txt_inputbet;
	JLabel label_info;
	JLabel label_money;

	String money = "100";

	/**
	 * This method adds all the components to the panels and adds the panels to the
	 * main Panel.
	 * 
	 * @return JPanel that contains all the different panels
	 */

	public JPanel displayGame() {
		mainPanel = new JPanel();
		DealerPanel = new JPanel();
		PlayerPanel = new JPanel();
		RpCardBtnPanel = new JPanel();
		ButtonPanel = new JPanel();
		InfoPanel = new JPanel();

		label_Image1 = new JLabel();
		label_Image2 = new JLabel();
		label_Image3 = new JLabel();

		Image1 = new ImageIcon("card_back.gif");
		label_Image1.setIcon(Image1);

		Image2 = new ImageIcon("card_back.gif");
		label_Image2.setIcon(Image2);

		Image3 = new ImageIcon("card_back.gif");
		label_Image3.setIcon(Image3);

		DealerPanel.add(label_Image1);
		DealerPanel.add(label_Image2);
		DealerPanel.add(label_Image3);

		label_Image4 = new JLabel();
		label_Image5 = new JLabel();
		label_Image6 = new JLabel();

		Image4 = new ImageIcon("card_back.gif");
		label_Image4.setIcon(Image4);

		Image5 = new ImageIcon("card_back.gif");
		label_Image5.setIcon(Image5);

		Image6 = new ImageIcon("card_back.gif");
		label_Image6.setIcon(Image6);

		PlayerPanel.add(label_Image4);
		PlayerPanel.add(label_Image5);
		PlayerPanel.add(label_Image6);

		btn_rpcard1 = new JButton("Replace Card 1");
		btn_rpcard2 = new JButton("Replace Card 2");
		btn_rpcard3 = new JButton("Replace Card 3");

		btn_rpcard1.setEnabled(false);
		btn_rpcard2.setEnabled(false);
		btn_rpcard3.setEnabled(false);

		RpCardBtnPanel.add(btn_rpcard1);
		RpCardBtnPanel.add(btn_rpcard2);
		RpCardBtnPanel.add(btn_rpcard3);

		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green);

		label_bet = new JLabel("Bet: $");
		txt_inputbet = new JTextField(10);
		btn_start = new JButton("Start");
		btn_result = new JButton("Result");

		btn_result.setEnabled(false);

		ButtonPanel.add(label_bet);
		ButtonPanel.add(txt_inputbet);
		ButtonPanel.add(btn_start);
		ButtonPanel.add(btn_result);

		label_info = new JLabel("Please place your bet! Amount of money you have:");
		label_money = new JLabel("$" + money);

		InfoPanel.add(label_info);
		InfoPanel.add(label_money);

		mainPanel.setLayout(new GridLayout(5, 1));
		mainPanel.add(DealerPanel);
		mainPanel.add(PlayerPanel);
		mainPanel.add(RpCardBtnPanel);
		mainPanel.add(ButtonPanel);
		mainPanel.add(InfoPanel);

		return mainPanel;
	}

	/**
	 * This method is called every time a game round is started and returns the
	 * shuffled deck
	 * 
	 * @return shuffled cards
	 */
	public String[] shuffleDeck() {

		String cards[] = { "card_11.gif", "card_110.gif", "card_111.gif", "card_112.gif", "card_113.gif", "card_12.gif",
				"card_13.gif", "card_14.gif", "card_15.gif", "card_16.gif", "card_17.gif", "card_18.gif", "card_19.gif",
				"card_21.gif", "card_210.gif", "card_211.gif", "card_212.gif", "card_213.gif", "card_22.gif",
				"card_23.gif", "card_24.gif", "card_25.gif", "card_26.gif", "card_27.gif", "card_28.gif", "card_29.gif",
				"card_31.gif", "card_310.gif", "card_311.gif", "card_312.gif", "card_313.gif", "card_32.gif",
				"card_33.gif", "card_34.gif", "card_35.gif", "card_36.gif", "card_37.gif", "card_38.gif", "card_39.gif",
				"card_41.gif", "card_410.gif", "card_411.gif", "card_412.gif", "card_413.gif", "card_42.gif",
				"card_43.gif", "card_44.gif", "card_45.gif", "card_46.gif", "card_47.gif", "card_48.gif",
				"card_49.gif" };

		// the for loop below swaps a random card with every card in the deck
		for (int i = 0; i < 52; i++) {
			int rand_card = (int) ((Math.random() * 52));

			String temp = cards[i];
			cards[i] = cards[rand_card];
			cards[rand_card] = temp;

		}

		return cards;

	}
}
