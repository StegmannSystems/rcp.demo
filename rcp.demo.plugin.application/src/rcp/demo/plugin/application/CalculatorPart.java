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
