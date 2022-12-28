package javaDocPractice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.util.Date;
import java.util.Locale;

public class DateTimeApi {

	public static void main(String[] args) throws ParseException 
	{
//         System.out.println(DayOfWeek.FRIDAY);
//         DayOfWeek d = DayOfWeek.of(3);
//         System.out.println(d);
//         System.out.println(DayOfWeek.values().toString());
//        System.out.println(DayOfWeek.valueOf("SUNDAY"));
//        DayOfWeek d1 = DayOfWeek.MONDAY.plus(5);
        Locale locale = Locale.ENGLISH;
//        System.out.println(d1.getDisplayName(TextStyle.SHORT, locale));
		
//		String month = Month.APRIL.getDisplayName(TextStyle.SHORT_STANDALONE, locale);
//		System.out.println(month);
//		System.out.println(Month.of(5));
        
        
//		Date date = new Date();
//		System.out.println(date);
//		System.out.println(date.getTime());
//		System.out.println(date.get);
        
//        LocalDate localDate = LocalDate.now();
//        System.out.println(localDate);
//        
//        
//        LocalDate localDate2 = LocalDate.of(2023,1,24);
//        System.out.println(localDate2.getDayOfWeek());
//         System.out.println(localDate2.with(DayOfWeek.MONDAY));
        
//        YearMonth yearMonth = YearMonth.now();
//        System.out.println(yearMonth.lengthOfMonth());
//        YearMonth yearMonth2 = YearMonth.of(2023, 01);
//        System.out.println(yearMonth2.lengthOfMonth());
        
//        MonthDay monthDay = MonthDay.now();
//        System.out.println(monthDay);
//         DayOfWeek date = MonthDay.of(01, 24).atYear(2023).getDayOfWeek();
//         System.out.println(date);
        
//        Year year = Year.now();
//        System.out.println(year);
//          Boolean b = Year.isLeap(2024);
//          System.out.println(b);
        
//        ZoneId zoneId = ZoneId.systemDefault();
//        System.out.println(zoneId);
//        
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
//        System.out.println(dateTimeFormatter);
        
//        Instant instant = Instant.now();
//        System.out.println(instant);
//        Period period = Period.between(LocalDate.now(), LocalDate.now().minusDays(5));
//        System.out.println(period);
//        Duration duration = Duration.between(LocalDate.now(),LocalDate.now().minusDays(5));
//        System.out.println(duration);
        
            
//        String zoneId = ZoneId.of("Asia/Kolkata").getDisplayName(TextStyle.FULL, locale);
//        System.out.println(zoneId);
//         System.out.println(ZoneId.systemDefault());
        
//        ZoneOffset zoneOffset = ZoneOffset.MAX;
//        System.out.println(zoneOffset);
//        System.out.println(ZoneOffset.MIN);
//        System.out.println(ZoneOffset.UTC);
//        System.out.println();
        
        Date date = new Date();
        System.out.println(date);
        DateFormat dateFormat = new SimpleDateFormat();
         String s = dateFormat.format(date);
        System.out.println(s);
        Date date2 = dateFormat.parse(s);
        System.out.println(date2);
        DateFormat date3 = dateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println(dateFormat);
        
        
	}

}
