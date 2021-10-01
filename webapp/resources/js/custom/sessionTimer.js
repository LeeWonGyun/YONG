/**
 * 
 */
let unit = 100; //함수간 시간 맞추기 위한 변수 -> 전역변수 설정
$.timeFormat=function(timer){
	let minute = Math.trunc(timer / 60); //trunc로 소숫점 밑단위 절삭
	let second = timer % 60;
	return minute + ":" + second;
} //브라우저에 시간을 나타내는 값

var timerJob = null;
$.fn.sessionTimer=function(obj){
	const TIMEOUT = obj.timeout;
	let msgArea = obj.msgArea;
	let timer = TIMEOUT;
	this.html($.timeFormat(TIMEOUT));
	let timerTag = this;
	if(!msgArea){
		//generate
	}
	msgArea.hide().on("click", ".controlBtn",function(){
		if(this.id=='yesBtn'){
//			sessionTimer.html($.timeFormat(TIMEOUT));
			timer = TIMEOUT;
			$.ajax({
				method:"head"
			});
		}
		msgArea.hide();
	});;
	
	timerJob = setInterval(() => {
		if(--timer > 0){
			timerTag.html($.timeFormat(timer));
		}else{
			clearInterval(timerJob);
			location.reload();
		}
	}, 1 * unit);
	
	setTimeout(function(){
		msgArea.show();
	}, (TIMEOUT-60) * unit);
	
	return this;
}