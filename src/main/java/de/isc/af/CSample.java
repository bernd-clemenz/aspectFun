package de.isc.af;

public class CSample extends ASample 
                     implements ISample
{
  public CSample() {}

  public Object process()
  {
    System.out.println("Processing ...");
    return "This is a test";
  }

  @Override
  public Object someProcess()
  {
    System.out.println("Processing SAMPLE ...");
    return "Some other test";
  }

  @Override
  public Object withParam(final String x)
  {
    // TODO Auto-generated method stub
    return "Param test";
  }

}
