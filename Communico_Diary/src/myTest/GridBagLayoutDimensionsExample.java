package myTest;

import java.awt.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class GridBagLayoutDimensionsExample {

    public static void main(String[] args) {
        // Create a container to hold the components
        Container container = new Container();
        
        // Set the container's layout to GridBagLayout
        container.setLayout(new GridBagLayout());
        
        // Get the GridBagLayout instance
        GridBagLayout gridBagLayout = (GridBagLayout) container.getLayout();
        
        // Get the layout dimensions using the GridBagLayoutInfo class
        GridBagLayoutInfo layoutInfo = gridBagLayout.getLayoutInfo(container);
        int[] columnWidths = layoutInfo.columnWidths;
        int[] rowHeights = layoutInfo.rowHeights;
        
        // Print the layout dimensions
        System.out.println("Column Widths: " + java.util.Arrays.toString(columnWidths));
        System.out.println("Row Heights: " + java.util.Arrays.toString(rowHeights));
    }
}
