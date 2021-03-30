//Finn Parker
//2.3.21
//CS145 - Assignment #2 - Phone book
//Darrell Criss
//Defines the attribute of the PhoneNode object, AKA the contact
//And creates constructors

public class PhoneNode {
	// attributes of PhoneNode (AKA a single contact)
	public String fName;
	public String lName;
	public String address;
	public String city;
	public String phoneNum;
	public PhoneNode next;

	// constructors

	public PhoneNode() {
		this(null, null, null, null, null, null);
	}

	public PhoneNode(String lName, String fName, String address, String city, String phoneNum, PhoneNode next) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.city = city;
		this.phoneNum = phoneNum;
		this.next = next;
	}
}