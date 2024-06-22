//7.40: Polling
import java.util.Scanner;

public class Polling
{
  private static final String[] topics = {"Smoking             ", "Global warming      ", "Deforestation       ", "Littering           ", "Child Abuse         "};
  private static int[][] responses = new int[5][10]; //array to summarize the user's responses
  private static int[] highestLowest = new int[5]; //array to find the highest & lowest no. of votes
  private static int userNum = 0; //no. of users (used to find the average)
  
  public static void main(String[] args)
  {
    //create Scanner object to access its methods
    Scanner input = new Scanner(System.in);
    int start = 0;
    int users = 0;
      
    System.out.printf( " Polling%n" );
    System.out.printf( ":=======:%n%n" );
    System.out.printf( "- The following program is a polling application that will ask the user to rate five social issues from 1 (least important) to 10 (most important).%n%n" );
    System.out.printf( "- Before we begin, please enter the number of users who will participate in this poll: " );
    users = input.nextInt();
    
    while(users < 1) //Error-trapping
    {
      System.out.printf("%nInvalid input. The number of users must be at least one. Please try again: ");
      users = input.nextInt();
    }
    
    System.out.printf( "- When you have read the instructions and are ready to begin, enter 1: " );
    start = input.nextInt();
    
    while(start != 1) //Error-trapping
    {
      System.out.printf("%nWhoops. Maybe you mistyped. Please try again: ");
      start = input.nextInt();
    }
    
    System.out.println();
    System.out.printf("The five social issues are as follows:%n%n");
    for(int i = 0; i < topics.length; ++i)
    {
      System.out.printf("#%d " + topics[i] + "%n", i + 1);
    }
    
    System.out.printf("%n%n");
    System.out.printf("Reminder: Rate the issues out of 10. A value of 1 being the least important while a value of 10 being the most important.%n%n");
    
    while(users >= 1)
    {
      ++userNum;
      System.out.printf("User #%d:%n", userNum);
      for(int i = 0; i < topics.length; ++i)
      {
        int rate = 0;
        System.out.printf("%nHow would you rate the social issue '%s' out of 10?: ", topics[i].trim());
        rate = input.nextInt();
        
        while(rate < 1 || rate > 10)
        {
          System.out.printf("%nInvalid input. Please check your input range and try again: ");
          rate = input.nextInt();
        }
        
        switch(rate)
        {
          case 1:
            ++responses[i][rate - 1];
            break;
            
          case 2:
            ++responses[i][rate - 1];
            break;
          
          case 3:
            ++responses[i][rate - 1];
            break;
            
          case 4:
            ++responses[i][rate - 1];
            break;
            
          case 5:
            ++responses[i][rate - 1];
            break;
            
          case 6:
            ++responses[i][rate - 1];
            break;
            
          case 7:
            ++responses[i][rate - 1];
            break;
            
          case 8:
            ++responses[i][rate - 1];
            break;
            
          case 9:
            ++responses[i][rate - 1];
            break;
            
          case 10:
            ++responses[i][rate - 1];
            break;
            
          default:
            break;
        }//end switch
        
        System.out.println();
      }//end for loop
      
      System.out.printf("%n%n");
      --users;
    }//end while loop
    
    //dipslay the results
    displayResults();
    
  }//end main
  
  public static void displayResults()
  {
    int totalResponses = 0;
    
    System.out.printf( "Results:%n%n" );
    for(int i = 0; i < 10; ++i)
    {
      if(i == 0)
      {
        System.out.print("                    ");
      }
      if(i == 9)
      {
        System.out.printf(" %4d   ", i+1);
        break;
      }
      System.out.printf("%4d", i+1);
        
    }
    
    System.out.printf("AVG%n%n");
    for(int row = 0; row < responses.length; ++row)
    {
      System.out.print( topics[row] ); //printing each issue
      for(int col = 0; col < responses[row].length; ++col)
      {
        System.out.printf("%4d", responses[row][col]);
        totalResponses += responses[row][col] * (col + 1); //calculating the total reponses for each issue
      }
      highestLowest[row] = totalResponses; //totaling the responses for each social issue
      System.out.printf("    %.2f", (double) totalResponses / userNum);
      System.out.println();
      totalResponses = 0; //resetting the total responses to zero
    }
    
    minMax(); //call method minMax to get the maximum and minimum votes across the social issues
  }//end displayResponses
  
  public static void minMax()
  {
    int maxTopicsIndex = 0;
    int minTopicsIndex = 0;
    
    int max = highestLowest[0];
    int min = highestLowest[0];
    
    for(int i = 1; i < highestLowest.length; ++i)
    {
      if(highestLowest[i] > max)
      {
        max = highestLowest[i];
        maxTopicsIndex = i;
      }
      if(highestLowest[i] < min)
      {
        min = highestLowest[i];
        minTopicsIndex = i;
      }
    }

    System.out.printf("%n%nHighest social issue was %s with %d points.%n", topics[maxTopicsIndex].trim(), max);
    System.out.printf("Lowest social issue was %s with %d points.%n%n", topics[minTopicsIndex].trim(), min);
  }//end method minMax
  
}//end class