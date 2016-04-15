package de.isc.af;

import org.junit.Test;

public class CSampleTest
{

  public CSampleTest() {}
  
  @Test
  public void testAspect()
  {
    new CSample().process();
  }
  
  @Test
  public void testParamAspect()
  {
    System.out.println(new CSample().withParam("mimimi"));
  }
  
  @Test
  public void testSampleAspect()
  {
    new CSample().someProcess();
  }

}
