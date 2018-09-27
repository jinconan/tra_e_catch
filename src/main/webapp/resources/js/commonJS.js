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
 *  업로드 체크 
 */
function fileCheck(file){
    // 사이즈체크
    var maxSize  = 20 * 1024 * 1024    //30MB
    var fileSize = 0;

	// 브라우저 확인
	var browser=navigator.appName;
	
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
        alert("첨부파일 사이즈는 5MB 이내로 등록 가능합니다.    ");
        return;
    }

    document.forms[0].submit();
}