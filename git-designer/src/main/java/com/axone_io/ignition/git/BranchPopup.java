package com.axone_io.ignition.git;

import com.axone_io.ignition.git.components.SelectAllHeader;
import com.inductiveautomation.ignition.designer.gui.CommonUI;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BranchPopup extends JFrame{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private JPanel panel1;
    private JList branchList;
    private JButton closeBtn;

    public BranchPopup(Object[][] data, Component parent) {
        try {
            InputStream commitIconStream = getClass().getResourceAsStream("/com/axone_io/ignition/git/icons/ic_commit.svg");
            ImageIcon commitIcon = new ImageIcon(ImageIO.read(commitIconStream));
            setIconImage(commitIcon.getImage());
        } catch (IOException e) {
            logger.trace(e.toString(), e);
        }
        setContentPane(panel1);
        setTitle("Branches");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);

//        branchList.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
//        branchList.getTableHeader().setReorderingAllowed(false);

//        setData(data);

        closeBtn.addActionListener(e -> this.dispose());

        pack();
        CommonUI.centerComponent(this, parent);
        toFront();
    }
}