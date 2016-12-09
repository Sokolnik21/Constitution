package agh.cs.lab8.copy;

public class SubChapter {
	private String title;			//tutaj jest tre�� rozdzia�u(KAPITALIKI)
	private int nextArticle;
	//powrzuca� tu te wszystkie dodawania do rozdzia��w (tj. tytu�y, nr pocz�tkowe i ko�cowe)
	
	public SubChapter(String title, int next){
		this.title = title;
		this.nextArticle = next;
	}
	public void setNextArticle(int number){
		this.nextArticle = number;
	}
	public int getNextArticle(){
		return this.nextArticle;
	}
	public void echoSubChapter(){
		System.out.println(title);
	}
}
