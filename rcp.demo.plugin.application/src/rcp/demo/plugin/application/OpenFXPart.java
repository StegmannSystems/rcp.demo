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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

import javafx.embed.swt.FXCanvas;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;

/**
 * Part using Java FX.
 */
public class OpenFXPart
{
    /**
     * Creating a simple FX browser.
     * 
     * @param parent owner of the FX browser.
     */
    @PostConstruct
    public void createControls(final Composite parent)
    {
        final FXCanvas fxCanvas = new FXCanvas(parent, SWT.NONE)
        {

            @Override
            public Point computeSize(final int wHint, final int hHint, final boolean changed)
            {
                getScene().getWindow().sizeToScene();
                final int width = (int) getScene().getWidth();
                final int height = (int) getScene().getHeight();
                return new Point(width, height);
            }
        };

        final WebView webview = new WebView();
        webview.getEngine().load("http://www.google.de");
        final VBox vBox = new VBox(webview);
        final Scene scene = new Scene(vBox, 300, 300);
        fxCanvas.setScene(scene);
    }
}
