package com.example.fw;

import javax.swing.JTree;

import org.netbeans.jemmy.operators.JMenuBarOperator;
import org.netbeans.jemmy.operators.JTreeOperator;
import org.netbeans.jemmy.operators.JTreeOperator.JTreeFinder;

public class MenuHelper extends HelpersBase {
			
	public MenuHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void pushCreateFolder() {
		
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|New folder...");
	}
	
	public void pushDeleteFolder() {
		
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|Delete");
	}

	public void selectFolder(String folder) {
		JTreeOperator tree = new JTreeOperator(mainFrame);
		tree.selectRow(tree.findRow(folder));
	}
	
}
