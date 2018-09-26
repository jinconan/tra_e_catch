/**
 * 
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