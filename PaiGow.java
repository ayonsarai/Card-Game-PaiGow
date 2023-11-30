// Programer: Sarai Ayon
// Class: CS&141 F2P
// Date: 10/19/2023
// Assignment: Lab 4Deck of Cards
// Reference Materials: Dietel Class ArrayList ch6 pg.222, ArrayList<> Dietel ch16 pg.608. Java PP slides Chapter 10 ArrayLista
// Chat GBT, CoPiolot, 1-1 tutoring with Tsaquif 
// Purpose: Pai Gow is a fun game that you can play with a friend. In the game, you use special tiles instead of cards.
// There are 32 tiles in the game, and you and your friend each get a set of tiles to play with. To make the game more exciting, the game 
// uses a special tool called a random number generator. This tool helps to make the game more fun by randomly choosing which tiles you and 
// your friend get to play with. The game also uses something called a "list" to keep track of the tiles and the players' hands. This helps to make
// sure that the game is fair and that everyone is playing by the same rules. Overall, Pai Gow is a fun game that you can play with a friend using special 
// tiles and a random number generator.


import java.util.*;

public class PaiGow {
   private static final int NUM_TILES = 32;
   private static final int NUM_PLAYERS = 2;

   private static final Scanner scanner = new Scanner(System.in);
   private static final Random random = new Random();

   private static List<Tile> tiles;
   private static List<Tile>[] hands;
   private static final String[] SUIT_NAMES = {"Hearts", "Diamonds", "Clubs", "Spades"};
   
   public static void main(String[] args) {
      // Initialize the tiles
      tiles = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 8; j++) {
            tiles.add(new Tile(i, j));
         }// End of for loop
      }// End of for loop
   
      // Initialize the hands
      hands = new List[NUM_PLAYERS];
      for (int i = 0; i < NUM_PLAYERS; i++) {
         hands[i] = new ArrayList<>();
      }// End of for loop
   
      // Shuffle the tiles
      Collections.shuffle(tiles);
   
      // Deal the tiles
      for (int i = 0; i < NUM_TILES; i++) {
         hands[i % NUM_PLAYERS].add(tiles.get(i));
      }// End of for loop
   
      // Sort the tiles in each hand
      for (int i = 0; i < NUM_PLAYERS; i++) {
         Collections.sort(hands[i]);
      }// End of for loop
   
      // Print the hands
      for (int i = 0; i < NUM_PLAYERS; i++) {
         System.out.println("Player " + (i + 1) + "'s hand: " + hands[i]);
      }// End of for loop
   
      // Determine the winner
      int winner = 0;
      int maxScore = 0;
      for (int i = 0; i < NUM_PLAYERS; i++) {
         int score = getScore(hands[i]);
         if (score > maxScore) {
            winner = i;
            maxScore = score;
         }// End of if statement
      }// End of for loop
   
      // Print the winner
      System.out.println("Player " + (winner + 1) + " wins with a score of " + maxScore);
   }// End of main method

   // Compute the score of a hand
   private static int getScore(List<Tile> hand) {
      int score = 0;
      for (int i = 0; i < hand.size(); i += 2) {
         Tile high = hand.get(i);
         Tile low = hand.get(i + 1);
         score += high.getValue() * 10 + low.getValue();
      }// End of for loop
      return score;
   }// End of getScore method

   // A tile
   private static class Tile implements Comparable<Tile> {
      private final int suit;
      private final int value;
      // Constructor
      public Tile(int suit, int value) {
         this.suit = suit;
         this.value = value;
      }// End of constructor
   
   
      public int getSuit() {
         return suit;
      }// End of getSuit method
   
   
      public int getValue() {
         return value;
      }// End of getValue method
   
   
      @Override
      public int compareTo(Tile other) {
         if (suit != other.suit) {
            return suit - other.suit;
         } else {
            return value - other.value;
         }// End of if statement
      }// End of compareTo method
   
      // Return a string representation of this tile with suit name
      @Override
      public String toString() {
         String suitName = SUIT_NAMES[suit];
         return "[" + suitName + "," + value + "]";
      } // End of toString method
   
   }// End of class Tile

}// End of class PaiGow