package com.example.fw;

import java.util.ArrayList;
import java.util.List;



import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.tests.Folders;

public class FolderHelper extends HelpersBase {

	

	public FolderHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public String createFolder(String folder) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folder);
		new JButtonOperator(dialog, "OK").push();
		return waitMessageDialog("Warning", 3000);
	}
	
	public String deleteFolder(String folder) {
		manager.getMenuHelper().selectFolder(folder);
		manager.getMenuHelper().pushDeleteFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JButtonOperator(dialog, "Yes").push();
		return waitMessageDialog("Warning", 3000);
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children){
			list.add("" + child);
		}
		return new Folders(list);
	}
	
}
