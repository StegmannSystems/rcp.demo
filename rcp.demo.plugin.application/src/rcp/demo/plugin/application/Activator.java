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
package rcp.demo.plugin.application;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Activator for the application bundle.
 */
public class Activator implements BundleActivator
{
    /** Current bundle context. */
    private static BundleContext context;

    /**
     * Provide current bundle context.
     *
     * @return current bundle context.
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
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception
    {
        if (Activator.context != null)
        {
            setContext(null);
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
