package kr.or.ddit.enumpkg;
	
public enum BrowserType {
	//enum도 객체의 한 부분. class를 빼고 enum을 넣어도 오류가 안 뜬다.
	//enum은 자기타입으로 상수화 시킨다.
	EDG("엣지"), CHROME("크롬"), SAFARI("사파리"), OTHER("기타"); //=> 원래는 밑으로 해야하지만 클래스를 enum으로 바뀌었기때문에 자동으로 생성되어 앞처럼만 사용해도 된다.
	//LinkedHashMap 구조처럼 entry를 갖고있음.
//	public static final BrowserType CHROME = new BrowserType(); //생성자로 만듦. 앞에 final을 붙임으로 상수화. 값은 바뀌지 않는다.
//	public static final BrowserType EDG = new BrowserType(); //생성자로 만듦. 앞에 final을 붙임으로 상수화. 값은 바뀌지 않는다.
	private BrowserType(String name) {
		this.browserName = name;
	}
	private String browserName; //위에 CHROME과 EDG는 browserName이라는 프로퍼티를 갖고있는 것
	
	public String getBrowserName() {
		return browserName;
	} //겟을 통해서 객체에대해 꺼내갈 수 있는 구조가 만들어짐
	
	public static BrowserType findBrowser(String agent) {
		//agent에서 브라우저타입을 못찾았을때 사용하는 것.
		agent = agent==null?"" : agent.toUpperCase();
		BrowserType retValue = OTHER;
		for(BrowserType tmp : values()) {
			if(agent.contains(tmp.name())) {
				retValue = tmp;
				break;
			}
		}
		return retValue;
	}
	
	public static String findBrowserName(String agent) {
		//String으로 리턴값을 받는다.
		return findBrowser(agent).getBrowserName();
	}
}
