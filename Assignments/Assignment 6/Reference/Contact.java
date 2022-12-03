/*
*Name: Kenil Shah
*ID: V00903842
*Date: 14 MAR 2018
*Filename: Contact.java
*Course Number: CSC 110 Lab9
*/


/* A Contact is a firstname, a lastname, an initial and an email address.
For now, assume that the contacts are email addresses.
A contact cannot be created without an email address,
	ie, there is no default constructor.
*/

//The class below can be use to store contact information
public class Contact  {
	private String firstName = "";
	private String lastName = "";
	private String initial = "";
	private String email = "";
	private String kind = "email";
	private String alias = "";
	//constructor to initialise varibles and store values for email
	public Contact(String email)  {
		this.email = email;
	}
	
	//constructor to initialise variables and stores values for email. fistname, initial and last name 
	public Contact(String email, String first, String init, String last)  {
		this.email = email;
		this.firstName = first;
		this.initial = init;
		this.lastName = last;
	}
	
	//construstor to initialise variables and store values for email, alias
	public Contact(String email, String alias){
		this.email=email;
		this.alias=alias;
	}
	/*This method is used to set first name, last name, and initial as the variables are private
	  thus this method is used to set the names*/
	public void setName(String first, String initial, String last)  {
		this.firstName = first;
		this.initial = initial;
		this.lastName = last;
	}

	//set name fields back to blank
	public void privatizeName()  {
		this.firstName = "";
		this.initial = "";
		this.lastName = "";
	}
	
	//when this method is called it outputs name on the screen
	public String getName()  {
		return "Name: " + this.firstName + " " + this.initial + " "+ this.lastName + "\n";
	}
	
	//when this method is called it outputs email on the screen
	public String getEmail()  {
		return this.email;
	}
	
	//this method is used to change an email of an already stored contact
	public void changeEmail(String newEmail)  {
		this.email = newEmail;
	}
	
	//toString method to output the string representation  of the object
	public String toString(){
		return getName() + "; " + kind + ": " + email + " ; " +alias;
	}

}//end class Contact
