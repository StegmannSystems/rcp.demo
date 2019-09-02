/*
 * Copyright (c) Stegmann Systems (www.stegmannsystems.com),
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Stegmann Systems ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Stegmann Systems.
 *
 * THIS SOFTWARE IS PROVIDED BY STEGMANN SYSTEMS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL STEGMANN SYSTEMS OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * You acknowledge that this software is not designed, licensed or
 * intended for use in the design, construction, operation or
 * maintenance of any nuclear facility.
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
