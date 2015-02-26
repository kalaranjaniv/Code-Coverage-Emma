package com.example.circlearea.test;


import com.example.circlearea.AreaCircle;
import com.jayway.android.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.text.format.Time;

public class InitialLoadTest extends
		ActivityInstrumentationTestCase2<AreaCircle> {

	
	
	private Solo solo;
	
	@SuppressWarnings({"deprecation"})
	
	public InitialLoadTest()
	{
		super("com.example.circlearea",AreaCircle.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		this.solo=new Solo(getInstrumentation(),getActivity());
	}
	protected void tearDown() throws Exception {
		getActivity().finish();
		super.tearDown();
	}
	public void testEP01()
	{	
		solo.takeScreenshot("TestcaseEP01");
		solo.enterText(0,"");
		solo.enterText(0,"12.5");
		solo.enterText(1,"");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("484.375") && text2.equals("77.5"))
				{
			assertEquals("Calculation is not working properly-EP01",expected,actual);
	
				}		
	}
	
	public void testEP02()
	{
		solo.enterText(0, "");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("radius should not be empty");		
		assertEquals("Error message not displayed-EP02",expected,actual);	
	
	}
	
	public void testEP03()
	{
		solo.enterText(0, "");
		solo.enterText(0, "15");
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("675") && text2.equals("90"))
				{
			assertEquals("Calculation is not working properly-EP03",expected,actual);
				}		
	}
	
	public void testEP04()
	{
		solo.enterText(0,"");
		solo.enterText(0,"-10");
		solo.enterText(1,"");
		solo.enterText(1,"-10");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("Values cannot be negative");
		assertEquals("Negative values doesnt get accepted in actual application(robotium error)-EP04",expected,actual);
	}
	public void testEP05()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5");
		solo.enterText(1, "");
		solo.enterText(1, "3");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("491.09375") && text2.equals("78.575"))
				{
			assertEquals("Calculation is not working properly-EP05",expected,actual);
				}		
	}
	public void testBVA01()
	{
		solo.enterText(0, "");
		solo.enterText(0, "0");
		solo.enterText(1, "");
		solo.enterText(1, "1");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("0") && text2.equals("0"))
				{
			actual=true;
				}
		assertEquals("Calculation is not working properly-BVA01",expected,actual);
	}
	public void testBVA02()
	{
		solo.enterText(0, "");
		solo.enterText(0, "0.0");
		solo.enterText(1, "");
		solo.enterText(1, "16");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("0") && text2.equals("0"))
				{
			actual=true;
				}		
		assertEquals("Calculation is not working properly-BVA02",expected,actual);
	}
	public void testBVA03()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5");
		solo.enterText(1, "");
		solo.enterText(1, "0");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("468.75") && text1.equals("75"))
				{
			actual=true;
				}		
	assertEquals("Calculation is not working properly-BVA03",expected,actual);
	}
	public void testBVA04()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5");
		solo.enterText(1, "");
		solo.enterText(1, "16");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("491.07142857") && text1.equals("78.57142857"))
				{
			actual=true;
				}		
				assertEquals("Calculation is not working properly-BVA04",expected,actual);
	}
	public void testBVA05()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.555555");
		solo.enterText(1,"");
		solo.enterText(1,"4");
		solo.clickOnButton("Calculate");
		String text1=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("495.45292035"))
				{
			actual=true;
				}
				assertEquals("No: of digits displayed in area is not exactly equal to 8 after decimal point-BVA05",expected,actual);
	}
	public void testBVA06()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.555555");
		solo.enterText(1,"");
		solo.enterText(1,"4");
		solo.clickOnButton("Calculate");
		String text2=solo.getText(7).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("78.92170762"))
				{
			
			actual=true;
				}
				assertEquals("No: of digits displayed in circumference is not exactly equal to 8 after decimal point-BVA06",expected,actual);
				
	}
	public void testEP07()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5");
		solo.enterText(1, "");
		solo.enterText(1, "2");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("490.625") && text1.equals("78.5"))
				{
			actual=true;
				}		
				assertEquals("Calculation is not working properly-EP07",expected,actual);
	}
	
	public void testEP08()
	{   
		solo.enterText(0, "");
	    solo.enterText(0,"12.5");
		solo.enterText(1,"");		
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("Precision length should not be empty");
		assertEquals("Error message not displayed",expected,actual);	
		
	}
	
	public void testEP09()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5555555");
		solo.enterText(1, "");
		solo.enterText(1, "12");		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("495.44620373"))
				{
			actual=true;
				}		
				assertEquals("Calculation is not working properly-EP09",expected,actual);
	}
	public void testEP10()
	{
		solo.enterText(0, "");
		solo.enterText(0, "12.5555555");
		solo.enterText(1, "");
		solo.enterText(1, "12");		
		solo.clickOnButton("Calculate");
		String text2=solo.getText(7).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("78.92063457"))
				{
			actual=true;
				}		
				assertEquals("Calculation is not working properly-EP10",expected,actual);
	}
	public void testTCF01()
	{		
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text1.equals("0") && text2.equals("0"))
				{
			actual=true;
				}		
		assertEquals("Calculate button not working",expected,actual);
	}
	public void testTCF02()
	{
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-TCF02",expected,actual);
		
	}
	public void testTCF03()
	{
		solo.enterText(0,"");
		solo.enterText(1,"");
		solo.enterText(1,"5");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-TCF03",expected,actual);
		
	}
	public void testTCF04()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.5");
		solo.enterText(1,"");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-TCF04",expected,actual);
		
	}
	public void testTCF05()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.5");
		solo.enterText(1,"");
		solo.enterText(1,"17");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-TCF05",expected,actual);
		
	}
	public void testTF06()
	{
		solo.enterText(0,"");
		solo.enterText(0,"12.5");
		solo.enterText(1,"");
		solo.enterText(1,"16");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Clear");
		String text1=solo.getEditText(0).getText().toString();
		String text2=solo.getEditText(1).getText().toString();
		String text3=solo.getText(6).getText().toString();
		String text4=solo.getText(7).getText().toString();
		boolean actual=false;
		if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
		{
		actual=true;
		}
		boolean expected=true;
		assertEquals("Clear button not working-TF06",expected,actual);
		
	}
	
	public void testTCF07()
	{
		solo.clickOnButton("Exit");
		boolean expected=true;
		boolean actual=false;
		if(solo.getActivityMonitor().getResult()==null)
		{
			actual=true;
		}
		assertEquals("Exit button not working-TF07",expected,actual);
	}
	public void testTCF08()
	{
		solo.enterText(0,"");
		solo.clickOnButton("Calculate");
		solo.clickOnButton("Exit");
		boolean expected=true;
		boolean actual=false;
		if(solo.getActivityMonitor().getResult()==null)
		{
			actual=true;
		}
		assertEquals("Exit button not working-TF08",expected,actual);		
	}
	public void testTCF09()
	{			
		Time now=new Time();
		now.setToNow();
		String text1=solo.getText(17).getText().toString();
		String[] separated=text1.split(":");
		String hrs1=String.valueOf(now.hour);
		String mins1=String.valueOf(now.minute);
		boolean actual=false;
		boolean expected=true;
		if(hrs1.equals(separated[0]) & mins1.equals(separated[1]))
		{
			 actual=true;
		}
		assertEquals("Current system time is not displayed-TCF09",expected,actual);
	}
	public void testTCF11andTCF13()
	{			
		Time now=new Time();
		now.setToNow();
		String text1=solo.getText(16).getText().toString();
		String[] separated=text1.split(":");
		String hrs=String.valueOf(now.hour);
		String mins=String.valueOf(now.minute);
		String hrs1=String.valueOf(Integer.parseInt(hrs)-2);
		if(Integer.parseInt(hrs1)<0)
		{
			hrs1 = String.valueOf(Integer.parseInt(hrs1) + 24);
		}
		boolean actual=false;
		boolean expected=true;
		if(hrs1.equals(separated[0]) & mins.equals(separated[1]))
		{
			 actual=true;
		}
		assertEquals("Current california time is not displayed-TCF11orTCF13",expected,actual);
	}
	public void testTCF10andTCF12()
	{	
	Time now=new Time();
		now.setToNow();
		String text1=solo.getText(15).getText().toString();
		String[] separated=text1.split(":");
		String hrs=String.valueOf(now.hour);
		String mins=String.valueOf(now.minute);
		String hrs1=String.valueOf(Integer.parseInt(hrs)+10);
		String mins1=String.valueOf(Integer.parseInt(mins)+30);
		if(Integer.parseInt(hrs1)>=24)
		{
			hrs1 = String.valueOf(Integer.parseInt(hrs1) - 24);
		}
		if(Integer.parseInt(mins1)>=60)
		{			
			mins1=String.valueOf((Integer.parseInt(mins1)-60));
			hrs1=String.valueOf(Integer.parseInt(hrs1)+1);
			if(Integer.parseInt(hrs1)>=24)
			{
				hrs1=String.valueOf(Integer.parseInt(hrs1)-24);				
			}
			
		}
		boolean actual=false;
		boolean expected=true;
		if(hrs1.equals(separated[0]) & mins1.equals(separated[1]))
		{
			 actual=true;
		}
		assertEquals("Current India time is not displayed-TCF10orTCF12",expected,actual);
	}
	

}
