package com.cmg.pl.dailytest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
//all case
@RunWith(Suite.class)
@SuiteClasses({ 
		PLDailyTestCase1Test.class,
		PLDailyTestCase2Test.class,
		PLDailyTestCase3Test.class,
		PLDailyTestCase4Test.class,
		PLDailyTestCase5Test.class,
		PLDailyTestCase6Test.class,
		PLDailyTestCase7Test.class,
		PLDailyTestCase8Test.class,
		PLDailyTestCase9Test.class,
		PLDailyTestCase10Test.class 
		})
public class AllTests {
}
