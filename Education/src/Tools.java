import java.util.Random;

public class Tools {
	private char[] codeSequence={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
															'0','1','2','3','4','5','6','7','8','9'};
	public String getCode(){
		Random random=new Random();
		StringBuilder sb=new StringBuilder();
		int count=0;
		while(true){
			int code=random.nextInt(36);
			char c=codeSequence[code];
			if(sb.indexOf(c+"")==-1){
				sb.append(c+"");
				count++;
				if(count==4)break;
			}
		}
		return sb.toString();
	}
}
