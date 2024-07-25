import java.util.*;

public class game_runner {
    
    int roll() {
        // rolls a move for the player
        return (int) (Math.random() * 13) + 1;
    }

    static square[] boardMaker() {
        square[] board = new square[40];

        for (int i = 0; i < 40; i++) {
            board[i] = new square(); // Instantiate each square object
        }

        for (int i = 0; i < 40; i++) {
            board[i].color = "\u001B[0m"; // Instantiate each square color
        }

        // making the board (square array), setting the name and the atributes of each
        // square

        board[0].hasGo = true;
        board[0].name = "Go";

        board[1].hasProperty = true;
        board[1].name = "Dining Hall";
        board[1].value = 60;

        board[2].isChance = true;

        board[3].hasProperty = true;
        board[3].name = "The Kove";
        board[3].value = 60;

        board[4].isChance = true;
        board[5].empty = true;

        board[6].hasProperty = true;
        board[6].name = "Mcdonalds";
        board[6].value = 100;

        board[7].isChance = true;

        board[8].hasProperty = true;
        board[8].name = "Burger King";
        board[8].value = 100;

        board[9].hasProperty = true;
        board[9].name = "Wendys";
        board[9].value = 100;

        board[10].hasJail = true;
        board[10].name = "Jail";

        board[11].hasProperty = true;
        board[11].name = "Yogurt Store";
        board[11].value = 179;

        board[12].empty = true;

        board[13].hasProperty = true;
        board[13].name = "Bakery";
        board[13].value = 140;

        board[14].hasProperty = true;
        board[14].name = "Coffee Shop";
        board[14].value = 140;

        board[15].isChance = true;

        board[16].hasProperty = true;
        board[16].name = "Papa Johns";
        board[16].value = 180;

        board[17].isChance = true;

        board[18].hasProperty = true;
        board[18].name = "Little Caesar's";
        board[18].value = 180;

        board[19].hasProperty = true;
        board[19].name = "Dominos";
        board[19].value = 180;

        board[20].empty = true;

        board[21].hasProperty = true;
        board[21].name = "Winery";
        board[21].value = 220;

        board[22].isChance = true;

        board[23].hasProperty = true;
        board[23].name = "Brewery";
        board[23].value = 220;

        board[24].hasProperty = true;
        board[24].name = "Tequilery";
        board[24].value = 220;

        board[25].isChance = true;

        board[26].hasProperty = true;
        board[26].name = "Taco Bell";
        board[26].value = 260;

        board[27].hasProperty = true;
        board[27].name = "Qdoba";
        board[27].value = 260;

        board[28].empty = true;

        board[29].hasProperty = true;
        board[29].name = "Chipotle";
        board[29].value = 280;

        board[30].hasGoToJail = true;
        board[30].name = "Go To Jail";

        board[31].hasProperty = true;
        board[31].name = "Kfc";
        board[31].value = 300;

        board[32].hasProperty = true;
        board[32].name = "Popeyes";
        board[32].value = 300;

        board[33].isChance = true;

        board[34].hasProperty = true;
        board[34].name = "Chic Fil A";
        board[34].value = 300;

        board[35].empty = true;
        board[36].isChance = true;

        board[37].hasProperty = true;
        board[37].name = "Ihope";
        board[37].value = 400;

        board[38].isChance = true;

        board[39].hasProperty = true;
        board[39].name = "Franklin's Pancakery";
        board[39].value = 500;

        board[39].isLast = true;

        for (int i = 0; i < 40; i++) {
            if (board[i].empty) {
                board[i].name = "Empty";
            }
        }

        for (int i = 0; i < 40; i++) {
            if (board[i].isChance) {
                board[i].name = "Chance";
            }
        }

        return board;

    }

    boolean checkBankrupt(int fee, player p) {
        // if your money is < than the fee
        if ((p.money - fee) < 0) {
            return true;
        }
        return false;
    }

    boolean checkProperty(player p, square[] b) {
        // check if you own any properties by looping through
        boolean check = false;
        for (int i = 0; i < 40; i++) {
            if (b[i].owner == p) {
                check = true;
            }
        }
        return check;
    }

    boolean checkEliminated(player p, square[] b) {
        // check if you have no money and no property
        if (p.money <= 0 && checkProperty(p, b) == false) {
            return true;
        } else
            return false;
    }

    void eliminate(player[] players, int counter, square[] b) {
        // goes to every square and makes sure it does not have an owner
        for (int i = 0; i < 40; i++) {
            if (b[i].owner == players[counter])
                b[i].owner = null;
        }
        // take their money
        players[counter].money = 0;

    }

    // chances
    void goToJail(player[] players, int counter, square[] b)
    {
                        players[counter].on = b[10];
                        players[counter].position = 10;
                        System.out.println(
                                "Player " + (players[counter].number + 1) + " is on " + players[counter].on.name);
                        System.out.println("You lost a hundred bucks! womp womp");
                        players[counter].money -= 100;
                        System.out.println("Your balance is " + players[counter].money);

    }

    void Birthday(player p, player[] ps) {
        // take $80 from everybody and give it to the player
        System.out.println("Its your birthday! Everyone will give you $80");
        for (int i = 0; i < ps.length; i++) {
            ps[i].money -= 80;
            p.money += 80;
        }
        for (int i = 0; i < ps.length; i++) {
            System.out.println("Player " + (ps[i].number + 1) + "'s balance: " + ps[i].money);
        }
    }

    void Pancakes(game_runner g, player[] ps, int counter, String[] player_colors, player p, square[] b) {
        // teleport you to Francakelin
        p.on = b[39];
        p.position = 39;
        landOnProp(g, b, ps, counter, player_colors, 0);
    }

    void SweetTooth(game_runner g, player p, square[] b, player[] players, int counter, String[] player_colors) {
        System.out.println("You ate too many sweets and lost $100!");
        // takes money and makes sure you are not bankrupt
        boolean check = false;
        for (int i = 0; i < 40; i++) {
            if (b[i].hasProperty) {
                if (b[i].owner == players[counter]) {
                    check = true;
                }
            }
        }
        if (checkBankrupt(100, p) && check) {
            System.out.println("You could not afford it. Try to sell a property");
            sellProperty(g, b, players, counter, player_colors);
            // use recursion to continously check if they can afford it
            SweetTooth(g, p, b, players, counter, player_colors);
        } else if (checkBankrupt(100, p)) {
            System.out.println("You are out of money!");

        }

        p.money -= 100;
    }

    void BogoSort(square[] b, player[] p) {
        // BOGOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        for (int i = 0; i < p.length; i++) {
            if (p[i] != null) {
                int spot = (int) (Math.random() * 39) + 1;
                p[i].on = b[spot];
                p[i].position = spot;
            }
        }

    }

    void Alcholism(game_runner g, player p, square[] b, player[] players, int counter, String[] player_colors)
    {
        if(players[counter].position<21)
        {
            System.out.println("You have been arrested for underage possesion of pancakohol!");
            goToJail(players, counter, b);
        }
        else
        {  
            System.out.println("You have been sent to the winery");
            players[counter].position=21;
            players[counter].on = b[21];
            landOnProp(g, b, players, counter, player_colors, counter);
        }

    }
    void landOnProp(game_runner game_runner, square[] b, player[] players, int counter, String[] player_colors,
            int buying) {
        Scanner sc = new Scanner(System.in);

        // if you landed on a property
        if (players[counter].on.hasProperty) {
            if (players[counter].money < players[counter].on.value) {
                // if you cannot afford it:
                System.out.println("You can't buy this property");
            } else {
                // if it doesnt have an owner
                if (players[counter].on.owner == null) {
                    System.out.println();
                    // prompt for purchase
                    System.out.println("Would you like to buy " + players[counter].on.name + " for $"
                            + players[counter].on.value + "? Press 1 to buy, 2 to not");
                    buying = sc.nextInt();
                    if (buying == 1) {
                        // make purchase
                        System.out.println();
                        System.out.println("You have purchased " + players[counter].on.name + " for $"
                                + players[counter].on.value);
                        // subtract money
                        players[counter].money -= players[counter].on.value;
                        // give ownership
                        players[counter].on.owner = players[counter];
                        System.out.println(
                                "Player " + (players[counter].number + 1) + "'s balance = $" + players[counter].money);
                        // change color
                        players[counter].on.color = player_colors[players[counter].number];
                    }
                } else {
                    // if you already own it
                    if (players[counter].on.owner == players[counter]) {
                        System.out.println("You own this property");
                    } else {
                        // rent
                        System.out.println();
                        System.out.println("You landed on square owned by " + (players[counter].on.owner.number + 1));
                        // rent is value x .35
                        int rent_val = (int) (players[counter].on.value * .35);
                        System.out.println("Rent amount is $" + rent_val);

                        // if you cant afford it, prompt for selling properties
                        while (players[counter].money <= rent_val) {
                            System.out.println("You cannot afford to pay rent, you must sell a property");
                            sellProperty(game_runner, b, players, counter, player_colors);

                        }
                        
                        //subtract money
                        players[counter].money -= rent_val;
                        System.out.println("Player " + (players[counter].number + 1) + "'s balance = $"
                                + players[counter].money);
                        //add to landlord
                        players[counter].on.owner.money += rent_val;
                        System.out.println("Player " + (players[counter].on.owner.number + 1) + "'s balance = $"
                                + players[counter].on.owner.money);

                    }
                }
            }
        }

    }

    void sellProperty(game_runner game_runner, square[] b, player[] players, int counter, String[] player_colors) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which property would you like to sell? ");
        String selling = sc.nextLine();

        boolean propertyFound = false;

        //loop through and check if you own a property
        for (int c = 0; c < 40; c++) {
            if (b[c].name.equals(selling)) {
                if (b[c].owner == players[counter]) {
                    System.out.println("Successfully sold " + b[c].name);
                    players[counter].money += b[c].value;
                    b[c].owner = null;
                    System.out.println("Your balance is " + players[counter].money);
                    b[c].color = "\u001B[0m"; //reset color
                    propertyFound = true;
                    break;
                } else {
                    System.out.println("You don't own this property.");
                    propertyFound = true; // Property found but not owned by player
                    break;
                }
            }
        }

        if (!propertyFound) {
            System.out.println("Property not found.");
        }
        if (players[counter].money <= 0) {
            sellProperty(game_runner, b, players, counter, player_colors);
            if (checkEliminated(players[counter], b) == true) {
                System.out.println("You have been eliminated due to a lack of money.");
                if (counter == 3) {
                    counter = 0;
                } else {
                    counter = counter + 1;
                }

            }
        }


    }

    void printBoard(square[] board, player[] players) {
        String reset = "\u001B[0m";
        // Print middle row of square names

        for (int i = 20; i <= 30; i++) {
            System.out.print(board[i].color + board[i].name + reset + "    ");
        }
        System.out.println();
        System.out.println();

        // Print bottom row of square names
        System.out.print(board[19].color + board[19].name + reset
                + "                                                              ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[31].color + board[31].name + reset + "    ");
        System.out.println();

        System.out.print(
                board[18].color + board[18].name + reset + "                                                      ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[32].color + board[32].name + reset + "    ");
        System.out.println();

        System.out.print(board[17].color + board[17].name + reset
                + "                                                               ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[33].color + board[33].name + reset + "    ");
        System.out.println();

        System.out.print(board[16].color + board[16].name + reset
                + "                                                           ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[34].color + board[34].name + reset + "    ");
        System.out.println();

        System.out.print(board[15].color + board[15].name + reset
                + "                                                               ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[35].color + board[35].name + reset + "    ");
        System.out.println();

        System.out.print(board[14].color + board[14].name + reset
                + "                                                          ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[36].color + board[36].name + reset + "    ");
        System.out.println();

        System.out.print(board[13].color + board[13].name + reset
                + "                                                               ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[37].color + board[37].name + reset + "    ");
        System.out.println();

        System.out.print(board[12].color + board[12].name + reset
                + "                                                                ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[38].color + board[38].name + reset + "     ");
        System.out.println();

        System.out.print(
                board[11].color + board[11].name + reset + "                                                         ");
        for (int i = 0; i < 9; i++) {
            System.out.print("    ");
        }
        System.out.println(board[39].color + board[39].name + reset + "     ");
        System.out.println();

        // Print bottom row of square names
        for (int i = 10; i >= 0; i--) {
            System.out.print(board[i].color + board[i].name + reset + "    ");
        }
        System.out.println();
    }

    static boolean checkEnd(int threshold, player[] players, square[] b, game_runner game_runner) {
        int counter = 0;
        //check if 3 players are eliminated
        for (int i = 0; i < players.length; i++) {
            if (game_runner.checkEliminated(players[i], b) == true) {
                counter++;
            }
        }

        if (counter == threshold) {
            return true;
        } else

            return false;
    }

    player findWinner(player[] p, square[] b) {
        //find who is not bankrupt
        player winner = null;
        for (int i = 0; i < 4; i++) {
            if (checkEliminated(p[i], b) == false)
                winner = p[i];

        }
        return winner;
    }

    public static void main(String[] args) {
        // make the board and set everybodys colors
        game_runner game_runner = new game_runner();
        square[] b = boardMaker();

        int counter = 0;

        Scanner sc = new Scanner(System.in);

        //make a players array
        player[] players = new player[4];
        for (int i = 0; i < 4; i++) {
            players[i] = new player();
            players[i].number = i;
        }
        String white="\u001B[0m";

        String[] player_colors = new String[4];
        player_colors[0] = "\u001B[31m";
        player_colors[1] = "\u001B[34m";
        player_colors[2] = "\u001B[32m";
        player_colors[3] = "\u001B[33m";

        //print board
        game_runner.printBoard(b, players);

        System.out.println();
        System.out.println("Welcome to Pancakeopoly!");
        System.out.println("A game made by David Balzac, Killian Cunjak, and Samuel Yan");
        System.out.println("Player 1 is "+player_colors[0]+"red"+white);
        System.out.println("Player 2 is "+player_colors[1]+"purple"+white);
        System.out.println("Player 3 is "+player_colors[2]+"green"+white);
        System.out.println("Player 4 is "+player_colors[3]+"yellow"+white);
        while (!checkEnd(3, players, b, game_runner)) {
            //while game not finished
            while (game_runner.checkEliminated(players[counter], b)) {
                //skip players if they are eliminated
                if (counter == 3) {
                    System.out.println("Player " + (counter + 1) + " has been skipped.");
                    counter = 0;

                } else if (counter == 0) {
                    System.out.println("Player 1 has been skipped");
                    counter = counter + 1;
                } else if (counter == 1) {
                    System.out.println("Player 2 has been skipped");
                    counter = counter + 1;
                } else if (counter == 2) {
                    System.out.println("Player 3 has been skipped");
                    counter = counter + 1;
                }

            }
            System.out.println();
            //print which players turn it is and their position
            System.out.println("It is player " + (players[counter].number + 1) + " 's turn. They have: $"
                    + players[counter].money);
            if (players[counter].on != null) {
                System.out.println("Your position is " + players[counter].on.name);
            }
            if (players[counter].money <= 0) {
                game_runner.sellProperty(game_runner, b, players, counter, player_colors);
            }
            System.out.println("To roll the dice, press 1. To sell a property, press 2");
            int userInput = sc.nextInt();

            int roll;

            switch (userInput) {
                case 1:

                
                    // roll
                    roll = game_runner.roll();
                    System.out.println();
                    System.out.println("Player " + (players[counter].number + 1) + " rolled a " + roll);
                    // increment position
                    if (players[counter].hasCar){
                        System.out.println("You had a car, so you will move double your roll");
                        roll = roll*2;
                        players[counter].hasCar = false; 
                    }
                    // moves player
                    
                    for (int j = 0; j < roll; j++)
                        if (players[counter].position + 1 == 40) {
                            players[counter].position = 0;
                            System.out.println(
                                    "Player " + (players[counter].number + 1) + " passed go and collected 200$!");
                                    //pass go
                            players[counter].money += 200;
                            players[counter].on = b[0];
                            players[counter].position = 0;
                            System.out.println("Player " + (players[counter].number + 1) + "'s balance: "
                                    + players[counter].money);
                        } else {

                            players[counter].position += 1;
                            players[counter].on = b[players[counter].position];
                        }
                    if (players[counter].on != null)
                        //if the square you landed on is not special
                        System.out.println("Your position is " + players[counter].on.name);
                    // prints landing square

                    // Chance cards
                    if (players[counter].on.hasGoToJail) {
                        System.out.println("You have been arrested for pancake laundering!");
                        game_runner.goToJail(players, counter, b);
                        
                    }

                    if (players[counter].on.isChance) {
                        int bogo = (int) (Math.random() * 6) + 1;
                        //if on a chance, pick a random chance card
                        switch (bogo) {
                            case 1:
                                //Bogoroni
                                System.out.println("Bogo Sorted! All players have moved to random spots on the board");
                                game_runner.BogoSort(b, players);
                                System.out.println("Player 1's position is "+ players[0].on.name);
                                System.out.println("Player 2's position is "+ players[1].on.name);
                                System.out.println("Player 3's position is "+ players[2].on.name);
                                System.out.println("Player 4's position is "+ players[3].on.name);
                                break;

                            case 2:
                                game_runner.Birthday(players[counter], players);
                                break;

                            case 3:
                                game_runner.SweetTooth(game_runner, players[counter], b, players, counter,
                                        player_colors);

                                System.out.println("Your balance is now $ " + players[counter].money);
                                break;

                            case 4:
                                System.out.println("Pancakes! You went to Franklin's Pancakery");
                                game_runner.Pancakes(game_runner, players, counter, player_colors, players[counter], b);
                                game_runner.printBoard(b, players);
                                break;
                            case 5:
                                System.out.println("You won a car! Next turn you will move double your roll");
                                players[counter].hasCar = true; 
                                break;
                            case 6:
                                System.out.println("Alcholism!!!");
                                System.out.println("If your board position is under 21 you will go to jail, otherwise you will go to the winery");
                                game_runner.Alcholism(game_runner, players[counter], b, players, counter, player_colors);
                                break; 
                            default:
                            
                                break;
                        }
                    }

                    //check if its a property
                    game_runner.landOnProp(game_runner, b, players, counter, player_colors, counter);
                    // increments player
                    if (counter == 3) {
                        counter = 0;
                        System.out.println();
                        game_runner.printBoard(b, players);

                    } else {
                        counter++;
                        System.out.println();
                        game_runner.printBoard(b, players);

                    }
                    break;
                case 2:
                    //case 2 is sell
                    game_runner.sellProperty(game_runner, b, players, counter, player_colors);
                    break;

                default:
                    System.out.println("Number not recognized");
                    break;
            }

        }
        System.out.println("Player " + (game_runner.findWinner(players, b).number + 1) + " has eaten the most pancakes and won with $"+(game_runner.findWinner(players, b).money)+"!!!!!!");
    }

}
