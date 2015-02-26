import com.example.circlearea.AreaCircle;
import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;
import android.text.format.Time;


public class StructuralTesting extends
		ActivityInstrumentationTestCase2<AreaCircle> {
private Solo solo;
	
	@SuppressWarnings("deprecation")
	public StructuralTesting()
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
	public void testModel1()
	{	
		solo.enterText(0,"");
		solo.enterText(0,"12.5");
		solo.enterText(1,"");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text1=solo.getText(7).getText().toString();
		String text2=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text2.equals("484.375") && text1.equals("77.5"))
				{
			
	          actual=true;
				}	
		assertEquals("Calculation is not working properly-Model1",expected,actual);
	}
	public void testModel2()
	{
		solo.enterText(0, "");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("radius should not be empty");		
		assertEquals("Error message not displayed-Model2",expected,actual);	
	
	}
	public void testModel3()
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
				assertEquals("No: of digits displayed in area is not exactly equal to 8 after decimal point-Model3",expected,actual);
	}
	public void testModel4()
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
				assertEquals("No: of digits displayed in circumference is not exactly equal to 8 after decimal point-Model4",expected,actual);
				
	}
	public void testModel5()
	{   
		solo.enterText(0, "");
	    solo.enterText(0,"12.5");
		solo.enterText(1,"");		
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("Precision length should not be empty");
		assertEquals("Error message not displayed-Model5",expected,actual);	
		
	}
	public void testModel6()
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
				assertEquals("Calculation is not working properly-Model6",expected,actual);
	}
	public void testModel7()
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
				assertEquals("Calculation is not working properly-Model7",expected,actual);
	}
	public void testModel8()
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
		assertEquals("Calculate button not working-Model8",expected,actual);
	}
	public void testModel9()
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
		assertEquals("Clear button not working-Model9",expected,actual);
		
	}
	public void testModel10()
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
		assertEquals("Clear button not working-Model11",expected,actual);		
	}
	public void testModel12()
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
		assertEquals("Clear button not working-Model12",expected,actual);
		
	}
	
	public void testModel13()
	{
		solo.clickOnButton("Exit");
		boolean expected=true;
		boolean actual=false;
		if(solo.getActivityMonitor().getResult()==null)
		{
			actual=true;
		}
		assertEquals("Exit button not working-Model13",expected,actual);
	}
	public void testModel14()
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
		assertEquals("Exit button not working-Model14",expected,actual);		
	}
	public void testModel15()
	{
		solo.enterText(0, "");
		solo.enterText(0,"12.5");
		solo.enterText(1, "");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text0=solo.getText(7).getText().toString();
		String text00=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text00.equals("484.375") && text0.equals("77.5"))
		{
			solo.clickOnButton("Clear");
			String text1=solo.getEditText(0).getText().toString();
			String text2=solo.getEditText(1).getText().toString();
			String text3=solo.getText(6).getText().toString();
			String text4=solo.getText(7).getText().toString();
			if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
			{
			actual=true;
			}
		}
		assertEquals("Model15-Flow is not working properly",expected,actual);
		
	}
	public void testModel16()
	{
		solo.enterText(0, "");
		solo.enterText(0,"12.5");
		solo.enterText(1, "");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text0=solo.getText(7).getText().toString();
		String text00=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text00.equals("484.375") && text0.equals("77.5"))
		{
			solo.clickOnButton("Exit");	
			if(solo.getActivityMonitor().getResult()==null)
			{
				actual=true;
			}
		}
		assertEquals("Model16-Flow is not working properly",expected,actual);
		
	}
	public void testModel17()
	{
		solo.enterText(0, "");
		solo.enterText(0,"12.5");
		solo.enterText(1, "");
		solo.enterText(1,"1");
		solo.clickOnButton("Calculate");
		String text0=solo.getText(7).getText().toString();
		String text00=solo.getText(6).getText().toString();
		boolean expected=true;
		boolean actual=false;
		if(text00.equals("484.375") && text0.equals("77.5"))
		{
			solo.clickOnButton("Clear");
			String text1=solo.getEditText(0).getText().toString();
			String text2=solo.getEditText(1).getText().toString();
			String text3=solo.getText(6).getText().toString();
			String text4=solo.getText(7).getText().toString();
			if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
			{
				solo.clickOnButton("Exit");	
				if(solo.getActivityMonitor().getResult()==null)
				{
					actual=true;
				}
			}
			
		}
		assertEquals("Model17-Flow is not working properly",expected,actual);
		
	}
	public void testModel18()
	{
		solo.enterText(0, "");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("radius should not be empty");
		if(actual==true)
		{
			actual=false;
			solo.clickOnButton("Clear");
			String text1=solo.getEditText(0).getText().toString();
			String text2=solo.getEditText(1).getText().toString();
			String text3=solo.getText(6).getText().toString();
			String text4=solo.getText(7).getText().toString();
			if(text3.equals("0.00000000") && text4.equals("0.00000000") && text1.equals("0.0") && text2.equals("0"))
			{
				solo.clickOnButton("Exit");	
				if(solo.getActivityMonitor().getResult()==null)
				{
					actual=true;
				}
		}
			
			
		}
		assertEquals("Model18-Flow is not working properly",expected,actual);
		
	}
	public void testModel19()
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
		assertEquals("Current system time is not displayed-Model19",expected,actual);
	}

	public void testModel20()
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
		assertEquals("Current california time is not displayed-Model20",expected,actual);
	}
	public void testModel21()
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
		assertEquals("Current India time is not displayed-Model21",expected,actual);
	}
	
	public void testFunc1()
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
			assertEquals("Calculation is not working properly-Func1",expected,actual);
	
				}		
	}
	
	public void testFunc2()
	{
		solo.enterText(0, "");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("radius should not be empty");		
		assertEquals("Error message not displayed-Func2",expected,actual);	
	
	}
	
	public void testFunc3()
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
			assertEquals("Calculation is not working properly-Func3",expected,actual);
				}		
	}
	
	public void testFunc4()
	{
		solo.enterText(0,"");
		solo.enterText(0,"-10");
		solo.enterText(1,"");
		solo.enterText(1,"-10");
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("Values cannot be negative");
		assertEquals("Negative values doesnt get accepted in actual application(robotium error)-Func4",expected,actual);
	}
	public void testFunc5()
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
			assertEquals("Calculation is not working properly-Func5",expected,actual);
				}		
	}
	public void testFunc6()
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
		assertEquals("Calculation is not working properly-Func6",expected,actual);
	}
	public void testFunc7()
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
		assertEquals("Calculation is not working properly-Func7",expected,actual);
	}
	public void testFunc8()
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
	assertEquals("Calculation is not working properly-Func8",expected,actual);
	}
	public void testFunc9()
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
				assertEquals("Calculation is not working properly-Func9",expected,actual);
	}
	public void testFunc10()
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
				assertEquals("No: of digits displayed in area is not exactly equal to 8 after decimal point-Func10",expected,actual);
	}
	public void testFunc11()
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
				assertEquals("No: of digits displayed in circumference is not exactly equal to 8 after decimal point-Func11",expected,actual);
				
	}
	public void testFunc12()
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
				assertEquals("Calculation is not working properly-Func12",expected,actual);
	}
	
	public void testFunc13()
	{   
		solo.enterText(0, "");
	    solo.enterText(0,"12.5");
		solo.enterText(1,"");		
		solo.clickOnButton("Calculate");
		boolean expected=true;
		boolean actual=solo.searchText("Precision length should not be empty");
		assertEquals("Error message not displayed-Func13",expected,actual);	
		
	}
	
	public void testFunc14()
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
				assertEquals("Calculation is not working properly-Func14",expected,actual);
	}
	public void testFunc15()
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
				assertEquals("Calculation is not working properly-Func15",expected,actual);
	}
	public void testFunc16()
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
		assertEquals("Calculate button not working-Func16",expected,actual);
	}
	public void testFunc17()
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
		assertEquals("Clear button not working-Func17",expected,actual);
		
	}
	public void testFunc18()
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
		assertEquals("Clear button not working-Func18",expected,actual);
		
	}
	public void testFunc19()
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
		assertEquals("Clear button not working-Func19",expected,actual);
		
	}
	public void testFunc20()
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
		assertEquals("Clear button not working-Func20",expected,actual);
		
	}
	public void testFunc21()
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
		assertEquals("Clear button not working-Func21",expected,actual);
		
	}
	
	public void testFunc22()
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
	public void testFunc23()
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
	public void testFunc24()
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
	public void testFunc25()
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
	public void testFunc26()
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
