package com.example.tests;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestFolderCreation extends TestBase {

	
	@Test
	public void testFolderCreation(){
		String folder = "NewFolder";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));
	}
	
	@Test
	public void testVariousFoldersCreation(){
		String folder1 = "NewFolder1";
		String folder2 = "NewFolder2";
		Folders oldFolders = app.getFolderHelper().getFolders();
		
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2), is(nullValue()));
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders.withAdded(folder2)));
	}
	
	@Test
	public void testFoldersWithSameNamesCreation(){
		String folder1 = "NewFolder3";
		String folder2 = "NewFolder3";
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));
		assertThat(app.getFolderHelper().createFolder(folder2), containsString("Duplicated folder name"));
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders));
	}
	
	@Test
	public void testFolderDeletion(){
		String folder = "Persons";
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().deleteFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.without(folder)));
	}
	
}
