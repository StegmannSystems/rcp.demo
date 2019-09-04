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
package rcp.demo.plugin.calculator.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import rcp.demo.plugin.categories.ISquareBasedTests;
import rcp.demo.plugin.categories.ISquareRootBasedTests;

/**
 * Testing calculator service implementation directly.
 */
@SuppressWarnings("checkstyle:magicnumber")
public class CalculatorImplTest
{
    /**
     * Testing calculator service for square root function.
     */
    @Category(ISquareRootBasedTests.class)
    @Test
    public void testSquareRoot()
    {
        final var calculatorService = new CalculatorServiceImpl();
        assertThat(calculatorService.sqrt(2.0), equalTo(Math.sqrt(2.0)));
    }

    /**
     * Testing calculator service for square function.
     */
    @Category(ISquareBasedTests.class)
    @Test
    public void testSquare()
    {
        final var calculatorService = new CalculatorServiceImpl();
        assertThat(calculatorService.square(2.0), equalTo(4.0));
        assertThat(calculatorService.square(2.5), equalTo(6.25));
    }
}
