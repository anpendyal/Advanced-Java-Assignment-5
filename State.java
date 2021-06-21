//Assignment 5 - State Class
//Anooshka Pendyal
//State class models states that will be used in the assignment.
//There are 4 attributes -- total population, child population, child poverty population, and state code
public class State
{
    //attributes
    private int totalPopulation;
    private int childPopulation;
    private int childPovertyPopulation;
    private String code;

    //no argument constructor
    public State()
    {
        totalPopulation = 0;
        childPopulation = 0;
        childPovertyPopulation = 0;
        code = "";
    }

    //parameterized constructor
    public State(int tp, int cp, int cpp, String c)
    {
        totalPopulation = tp;
        childPopulation = cp;
        childPovertyPopulation = cpp;
        code = c;
    }

    //setter methods
    public void setTotalPopulation(int tp)
    {
        totalPopulation = tp;
    }

    public void setChildPopulation(int cp)
    {
        childPopulation = cp;
    }

    public void setChildPovertyPopulation(int cpp)
    {
        childPovertyPopulation =  cpp;
    }

    public void setCode(String c)
    {
        code = c;
    }

    //getter methods
    public int getTotalPopulation()
    {
        return totalPopulation;
    }

    public int getChildPopulation()
    {
        return childPopulation;
    }

    public int getChildPovertyPopulation()
    {
        return childPovertyPopulation;
    }

    public String getCode()
    {
        return code;
    }

    //add methods will be used to update the attributes
    //easier than resetting the values every time
    public void addTotalPopulation(int newTP)
    {
        totalPopulation = totalPopulation + newTP;
    }

    public void addChildPopulation(int newCP)
    {
        childPopulation = childPopulation + newCP;
    }

    public void addChildPovertyPopulation(int newCPP)
    {
        childPovertyPopulation = childPovertyPopulation + newCPP;
    }
}