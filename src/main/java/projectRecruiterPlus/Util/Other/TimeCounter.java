package projectRecruiterPlus.Util.Other;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;

public class TimeCounter extends Thread {
	private int sec = 0;
	private int min = 0;
	private int hour = 0;
	private boolean stop = true;
	private LocalDateTime date;
	int year;
	DayOfWeek day;
	Month month;

	public TimeCounter() {
		super();
		this.date = LocalDateTime.now();;
		this.year = date.getYear();
		this.day = date.getDayOfWeek();
		this.month = date.getMonth(); 
	}

	public void run() {
		while (stop) {
			try {
				Thread.sleep(1000);
				sec++;
				if (sec == 60) {
					sec = 0;
					min++;
					if (min == 60) {
						min = 0;
						hour++;
						String attention = "You have been working for " + hour + " hour";
						attention += (hour == 1) ? "!" : "s!";
						System.out.println(attention);
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void stopCount() {
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter("D:\\Work\\eclipse-workplace-cursuri\\test\\output.txt", true));
			bw.write("Year: " + year + ", Month: " + month + ", Day: " + day + "."
					+ " Program was used for: " + hour + " hours, " + min + " minutes and " + sec + " seconds!" + "\n");
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.stop = false;
	}
}
