package com.validator;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CNPValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String[] checkSComponent(String value) {
		int s = Integer.parseInt(value.substring(0, 1));
		String begginingOfYear;
		String gender;
		switch(s) {
		case 1:
			begginingOfYear = "19";
			gender = "male";
			break;
		case 2:
			begginingOfYear = "19";
			gender = "female";
			break;
		case 3:
			begginingOfYear = "18";
			gender = "male";
			break;
		case 4:
			begginingOfYear = "18";
			gender = "female";
			break;
		case 5:
			begginingOfYear = "20";
			gender = "male";
			break;
		case 6:
			begginingOfYear = "20";
			gender = "female";
			break;
		/*case 7:
			res = "Digit 7 means you are a male resident";
			gender = "male";
			break;
		case 8:
			res = "Digit 7 means you are a female resident";
			gender = "female";
			break;*/
		default:
			begginingOfYear = "";
			gender = "";
		}
		String[] arrayToReturn = new String[2];
		arrayToReturn[0] = begginingOfYear;
		arrayToReturn[1] = gender;
		return arrayToReturn;	
	}
	
	private String isLeapYear(String year) {
		int yearInt = Integer.parseInt(year);
		if((yearInt % 4 == 0 && yearInt % 100 != 0) || (yearInt % 100 == 0 && yearInt % 400 == 0)) {
			return "true";
		}
		return "false";
	}
	
	private String[] checkAComponent(String value, String begginingOfYear) {
		String a = value.substring(1, 3);
		String fullYear = begginingOfYear.concat(a);
		String[] arrayToReturn = new String[2];
		//String res = "Number " + a + " means you year of birth is " + fullYear;
		arrayToReturn[0] = fullYear;
		arrayToReturn[1] = isLeapYear(fullYear);
		return arrayToReturn;
	}
	
	private String checkLComponent(String value) {
		String lName;
		String l = value.substring(3, 5);
		int lDigit = Integer.parseInt(l);
		switch(lDigit) {
		case 1:
			lName = "January";
			break;
		case 2:
			lName = "February";
			break;
		case 3:
			lName = "March";
			break;
		case 4:
			lName = "April";
			break;
		case 5:
			lName = "May";
			break;
		case 6:
			lName = "June";
			break;
		case 7:
			lName = "July";
			break;
		case 8:
			lName = "August";
			break;
		case 9:
			lName = "September";
			break;
		case 10:
			lName = "October";
			break;
		case 11:
			lName = "November";
			break;
		case 12:
			lName = "December";
			break;
		default:
			lName = "";
		}
		return lName;
	}
	
	private String checkZComponent(String value, String isLeapYear) {
		String z = value.substring(5, 7);
		int zInt = Integer.parseInt(z);
		String month = value.substring(3, 5);
		String res = "";
		if(month.matches("0[13578]|1[02]")) {
			if(zInt >= 1 && zInt <= 31) {
				res = z;
			}
		}
		else if(month.matches("0[469]|11")) {
			if(zInt >= 1 && zInt <= 30) {
				res = z;
			}
		}
		else if(month.matches("02")) {
			if(isLeapYear == "true") {
				if(zInt >= 1 && zInt <= 29) {
					res = z;
				}
			}
			else {
				if(zInt >= 1 && zInt <= 28) {
					res = z;
				}
			}
		}
		return res;
	}
	
	private String checkJComponent(String value) {
		String j = value.substring(7, 9);
		int jInt = Integer.parseInt(j);
		String jName;
		switch(jInt) {
		case 1:
			jName = "Alba";
			break;
		case 2:
			jName = "Arad";
			break;
		case 3:
			jName = "Argeș";
			break;
		case 4:
			jName = "Bacău";
			break;
		case 5:
			jName = "Bihor";
			break;
		case 6:
			jName = "Bistrița-Năsăud";
			break;
		case 7:
			jName = "Botoșani";
			break;
		case 8:
			jName = "Brașov";
			break;
		case 9:
			jName = "Brăila";
			break;
		case 10:
			jName = "Buzău";
			break;
		case 11:
			jName = "Caraș-Severin";
			break;
		case 12:
			jName = "Cluj";
			break;
		case 13:
			jName = "Constanța";
			break;
		case 14:
			jName = "Covasna";
			break;
		case 15:
			jName = "Dâmbovița";
			break;
		case 16:
			jName = "Dolj";
			break;
		case 17:
			jName = "Galați";
			break;
		case 18:
			jName = "Gorj";
			break;
		case 19:
			jName = "Harghita";
			break;
		case 20:
			jName = "Hunedoara";
			break;
		case 21:
			jName = "Ialomița";
			break;
		case 22:
			jName = "Iași";
			break;
		case 23:
			jName = "Ilfov";
			break;
		case 24:
			jName = "Maramureș";
			break;
		case 25:
			jName = "Mehedinți";
			break;
		case 26:
			jName = "Mureș";
			break;
		case 27:
			jName = "Neamț";
			break;
		case 28:
			jName = "Olt";
			break;
		case 29:
			jName = "Prahova";
			break;
		case 30:
			jName = "Satu Mare";
			break;
		case 31:
			jName = "Sălaj";
			break;
		case 32:
			jName = "Sibiu";
			break;
		case 33:
			jName = "Suceava";
			break;
		case 34:
			jName = "Teleorman";
			break;
		case 35:
			jName = "Timiș";
			break;
		case 36:
			jName = "Tulcea";
			break;
		case 37:
			jName = "Vaslui";
			break;
		case 38:
			jName = "Vâlcea";
			break;
		case 39:
			jName = "Vrancea";
			break;
		case 40:
			jName = "București";
			break;
		case 41:
			jName = "București - Sector 1";
			break;
		case 42:
			jName = "București - Sector 2";
			break;
		case 43:
			jName = "București - Sector 3";
			break;
		case 44:
			jName = "București - Sector 4";
			break;
		case 45:
			jName = "București - Sector 5";
			break;
		case 46:
			jName = "București - Sector 6";
			break;
		case 51:
			jName = "Călărași";
			break;
		case 52:
			jName = "Giurgiu";
			break;
		default:
			jName = "";
		}
		return jName;
	}
	
	private String checkNComponent(String value) {
		String n = value.substring(9, 12);
		int nInt = Integer.parseInt(n);
		String orderSuffix;
		if(nInt == 0) {
			orderSuffix = "";
		}
		switch(nInt) {
		case 1:
			orderSuffix = "st";
			break;
		case 2:
			orderSuffix = "nd";
			break;
		case 3:
			orderSuffix = "rd";
			break;
		default:
			orderSuffix = "th";
		}
		return orderSuffix;
	}
	
	private String checkCComponent(String value) {
		String cons = "279146358279";
		int currentDigitOfCNP;
		int currentDigitOfCons;
		int sum = 0;
		//String[] arrayToReturn = new String[2];
		for(int i = 0; i < 12; i++) {
			currentDigitOfCNP = Integer.parseInt(value.substring(i, i+1));
			currentDigitOfCons = Integer.parseInt(cons.substring(i, i+1));
			sum += currentDigitOfCNP * currentDigitOfCons;
		}
		int divisionRes = sum % 11;
		if(divisionRes == 10) {
			divisionRes = 1;
		}
		return String.valueOf(divisionRes);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter pw = resp.getWriter();
		
		pw = resp.getWriter();
		
		String cnp = req.getParameter("cnp");
		
		//check CNP format
		if(cnp.length() < 13) {
			pw.print("<p class='validation-msg-error'>CNP " + cnp + " has less than 13 characters!</p>");
			return;
		}
		if(cnp.length() > 13) {
			pw.print("<p class='validation-msg-error'>CNP " + cnp + " has more than 13 characters!</p>");
			return;
		}
		if(cnp.length() == 13 && !cnp.matches("[0-9]+")) {
			pw.print("<p class='validation-msg-error'>CNP " + cnp + " does not contain only digits!</p>");
			return;
		}
		if(cnp.length() == 13 && cnp.matches("[0-9]+")) {
			pw.print("<p class='validation-msg-success'>CNP " + cnp + " has the correct format!</p>");
		}
			
		pw.print("<h3>Your CNP explained:</h3>");
		
		//check component S
		String[] sResult = checkSComponent(cnp);
		if(sResult[0] == "" && sResult[1] == "") {
			pw.print("<p class='validation-msg-error'>The S component digit of the CNP (" + cnp.substring(0, 1) + ") is not valid!</p>");
			return;
		}
		pw.print("<p>- Component S -- gender and century (first digit): Digit " + cnp.substring(0, 1) + " means you are a " + sResult[1] + " born between " + sResult[0] + "00 and " + sResult[0] + "99</p>");
		
		//check component A
		String[] aResult = checkAComponent(cnp, sResult[0]);
		pw.print("<p>- Component AA -- last two digits in year of birth (digits 2 and 3): Number " + cnp.substring(1, 3) + " means you year of birth is " + aResult[0] +"</p>");
		
		//check component L
		String lResult = checkLComponent(cnp);
		if(lResult == "") {
			pw.print("<p class='validation-msg-error'>The LL component digits of the CNP (" + cnp.substring(3, 5) + ") are not valid!</p>");
			return;
		}
		pw.print("<p>- Component LL -- month of birth (digits 4 and 5): Digits " + cnp.substring(3, 5) + " mean your month of birth is " + lResult + "</p>");
		
		//check component Z
		String zResult = checkZComponent(cnp, aResult[0]);
		if(zResult == "") {
			pw.print("<p class='validation-msg-error'>The ZZ component digits of the CNP (" + cnp.substring(5, 7) + ") are not valid!</p>");
			return;
		}
		pw.print("<p>- Component ZZ -- day of birth (digits 6 and 7): These digits mean your day of birth is " + zResult + "</p>");
		
		//check component J
		String jResult = checkJComponent(cnp);
		if(jResult == "") {
			pw.print("<p class='validation-msg-error'>The JJ component digits of the CNP (" + cnp.substring(7, 9) + ") are not valid!</p>");
			return;
		}
		pw.print("<p>- Component JJ -- current county (Digits 8 and 9): Digits " + cnp.substring(7, 9) + " mean you were born in the county with this code, county name being " + jResult + "</p>");
		
		//check component N
		String nResult = checkNComponent(cnp);
		if(nResult == "") {
			pw.print("<p class='validation-msg-error'>At least one digit of NNN component should be greater than 0 (you introduced digits " + cnp.substring(9, 12) + ")!</p>");
			return;
		}
		pw.print("<p>- Component NNN -- sequential index (Digits 10, 11 and 12): Digits " + cnp.substring(9, 12) + " mean you are the " + Integer.parseInt(cnp.substring(9, 12)) + nResult + " " + sResult[1] + " born on " + cnp.substring(5, 7) + "." + cnp.substring(3, 5) + "." + aResult[0] + " in " +  jResult + "</p>");
		
		//check component C
		String cResult = checkCComponent(cnp);
		if(!cResult.equals(cnp.substring(12, 13))) {
			pw.print("<p class='validation-msg-error'>The C component (the last digit) should have value " + cResult + ", but the value you introduced is " + cnp.substring(12, 13) + ". This means the CNP is not valid!</p>");
			return;
		}
		pw.print("<p>- Component C -- validation digit (the last digit): The calculated value is " + cResult + ", which is the same as in the CNP you introduced. This means the CNP is valid!</p>");
		pw.close();
	}
}
