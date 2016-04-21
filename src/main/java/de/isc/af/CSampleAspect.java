package de.isc.af;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * An sample aspect showing some features of AspectJ like hooking into a
 * 'interface' method.
 * 
 * @author Bernd Clemenz
 * @version 1.0.0
 */
@Aspect
public class CSampleAspect
{

  public CSampleAspect() {}
  
  //----------------------------------------------------------------------------
  @Around
  (
      "   execution(public java.lang.Object de.isc.af.ISample.process())"
    + "&& within(de.isc.af.ISample+)"
  )
  public Object generalMonitoring(final ProceedingJoinPoint oJp)
  throws Throwable
  {
    System.out.println("\n---->>> GENERAL MONITORING ASPECT");
    return oJp.proceed();
  }
  //----------------------------------------------------------------------------
  @Around
  (
      "   execution(public java.lang.Object de.isc.af.ISample.withParam(..))"
    + "&& within(de.isc.af.ISample+)"
  )
  public Object generalParamMonitoring(final ProceedingJoinPoint oJp)
  throws Throwable
  {
    System.out.println("\n---->>> GENERAL MONITORING ASPECT PARAMS");
    return "Result modfied: " + oJp.proceed(oJp.getArgs());
  }
  //----------------------------------------------------------------------------
  @Around
  (
      "   execution(public java.lang.Object de.isc.af.ASample.someProcess())"
    + "&& within(de.isc.af.ASample+)"
  )
  public Object generalSampleMonitoring(final ProceedingJoinPoint oJp)
  throws Throwable
  {
    System.out.println("\n---->>> GENERAL SAMPLE MONITORING ASPECT");
    return oJp.proceed();
  }
}
