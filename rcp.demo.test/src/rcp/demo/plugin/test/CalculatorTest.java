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
package rcp.demo.plugin.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.osgi.framework.ServiceReference;

import rcp.demo.plugin.calculator.ICalculatorService;
import rcp.demo.plugin.categories.ISquareBasedTests;
import rcp.demo.plugin.categories.ISquareRootBasedTests;

/**
 * Testing of the Calculator service.
 */
@SuppressWarnings("checkstyle:magicnumber")
public class CalculatorTest
{

    /** Service reference as interface to get the concrete shared service. */
    private ServiceReference<ICalculatorService> m_reference;

    /** Service instance. */
    private ICalculatorService m_calculatorService;

    @Before
    public void setUp()
    {
        this.m_reference = Activator.getContext().getServiceReference(ICalculatorService.class);
        this.m_calculatorService = Activator.getContext().getService(this.m_reference);
    }

    @After
    public void tearDown()
    {
        Activator.getContext().ungetService(this.m_reference);
    }

    /**
     * Testing square function.
     */
    @Test
    @Category(ISquareBasedTests.class)
    public void testSquare()
    {
        assertThat(this.m_calculatorService.square(2.5), equalTo(2.5 * 2.5));
    }

    /**
     * Testing square root function.
     */
    @Test
    @Category(ISquareRootBasedTests.class)
    public void testSquareRoot()
    {
        assertThat(this.m_calculatorService.sqrt(1.234), equalTo(Math.sqrt(1.234)));
    }
}
