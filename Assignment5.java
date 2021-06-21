//Assignment 5
//Anooshka Pendyal
//This assignment reads in a raw data file and summarizes the total population, child population, and child poverty population for each state.
//The output is in the form of a file.

//imports
import java.io.*;
import java.util.*; 

public class Assignment5
{
    public static void main (String [] args) throws IOException
    {
        //initializing everything necessary to read in file
        BufferedReader in = null;
        Scanner fileScanner = null;
        String line = null;

        //used to help identify which state each line of the file belongs to 
        String [] stateCodeArray = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
                                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                                    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
                                    "31", "32", "33", "34", "35", "36", "37", "38", "39", "40",
                                    "41", "42", "43", "44", "45", "46", "47", "48", "49", "50",
                                    "51", "52", "53", "54", "55", "56"};

        //array of State objects, used to store data for each state
        State [] stateArray = new State [56];

        //initializing each State object in array so I can add data to their attributes
        for (int i = 0; i < stateArray.length; i++)
        {
            stateArray[i] = new State();
        }

        //try block because scanner/bufferedreader may cause exceptions
        try
        {
            //reading in file
            in = new BufferedReader(new FileReader("/Users/anooshka_pendyal/Desktop/Advanced_Java_CTY/Unit_5/PovertyData.txt"));
            fileScanner = new Scanner(in);

            //loops through each line in the file
            while((line = in.readLine()) != null)
            {
                //i is used to keep track of iterations in loop
                int i;

                //goes through each item in statecodearray to find all possible matches to statecode
                for (i = 0; i < stateCodeArray.length; i++)
                {
                    //when the program finds the state code of the line in the array
                    if(stateCodeArray[i].equals(line.substring(0,2)))
                    {
                        //get substring
                        String totalPopSubstring = line.substring(82,90);
                        //trim substring
                        totalPopSubstring = totalPopSubstring.trim();
                        //convert to integer
                        int changeToInt = Integer.parseInt(totalPopSubstring);
                        //add to total population of state i
                        stateArray[i].addTotalPopulation(changeToInt);

                        //add to total child population of state i
                        String totalChildSubstring = line.substring(91,99);
                        totalChildSubstring = totalChildSubstring.trim();
                        changeToInt = Integer.parseInt(totalChildSubstring);
                        stateArray[i].addChildPopulation(changeToInt);

                        //add to total child poverty population of state i
                        String totalChildPovSubstring = line.substring(100,108);
                        totalChildPovSubstring = totalChildPovSubstring.trim();
                        changeToInt = Integer.parseInt(totalChildPovSubstring);
                        stateArray[i].addChildPovertyPopulation(changeToInt);

                        break;
                    }
                }
            }
            //closing file and scanner
            in.close();
            fileScanner.close();
        }
        //catch block for exception
        catch(Exception e)
        {
            System.out.println("Exception occurred");
        }

        //initializing printwriter to write output to file
        PrintWriter out = null;

        //try block
        try
        {
            //creating the file
            out = new PrintWriter(
                new BufferedWriter(
                new FileWriter("/Users/anooshka_pendyal/Desktop/Advanced_Java_CTY/Unit_5/PovertyDataSummary.txt", true)));
                
            //loop for each state
            for (int i = 0; i < stateArray.length; i++)
            {
                //print out statecode
                out.print(stateCodeArray[i]);
                //print out total population and right align
                out.printf("%15s", stateArray[i].getTotalPopulation());
                //print out child population and right align
                out.printf("%15s", stateArray[i].getChildPopulation());
                //print out child poverty population and right align
                out.printf("%15s \n", stateArray[i].getChildPovertyPopulation());
            }
        }
        //catch block
        catch(IOException e)
        {
            System.out.println("Exception occurred!");
        }
        finally
        {
            //close out file
            out.close();
        }  
    }
}