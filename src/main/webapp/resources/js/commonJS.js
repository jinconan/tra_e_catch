/**
 * Date타입의 변수를 XXXX-YY-MM의 문자열로 변환.
 */
function dateToString(pdate) {
	try {
		var year = pdate.getYear()+1900+"";
		var month = pdate.getMonth()+1+"";
		var date = pdate.getDate()+"";
		
		year = "0000".slice(0,4-year.length)+year;
		month = "00".slice(0,2-month.length)+month;
		date = "00".slice(0,2-date.length)+date;
		
		return year+"-"+month+"-"+date;
	} catch(error){
		console.log(error.message);
		return "0000-00-00"
	}
	
}

/**
 *  업로드 체크. 최대 20MB
 */
function fileCheck(form,file){
    // 사이즈체크
    var maxSize  = 20 * 1024 * 1024    //20MB
    var fileSize = 0;

	// 브라우저 확인
	var browser=navigator.appName;
	
	//파일 첨부를 안한 경우에는 바로 폼 전송
	if(file.value=="") {
		form.submit();
		return;
	}
	else {
		// 익스플로러일 경우
		if (browser=="Microsoft Internet Explorer")	{
			var oas = new ActiveXObject("Scripting.FileSystemObject");
			fileSize = oas.getFile( file.value ).size;
		}
		// 익스플로러가 아닐경우
		else{
			fileSize = file.files[0].size;
		}

	    if(fileSize > maxSize){
	        alert("첨부파일 사이즈는 20MB 이내로 등록 가능합니다.    ");
	        return;
	    }

	    form.submit();
	    return;
	}
	
}