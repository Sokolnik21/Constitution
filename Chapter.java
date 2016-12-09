package agh.cs.lab8.copy;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
	private String title;			//tutaj jest tre�� rozdzia�u(KAPITALIKI)
	private int firstArticle;
	private int lastArticle;
	private List<SubChapter> subchapters = new ArrayList<>();
	public Constitution constitution;
	
	public Chapter(String title, Constitution constitution){
		this.title = title;
		this.constitution = constitution;
	}
	public void setFirstArticle(int number){
		this.firstArticle = number;
	}
	public void setLastArticle(int number){
		this.lastArticle = number;
	}
	public int getFirstArticle(int number){
		return this.firstArticle;
	}
	public int getLastArticle(int number){
		return this.lastArticle;
	}
	public void addChapter(String title){
		this.title=this.title+title;		//dodawanie zaczyna si� od indeksu 0
	}
	public void addSubChapter(String title, int n){
		subchapters.add(new SubChapter(title, n));
	}
	
	public void echoChapter(){
		System.out.println(title);
		for(int i = firstArticle; i <=lastArticle; i++){
			for(SubChapter sub : subchapters){
				if(sub.getNextArticle() == i) sub.echoSubChapter();
			}
			constitution.echoArticle(i);		//doda� do struktury constitution
		}
	}
}
