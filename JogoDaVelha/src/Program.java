import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Program
{

	public static void main(String[] args)
	{
		// Troca para fonte mono-espaçada para melhorar a legibilidade da tabela
		UIManager.put("OptionPane.messageFont", new Font("Source Code Pro", Font.BOLD, 14));

		String[] players = {"X", "O"};
		String[][] hash = buildEmptyHash(3, 3);

		playMatch(hash, players);
		String winner = getWinnerFromMatch(hash, players);

		showResult(hash, winner);
	}

	static void playMatch(String[][] hash, String[] players)
	{
		boolean hasWinner;
		do
		{
			for (String player : players)
			{
				playRound(hash, player);
				hasWinner = getWinnerFromMatch(hash, players) != null;

				if (hasWinner) return;
			}
		}
		while (true);
	}

	static void playRound(String[][] hash, String player)
	{
		boolean validPlay;
		int[] play;

		do
		{
			play = readPlay(hash, player);
			validPlay = validatePlay(hash, play);

			if (!validPlay)
			{
				JOptionPane.showMessageDialog(null, "Jogada inválida", "Erro",
					JOptionPane.WARNING_MESSAGE);
			}
		}
		while (!validPlay);

		writePlay(hash, play, player);

		if (!isNextRoundPossible(hash))
		{
			JOptionPane.showMessageDialog(null, "Deu velha!\n" + "----------\n" + buildFlatHash(hash),
				"Fim de jogo", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}

	static String getWinnerFromMatch(String[][] matchHash, String[] players)
	{
		for (String player : players)
		{
			if (hasWon(matchHash, player))
			{
				return player;
			}
		}
		return null;
	}

	static String[][] buildEmptyHash(int lines, int columns)
	{
		String[][] emptyHash = new String[lines][columns];

		for (int i = 0; i < lines; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				emptyHash[i][j] = " ";
			}
		}
		return emptyHash;
	}

	static String buildFlatHash(String[][] hash)
	{
		StringBuilder flatHash = new StringBuilder();
		flatHash.append("  a b c\n");

		for (int i = 0; i < hash.length; i++)
		{
			flatHash.append((i + 1));
			flatHash.append("|");

			for (int j = 0; hash.length > j; j++)
			{
				flatHash.append(hash[i][j]);
				flatHash.append("|");
			}
			flatHash.append("\n");
		}
		return flatHash.toString();
	}

	static int[] readPlay(String[][] currentHash, String currentPlayer)
	{
		int[] play = new int[2];
		String message = "Jogador " + currentPlayer + ", escolha a linha da jogada:\n";
		message += "--------------------------------------\n";
		message += buildFlatHash(currentHash);

		int line;
		String column;

		do
		{
			line = safeParseInt(JOptionPane.showInputDialog(message), 0);

			if (!Arrays.asList(1, 2, 3).contains(line))
			{
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro",
					JOptionPane.WARNING_MESSAGE);
			}
		}
		while (!Arrays.asList(1, 2, 3).contains(line));

		play[0] = line - 1;

		message = "Agora escolha a coluna:\n";
		message += "----------------------\n";
		message += buildFlatHash(currentHash);

		do
		{
			column = JOptionPane.showInputDialog(message).trim().toLowerCase();

			if (!Arrays.asList("a", "b", "c").contains(column))
			{
				JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro",
					JOptionPane.WARNING_MESSAGE);
			}
		}
		while (!Arrays.asList("a", "b", "c").contains(column));

		switch (column)
		{
			case "b":
				play[1] = 1;
				break;
			case "c":
				play[1] = 2;
				break;
			default:
				break;
		}
		return play;
	}

	static boolean validatePlay(String[][] hash, int[] play)
	{
		return " ".equals(hash[play[0]][play[1]]);
	}

	static void writePlay(String[][] hash, int[] play, String player)
	{
		hash[play[0]][play[1]] = player;
	}

	static boolean hasWon(String[][] hash, String player)
	{
		return wonDiagonally(hash, player) || wonHorizontally(hash, player) || wonVertically(hash,
			player);
	}

	static boolean wonDiagonally(String[][] hash, String player)
	{
		String[] d1 = new String[hash.length];
		String[] d2 = new String[hash.length];

		for (int i = 0; i < hash.length; i++)
		{
			d1[i] = hash[i][i];
		}

		for (int i = hash.length; i > 0; i--)
		{
			d2[i - 1] = hash[hash.length - i][i - 1];
		}

		return Arrays.stream(d1).filter(player::equals).count() == hash.length
			|| Arrays.stream(d2).filter(player::equals).count() == hash.length;
	}

	static boolean wonHorizontally(String[][] hash, String player)
	{
		for (String[] line : hash)
		{
			if (Arrays.stream(line).filter(player::equals).count() == hash.length)
			{
				return true;
			}
		}
		return false;
	}

	static boolean wonVertically(String[][] hash, String player)
	{
		String[] column = new String[hash.length];

		for (int i = 0; i < hash.length; i++)
		{
			for (int j = 0; j < hash.length; j++)
			{
				column[j] = hash[j][i];
			}

			if (Arrays.stream(column).filter(player::equals).count() == hash.length)
			{
				return true;
			}
		}
		return false;
	}

	static boolean isNextRoundPossible(String[][] hash)
	{
		List<String> flatContent = new ArrayList<>();

		for (String[] line : hash)
		{
			flatContent.addAll(Arrays.asList(line));
		}

		return flatContent.stream().anyMatch(" "::equals);
	}

	static void showResult(String[][] finalHash, String winner)
	{
		String message = "O Jogador " + winner + " ganhou!\n";
		message += "-------------------\n";
		message += buildFlatHash(finalHash);

		JOptionPane.showMessageDialog(null, message, "Resultado", JOptionPane.INFORMATION_MESSAGE);
	}

	static int safeParseInt(String stringToParse, int fallback)
	{
		try
		{
			return Integer.parseInt(stringToParse);
		}
		catch (NumberFormatException e)
		{
			return fallback;
		}
	}
}
