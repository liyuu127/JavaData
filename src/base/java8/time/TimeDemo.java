package base.java8.time;

import base.jvm.classload.Person;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @author liyu
 * @date 2019/12/2 14:57
 * @description
 */
public class TimeDemo {
    public static void main(String[] args) throws InterruptedException {

        //创建一个LocalDate对象并读取其值
//        demo1();

        //使用TemporalField读取LocalDate的值
//        demo2();

        //创建LocalTime并读取其值
//        demo3();

        //直接创建LocalDateTime对象，或者通过合并日期和时间的方式创建
//        demo4();

        //创建Duration和Period对象
//        demo5();

        //操纵时间对象
//        demo6();

        //打印输出及解析日期-时间对象
//        demo7();

        System.out.println("858815^9527 = " + (858815 ^ 9527));
        System.out.println("877755^9527 = " + (877755 ^ 9527));
    }

    @Data
    static class User {
        private Integer id;
        private String name;
        private Boolean flag;
    }


    private static void demo7() {
        //格式器生成字符串
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("s1 = " + s1);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("s2 = " + s2);

        //使用工厂方法parse重创该日期对象
        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        // 按照某个模式创建DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date3 = LocalDate.of(2014, 3, 18);
        String formattedDate = date3.format(formatter);
        LocalDate date4 = LocalDate.parse(formattedDate, formatter);
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss");
        String now = LocalDateTime.now().format(formatter2);
        System.out.println("now = " + now);

        //创建一个本地化的DateTimeFormatter
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.CHINESE);
        LocalDate date5 = LocalDate.of(2014, 3, 18);
        String formattedDate2 = date5.format(italianFormatter);
        System.out.println("formattedDate2 = " + formattedDate2);
        LocalDate date6 = LocalDate.parse(formattedDate2, italianFormatter);

        //构造一个DateTimeFormatter
        DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
    }

    private static void demo6() {

        //以比较直观的方式操纵LocalDate的属性
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        //以相对方式修改LocalDate对象的属性
        LocalDate date5 = LocalDate.of(2014, 3, 18);
        LocalDate date6 = date5.plusWeeks(1);
        LocalDate date7 = date6.minusYears(3);
        LocalDate date8 = date7.plus(6, ChronoUnit.MONTHS);

        //使用 TemporalAdjuster
        LocalDate date9 = LocalDate.of(2014, 3, 18);
        LocalDate date10 = date9.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date11 = date10.with(lastDayOfMonth());
    }


    private static void demo5() {
        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println("threeMinutes = " + threeMinutes.toString());
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println("threeMinutes2 = " + threeMinutes2.toString());
        Period tenDays = Period.ofDays(10);
        System.out.println("tenDays = " + tenDays.toString());
        Period threeWeeks = Period.ofWeeks(3);
        System.out.println("threeWeeks = " + threeWeeks.toString());
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println("twoYearsSixMonthsOneDay = " + twoYearsSixMonthsOneDay.toString());

        Period tenDays2 = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));
        System.out.println("tenDays2 = " + tenDays2.toString());
    }

    private static void demo4() {
        // 2014-03-18T13:45:20
        LocalDate date = LocalDate.of(2019, 12, 02);
        LocalTime time = LocalTime.of(13, 55, 59);

        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        System.out.println("dt1 = " + dt1.toString());
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        System.out.println("dt2.toString() = " + dt2.toString());
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        System.out.println("dt3.toString() = " + dt3.toString());
        LocalDateTime dt4 = date.atTime(time);
        System.out.println("dt4.toString() = " + dt4.toString());
        LocalDateTime dt5 = time.atDate(date);
        System.out.println("dt5.toString() = " + dt5.toString());

        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
    }


    private static void demo3() {
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        System.out.println("hour = " + hour);
        int minute = time.getMinute();
        System.out.println("minute = " + minute);
        int second = time.getSecond();
        System.out.println("second = " + second);

        LocalDate date2 = LocalDate.parse("2014-03-18");
        System.out.println("date2 = " + date2.toString());
        LocalTime time2 = LocalTime.parse("13:45:20");
        System.out.println("time2.toString() = " + time2.toString());
    }

    private static void demo2() {
        LocalDate date = LocalDate.now();
        int year = date.get(ChronoField.YEAR);
        System.out.println("year = " + year);
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("month = " + month);
        int day = date.get(ChronoField.DAY_OF_MONTH);
        System.out.println("day = " + day);
    }

    private static void demo1() {
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        System.out.println("year = " + year);
        int monthValue = date.getMonthValue();
        System.out.println("monthValue = " + monthValue);
        Month month = date.getMonth();
        System.out.println("month = " + month);
        int day = date.getDayOfMonth();
        System.out.println("day = " + day);
        DayOfWeek dow = date.getDayOfWeek();
        System.out.println("dow = " + dow);
        int len = date.lengthOfMonth();
        System.out.println("len = " + len);
        boolean leap = date.isLeapYear();
        System.out.println("leap = " + leap);
    }
}
