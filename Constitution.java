package agh.cs.lab8.copy;

import java.util.ArrayList;
import java.util.List;

public class Constitution {
	String title;									//tytu³ nie jest wymagany - nie trzeba go wypisywaæ
	public List<Chapter> chapters = new ArrayList<>();
	public List<Article> articles = new ArrayList<>();
	private int isSpace;
	
	public Constitution(){
		this.isSpace = 0;
	}
	public void addConstitution(String title){
		if(title.charAt(title.length()-1)=='-'){
			title = title.substring(0,title.length()-1);
			isSpace = 1;
		}
		if(isSpace == 0){
			title = title + ' ';
		}
		else isSpace = 0;
		if(title.charAt(title.length()-1)=='.'){
			title = title + "\n";
		}
		this.title=this.title+title;
	}
	
	public void createChapter(String title, Constitution constitution){
		chapters.add(new Chapter(title, constitution));		//dodawanie zaczyna siê od indeksu 0
	}
	public void createArticle(String title){
		articles.add(new Article(title));
	}
	
	public void addChapter(String title, int n){
		chapters.get(n - 1).addChapter(title);		//dodawanie zaczyna siê od indeksu 0
	}
	public void addArticle(String title,int n){
		articles.get(n - 1).addArticle(title);	
	}
	
	public void echoChapter(int n){
		chapters.get(n - 1).echoChapter();			//w liœcie indeksowanie zaczyna siê od nr 0, wiêc chc¹c siê dostac do danego elementu o okreœlonej liczbie nalezy zmniejszyæ indeks o 1
	}
	public void echoArticle(int n){
		articles.get(n - 1).echoArticle();				//tu jest to samo
	}
	public void echoArticles(int n1, int n2){
		for(int i=n1;i<=n2;i++){
			articles.get(i - 1).echoArticle();			//to samo
		}
	}
}
