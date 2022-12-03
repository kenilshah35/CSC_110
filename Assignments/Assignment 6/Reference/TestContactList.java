public class TestContactList
{
	public static void main(String [] args)
	{
		System.out.println("Program test begins\n");
		ContactList cList = new ContactList();

		//make a contact and add to list
		Contact friend1 = new Contact("jsmith@faceTwit.ca");
		friend1.setName("John", "E.", "Smith");
		cList.addContact(friend1);

		//make another contact
		Contact friend2 = new Contact("jdoe@faceTwit.ca","Jane", "T.", "Doe");
		cList.addContact(friend2);

		//make another contact
		Contact acquaint = new Contact("nubee@faceTwit.ca");
		cList.addContact(acquaint);

		//print contactList
		System.out.println(cList);

		System.out.println("\"nubee@faceTwit.ca\" is in list?");
		System.out.println(cList.find("nubee@faceTwit.ca"));

		System.out.println("\"tobee@faceTwit.ca\" is in list?");
		System.out.println(cList.find("tobee@faceTwit.ca"));
	}
}// end TestContactList
