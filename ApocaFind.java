import java.util.Random;
import java.util.Scanner;

public class ApocaFind {
  public static void main(String[] args) {
    // Location strings
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int health = 50; // declare health variable
    System.out.println(
        "Welcome to ApocaFind! Receive instant zombie stats and survival plans suited for your location.");
    String[] Provinces_Territories = {"Ontario", "Alberta", "Saskatchewan",
        "British Columbia", "Manitoba", "Newfoundland and Labrador",
        "Nova Scotia", "Prince Edward Island", "Quebec", "New Brunswick",
        "Yukon", "Northwest Territories"};
    // Randomized zombie populations across the country (for each province and
    // territory)
    int[] zombie_population = new int[Provinces_Territories.length];
    for (int i = 0; i < Provinces_Territories.length; i++) {
      zombie_population[i] = (int) (Math.random() * 50001);
    }
    // Asks user what province in Canada they are from (determines zombie stats)
    System.out.println("Enter province in Canada:");
    String ans = scanner.next();
    // Conditions for if answer is in Provinces_Territories string
    for (int i = 0; i < Provinces_Territories.length; i++) {
      if (ans.equalsIgnoreCase(Provinces_Territories[i])) {
        System.out.println("Your zombie population is:"
            + " " + zombie_population[i]);
        break;
      }
    }

    // Survival packs run through a decision program
    String pack_WeaponsFood = "1. Weapons and Food Pack";
    String pack_Essentials = "2. Essentials and Food Pack";
    String[] weapon_Pack = {
        "Crossbow", "AK-47", "Zombie Knife", "Acid", "Smoke bomb"};
    String[] food_Pack = {
        "Canned food (Veg)", "Canned food (Non-Veg)", "Fruits", "Protein Bars"};
    String[] essentials_Pack = {
        "First-aid kit", "Flashlight", "Backpack", "Binoculars", "Tent"};

    // Prints options for decision program
    System.out.println(pack_WeaponsFood);
    System.out.println(pack_Essentials);

    System.out.println("Choose your survival pack:");
    int selection = scanner.nextInt();

    // Conditions for if user selects #1 pack
    if (selection == 1) {
      int weaponIndex1 = random.nextInt(weapon_Pack.length);
      int foodIndex1 = random.nextInt(food_Pack.length);

      // Prints items from selected package
      System.out.println("Weapons: " + weapon_Pack[weaponIndex1] + ", ");
      System.out.println("Food: " + food_Pack[foodIndex1] + ", ");

      // Calculate the score of the pack
      int[] itemScores = {10, 15}; // Example scores for weapons and food
      int packScore = calculatePackScore(
          new String[] {weapon_Pack[weaponIndex1], food_Pack[foodIndex1]},
          itemScores);
      System.out.println("Pack Score: " + packScore);
    }

    // Conditions for if user selects #2 pack
    if (selection == 2) {
      int essentialIndex1 = random.nextInt(essentials_Pack.length);
      int foodIndex1 = random.nextInt(food_Pack.length);

      // Prints items from selected package
      System.out.println(
          "Essentials: " + essentials_Pack[essentialIndex1] + ", ");
      System.out.println("Food: " + food_Pack[foodIndex1] + ", ");

      // Increment essentials score if first-aid kit is included
      if (essentials_Pack[essentialIndex1].equals("First-aid kit")) {
        System.out.println(
            "You found a First-aid kit! Use it wisely to restore your health.");
        System.out.println("Your current health: " + health);

        // Mini-game: Using the first-aid kit
        System.out.println(
            "You found yourself wounded! Use the First-aid kit to restore your health.");
        System.out.println(
            "You need to guess a number between 1 and 10 to apply the first-aid kit correctly.");
        int randomNumber = generateRandomNumber(1, 10);
        System.out.println("Enter your guess:");
        int guess = scanner.nextInt();

        if (guess == randomNumber) {
          System.out.println(
              "Congratulations! You applied the first-aid kit successfully.");
          health += 20; // increasing health
          System.out.println("Your health is now: " + health);
        } else {
          System.out.println(
              "Oops! Wrong guess. The correct number was: " + randomNumber);
        }
      }
    }

    // ASCII art of shelter
    System.out.println("         []___");
    System.out.println("       /    /\\____");
    System.out.println(" (~)  /_/\\_//____/\\");
    System.out.println("  |   | || |||__||| |");

    System.out.println(
        "You stumble across a shelter! Do you want to go inside?");

    // Decision program which asks user if they want to enter the shelter
    String yes = "1. Yes";
    String no = "2. No";

    System.out.println(yes);
    System.out.println(no);

    // Reading user's choice
    int option = scanner.nextInt();

    // Condition for if user chooses to enter shelter
    if (option == 1) {
      int zombie_ShelterCount = (int) (Math.random() * 51);
      System.out.println("A mob of"
          + " " + zombie_ShelterCount + " "
          + "zombies are attacking you! Fight them off to save yourself!");
      System.out.println("Which pack did you choose?");

      // Decision program asking user which pack they chose
      String w = " 1) Weapons pack ";
      String e = " 2) Essentials pack";

      System.out.println(w);
      System.out.println(e);

      // Reading user's choice of pack
      int response = scanner.nextInt();

      // Condition for if response is 1 (Weapons pack)
      if (response == 1) {
        zombie_ShelterCount = 0;
        System.out.println(
            "You have defeated the shelter zombies, and they are eliminated!");
        // Incrementing zombie count
        zombie_ShelterCount++;

        // Post shelter fight action
        System.out.println("You encounter a friend!");
        System.out.println(
            "Careful! Friend might have been bitten by a zombie! Try a test on him!");

        // Generate a random number (0 or 1) representing heads or tails
        int result =
            random.nextInt(2); // 0 represents heads, 1 represents tails

        // Display the result of the coin toss
        if (result == 0) {
          System.out.println("The coin landed on heads! This friend is safe!");
        } else {
          System.out.println(
              "The coin landed on tails! Unfortunately, this friend is bitten! Run away from him before it's too late!");
        }

        // Condition for if friend is safe
        if (result == 0) {
          System.out.println("Friend: Told you I'm not a zombie!");
        } else {
          System.out.println(
              "Answer this question to run away from the future zombie! Else, face doom!");
          System.out.println("How to make a tissue dance?");
          System.out.println("You put a little boogie in it!");

          // Check if user entered the correct answer
          scanner.nextLine(); // Consume the newline character left by nextInt()
          String userAnswer = scanner.nextLine();

          if (userAnswer.equals("You put a little boogie in it")) {
            System.out.println("Correct! You are now in the safe zone!");
            System.out.println(
                "Time to get some food! You have reached an abandoned restaurant!");
            System.out.println("           _________##");
            System.out.println("          @\\\\\\\\\\\\##");
            System.out.println("         @@@\\\\\\\\\\\\##\\");
            System.out.println("        @@ @@\\\\\\\\\\\\\\\\");
            System.out.println("       @@@@@@@\\\\\\\\\\\\\\\\");
            System.out.println("      @@@@@@@@@----------|");
            System.out.println("      @@ @@@ @@__________|");
            System.out.println("      @@@@@@@@@__________|");
            System.out.println("      @@@@ .@@@__________|");
            System.out.println("_\\|/__@@@@__@@@__________|__");

            // Play this zombie number game!
            System.out.println("Welcome to the Zombie Math Game!");

            int score = 0;
            int rounds = 5;
            int zombies = 0;

            for (int i = 0; i < rounds; i++) {
              int num1 = random.nextInt(10);
              int num2 = random.nextInt(10);

              System.out.printf("\nRound %d:\n", i + 1);
              System.out.printf("Oh no! A zombie approaches!\n");
              System.out.printf(
                  "You quickly calculate: What is %d + %d?\n", num1, num2);

              int answer = num1 + num2;
              int userAnswerMath =
                  scanner.nextInt(); // Read user's answer within the loop

              if (userAnswerMath
                  == answer) { // Compare user's answer with the correct answer
                System.out.println("Phew! You defeated the zombie!");
                score++;
              } else {
                System.out.println(
                    "The zombie got you! The correct answer is " + answer);
                zombies++;
              }
            }

            System.out.println("\nGame over!");
            System.out.printf("Your score: %d out of %d\n", score, rounds);
            System.out.printf("You were overwhelmed by %d zombies!\n", zombies);

            System.out.println("\nGame over!");
            System.out.printf("Your score: %d out of %d\n", score, rounds);
            System.out.printf("You were overwhelmed by %d zombies!\n", zombies);
          }
        }
      }

      // Condition for if response is 2 (Essentials pack)
      if (response == 2) {
        zombie_ShelterCount -=
            10; // Deducting zombies count for choosing essentials pack
        System.out.println(
            "You chose the Essentials pack. Let's play a mini-game to use the First-aid kit!");
        System.out.println(
            "You found yourself wounded! Use the First-aid kit to restore your health.");
        System.out.println(
            "You need to guess a number between 1 and 10 to apply the first-aid kit correctly.");
        int randomNumber = generateRandomNumber(1, 10);
        System.out.println("Enter your guess:");
        int guess = scanner.nextInt();

        if (guess == randomNumber) {
          System.out.println(
              "Congratulations! You applied the first-aid kit successfully.");
          // Increment health and essentials score
          health += 20;
          System.out.println("Your health is now: " + health);
        } else {
          System.out.println(
              "Oops! Wrong guess. The correct number was: " + randomNumber);
        }
      }
    }
  }

  // Function to calculate the total score of the survival pack based on the
  // items chosen
  static int calculatePackScore(String[] packItems, int[] itemScores) {
    int totalScore = 0;
    for (int i = 0; i < packItems.length; i++) {
      // Assuming itemScores array corresponds to each item's score in the
      // packItems array You can modify this logic according to your scoring
      // system
      totalScore += itemScores[i];
    }
    return totalScore;
  }

  // Function to generate a random number within a specified range
  static int generateRandomNumber(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }
}