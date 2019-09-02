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
package rcp.demo.plugin.application;

import javax.annotation.PostConstruct;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import org.osgi.framework.ServiceReference;

import rcp.demo.plugin.calculator.ICalculatorService;
import rcp.demo.plugin.common.UIConstants;

/**
 * Small Dialog for using the calculator.
 */
@SuppressWarnings({
    "checkstyle:classfanoutcomplexity",
    "checkstyle:classdataabstractioncoupling"})
public class CalculatorPart
{
    /** Used Font height. */
    private static final int FONT_HEIGHT = 24;

    /**
     * Creating the calculator widgets.
     * 
     * @param parent owner/parent of the calculator.
     */
    @PostConstruct
    public void createControls(final Composite parent)
    {
        parent.setLayout(new GridLayout(1, true));

        final var txtInput = new Text(parent, 0);
        txtInput.setData(UIConstants.TEST_COMP_NAME.name(), UIConstants.CALCULATOR_INPUT.name());
        txtInput.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        final var btnCalculator = new Button(parent, 0);
        btnCalculator.setData(UIConstants.TEST_COMP_NAME.name(), UIConstants.CALCULATOR_RUN.name());
        btnCalculator.setLayoutData(new GridData(SWT.FILL, 0, true, true, 1, 1));
        btnCalculator.setText("Calculate");

        final var txtResult = new Text(parent, SWT.SHADOW_IN);
        txtResult.setData(UIConstants.TEST_COMP_NAME.name(), UIConstants.CALCULATOR_RESULT.name());
        txtResult.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        txtResult.setEditable(false);

        final var font = txtResult.getFont();
        final var fontData = font.getFontData();
        fontData[0].setHeight(FONT_HEIGHT);
        txtResult.setFont(new Font(parent.getDisplay(), fontData));

        btnCalculator.addSelectionListener(new SelectionListener()
        {

            @Override
            public void widgetSelected(SelectionEvent e)
            {
                final ServiceReference<ICalculatorService> reference
                    = Activator.getContext().getServiceReference(ICalculatorService.class);
                final ICalculatorService calculatorService
                    = Activator.getContext().getService(reference);

                final var value = Double.valueOf(txtInput.getText());
                final var squareResult = calculatorService.square(value);
                txtResult.setText("Square(" + value + ") = " + squareResult);

                Activator.getContext().ungetService(reference);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e)
            {
                // nothing to do.
            }
        });
    }
}
