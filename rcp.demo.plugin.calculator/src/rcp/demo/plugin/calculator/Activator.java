/*
 * MIT License
 *
 * Copyright (c) 2019 StegmannSystems
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package rcp.demo.plugin.calculator;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import rcp.demo.plugin.calculator.impl.CalculatorServiceImpl;

/**
 * Activator for calculator bundle.
 */
public class Activator implements BundleActivator
{
    /** Remember the bundler context. */
    private static BundleContext context;
    /** Remember the service. */
    @SuppressWarnings("unused")
    private ServiceRegistration<ICalculatorService> m_calculatorServiceRegistration;

    /**
     * Provide current bundle context.
     *
     * @return current Bundle context.
     */
    static synchronized BundleContext getContext()
    {
        return context;
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception
    {
        if (Activator.context == null)
        {
            setContext(bundleContext);
            this.m_calculatorServiceRegistration = Activator.context.registerService(
                    ICalculatorService.class, new CalculatorServiceImpl(),
                    new Hashtable<String, String>());
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception
    {
        if (Activator.context != null)
        {
            setContext(null);
            this.m_calculatorServiceRegistration.unregister();
        }
    }

    /**
     * Adjusts the bundle context.
     *
     * @param bundleContext - Der Bundle-Context
     */
    private static synchronized void setContext(final BundleContext bundleContext)
    {
        context = bundleContext;
    }
}
