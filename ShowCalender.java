import java.awt.*;
import java.awt.event.*;
class ShowCalender extends WindowAdapter implements ActionListener
{
    Frame f;
    Button prevYear,prevMonth,nextYear,nextMonth,search;
    Label month,year,author,holiday;
    Choice monthlist;
    static TextField monthYear,weekname,week1,week2,week3,week4,week5,inYear;
    static TextArea holidays;
    int storeMonth,storeYear;
    ShowCalender()
    {
        f=new Frame("CALENDER");
        f.setLayout(null);
        month=new Label("Month");
        year=new Label("Year");
        holiday=new Label("Holidays");
        author=new Label("Designed by Aditya Pandey");
        prevYear=new Button("Previous");
        prevMonth=new Button("Previous");
        nextYear=new Button("Next");
        nextMonth=new Button("Next");
        search=new Button("Search");
        inYear=new TextField();
        monthYear=new TextField();
        weekname=new TextField("    SUNDAY        MONDAY        TUEDAY        WEDNESDAY        THURSDAY        FRIDAY        SATURDAY");
        week1=new TextField(75);
        week2=new TextField(75);
        week3=new TextField(75);
        week4=new TextField(75);
        week5=new TextField(75);
        holidays=new TextArea("",270,87,TextArea.SCROLLBARS_VERTICAL_ONLY);
        monthlist=new Choice();
        monthlist.add("January");
        monthlist.add("February");
        monthlist.add("March");
        monthlist.add("April");
        monthlist.add("May");
        monthlist.add("June");
        monthlist.add("July");
        monthlist.add("August");
        monthlist.add("September");
        monthlist.add("October");
        monthlist.add("November");
        monthlist.add("December");

        f.add(month);
        f.add(year);
        f.add(holiday);
        f.add(author);
        f.add(prevYear);
        f.add(prevMonth);
        f.add(nextYear);
        f.add(nextMonth);
        f.add(search);
        f.add(inYear);
        f.add(monthYear);
        f.add(weekname);
        f.add(week1);
        f.add(week2);
        f.add(week3);
        f.add(week4);
        f.add(week5);
        f.add(holidays);
        f.add(monthlist);

        holidays.setEditable(false);
        monthYear.setEditable(false);
        weekname.setEditable(false);
        week1.setEditable(false);
        week2.setEditable(false);
        week3.setEditable(false);
        week4.setEditable(false);
        week5.setEditable(false);

        prevYear.addActionListener(this);
        prevMonth.addActionListener(this);
        nextYear.addActionListener(this);
        nextMonth.addActionListener(this);
        search.addActionListener(this);

        month.setBounds(20,50,40,30);
        monthlist.setBounds(70,50,100,30);
        year.setBounds(180,50,40,30);
        inYear.setBounds(220,50,80,30);
        search.setBounds(130,135,70,30);
        prevYear.setBounds(130,100,70,30);
        prevMonth.setBounds(55,135,70,30);
        nextMonth.setBounds(205,135,70,30);
        nextYear.setBounds(130,170,70,30);
        monthYear.setBounds(320,50,630,30);
        weekname.setBounds(320,90,630,30);
        week1.setBounds(320,130,630,30);
        week2.setBounds(320,170,630,30);
        week3.setBounds(320,210,630,30);
        week4.setBounds(320,250,630,30);
        week5.setBounds(320,290,630,30);
        holiday.setBounds(130,200,100,30);
        holidays.setBounds(20,230,270,87);
        author.setBounds(380,327,200,30);

        f.addWindowListener(this);
        f.setSize(960,360);
        f.setBackground(Color.ORANGE);
        search.setBackground(Color.WHITE);
        prevYear.setBackground(Color.WHITE);
        prevMonth.setBackground(Color.WHITE);
        nextMonth.setBackground(Color.WHITE);
        nextYear.setBackground(Color.WHITE);
        monthlist.setBackground(Color.WHITE);
        f.setResizable(false);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {
        try
        {
            if(event.getSource()==search)
            {
                int month=monthlist.getSelectedIndex();
                int year=Integer.parseInt(inYear.getText());
                storeYear=year;
                storeMonth=month+1;
                if(storeYear==1)
                {
                    prevYear.setEnabled(false);
                }
                if(storeMonth==1)
                {
                    prevMonth.setEnabled(false);
                }
                if(storeMonth<=11 && storeMonth>1)
                {
                    nextMonth.setEnabled(true);
                }
                if(storeYear<1)
                {
                    nextYear.setEnabled(true);
                }
                if(storeMonth==12)
                {
                    nextMonth.setEnabled(false);
                }
                if(storeMonth>1)
                {
                    prevMonth.setEnabled(true);
                }
                ShowCalender.printCalender(storeMonth,storeYear);
            }
            if(event.getSource()==prevYear)
            {
                storeYear=storeYear-1;
                if(storeYear==1)
                {
                    prevYear.setEnabled(false);
                }
                ShowCalender.printCalender(storeMonth,storeYear);
            }
            if(event.getSource()==prevMonth)
            {
                storeMonth=storeMonth-1;
                if(storeMonth==1)
                {
                    prevMonth.setEnabled(false);
                }
                if(storeMonth<=11 && storeMonth>1)
                {
                    nextMonth.setEnabled(true);
                }
                ShowCalender.printCalender(storeMonth,storeYear);
            }
            if(event.getSource()==nextYear)
            {
                storeYear=storeYear+1;
                if(storeYear<1)
                {
                    nextYear.setEnabled(true);
                }
                ShowCalender.printCalender(storeMonth,storeYear);
            }
            if(event.getSource()==nextMonth)
            {
                storeMonth=storeMonth+1;
                if(storeMonth==12)
                {
                    nextMonth.setEnabled(false);
                }
                if(storeMonth>1)
                {
                    prevMonth.setEnabled(true);
                }
                ShowCalender.printCalender(storeMonth,storeYear);
            }
        }
        catch(Exception ex)
        {
            monthYear.setText("");
            week1.setText("");
            week2.setText("");
            week4.setText("");
            week5.setText("");
            week3.setText("\t            Invalid Input");
        }
    }

    public void windowClosing(WindowEvent e) 
    {  
        f.dispose();  
    } 

    public static void printCalender(int m,int y)
    {
        int d=1;
        int ar[]={31,y%100==0?y%400==0?29:28:y%4==0?29:28,31,30,31,30,31,31,30,31,30,31};
        String month[]={"JANUARY","FEBRUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER","NOVEMBER","DECEMBER"};
        String holiday[]=new String[12];
        holiday[0]="01 -  New Year's Day\n14 - Makar Sankranti / Pongal\n26 - Republic Day";
        holiday[3]="14 - Mahavir Jayanti\n19 - Good Friday";
        holiday[4]="01 - Labour Day";
        holiday[7]="15 - Independence Day";
        holiday[8]="05 - Teacher's Day";
        holiday[9]="02 - Gandhi Jayanti";
        holiday[11]="25 - Christmas";
        if(y>0)
        {
            int y1=y-1;
            int sum=0;
            y1=y1%400;
            if(y1>=300)
            {
                sum=sum+1;
            }
            y1=y1%300;
            if(y1>=200)
            {
                sum=sum+3;
            }
            y1=y1%200;
            if(y1>=100)
            {
                sum=sum+5;
            }
            y1=y1%100;
            int lp=y1/4;
            sum=sum+(lp*2);
            sum=sum+(y1-lp);
            for(int x=1;x<m;x++)
            {
                sum=sum+(ShowCalender.findOdd(x,y));
            }
            sum=sum+d;
            int odd_day=sum%7;
            String weeks[]=new String[5];
            weeks[0]="";
            weeks[1]="";
            weeks[2]="";
            weeks[3]="";
            weeks[4]="  ";
            int wcount=0;
            int cweek=0;
            int count=1,run=1;
            while(true)
            {
                cweek++;
                if(run<odd_day+1)
                {
                    weeks[wcount]=weeks[wcount]+"\t";
                }
                else if(cweek<=7)
                {
                    weeks[wcount]=" "+weeks[wcount]+count+"\t";
                    count++;
                }
                else
                {
                    cweek=0;
                    wcount++;
                }
                if(count>ar[m-1])
                {
                    break;
                }
                run++;
            }
            String my="    "+month[m-1]+"\t\t\t\t\t\t"+y;
            monthYear.setText(my);
            week1.setText(weeks[0]);
            week2.setText(weeks[1]);
            week3.setText(weeks[2]);
            week4.setText(weeks[3]);
            week5.setText(weeks[4]);
            holidays.setText(holiday[m-1]);
        }
        else
        {
            monthYear.setText("");
            week1.setText("");
            week2.setText("");
            week4.setText("");
            week5.setText("");
            week3.setText("\t            Invalid Input");
        }
    }

    public static int findOdd(int m,int y)
    {
        int ar[]={3,y%100==0?y%400==0?1:0:y%4==0?1:0,3,2,3,2,3,3,2,3,2,3};
        return ar[m-1];
    }

    public static void main(String args[])
    {
        ShowCalender ob =new ShowCalender();
    }
}