package agh.cs.lab8.copy;

public class SubChapter {
	private String title;			//tutaj jest treœæ rozdzia³u(KAPITALIKI)
	private int nextArticle;
	//powrzucaæ tu te wszystkie dodawania do rozdzia³ów (tj. tytu³y, nr pocz¹tkowe i koñcowe)
	
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
