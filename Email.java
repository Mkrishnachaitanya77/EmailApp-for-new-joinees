package emailAdminApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String company="mycompany.com";
	private int mailboxCapacity;
	private int defaultPasswordlength=10;
	private String alternateEmail;
	
	
	
	//constructor to recieve the first and last name
	public Email(String firstName,String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
		System.out.println("EMAIL CREATED: "+this.firstName+" "+this.lastName);
		
		//call a method asking for the department- return the department
		this.department=setDept();
		
		//call a method that returns a random password
		this.password=randomPassword(defaultPasswordlength);
		System.out.println("your password is: "+this.password);
		
		//combine elements to generate mail
		email=firstName.toLowerCase()+lastName.toLowerCase()+"@"+department+"."+company;
		System.out.println("your email is: "+email);
		
	}
	
	//Ask for department
	private String setDept() {
		Scanner in=new Scanner(System.in);
		System.out.println("choose the department\n1 for sales\n2 for development\n3 for accounting\n4 for testing\n0 for nothing");
		int choice=in.nextInt();
		in.close();
		if(choice==1) {return "sales";}
		else if(choice==2) {return "dev";}
		else if(choice==3) {return "acct";}
		else if(choice==4) {return "test";}
		else {return "";}
		
		
		
	}
	
	//generate a random password
	
	private String randomPassword(int length) {
		String passwordset="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int)(Math.random()*passwordset.length());
			password[i]=passwordset.charAt(rand);
		}
		return new String(password);
	}
	
	//set the mailbox capacity
	
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	
	//set the alternate email
	
	public void setAlternateEmail(String altMail) {
		this.alternateEmail=altMail;
	}
	
	//change the password
	
	public void changePassword(String password) {
		this.password=password;
	}
	
	public int getMailboxcapacity() { return mailboxCapacity;}
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() { return password;}
	
	
	public String showInfo() {
		return "DISPLAY NAME: "+firstName +" "+lastName +
				"COMPANY EMAIL: "+ email +
				"MAILBOX CAPACITY: "+ mailboxCapacity+"mb";
	}
	
	

}
