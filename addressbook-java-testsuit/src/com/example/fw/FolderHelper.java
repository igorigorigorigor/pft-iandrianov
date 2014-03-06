package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

import com.example.tests.Folders;

public class FolderHelper {

	private ApplicationManager manager;

	public FolderHelper(ApplicationManager applicationManager) {
		this.manager = applicationManager;
	}


	public void createFolder(String folder) {
		// TODO Auto-generated method stub
		
	}

	public Folders getFolders() {
		List<String> list = new ArrayList<String>();
		JFrameOperator mainFrame = manager.getApplication();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children){
			list.add("" + child);
		}
		return new Folders(list);
	}
	
}
