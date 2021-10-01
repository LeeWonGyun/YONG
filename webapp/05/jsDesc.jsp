<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/jsDesc.jsp</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-3.6.0.min.js"></script>
</head>
<body>
	<form name="testForm" action="<%=request.getContextPath() %>/marshallingTest.do" method="post">
		<input type="text" name="p1" placeholder="p1" />
		<input type="text" name="p1" placeholder="p1" />
		<input type="number" name="p2" placeholder="p2" />
		<input type="number" name="p2" placeholder="p2" />
		<select name="p3">
			<option>o1</option>
			<option>o2</option>
		</select>
		<input type="submit" value="전송" />
	</form>
	
	<script type="text/javascript">
		let nameSet = new Set(); //중복된 
		
		$(document.testForm).on("submit", function(event){
			event.preventDefault();
			let url = this.action;
			let form = this;
			let method = this.method;
// 			let data = $(this).serialize();
// 			let data = {
// 				p1 : ['text', 'text'],
// 				p2 : [232, 232],
// 				p3 : 'o2'
// 			}

			let data = {};
			
			for(let name of nameSet){
				let children = $(form).find('[name="'+name+'"]')
				let value = null;
				if(children.length > 1){
					value = [];
					children.each(function(index, child){
						if(child.type=='number'){
							value.push(parseInt(	$(this).val())	);
						} else {
							value.push(	$(this).val() ); //이렇게만 할 경우, 경우에 따라서 숫자로 넣어야할 때에도 문자열로 들어가진다.
						}
					});
				} else {
					value = $(children).val();
				}
				
				data[name] = value; 
			}
			
			console.log(data);
			let jsonData = JSON.stringify(data); //마샬링작업
			$.ajax({ 
				url : url,
				data : jsonData,
				method : "post",
				contentType : "application/json;charset=UTF-8" //보내는 데이터 타입을 mime형식으로 contentType으로 지정한다.
// 				dataType : "", //받는 데이터 타입 이라는 뜻.
// 				success : function(resp) {

// 				},
// 				error : function(xhr, errorResp, error) { //요청 상태코드가 200이 아닐 시. xml http resp
// 					console.log(xhr);
// 					console.log(errorResp);
// 					console.log(error);
// 				}
			});
// 			let data = $(this).serialize();
// 			console.log(data);
//			p1=text&p1=text&p2=232&p2=232&p3=o2
// 			let data = {
// 				p1 : ['text', 'text'],
// 				p2 : [232, 232],
// 				p3 : 'o2'
// 			}
// 			let jsonData = JSON.stringify(data); //json문자열로 만든다.
// 			console.log(jsonData);
//			p1=text&p2=3&p3=o1
// 			let data = {
// 				p1 : "text",
// 				p2 : 3,
// 				p3 : "o1"
// 			}
			return false;
		}).find(":input[name]").each(function(index, input){//.find를 사용해 form 안에있는 name이 드가있는 input태그를 찾는데 each로 하나씩 function 으로 찾는다.
			nameSet.add(input.name);
			$(input).prop("required", true);
		}); 
		
		
		
		
		
// 		let obj = {
// 			prop1 : 23,
// 			prop2 : "text"
// 		};
// 		// dot notation
// 		obj.prop3 = "text3";
// 		//연상배열(연관배열) 구조
// 		obj['prop4'] = "text4";
// 		//script가 동적파일을 지원하기 때문에 값을 넣는 방법이 다양하다.
// 		console.log(obj);
		
// 		for(let name in obj){
// 			let propValue = obj[name];
// 			console.log(name + ":" + propValue);
// 		}
		
// 		let array = ['a'];
// 		array.push('b');
// 		console.log(array.length);
// 		for(let index in array){
// 			console.log(index); //in 연산자 사용시 배열의 인덱스 번호가 출력된다.
// 		}
// 		for(let element of array){ //of를 사용하면 무조건 컬렉션을 받아와야한다. obj를 사용하면  is not iterable이라는 에러문구가 뜬다.
// 			console.log(element); //of 연산자 사용시 a, b 값이 출력
// 		}
		
// 		//set은 순서없는 집합 객체이면서 중복을 허용하지 않는 집합 객체
		
// 		let testSet = new Set();
// 		let testMap = new Map();
// 		testSet.add('a');
// 		testMap.set('key1', 'value1');
// 		for(let tmp of testSet){
// 			console.log(tmp);
// 		}
// 		for(let tmp of testMap){
// 			console.log(tmp);
// 		}
		
		
		
	</script>
</body>
</html>