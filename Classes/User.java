package Classes;

import Interface.*;

public class User implements IUser 
{

    private String name;
    private String password;

    public User(String name, String password) 
	{
        this.name = name;
        this.password = password;
    }

    public String getname() 
	{
        return name;
    }

    public String getPassword() 
	{
        return password;
    }

}
