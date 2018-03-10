import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Calendar; 

public  class stackoverflow {


		 public static void main(String[] args) {

		    String[] days = {
		        "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
		    };
		    Scanner in = new Scanner(System. in );
		    Calendar cal = Calendar.getInstance();
		    String ans;
		    int year = cal.get(Calendar.YEAR);
		    int day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		    int week = cal.get(Calendar.DAY_OF_WEEK);
		    int month = cal.get(Calendar.MONTH);
		    int col[] = new int[3];

		    do {
		        // validation for input year

		        do {
		            System.out.print("\nEnter year: ");
		            while (true)
		            try {
		                year = Integer.parseInt( in .next());
		                break;
		            } catch (Exception ex) {
		                System.out.println("Try again!");
		                System.out.print("\nEnter year: ");
		            }
		            if (year < 1900 || year > 2099) {
		                System.out.println("Try again!");
		            }
		        } while (year < 1900 || year > 2099);

		        for (month = 1; month <= 1; month++) {


		            HashMap < Integer, Integer > map = new HashMap < Integer, Integer > ();
		            map.put(1, 0);
		            map.put(7, 6);
		            map.put(2, 3);
		            map.put(8, 2);
		            map.put(3, 3);
		            map.put(9, 5);
		            map.put(4, 6);
		            map.put(10, 0);
		            map.put(5, 1);
		            map.put(11, 3);
		            map.put(6, 4);
		            map.put(12, 5);

		            System.out.println();

		            for (int a = 0; a < col.length; a++) {
		                int counter = 1;
		                System.out.printf("%-6s%-6s%-6s%-6s%-6s%-6s%-6s", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
		                System.out.printf("\t\t\t"); //Formatting for days

		            }
		            // System.out.println();

		            // calculate leap year
		            boolean LeapYear = false;
		            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) LeapYear = true;
		            // displaying month as String

		            ArrayList < Integer > dds = new ArrayList < Integer > ();
		            dds.add(0);
		            dds.add(0);
		            dds.add(0);
		            dds.add(0);
		            int indexofA = 0;

		            String yy = year + "";

		            int m;
		            if (LeapYear && month == 1) m = map.get(month) + 6;
		            else if (LeapYear && month == 2) m = map.get(month) - 1;
		            else m = map.get(month);

		            int y = Integer.parseInt(yy.substring(2, 4));
		            int c = (year / 100);
		            if (c % 4 == 0) c = 6;
		            else if (c % 4 == 1) c = 4;
		            else if (c % 4 == 2) c = 2;
		            else c = 0;
		            int x = y + y / 4 + c;
		            int d = (1 + x + m) % 7;
		            // cal.set(year, month, 0);

		            int length = (int)(30 + ((month + (month / 8.0)) % 2));
		            if (month == 2) {
		                if (LeapYear) {
		                    length -= 1;
		                } else {
		                    length -= 2;
		                }
		            }
		            System.out.print("len : " + length);
		            System.out.println();
		            boolean thirtyone = false;
		            int count = 0;
		            for (int r = 0; r < 6; r++) { //For each row of the calendars

		                String[] dayss = new String[7];

		                int index = 0;

		                for (int a = 0; a < col.length; a++) { //For each column of a calendar

		                    for (int i = 0; i < d && dds.get(indexofA) == 0; i++) {

		                        dayss[index] = " ";
		                        index++;
		                    }

		                    for (day = dds.get(indexofA) + 1; day <= length; day++) {
		                        if (day == 31) {
		                            dayss[index] = day + "";
		                            index++;
		                            thirtyone = true;

		                        } else if (day < 31) {
		                            dayss[index] = day + "";
		                            index++;
		                        }

		                        if (index == 7) {
		                            dds.set(indexofA, day);
		                            break;
		                        }

		                    }

		                    indexofA++;
		                    System.out.printf("%-6s%-6s%-6s%-6s%-6s%-6s%-6s", dayss[0], dayss[1], dayss[2], dayss[3],
		                    dayss[4], dayss[5], dayss[6]);
		                    System.out.printf("\t\t\t");

		                    index = 0;
		                    year++;
		                    LeapYear = false;
		                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) LeapYear = true;
		                    yy = year + "";
		                    if (LeapYear && month == 1) m = map.get(month) + 6;
		                    else if (LeapYear && month == 2) m = map.get(month) - 1;
		                    else m = map.get(month);

		                    y = Integer.parseInt(yy.substring(2, 4));
		                    c = (year / 100);
		                    if (c % 4 == 0) c = 6;
		                    else if (c % 4 == 1) c = 4;
		                    else if (c % 4 == 2) c = 2;
		                    else c = 0;
		                    x = y + y / 4 + c;
		                    d = (1 + x + m) % 7;

		                }
		                year -= 3;
		                yy = year + "";
		                LeapYear = false;
		                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) LeapYear = true;

		                if (LeapYear && month == 1) m = map.get(month) + 6;
		                else if (LeapYear && month == 2) m = map.get(month) - 1;
		                else m = map.get(month);

		                y = Integer.parseInt(yy.substring(2, 4));
		                c = (year / 100);
		                if (c % 4 == 0) c = 6;
		                else if (c % 4 == 1) c = 4;
		                else if (c % 4 == 2) c = 2;
		                else c = 0;
		                x = y + y / 4 + c;
		                d = (1 + x + m) % 7;

		                indexofA = 0;
		                System.out.println();

		            }

		        }
		        System.out.print("\n\n" + "Enter another year (Y/N)? ");
		        ans = in .next();
		    } while (ans.equals("Y") || ans.equals("y"));
		    System.out.println("\nEnd!"); in .close();
		}

		}

