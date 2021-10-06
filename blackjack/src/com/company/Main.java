package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "y";
        String compActive = "y";
        // create an array for the deck of cards each section represents a different suit
        int[][] deck = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10}};
        // create arrays the max size of a hand for players (-1 is just a placeholder)
        int[] playerHand = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int[] compHand = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int playerHandPos = 0;
        int compHandPos = 0;
        int j = 0;
        System.out.println("your cards are");
        while (playAgain.equals("y")) {
            //gen starting cards
            do {

                int suit1 = random.nextInt(3);
                int cardDrawn1 = random.nextInt(11);
                int suit2 = random.nextInt(3);
                int cardDrawn2 = random.nextInt(11);
                if (deck[suit1][cardDrawn1] != -1 && deck[suit2][cardDrawn2] != -1) {
                    cardDrawn1 = deck[suit1][cardDrawn1];
                    deck[suit1][cardDrawn1] = -1;
                    playerHand[playerHandPos] = cardDrawn1;
                    cardDrawn2 = deck[suit2][cardDrawn2];
                    deck[suit2][cardDrawn2] = -1;
                    compHand[compHandPos] = cardDrawn2;
                    playerHandPos++;
                    compHandPos++;
                    switch (suit1) {
                        case 0 -> System.out.println(playerHand[j] + " of diamonds");
                        case 1 -> System.out.println(playerHand[j] + " of hearts");
                        case 2 -> System.out.println(playerHand[j] + " of spades");
                        case 3 -> System.out.println(playerHand[j] + " of clubs");
                    }
                    j++;
                } else {
                    break;
                }

            } while (j <= 1);

            System.out.println("Do you want another card");
            String needCard = input.next();
            //needCard = "y";
            if (needCard.equals("y")) {
                int suit = random.nextInt(3);
                int cardDrawn = random.nextInt(11);
                if (deck[suit][cardDrawn] != -1) {
                    cardDrawn = deck[suit][cardDrawn];
                    deck[suit][cardDrawn] = -1;
                    playerHand[playerHandPos] = cardDrawn;
                    playerHandPos++;
                    System.out.println("you drew a ");
                    switch (suit) {
                        case 0 -> System.out.println(playerHand[j] + " of diamonds");
                        case 1 -> System.out.println(playerHand[j] + " of hearts");
                        case 2 -> System.out.println(playerHand[j] + " of spades");
                        case 3 -> System.out.println(playerHand[j] + " of clubs");
                    }

                }
                //needCard = "n";
            }
            else {
                System.out.println("lets see who wins");
                //computers turn
                int compTotal = 0;
                for (int i = 0; compHand[i] != -1 && compActive.equals("y"); i++) {
                    compTotal = compTotal + compHand[i];
                    if (compTotal > 21) {
                        System.out.println("the computer went bust with a total of "+compTotal);
                        playAgain = "n";
                        compActive = "n";
                    }
                    if (compTotal == 21) {
                        System.out.println("you lose, the computer got 21");
                        playAgain = "n";
                        compActive = "n";
                        break;
                    }
                    if (compTotal < 15) {
                        int suit = random.nextInt(3);
                        int cardDrawn = random.nextInt(11);
                        if (deck[suit][cardDrawn] != -1) {
                            cardDrawn = deck[suit][cardDrawn];
                            deck[suit][cardDrawn] = -1;
                            compHand[compHandPos] = cardDrawn;
                            compHandPos++;
                        }
                    }
                }
                //break;
            int total = 0;
            for (int i = 0; playerHand[i] != -1; i++) {
                total = total + playerHand[i];
                if (total > 21) {
                    System.out.println("bust");
                    playAgain = "n";
                }
                if (total == 21) {
                    System.out.println("you win");
                    playAgain = "n";
                    break;
                }
            }
            System.out.println("your total is " + total);


                //System.out.println("do you want to play again y or n");
                //playAgain = input.next();
            }

        }


    }
}