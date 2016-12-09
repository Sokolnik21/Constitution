package agh.cs.lab8.copy;

import java.util.ArrayList;
import java.util.List;

public class Constitution {
	String title;									//tytu� nie jest wymagany - nie trzeba go wypisywa�
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
		chapters.add(new Chapter(title, constitution));		//dodawanie zaczyna si� od indeksu 0
	}
	public void createArticle(String title){
		articles.add(new Article(title));
	}
	
	public void addChapter(String title, int n){
		chapters.get(n - 1).addChapter(title);		//dodawanie zaczyna si� od indeksu 0
	}
	public void addArticle(String title,int n){
		articles.get(n - 1).addArticle(title);	
	}
	
	public void echoChapter(int n){
		chapters.get(n - 1).echoChapter();			//w li�cie indeksowanie zaczyna si� od nr 0, wi�c chc�c si� dostac do danego elementu o okre�lonej liczbie nalezy zmniejszy� indeks o 1
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
