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
