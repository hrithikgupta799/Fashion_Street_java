//Expection Handling
//Custom Expection Handling 
//Typing Casting
//Collection Add()/Remove()
//Inheritance (Multiply Inheritance,Single-Level Inheritance,Multi-Level Inheritance)
//DMS(if ,if else,if else if,switch)
//Method Recursion

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.InputMismatchException;
 
//Interface 
interface MainInterface
{
	void start();
	void signup();
	void login();
	void category();
	}

interface fashionStree
{
	void exit();
	void cart();
	void payment();
	void remove();
}

//Single-Level Inheritance
//@inheritance
class SignupClass implements MainInterface
{
	static private String name;
	static private long number;
	static private String email;
	private String password;
	static private String address;
	String captcha ="";
	static boolean flag=false;

	//@Override
public void start(){
		System.out.println("");
		System.out.println("1 - Sign-Up");
		System.out.println("2 - Login");
		System.out.println("3 - Home");
		System.out.println("4 - Exit");
		System.out.println("");
		System.out.println("=========================================================");
		System.out.println("");
		System.out.print("ENTER YOUR CHOICES :: ");
		input();
	}
	
public void input() {
		try {
			Scanner sc = new Scanner(System.in);
			int input=sc.nextInt();
			if(input==1) {
				signup();
				}
				else if(input==2) {
				login();
				}
				else if(input==3) {
					category();
				}
				else if(input==4) {
					System.out.println("Thanks For Visting !!!");
					System.exit(0);
				}
				else {
					System.err.println("Invalid Input!! Please Enter Correct Input");
					System.out.println("");
					input();
				}
		}
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer Not Character");
			System.out.println("");
			System.out.println("ENTER AGAIN :: ");
			input();
		}
		
	}	
		
public String getName() {
		return name;
	}
	
public void setName(String name) {
		this.name = name;
	}
	
public String getAddress() {
		return address;
	}
	
public void setAddress(String address) {
		this.address = address;
	}
	
public long getNumber() {
		return number;
	}
	
public String getPassword() {
		return password;
	}
	
public void setNumber() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your Mobile Number :: ");
			number=sc.nextLong();
			if(number > 999999999 && number < 10000000000L ) {
				this.number=number;
			}
			else {
				System.err.println("Invaild Number!!");
				System.out.println("Enter 10 digit Number");
				setNumber();
			}
		}
	catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		setNumber();
	}
		
	}
	
public String getEmail() {
		return email;
	}

public void setEmail(String email) {
		this.email = email;
	}
	
public void setPassword() {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Password  :: ");
			password=sc.nextLine();
			if(password.length()>7 ) {
				this.password=password;
			}
			else {
				System.err.println("Invaild Password!!");
				System.out.println("--> Enter Strong Password consist of 8 character");
				setPassword();
			}
	}
	
//@Override
public void signup(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Your Name :: ");
		name=sc.nextLine();
		setNumber();
		System.out.print("Enter Your Email :: ");
		email=sc.nextLine();
		System.out.print("Enter Your Address :: ");
		address=sc.nextLine();
		setPassword();
		System.out.println("");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("                       Sign Up Successful                         ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("");
		flag=true;		
	}

//@Override
public void login() {
	System.out.println(" ");
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	System.out.println("                           Login Section                     ");
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	System.out.println(" ");
	try {
		if(flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1 - Login by Number");
			System.out.println("2 - Login by Email");
			System.out.println("=========================================================");
			System.out.println("");
			System.out.print("ENTER YOUR CHOICES :: ");
			int n = sc.nextInt();
			if (n == 1) {
				System.out.print("Enter the Number :: ");
				long number = sc.nextLong();
				sc.nextLine();
				System.out.print("Enter the Password ::");
				String pass = sc.nextLine();
				if (this.number == number && this.password.equals(pass)) { 
					generatecaptcha();
				} else {
					System.err.println("User Credentials Incorrect");
					login();
				}

			} else if (n == 2) {
				System.out.print("Enter the Email :: ");
				sc.nextLine();
				String email = sc.nextLine();
				System.out.print("Enter the password :: ");
				String pass = sc.nextLine();
				if (this.email.equals(email) && this.password.equals(pass)) {
					generatecaptcha();
				} else {
					System.err.println("User Credentials Incorrect");
					login();
				}
			} else {
				System.err.println("Wrong Choice!!! Please try again");
				login();
			}
		}
		else {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(" Please Sign Up First!!                       ");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(" ");
			signup();
		}		
		
	}
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer not Character");
		login();
		}
		
	}

public void generatecaptcha() {
		captcha ="";
		while(captcha.length()<5) {
		Random random=new Random();
		int ran=random.nextInt(123);
		if((ran>47 && ran<58)||(ran>64 && ran<91)||(ran>96 && ran<123)){
			char r=(char)ran;	
			captcha=captcha+r;
			}
		}
		System.out.println("Captcha Code :: "+captcha);
		verfiycaptcha();
	}

public void verfiycaptcha() {
		System.out.print("Enter the Captcha Code ::");
		Scanner sc = new Scanner(System.in);
		String captcha=sc.nextLine();
		if(this.captcha.equals(captcha)) {

			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.err.println("                      Login Sucessfull!!                  ");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("");
		}
		else
		{
			System.err.println("Invalid Captcha");
			System.out.println("Try Again!!!");
			generatecaptcha();
		}
		
	}

//@Override
public void category() {
	System.out.println("");
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	System.out.println("                               HOME PAGE                         ");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	System.out.println("");
	System.out.println("1 - Men's Clothing ");
	System.out.println("2 - Wowen's Clothing ");
	System.out.println("3 - Shoes ");
	System.out.println("4 - Asscessories");
	System.out.println("");
	System.out.println("=========================================================");
	System.out.println("");
	System.out.print("ENTER YOUR CHOICES :: ");
	categoryInput();
}

public void categoryInput(){
try {
	Scanner sc = new Scanner(System.in);
	var input=sc.nextInt();
	if(input==1) {
	new Men();
	}
	else if(input==2) {
	new WOMEN();
	}
	else if(input==3) {
		new Shoes();
	}
	else if(input == 4) {
		new Asscessories();
	}
	else {
		System.err.println("Invalid Input!! ");
		System.out.print("Please Enter Correct Input :: ");
		System.out.println("");
		input();
	}
}
catch(InputMismatchException e) {
	System.err.println("Invalid Input!! Please Enter Integer not Character");
	System.out.print("Please Enter Correct Input :: ");
	System.out.println("");
	categoryInput();
            }	
}
//Class Closed
}

//Main Class
class Main 
{	
public static void main(String[] args) 
{
	SignupClass signup_classobj=new SignupClass();
	signup_classobj.start();
	signup_classobj.login();
	signup_classobj.category();
	}

	//Static Block
	static
	{
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.err.println("                      Welcome TO FASHION STREET                  ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("");
	}
// Class Closed 
}

//Multiply Inheritance
//@inheritance
class FashionStree extends SignupClass
{
static double Totalbill;
static double couponamount;
static ArrayList<String> cart=new ArrayList<String>();
static LinkedList rate=new LinkedList();

	
//@Override
public void exit() {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("                      Thanks For Visiting!!!                     ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.exit(0);
	}
	
//@Override
public void cart() {
		if(cart.size()<1) {
			throw new CardEmptyException();
		}
		System.out.println("=========================================================");
		System.out.println("Your Cart Items");
		System.out.println("=========================================================");
		System.out.println("");
		 System.out.print("Sr No   ");
		 System.out.print("Price   ");
	      System.out.println("Item Name "); 
	      System.out.print("=====   ");
	      System.out.print("======   ");
	      System.out.println("=========================================================");
		for (int i = 0; i < cart.size(); i++) 
		{
			 System.out.print(01+i);
			 System.out.print("       "+rate.get(i));
		      System.out.println("       "+cart.get(i));
		}
		  System.out.print("=====   ");
		    System.out.print("======   ");
	      System.out.println("=========================================================");
		 System.out.println("");
		System.out.print("Card Amount :: ");
		System.err.println("RS "+Totalbill);
		 System.out.println("");
		 cartinput();
	}
	
public void cartinput() {
			 System.out.println("");
			 try {
					System.out.println("=========================================================");
				 System.out.println("1 - Remove Item");
					System.out.println("2 - Apply Coupon");
					System.out.println("3 - Payment");
					System.out.println("4 - Exit");
					System.out.println("");
					System.out.println("=========================================================");
					System.out.println("");
					System.out.print("ENTER YOUR CHOICES :: ");
					Scanner sc=new Scanner(System.in);
					int input= sc.nextInt();
					if(input==1) {
						remove();
					}
					else if(input==2) {
						apply();
					}
					else if(input==3){
						payment();
					}
					else {
						System.out.println("Invalid Input");
						cartinput();
					}
			 }
			 catch(InputMismatchException e) {
				 System.out.println("Invalid Input!!!");
				 System.out.println("Please Enter Interger Not a Character");
				 cartinput();
			 }	
		 }

//@Override
public void payment() {
		System.out.println("");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("                        Payment");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("");
		System.out.println("Dear "+getName());
		System.out.println(getNumber());
		System.out.println(getEmail());
		System.out.println("");
		System.out.println("Order Details ");
		 System.out.println("********************************************************************");
		 System.out.println("");
		 System.out.println("Number of Items :: "+cart.size());
		System.out.println("Cart Amount :: "+Totalbill);
		System.out.println("Offer Applied :: -"+couponamount);
		double finalaccount=Totalbill-couponamount;
		System.out.println("========================");
		System.out.println("Final Amount :: "+finalaccount);
		System.out.println("");
		System.out.println("Choose Payment Mode ");
		System.out.println("=========================================================");
		System.out.println("1 - Credit/Debit Card");
		System.out.println("2 - UPI Payment");
		System.out.println("3 - Cash on Delivery");
		System.out.println("=========================================================");
		System.out.println("");
		System.out.print("ENTER YOUR CHOICES ::");
		payinput();
	}

int chance=1;
// Method Recursion
public void apply() {
	if(chance<4) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Coupon Code :: ");
		String coupon= sc.nextLine();
		if(coupon.equals("java")) {
			couponamount=Totalbill/100*30;
			System.out.println("");
			System.out.println("Congratulations !!! ");
			System.out.println("Coupon Applied");
			System.out.println("");
			payment();
		}
		else {
			System.err.println("Invalid Coupon");
			System.out.println("Try Again!!!");
			System.out.println("");
			chance++;
			apply();
		}
		          }
	else {
		System.out.println("Apply Coupon Limit is Over");
		payment();
	}
	}
	
public void payinput()
		{	
		try {
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			switch(input) {
			case 1:
				Cardpayment();
				break;
			case 2:
				System.out.print("Enter Your UPI ID ::");
				sc.next();
				sc.nextLine();
				System.out.println("");
				System.out.println("Congrat !!! ");
				System.out.println("Payment Done");
				System.out.println("");
				System.out.println("Order Will Delivery Soon at Address");
				System.out.println("Address :: "+getAddress());
				exit();
				break;
			case 3:
				System.out.println("");
				System.out.println("Order Will Delivery Soon at Address");
				System.out.println("Address :: "+getAddress());
				exit();
				break;
				default:
					System.out.println("Invaild Input!!");
					System.out.println("================================================================");
					System.out.print("Please Enter Correct Input :: ");
					payinput();
					break;
			}
		}
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer not Character");
			System.out.print("Please Enter Correct Input :: ");
			System.out.println("");
			payinput();
		}
	}
		
public void Cardpayment() {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("");
				System.out.println("Enter Card Details");
				System.out.println("=========================================================");
				System.out.print("Card Holder Name ::");
				sc.nextLine();
				System.out.print("Card Number ::");
				sc.nextLong();
				System.out.print("Expriy Date ::");
				sc.nextLine();
				sc.next();
				System.out.print("CVV Number ::");
				sc.nextInt();
				System.out.println("");
				System.out.println("Congrat !!! ");
				System.out.println("Payment Done");
				System.out.println("");
				System.out.println("Order Will Delivery Soon at Address");
				System.out.println("Address :: "+getAddress());
				exit();
			}
			catch(InputMismatchException e) {
				System.err.println("Invalid Input!! Please Enter Integer not Character");
				System.out.print("Please Enter Correct Input");
				System.out.println("");
				Cardpayment();
			}
		}
		
//@Override
public void remove() {
			try {
			System.out.println("");
			System.out.print("Enter which item want to remove :: ");
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			input=input-1;
			//Typecasting
			int RemoveValue=(int)rate.get(input);
		cart.remove(input);
		rate.remove(input);
		Totalbill=Totalbill-RemoveValue;
		System.out.println("");
		cart();
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("");
			System.out.println("Invalid Input!!Such Element Not Exixt ");
			System.out.println("Try Again");
			remove();
		}
		}
	
public void condition() {
		if(flag) {
			
		}else {
			System.out.println("");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.err.println("                        Please Sign Up First!!");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("");
			signup();
		}
	}

//Class closed
}

//Custom Exception
class CardEmptyException extends ArithmeticException{
	
}

//@inheritance
class Men extends FashionStree
{
	//Non-Static Block
{
	System.out.println("");
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	System.out.println("                    Welcome To Mens Collections                  ");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("");
		System.out.println("1 - T-Shirt");
		System.out.println("2 - Shirt");
		System.out.println("3 - Kurta");
		System.out.println("4 - Trousers");
		System.out.println("5 - Jeans");
		System.out.println("6 - Main Collection");
		System.out.println("7 - Cart Section");
		System.out.println("8 - Exit");
		System.out.println("");
		System.out.println("********************************************************************");
		System.out.println("");
		System.out.print("ENTER YOUR CHOICES :: ");
		inputSubcategory();
}

public void inputSubcategory(){
	try {
	Scanner sc = new Scanner(System.in);
	var input=sc.nextInt();
	switch(input){
	case 1:	tshirt();
	break;
	case 2:shirt();
	break;
	case 3:kurta();
	break;
	case 4:trousers();
	break;
	case 5:jeans();
	break;
	case 6:category();
	break;
	case 7:cart();
	break;
	case 8:exit();
	break;
	default :
		System.err.println("Invalid Input!! ");
		System.out.println("=========================================================");
		System.out.println("");
		System.out.println("Please Enter Correct Input :: ");
		inputSubcategory();
		break;
}}
	catch(InputMismatchException e) {
System.err.println("Invalid Input!! Please Enter Integer not Character");
System.out.println("=========================================================");
System.out.println("");
System.out.print("Enter Again :: ");	
inputSubcategory();
	}
	
}

//-----------------------------------------------------------------T-Shirt Section
public void tshirt(){
	System.out.println("");
	System.out.println("Welcome to T-Shirt Collection");
	System.out.println("********************************************************************");
	System.out.println("1.Men's Printed Full Sleeve Slim Fit Cotton T-Shirt");
	System.out.println("2.Polo Neck Half Sleeve Striped Print Casual Tshirt");
	System.out.println("3.London Hills Solid Round Neck Half Sleeve T-Shirts");
	System.out.println("4.Urbano Fashion Printed Full Sleeve T-Shirt");
	System.out.println("5.Classic Polo Men's Regular Fit T-Shirt");
	System.out.println("6.Bewakoof Men's Marvel T-Shirt - Oversized Fit");
	System.out.println("7.The Souled Store Men Official Thor: Oversized T-Shirts");
	System.out.println("8.VEIRDO® Men's Oversized Cotton Black Round Neck T-Shirt");
	System.out.println("9.Allen Solly Men's Regular Fit Polo");
	System.out.println("10.Van Heusen Men's Regular Fit Polo Shirt");
	System.out.println("11.Mens Collection");
	System.out.println("12.Main Collection");
	System.out.println("13.Cart Section");
	System.out.println("14.Exit");
	System.out.println("");
	System.out.println("********************************************************************");
	System.out.println("");
	System.out.print("ENTER YOUR CHOICES :: ");
	tshirtinput();
}

public void tshirtback() {
	System.out.println("=============================================================");
	System.out.println("");
	System.out.println("Press 1 for T-Shirt Collection");
	System.out.println("Press 2 for Mens Collection");
	System.out.println("Press 3 for Main Collection");
	System.out.println("Press 4 for Card Section");
	System.out.println("=========================================================");
	try {
		System.out.println("ENTER YOUR CHOICES");
		Scanner sc = new Scanner(System.in);
		int subinput=sc.nextInt();
		switch(subinput) {
		case 1: tshirt();
		break;
		case 2:new Men();
		break;
		case 3:category();
		break;
		case 4:cart();
		break;
		default:
			System.err.println("Invalid Input!!");
			System.out.println("=========================================================");
			System.out.println("Please Enter Correct Input :: ");
			tshirtback();
		break;
		}
	}
	catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
System.out.print("Enter Again :: ");
tshirtback();
	}
	
}

public void tshirtinput() {
	try {
		Scanner sc = new Scanner(System.in);
		var input=sc.nextInt();
		switch(input){
		case 1:{
					System.out.println("=============================================================");
					System.out.println("Item :: Men's Printed Full Sleeve Slim Fit Cotton T-Shirt");
					System.out.println("=============================================================");
					System.out.println("About this item ::");
					System.out.println("--> Stylish & Trendy All-Over Printed Design");
					System.out.println("--> 100% Premium Cotton with Bio Wash - Feels soft & comfortable");
					System.out.println("--> Round Neck Full Sleeve T-Shirt Printed pattern");
					System.out.println("--> Perfect for Casual, Evening, Holiday & Party Wear");
					System.out.println("=========================================================");
					System.out.println("Price :: RS 349");
					System.out.println("=========================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Men's Printed Full Sleeve Slim Fit Cotton T-Shirt");
						rate.add(349);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+349;
						tshirtback();
					}
					else {
						tshirt();
					}
				}
				break;
				case 2:
				{
					System.out.println("================================================================");
					System.out.println("Item :: Polo Neck Half Sleeve Striped Print Casual T-shirt");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> Premium Export Quality Branded T-shirt Unique Collection.");
					System.out.println("--> Casual Office T-shirt, Gifts, Get-together and Company Meet Ups.");
					System.out.println("--> Best Fashionably Comfortable Striped Trendy Polo T Shirts.");
					System.out.println("--> Full Sleeve,Buttons Three,Pattern Striper Style.");
					System.out.println("================================================================");
					System.out.println("Price :: RS 449");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Polo Neck Half Sleeve Striped Print Casual T-shirt");
						rate.add(449);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+449;
						tshirtback();
					}
					else {
						tshirt();
					}
				}
				break;
				case 3:{
					System.out.println("================================================================");
					System.out.println("Item :: London Hills Solid Round Neck Half Sleeve T-Shirts");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> Premium Export Quality Branded T-shirt Unique Collection Tshirt.");
					System.out.println("--> Perfect for Casual, Evening, Holiday & Party Wear");
					System.out.println("--> Best Fashionably Comfortable Striped Trendy Polo T Shirts.");
					System.out.println("================================================================");
					System.out.println("Price :: RS 349");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("London Hills Solid Round Neck Half Sleeve T-Shirts");
						rate.add(349);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+349;
						tshirtback();
					}
					else {
						tshirt();
					}
				}
				break;
				case 4:{
					System.out.println("================================================================");
					System.out.println("Item :: Urbano Fashion Printed Full Sleeve T-Shirt");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> Stylish & Trendy All-Over Printed Design.");
					System.out.println("--> 100% Premium Cotton with Bio Wash - Feels soft & comfortable");
					System.out.println("--> Round Neck,Full Sleeve T-Shirt,Slim Fit,Printed pattern.");
					System.out.println("--> Perfect for Casual, Evening, Holiday & Party Wear");
					System.out.println("================================================================");
					System.out.println("Price :: RS 549");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");				
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Urbano Fashion Printed Full Sleeve T-Shirt");
						rate.add(549);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+549;
					tshirtback();
					}
					else {
						tshirt();
					}
				}
				break;
				case 5:{
					System.out.println("================================================================");
					System.out.println("Item :: Classic Polo Men's Regular Fit T-Shirt");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> 60% Cotton 40% Polyster");
					System.out.println("--> Round Neck,Full Sleeve T-Shirt,Slim Fit,Regular Length");
					System.out.println("================================================================");
					System.out.println("Price :: RS 299");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");				
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Classic Polo Men's Regular Fit T-Shirt");
						rate.add(299);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+299;
						tshirtback();
					}
					else {
						tshirt();
					}
				}break;
				case 6:{
					System.out.println("================================================================");
					System.out.println("Item :: Bewakoof Men's Marvel T-Shirt - Oversized Fit");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> Oversized fit - Super Loose On Body Thoda Hawa Aane De");
					System.out.println("--> Fabric Description: Single Jersey, 100% Cotton");
					System.out.println("--> Pair this T-shirt with your favourite jeans and sneakers for a comfortable casual outfit");
					System.out.println("================================================================");
					System.out.println("Price :: RS 499");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");				
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Bewakoof Men's Marvel T-Shirt - Oversized Fit");
						rate.add(499);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+499;
						tshirtback();
					}
					else {
						tshirt();
					}
				}break;
				case 7:{
					System.out.println("================================================================");
					System.out.println("Item :: The Souled Store Men Official Thor: Oversized T-Shirt");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> 80% Cotton 20% Polyester, Fabric: Cotton & Polyester");
					System.out.println("--> Using the highest quality solvents and colors combines with fully automated machines");
					System.out.println("--> Colours may slightly vary depending on your screen brightness.");
					System.out.println("================================================================");
					System.out.println("Price :: RS 549");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");				
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("The Souled Store Men Official Thor: Oversized T-Shirt");
						rate.add(549);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+549;
						tshirtback();
					}
					else {
						tshirt();
					}
				}break;
				case 8:{
					System.out.println("================================================================");
					System.out.println("Item :: VEIRDO® Men's Oversized Cotton Black Round Neck T-Shirt");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> Trending Color combination design which gives extra ordinary casual looks");
					System.out.println("--> Made From 100% Premium Cotton, which always keeps you fresh and lasts longer.");
					System.out.println("================================================================");
					System.out.println("Price :: RS 349");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");				
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add(" VEIRDO® Men's Oversized Cotton Black Round Neck T-Shirt");
						rate.add(349);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+349;
						tshirtback();
					}
					else {
						tshirt();
					}
				}break;
				case 9:{
					System.out.println("================================================================");
					System.out.println("Item :: Allen Solly Men's Regular Fit Polo");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> Material: 60% Cotton 40% Polyester");
					System.out.println("--> Occasion : Leisure Sport");
					System.out.println("--> Closure Type : Button :: Collar Style : Band Collar");
					System.out.println("================================================================");
					System.out.println("Price :: RS 499");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");				
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Allen Solly Men's Regular Fit Polo");
						rate.add(499);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+499;
						tshirtback();
					}
					else {
						tshirt();
					}
				}break;
				case 10:{
					System.out.println("================================================================");
					System.out.println("Item :: Van Heusen Men's Regular Fit Polo Shirt");
					System.out.println("================================================================");
					System.out.println("About this item ::");
					System.out.println("--> Material : 60% Cotton and 40% Polyester");
					System.out.println("--> Occasion : Leisure Sport");
					System.out.println("================================================================");
					System.out.println("Price :: RS 599");
					System.out.println("================================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");				
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Van Heusen Men's Regular Fit Polo Shirt");
						rate.add(599);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+599;
						tshirtback();
					}
					else {
						tshirt();
					}
				}break;
				case 11:new Men();
				break;
				case 12:category();
				break;
				case 13:cart();
				break;
				case 14:exit();
				break;
				default:
					System.err.println("Invalid Input!! Please Enter Correct Input");
					System.out.println("================================================================");
					System.out.print("Please Enter Correct Input ::");
					tshirtinput();
					break;
				}
	}
	catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("================================================================");
		System.out.print("Enter Again :: ");
		tshirtinput();
	}
				}
//------------------------------------------------------------------------Shirt Section

public void shirt() {
	System.out.println("");
	System.out.println("********************************************************************");
	System.out.println("Welcome to Shirt Collection");
	System.out.println("********************************************************************");
	System.out.println("1.Peter England Men's Slim fit Formal Shirt");
	System.out.println("2.Arrow Tartan Cotton Formal Shirt");
	System.out.println("3.English Navy Men's Dress Shirt");
    System.out.println("4.Park Avenue Blue Checks Slim Fit Formal Shirts for Men");
	System.out.println("5.Van Heusen Men Formal Shirt");
	System.out.println("6.Dennis Lingo Men's Blue Slim Fit Cotton Casual Shirt");
	System.out.println("7.Kuons Avenue Men's Slim Fit Casual Denim Shirt");
	System.out.println("8.Mens Collection");
	System.out.println("9.Main Collection");
	System.out.println("10.Cart Section");
	System.out.println("11.Exit");
	System.out.println("********************************************************************");
	System.out.println("");
	System.out.print("ENTER YOUR CHOICES :: ");
	shirtinput();				
			}

public void shirtback() {
	try{
		System.out.println("=============================================================");
		System.out.println("Press 1 for Shirt Collection");
		System.out.println("Press 2 for Mens Collection");
		System.out.println("Press 3 for Main Collection");
		System.out.println("Press 4 for Card Section");
		System.out.println("=============================================================");
		System.out.println("ENTER YOUR CHOICES");
		Scanner sc = new Scanner(System.in);
		int subinput=sc.nextInt();
		switch(subinput) {
		case 1: shirt();
		break;
		case 2:new Men();
		break;
		case 3:category();
		break;
		case 4:cart();
		break;
		default:
			System.err.println("Invalid Input!! ");
			System.out.println("=========================================================");
			System.out.print("Please Enter Correct Input :: ");
			shirtback();
		}
	}
	catch(InputMismatchException e) {
				System.err.println("Invalid Input!! Please Enter Integer not Character");
				System.out.println("=========================================================");
				System.out.println("");
	System.out.print("Enter Again :: ");
	shirtback();
			}

}

public void shirtinput(){
				try{
					Scanner sc = new Scanner(System.in);
					var input=sc.nextInt();
					switch(input) {
					case 1:
					{
						System.out.println("=============================================================");
						System.out.println("Item :: Peter England Men's Slim fit Formal Shirt");
						System.out.println("=============================================================");
					System.out.println("About this item ::");
					System.out.println("--> Light Blue38");
					System.out.println("--> 100% cotton");
					System.out.println("--> Pattern: solid");
					System.out.println("--> Fit type: slim fit");
					System.out.println("--> Machine wash");
					System.out.println("=============================================================");
					System.out.println("Price :: RS 799");
					System.out.println("=============================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Peter England Men's Slim fit Formal Shirt");
						rate.add(799);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+799;
						shirtback();
					}
					else {
						shirt();
					}
				}break;
					case 2:
					{
						System.out.println("=============================================================");
						System.out.println("Item :: Arrow Tartan Cotton Formal Shirt");
						System.out.println("=============================================================");
					System.out.println("About this item ::");
					System.out.println("--> Cutaway collar");
					System.out.println("--> Chest patch pocket");
					System.out.println("--> French button placket");
					System.out.println("--> Long sleeves with mitered cuffs");
					System.out.println("=============================================================");
					System.out.println("Price :: RS 749");
					System.out.println("=============================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Arrow Tartan Cotton Formal Shirt");
						rate.add(749);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+749;
						shirtback();
					}
					else {
						shirt();
					}
				}break;
					case 3:
					{
						System.out.println("=============================================================");
						System.out.println("Item :: English Navy Men's Dress Shirt");
						System.out.println("=============================================================");
					System.out.println("About this item ::");
					System.out.println("--> Fabric Type: Cotton");
					System.out.println("--> Pattern Name: Solid");
					System.out.println("--> Collar Style: Classic");
					System.out.println("--> Sleeve Type: Long Sleeve");
					System.out.println("--> Material Composition: Blended");
					System.out.println("=============================================================");
					System.out.println("Price :: RS 649");
					System.out.println("=============================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("English Navy Men's Dress Shirt");
						rate.add(649);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+649;
						shirtback();
					}
					else {
						shirt();
					}
				}break;
					case 4:
					{
						System.out.println("=============================================================");
						System.out.println("Item :: Park Avenue Blue Checks Slim Fit Formal Shirts for Men");
						System.out.println("=============================================================");
					System.out.println("About this item ::");
					System.out.println("--> Fabric: 100% Cotton");
					System.out.println("--> Style: Western");
					System.out.println("--> Neck Style: Collared Neck");
					System.out.println("--> Pattern: Checked");
					System.out.println("--> Wash Care: Machine Wash");
					System.out.println("=============================================================");
					System.out.println("Price :: RS 599");
					System.out.println("");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Park Avenue Blue Checks Slim Fit Formal Shirts for Men");
						rate.add(599);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+599;
						shirtback();
					}
					else {
						shirt();
					}
				}break;
					case 5:
					{
						System.out.println("=============================================================");
						System.out.println("Item :: Van Heusen Men Formal Shirt");
						System.out.println("=============================================================");
					System.out.println("About this item ::");
					System.out.println("--> Occasion : Formal");
					System.out.println("--> Pattern : Solid");
					System.out.println("--> Material : 100% Cotton");
					System.out.println("--> Sleeves : Full Sleeves");
					System.out.println("=============================================================");
					System.out.println("Price :: RS 499");
					System.out.println("=============================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Van Heusen Men Formal Shirt");
						rate.add(499);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+499;
						shirtback();
					}
					else {
						shirt();
					}
				}break;
					case 6:
					{
						System.out.println("=============================================================");
						System.out.println("Item :: Dennis Lingo Men's Blue Slim Fit Cotton Casual Shirt");
						System.out.println("=============================================================");
					System.out.println("");
					System.out.println("About this item ::");
					System.out.println("--> Enhance your look by wearing this Casual Stylish Men's shirt");
					System.out.println("--> Team it with a pair of tapered denimd");
					System.out.println("--> Loafers for a fun Smart Casual look");
					System.out.println("--> Solid Chinos");
					System.out.println("=============================================================");
					System.out.println("Price :: RS 799");
					System.out.println("=============================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						cart.add("Dennis Lingo Men's Blue Slim Fit Cotton Casual Shirt");
						rate.add(799);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+799;
						shirtback();
					}
					else {
						shirt();
					}
				}break;
					case 7:
					{
						System.out.println("=============================================================");
						System.out.println("Item :: Kuons Avenue Men's Slim Fit Casual Denim Shirt");
						System.out.println("=============================================================");
					System.out.println("");
					System.out.println("About this item ::");
					System.out.println("--> Fabric: Denim Cotton,Style: Casual Shirt");
					System.out.println("--> Pattern: Solid,Fit Type: Slim Fit");
					System.out.println("--> Neck Styel: Spread Collar,Pocket: Single Patch Pockent");
					System.out.println("--> Sleeve Type: Full Sleeve,Cuff Style: Single");
					System.out.println("=============================================================");
					System.out.println("Price :: RS 799");
					System.out.println("=============================================================");
					System.out.println("Do You want byu!!");
					System.out.println("If Yes Press (Y) else press any character to go back");
					char byu=sc.next().charAt(0);
					if(byu == 'Y' || byu== 'y') {
						condition();
						cart.add("Kuons Avenue Men's Slim Fit Casual Denim Shirt");
						rate.add(799);
						System.out.println("Added to Cart");
						Totalbill=Totalbill+799;
						shirtback();
					}
					else {
						shirt();
					}
				}break;
					case 8:new Men();
					break;
				case 9:category();
				break;
				case 10:cart();
				break;
				case 11:exit();
				break;
					default:
						System.err.println("Invalid Input!!");
						System.out.println("=========================================================");
						System.out.println("");
						System.out.println("Please Enter Correct Input");
						shirtinput();
						break;
					}
				}
				catch(InputMismatchException e) {
							System.err.println("Invalid Input!! Please Enter Integer not Character");
							System.out.println("=========================================================");
							System.out.println("");
				System.out.print("Enter Again :: ");
				shirtinput();
						}
			}

//--------------------------------------------------------------------------Trousers Section

public void trousers() {
	System.out.println("");
	System.out.println("********************************************************************");
	System.out.println("Welcome to Trousers Collection");
	System.out.println("********************************************************************");
				System.out.println("We have collection of ");  
				System.out.println("1.Jockey Men Casual Trousers");
				System.out.println("2.SWADESI STUFF Men's Casual Chino Pants");
				System.out.println("3.Urbano Fashion Men's Cotton Slim Fit Casual Chinos Trousers");
				System.out.println("4.Dennis Lingo Men Casual Pant");
				System.out.println("5.LOUIS PHILLIPPS™ Men's Slim Fit Casual Trousers");
				System.out.println("6.The Indian Garage Co Men Chinos");
				System.out.println("7.Pepe Jeans Men Pant");
				System.out.println("8.Mens Collection");
				System.out.println("9.Main Collection");
				System.out.println("10.Cart Section");
				System.out.println("11.Exit");
				System.out.println("********************************************************************");
				System.out.println("");
				System.out.print("ENTER YOUR CHOICES :: ");
				trousersinput();
			}

public void trousersback() {
	System.out.println("=============================================================");
	System.out.println("1 - Trouser Collection");
	System.out.println("2 - Mens Collection");
	System.out.println("3 - Main Collection");
	System.out.println("4 - Card Section");
	System.out.println("=============================================================");
	System.out.println("");
	System.out.println("ENTER YOUR CHOICES");
		try{
			Scanner sc = new Scanner(System.in);
			int subinput=sc.nextInt();
			switch(subinput) {
			case 1: trousers();
			break;
			case 2:new Men();
			break;
			case 3:category();
			break;
			case 4:cart();
			break;
			default:
		System.err.println("Invalid Input!!");
		System.out.println("=========================================================");
		System.out.println("");
		 System.out.println("Please Enter Correct Input");
				trousersback();
			}
		}
		catch(InputMismatchException e) {
					System.err.println("Invalid Input!! Please Enter Integer not Character");
					System.out.println("=========================================================");
					System.out.println("");
		System.out.print("Enter Again :: ");
		trousersback();
				}
}

public void trousersinput() {
	try{
		Scanner sc = new Scanner(System.in);
		var input=sc.nextInt();
		switch(input) {
		case 1:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Jockey Men Casual Trousers");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Double knit Jacquard Super combed Cotton fabric");
		System.out.println("--> Comfortable waistband with button fastening & inner drawstring");
		System.out.println("--> Convenient side & back pockets");
		System.out.println("--> Flat & extra soft seams guaranteed to make the product last long");
		System.out.println("--> Machine wash");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 899");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Jockey Men Casual Trousers");
			rate.add(899);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+899;
			trousersback();
		}
		else {
			trousers();
		}
	}break;
		case 2:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: SWADESI STUFF Men's Casual Chino Pants");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Swadesi Stuff Casual Trousers for Men are made of premium quality Lycra Blend fabric that provides excellent comfort and durability.");
		System.out.println("--> These trousers feature a stylish and modern design that makes them perfect for casual wear.");
		System.out.println("--> The trousers are stitched with precision to ensure they are durable and long-lasting");
		System.out.println("--> These trousers come equipped with multiple pockets, providing ample space to store essentials like phones, wallets, and keys");
		System.out.println("--> The Swadesi Stuff Casual Trousers are suitable for a wide range of occasions, including work, casual outings, and even formal events");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 699");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("SWADESI STUFF Men's Casual Chino Pants");
			rate.add(699);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+699;
			trousersback();
		}
		else {
			trousers();
		}
	}break;
		case 3:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Urbano Fashion Men's Cotton Slim Fit Casual Chinos Trousers");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> This fabric is suited to craft the perfect comfort-oriented lightweight chinos.");
		System.out.println("--> The material used is versatile, light, durable, and low maintenance.");
		System.out.println("--> The trousers are stitched with precision to ensure they are durable and long-lasting");
		System.out.println("--> It is a stylish casual pant for men that can be paired either to fit a smart casual or even a formal looks");
		System.out.println("--> This has a midrise waist and stretchable tapered fit");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 799");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Urbano Fashion Men's Cotton Slim Fit Casual Chinos Trousers");
			rate.add(799);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+799;
			trousersback();
		}
		else {
			trousers();
		}
	}break;
		case 4:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Dennis Lingo Men Casual Pants");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> The Dennis Lingo solid cotton casual trousers are crafted with 98% Cotton and 2% Lycra.");
		System.out.println("--> It is comfortable at the hip and tapered below the knee, making dressing up or down easy for daily comfort.");
		System.out.println("--> This is a solid casual trouser featuring a buttoned waist, designed with flat-front styling with 5 pockets.");
		System.out.println("--> These chinos are made from a lightweight cotton material offering superior comfort and enhanced breathability.");
		System.out.println("--> Machine washable, use mild detergent, do not bleach, dry in shade, wash with similar colors");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 649");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Dennis Lingo Men Casual Pants");
			rate.add(649);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+649;
			trousersback();
		}
		else {
			trousers();
		}
	}break;
		case 5:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: LOUIS PHILLIPPS™ Men's Slim Fit Casual Trousers");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> LOUIS PHILLIPPS MEN’S BUSINESS CASUALS CHINOS, WITH WELTED BACK POCKETS.");
		System.out.println("--> NEW STYLE SLIM FIT WITH MID RISE TROUSER, ONLY UNDER 1000 & YOU WILL DEFINITELY LOVE IT.");
		System.out.println("--> 95% TWILL COTTON, 5% LYCRA FOR MORE COMFORT-ABILITY & ATHLEISURE LIFESTYLE.");
		System.out.println("--> THEY ARE CUT TO SIT AT LOW WAIST, COMFORTABLY FITS THROUGHOUT THE SEAT.");
		System.out.println("-->  LOUIS PHILLIPPS SLIM FIT TROUSERS ARE THE MOST LOVED FITS.");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 749");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("LOUIS PHILLIPPS™ Men's Slim Fit Casual Trousers");
			rate.add(749);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+749;
			trousersback();
		}
		else {
			trousers();
		}
	}break;
		case 6:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: The Indian Garage Co Men Chinos");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Slim Fit Mid-Rise Checkered Chinos.");
		System.out.println("--> Breathable Premium Cotton fabric, pre washed for an extremely soft finish and rich look.");
		System.out.println("--> Do not bleach, dry in shade, wash with similar colors.");
		System.out.println("--> Proudly made in India.");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 649");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("The Indian Garage Co Men Chinos");
			rate.add(649);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+649;
			trousersback();
		}
		else {
			trousers();
		}
	}break;
		case 7:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Pepe Jeans Men Pant");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Slim Fit with Mid-Rise Waist.");
		System.out.println("--> The cotton rich, breathable fabric is durable, absorbent and skin-friendly, making it great for workouts, lounging and casual wear.");
		System.out.println("--> The soft-feel, stretchable fabric gives you a slim fit that hugs your body and delivers a sporty look.");
		System.out.println("--> Designed for all day comfort, these lounge pants have flat drawcords and HD print.");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 699");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Pepe Jeans Men Pant");
			rate.add(699);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+699;
			trousersback();
		}
		else {
			trousers();
		}
	}break;
		case 8:new Men();
		break;
		case 9:category();
		break;
		case 10:cart();
		break;
		case 11:exit();
		break;
			default:
				System.err.println("Invalid Input!!");
				System.out.println("=========================================================");
				System.out.println("");
				System.out.println("");
				trousersinput();
				break;
		}
	}
	catch(InputMismatchException e) {
				System.err.println("Invalid Input!! Please Enter Integer not Character");
				System.out.println("=========================================================");
				System.out.println("");
	System.out.print("Enter Again :: ");
	trousersinput();
			}
}

//--------------------------------------------------------------------Jeans Section

public void jeans() {
	System.out.println("");
	System.out.println("********************************************************************");
	System.out.println("Welcome to Jeans Collection");
	System.out.println("********************************************************************");
				System.out.println("1.Men's Comfortable Stretchable Casual Denim Jeans");
				System.out.println("2.SCOTLANE Men's Cotton Regular Fit Solid Full Length Jeans");
				System.out.println("3.Levi's Men Mid Rise Slim Tapered Fit Jeans");
				System.out.println("4.Billford Men Jeans");
				System.out.println("5.Urbano Fashion Men's Slim Fit Washed Jeans Stretchable");
				System.out.println("6.Ben Martin Men's Relaxed Fit Jeans");
				System.out.println("7.Instafab Plus Men’s Classic Distressed Patterned Denim Jeans");
				System.out.println("8.Mens Collection");
				System.out.println("9.Main Collection");
				System.out.println("10.Cart Section");
				System.out.println("11.Exit");
				System.out.println("********************************************************************");
				System.out.println("");
				System.out.print("ENTER YOUR CHOICES :: ");
				jeansinput();
			}

public void jeansinput() {
	try{
		Scanner sc = new Scanner(System.in);
		var input=sc.nextInt();
		switch(input) {
		case 1:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Men's Comfortable Stretchable Casual Denim Jeans");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Timeless design with a versatile, classic fit that never goes out of style");
		System.out.println("--> Made from high-quality, durable denim for long-lasting wear");
		System.out.println("--> Designed for all-day comfort, with just the right amount of stretch");
		System.out.println("--> Suitable for casual, business-casual, and even dressier occasions");
		System.out.println("--> High-quality jeans at a price that won't break the bank");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 899");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add(" Men's Comfortable Stretchable Casual Denim Jeans");
			rate.add(899);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+899;
			jeanssback();
		}
		else {
			jeans();
		}
	}break;
		case 2:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: SCOTLANE Men's Cotton Regular Fit Solid Full Length Jeans");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Attention to detail and quality craftsmanship");
		System.out.println("--> Scotlane men's denim jeans are a stylish and comfortable addition to any wardrobe.");
		System.out.println("--> The denim fabric has a slight stretch for added comfort and flexibility");
		System.out.println("--> Easy to care for and can be machine washed");
		System.out.println("--> Manufactured in India");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 749");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("SCOTLANE Men's Cotton Regular Fit Solid Full Length Jeans");
			rate.add(749);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+749;
			jeanssback();
		}
		else {
			jeans();
		}
	}break;
		case 3:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Levi's Men Mid Rise Slim Tapered Fit Jeans");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> The personalized and unique design exudes basic casual jeans, making you look more handsome and the coolest guy on every occasion");
		System.out.println("--> Convenient side & back pocket.");
		System.out.println("--> The denim fabric has a slight stretch for added comfort and flexibility");
		System.out.println("--> Designed for all day comfort, these lounge jeans");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 1099");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Levi's Men Mid Rise Slim Tapered Fit Jeans");
			rate.add(1099);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+1099;
			jeanssback();
		}
		else {
			jeans();
		}
	}break;
		case 4:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Billford Men Jeans");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> These Basic jeans are constructed from a perfect blend of stretch-cotton fabric");
		System.out.println("--> Made with durable cotton denim, these stretch-fit jeans are stretchy.");
		System.out.println("--> Soft, breathable, wear-resistant, and durable, ensuring they can be worn all day");
		System.out.println("--> These jeans feature a zipper fly and button closure, along with two front pockets and two back pockets");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 599");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Billford Men Jeans");
			rate.add(599);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+599;
			jeanssback();
		}
		else {
			jeans();
		}
	}break;
		case 5:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Urbano Fashion Men's Slim Fit Washed Jeans Stretchable");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Cotton with Lycra/Elastane for Stretchability (98% Cotton , 2% Elastane)");
		System.out.println("--> Suitable for casual, business-casual, and even dressier occasions.");
		System.out.println("--> Zip Fly with Button Closure");
		System.out.println("--> Easy to care for and can be machine washed");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 699");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Urbano Fashion Men's Slim Fit Washed Jeans Stretchable");
			rate.add(699);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+699;
			jeanssback();
		}
		else {
			jeans();
		}
	}break;
		case 6:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Ben Martin Men's Relaxed Fit Jeans");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> Color: Dark Blue");
		System.out.println("--> Occasion: Casual.");
		System.out.println("--> Do not bleach, dry in shade");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 699");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Ben Martin Men's Relaxed Fit Jeans");
			rate.add(699);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+699;
			jeanssback();
		}
		else {
			jeans();
		}
	}break;
		case 7:
		{
			System.out.println("=============================================================");
			System.out.println("Item :: Instafab Plus Men’s Classic Distressed Patterned Denim Jeans");
			System.out.println("=============================================================");
		System.out.println("About this item ::");
		System.out.println("--> This denim jeans are fabricated with top-grade and durable material.");
		System.out.println("--> Made of fabric that holds its shape throughout the day, lets you have no restriction and feel relaxed.");
		System.out.println("--> This denim jeans have a regular fit. Quality craftsmanship is at the forefront.");
		System.out.println("--> Designed to offer an energetic look, the denim jeans combine the warmth of comfortable and casual feel.");
		System.out.println("--> Wash & dry inside out. Wash separately.");
		System.out.println("=============================================================");
		System.out.println("Price :: RS 999");
		System.out.println("=============================================================");
		System.out.println("Do You want byu!!");
		System.out.println("If Yes Press (Y) else press any character to go back");
		char byu=sc.next().charAt(0);
		if(byu == 'Y' || byu== 'y') {
			condition();
			cart.add("Instafab Plus Men’s Classic Distressed Patterned Denim Jeans");
			rate.add(999);
			System.out.println("Added to Cart");
			Totalbill=Totalbill+999;
			jeanssback();
		}
		else {
			jeans();
		}
	}break;
		case 8:new Men();
		break;
		case 9:category();
		break;
		case 10:cart();
		break;
		case 11:exit();
		break;
			default:
				System.err.println("Invalid Input!!");
				System.out.println("=========================================================");
				System.out.println("");
                System.out.print("Please Enter Correct Input :: ");
				jeansinput();
				break;
		}
	}
	catch(InputMismatchException e) {
	System.err.println("Invalid Input!! Please Enter Integer not Character");
	System.out.println("=========================================================");
	System.out.print("Enter Again :: ");
	jeansinput();
			}
}

public void jeanssback() {
	System.out.println("=============================================================");
	System.out.println("1 - Jeans Collection");
	System.out.println("2 - Mens Collection");
	System.out.println("3 - Main Collection");
	System.out.println("4 - Card Section");
	System.out.println("=============================================================");
	System.out.print("");
	System.out.print("ENTER YOUR CHOICES :: ");
	try{
		Scanner sc = new Scanner(System.in);
		int subinput=sc.nextInt();
		switch(subinput) {
		case 1: jeans();
		break;
		case 2:new Men();
		break;
		case 3:category();
		break;
		case 4:cart();
		break;
		default:
			System.err.println("Invalid Input!! ");
			System.out.println("=========================================================");
			System.out.print("Please Enter Correct Input :: ");
			jeanssback();
		}
	}
	catch(InputMismatchException e) {
	System.err.println("Invalid Input!! Please Enter Integer not Character");
	System.out.println("=========================================================");
	System.out.print("Enter Again :: ");
	jeanssback();
			}
}

//---------------------------------------------------------Kurta Section
 public void kurta() {
	 System.out.println("");
	 System.out.println("********************************************************************");
	 System.out.println("Welcome to Kurta Collection");
	 System.out.println("********************************************************************");
					System.out.println("We have collection of ");  
					System.out.println("1.Bigbanana Men's Regular Fit Printed Short Kurta");
					System.out.println("2.KARNAM Full Sleeves Raw Art Silk Kurta for Men");
					System.out.println("3.IDENTITI Men Solid Slim Fit Casual Kurta for Men");
					System.out.println("4.Zelboraf Men's Solid Light Weight and Comfertable Short Kurta");
					System.out.println("5.Men's Floral Embroidered Lakhnavi Ethnic Wear Straight Kurta");
					System.out.println("6.Kuons Avenue Men's Denim Regular Kurta");
					System.out.println("7.Majestic Man Cotton Solid Casual Short Kurta for Men");
					System.out.println("8.Mens Collection");
					System.out.println("9.Main Collection");
					System.out.println("10.Cart Section");
					System.out.println("11.Exit");
					System.out.println("********************************************************************");
					System.out.println("");
					System.out.print("ENTER YOUR CHOICES :: ");
					kurtainput();
 }
 public void kurtaback() {
		System.out.println("=============================================================");
		System.out.println("1 - Kurta Collection");
		System.out.println("2 - Mens Collection");
		System.out.println("3 - Main Collection");
		System.out.println("4 - Card Section");
		System.out.println("=============================================================");
		System.out.println("");
		System.out.print("ENTER YOUR CHOICES :: ");
		try{
			Scanner sc = new Scanner(System.in);
			int subinput=sc.nextInt();
			switch(subinput) {
			case 1: kurta();
			break;
			case 2:new Men();
			break;
			case 3:category();
			break;
			case 4:cart();
			break;
			default:
				System.err.println("Invalid Input!! ");
				System.out.println("=========================================================");
				System.out.print("Please Enter Correct Input :: ");
				kurtaback();
			}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		kurtaback();
				}
	}
 public void kurtainput() {
		try{
			Scanner sc = new Scanner(System.in);
			 var input=sc.nextInt();
				switch(input) {
				case 1:
				{
					System.out.println("=============================================================");
					System.out.println("Item :: Bigbanana Men's Regular Fit Printed Short Kurta");
					System.out.println("=============================================================");
				System.out.println("About this item ::");
				System.out.println("--> Short Kurta in Super Combed Cotton");
				System.out.println("--> Men blue short kurta");
				System.out.println("--> Patch pocket");
				System.out.println("--> Mandarin collar");
				System.out.println("=============================================================");
				System.out.println("Price :: RS 799");
				System.out.println("=============================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("Bigbanana Men's Regular Fit Printed Short Kurta");
					rate.add(799);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+799;
					kurtaback();
				}
				else {
					kurta();
				}
			}break;
				case 2:
				{
					System.out.println("=============================================================");
					System.out.println("Item :: KARNAM Full Sleeves Raw Art Silk Kurta for Men");
					System.out.println("=============================================================");
				System.out.println("About this item ::");
				System.out.println("--> Comfortable Raw Art Silk material which is specially designed for your skin with trendy look");
				System.out.println("--> Perfect for Indian Wedding, Office Events, Traditional Days and Religious Festivals");
				System.out.println("--> The Kurta is made from Lightweight and Breathable Raw Silk");
				System.out.println("--> This kurta captures all of the details of the classic Indian men's garment with long sleeves");
				System.out.println("=============================================================");
				System.out.println("Price :: RS 699");
				System.out.println("=============================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("KARNAM Full Sleeves Raw Art Silk Kurta for Men");
					rate.add(699);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+699;
					kurtaback();
				}
				else {
					kurta();
				}
			}break;
				case 3:
				{
					System.out.println("=============================================================");
					System.out.println("Item :: IDENTITI Men Solid Slim Fit Casual Kurta for Men");
					System.out.println("=============================================================");
				System.out.println("About this item ::");
				System.out.println("--> Fabric: Viscose Rayon");
				System.out.println("--> Sleeve Length: Long Sleeves");
				System.out.println("--> Neck/Collar: Mandarin Collar");
				System.out.println("--> Color: White");
				System.out.println("=============================================================");
				System.out.println("Price :: RS 499");
				System.out.println("=============================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("IDENTITI Men Solid Slim Fit Casual Kurta for Men");
					rate.add(499);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+499;
					kurtaback();
				}
				else {
					kurta();
				}
			}break;
				case 4:
				{
					System.out.println("=============================================================");
					System.out.println("Item :: Zelboraf Men's Solid Light Weight and Comfertable Short Kurta");
					System.out.println("=============================================================");
				System.out.println("About this item ::");
				System.out.println("--> Perfect for Indian Wedding, Office Events, Traditional Days and Religious Festivals");
				System.out.println("--> Neck:- Collared Collar||Sleeve Type: Long Sleeve ||Closure - Button");
				System.out.println("--> Material:- Cotton ||Color:- Green ||Pattern:- Solid");
				System.out.println("--> Upgrade your fashion quotient with these kurta for men as they give you a new look and appeal.");
				System.out.println("=============================================================");
				System.out.println("Price :: RS 599");
				System.out.println("=============================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("Zelboraf Men's Solid Light Weight and Comfertable Short Kurta");
					rate.add(599);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+599;
					kurtaback();
				}
				else {
					kurta();
				}
			}break;
				case 5:
				{
					System.out.println("=============================================================");
					System.out.println("Item :: Men's Floral Embroidered Lakhnavi Ethnic Wear Straight Kurta");
					System.out.println("=============================================================");
				System.out.println("About this item ::");
				System.out.println("--> Made from the cotton blend fabric.Lightweight and breathable material gives this kurta pajama");
				System.out.println("--> Traditional design on this kurta captures all of the details of the classic Indian men's garment");
				System.out.println("--> Collar: Mandarin, Sleeves: Full, Length: Knee length Kurta");
				System.out.println("--> Occasion: Casual, Party, Festival and Special Occasions.");
				System.out.println("=============================================================");
				System.out.println("Price :: RS 1199");
				System.out.println("=============================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("Men's Floral Embroidered Lakhnavi Ethnic Wear Straight Kurta");
					rate.add(1199);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1199;
					kurtaback();
				}
				else {
					kurta();
				}
			}break;
				case 6:
				{
					System.out.println("=============================================================");
					System.out.println("Item :: Kuons Avenue Men's Denim Regular Kurta");
					System.out.println("=============================================================");
				System.out.println("About this item ::");
				System.out.println("--> Pattern: Solid Kurta, Kurta Length: Mid Thigh Length");
				System.out.println("--> Sleeve Type: Long Sleeves, Fit: Tailored Fit");
				System.out.println("--> Neck Style: Mandarin Collar, Pocket: Welt Pockets on Chest");
				System.out.println("--> Occasion: Casual, Party, Festival and Special Occasions.");
				System.out.println("=============================================================");
				System.out.println("Price :: RS 1099");
				System.out.println("=============================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("Kuons Avenue Men's Denim Regular Kurta");
					rate.add(1099);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1099;
					kurtaback();
				}
				else {
					kurta();
				}
			}break;
				case 7:
				{
					System.out.println("=============================================================");
					System.out.println("Item :: Majestic Man Cotton Solid Casual Short Kurta for Men");
					System.out.println("=============================================================");
				System.out.println("About this item ::");
				System.out.println("--> Beautifully crafted in Pure cotton fabric, it comes in a convenient slim fit.");
				System.out.println("--> Features Mandarin collar and long sleeve.");
				System.out.println("--> This kurta has been designed keeping in mind the latest trends in a casual fashion.");
				System.out.println("--> Occasion - Casual wear, Regular Wear, Evening Wear.");
				System.out.println("=============================================================");
				System.out.println("Price :: RS 599");
				System.out.println("=============================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("Majestic Man Cotton Solid Casual Short Kurta for Men");
					rate.add(599);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+599;
					kurtaback();
				}
				else {
					kurta();
				}
			}break;
		 case 8:new Men();
			break;
			case 9: category();
			break;
			case 10: cart();
			break;
			case 11:exit();
			break;
				default:
					System.err.println("Invalid Input!! ");
					System.out.println("=========================================================");
					System.out.print("Please Enter Correct Input :: ");
					kurtainput();
					break;
			}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		kurtainput();
				}
 }
//Class Closed
}

//WOMEN Class 
//@inheritance
class WOMEN extends FashionStree
{	
//Non-Static Block
	{	
		System.out.println("");
	System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	System.out.println("                    Welcome To Women Collections                  ");
    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("");
		System.out.println("1 - Sarees");
		System.out.println("2 - Salwar Suits");
		System.out.println("3 - Tops & Tees");
		System.out.println("4 - Jeans");
		System.out.println("5 - Kurti");
		System.out.println("6 - Main Collection");
		System.out.println("7 - Cart Section");
		System.out.println("8 - Exit");
		System.out.println("=========================================================");
		System.out.println("");
		System.out.print("ENTER YOUR CHOICES :: ");
		inputSubcategory();;
	}
	
	
public void inputSubcategory() {
		try{
			Scanner sc = new Scanner(System.in);
			var input=sc.nextInt();
			switch(input){
				case 1:	sarees();
				break;
				case 2:salwarsuits();
				break;
				case 3:tops_tees();
				break;
				case 4:jeans();
				break;
				case 5:kurta();
				break;
				case 6:category();
				break;
				case 7:cart();
				break;
				case 8:exit();
				break;
				default :
					System.err.println("Invalid Input!!");
					System.out.println("=========================================================");
					System.out.println(" Please Enter Correct Input :: " );
					inputSubcategory();
					break;
			}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		inputSubcategory();
				}
	}

//-----------------------------------------Sarees Section
public void sarees(){
	        	 System.out.println("");
	        	 System.out.println("********************************************************************");
	        	 System.out.println("Welcome to Sarees Collection");
	        	 System.out.println("********************************************************************");
	        	System.out.println("1.SWORNOF Banarasi Silk Saree");
	        	System.out.println("2.SWORNOF Kanjivaram Soft Silk Saree Patola saree");
	        	System.out.println("3.Glory Sarees Kanchipuram Art Silk Saree");
	        	System.out.println("4.Kanjivaram Pure Soft Silk Handloom Saree");
	        	System.out.println("5.Glory Sarees Banarasi Silk Saree");
	        	System.out.println("6.Pure Kanjivaram Silk Saree Banarasi Silk Saree");
	        	System.out.println("7.Art Silk Sarees");
	        	System.out.println("8.Printed Poly Silk Saree");
	        	System.out.println("9.Tone Foil Printed Saree");
	        	System.out.println("10.Lucknowi Chikankari Linen cotton Woven Sarees");
	        	System.out.println("11.Women Collection");
	        	System.out.println("12.Main Collection");
	        	System.out.println("13.Cart Section");
	        	System.out.println("14.Exit");
	        	System.out.println("=======================================================================");
	        	System.out.println("");
	        	System.out.print("ENTER YOUR CHOICES :: ");
	        	sareesinput();		
			}
	        
public void sareesinput(){
	    	   try{
	    		   Scanner sc = new Scanner(System.in);
		    	   var input=sc.nextInt();
					switch(input){
					case 1:{
								System.out.println("=============================================================");
								System.out.println("Item :: SWORNOF Banarasi Silk Saree");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Gorgeous Design Style-Traditional Saree");
								System.out.println("--> Colour : Peach, Blue Rich Zari Border pallu.");
								System.out.println("--> Fabric: Comfortable and Pure Art Silk");
								System.out.println("--> Note-: Saree Comes Without Tassels.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 850");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y'){
									condition();
									cart.add("SWORNOF Banarasi Silk Saree");
									rate.add(850);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+850;
									sareesback();
								}
								else {
									sarees();
								}
							}
							break;
					case 2:{
						System.out.println("=============================================================");
						System.out.println("Item :: SWORNOF Kanjivaram Soft Silk Saree Patola saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Material : Soft silk || Design : Silk saree");
						System.out.println("--> Style : The Texture And Weight Of The Saree Brings Image Prints One Step Closer To The Originals And Invites Attention.");
						System.out.println("--> Sarees for women, festive, traditional saree");
						System.out.println("--> Best birth-day gift for your loved ones. Each piece is elegantly crafted and will surely add to your wardrobe");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 1199");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("SWORNOF Kanjivaram Soft Silk Saree Patola saree");
							rate.add(1199);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+1199;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 3:{
						System.out.println("=============================================================");
						System.out.println("Item :: Glory Sarees Kanchipuram Art Silk Saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> This kanchipuram style saree have soft finished art silk fabric easy and comfortable to wear");
						System.out.println("--> This saree have beautiful blouse made from art silk fabric woven with zari border.");
						System.out.println("--> This amazing saree have red colour");
						System.out.println("--> This beautiful saree woven in zari on technology repair jacquard machine");
						System.out.println("--> This sarees is specially design for and festive season of women wear");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 599");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Glory Sarees Kanchipuram Art Silk Saree");
							rate.add(599);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+599;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 4:{
						System.out.println("=============================================================");
						System.out.println("Item :: Kanjivaram Pure Soft Silk Handloom Saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Kanjivaram Pure Soft Silk Handloom, Zari Woven");
						System.out.println("--> Bold and beautiful, this Kanchipuram KING & QUEEN ATTRACTIVE silk saree is all about impactful presence.");
						System.out.println("--> This amazing saree have Royal Bottle Dark Pink-Rama Red color");
						System.out.println("--> Soft Finished Comfortable To Wear and Easy To Take Fleets.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 1599");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Kanjivaram Pure Soft Silk Handloom Saree");
							rate.add(1599);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+1599;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 5:{
						System.out.println("=============================================================");
						System.out.println("Item :: Glory Sarees Banarasi Silk Saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> This amazing saree have pink colour which make you look awesome");
						System.out.println("--> This beautiful saree woven in zari on jacquard repair loom.");
						System.out.println("--> This banarasi silk saree have soft finished fabric easy and comfortable to wear");
						System.out.println("--> This sarees is specially design for and festive season of women's wear.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 609");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition(); 
							cart.add("Glory Sarees Banarasi Silk Saree");
							rate.add(609);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+609;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 6:{
						System.out.println("=============================================================");
						System.out.println("Item :: Pure Kanjivaram Silk Saree Banarasi Silk Saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Banarasi Traditional Silk Saree from C J Enterprise");
						System.out.println("--> Fabric: Saree: Lichi Silk Blend || Blouse: Lichi Silk.");
						System.out.println("--> This amazing saree have wine colour which make you look awesome");
						System.out.println("--> Perfect for Event: Festive Wear Saree || Occasional Wear Saree || Party Wear Saree || Traditional Wear Saree || Wedding Wear Saree.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 599");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Pure Kanjivaram Silk Saree Banarasi Silk Saree");
							rate.add(599);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+599;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 7:{
						System.out.println("=============================================================");
						System.out.println("Item :: Pure Kanjivaram Silk Saree Banarasi Silk Saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Art Silk Sarees from Yashika Store.");
						System.out.println("--> Color: Beige || Fabric: Art Silk.");
						System.out.println("--> Hand wash & dry wash but requested not to use hard brush on the fabric");
						System.out.println("--> Product color may slightly vary due to photographic lighting and lighting used in mode.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 299");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Pure Kanjivaram Silk Saree Banarasi Silk Saree");
							rate.add(299);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+299;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 8:{
						System.out.println("=============================================================");
						System.out.println("Item :: Printed Poly Silk Saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Fabric: Poly Silk || Color: Yellow (Mustard)");
						System.out.println("--> Wash Separately in Cold Water, Do Not Bleach, Dry in Shade, Medium to Hot Iron.");
						System.out.println("--> Tip: Pair This Saree High Heels, Hand Clutch/Bag and Minimul Jewellery");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 499");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Printed Poly Silk Saree");
							rate.add(499);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+499;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 9:{
						System.out.println("=============================================================");
						System.out.println("Item :: Tone Foil Printed Saree");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Tree Shape Block Pattern Foil Print Design, Triangular Print Pallav, Shiny Golden Zari Woven Border with Foil Print Blouse Piece.");
						System.out.println("--> Fabric :: Saree - Cotton Blend (not pure cotton).");
						System.out.println("--> Color :: Teal, Gold.");
						System.out.println("--> This saree is suitable for get stylish contemporary look in functions, parties, festive occasions, marriage ceremony, evening & gifting to loved ones");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 649");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Tone Foil Printed Saree");
							rate.add(649);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+649;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 10:{
						System.out.println("=============================================================");
						System.out.println("Item :: Lucknowi Chikankari Linen cotton Woven Sarees");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Material : Soft Cotton || Color: Royal Blue");
						System.out.println("--> The Texture And Weight Of The Saree Brings Image Prints One Step Closer To The Originals And Invites Attention.");
						System.out.println("--> Each piece is elegantly crafted and will surely add to your wardrobe.");
						System.out.println("--> Sarees for festive, traditional saree. Best birth-day gift for your loved ones.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 649");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Lucknowi Chikankari Linen cotton Woven Sarees");
							rate.add(649);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+649;
							sareesback();
						}
						else {
							sarees();
						}
					}
					break;
					case 11:new WOMEN();
					break;
					case 12:category();
					break;
					case 13:cart();
					break;
					case 14:exit();
					break;
					default:
						System.err.println("Invalid Input!! ");
						System.out.println("================================================================"); 
						System.out.print("Please Enter Correct Input :: ");
						sareesinput();
						break;
					}
				}
				catch(InputMismatchException e) {
				System.err.println("Invalid Input!! Please Enter Integer not Character");
				System.out.print("Enter Again :: ");
				sareesinput();
						}
						
	        }
	       
public void sareesback(){
	    	   System.out.println("=============================================================");
	    		System.out.println("");
	    		System.out.println("1 - Sarees Collection");
	    		System.out.println("2 - Women Collection");
	    		System.out.println("3 - Home page");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("");
	    		System.out.print("ENTER YOUR CHOICES ::");
	    		
	    		try{
	    			Scanner sc = new Scanner(System.in);
		    		int subinput=sc.nextInt();
		    		switch(subinput) {
		    		case 1: sarees();
		    		break;
		    		case 2:new WOMEN();
		    		break;
		    		case 3:category();
		    		break;
		    		case 4:cart();
		    		break;
		    		default:
		    			System.err.println("Invalid Input!! ");
		    			System.out.println("=========================================================");
		    			System.out.print("Please Enter Correct Input :: ");
		    			sareesback();
		    		break;
		    		}
	    		}
	    		catch(InputMismatchException e) {
	    		System.err.println("Invalid Input!! Please Enter Integer not Character");
	    		System.out.println("=========================================================");
	    		System.out.print("Enter Again :: ");
	    		sareesback();
	    				}
	        }

///------------------------------------------Salwar Suits Section
public void salwarsuits() {
	    	   System.out.println("");
	    		 System.out.println("********************************************************************");
	        	System.out.println("Welcome to Salwar Suits Collection");
	       	 System.out.println("********************************************************************");
	        	System.out.println("1.Cotton Printed Women suit with Palazzo & Dupatta Set");
	        	System.out.println("2.Cotton Embroidered Straight Kurta Pant With Dupatta Set");
	        	System.out.println("3.Rajnandini Printed Readymade Salwar Suit");
	        	System.out.println("4.Net Semi Stitched Top With Stitched Net Bottom");
	        	System.out.println("5.Bollyclues Georgette Embroidered Readymade Salwar Suit Set");
	        	System.out.println("6.Trendmalls Embroidery Salwar Suit Set Kurta Pant");
	        	System.out.println("7.Miss Ethnik Faux Georgette Semi Stitched Top ");
	        	System.out.println("8.Pistaa's Cotton Solid Kurta With Palazzo Bottom Set");
	        	System.out.println("9.Royal Export Skyblue Floral Printed Salwar Suit Set");
	        	System.out.println("10.Pistaa's Loose Fit Cotton Salwar Suit");
	        	System.out.println("11.Women Collection");
	        	System.out.println("12.Main Collection");
	        	System.out.println("13.Cart Section");
	        	System.out.println("14.Exit");
	       	 System.out.println("********************************************************************");
	        	System.out.print ("ENTER YOUR CHOICES :: ");
	        	salwarsuitsinput();	
			}
	       
public void salwarsuitsinput() {
	    	
				try{
					   Scanner sc = new Scanner(System.in);
			    	   var input=sc.nextInt();
						switch(input){
						case 1:{
									System.out.println("=============================================================");
									System.out.println("Item :: Cotton Printed Women suit with Palazzo & Dupatta Set");
									System.out.println("=============================================================");
									System.out.println("About this item ::");
									System.out.println("--> Luxurious and elegant, suitable for festive occasions and parties.");
									System.out.println("--> Simple and comfortable kurtis for daily wear, available in vibrant colors and prints.");
									System.out.println("--> Stylish and embellished kurtis suitable for parties and special occasions.");
									System.out.println("=========================================================");
									System.out.println("Price :: RS 649");
									System.out.println("=========================================================");
									System.out.println("Do You want byu!!");
									System.out.println("If Yes Press (Y) else press any character to go back");
									char byu=sc.next().charAt(0);
									if(byu == 'Y' || byu== 'y') {
										condition();
										cart.add("Cotton Printed Women suit with Palazzo & Dupatta Set");
										rate.add(649);
										System.out.println("Added to Cart");
										Totalbill=Totalbill+649;
										salwarsuitsback();
									}
									else {
										salwarsuits();
									}
								}
								break;
						case 2:{
							System.out.println("=============================================================");
							System.out.println("Item :: Cotton Embroidered Straight Kurta Pant With Dupatta Set");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Embroidered Work and Crosia Lace Work on Yoke, Sleeve With Pant Border.");
							System.out.println("--> Kurta Pant Set Attached Printed Chiffon Dupatta With Tassel.");
							System.out.println("--> Drawstring latkan at waist area for proper fit.");
							System.out.println("--> Colour of the actual product may slightly vary due to different photographic lighting sources.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 999");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Cotton Embroidered Straight Kurta Pant With Dupatta Set");
								rate.add(999);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+999;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;
						case 3:{
							System.out.println("=============================================================");
							System.out.println("Item :: Rajnandini Printed Readymade Salwar Suit");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Color : Top -Blue , Bottom - Grey , Dupatta - Blue And Grey.");
							System.out.println("--> Simple and comfortable suit for daily wear, available in vibrant colors and prints.");
							System.out.println("--> Drawstring latkan at waist area for proper fit.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 649");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Rajnandini Printed Readymade Salwar Suit");
								rate.add(649);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+649;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;
						case 4:{
							System.out.println("=============================================================");
							System.out.println("Item :: Net Semi Stitched Top With Stitched Net Bottom");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Top Fabric : Net With Santoon Inner , Bottom Fabric : Net With Santoon Inner , Dupatta Fabric : Net.");
							System.out.println("--> Top : Semi Stitched , Bottom : Stitched; Work : Embroidered.");
							System.out.println("--> Occasion Type: Ceremony; Sleeve Type: Long Sleeve.");
							System.out.println("--> Material Composition: 80% Santoon 20% Synthetic.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 1119");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Net Semi Stitched Top With Stitched Net Bottom");
								rate.add(1119);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+1119;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;
						case 5:{
							System.out.println("=============================================================");
							System.out.println("Item :: Bollyclues Georgette Embroidered Readymade Salwar Suit Set");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Top Fabric : Georgette || Inner Fabric : Crepe || Dupatta fabric: Georgette.");
							System.out.println("--> Work : Floral Thread Work Embroidery.");
							System.out.println("--> Occasion : Ceremony , Evening, Festival , Official or casual wear.");
							System.out.println("--> There might be slight variation in the actual colour of the product due to different screen resolutions.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 1219");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Bollyclues Georgette Embroidered Readymade Salwar Suit Set");
								rate.add(1219);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+1219;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;
						case 6:{
							System.out.println("=============================================================");
							System.out.println("Item :: Trendmalls Embroidery Salwar Suit Set Kurta Pant");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Suit Fabric: Kurta, Salwar: Cotton; Inner: Santoon, Dupatta: Nylon Organza.");
							System.out.println("--> Work: Embroidery,Wave Cutwork Dupatta.");
							System.out.println("--> Color: LightPink.");
							System.out.println("--> Style: Straight Kurta Pant Suit Set.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 1499");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Trendmalls Embroidery Salwar Suit Set Kurta Pant");
								rate.add(1499);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+1499;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;		
						case 7:{
							System.out.println("=============================================================");
							System.out.println("Item :: Miss Ethnik Faux Georgette Semi Stitched Top");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Top : Semi Stitched , Bottom : Stitched.");
							System.out.println("--> Work : Embroidered.");
							System.out.println("--> Color: Heavy Black.");
							System.out.println("--> Type : Party wear Kurta Palazzo Set.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 1199");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Miss Ethnik Faux Georgette Semi Stitched Top");
								rate.add(1199);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+1199;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;		
						case 8:{
							System.out.println("=============================================================");
							System.out.println("Item :: Pistaa's Cotton Solid Kurta With Palazzo Bottom Set");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Work : Solid Plain.");
							System.out.println("--> Color: Yellow.");
							System.out.println("--> Wash Care : Do Not Bleach It and Wash It Separately In Cold Water.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 799");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Pistaa's Cotton Solid Kurta With Palazzo Bottom Set");
								rate.add(799);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+799;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;
						case 9:{
							System.out.println("=============================================================");
							System.out.println("Item :: Royal Export Skyblue Floral Printed Salwar Suit Set");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> Length: Calf || Sleeves: 3/4th.");
							System.out.println("--> Ocassion: Traditional wear, Casual Wear, party wear, evening wear.");
							System.out.println("--> Product Color May Slightly Vary Due To Photographic Lighting Sources.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 749");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Royal Export Skyblue Floral Printed Salwar Suit Set");
								rate.add(749);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+749;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;
						case 10:{
							System.out.println("=============================================================");
							System.out.println("Item :: Pistaa's Loose Fit Cotton Salwar Suit");
							System.out.println("=============================================================");
							System.out.println("About this item ::");
							System.out.println("--> MATERIAL DESCRIPTION :- 100% Cotton for a comfortable fit all day long.");
							System.out.println("--> KURTI :: Sleeves :-: 3/4th Fold-up Sleeve, Pattern : solid, Chinese Collar with V Neck, Buttoned are fixed Not Openable.");
							System.out.println("--> PALAZZO :- Style :: Matching Printed Palazzo , Length : 38-39 Inches , Long Flair , Closer.");
							System.out.println("--> WASH CARE :- Hand wash separately in cold water.");
							System.out.println("=========================================================");
							System.out.println("Price :: RS 449");
							System.out.println("=========================================================");
							System.out.println("Do You want byu!!");
							System.out.println("If Yes Press (Y) else press any character to go back");
							char byu=sc.next().charAt(0);
							if(byu == 'Y' || byu== 'y') {
								condition();
								cart.add("Pistaa's Loose Fit Cotton Salwar Suit");
								rate.add(449);
								System.out.println("Added to Cart");
								Totalbill=Totalbill+449;
								salwarsuitsback();
							}
							else {
								salwarsuits();
							}
						}
						break;	
						case 11:new WOMEN();
						break;
			       case 12:category();
					break;
			       case 13:cart();
					break;
					case 14:exit();
					break;
					default:
						System.err.println("Invalid Input!! ");
						System.out.println("================================================================");
						System.out.print("Please Enter Correct Input :: ");
						salwarsuitsinput();
						break;
					
						}
				}
				catch(InputMismatchException e) {
				System.err.println("Invalid Input!! Please Enter Integer not Character");
				System.out.println("=========================================================");
				System.out.print("Enter Again :: ");
				salwarsuitsinput();
						}
	       }
	       
public void salwarsuitsback(){
	    	   System.out.println("=============================================================");
	    		System.out.println("");
	    		System.out.println("1 - Salwar Suits Collection");
	    		System.out.println("2 - Women Collection");
	    		System.out.println("3 - Main Collection");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("");
	    		System.out.println("ENTER YOUR CHOICES :: ");
	    		
	    		try{
	    			Scanner sc = new Scanner(System.in);
		    		int subinput=sc.nextInt();
		    		switch(subinput) {
		    		case 1: salwarsuits();
		    		break;
		    		case 2:new WOMEN();
		    		break;
		    		case 3:category();
		    		break;
		    		case 4:cart();
		    		break;
		    		default:
	System.err.println("Invalid Input!! ");
	System.out.println("=========================================================");
	System.out.println("Please Enter Correct Input :: ");
	salwarsuitsback();
		    		break;
		    		}
	    		}
	    		catch(InputMismatchException e) {
	    		System.err.println("Invalid Input!! Please Enter Integer not Character");
	    		System.out.println("=========================================================");
	    		System.out.print("Enter Again :: ");
	    		salwarsuitsback();
	    				}
	        }

//------------------------------------------Jeans Section
public void jeans() {
				System.out.println("");
				 System.out.println("********************************************************************");
	        	System.out.println("Welcome to Jeans Collection");
	       	 System.out.println("********************************************************************");
	        	System.out.println("1.Women's Stretchable High Waist Denim Jeans");
	        	System.out.println("2.Women's Stretchable Skinny Fit Denim Jeans");
	        	System.out.println("3.Women's High Rise Cotton Lycra Jeans");
	        	System.out.println("4.Women's Nifty Slim Fit Cotton Jeans");
	        	System.out.println("5.Women's Nifty Denim Slim Fit High Waist Jeans");
	        	System.out.println("6.Women's Inkast High Rise Full Length Jeans");
	        	System.out.println("7.Women's Inkd Skinny Fit Jeans");
	        	System.out.println("8.Women's Aka Chic Skinny Fit Jeans");
	        	System.out.println("9.Women's Adbucks High-Rise Clean Look Joggers");
	        	System.out.println("10.Women's Miss Chase Skinny Fit Jeans");
	        	System.out.println("11.Women Collection");
	        	System.out.println("12.Main Collection");
	        	System.out.println("13.Cart Section");
	        	System.out.println("14.Exit");
	       	 System.out.println("********************************************************************");
	       	 System.out.println("");
	        	System.out.print("ENTER YOUR CHOICES :: ");
	        	jeansinput();
			}
			
public void jeansinput() {
			
					try{
						Scanner sc = new Scanner(System.in);
				    	   var input=sc.nextInt();
							switch(input){
							case 1:{
										System.out.println("=============================================================");
										System.out.println("Item :: Women Stretchable High Waist Denim Jeans");
										System.out.println("=============================================================");
										System.out.println("About this item ::");
										System.out.println("--> Denim. 6-inch wide compression belt at the tummy provides a sturdy fit.");
										System.out.println("--> It is super high-waist and provides moderate compression to your abdomen muscles.");
										System.out.println("--> This premium quality Denims with stretchable fabric also has anti-roll Stays.");
										System.out.println("--> Denims like figure hugging fit, extra comfort, pockets, movement-friendly stretch.");
										System.out.println("=========================================================");
										System.out.println("Price :: RS 749");
										System.out.println("=========================================================");
										System.out.println("Do You want byu!!");
										System.out.println("If Yes Press (Y) else press any character to go back");
										char byu=sc.next().charAt(0);
										if(byu == 'Y' || byu== 'y') {
											condition();
											cart.add("Women Stretchable High Waist Denim Jeans");
											rate.add(749);
											System.out.println("Added to Cart");
											Totalbill=Totalbill+749;
											jeansback();
										}
										else {
											jeans();
										}
									}
									break;
							case 2:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Stretchable Skinny Fit Denim Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Timeless design with a versatile, classic fit that never goes out of style");
								System.out.println("--> Made from high-quality, durable denim for long-lasting wear");
								System.out.println("--> Designed for all-day comfort, with just the right amount of stretch");
								System.out.println("--> Suitable for casual, business-casual, and even dressier occasions");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 699");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Stretchable Skinny Fit Denim Jeans");
									rate.add(699);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+699;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 3:{
								System.out.println("=============================================================");
								System.out.println("Item :: Womens High Rise Cotton Lycra Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> This lycra jeans are fabricated with top-grade and durable material.");
								System.out.println("--> Made of fabric that holds its shape throughout the day, lets you have no restriction and feel relaxed.");
								System.out.println("--> Quality craftsmanship is at the forefront.");
								System.out.println("--> Designed to offer an energetic look, the denim jeans combine the warmth of comfortable and casual feel.");
								System.out.println("--> Wash & dry inside out. Wash separately.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 499");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								rate.add(499);
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Womens High Rise Cotton Lycra Jeans");
									System.out.println("Added to Cart");
									Totalbill=Totalbill+499;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 4:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Nifty Slim Fit Cotton Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Material: 70.5% cotton, 27.5% poly, 2% spandex.");
								System.out.println("--> Designed for all-day comfort, with just the right amount of stretch");
								System.out.println("--> Suitable for casual, business-casual, and even dressier occasions");
								System.out.println("--> Machine Wash & cold. Wash separately.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 549");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Nifty Slim Fit Cotton Jeans");
									rate.add(549);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+549;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 5:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Nifty Denim Slim Fit High Waist Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Material: 73% Cotton, 25.5% Poly, 1.5% Spandex.");
								System.out.println("--> Designed for all-day comfort, with just the right amount of stretch");
								System.out.println("--> Suitable for casual, business-casual, and even dressier occasions");
								System.out.println("--> Machine Wash & cold. Wash separately.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 649");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Nifty Denim Slim Fit High Waist Jeans");
									rate.add(649);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+649;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 6:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Inkast High Rise Full Length Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Form flattering Jeans that is fitted through the waist and flaring out below the hips.");
								System.out.println("--> Highrise 5 pocket jeans in ankle length ,pocket will be scoop pocket");
								System.out.println("--> Zip fly with button closure ,Material: 100% cotton");
								System.out.println("--> Disclaimer: Product color may slightly vary due to photographic lighting sources.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 699");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Inkast High Rise Full Length Jeans");
									System.out.println("Added to Cart");
									Totalbill=Totalbill+699;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 7:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Inkd Skinny Fit Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Take your style to the next level with the INKD Skinny Fit Jeans.");
								System.out.println("--> These classic mid-rise skinny jeans are specially built for all body types");
								System.out.println("--> Made with high stretch cotton poly spandex fabric -these jeans are durable, lightweight & flexible");
								System.out.println("--> Featuring the classic 5 pocket styling with mid-rise skinny fit.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 649");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Inkd Skinny Fit Jeans");
									rate.add(649);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+649;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 8:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Aka Chic Skinny Fit Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Material Type : Denim Cotton,Elastane, Cotton.");
								System.out.println("--> Zip Fly With 3 Button Closure");
								System.out.println("--> Made with high stretch fabric -these jeans are durable, lightweight & flexible");
								System.out.println("--> Featuring the classic 5 pocket styling with mid-rise skinny fit.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 999");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Aka Chic Skinny Fit Jeans");
									rate.add(999);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+999;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 9:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Adbucks High-Rise Clean Look Joggers");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Fit Type: Straight Jeans.");
								System.out.println("--> Solid Denim Straight Fit High Rise Joggers Button & Zip closure, and 6 pockets.");
								System.out.println("--> Now pair these Straight Fit stylish Jean from Adbucks.");
								System.out.println("--> Occasions like parties, college, functions, office, birthdays, etc.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 899");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Adbucks High-Rise Clean Look Joggers");
									rate.add(899);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+899;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
							case 10:{
								System.out.println("=============================================================");
								System.out.println("Item :: Women's Miss Chase Skinny Fit Jeans");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Fabric: 69% Cotton, 29% Polyester 2% Elastane.");
								System.out.println("--> Pocket: 2 Side Pockets, 2 Back Pockets & 1 Coin Pocket.");
								System.out.println("--> Machine wash cold with like colors, wash inside out, do not tumble dry.");
								System.out.println("--> Occasion: Casual wear, Daily wear, Party wear, Evening wear.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 899");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Women's Adbucks High-Rise Clean Look Joggers");
									rate.add(899);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+899;
									jeansback();
								}
								else {
									jeans();
								}
							}
							break;
					case 11:new WOMEN();
					break;
		       case 12:category();
				break;
		       case 13:cart();
				break;
				case 14:exit();
				break;
				default:
					System.err.println("Invalid Input!! ");
					System.out.println("================================================================");
					System.out.print("Please Enter Correct Input :: ");
					jeansinput();
					break;
					}	
					}
					catch(InputMismatchException e) {
					System.err.println("Invalid Input!! Please Enter Integer not Character");
					System.out.println("=========================================================");
					System.out.print("Enter Again :: ");
					jeansinput();
							}
			}
			
public void jeansback(){
		    	   System.out.println("=============================================================");
		    		System.out.println("");
		    		System.out.println("1 - Jeans Collection"); 
		    	System.out.println("2 - Women Collection");
	    		System.out.println("3 - Home page");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("");
	    		System.out.print("ENTER YOUR CHOICES ::");
	    		 
		    		try{
		    			Scanner sc = new Scanner(System.in);
			    		int subinput=sc.nextInt();
			    		switch(subinput) {
			    		case 1: jeans();
			    		break;
			    		case 2:new WOMEN();
			    		break;
			    		case 3:category();
			    		break;
			    		case 4:cart();
			    		break;
			    		default:
			    			System.err.println("Invalid Input!!");
			    			System.out.println("================================================================");
			    			System.out.print("Please Enter Correct Input :: ");
			    			jeansback();
			    		break;
			    		}
		    		}
		    		catch(InputMismatchException e) {
		    		System.err.println("Invalid Input!! Please Enter Integer not Character");
		    		System.out.println("================================================================");
		    		System.out.print("Enter Again :: ");
		    		jeansback();
		    				}
		        }

//------------------------------------------------Tops Tees

public void tops_tees() {
				System.out.println("");
				 System.out.println("********************************************************************");
	        	System.out.println("Welcome to Tops & Tees Collection");
	       	 System.out.println("********************************************************************");
	        	System.out.println("1.JUNEBERRY® Pure Cotton Oversized Graphic Printed T-Shirt");
	        	System.out.println("2.Berge' Ladies Jacquard Polyester Dry Fit Tshirts");
	        	System.out.println("3.ICW Stretchable Ribbed Knitted Stripe Pullover T-Shirts");
	        	System.out.println("4.Shasmi Solid Knitted Square Neck T-Shirts");
	        	System.out.println("5.Dream Full Sleeve Top Round Neck Casual Tshirt");
	        	System.out.println("6.Fabricorn Stylish Plain Green Long Sleeve Cotton Tshirt");
	        	System.out.println("7.Fabricorn Plain Stylish Cross V-Neck Cotton Tshirt");
	        	System.out.println("8.LEOTUDE Cottonblend Half Sleeve Oversized T-Shirts ");
	        	System.out.println("9.Appulse Women's 3/4 Rollover Sleeve Tshirt");
	        	System.out.println("10.TOPLOT V-Collar Crop Shirt with Short Sleeves");
	        	System.out.println("11.Women Collection");
	        	System.out.println("12.Main Collection");
	        	System.out.println("13.Cart Section");
	        	System.out.println("14.Exit");
System.out.println("********************************************************************");
	        	System.out.print("ENTER YOUR CHOICES :: ");
	        	tops_teesInput();
			}
			
public void tops_teesInput() {
			
				try{
					Scanner sc = new Scanner(System.in);
					var input=sc.nextInt();
					switch(input){
					case 1:{
								System.out.println("=============================================================");
								System.out.println("Item :: Berge' Ladies Jacquard Polyester Dry Fit Tshirts");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> We are presenting a 100% polyester knitted T-shirt.");
								System.out.println("--> Breathable instadry fabric keeps you dry & energetic all day long.");
								System.out.println("--> A unique design & stitching enhances subtle styling.");
								System.out.println("--> Fabric doesn’t loose its shape & colour even after 100 washes.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 349");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Berge' Ladies Jacquard Polyester Dry Fit Tshirts");
									rate.add(349);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+349;
									tops_teesback();
								}
								else {
									tops_tees();
								}
							}
							break;
					case 2:{
						System.out.println("=============================================================");
						System.out.println("Item :: JUNEBERRY® Pure Cotton Oversized Graphic Printed T-Shirt");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Color: Swan White || Fabric: Cotton.");
						System.out.println("--> Trendy Round-Neckline Comfortable For All-Day Wear.");
						System.out.println("--> Back Printed Pattern With Half Sleeves.");
						System.out.println("--> Machine Wash, Hand Wash, Aviod Warm Water & Bleach.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 449");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("JUNEBERRY® Pure Cotton Oversized Graphic Printed T-Shirt");
							rate.add(449);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+449;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 3:{
						System.out.println("=============================================================");
						System.out.println("Item :: ICW Stretchable Ribbed Knitted Stripe Pullover T-Shirts");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> HOLLOW OUT CROCHET SHEER TOP.");
						System.out.println("--> FIT :: LOOSE FIT.");
						System.out.println("--> Neck Style :: Crew Neck.");
						System.out.println("--> Material Type :: SHEER.");
						System.out.println("--> Machine Wash, Hand Wash, Aviod Warm Water & Bleach.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 499");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("ICW Stretchable Ribbed Knitted Stripe Pullover T-Shirts");
							rate.add(499);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+499;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 4:{
						System.out.println("=============================================================");
						System.out.println("Item :: Shasmi Solid Knitted Square Neck T-Shirts");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Material: 93% Microfiber, 7% Spandex (Lycra).");
						System.out.println("--> Pattern: Solid Stripe.");
						System.out.println("--> Neck: Square Neck, Sleeve: Short Puff Sleeve.");
						System.out.println("--> Collar: Collarless, Closure: Pull On.");
						System.out.println("--> Machine Wash, Hand Wash, Aviod Warm Water & Bleach.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 379");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Shasmi Solid Knitted Square Neck T-Shirts");
							rate.add(379);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+379;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 5:{
						System.out.println("=============================================================");
						System.out.println("Item :: Dream Full Sleeve Top Round Neck Casual Tshirt");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Material : Polyester Blend.");
						System.out.println("--> Fit Type: Slim Fit / Perfect for lounge.");
						System.out.println("--> Machine Wash, Hand Wash, Aviod Warm Water & Bleach.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 299");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Dream Full Sleeve Top Round Neck Casual Tshirt");
							rate.add(299);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+299;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 6:{
						System.out.println("=============================================================");
						System.out.println("Item :: Fabricorn Stylish Plain Green Long Sleeve Cotton Tshirt");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Quality:Fleece Premium Quality.");
						System.out.println("--> Sleeve: Full Sleeve sweatshirt.");
						System.out.println("--> Neck Type: Collar Neck Sweatshirt.");
						System.out.println("--> Best for Winter Wear.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 399");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Fabricorn Stylish Plain Green Long Sleeve Cotton Tshirt");
							rate.add(399);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+399;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 7:{
						System.out.println("=============================================================");
						System.out.println("Item :: Fabricorn Plain Stylish Cross V-Neck Cotton Tshirt");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Fabric Type: Cotton || Pattern Name: Solid.");
						System.out.println("--> Closure Type: Pull On.");
						System.out.println("--> Sleeve Type: Short Sleeve.");
						System.out.println("--> Occasion Type: Casual.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 399");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Fabricorn Plain Stylish Cross V-Neck Cotton Tshirt");
							rate.add(399);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+399;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 8:{
						System.out.println("=============================================================");
						System.out.println("Item :: LEOTUDE Cottonblend Half Sleeve Oversized T-Shirts");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Sleeve Type: Half Sleeve.");
						System.out.println("--> Pattern : Printed.");
						System.out.println("--> Neck Style: Round.");
						System.out.println("--> Occasion Type: Casual.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 299");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("LEOTUDE Cottonblend Half Sleeve Oversized T-Shirts ");
							rate.add(299);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+299;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 9:{
						System.out.println("=============================================================");
						System.out.println("Item :: Appulse Women's 3/4 Rollover Sleeve Tshirt");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Material :: 100% Premium Cotton.");
						System.out.println("--> Sleeves :: 3/4 Rollover Sleeves.");
						System.out.println("--> Fit  :: Smart Fit.");
						System.out.println("--> Occasion Type: Sports wear.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 349");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Appulse Women's 3/4 Rollover Sleeve Tshirt");
							rate.add(349);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+349;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
					case 10:{
						System.out.println("=============================================================");
						System.out.println("Item :: TOPLOT V-Collar Crop Shirt with Short Sleeves");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Fabric : Polycotton.");
						System.out.println("--> Sleeve : Short Sleeve.");
						System.out.println("--> Pattern : Geometric Printed Crop Shirt.");
						System.out.println("--> Occasion: Casual, Party, Dayout, Nightout.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 349");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("TOPLOT V-Collar Crop Shirt with Short Sleeves");
							rate.add(349);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+349;
							tops_teesback();
						}
						else {
							tops_tees();
						}
					}
					break;
				case 11:new WOMEN();
				break;
	       case 12:category();
			break;
	       case 13:cart();
			break;
			case 14:exit();
			break;			
			default:
				System.err.println("Invalid Input!! Please Enter Correct Input");
				System.out.println("================================================================");
				tops_teesInput();
				break;
				}
				}
				catch(InputMismatchException e) {
				System.err.println("Invalid Input!! Please Enter Integer not Character");
				System.out.print("Enter Again :: ");
				tops_teesInput();
						}
			}
			
public void tops_teesback(){
		    	   System.out.println("=============================================================");
		    		System.out.println("");
		    		System.out.println("1 - Tops & Tees Collection");
		    		System.out.println("2 - Women Collection");
		    		System.out.println("3 - Home page");
		    		System.out.println("4 - Card Section");
		    		System.out.println("=========================================================");
		    		System.out.println("");
		    		System.out.print("ENTER YOUR CHOICES ::");
		    	
		    		try{
		    			Scanner sc = new Scanner(System.in);
			    		int subinput=sc.nextInt();
			    		switch(subinput) {
			    		case 1: tops_tees();
			    		break;
			    		case 2:new WOMEN();
			    		break;
			    		case 3:category();
			    		break;
			    		case 4:cart();
			    		break;
			    		default:
			    			System.err.println("Invalid Input!!");
			    			System.out.println("================================================================");
							System.out.print("Please Enter Correct Input :: ");
			    			tops_teesback();
			    		break;
			    		}
		    		}
		    		catch(InputMismatchException e) {
		    		System.err.println("Invalid Input!! Please Enter Integer not Character");
		    		System.out.println("=========================================================");
		    		System.out.print("Enter Again :: ");
		    		tops_teesback();
		    				}
		        }

//---------------------------------------------------Kurti Section
			
public void kurta() {
				System.out.println("");
				 System.out.println("********************************************************************");
				 System.out.println("Welcome to Kurti Collection");
				 System.out.println("********************************************************************");
	        	System.out.println("2.IdaLia Straight Cotton Kurti with Palazzo Pant Set");
	        	System.out.println("3.GoSriKi Rayon Floral Printed Straight Kurti with Pants & Dupatta");
	        	System.out.println("4.MEERA FAB Cotton Printed Anarkali Kurti With Palazzo & Dupatta Set");
	        	System.out.println("5.KLOSIA Printed Kurti and Pant Set with Dupatta");
	        	System.out.println("6.Rytras Cotton Printed Straight Kurti and Pant Set");
	        	System.out.println("7.ANNI DESIGNER Blend Printed Straight Kurti with Pant");
	        	System.out.println("8.Arayna Floral Printed Pure Cotton Kurti Palazzo Pants Set ");
	        	System.out.println("9.Vaamsi Cotton Blend Paisley Printed Straight Kurti Pant");
	        	System.out.println("10.Lymio Kurta Pant Set Women Kurti Set with Pant");
	        	System.out.println("11.Women Collection");
	        	System.out.println("12.Main Collection");
	        	System.out.println("13.Cart Section");
	        	System.out.println("14.Exit");
	       	 System.out.println("********************************************************************");
	       	 System.out.println("");
	        	System.out.println("ENTER YOUR CHOICES :: ");
	        	kurtaInput();
			}
			
public void kurtaInput() {
			
				try{
					Scanner sc = new Scanner(System.in);
					var input=sc.nextInt();
					switch(input){
					case 1:{
								System.out.println("=============================================================");
								System.out.println("Item :: Brownverse Off White Cotton Embroidered Kurti and Pant Set");
								System.out.println("=============================================================");
								System.out.println("About this item ::");
								System.out.println("--> Color : Off White || Top Fabric : Cotton || Top Length :Calf Length Sleeves :3/4 Sleeve .");
								System.out.println("--> A Gracefully Designed Contemporary Collection of Clothing for You to Wear on a Special Occasion.");
								System.out.println("--> We Create the Product by Listening to and Understanding Your Needs.");
								System.out.println("--> The Suit Gives a Modern Touch to Traditional Indian Attire.");
								System.out.println("=========================================================");
								System.out.println("Price :: RS 949");
								System.out.println("=========================================================");
								System.out.println("Do You want byu!!");
								System.out.println("If Yes Press (Y) else press any character to go back");
								char byu=sc.next().charAt(0);
								if(byu == 'Y' || byu== 'y') {
									condition();
									cart.add("Brownverse Off White Cotton Embroidered Kurti and Pant Set");
									rate.add(949);
									System.out.println("Added to Cart");
									Totalbill=Totalbill+949;
									kurtaBack();
								}
								else {
									kurta();
								}
							}
							break;
					case 2:{
						System.out.println("=============================================================");
						System.out.println("Item :: IdaLia Straight Cotton Kurti with Palazzo Pant Set");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> This ethnic kurta set features a cotton slub top and bottom, ensuring a soft and breathable feel.");
						System.out.println("--> Solid top and printed palazzo pant, this set is suitable for both festive and party events.");
						System.out.println("--> The 3/4 sleeve pattern and calf-length kurta make it an ideal choice for festival kurta sets.");
						System.out.println("--> Great for those seeking designer kurta sets that are both stylish and comfortable for festive occasions.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 899");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("IdaLia Straight Cotton Kurti with Palazzo Pant Set");
							rate.add(899);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+899;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 3:{
						System.out.println("=============================================================");
						System.out.println("Item :: GoSriKi Rayon Floral Printed Straight Kurti with Pants & Dupatta");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Kurta Set Fabric: Rayon || Kurta Set Color :- Maroon.");
						System.out.println("--> Style: Straight || Length: Calf Length || Sleeves: 3/4 Sleeves.");
						System.out.println("--> Work : Printed || Neck Style:- Round Neck.");
						System.out.println("--> Ocassion: Traditional wear, Casual Wear, party wear, evening wear.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 699");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("GoSriKi Rayon Floral Printed Straight Kurti with Pants & Dupatta");
							rate.add(699);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+699;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 4:{
						System.out.println("=============================================================");
						System.out.println("Item :: MEERA FAB Cotton Printed Anarkali Kurti With Palazzo & Dupatta Set");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Kurta Set Fabric: Rayon || Kurta Set Color :- Maroon.");
						System.out.println("--> Style: Straight || Length: Calf Length || Sleeves: 3/4 Sleeves.");
						System.out.println("--> Work : Printed || Neck Style:- Round Neck.");
						System.out.println("--> Ocassion: Traditional wear, Casual Wear, party wear, evening wear.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 699");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("MEERA FAB Cotton Printed Anarkali Kurti With Palazzo & Dupatta Set");
							rate.add(699);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+699;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 5:{
						System.out.println("=============================================================");
						System.out.println("Item :: KLOSIA Printed Kurti and Pant Set with Dupatta");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Fit Type: Straight; Salwar Suits : Straight Kurta Pant and printed Dupatta Set.");
						System.out.println("--> Product Material :- Viscose || Colour :- Rust & Black || Pattern :- Floral Printed.");
						System.out.println("--> Style :- Straight Kurta || Sleeve Length :- 3/4 Sleeve || Bottom :- Pant.");
						System.out.println("--> Occasion :- Casual ,Office wear ,Party ,Wedding , Ragular & Festive.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 699");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("KLOSIA Printed Kurti and Pant Set with Dupatta");
							rate.add(699);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+699;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 6:{
						System.out.println("=============================================================");
						System.out.println("Item :: Rytras Cotton Printed Straight Kurti and Pant Set");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Fabric Kurta :- Cotton & Pant - Cotton.");
						System.out.println("--> Sleeve:- Sleeveless ; Neck Style:- V-Neck.");
						System.out.println("--> Occasion :- Casual ,Office wear ,Party ,Wedding , Ragular & Festive.");
						System.out.println("--> Wash Care: Machine Wash.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 499");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Rytras Cotton Printed Straight Kurti and Pant Set");
							rate.add(499);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+499;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 7:{
						System.out.println("=============================================================");
						System.out.println("Item :: ANNI DESIGNER Blend Printed Straight Kurti with Pant");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Kurta and Bottom Fabric: Cotton Blend || Kurta Set Color :- Blue.");
						System.out.println("--> Style: Straight || Length: Calf Length || Sleeves: 3/4 Sleeves.");
						System.out.println("--> Work : Printed || Neck Style:- Round Neck.");
						System.out.println("--> Ocassion: Traditional wear, Casual Wear, party wear, evening wear.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 449");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("ANNI DESIGNER Blend Printed Straight Kurti with Pant");
							rate.add(449);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+449;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 8:{
						System.out.println("=============================================================");
						System.out.println("Item :: Arayna Floral Printed Pure Cotton Kurti Palazzo Pants Set");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Kurta & Palazzo Fabric: 100% Cotton, Dupatta Fabric: 100% Muslin.");
						System.out.println("--> Style: Straight Kurta with Palazzo Pants and Dupatta.");
						System.out.println("--> Design: Printed.");
						System.out.println("--> Wash Care: Hand Wash with Normal Water, Do not Bleach.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 849");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Arayna Floral Printed Pure Cotton Kurti Palazzo Pants Set");
							rate.add(849);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+849;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 9:{
						System.out.println("=============================================================");
						System.out.println("Item :: Vaamsi Cotton Blend Paisley Printed Straight Kurti Pant");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Kurta Color- Black, Pant Color- Beige, Dupatta Color- Beige.");
						System.out.println("--> Kurta Fabric- Cotton Blend, Pant Fabric- Cotton Blend.");
						System.out.println("--> Kurta Work- Printed, Pant Work- Printed, Work Type- Paisley.");
						System.out.println("--> Wash Care: Hand Wash with Normal Water, Do not Bleach.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 549");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Vaamsi Cotton Blend Paisley Printed Straight Kurti Pant");
							rate.add(549);
							System.out.println("Added to Cart");
							Totalbill=Totalbill+549;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;
					case 10:{
						System.out.println("=============================================================");
						System.out.println("Item :: Lymio Kurta Pant Set Women Kurti Set with Pant");
						System.out.println("=============================================================");
						System.out.println("About this item ::");
						System.out.println("--> Kurta Color- Sky Blue, Pant Color- White, Dupatta Color- White.");
						System.out.println("--> Kurta Set Fabric: Cotton Bland.");
						System.out.println("--> Ocassion: Traditional wear, Casual Wear, party wear, evening wear.");
						System.out.println("--> Wash Care: Hand Wash with Normal Water, Do not Bleach.");
						System.out.println("=========================================================");
						System.out.println("Price :: RS 499");
						System.out.println("=========================================================");
						System.out.println("Do You want byu!!");
						System.out.println("If Yes Press (Y) else press any character to go back");
						char byu=sc.next().charAt(0);
						if(byu == 'Y' || byu== 'y') {
							condition();
							cart.add("Lymio Kurta Pant Set Women Kurti Set with Pant");
							System.out.println("Added to Cart");
							rate.add(499);
							Totalbill=Totalbill+499;
							kurtaBack();
						}
						else {
							kurta();
						}
					}
					break;	
					case 11:new WOMEN();
					break;
		       case 12:category();
				break;
		       case 13:cart();
				break;
				case 14:exit();
				break;
				default:
					System.err.println("Invalid Input!! Please Enter Correct Input");
					System.out.println("================================================================");
					kurtaInput();
					break;
					}
				}
				catch(InputMismatchException e) {
				System.err.println("Invalid Input!! Please Enter Integer not Character");
				System.out.print("Enter Again :: ");
				kurtaInput();
						}
			}
			
public void kurtaBack(){
		    	  
		    		try{
		    			 System.out.println("=============================================================");
				    		System.out.println("");
				    		System.out.println("Press 1 for Kurti Collection");
				    		System.out.println("Press 2 for Women Collection");
				    		System.out.println("Press 3 for Main Collection");
				    		System.out.println("Press 4 for Card Section");
				    		System.out.println("=========================================================");
				    		System.out.println("ENTER YOUR CHOICES :: ");
				    		Scanner sc = new Scanner(System.in);
				    		int subinput=sc.nextInt();
				    		switch(subinput) {
				    		case 1: kurta();
				    		break;
				    		case 2:new WOMEN();
				    		break;
				    		case 3:category();
				    		break;
				    		case 4:cart();
				    		break;
				    		default:
				    			System.err.println("Invalid Input!!");
				    			System.out.println("================================================================");
							System.out.print("Please Enter Correct Input :: ");
				    			kurtaBack();
				    		break;
				    		}
		    		}
		    		catch(InputMismatchException e) {
		    		System.err.println("Invalid Input!! Please Enter Integer not Character");
		    		System.out.println("=========================================================");
		    		System.out.print("Enter Again :: ");
		    		kurtaBack();
		    				}
}
			//Class Closed
}
class Shoes extends FashionStree
{
//	Non-Static Block
	{
		System.out.println("");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("                    Welcome To Shoes Collections                  ");
	    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("");
			System.out.println("1 - Mens Shoes");
			System.out.println("2 - Womens Shoes");
			System.out.println("3 - Main Collection");
			System.out.println("4 - Cart Section");
			System.out.println("5 - Exit");
			System.out.println("=========================================================");
			System.out.println("");
			System.out.print("ENTER YOUR CHOICES :: ");
			InputSubCategory();
	}

	public void InputSubCategory() {

		try{
			Scanner sc = new Scanner(System.in);
			var input=sc.nextInt();
			switch(input){
				case 1:	MensShoes();
				break;
				case 2: WomensShoes();
				break;
				case 3:category();
				break;
				case 4:cart();
				break;
				case 5:exit();
				break;
				default :
					System.err.println("Invalid Input!!");
					System.out.println("=========================================================");
					System.out.println(" Please Enter Correct Input :: " );
					InputSubCategory();
					break;
			}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		InputSubCategory();
				}
				
		}

//-------------------------------------------Mens Shoes Section
	public void MensShoes() {
		System.out.println("");
		 System.out.println("********************************************************************");
		 System.out.println("Welcome to Mens Shoes Collection");
		 System.out.println("********************************************************************");
   	System.out.println("1.PUMA Mens Ferrari Future Cat Ultra Shoes");
   	System.out.println("2.CAMPUS Mens Round-Toe Lace-Up Running Shoes");
   	System.out.println("3.LOUIS STITCH Men Genuine Leather Formal Shoes");
   	System.out.println("4.NIKE Revolution 6 Flyease Running Shoes");
   	System.out.println("5.ALLEN COOPER Men Knitted Slip-On Running Shoes");
   	System.out.println("6.ADIDAS Adivat Running Shoes");
   	System.out.println("7.RED TAPE Lace Fastening Flat Heels Oxfords ");
   	System.out.println("8.CLARKS Square-Toe Low-Top Loafers");
   	System.out.println("9.ID Broguing Lace-Up Formal Shoes");
  	System.out.println("10.ARBUNORE Lace-Up Shoes with Velcro Fastening");
   	System.out.println("11.Shoes Collection");
   	System.out.println("12.Main Collection");
   	System.out.println("13.Cart Section");
   	System.out.println("14.Exit");
  	 System.out.println("********************************************************************");
  	 System.out.println("");
   	System.out.println("ENTER YOUR CHOICES :: ");
   	MensShoesInput();
		
	}

	public void MensShoesInput() {

		try {
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			switch(input) {
			case 1:{
				System.out.println("=============================================================");
				System.out.println("Item :: PUMA Mens Ferrari Future Cat Ultra Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: White ");
				System.out.println("--> Men's Sports Shoes");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Mesh upper .");
				System.out.println("--> Memory foam insole");
			    System.out.println("--> TPR sole.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("PUMA Mens Ferrari Future Cat Ultra Shoes");
					rate.add(999);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+999;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 2:{
				System.out.println("=============================================================");
				System.out.println("Item :: CAMPUS Mens Round-Toe Lace-Up Running Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black");
				System.out.println("--> Men's Casual Shoes");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Narrow Fit .");
			    System.out.println("--> Rubber sole.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1800");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("CAMPUS Mens Round-Toe Lace-Up Running Shoes");
					rate.add(1800);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1800;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 3:{
				System.out.println("=============================================================");
				System.out.println("Item :: LOUIS STITCH Men Genuine Leather Formal Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Brown");
				System.out.println("--> Men's Leather Formal Shoes");
				System.out.println("--> Genuine leather upper.");
				System.out.println("--> Leather sole.");
				System.out.println("--> Leather insole.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("LOUIS STITCH Men Genuine Leather Formal Shoes");
					rate.add(1999);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1999;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 4:{
				System.out.println("=============================================================");
				System.out.println("Item :: NIKE Revolution 6 Flyease Running Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black");
				System.out.println("--> Men's Running Shoes");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Synthetic rubber sole.");
				System.out.println("--> Lace Fastening.");
				System.out.println("--> Mesh upper");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("NIKE Revolution 6 Flyease Running Shoes");
					rate.add(1999);
					System.out.println("");
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1999;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 5:{
				System.out.println("=============================================================");
				System.out.println("Item :: ALLEN COOPER Men Knitted Slip-On Running Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Grey");
				System.out.println("--> Men's Running Shoes");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Slip-on Styling.");
				System.out.println("--> EVA sole.");
				System.out.println("--> Mesh upper");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1449");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("ALLEN COOPER Men Knitted Slip-On Running Shoes");
					rate.add(1449);
					System.out.println("");
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1449;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 6:{
				System.out.println("=============================================================");
				System.out.println("Item :: ADIDAS Adivat Running Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Blue");
				System.out.println("--> Men's Running Shoes");
				System.out.println("--> Avoid contact with water.");
				System.out.println("--> Lace Fastening.");
				System.out.println("--> EVA sole.");
				System.out.println("--> PU and textile upper");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1199");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("ADIDAS Adivat Running Shoes");
					rate.add(1199);
					System.out.println("");
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1199;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 7:{
				System.out.println("=============================================================");
				System.out.println("Item :: RED TAPE Lace Fastening Flat Heels Oxfords ");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Blue");
				System.out.println("--> Men's Formal Shoes");
				System.out.println("--> Avoid contact with water.");
				System.out.println("--> Lace Fastening.");
				System.out.println("--> TPR sole.");
				System.out.println("--> Genuine leather upper");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1899");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("RED TAPE Lace Fastening Flat Heels Oxfords ");
					rate.add(1899);
					System.out.println("");
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1899;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 8:{
				System.out.println("=============================================================");
				System.out.println("Item :: CLARKS Square-Toe Low-Top Loafers ");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Blue");
				System.out.println("--> Men's Formal Shoes");
				System.out.println("--> Slip-on Styling.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Leather upper.");
				System.out.println("--> TPR sole");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 2999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("CLARKS Square-Toe Low-Top Loafers");
					rate.add(2999);
					System.out.println("");
					System.out.println("Added to Cart");
					Totalbill=Totalbill+2999;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 9:{
				System.out.println("=============================================================");
				System.out.println("Item :: ID Broguing Lace-Up Formal Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black");
				System.out.println("--> Men's Formal Shoes");
				System.out.println("--> Man made leather.");
				System.out.println("--> Genuine leather upper.");
				System.out.println("--> Rubber sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1499");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("ID Broguing Lace-Up Formal Shoes");
					rate.add(1499);
					System.out.println("");
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1499;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			case 10:{
				System.out.println("=============================================================");
				System.out.println("Item :: ARBUNORE Lace-Up Shoes with Velcro Fastening");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Grey");
				System.out.println("--> Men's Casual Shoes");
				System.out.println("--> Lace Fastening.");
				System.out.println("--> Mesh upper.");
				System.out.println("--> Rubber sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1299");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("ARBUNORE Lace-Up Shoes with Velcro Fastening");
					rate.add(1299);
					System.out.println("");
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1299;
					MensShoesBack();
				}
				else {
					MensShoes();
				}
			}
			break;
			
	case 11:new Shoes();
	break;
	case 12:category();
	break;
	case 13:cart();
	break;
	case 14:exit();
	break;
	default:
		System.err.println("Invalid Input!! Please Enter Correct Input");
		System.out.println("================================================================");
		MensShoesInput();
		break;
			}
		}
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer not Character");
			System.out.print("Enter Again :: ");
			MensShoesInput();
					}
		}

	public void MensShoesBack() {
		try{
			 System.out.println("=============================================================");
	    		System.out.println("");
	    		System.out.println("1 - Mens Shoes Collection");
	    		System.out.println("2 - Shoes Collection");
	    		System.out.println("3 - Main Collection");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("ENTER YOUR CHOICES :: ");
	    		Scanner sc = new Scanner(System.in);
	    		int subinput=sc.nextInt();
	    		switch(subinput) {
	    		case 1: MensShoes();
	    		break;
	    		case 2:new Shoes();
	    		break;
	    		case 3:category();
	    		break;
	    		case 4:cart();
	    		break;
	    		default:
	    			System.err.println("Invalid Input!!");
	    			System.out.println("================================================================");
				System.out.print("Please Enter Correct Input :: ");
				MensShoesBack();
	    		break;
	    		}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		MensShoesBack();
				}
		
	}

	//-------------------------------------------Womens Shoes Section
	public void WomensShoes() {
	System.out.println("");
	System.out.println("********************************************************************");
	System.out.println("Welcome to Womens Shoes Collection");
    System.out.println("********************************************************************");
  	System.out.println("1.ASICS Japan S ST Women Sneakers");
  	System.out.println("2.PUMA Women Dynamite Slip-On Sneakers");
  	System.out.println("3.NIKE Womens Court Vision Low-Top Sneakers");
  	System.out.println("4.STEVE MADDEN Women's Tianna Paris Mid Bootie");
  	System.out.println("5.STEVE MADDEN Women'sTutuu Chunky Heeled Shoes");
  	System.out.println("6.PUMA Women Round-Toe Lace-Up Casual Shoes");
  	System.out.println("7.PUMA Women Better Foam Prowl Slip-On Running Shoes");
  	System.out.println("8.RED TAPE Women's Mid-Tops Lace-Up Sneakers");
  	System.out.println("9.CLARKS Women Slip-On Knee-Length Boots");
 	System.out.println("10.ALDO Pumps Heeled Shoes");
  	System.out.println("11.Shoes Collection");
  	System.out.println("12.Main Collection");
  	System.out.println("13.Cart Section");
  	System.out.println("14.Exit");
 	System.out.println("********************************************************************");
 	System.out.println("");
  	System.out.println("ENTER YOUR CHOICES :: ");
  	WomensShoesInput();
		
	}

	public void WomensShoesInput() {

		try {
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			switch(input) {
			case 1:{
				System.out.println("=============================================================");
				System.out.println("Item :: ASICS Japan S ST Women Sneakers");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Beige ");
				System.out.println("--> Women's Casual Shoes");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Synthetic upper.");
				System.out.println("--> Rubber sole.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("ASICS Japan S ST Women Sneakers");
					rate.add(1999);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1999;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 2:{
				System.out.println("=============================================================");
				System.out.println("Item :: PUMA Women Dynamite Slip-On Sneakers");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Purple ");
				System.out.println("--> Women's Casual Shoes");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Fabric upper");
				System.out.println("--> Fabric insole.");
				System.out.println("--> Rubber sole.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1799");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("PUMA Women Dynamite Slip-On Sneakers");
					rate.add(1799);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1799;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 3:{
				System.out.println("=============================================================");
				System.out.println("Item :: NIKE Womens Court Vision Low-Top Sneakers");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Purple ");
				System.out.println("--> Women's Casual Shoes");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("--> Fabric upper");
				System.out.println("--> Fabric insole.");
				System.out.println("--> Rubber sole.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1799");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("NIKE Womens Court Vision Low-Top Sneakers");
					rate.add(1799);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1799;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 4:{
				System.out.println("=============================================================");
				System.out.println("Item :: STEVE MADDEN Women's Tianna Paris Mid Bootie");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black ");
				System.out.println("--> Women's Boots");
				System.out.println("--> PU upper");
				System.out.println("--> Rubber sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1499");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("STEVE MADDEN Women's Tianna Paris Mid Bootie");
					rate.add(1499);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1499;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 5:{
				System.out.println("=============================================================");
				System.out.println("Item :: STEVE MADDEN Women'sTutuu Chunky Heeled Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black ");
				System.out.println("--> Women's Heeled Shoes");
				System.out.println("--> Heel height: 2 inches");
				System.out.println("--> PU upper");
				System.out.println("--> Rubber sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1499");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("STEVE MADDEN Women'sTutuu Chunky Heeled Shoes");
					rate.add(1499);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1499;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 6:{
				System.out.println("=============================================================");
				System.out.println("Item :: PUMA Women Round-Toe Lace-Up Casual Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black ");
				System.out.println("--> Women's Casual Shoes");
				System.out.println("--> Synthetic upper");
				System.out.println("--> Fabric insole");
				System.out.println("--> Rubber sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("PUMA Women Round-Toe Lace-Up Casual Shoes");
					rate.add(1999);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1999;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 7:{
				System.out.println("=============================================================");
				System.out.println("Item :: PUMA Women Better Foam Prowl Slip-On Running Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black ");
				System.out.println("--> Women's Sports Shoes");
				System.out.println("--> Fabric upper");
				System.out.println("--> Rubber sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("PUMA Women Better Foam Prowl Slip-On Running Shoes");
					rate.add(999);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+999;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 8:{
				System.out.println("=============================================================");
				System.out.println("Item :: RED TAPE Women's Mid-Tops Lace-Up Sneakers");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Beige ");
				System.out.println("--> Women's Sneakers");
				System.out.println("--> Lace Fastening");
				System.out.println("--> PU upper");
				System.out.println("--> TPR sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1499");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("RED TAPE Women's Mid-Tops Lace-Up Sneakers");
					rate.add(1499);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1499;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 9:{
				System.out.println("=============================================================");
				System.out.println("Item :: CLARKS Women Slip-On Knee-Length Boots");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Black ");
				System.out.println("--> Women's Boots");
				System.out.println("--> Heel height: 1.18 inches");
				System.out.println("--> Genuine leather upper");
				System.out.println("--> PU upper");
				System.out.println("--> TPR sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 3999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("CLARKS Women Slip-On Knee-Length Boots");
					rate.add(3999);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+3999;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			case 10:{
				System.out.println("=============================================================");
				System.out.println("Item :: ALDO Pumps Heeled Shoes");
				System.out.println("=============================================================");
				System.out.println("Product Details ::");
				System.out.println("--> Colour :: Beige ");
				System.out.println("--> Women's Heeled Shoes");
				System.out.println("--> Heel height: 1.18 inches");
				System.out.println("--> Synthetic upper");
				System.out.println("--> Rubber sole.");
				System.out.println("--> Wipe with a clean, dry cloth when needed.");
				System.out.println("=========================================================");
				System.out.println("Price :: RS 1999");
				System.out.println("=========================================================");
				System.out.println("Do You want byu!!");
				System.out.println("If Yes Press (Y) else press any character to go back");
				char byu=sc.next().charAt(0);
				if(byu == 'Y' || byu== 'y') {
					condition();
					cart.add("ALDO Pumps Heeled Shoes");
					rate.add(1999);
					System.out.println("Added to Cart");
					Totalbill=Totalbill+1999;
					WomensShoesBack();
				}
				else {
					WomensShoes();
				}
			}
			break;
			
			case 11:new Shoes();
			break;
			case 12:category();
			break;
			case 13:cart();
			break;
			case 14:exit();
			break;
			default:
				System.err.println("Invalid Input!! Please Enter Correct Input");
				System.out.println("================================================================");
				MensShoesInput();
				break;
			}
		}
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer not Character");
			System.out.println("=========================================================");
			System.out.print("Enter Again :: ");
			MensShoesInput();
					}	
	}

	public void WomensShoesBack() {
		try{
			 System.out.println("=============================================================");
	    		System.out.println("");
	    		System.out.println("1 - Mens Shoes Collection");
	    		System.out.println("2 - Shoes Collection");
	    		System.out.println("3 - Main Collection");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("ENTER YOUR CHOICES :: ");
	    		Scanner sc = new Scanner(System.in);
	    		int subinput=sc.nextInt();
	    		switch(subinput) {
	    		case 1: WomensShoes();
	    		break;
	    		case 2:new Shoes();
	    		break;
	    		case 3:category();
	    		break;
	    		case 4:cart();
	    		break;
	    		default:
	    			System.err.println("Invalid Input!!");
	    			System.out.println("================================================================");
				System.out.print("Please Enter Correct Input :: ");
				WomensShoesBack();
	    		break;
	    		}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		WomensShoesBack();
				}		
	}
	
//	Class Closed
}


	class Asscessories extends FashionStree
	{
		
		Asscessories(){
		System.out.println("");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("                    Welcome To Asscessories Collections                  ");
	    System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("");
			System.out.println("1 - Watches Collection");
			System.out.println("2 - Sunglasses Collection");
			System.out.println("3 - Belts Collection");
			System.out.println("4 - Main Collection");
			System.out.println("5 - Cart Section");
			System.out.println("6 - Exit");
			System.out.println("=========================================================");
			System.out.println("");
			System.out.print("ENTER YOUR CHOICES :: ");
			inputsubcatergory();
	}
	
	public void inputsubcatergory() {
		try {
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			switch(input) {
			case 1: watches();
			break;
			case 2: sunglasses_frames();
			break;
			case 3: Belts();
			break;
			case 4: category();
			break;
			case  5: cart();
			break;
			case 6: exit();
			break;
			default : 
				System.out.println("Invalid Input !!!");
				System.out.println("Enter CORRECT CHOICES :: ");
				inputsubcatergory();
			}
		}
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer not Character");
			System.out.println("=========================================================");
			System.out.print("Enter Again :: ");
			inputsubcatergory();
					}	
	}
	
	
//  -----------------------------------------------Watches Section

	
	static ArrayList watches=new ArrayList();
	
	public void watches() {
		watches.clear();
		System.out.println("");
		System.out.println("********************************************************************");
		System.out.println("Welcome to Watches Collection");
	    System.out.println("********************************************************************");
		watches.add("CASIO Vintage Unisex Digital Wrist Watch");
		watches.add("SWISS DESIGN Women Analogue Wrist Watch");
		watches.add("FASTRACK Women Pink Dial Metal Mesh Strap Watch");
		watches.add("TITAN Women Silver Stainless Steel Strap Watch");
		watches.add("GUESS Analogue Watch with Silicone Strap Watch");
		watches.add("SKYLONA Analogue Watch with Deployant Clasp");
		watches.add("REDUX Analogue Watch with Metallic Strap");
		watches.add("Asscessories Collection");
		watches.add("Main Collection");
		watches.add("Cart Section");
		watches.add("Exit");
//		System.out.println(watches);
		for (int i = 0; i < watches.size(); i++) 
		{
			 System.out.print(01+i+".");
			 System.out.println(watches.get(i));
		}
	 	System.out.println("********************************************************************");
	 	System.out.println("");
	  	System.out.print("ENTER YOUR CHOICES :: ");
	  	watchesInput();
	}
	
	public void watchesInput() {
		try {
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			ArrayList WatchesInput=new ArrayList();
	        ArrayList WatchesRate=new ArrayList();
	        WatchesInput.add("=============================================================\r\n"
					+ "Item :: CASIO Vintage Unisex Digital Wrist Watch\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Colour :: Rose Gold\r\n"
					+ "--> Metal strap\r\n"
					+ "--> Water-resistant.\r\n"
					+ "--> Clean the dial with a cotton cloth\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 1499\r\n"
					+ "=========================================================");
	        WatchesRate.add(1499);
	        WatchesInput.add("=============================================================\r\n"
					+ "Item :: SWISS DESIGN Women Analogue Wrist Watch\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Martial :: Metal \r\n"
					+ "--> Colour :: Blue\r\n"
					+ "--> Scratch resistance: No\r\n"
					+ "--> Water-resistant.\r\n"
					+ "--> Clean the dial with a cotton cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 499\r\n"
					+ "=========================================================");
	        WatchesRate.add(499);
	        WatchesInput.add("=============================================================\r\n"
					+ "Item :: FASTRACK Women Pink Dial Metal Mesh Strap Watch\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Movement: quartz\r\n"
					+ "--> Stainless Steel\r\n"
					+ "--> Water-resistant.\r\n"
					+ "--> Clean the dial with a cotton cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 1399\r\n"
					+ "=========================================================");
	        WatchesRate.add(1399);
	        WatchesInput.add("=============================================================\r\n"
					+ "Item :: TITAN Women Silver Stainless Steel Strap Watch\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Movement: quartz\r\n"
					+ "--> Stainless Steel\r\n"
					+ "--> Water-resistant.\r\n"
					+ "--> Clean the dial with a cotton cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 1199\r\n"
					+ "=========================================================");
	        WatchesRate.add(1199);
	        WatchesInput.add("=============================================================\r\n"
	  					+ "Item :: GUESS Analogue Watch with Silicone Strap Watchr\n"
	  					+ "=============================================================\r\n"
	  					+ "Product Details ::\r\n"
	  					+ "--> Silicone\r\n"
	  					+ "--> Textured bezel\r\n"
	  					+ "--> Textured bezel.\r\n"
	  					+ "--> Clean the dial with a cotton cloth.\r\n"
	  					+ "=========================================================\r\n"
	  					+ "Price :: RS 1499\r\n"
	  					+ "=========================================================");
	  	        WatchesRate.add(1499);
	  	      WatchesInput.add("=============================================================\r\n"
	  					+ "Item :: SKYLONA Analogue Watch with Deployant Clasp\r\n"
	  					+ "=============================================================\r\n"
	  					+ "Product Details ::\r\n"
	  					+ "--> Stainless Steel\r\n"
	  					+ "--> Deployant Clasp\r\n"
	  					+ "--> Water-resistant.\r\n"
	  					+ "--> Clean the dial with a cotton cloth.\r\n"
	  					+ "=========================================================\r\n"
	  					+ "Price :: RS 999\r\n"
	  					+ "=========================================================");
	  	        WatchesRate.add(999);
	  	      WatchesInput.add("=============================================================\r\n"
	  					+ "Item :: REDUX Analogue Watch with Metallic Strap\r\n"
	  					+ "=============================================================\r\n"
	  					+ "Product Details ::\r\n"
	  					+ "--> Stainless Steel\r\n"
	  					+ "--> Metallic Strap\r\n"
	  					+ "--> Water-resistant.\r\n"
	  					+ "--> Clean the dial with a cotton cloth.\r\n"
	  					+ "=========================================================\r\n"
	  					+ "Price :: RS 1999\r\n"
	  					+ "=========================================================");
	  	        WatchesRate.add(1999);
	
	  	      if(input>0 && input<8) {
	            	input=input-1;
					System.out.println(WatchesInput.get(input));
					System.out.println("If Yes Press (Y) else press any character to go back");
		      		char byu=sc.next().charAt(0);
		      		if(byu == 'Y' || byu== 'y') {
		      			condition();
		      			String item=(String)watches.get(input);
		      			cart.add(item);
		      			rate.add(WatchesRate.get(input));
		      			System.out.println("Added to Cart");
		      			int value=(int)WatchesRate.get(input);
		      			Totalbill=Totalbill+value;
		      			WatchesBack();
		      		}
		      		else {
		      			watches();
		      		}
				}
				else if (input==8) {
					new Asscessories();
				}
				else if (input==9) {
					category();
				}
				else if (input==10) {
					cart();
				}
				else if (input==11) {
					exit();
				}
				else {
					System.err.println("Invalid Input!! Please Enter Correct Input");
		    		System.out.println("================================================================");
		    		sunglassesInput();
				}
			
			
		}
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer not Character");
			System.out.println("=========================================================");
			System.out.print("Enter Again :: ");
			watchesInput();
					}
	}
	
	public void WatchesBack() {
		try{
			 System.out.println("=============================================================");
	    		System.out.println("");
	    		System.out.println("1 - Watches Collection");
	    		System.out.println("2 - Asscessories Collection");
	    		System.out.println("3 - Main Collection");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("ENTER YOUR CHOICES :: ");
	    		Scanner sc = new Scanner(System.in);
	    		int subinput=sc.nextInt();
	    		switch(subinput) {
	    		case 1: watches();
	    		break;
	    		case 2:new Asscessories();
	    		break;
	    		case 3:category();
	    		break;
	    		case 4:cart();
	    		break;
	    		default:
	    			System.err.println("Invalid Input!!");
	    			System.out.println("================================================================");
				System.out.print("Please Enter Correct Input :: ");
				WatchesBack();
	    		break;
	    		}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		WatchesBack();
				}		
	}
	
//  -----------------------------------------------SunGlasses Section
	static ArrayList sunglasses=new ArrayList();
	public void sunglasses_frames(){
		sunglasses.clear();
		System.out.println("");
		System.out.println("********************************************************************");
		System.out.println("Welcome to Sunglasses Collection");
	    System.out.println("********************************************************************");
		sunglasses.add("VOYAGE Full-Rim Round Sunglasses");
		sunglasses.add("CARLTON LONDON UV Protected Lens Rectangle Sunglasses");
		sunglasses.add("RESIST EYEWEAR UV Protected Rimless Wayfarers");
		sunglasses.add("TED SMITH BLK/GLD UV-Protected Clubmasters");
		sunglasses.add("IRUS UV-Protected & Polarised Aviators");
		sunglasses.add("EYEWEARLABS UV-Protected Polarised Square Sunglasses");
		sunglasses.add("VINCENT CHASE Unisex UV Protected Sunglasses ");
		sunglasses.add("Asscessories Collection");
		sunglasses.add("Main Collection");
		sunglasses.add("Cart Section");
		sunglasses.add("Exit");
		for (int i = 0; i < sunglasses.size(); i++) 
		{
			 System.out.print(01+i+".");
			 System.out.println(sunglasses.get(i));
		}
		System.out.println("********************************************************************");
	 	System.out.println("");
	  	System.out.print("ENTER YOUR CHOICES :: ");
		sunglassesInput();
	}
	
    public void sunglassesInput(){
    try {
    	Scanner sc=new Scanner(System.in);
        int input=sc.nextInt();
        ArrayList SunglassesInput=new ArrayList();
        ArrayList SunglassesRate=new ArrayList();
        SunglassesInput.add("=============================================================\r\n"
				+ "Item :: VOYAGE Full-Rim Round Sunglasses\r\n"
				+ "=============================================================\r\n"
				+ "Product Details ::\r\n"
				+ "--> Colour :: Rose Gold\r\n"
				+ "--> Metal strap\r\n"
				+ "--> Water-resistant.\r\n"
				+ "--> Water-resistant upto 50 m.\r\n"
				+ "--> Clean the dial with a cotton cloth\r\n"
				+ "=========================================================\r\n"
				+ "Price :: RS 599\r\n"
				+ "=========================================================");
        SunglassesRate.add(599);
        SunglassesInput.add("=============================================================\r\n"
    				+ "Item :: CARLTON LONDON UV Protected Lens Rectangle Sunglasses\r\n"
    				+ "=============================================================\r\n"
    				+ "Product Details ::\r\n"
    				+ "--> Full-rim Frame\r\n"
    				+ "--> Polarised Lens\r\n"
    				+ "--> Acetate Frame\r\n"
    				+ "--> Polycarbonate Lens\r\n "
    				+ "--> Clean the dial with a cotton cloth.\r\n"
    				+ "=========================================================\r\n"
    				+ "Price :: RS 999\r\n"
    				+ "=========================================================");
            SunglassesRate.add(999);
            SunglassesInput.add("=============================================================\r\n"
    				+ "Item :: RESIST EYEWEAR UV Protected Rimless Wayfarers\r\n"
    				+ "=============================================================\r\n"
    				+ "Product Details ::\r\n"
    				+ "--> Rimless Frame\r\n"
    				+ "--> UV Protected Lens\r\n"
    				+ "--> Polycarbonate Lens.\r\n"
    				+ "--> Do not allow sweat settlement.\r\n "
    				+ "--> Clean the dial with a cotton cloth.\r\n"
    				+ "=========================================================\r\n"
    				+ "Price :: RS 1999\r\n"
    				+ "=========================================================");
            SunglassesRate.add(1999);
            SunglassesInput.add("=============================================================\r\n"
    				+ "Item :: TED SMITH BLK/GLD UV-Protected Clubmasters\r\n"
    				+ "=============================================================\r\n"
    				+ "Product Details ::\r\n"
    				+ "--> Full-rim Frame\r\n"
    				+ "--> UV Protected Lens\r\n"
    				+ "--> Polycarbonate Lens.\r\n"
    				+ "--> Metal Frame.\r\n "
    				+ "--> Clean the dial with a cotton cloth.\r\n"
    				+ "=========================================================\r\n"
    				+ "Price :: RS 799\r\n"
    				+ "=========================================================");
            SunglassesRate.add(799);
            SunglassesInput.add("=============================================================\r\n"
    				+ "Item :: IRUS UV-Protected & Polarised Aviators\r\n"
    				+ "=============================================================\r\n"
    				+ "Product Details ::\r\n"
    				+ "--> Full-rim Frame\r\n"
    				+ "--> UV Protected Lens\r\n"
    				+ "--> Polycarbonate Lens.\r\n"
    				+ "--> Metal Frame.\r\n "
    				+ "--> Clean the dial with a cotton cloth.\r\n"
    				+ "=========================================================\r\n"
    				+ "Price :: RS 1499\r\n"
    				+ "=========================================================");
            SunglassesRate.add(1499);
            SunglassesInput.add("=============================================================\r\n"
    				+ "Item ::  EYEWEARLABS UV-Protected Polarised Square Sunglasses\r\n"
    				+ "=============================================================\r\n"
    				+ "Product Details ::\r\n"
    				+ "--> Full-rim Frame\r\n"
    				+ "--> UV Protected Lens\r\n"
    				+ "--> Polycarbonate Lens.\r\n"
    				+ "--> Metal Frame.\r\n "
    				+ "--> Clean the dial with a cotton cloth.\r\n"
    				+ "=========================================================\r\n"
    				+ "Price :: RS 1499\r\n"
    				+ "=========================================================");
            SunglassesRate.add(1499);
            SunglassesInput.add("=============================================================\r\n"
    				+ "Item ::   VINCENT CHASE Unisex UV Protected Sunglasses\r\n"
    				+ "=============================================================\r\n"
    				+ "Product Details ::\r\n"
    				+ "--> Full-rim Frame\r\n"
    				+ "--> UV Protected Lens\r\n"
    				+ "--> Polycarbonate Lens.\r\n"
    				+ "--> Metal Frame.\r\n "
    				+ "--> Clean the dial with a cotton cloth.\r\n"
    				+ "=========================================================\r\n"
    				+ "Price :: RS 1499\r\n"
    				+ "=========================================================");
            SunglassesRate.add(1499);
//            System.out.println(SunglassesRate.size());
            if(input>0 && input<8) {
            	input=input-1;
				System.out.println(SunglassesInput.get(input));
				System.out.println("If Yes Press (Y) else press any character to go back");
	      		char byu=sc.next().charAt(0);
	      		if(byu == 'Y' || byu== 'y') {
	      			condition();
	      			String item=(String)sunglasses.get(input);
	      			cart.add(item);
	      			rate.add(SunglassesRate.get(input));
	      			System.out.println("Added to Cart");
	      			int value=(int)SunglassesRate.get(input);
	      			Totalbill=Totalbill+value;
	      			sunglassesback();
	      		}
	      		else {
	      			sunglasses_frames();
	      		}
			}
			else if (input==8) {
				new Asscessories();
			}
			else if (input==9) {
				category();
			}
			else if (input==10) {
				cart();
			}
			else if (input==11) {
				exit();
			}
			else {
				System.err.println("Invalid Input!! Please Enter Correct Input");
	    		System.out.println("================================================================");
	    		sunglassesInput();
			}
    }
    catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		sunglassesInput();
				}
	}
    
    
     public void sunglassesback() 
    {
    	try{
			 System.out.println("=============================================================");
	    		System.out.println("");
	    		System.out.println("1 - Sunglasses Frames Collection");
	    		System.out.println("2 - Asscessories Collection");
	    		System.out.println("3 - Main Collection");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("ENTER YOUR CHOICES :: ");
	    		Scanner sc = new Scanner(System.in);
	    		int subinput=sc.nextInt();
	    		switch(subinput) {
	    		case 1: sunglasses_frames();
	    		break;
	    		case 2:new Asscessories();
	    		break;
	    		case 3:category();
	    		break;
	    		case 4:cart();
	    		break;
	    		default:
	    			System.err.println("Invalid Input!!");
	    			System.out.println("================================================================");
				System.out.print("Please Enter Correct Input :: ");
				sunglassesback();
	    		break;
	    		}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		sunglassesback();
				}			
    }
     
     
     //    -----------------------------------------------Belts Section
    
    static ArrayList BeltsStorage=new ArrayList();
    
    public void Belts() {
//		ArrayList BeltsStorage=new ArrayList();
		BeltsStorage.clear();
		System.out.println("");
		System.out.println("********************************************************************");
		System.out.println("Welcome to Belts Collection");
	    System.out.println("********************************************************************");
	    BeltsStorage.add("WINSOME DEAL Leather Belt with Buckle Closure");
	    BeltsStorage.add("AXXTITUDE Reversibl Belt with Tang Buckle Closure");
	    BeltsStorage.add("ARENDELLE Textured Suspender Belt");
	    BeltsStorage.add("TEAKWOOD LEATHERS Textured Print Reversible Belt");
	    BeltsStorage.add("DA MILANO Women Slim Belt with Buckle Closure"); 
	    BeltsStorage.add("ALDO Typographic Slim Belt with Buckle Closure");
	    BeltsStorage.add("SUPERDRY Vintage Utility Webbing Belt");
	    BeltsStorage.add("MARKS & SPENCER Wide Belt with Buckle Closure");
	    BeltsStorage.add("ZORO Men Belt with Plaque Closure");
	    BeltsStorage.add("Asscessories Collection");
	    BeltsStorage.add("Main Collection");
	    BeltsStorage.add("Cart Section");
	    BeltsStorage.add("Exit");    
	    for (int i = 0; i < BeltsStorage.size(); i++) 
		{
			 System.out.print(01+i+".");
			 System.out.println(BeltsStorage.get(i));
		}
		System.out.println("********************************************************************");
	 	System.out.println("");
	  	System.out.print("ENTER YOUR CHOICES :: ");
		BeltsInput();
		
	}
	
	public void BeltsInput() 
	{
	
		try {
//			System.out.println(BeltsStorage);
			ArrayList BeltsInputs=new ArrayList();
			ArrayList BeltsRates=new ArrayList();
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: WINSOME DEAL Leather Belt with Buckle Closure\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Genuine Leather\r\n"
					+ "--> Colour :: Black\r\n"
					+ "--> Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 499\r\n"
					+ "=========================================================");
			BeltsRates.add(499);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: AXXTITUDE Reversibl Belt with Tang Buckle Closure\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Faux Leather\r\n"
					+ "--> Colour :: Brown\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 499\r\n"
					+ "=========================================================");
			BeltsRates.add(499);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: ARENDELLE Textured Suspender Belt\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Polyester\r\n"
					+ "--> Colour :: Brown\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 399\r\n"
					+ "=========================================================");
			BeltsRates.add(399);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: TEAKWOOD LEATHERS Textured Print Reversible Belt\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Genuine Leather\r\n"
					+ "--> Colour :: Black\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 899\r\n"
					+ "=========================================================");
			BeltsRates.add(899);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: DA MILANO Women Slim Belt with Buckle Closure\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Genuine Leather\r\n"
					+ "--> Colour :: Black\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 899\r\n"
					+ "=========================================================");
			BeltsRates.add(899);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: ALDO Typographic Slim Belt with Buckle Closure\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Polyurethane\r\n"
					+ "--> Colour :: Brown\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 499\r\n"
					+ "=========================================================");
			BeltsRates.add(499);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: SUPERDRY Vintage Utility Webbing Belt\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Polyurethane\r\n"
					+ "--> Colour :: Brown\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 999\r\n"
					+ "=========================================================");
			BeltsRates.add(999);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: MARKS & SPENCER Wide Belt with Buckle Closure\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Colour :: Black\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 999\r\n"
					+ "=========================================================");
			BeltsRates.add(999);
			BeltsInputs.add("=============================================================\r\n"
					+ "Item :: ZORO Men Belt with Plaque Closure\r\n"
					+ "=============================================================\r\n"
					+ "Product Details ::\r\n"
					+ "--> Colour :: Black\r\n"
					+ "-->  Reversible\r\n"
					+ "-->  Men's Belts\r\n"
					+ "--> Wipe with clean, dry cloth.\r\n"
					+ "=========================================================\r\n"
					+ "Price :: RS 599\r\n"
					+ "=========================================================");
			BeltsRates.add(599);
			if(input>0 && input<10) {
				input=input-1;
				System.out.println(BeltsInputs.get(input));
				System.out.println("If Yes Press (Y) else press any character to go back");
	      		char byu=sc.next().charAt(0);
	      		if(byu == 'Y' || byu== 'y') {
	      			condition();
	      			String item=(String)BeltsStorage.get(input);
	      			cart.add(item);
	      			rate.add(BeltsRates.get(input));
	      			System.out.println("Added to Cart");
	      			int value=(int)BeltsRates.get(input);
	      			Totalbill=Totalbill+value;
	      			BeltsBack();
	      		}
	      		else {
	      			Belts();
	      		}
			}
			else if (input==10) {
				new Asscessories();
			}
			else if (input==11) {
				category();
			}
			else if (input==12) {
				cart();
			}
			else if (input==13) {
				exit();
			}
			else {
				System.err.println("Invalid Input!! Please Enter Correct Input");
	    		System.out.println("================================================================");
	    		BeltsInput();
			}
		}
		
		catch(InputMismatchException e) {
			System.err.println("Invalid Input!! Please Enter Integer not Character");
			System.out.println("=========================================================");
			System.out.print("Enter Again :: ");
			BeltsInput();
					}			
	}

	public void BeltsBack() {
		try{
			 System.out.println("=============================================================");
	    		System.out.println("");
	    		System.out.println("1 - Belts Collection");
	    		System.out.println("2 - Asscessories Collection");
	    		System.out.println("3 - Main Collection");
	    		System.out.println("4 - Card Section");
	    		System.out.println("=========================================================");
	    		System.out.println("ENTER YOUR CHOICES :: ");
	    		Scanner sc = new Scanner(System.in);
	    		int subinput=sc.nextInt();
	    		switch(subinput) {
	    		case 1: Belts();
	    		break;
	    		case 2:new Asscessories();
	    		break;
	    		case 3:category();
	    		break;
	    		case 4:cart();
	    		break;
	    		default:
	    			System.err.println("Invalid Input!!");
	    			System.out.println("================================================================");
				System.out.print("Please Enter Correct Input :: ");
				BeltsBack();
	    		break;
	    		}
		}
		catch(InputMismatchException e) {
		System.err.println("Invalid Input!! Please Enter Integer not Character");
		System.out.println("=========================================================");
		System.out.print("Enter Again :: ");
		BeltsBack();
				}			
		
	}
//	Closed Class
	}

