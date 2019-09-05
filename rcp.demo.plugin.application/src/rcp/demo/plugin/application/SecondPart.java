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

import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

/**
 * Demo on what you basically can do with a pure tree widget.
 * (for the purpose of a demo a few style issues can be ignored)
 */
@SuppressWarnings({
    "checkstyle:classdataabstractioncoupling",
    "checkstyle:magicnumber", "checkstyle:multiplestringliterals"})
public class SecondPart
{

    /**
     * Create the controls for given parent.
     * 
     * @param parent where to place (layout) the controls.
     * @param part   not used here.
     */
    @PostConstruct
    public void postConstruct(final Composite parent, final MPart part)
    {
        parent.setLayout(new GridLayout());

        final Device device = Display.getCurrent();

        final Tree tree = new Tree(parent,
                SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
        tree.setHeaderVisible(true);
        tree.setLinesVisible(false);
        tree.setFont(new Font(device, "Time New Roman", 16, SWT.NORMAL));

        // adjusting layout in parent composite
        final GridData layoutData = new GridData(GridData.FILL_BOTH);
        tree.setLayoutData(layoutData);

        TreeColumn column = new TreeColumn(tree, SWT.LEFT);
        column.setText("The Title");
        column.setMoveable(false);
        column.setToolTipText("Title data");

        column = new TreeColumn(tree, SWT.LEFT);
        column.setText("The Id");
        column.setMoveable(false);
        column.setToolTipText("Id Data");

        column = new TreeColumn(tree, SWT.LEFT);
        column.setText("");
        column.setMoveable(false);
        column.setToolTipText("State");

        for (int a = 1; a <= 10; ++a)
        {
            final TreeItem item = new TreeItem(tree, SWT.NONE, 0);
            item.setText(new String[] {"Item with a very very long text", "" + a});
            item.setFont(new Font(device, "Time New Roman", 14, SWT.BOLD));

            for (int b = 1; b <= 10; ++b)
            {
                final TreeItem subItem = new TreeItem(item, SWT.NONE);
                subItem.setText(new String[] {"Sub Item", "" + a + "." + b});
                if (b % 2 == 0)
                {
                    subItem.setBackground(new Color(device, 220, 220, 220));
                }
            }
        }

        // resize columns
        for (int cix = 0; cix < tree.getColumnCount(); ++cix)
        {
            tree.getColumn(cix).pack();
        }
    }
}
