package agh.cs.lab8.copy;

public class Article {
	private String title;
	private int isSpace;	//zamieniæ na boola
	
	public Article(String title){
		this.title = title;
		this.isSpace = 0;	//to te¿
	}
	public void echoArticle(){
		System.out.println(title);
	}
	public void addArticle(String title){
		if(title.charAt(title.length()-1)=='-'){
			title = title.substring(0,title.length()-1);
			isSpace = 1;
		}
		if(isSpace == 0){
			title = title + ' ';
		}
		else isSpace = 0;
		this.title=this.title+title;
	}
}
