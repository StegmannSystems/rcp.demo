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
