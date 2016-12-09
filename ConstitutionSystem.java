package agh.cs.lab8.copy;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ConstitutionSystem {

	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("No arguments");
			System.exit(0);
		}
		if (args.length > 4){
			System.out.println("The number of arguments can not be higher than 4");
			System.exit(0);
		}
		//tworzenie obiektu klasy Constitution			//ok
		Constitution constitution = new Constitution();	//ok
		
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(args[0]), Charset.forName("UTF-8"));
		} catch (IOException e) {
			System.out.println(args[0]+" does not exist, try \"konstytucja.txt\"");
			System.exit(0);
			//e.printStackTrace();
		}
		int chapter=1;
		int article=0;
		int constitutionEnd=1;
		int first=0;//
		for(String line: lines){
			if(!line.equals("©Kancelaria Sejmu") && !line.equals("2009-11-16")){
				if(constitutionEnd == 1 && !line.startsWith("Rozdzia³")){
					if(line.length() > 1) constitution.addConstitution(line);
				}
				else constitutionEnd = 0;
				if(constitutionEnd == 0){
					if(line.startsWith("Rozdzia³")){
						constitution.createChapter(line, constitution);
						if(chapter != 1){
							constitution.chapters.get(chapter - 2).setLastArticle(article);	//-1, bo indeksowanie od 0
						}
						constitution.chapters.get(chapter - 1).setFirstArticle(article + 1);	//-1, bo indeksowanie od 0
						chapter++;
					}
					else if(line.startsWith("Art")){
						constitution.createArticle(line);
						constitution.addArticle("\n",article+1);
						article++;
						first=1;//
					}
					else if(line.length()>1 && Character.isDigit(line.charAt(0)) && (line.charAt(1)=='.' || line.charAt(1)==')')){
						if(first==0) constitution.addArticle("\n", article);
						else first=0;
						constitution.addArticle(line,article);
					}
					else if(line.length() > 1 && line.charAt(0) >= 65 && line.charAt(0) <= 90 && line.charAt(1) >= 65 && line.charAt(1) <= 90){
						constitution.chapters.get(chapter - 2).addSubChapter(line,article+1);
					}
					else{
						first=0;
						constitution.addArticle(line,article);
					}
				}
			}
		}
		constitution.chapters.get(chapter - 2).setLastArticle(article);
		//the state between 1 and 4 arguments is needed
		if (args[1].equals("chapter")){
			if(Integer.parseInt(args[2]) < 1 || Integer.parseInt(args[2]) > 13){
				System.out.println(args[2]+" is wrong number, try number between 1 and 13");
				System.exit(0);
			}
			constitution.echoChapter(Integer.parseInt(args[2]));
		}
		else if (args[1].equals("article")){
			if(Integer.parseInt(args[2]) < 1 || Integer.parseInt(args[2]) > 243){
				System.out.println(args[2]+" is wrong number, try number between 1 and 243");
				System.exit(0);
			}
			constitution.echoArticle(Integer.parseInt(args[2]));
		}
		else if (args[1].equals("articles")){
			if(args.length < 4){
				System.out.println("Set final article");
				System.exit(0);
			}
			if(Integer.parseInt(args[2]) < 1 || Integer.parseInt(args[2]) > 243){
				System.out.println(args[2]+" is wrong number, try number between 1 and 243");
				System.exit(0);
			}
			if(Integer.parseInt(args[3]) < 1 || Integer.parseInt(args[3]) > 243){
				System.out.println(args[3]+" is too wrong number, try number between 1 and 243");
				System.exit(0);
			}
			constitution.echoArticles(Integer.parseInt(args[2]),Integer.parseInt(args[3]));
		}
		else System.out.println("The first argument can be \"chapter\", \"article\" or \"articles\"");
	}
}
