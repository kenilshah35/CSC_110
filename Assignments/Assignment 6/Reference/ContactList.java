/* A ContactList is an array of Contacts.
	This implementation is (currently) pretty straightforward:
	- Size is input with invoking one constructor else it defaults to 10.
	- A technique to expand the array size will need to be implmented in the future.
	- There is no mechanism for deletion.
	- The only search function is by searching the email addresses.
*/

public class ContactList
{
	// array of contacts
	private Contact [] list;
	private int count = 0;
	private int defaultSize = 10;

	public ContactList()
	{
		this.list = new Contact[defaultSize];
	}

	public ContactList(int size)
	{
		this.list = new Contact[size];
	}

	public void addContact(Contact c)
	{
		this.list[count] = c;
		this.count++;
	}

	// if the email matches return the contact else
	// return null.
	public boolean find(String email)
	{
		for(int i = 0; i< count; i++)
		{
			//list[i] is Contact, getMail is string,
			//.equals() is string method
			if (this.list[i].getEmail().equals(email))
			{
				return true;
			}
		}
		// not found
		return false;
	}
	//returns all the contacts in the list.  Assumes toString method in Contact.
	public String toString()
	{
		String temp = "There are " + count + " contacts: \n";

		//print the contents of all the contacts in the list
		for(int i = 0; i< count; i++)
		{
			temp = temp + list[i] +"\n";
		}
		temp = temp + "End List \n";
		return temp;
	}

}//end class ContactList
