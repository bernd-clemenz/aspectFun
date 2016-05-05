/*
 * This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.

   Dieses Programm ist Freie Software: Sie können es unter den Bedingungen
   der GNU General Public License, wie von der Free Software Foundation,
   Version 3 der Lizenz oder (nach Ihrer Wahl) jeder neueren
   veröffentlichten Version, weiterverbreiten und/oder modifizieren.

   Dieses Programm wird in der Hoffnung, dass es nützlich sein wird, aber
   OHNE JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
   Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
   Siehe die GNU General Public License für weitere Details.

   Sie sollten eine Kopie der GNU General Public License zusammen mit diesem
   Programm erhalten haben. Wenn nicht, siehe <http://www.gnu.org/licenses/>.
 */
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
  //----------------------------------------------------------------------------
  @Around("execution(* *(..)) && @annotation(de.isc.af.ProfileMe)")
  public Object profile(final ProceedingJoinPoint oJp)
  throws Throwable
  {
    System.out.println("\n---->>> GENERAL SAMPLE MONITORING ASPECT");
    
    long start = System.currentTimeMillis();
    Object result = oJp.proceed();
    long end = System.currentTimeMillis();
    
    System.out.println("Duration (ms): " + (end - start));
    
    return result;
  }
}
